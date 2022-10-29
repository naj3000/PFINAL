/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import domain.BalonDTO;
import domain.MascotaDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface MascotaDAO {
       public List<MascotaDTO> select() throws SQLException;
    
    public int insert(MascotaDTO  Mascota) throws SQLException;
    
    public int update(MascotaDTO Mascota) throws SQLException;
    
    public int delete(MascotaDTO Mascota) throws SQLException;
}
