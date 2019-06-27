/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.dao;

import biosensews.model.Usuario;
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
public class UsuarioDAOImpl implements UsuarioDAO {

    /**
     * Cadastra um novo Usuario no banco de dados
     *
     * @param usuario Usuario a ser cadastrado
     * @return Id do Usuario cadastrado
     */
    @Override
    public int salvar(Usuario usuario) {
        Connection con = FabricaConexao.getConexao();
        PreparedStatement pstm;
        ResultSet res;
        int idUsuario = -1;

        if (con != null) {
            try {
                pstm = con.prepareStatement(INSERT_USUARIO, PreparedStatement.RETURN_GENERATED_KEYS);
                pstm.setString(1, usuario.getNome());
                pstm.setString(2, usuario.getEmail());
                pstm.setString(3, usuario.getLogin());
                pstm.setString(4, usuario.getSenha());
                pstm.setString(5, usuario.getCelular());
                pstm.setString(6, usuario.getTelefone());
                pstm.executeUpdate();
                res = pstm.getGeneratedKeys();
                while (res.next()) {
                    idUsuario = res.getInt(1);
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }

        return idUsuario;
    }

    /**
     * Busca todos os Usuarios
     *
     * @return Lista de todos os Usuarios
     */
    @Override
    public List<Usuario> todos() {
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = null;
        Connection con = FabricaConexao.getConexao();
        PreparedStatement pstm;
        ResultSet res;

        if (con != null) {
            try {
                pstm = con.prepareStatement(SELECT_TODOS_USUARIO);
                res = pstm.executeQuery();
                while (res.next()) {
                    usuario = new Usuario();
                    usuario.setId(res.getInt(1));
                    usuario.setNome(res.getString(2));
                    usuario.setEmail(res.getString(3));
                    usuario.setCelular(res.getString(4));
                    usuario.setTelefone(res.getString(5));
                    usuarios.add(usuario);
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }

        return usuarios;
    }

    /**
     * Busca determinado Usuario pelo login e senha
     *
     * @param login Login do Usuario
     * @param senha Senha do Usuario
     * @return Usuario solicitado
     */
    @Override
    public Usuario buscarPorLoginSenha(String login, String senha) {
        Usuario usuario = null;
        Connection con = FabricaConexao.getConexao();
        PreparedStatement pstm;
        ResultSet res;

        if (con != null) {
            try {
                pstm = con.prepareStatement(SELECT_USUARIO_BY_LOGIN_SENHA);
                pstm.setString(1, login);
                pstm.setString(2, senha);
                res = pstm.executeQuery();
                while (res.next()) {
                    usuario = new Usuario();
                    usuario.setId(res.getInt(1));
                    usuario.setNome(res.getString(2));
                    usuario.setEmail(res.getString(3));
                    usuario.setCelular(res.getString(4));
                    usuario.setTelefone(res.getString(5));
                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }

        return usuario;
    }

    /**
     * Edita as informações pessoais do Usuario
     *
     * @param usuario Usuario a ser editado
     * @return true caso tenha sido editado com sucesso
     */
    @Override
    public boolean editarInfo(Usuario usuario) {
        boolean b = false;
        Connection con = FabricaConexao.getConexao();
        PreparedStatement pstm;

        if (con != null) {
            try {
                pstm = con.prepareStatement(UPDATE_USUARIO_INFO);
                pstm.setString(1, usuario.getNome());
                pstm.setString(2, usuario.getEmail());
                pstm.setString(3, usuario.getCelular());
                pstm.setString(4, usuario.getTelefone());
                pstm.setInt(5, usuario.getId());
                pstm.executeUpdate();

                b = true;
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }

        return b;
    }

    /**
     * Edita a senha do Usuario solicitado
     *
     * @param usuario Usuario a ser alterado a senha
     * @return true caso a senha tenha sido alterada com sucesso
     */
    @Override
    public boolean editarSenha(Usuario usuario) {
        boolean b = false;
        Connection con = FabricaConexao.getConexao();
        PreparedStatement pstm;

        if (con != null) {
            try {
                pstm = con.prepareStatement(UPDATE_USUARIO_PASSWORD);
                pstm.setString(1, usuario.getSenha());
                pstm.setInt(2, usuario.getId());
                pstm.executeUpdate();

                b = true;
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }

        return b;
    }
}
