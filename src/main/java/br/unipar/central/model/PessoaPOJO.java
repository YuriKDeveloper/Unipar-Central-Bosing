/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.model;

import br.unipar.central.model.abstracts.RaAbstrato;

/**
 *
 * @author yuriz
 */
public class PessoaPOJO extends RaAbstrato {
    private int id_pessoa;
    private String email; 


    public PessoaPOJO() {
    }

    public PessoaPOJO(int id, String email) {
        this.id_pessoa = id;
        this.email = email;
    }
    
    public int getId() {
        return id_pessoa;
    }

    public void setId(int id) {
        this.id_pessoa = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "\nPessoa{" + "id=" + id_pessoa + ", email=" + email + '}';
    }

    
    

  
}
