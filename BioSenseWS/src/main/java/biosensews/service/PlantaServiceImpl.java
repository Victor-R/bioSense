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
        
    @Override
    public int cadastrar(Planta planta) {
        return plantaDAO.salvar(planta);
    }

    @Override
    public Planta buscarPorId(int idPlanta) {
        return plantaDAO.buscarPorId(idPlanta);
    }

    @Override
    public List<Planta> todosPorUsuario(int idUsuario) {
        return plantaDAO.buscarPorUsuario(idUsuario);
    }

    @Override
    public boolean editar(Planta planta) {
        return plantaDAO.editar(planta);
    }

    @Override
    public boolean deletar(int idPlanta) {
        return plantaDAO.deletar(idPlanta);
    }

}
