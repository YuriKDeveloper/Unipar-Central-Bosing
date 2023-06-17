/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.model;

import br.unipar.central.model.abstracts.RaAbstrato;
import br.unipar.central.model.enums.TipoContaEnum;

/**
 *
 * @author yuriz
 */
public class ContaPOJO extends RaAbstrato {
    
     private int id_conta;
    private String numero;
    private String digito;
    private double saldo;
    private TipoContaEnum tipoConta;
    private String ra;
    private AgenciaPOJO agencia;
    private PessoaPOJO pessoa;

    public ContaPOJO() {
    }

    public int getId() {
        return id_conta;
    }

    public void setId(int id) {
        this.id_conta = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public TipoContaEnum getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoContaEnum tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
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

    @Override
    public String toString() {
        return "\nContaPOJO{" + "id=" + id_conta + ", numero=" + numero + ", digito=" + digito + ", saldo=" + saldo + ", tipoConta=" + tipoConta + ", ra=" + ra + ", agencia=" + agencia + ", pessoa=" + pessoa + '}';
    }
    
    
}   
