/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.service;

import biosensews.model.TipoPlanta;
import java.util.List;

/**
 *
 * @author Lucas Leandro
 */
public interface TipoPlantaService {

    public int cadastrar(TipoPlanta tipoPlanta);

    public TipoPlanta buscar(int id);

    public List<TipoPlanta> todos();

    public boolean editar(TipoPlanta tipoPlanta);
}
