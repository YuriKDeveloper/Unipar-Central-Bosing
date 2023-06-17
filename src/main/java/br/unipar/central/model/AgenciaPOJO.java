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
public class AgenciaPOJO extends RaAbstrato {
  private int id_agencia;
    private String codigo;
    private String digito;
    private String razaoSocial;
    private String cnpj;
    private String ra;
    private BancoPOJO banco;

    public AgenciaPOJO() {
    }

    public int getId() {
        return id_agencia;
    }

    public void setId(int id) {
        this.id_agencia = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
 
    public BancoPOJO getBanco() {
        return banco;
    }

    public void setBanco(BancoPOJO banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return "\nAgenciaPOJO{" + "id=" + id_agencia + ", codigo=" + codigo + ", digito=" + digito + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", ra=" + ra + ", banco=" + banco + '}';
    }

   
    
}
