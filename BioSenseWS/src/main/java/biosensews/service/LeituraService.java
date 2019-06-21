/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.service;

import biosensews.model.Leitura;
import java.util.List;

/**
 *
 * @author Lucas Leandro
 */
public interface LeituraService {

    public int cadastrar(Leitura Leitura);

    public List<Leitura> todosPorPlanta(int idPlanta);
}
