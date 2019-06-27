/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.dao;

import biosensews.model.TipoPlanta;
import biosensews.utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Leandro
 */
public class TipoPlantaDAOImpl implements TipoPlantaDAO {

    /**
     * Cadastra um novo TipoPlanta
     *
     * @param tipoPlanta Tipo planta a ser cadastrado
     * @return Id do TipoPlanta cadastrado
     */
    @Override
    public int salvar(TipoPlanta tipoPlanta) {
        Connection con = FabricaConexao.getConexao();
        PreparedStatement pstm;
        ResultSet res;
        int idTipoPlanta = -1;

        if (con != null) {
            try {
                pstm = con.prepareStatement(INSERT_TIPO_PLANTA, PreparedStatement.RETURN_GENERATED_KEYS);
                pstm.setString(1, tipoPlanta.getNome());
                pstm.setInt(2, tipoPlanta.getTempoColheita());
                pstm.setFloat(3, tipoPlanta.getSoloIdeal());
                pstm.setFloat(4, tipoPlanta.getIrrigacaoIdeal());
                pstm.setFloat(5, tipoPlanta.getPhIdeal());
                pstm.setFloat(6, tipoPlanta.getTemperaturaIdeal());
                pstm.setFloat(7, tipoPlanta.getUmidadeIdeal());
                pstm.executeUpdate();
                res = pstm.getGeneratedKeys();
                while (res.next()) {
                    idTipoPlanta = res.getInt(1);
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }

        return idTipoPlanta;
    }

    /**
     * Busca todos os TipoPlanta do banco
     *
     * @return Lista de TipoPlanta
     */
    @Override
    public List<TipoPlanta> buscarTodos() {
        List<TipoPlanta> tiposPlanta = new ArrayList<>();
        TipoPlanta tipoPlanta = null;
        Connection con = FabricaConexao.getConexao();
        PreparedStatement pstm;
        ResultSet res;

        if (con != null) {
            try {
                pstm = con.prepareStatement(SELECT_TODOS_TIPO_PLANTA);
                res = pstm.executeQuery();
                while (res.next()) {
                    tipoPlanta = new TipoPlanta();
                    tipoPlanta.setId(res.getInt(1));
                    tipoPlanta.setNome(res.getString(2));
                    tipoPlanta.setTempoColheita(res.getInt(3));
                    tipoPlanta.setSoloIdeal(res.getFloat(4));
                    tipoPlanta.setIrrigacaoIdeal(res.getFloat(5));
                    tipoPlanta.setPhIdeal(res.getFloat(6));
                    tipoPlanta.setTemperaturaIdeal(res.getFloat(7));
                    tipoPlanta.setUmidadeIdeal(res.getFloat(5));
                    tiposPlanta.add(tipoPlanta);
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }

        return tiposPlanta;
    }

    /**
     * Busca um determinado TipoPlanta
     *
     * @param id Id do TipoPlanta solicitada
     * @return TipoPlanta solicitado
     */
    @Override
    public TipoPlanta buscarPorId(int id) {
        TipoPlanta tipoPlanta = null;
        Connection con = FabricaConexao.getConexao();
        PreparedStatement pstm;
        ResultSet res;

        if (con != null) {
            try {
                pstm = con.prepareStatement(SELECT_TIPO_PLANTA_BY_ID);
                pstm.setInt(1, id);
                res = pstm.executeQuery();
                while (res.next()) {
                    tipoPlanta = new TipoPlanta();
                    tipoPlanta.setId(res.getInt(1));
                    tipoPlanta.setNome(res.getString(2));
                    tipoPlanta.setTempoColheita(res.getInt(3));
                    tipoPlanta.setSoloIdeal(res.getFloat(4));
                    tipoPlanta.setIrrigacaoIdeal(res.getFloat(5));
                    tipoPlanta.setPhIdeal(res.getFloat(6));
                    tipoPlanta.setTemperaturaIdeal(res.getFloat(7));
                    tipoPlanta.setUmidadeIdeal(res.getFloat(5));
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }

        return tipoPlanta;
    }

    /**
     * Edita um determinado TipoPlanta
     *
     * @param tipoPlanta TipoPlanta a ser editado
     * @return true caso o TipoPlanta tenha sido editado com sucesso
     */
    @Override
    public boolean editar(TipoPlanta tipoPlanta) {
        boolean b = false;
        Connection con = FabricaConexao.getConexao();
        PreparedStatement pstm;

        if (con != null) {
            try {
                pstm = con.prepareStatement(UPDATE_TIPO_PLANTA);
                pstm.setString(1, tipoPlanta.getNome());
                pstm.setInt(2, tipoPlanta.getTempoColheita());
                pstm.setFloat(3, tipoPlanta.getSoloIdeal());
                pstm.setFloat(4, tipoPlanta.getIrrigacaoIdeal());
                pstm.setFloat(5, tipoPlanta.getPhIdeal());
                pstm.setFloat(6, tipoPlanta.getTemperaturaIdeal());
                pstm.setFloat(7, tipoPlanta.getUmidadeIdeal());
                pstm.setInt(8, tipoPlanta.getId());
                pstm.executeUpdate();

                b = true;
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }

        return b;
    }
}
