/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.dao;

import biosensews.model.Leitura;
import biosensews.utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Leandro
 */
public class LeituraDAOImpl implements LeituraDAO {

    /**
     * Cadastra uma nova Leitura no banco de dados
     *
     * @param leitura A ser gravada
     * @return Id da Leitura inserida
     */
    @Override
    public int salvar(Leitura leitura) {
        Connection con = FabricaConexao.getConexao();
        PreparedStatement pstm;
        ResultSet res;
        int idLeitura = -1;

        if (con != null) {
            try {
                pstm = con.prepareStatement(INSERT_LEITURA, PreparedStatement.RETURN_GENERATED_KEYS);
                pstm.setInt(1, leitura.getPlanta().getId());
                pstm.setTimestamp(2, new Timestamp(leitura.getData().getTime()));
                pstm.setFloat(3, leitura.getTemperatura());
                pstm.setFloat(4, leitura.getPh());
                pstm.setFloat(5, leitura.getUmidade());
                pstm.setFloat(6, leitura.getIrrigacao());
                pstm.setFloat(7, leitura.getSolo());
                pstm.executeUpdate();
                res = pstm.getGeneratedKeys();
                while (res.next()) {
                    idLeitura = res.getInt(1);
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }

        return idLeitura;
    }

    /**
     * Busca todas as leituras de uma determinada planta
     *
     * @param idPlanta Id da planta a ser buscada
     * @return Lista de leituras da planta
     */
    @Override
    public List<Leitura> buscarPorPlanta(int idPlanta) {
        List<Leitura> leituras = new ArrayList<>();
        Leitura leitura;
        Connection con = FabricaConexao.getConexao();
        PreparedStatement pstm;
        ResultSet res;

        if (con != null) {
            try {
                pstm = con.prepareStatement(SELECT_LEITURA_BY_PLANTA);
                pstm.setInt(1, idPlanta);
                res = pstm.executeQuery();
                while (res.next()) {
                    leitura = new Leitura();
                    leitura.setId(res.getInt(1));
                    leitura.setData(res.getTimestamp(2));
                    leitura.setTemperatura(res.getFloat(3));
                    leitura.setPh(res.getFloat(4));
                    leitura.setUmidade(res.getFloat(5));
                    leitura.setIrrigacao(res.getFloat(6));
                    leitura.setSolo(res.getFloat(7));
                    leituras.add(leitura);
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }

        return leituras;
    }
}
