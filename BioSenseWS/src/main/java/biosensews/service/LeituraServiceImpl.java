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

    /**
     * Cadastra uma nova Leitura no banco de dados
     *
     * @param Leitura A ser gravada
     * @return Id da Leitura inserida
     */
    @Override
    public int cadastrar(Leitura Leitura) {
        return leituraDAO.salvar(Leitura);
    }

    /**
     * Busca todas as leituras de uma determinada planta
     *
     * @param idPlanta Id da planta a ser buscada
     * @return Lista de leituras da planta
     */
    @Override
    public List<Leitura> todosPorPlanta(int idPlanta) {
        return leituraDAO.buscarPorPlanta(idPlanta);
    }

}
