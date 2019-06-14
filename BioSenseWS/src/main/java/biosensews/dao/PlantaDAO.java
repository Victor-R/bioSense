/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.dao;

import biosensews.model.Planta;
import java.util.List;

/**
 *
 * @author Lucas Leandro
 */
public interface PlantaDAO {
    final String INSERT_PLANTA = 
    "INSERT INTO bio_planta(TPL_ID, USR_ID, PLT_DATA_PLANTIO, PLT_QUANTIDADE"
            + "VALUES(?, ?, ?, ?)";
    
    final String SELECT_PLANTA_BY_USUARIO = 
    "SELECT PLT_ID, PLT_DATA_PLANTIO, PLT_QUANTIDADE, TPL_ID, TPL_NOME, "
            + "TPL_TEMPO_COLHEITA, TPL_SOLO_IDEAL, TPL_IRRIGACAO_IDEAL, "
            + "TPL_PH_IDEAL, TPL_TEMPERATURA_IDEAL, TPL_UMIDADE_IDEAL "
            + "FROM bio_planta AS p"
            + "JOIN bio_tipo_planta AS tp ON tp.TPL_ID = p.TPL_ID"
            + "WHERE USR_ID = ?";
    
    
    final String SELECT_PLANTA_BY_ID = 
    "SELECT PLT_ID, PLT_DATA_PLANTIO, PLT_QUANTIDADE, TPL_ID, TPL_NOME, "
            + "TPL_TEMPO_COLHEITA, TPL_SOLO_IDEAL, TPL_IRRIGACAO_IDEAL, "
            + "TPL_PH_IDEAL, TPL_TEMPERATURA_IDEAL, TPL_UMIDADE_IDEAL "
            + "FROM bio_planta AS p"
            + "JOIN bio_tipo_planta AS tp ON tp.TPL_ID = p.TPL_ID"
            + "WHERE PLT_ID = ?";
    
    final String UPDATE_PLANTA =
    "UPDATE bio_planta "
            + "SET PLT_DATA_PLANTIO = ?, PLT_QUANTIDADE = ?"
            + "WHERE PLT_ID = ?";
    
    final String DELETE_PLANTA = "DELETE FROM bio_planta WHERE PLT_ID = ?";
    
    public int salvar(Planta planta);
    public List<Planta> buscarPorUsuario(int idUsuario);
    public Planta buscarPorId(int idPlanta);
    public boolean editar(Planta planta);
    public boolean deletar(int idPlanta);
}
