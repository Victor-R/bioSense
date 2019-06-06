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
public class Leitura {
    
    private int Id;
    private Planta Planta;
    private Date Data;
    private float Temperatura;
    private float Ph;
    private float Umidade;
    private float Irrigacao;
    private float Solo;

    public Leitura(int Id, Planta Planta, Date Data, float Temperatura, float Ph, float Umidade, float Irrigacao, float Solo) {
        this.Id = Id;
        this.Planta = Planta;
        this.Data = Data;
        this.Temperatura = Temperatura;
        this.Ph = Ph;
        this.Umidade = Umidade;
        this.Irrigacao = Irrigacao;
        this.Solo = Solo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Planta getPlanta() {
        return Planta;
    }

    public void setPlanta(Planta Planta) {
        this.Planta = Planta;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public float getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(float Temperatura) {
        this.Temperatura = Temperatura;
    }

    public float getPh() {
        return Ph;
    }

    public void setPh(float Ph) {
        this.Ph = Ph;
    }

    public float getUmidade() {
        return Umidade;
    }

    public void setUmidade(float Umidade) {
        this.Umidade = Umidade;
    }

    public float getIrrigacao() {
        return Irrigacao;
    }

    public void setIrrigacao(float Irrigacao) {
        this.Irrigacao = Irrigacao;
    }

    public float getSolo() {
        return Solo;
    }

    public void setSolo(float Solo) {
        this.Solo = Solo;
    }
}
