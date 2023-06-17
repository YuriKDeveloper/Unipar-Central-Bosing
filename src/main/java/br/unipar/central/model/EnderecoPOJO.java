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
public class EnderecoPOJO extends RaAbstrato {
    private int id_endereco;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private String complemento;
    private CidadePOJO cidade;
    private PessoaPOJO pessoa;

    public EnderecoPOJO() {
    }

    public EnderecoPOJO(int id_endereco, String logradouro, String numero, String bairro, String cep, String complemento, CidadePOJO cidade, PessoaPOJO pessoa) {
        this.id_endereco = id_endereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pessoa = pessoa;
    }

    public PessoaPOJO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaPOJO pessoa) {
        this.pessoa = pessoa;
    }

   

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public CidadePOJO getCidade() {
        return cidade;
    }

    public void setCidade(CidadePOJO cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "\nEndereco{" + "id_endereco=" + id_endereco + ", logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", cep=" + cep + ", complemento=" + complemento + ", cidade=" + cidade + '}';
    }
    
    
}
