/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosense;

import biosensews.ws.BioSenseWS;
import biosensews.ws.BioSenseWS_Service;
import biosensews.ws.Planta;
import biosensews.ws.TipoPlanta;
import biosensews.ws.Usuario;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

/**
 *
 * @author victo
 */
public class BioSense {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello Plant World");

        Planta planta = new Planta();
        Usuario usuario = new Usuario();
        usuario.setId(1);
        TipoPlanta tipoPlanta = new TipoPlanta();
        tipoPlanta.setId(1);

        try {
            planta.setDataPlantio(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
        } catch (DatatypeConfigurationException ex) {
            System.out.println(ex.getMessage());
        }

        planta.setQuantidade(25);
        planta.setUsuario(usuario);
        planta.setTipoPlanta(tipoPlanta);

        BioSenseWS_Service service = new BioSenseWS_Service();
        BioSenseWS port = service.getBioSenseWSPort();
        /*
        int idPlanta = port.cadastrarPlanta(planta);
        System.out.println(idPlanta);
        */
        
        List<Planta> plantas = port.todasPlantaPorUsuario(1);
        System.out.println(plantas.size());
    }

}
