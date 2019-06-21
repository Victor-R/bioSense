/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.service;

import biosensews.dao.FabricaDAO;
import biosensews.dao.LeituraDAO;
import biosensews.model.Leitura;
import java.util.List;

/**
 *
 * @author Lucas Leandro
 */
public class LeituraServiceImpl implements LeituraService {

    private final LeituraDAO leituraDAO;

    public LeituraServiceImpl() {
        this.leituraDAO = FabricaDAO.getLeituraDAO();
    }

    @Override
    public int cadastrar(Leitura Leitura) {
        return leituraDAO.salvar(Leitura);
    }

    @Override
    public List<Leitura> todosPorPlanta(int idPlanta) {
        return leituraDAO.buscarPorPlanta(idPlanta);
    }

}
