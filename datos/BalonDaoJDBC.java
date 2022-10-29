/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import domain.BalonDTO;
import domain.MundialDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class BalonDaoJDBC {
    private Connection conexionTransaccional;

    
    //constantes para la manipulacion de informacion
    private static final String SQL_SELECT = "SELECT Id, Balon, Pais, Año FROM balones";
    private static final String SQL_INSERT = "INSERT INTO balones (Id, Balon, Pais, Año) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE balones SET Balon=?, Pais=?, Año=? WHERE Id = ?";
    private static final String SQL_DELETE = "DELETE FROM balones WHERE Id=?";
    
    public BalonDaoJDBC(){
        
    }
    
      public BalonDaoJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    

      }
      public List<BalonDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        BalonDTO balon = null;
        List<BalonDTO> balones = new ArrayList<BalonDTO>();

        try {
            //ternario para comparar si la conexion esta activa.
            //si la transaccion esta activa, retorna la propieadad de conexion
            //si no, crea la transaccion.
           
//            if (this.conexionTransaccional != null){
//                conn = this.conexionTransaccional;
//            }else {
//                conn = Conexion.getConnection();
//            }
            
            
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            
            
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt("Id");
                String Balon = rs.getString("Balon");
                String Pais = rs.getString("Pais");
                String Año = rs.getString("Año");
              

                balon = new BalonDTO();
                balon.setId(Id);
                balon.setBalon(Balon);
                balon.setPais(Pais);
                balon.setAño(Año);
               
                    

                balones.add(balon);
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }

        }

        return balones;
    }
      public int insert(BalonDTO balon) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, balon.getBalon());
            stmt.setString(2, balon.getPais());
            stmt.setString(3, balon.getAño());
          
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }

    public int update(BalonDTO balon) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, balon.getBalon());
            stmt.setString(2, balon.getPais());
            stmt.setString(3, balon.getAño());
           
            stmt.setInt(4, balon.getId());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }
     public int delete(BalonDTO balon) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            //validacion usando un ternario
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, balon.getId());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }

}


