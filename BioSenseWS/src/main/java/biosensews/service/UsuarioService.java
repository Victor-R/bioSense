/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.service;

import biosensews.model.Usuario;

/**
 *
 * @author Lucas Leandro
 */
public interface UsuarioService {

    public int cadastrar(Usuario usuario);

    public Usuario login(String login, String senha);

}
