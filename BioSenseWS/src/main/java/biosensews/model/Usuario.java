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
public class Usuario {
    
    private int Id;
    private String Nome;
    private String Email;
    private String Celular;
    private String Telefone;

    public Usuario(int Id, String Nome, String Email, String Celular, String Telefone) {
        this.Id = Id;
        this.Nome = Nome;
        this.Email = Email;
        this.Celular = Celular;
        this.Telefone = Telefone;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }
}
