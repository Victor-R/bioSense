/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosense.classes;

/**
 *
 * @author victo
 */
public class Planta {

    private int Id;
    private String Nome;
    private String TempoColheita;
    private String Solo;
    private String Irrigacao;
    private String Ph;
    private String Temperatura;
    private String Umidade;

    public Planta(int Id, String Nome, String TempoColheita, String Solo, String Irrigacao, String Ph, String Temperatura, String Umidade) {
        this.Id = Id;
        this.Nome = Nome;
        this.TempoColheita = TempoColheita;
        this.Solo = Solo;
        this.Irrigacao = Irrigacao;
        this.Ph = Ph;
        this.Temperatura = Temperatura;
        this.Umidade = Umidade;
    }

    public Planta() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getTempoColheita() {
        return TempoColheita;
    }

    public void setTempoColheita(String TempoColheita) {
        this.TempoColheita = TempoColheita;
    }

    public String getSolo() {
        return Solo;
    }

    public void setSolo(String Solo) {
        this.Solo = Solo;
    }

    public String getIrrigacao() {
        return Irrigacao;
    }

    public void setIrrigacao(String Irrigacao) {
        this.Irrigacao = Irrigacao;
    }

    public String getPh() {
        return Ph;
    }

    public void setPh(String Ph) {
        this.Ph = Ph;
    }

    public String getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(String Temperatura) {
        this.Temperatura = Temperatura;
    }

    public String getUmidade() {
        return Umidade;
    }

    public void setUmidade(String Umidade) {
        this.Umidade = Umidade;
    }

}
