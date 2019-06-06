/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosensews.model;

/**
 *
 * @author Lucas Leandro
 */
public class TipoPlanta {
    
    private int Id;
    private String Nome;
    private int TempoColheita;
    private Float SoloIdeal;
    private Float IrrigacaoIdeal;
    private Float PhIdeal;
    private Float TemperaturaIdeal;
    private Float UmidadeIdeal;

    public TipoPlanta(int Id, String Nome, int TempoColheita, Float SoloIdeal, Float IrrigacaoIdeal, Float PhIdeal, Float TemperaturaIdeal, Float UmidadeIdeal) {
        this.Id = Id;
        this.Nome = Nome;
        this.TempoColheita = TempoColheita;
        this.SoloIdeal = SoloIdeal;
        this.IrrigacaoIdeal = IrrigacaoIdeal;
        this.PhIdeal = PhIdeal;
        this.TemperaturaIdeal = TemperaturaIdeal;
        this.UmidadeIdeal = UmidadeIdeal;
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

    public int getTempoColheita() {
        return TempoColheita;
    }

    public void setTempoColheita(int TempoColheita) {
        this.TempoColheita = TempoColheita;
    }

    public Float getSoloIdeal() {
        return SoloIdeal;
    }

    public void setSoloIdeal(Float SoloIdeal) {
        this.SoloIdeal = SoloIdeal;
    }

    public Float getIrrigacaoIdeal() {
        return IrrigacaoIdeal;
    }

    public void setIrrigacaoIdeal(Float IrrigacaoIdeal) {
        this.IrrigacaoIdeal = IrrigacaoIdeal;
    }

    public Float getPhIdeal() {
        return PhIdeal;
    }

    public void setPhIdeal(Float PhIdeal) {
        this.PhIdeal = PhIdeal;
    }

    public Float getTemperaturaIdeal() {
        return TemperaturaIdeal;
    }

    public void setTemperaturaIdeal(Float TemperaturaIdeal) {
        this.TemperaturaIdeal = TemperaturaIdeal;
    }

    public Float getUmidadeIdeal() {
        return UmidadeIdeal;
    }

    public void setUmidadeIdeal(Float UmidadeIdeal) {
        this.UmidadeIdeal = UmidadeIdeal;
    }
}
