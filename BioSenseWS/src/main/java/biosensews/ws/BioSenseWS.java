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
     * Operação de Web service
     *
     * @param usuario
     * @return
     */
    @WebMethod(operationName = "cadastrarUsuario")
    public int cadastrarUsuario(@WebParam(name = "usuario") Usuario usuario) {
        UsuarioService us = FabricaService.getUsuarioService();
        return us.cadastrar(usuario);
    }

    /**
     * Operação de Web service
     *
     * @param login
     * @param senha
     * @return
     */
    @WebMethod(operationName = "login")
    public Usuario login(@WebParam(name = "login") String login, @WebParam(name = "senha") String senha) {
        UsuarioService us = FabricaService.getUsuarioService();
        return us.login(login, senha);
    }

    /**
     * Operação de Web service
     *
     * @param tipoPlanta
     * @return
     */
    @WebMethod(operationName = "cadastrarTipoPlanta")
    public int cadastrarTipoPlanta(@WebParam(name = "tipoPlanta") TipoPlanta tipoPlanta) {
        TipoPlantaService tps = FabricaService.getTipoPlantaService();
        return tps.cadastrar(tipoPlanta);
    }

    /**
     * Operação de Web service
     *
     * @param idTipoPlanta
     * @return
     */
    @WebMethod(operationName = "buscarTipoPlanta")
    public TipoPlanta buscarTipoPlanta(@WebParam(name = "idTipoPlanta") int idTipoPlanta) {
        TipoPlantaService tps = FabricaService.getTipoPlantaService();
        return tps.buscar(idTipoPlanta);
    }

    /**
     * Operação de Web service
     *
     * @return
     */
    @WebMethod(operationName = "todosTipoPlanta")
    public List<TipoPlanta> todosTipoPlanta() {
        TipoPlantaService tps = FabricaService.getTipoPlantaService();
        return tps.todos();
    }

    /**
     * Operação de Web service
     *
     * @param tipoPlanta
     * @return
     */
    @WebMethod(operationName = "editarTipoPlanta")
    public boolean editarTipoPlanta(@WebParam(name = "tipoPlanta") TipoPlanta tipoPlanta) {
        TipoPlantaService tps = FabricaService.getTipoPlantaService();
        return tps.editar(tipoPlanta);
    }

    /**
     * Operação de Web service
     *
     * @param planta
     * @return
     */
    @WebMethod(operationName = "cadastrarPlanta")
    public int cadastrarPlanta(@WebParam(name = "planta") Planta planta) {
        PlantaService ps = FabricaService.getPlantaService();
        return ps.cadastrar(planta);
    }

    /**
     * Operação de Web service
     *
     * @param idPlanta
     * @return
     */
    @WebMethod(operationName = "buscarPlantaPorId")
    public Planta buscarPlantaPorId(@WebParam(name = "idPlanta") int idPlanta) {
        PlantaService ps = FabricaService.getPlantaService();
        return ps.buscarPorId(idPlanta);
    }

    /**
     * Operação de Web service
     *
     * @param idUsuario
     * @return
     */
    @WebMethod(operationName = "todasPlantaPorUsuario")
    public List<Planta> todasPlantaPorUsuario(@WebParam(name = "idUsuario") int idUsuario) {
        PlantaService ps = FabricaService.getPlantaService();
        return ps.todosPorUsuario(idUsuario);
    }

    /**
     * Operação de Web service
     *
     * @param planta
     * @return
     */
    @WebMethod(operationName = "editarPlanta")
    public boolean editarPlanta(@WebParam(name = "planta") Planta planta) {
        PlantaService ps = FabricaService.getPlantaService();
        return ps.editar(planta);
    }

    /**
     * Operação de Web service
     *
     * @param idPlanta
     * @return
     */
    @WebMethod(operationName = "deletarPlanta")
    public boolean deletarPlanta(@WebParam(name = "idPlanta") int idPlanta) {
        PlantaService ps = FabricaService.getPlantaService();
        return ps.deletar(idPlanta);
    }

    /**
     * Operação de Web service
     *
     * @param leitura
     * @return
     */
    @WebMethod(operationName = "cadastrarLeitura")
    public int cadastrarLeitura(@WebParam(name = "leitura") Leitura leitura) {
        LeituraService ls = FabricaService.getLeituraService();
        return ls.cadastrar(leitura);
    }

    /**
     * Operação de Web service
     *
     * @param idPlanta
     * @return
     */
    @WebMethod(operationName = "todasLeituraPorPlanta")
    public List<Leitura> todasLeituraPorPlanta(@WebParam(name = "idPlanta") int idPlanta) {
        LeituraService ls = FabricaService.getLeituraService();
        return ls.todosPorPlanta(idPlanta);
    }

    /**
     * Operação de Web service
     *
     * @return
     */
    @WebMethod(operationName = "todosUsuario")
    public List<Usuario> todosUsuario() {
        UsuarioService us = FabricaService.getUsuarioService();
        return us.todos();
    }
}
