/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.ws;

import biosensews.model.Leitura;
import biosensews.model.Planta;
import biosensews.model.TipoPlanta;
import biosensews.model.Usuario;
import biosensews.service.FabricaService;
import biosensews.service.LeituraService;
import biosensews.service.PlantaService;
import biosensews.service.TipoPlantaService;
import biosensews.service.UsuarioService;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Lucas Leandro
 */
@WebService(serviceName = "BioSenseWS")
public class BioSenseWS {

    /**
     * This is a sample web service operation
     *
     * @param txt
     * @return
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Cadastra um novo usuario
     *
     * @param usuario
     * @return Id do usuario cadastrado
     */
    @WebMethod(operationName = "cadastrarUsuario")
    public int cadastrarUsuario(@WebParam(name = "usuario") Usuario usuario) {
        UsuarioService us = FabricaService.getUsuarioService();
        return us.cadastrar(usuario);
    }

    /**
     * Busca usuario pelo login e senha
     *
     * @param login
     * @param senha
     * @return Usuario solicitado
     */
    @WebMethod(operationName = "login")
    public Usuario login(@WebParam(name = "login") String login, @WebParam(name = "senha") String senha) {
        UsuarioService us = FabricaService.getUsuarioService();
        return us.login(login, senha);
    }

    /**
     * Cadastra um novo tipo planta
     *
     * @param tipoPlanta
     * @return Id do tipo planta cadastrado
     */
    @WebMethod(operationName = "cadastrarTipoPlanta")
    public int cadastrarTipoPlanta(@WebParam(name = "tipoPlanta") TipoPlanta tipoPlanta) {
        TipoPlantaService tps = FabricaService.getTipoPlantaService();
        return tps.cadastrar(tipoPlanta);
    }

    /**
     * Busca determinado tipo planta
     *
     * @param idTipoPlanta
     * @return Tipo planta solicitado
     */
    @WebMethod(operationName = "buscarTipoPlanta")
    public TipoPlanta buscarTipoPlanta(@WebParam(name = "idTipoPlanta") int idTipoPlanta) {
        TipoPlantaService tps = FabricaService.getTipoPlantaService();
        return tps.buscar(idTipoPlanta);
    }

    /**
     * Busca todos os tipo planta
     *
     * @return Lista de tipo planta
     */
    @WebMethod(operationName = "todosTipoPlanta")
    public List<TipoPlanta> todosTipoPlanta() {
        TipoPlantaService tps = FabricaService.getTipoPlantaService();
        return tps.todos();
    }

    /**
     * Edita determinado TipoPlanta
     *
     * @param tipoPlanta
     * @return true caso tenha editado com sucesso
     */
    @WebMethod(operationName = "editarTipoPlanta")
    public boolean editarTipoPlanta(@WebParam(name = "tipoPlanta") TipoPlanta tipoPlanta) {
        TipoPlantaService tps = FabricaService.getTipoPlantaService();
        return tps.editar(tipoPlanta);
    }

    /**
     * Cadastra uma nova planta
     *
     * @param planta
     * @return Planta solicitada
     */
    @WebMethod(operationName = "cadastrarPlanta")
    public int cadastrarPlanta(@WebParam(name = "planta") Planta planta) {
        PlantaService ps = FabricaService.getPlantaService();
        return ps.cadastrar(planta);
    }

    /**
     * Busca determinada planta
     *
     * @param idPlanta
     * @return Planta solicitada
     */
    @WebMethod(operationName = "buscarPlantaPorId")
    public Planta buscarPlantaPorId(@WebParam(name = "idPlanta") int idPlanta) {
        PlantaService ps = FabricaService.getPlantaService();
        return ps.buscarPorId(idPlanta);
    }

    /**
     * Busca todas as plantas do usuario solicitado
     *
     * @param idUsuario
     * @return Lista de plantas
     */
    @WebMethod(operationName = "todasPlantaPorUsuario")
    public List<Planta> todasPlantaPorUsuario(@WebParam(name = "idUsuario") int idUsuario) {
        PlantaService ps = FabricaService.getPlantaService();
        return ps.todosPorUsuario(idUsuario);
    }

    /**
     * Edita uma determinada planta
     *
     * @param planta
     * @return true caso tenha editado com sucesso
     */
    @WebMethod(operationName = "editarPlanta")
    public boolean editarPlanta(@WebParam(name = "planta") Planta planta) {
        PlantaService ps = FabricaService.getPlantaService();
        return ps.editar(planta);
    }

    /**
     * Deleta uma determinada planta
     *
     * @param idPlanta
     * @return true caso tenha deletado com sucesso
     */
    @WebMethod(operationName = "deletarPlanta")
    public boolean deletarPlanta(@WebParam(name = "idPlanta") int idPlanta) {
        PlantaService ps = FabricaService.getPlantaService();
        return ps.deletar(idPlanta);
    }

    /**
     * Cadastra uma nova leitura
     *
     * @param leitura
     * @return Id da leitura cadastrada
     */
    @WebMethod(operationName = "cadastrarLeitura")
    public int cadastrarLeitura(@WebParam(name = "leitura") Leitura leitura) {
        LeituraService ls = FabricaService.getLeituraService();
        return ls.cadastrar(leitura);
    }

    /**
     * Busca todas as leituras da planta solicitada
     *
     * @param idPlanta
     * @return Lista de leituras
     */
    @WebMethod(operationName = "todasLeituraPorPlanta")
    public List<Leitura> todasLeituraPorPlanta(@WebParam(name = "idPlanta") int idPlanta) {
        LeituraService ls = FabricaService.getLeituraService();
        return ls.todosPorPlanta(idPlanta);
    }

    /**
     * Busca todos os usuarios cadastrados
     *
     * @return Lista de usuarios
     */
    @WebMethod(operationName = "todosUsuario")
    public List<Usuario> todosUsuario() {
        UsuarioService us = FabricaService.getUsuarioService();
        return us.todos();
    }

    /**
     * Edita as informações pessoais do usuario
     *
     * @param usuario
     * @return true caso tenha editado com sucesso
     */
    @WebMethod(operationName = "editarInfoUsuario")
    public boolean editarInfoUsuario(@WebParam(name = "usuario") Usuario usuario) {
        UsuarioService us = FabricaService.getUsuarioService();
        return us.editarInfo(usuario);
    }

    /**
     * Edita a senha do usuario solicitado
     *
     * @param usuario
     * @return true caso tenha editado com sucesso
     */
    @WebMethod(operationName = "editarSenhaUsuario")
    public boolean editarSenhaUsuario(@WebParam(name = "usuario") Usuario usuario) {
        UsuarioService us = FabricaService.getUsuarioService();
        return us.editarSenha(usuario);
    }
}
