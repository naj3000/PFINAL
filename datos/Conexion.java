/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author USUARIO
 */
public class Conexion {
      //declaramos las constantes de instancia
    //private static final String JDBC_URL = "jdbc:mysql://localhost/test?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_URL = "jdbc:sqlite:/C:\\Users\\USUARIO\\Documents\\db sqlite\\dbmundial.db";
  //private static final String JDBC_URL = "jdbc:sqlserver://LT-RULDIN-LENOV\\SQLEXPRESS2019:55847;database=p2a;user=ruldin;password=andrea";
    
    
   
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL);
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
    
}

