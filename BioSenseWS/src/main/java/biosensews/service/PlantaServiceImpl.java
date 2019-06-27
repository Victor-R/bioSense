/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.service;

import biosensews.dao.FabricaDAO;
import biosensews.dao.PlantaDAO;
import biosensews.model.Planta;
import java.util.List;

/**
 *
 * @author Lucas Leandro
 */
public class PlantaServiceImpl implements PlantaService {

    private final PlantaDAO plantaDAO;

    public PlantaServiceImpl() {
        this.plantaDAO = FabricaDAO.getPlantaDAO();
    }

    /**
     * Cadastra uma nova Planta no banco de dados
     *
     * @param planta Planta a ser cadastrada
     * @return Id da Planta cadastrada
     */
    @Override
    public int cadastrar(Planta planta) {
        return plantaDAO.salvar(planta);
    }

    /**
     * Busca uma determinada planta
     *
     * @param idPlanta Id da planta a ser buscada
     * @return Planta solicitada
     */
    @Override
    public Planta buscarPorId(int idPlanta) {
        return plantaDAO.buscarPorId(idPlanta);
    }

    /**
     * Todas as plantas de um usuário
     *
     * @param idUsuario Id do usuário a ser buscado
     * @return Lista das plantas solicitadas
     */
    @Override
    public List<Planta> todosPorUsuario(int idUsuario) {
        return plantaDAO.buscarPorUsuario(idUsuario);
    }

    /**
     * Edita uma determinada planta
     *
     * @param planta Planta a ser editada
     * @return true caso a planta tenha sido editada com sucesso
     */
    @Override
    public boolean editar(Planta planta) {
        return plantaDAO.editar(planta);
    }

    /**
     * Deleta a planta solicitada
     *
     * @param idPlanta Id da planta a ser deletada
     * @return true caso a planta tenha sido deletada com sucesso
     */
    @Override
    public boolean deletar(int idPlanta) {
        return plantaDAO.deletar(idPlanta);
    }

}
