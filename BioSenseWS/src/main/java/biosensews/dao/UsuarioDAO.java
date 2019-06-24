/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.dao;

import biosensews.model.Usuario;
import java.util.List;

/**
 *
 * @author Lucas Leandro
 */
public interface UsuarioDAO {
    final String INSERT_USUARIO = 
    "INSERT INTO bio_usuario(USR_NOME, USR_EMAIL, USR_LOGIN, USR_SENHA, "
            + "USR_CELULAR, USR_TELEFONE) "
            + "VALUES(?, ?, ?, ?, ?, ?)";

    final String SELECT_TODOS_USUARIO = 
    "SELECT USR_ID, USR_NOME, USR_EMAIL, USR_CELULAR, USR_TELEFONE "
            + "FROM bio_usuario";
    
    final String SELECT_USUARIO_BY_LOGIN_SENHA = 
    "SELECT USR_ID, USR_NOME, USR_EMAIL, USR_CELULAR, USR_TELEFONE "
            + "FROM bio_usuario WHERE USR_LOGIN = ? AND USR_SENHA = ?";
    
    final String UPDATE_USUARIO_INFO =
    "UPDATE bio_usuario "
            + "SET USR_NOME = ?, USR_EMAIL = ?, USR_CELULAR = ? USR_TELEFONE = ? "
            + "WHERE USR_ID = ?";
    
    final String UPDATE_USUARIO_PASSWORD =
    "UPDATE bio_usuario SET USR_SENHA = ? WHERE USR_ID = ?";
    
    public int salvar(Usuario usuario);
    public List<Usuario> todos();
    public Usuario buscarPorLoginSenha(String login, String senha);
    public boolean editarInfo(Usuario usuario);
    public boolean editarSenha(Usuario usuario);
}
