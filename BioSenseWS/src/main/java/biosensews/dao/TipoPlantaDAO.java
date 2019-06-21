/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.dao;

import biosensews.model.TipoPlanta;
import java.util.List;

/**
 *
 * @author Lucas Leandro
 */
public interface TipoPlantaDAO {
    final String INSERT_TIPO_PLANTA = 
    "INSERT INTO bio_tipo_planta(TPL_NOME, TPL_TEMPO_COLHEITA, TPL_SOLO_IDEAL, "
            + "TPL_IRRIGACAO_IDEAL, TPL_PH_IDEAL, TPL_TEMPERATURA_IDEAL, "
            + "TPL_UMIDADE_IDEAL) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?)";
    
    final String SELECT_TODOS_TIPO_PLANTA = 
    "SELECT TPL_ID, TPL_NOME, TPL_TEMPO_COLHEITA, TPL_SOLO_IDEAL, "
            + "TPL_IRRIGACAO_IDEAL, TPL_PH_IDEAL, TPL_TEMPERATURA_IDEAL, "
            + "TPL_UMIDADE_IDEAL "
            + "FROM bio_tipo_planta";
    
    final String SELECT_TIPO_PLANTA_BY_ID = 
    "SELECT TPL_ID, TPL_NOME, TPL_TEMPO_COLHEITA, TPL_SOLO_IDEAL, "
            + "TPL_IRRIGACAO_IDEAL, TPL_PH_IDEAL, TPL_TEMPERATURA_IDEAL, "
            + "TPL_UMIDADE_IDEAL "
            + "FROM bio_tipo_planta "
            + "WHERE TPL_ID = ?";
    
    final String UPDATE_TIPO_PLANTA =
    "UPDATE bio_tipo_planta "
            + "SET TPL_NOME = ?, TPL_TEMPO_COLHEITA = ?, TPL_SOLO_IDEAL = ?, "
            + "TPL_IRRIGACAO_IDEAL = ?, TPL_PH_IDEAL = ?, "
            + "TPL_TEMPERATURA_IDEAL = ?, TPL_UMIDADE_IDEAL = ? "
            + "WHERE TPL_ID = ?";
    
    public int salvar(TipoPlanta tipoPlanta);
    public List<TipoPlanta> buscarTodos();
    public TipoPlanta buscarPorId(int id);
    public boolean editar(TipoPlanta tipoPlanta);
}
