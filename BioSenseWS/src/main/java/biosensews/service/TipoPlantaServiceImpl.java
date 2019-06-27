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

    @Override
    public int cadastrar(TipoPlanta tipoPlanta) {
        return tipoPlantaDAO.salvar(tipoPlanta);
    }

    @Override
    public TipoPlanta buscar(int id) {
        return tipoPlantaDAO.buscarPorId(id);
    }

    @Override
    public List<TipoPlanta> todos() {
        return tipoPlantaDAO.buscarTodos();
    }

    @Override
    public boolean editar(TipoPlanta tipoPlanta) {
        return tipoPlantaDAO.editar(tipoPlanta);
    }
}
