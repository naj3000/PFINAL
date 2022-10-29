/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import domain.MundialDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface MundialDAO {
     public List<MundialDTO> select() throws SQLException;
    
    public int insert(MundialDTO  Mundial) throws SQLException;
    
    public int update(MundialDTO Mundial) throws SQLException;
    
    public int delete(MundialDTO Mundial) throws SQLException;
}
