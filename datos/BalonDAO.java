/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import domain.BalonDTO;
import domain.MundialDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface BalonDAO {
       public List<BalonDTO> select() throws SQLException;
    
    public int insert(BalonDTO  Balon) throws SQLException;
    
    public int update(BalonDTO Balon) throws SQLException;
    
    public int delete(BalonDTO Balon) throws SQLException;
}


