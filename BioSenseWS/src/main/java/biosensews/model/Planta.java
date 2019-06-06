/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.model;

import java.util.Date;

/**
 *
 * @author Lucas Leandro
 */
public class Planta {
    
    private int Id;
    private TipoPlanta TipoPlanta;
    private Usuario Usuario;
    private Date DataPlantio;
    private int Quantidade;

    public Planta(int Id, TipoPlanta TipoPlanta, Usuario Usuario, Date DataPlantio, int Quantidade) {
        this.Id = Id;
        this.TipoPlanta = TipoPlanta;
        this.Usuario = Usuario;
        this.DataPlantio = DataPlantio;
        this.Quantidade = Quantidade;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public TipoPlanta getTipoPlanta() {
        return TipoPlanta;
    }

    public void setTipoPlanta(TipoPlanta TipoPlanta) {
        this.TipoPlanta = TipoPlanta;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public Date getDataPlantio() {
        return DataPlantio;
    }

    public void setDataPlantio(Date DataPlantio) {
        this.DataPlantio = DataPlantio;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }
}
