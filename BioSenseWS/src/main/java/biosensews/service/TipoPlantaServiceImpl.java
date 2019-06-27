/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.service;

import biosensews.dao.FabricaDAO;
import biosensews.dao.TipoPlantaDAO;
import biosensews.model.TipoPlanta;
import java.util.List;

/**
 *
 * @author Lucas Leandro
 */
public class TipoPlantaServiceImpl implements TipoPlantaService {

    private final TipoPlantaDAO tipoPlantaDAO;

    public TipoPlantaServiceImpl() {
        this.tipoPlantaDAO = FabricaDAO.getTipoPlantaDAO();
    }

    /**
     * Cadastra um novo TipoPlanta
     *
     * @param tipoPlanta Tipo planta a ser cadastrado
     * @return Id do TipoPlanta cadastrado
     */
    @Override
    public int cadastrar(TipoPlanta tipoPlanta) {
        return tipoPlantaDAO.salvar(tipoPlanta);
    }

    /**
     * Busca um determinado TipoPlanta
     *
     * @param id Id do TipoPlanta solicitada
     * @return TipoPlanta solicitado
     */
    @Override
    public TipoPlanta buscar(int id) {
        return tipoPlantaDAO.buscarPorId(id);
    }

    /**
     * Busca todos os TipoPlanta do banco
     *
     * @return Lista de TipoPlanta
     */
    @Override
    public List<TipoPlanta> todos() {
        return tipoPlantaDAO.buscarTodos();
    }

    /**
     * Edita um determinado TipoPlanta
     *
     * @param tipoPlanta TipoPlanta a ser editado
     * @return true caso o TipoPlanta tenha sido editado com sucesso
     */
    @Override
    public boolean editar(TipoPlanta tipoPlanta) {
        return tipoPlantaDAO.editar(tipoPlanta);
    }
}
