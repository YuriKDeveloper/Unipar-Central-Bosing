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
public class CidadePOJO extends RaAbstrato {
    private int id_cidade;
    private String nome;
    private EstadoPOJO estado;

    public CidadePOJO() {
    }

    public CidadePOJO(int id_cidade, String nome, EstadoPOJO estado) {
        this.id_cidade = id_cidade;
        this.nome = nome;
        this.estado = estado;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstadoPOJO getEstado() {
        return estado;
    }

    public void setEstado(EstadoPOJO estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "\nCidade{" + "id_estado=" + id_cidade + ", nome=" + nome + ", estado=" + estado + '}';
    }
    
    
}
