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
    "INSERT INTO bio_planta(TPL_ID, USR_ID, PLT_DATA_PLANTIO, PLT_QUANTIDADE) "
            + "VALUES(?, ?, ?, ?)";
    
    final String SELECT_PLANTA_BY_USUARIO = 
    "SELECT p.PLT_ID, p.PLT_DATA_PLANTIO, p.PLT_QUANTIDADE, p.TPL_ID, tp.TPL_NOME, "
            + "tp.TPL_TEMPO_COLHEITA, tp.TPL_SOLO_IDEAL, tp.TPL_IRRIGACAO_IDEAL, "
            + "tp.TPL_PH_IDEAL, tp.TPL_TEMPERATURA_IDEAL, tp.TPL_UMIDADE_IDEAL "
            + "FROM bio_planta AS p "
            + "JOIN bio_tipo_planta AS tp ON tp.TPL_ID = p.TPL_ID "
            + "WHERE p.USR_ID = ?";
    
    
    final String SELECT_PLANTA_BY_ID = 
    "SELECT p.PLT_ID, p.PLT_DATA_PLANTIO, p.PLT_QUANTIDADE, p.TPL_ID, tp.TPL_NOME, "
            + "tp.TPL_TEMPO_COLHEITA, tp.TPL_SOLO_IDEAL, tp.TPL_IRRIGACAO_IDEAL, "
            + "tp.TPL_PH_IDEAL, tp.TPL_TEMPERATURA_IDEAL, tp.TPL_UMIDADE_IDEAL "
            + "FROM bio_planta AS p "
            + "JOIN bio_tipo_planta AS tp ON tp.TPL_ID = p.TPL_ID "
            + "WHERE p.PLT_ID = ?";
    
    final String UPDATE_PLANTA =
    "UPDATE bio_planta "
            + "SET PLT_DATA_PLANTIO = ?, PLT_QUANTIDADE = ? "
            + "WHERE PLT_ID = ?";
    
    final String DELETE_PLANTA = "DELETE FROM bio_planta WHERE PLT_ID = ?";
    
    public int salvar(Planta planta);
    public List<Planta> buscarPorUsuario(int idUsuario);
    public Planta buscarPorId(int idPlanta);
    public boolean editar(Planta planta);
    public boolean deletar(int idPlanta);
}
