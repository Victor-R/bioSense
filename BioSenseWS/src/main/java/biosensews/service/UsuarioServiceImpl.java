/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.service;

import biosensews.dao.FabricaDAO;
import biosensews.dao.UsuarioDAO;
import biosensews.model.Usuario;
import java.util.List;

/**
 *
 * @author Lucas Leandro
 */
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDAO usuarioDAO;

    public UsuarioServiceImpl() {
        this.usuarioDAO = FabricaDAO.getUsuarioDAO();
    }

    /**
     * Cadastra um novo Usuario no banco de dados
     *
     * @param usuario Usuario a ser cadastrado
     * @return Id do Usuario cadastrado
     */
    @Override
    public int cadastrar(Usuario usuario) {
        return this.usuarioDAO.salvar(usuario);
    }

    /**
     * Busca todos os Usuarios
     *
     * @return Lista de todos os Usuarios
     */
    @Override
    public List<Usuario> todos() {
        return this.usuarioDAO.todos();
    }

    /**
     * Busca determinado Usuario pelo login e senha
     *
     * @param login Login do Usuario
     * @param senha Senha do Usuario
     * @return Usuario solicitado
     */
    @Override
    public Usuario login(String login, String senha) {
        return this.usuarioDAO.buscarPorLoginSenha(login, senha);
    }

    /**
     * Edita as informações pessoais do Usuario
     *
     * @param usuario Usuario a ser editado
     * @return true caso tenha sido editado com sucesso
     */
    @Override
    public boolean editarInfo(Usuario usuario) {
        return this.usuarioDAO.editarInfo(usuario);
    }

    /**
     * Edita a senha do Usuario solicitado
     *
     * @param usuario Usuario a ser alterado a senha
     * @return true caso a senha tenha sido alterada com sucesso
     */
    @Override
    public boolean editarSenha(Usuario usuario) {
        return this.usuarioDAO.editarSenha(usuario);
    }
}
