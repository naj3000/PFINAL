/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

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
public class MundialDaoJDBC extends MundialDTO{
private Connection conexionTransaccional;

    
    //constantes para la manipulacion de informacion
    private static final String SQL_SELECT = "SELECT Id, Pais, Region, Capitan, Ranking,Mundiales_Ganados FROM jugadores";
    private static final String SQL_INSERT = "INSERT INTO jugadores(Id, Pais, Region, Capitan, Ranking,Mundiales_Ganados) VALUES(?, ?, ?, ?,?,?)";
    private static final String SQL_UPDATE = "UPDATE jugadores SET Pais=?, Region=?, Capitan=?, Ranking=?,Mundiales_Ganados=? WHERE Id = ?";
    private static final String SQL_DELETE = "DELETE FROM jugadores WHERE Id=?";
    
    public MundialDaoJDBC(){
        
    }
    
      public MundialDaoJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    

      }
      public List<MundialDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MundialDTO mundial = null;
        List<MundialDTO> mundiales = new ArrayList<MundialDTO>();

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
                String Pais = rs.getString("Pais");
                String Region = rs.getString("Region");
                String Capitan = rs.getString("Capitan");
                String Ranking = rs.getString("Ranking");
                String  Mundiales_Ganados = rs.getString("Mundiales_Ganados");

                mundial = new MundialDTO();
                mundial.setId(Id);
                mundial.setPais(Pais);
                mundial.setRegion(Region);
                mundial.setCapitan(Capitan);
                mundial.setRanking(Ranking);
                mundial.setMundiales_Ganados(Mundiales_Ganados);
                    

                mundiales.add(mundial);
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }

        }

        return mundiales;
    }
      public int insert(MundialDTO mundial) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, mundial.getPais());
            stmt.setString(2, mundial.getRegion());
            stmt.setString(3, mundial.getCapitan());
            stmt.setString(4, mundial.getRanking());
            stmt.setString(5,mundial.getMundiales_Ganados());

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

    public int update(MundialDTO mundial) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, mundial.getPais());
            stmt.setString(2, mundial.getRegion());
            stmt.setString(3, mundial.getCapitan());
            stmt.setString(4, mundial.getRanking());
            stmt.setString(5,mundial.getMundiales_Ganados());
            stmt.setInt(6, mundial.getId());

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
     public int delete(MundialDTO mundial) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            //validacion usando un ternario
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, mundial.getId());
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
