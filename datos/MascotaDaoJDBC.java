/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import domain.BalonDTO;
import domain.MascotaDTO;
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
public class MascotaDaoJDBC {
     private Connection conexionTransaccional;

    
    //constantes para la manipulacion de informacion
    private static final String SQL_SELECT = "SELECT Id, Nombre, Pais, Año FROM mascotas";
    private static final String SQL_INSERT = "INSERT INTO mascotas (Id, Nombre, Pais, Año) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE mascotas SET Nombre=?, Pais=?, Año=? WHERE Id = ?";
    private static final String SQL_DELETE = "DELETE FROM mascotas  WHERE Id=?";
    
    public MascotaDaoJDBC(){
        
    }
    
      public MascotaDaoJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    

      }
      public List<MascotaDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MascotaDTO mascota = null;
        List<MascotaDTO> mascotas = new ArrayList<MascotaDTO>();

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
                String Nombre = rs.getString("Nombre");
                String Pais = rs.getString("Pais");
                String Año = rs.getString("Año");
              

                mascota= new MascotaDTO();
                mascota.setId(Id);
                mascota.setNombre(Nombre);
                mascota.setPais(Pais);
                mascota.setAño(Año);
               
                    

                mascotas.add(mascota);
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }

        }

        return mascotas;
    }
      public int insert(MascotaDTO mascota) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, mascota.getNombre());
            stmt.setString(2, mascota.getPais());
            stmt.setString(3, mascota.getAño());
          
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

    public int update(MascotaDTO mascota) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, mascota.getNombre());
            stmt.setString(2, mascota.getPais());
            stmt.setString(3, mascota.getAño());
           
            stmt.setInt(4, mascota.getId());

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
     public int delete(MascotaDTO mascota) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            //validacion usando un ternario
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, mascota.getId());
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




