/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.dao;

import biosensews.model.Leitura;
import java.util.List;

/**
 *
 * @author Lucas Leandro
 */
public interface LeituraDAO {
    
    final String INSERT_LEITURA = 
    "INSERT INTO bio_leitura(PLT_ID, LET_DATA, LET_TEMPERATURA, LET_PH, "
            + "LET_UMIDADE, LET_IRRIGACAO, LET_QUALIDADE_SOLO) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?)";
    
    final String SELECT_LEITURA_BY_PLANTA = 
    "SELECT LET_ID, PLT_ID, LET_DATA, LET_TEMPERATURA, LET_PH, LET_UMIDADE, "
            + "LET_IRRIGACAO, LET_QUALIDADE_SOLO "
            + "FROM bio_leitura "
            + "WHERE PLT_ID = ? "
            + "ORDER BY LET_DATA";
    
        
    public int salvar(Leitura leitura);
    public List<Leitura> buscarPorPlanta(int idPlanta);
}
