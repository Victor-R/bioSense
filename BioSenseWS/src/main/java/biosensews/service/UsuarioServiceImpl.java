/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.service;

import biosensews.dao.FabricaDAO;
import biosensews.dao.UsuarioDAO;
import biosensews.model.Usuario;

/**
 *
 * @author Lucas Leandro
 */
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDAO usuarioDAO;

    public UsuarioServiceImpl() {
        this.usuarioDAO = FabricaDAO.getUsuarioDAO();
    }

    @Override
    public int cadastrar(Usuario usuario) {
        return this.usuarioDAO.salvar(usuario);
    }

    @Override
    public Usuario login(String login, String senha) {
        return this.usuarioDAO.buscarPorLoginSenha(login, senha);
    }
}
