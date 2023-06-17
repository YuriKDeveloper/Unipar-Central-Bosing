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
public class BancoPOJO extends RaAbstrato {
    
    private int id_banco;
    private String nome;

    public BancoPOJO() {
    }

    public BancoPOJO(int id, String nome) {
        this.id_banco = id;
        this.nome = nome;
    }

    public int getId() {
        return id_banco;
    }

    public void setId(int id) {
        this.id_banco = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "\nBancoPOJO{" + "id=" + id_banco + ", nome=" + nome + '}';
    }
    
    
}
