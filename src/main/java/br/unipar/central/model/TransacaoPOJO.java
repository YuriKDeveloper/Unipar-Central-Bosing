/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.model;

import br.unipar.central.model.abstracts.RaAbstrato;
import br.unipar.central.model.enums.TipoTransacaoEnums;
import java.sql.Timestamp;

/**
 *
 * @author yuriz
 */
public class TransacaoPOJO extends RaAbstrato {
    private int id;
    private Timestamp dataHora;
    private double valor;
    private TipoTransacaoEnums tipo;
    private ContaPOJO contaOrigem;
    private ContaPOJO contaDestino;

    public TransacaoPOJO() {
    }

    public TransacaoPOJO(int id, Timestamp dataHora, double valor, TipoTransacaoEnums tipo, ContaPOJO contaOrigem, ContaPOJO contaDestino) {
        this.id = id;
        this.dataHora = dataHora;
        this.valor = valor;
        this.tipo = tipo;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoTransacaoEnums getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacaoEnums tipo) {
        this.tipo = tipo;
    }

    public ContaPOJO getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(ContaPOJO contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public ContaPOJO getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(ContaPOJO contaDestino) {
        this.contaDestino = contaDestino;
    }
        
    
    @Override
    public String toString() {
        return "\nTransacao{" + "id=" + id + ", dataHora=" + dataHora + ", valor=" + valor + ", tipo=" + tipo + ", contaOrigem=" + contaOrigem + ", contaDestino=" + contaDestino + '}';
    }
    
    
    
}
