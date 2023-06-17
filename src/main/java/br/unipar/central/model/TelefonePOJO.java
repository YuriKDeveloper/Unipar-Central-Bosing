/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.model;

import br.unipar.central.model.abstracts.RaAbstrato;
import br.unipar.central.model.enums.TipoOperadoraEnum;

/**
 *
 * @author yuriz
 */
public class TelefonePOJO extends RaAbstrato {
    private int id_telefone;
    private String numero;
    private TipoOperadoraEnum operadora;
    private AgenciaPOJO agencia;
    private PessoaPOJO pessoa;

    public TelefonePOJO() {
    }

    public TelefonePOJO(int id_telefone, String numero, TipoOperadoraEnum operadora, AgenciaPOJO agencia, PessoaPOJO pessoa) {
        this.id_telefone = id_telefone;
        this.numero = numero;
        this.operadora = operadora;
        this.agencia = agencia;
        this.pessoa = pessoa;
    }

    public AgenciaPOJO getAgencia() {
        return agencia;
    }

    public void setAgencia(AgenciaPOJO agencia) {
        this.agencia = agencia;
    }

    public PessoaPOJO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaPOJO pessoa) {
        this.pessoa = pessoa;
    }

    

    public int getId_telefone() {
        return id_telefone;
    }

    public void setId_telefone(int id_telefone) {
        this.id_telefone = id_telefone;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoOperadoraEnum getOperadora() {
        return operadora;
    }

    public void setOperadora(TipoOperadoraEnum operadora) {
        this.operadora = operadora;
    }

    @Override
    public String toString() {
        return "\nTelefone{" + "id_telefone=" + id_telefone + ", numero=" + numero + ", operadora=" + operadora + '}';
    }
    
    
}
