/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.BalonDaoJDBC;
import datos.Conexion;
import datos.MundialDaoJDBC;
import domain.BalonDTO;
import domain.MundialDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ManejoBalon {
     public static void main(String[] args) {

        //definimos la variable conexion
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            //el autocommit por default es true, lo pasamos a false
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            BalonDaoJDBC BalonDaoJDBC = new BalonDaoJDBC(conexion) {};
            
            List<BalonDTO> balones = BalonDaoJDBC.select();
            
         for(BalonDTO balon : balones){
             System.out.println("Balon DTO:"+ balon);
            
        }
         conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
}
    }




