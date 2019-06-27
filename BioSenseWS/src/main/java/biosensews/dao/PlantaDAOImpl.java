/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.dao;

import biosensews.model.Planta;
import biosensews.model.TipoPlanta;
import biosensews.utils.FabricaConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Leandro
 */
public class PlantaDAOImpl implements PlantaDAO {

    /**
     * Cadastra uma nova Planta no banco de dados
     *
     * @param planta Planta a ser cadastrada
     * @return Id da Planta cadastrada
     */
    @Override
    public int salvar(Planta planta) {
        Connection con = FabricaConexao.getConexao();
        PreparedStatement pstm;
        ResultSet res;
        int idPlanta = -1;

        if (con != null) {
            try {
                pstm = con.prepareStatement(INSERT_PLANTA, PreparedStatement.RETURN_GENERATED_KEYS);
                pstm.setInt(1, planta.getTipoPlanta().getId());
                pstm.setInt(2, planta.getUsuario().getId());
                pstm.setDate(3, new Date(planta.getDataPlantio().getTime()));
                pstm.setInt(4, planta.getQuantidade());
                pstm.executeUpdate();
                res = pstm.getGeneratedKeys();
                while (res.next()) {
                    idPlanta = res.getInt(1);
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }

        return idPlanta;
    }

    /**
     * Todas as plantas de um usuário
     *
     * @param idUsuario Id do usuário a ser buscado
     * @return Lista das plantas solicitadas
     */
    @Override
    public List<Planta> buscarPorUsuario(int idUsuario) {
        List<Planta> plantas = new ArrayList<>();
        Planta planta;
        TipoPlanta tipoPlanta;
        Connection con = FabricaConexao.getConexao();
        PreparedStatement pstm;
        ResultSet res;

        if (con != null) {
            try {
                pstm = con.prepareStatement(SELECT_PLANTA_BY_USUARIO);
                pstm.setInt(1, idUsuario);
                res = pstm.executeQuery();
                while (res.next()) {
                    planta = new Planta();
                    planta.setId(res.getInt(1));
                    planta.setDataPlantio(res.getDate(2));
                    planta.setQuantidade(res.getInt(3));

                    tipoPlanta = new TipoPlanta();
                    tipoPlanta.setId(res.getInt(4));
                    tipoPlanta.setNome(res.getString(5));
                    tipoPlanta.setTempoColheita(res.getInt(6));
                    tipoPlanta.setSoloIdeal(res.getFloat(7));
                    tipoPlanta.setIrrigacaoIdeal(res.getFloat(8));
                    tipoPlanta.setPhIdeal(res.getFloat(9));
                    tipoPlanta.setTemperaturaIdeal(res.getFloat(10));
                    tipoPlanta.setUmidadeIdeal(res.getFloat(11));

                    planta.setTipoPlanta(tipoPlanta);
                    plantas.add(planta);
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }

        return plantas;
    }

    /**
     * Busca uma determinada planta
     *
     * @param idPlanta Id da planta a ser buscada
     * @return Planta solicitada
     */
    @Override
    public Planta buscarPorId(int idPlanta) {
        Planta planta = null;
        TipoPlanta tipoPlanta;
        Connection con = FabricaConexao.getConexao();
        PreparedStatement pstm;
        ResultSet res;

        if (con != null) {
            try {
                pstm = con.prepareStatement(SELECT_PLANTA_BY_ID);
                pstm.setInt(1, idPlanta);
                res = pstm.executeQuery();
                while (res.next()) {
                    planta = new Planta();
                    planta.setId(res.getInt(1));
                    planta.setDataPlantio(res.getDate(2));
                    planta.setQuantidade(res.getInt(3));

                    tipoPlanta = new TipoPlanta();
                    tipoPlanta.setId(res.getInt(4));
                    tipoPlanta.setNome(res.getString(5));
                    tipoPlanta.setTempoColheita(res.getInt(6));
                    tipoPlanta.setSoloIdeal(res.getFloat(7));
                    tipoPlanta.setIrrigacaoIdeal(res.getFloat(8));
                    tipoPlanta.setPhIdeal(res.getFloat(9));
                    tipoPlanta.setTemperaturaIdeal(res.getFloat(10));
                    tipoPlanta.setUmidadeIdeal(res.getFloat(11));

                    planta.setTipoPlanta(tipoPlanta);
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }

        return planta;
    }

    /**
     * Edita uma determinada planta
     *
     * @param planta Planta a ser editada
     * @return true caso a planta tenha sido editada com sucesso
     */
    @Override
    public boolean editar(Planta planta) {
        boolean b = false;
        Connection con = FabricaConexao.getConexao();
        PreparedStatement pstm;

        if (con != null) {
            try {
                pstm = con.prepareStatement(UPDATE_PLANTA);
                pstm.setDate(1, new Date(planta.getDataPlantio().getTime()));
                pstm.setInt(2, planta.getQuantidade());
                pstm.setInt(3, planta.getId());
                pstm.executeUpdate();

                b = true;
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }

        return b;
    }

    /**
     * Deleta a planta solicitada
     *
     * @param idPlanta Id da planta a ser deletada
     * @return true caso a planta tenha sido deletada com sucesso
     */
    @Override
    public boolean deletar(int idPlanta) {
        boolean b = false;
        Connection con = FabricaConexao.getConexao();
        PreparedStatement pstm;

        if (con != null) {
            try {
                pstm = con.prepareStatement(DELETE_PLANTA);
                pstm.setLong(1, idPlanta);
                int result = pstm.executeUpdate();

                b = result == 1;
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }

        return b;
    }

}
