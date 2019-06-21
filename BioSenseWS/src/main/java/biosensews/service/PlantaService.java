/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.service;

import biosensews.model.Planta;
import java.util.List;

/**
 *
 * @author Lucas Leandro
 */
public interface PlantaService {

    public int cadastrar(Planta planta);

    public Planta buscarPorId(int idPlanta);    
    
    public List<Planta> todosPorUsuario(int idUsuario);

    public boolean editar(Planta planta);
    
    public boolean deletar(int idPlanta);
}
