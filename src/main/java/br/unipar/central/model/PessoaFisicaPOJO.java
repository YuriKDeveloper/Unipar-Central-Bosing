/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.model;

import java.util.Date;

/**
 *
 * @author yuriz
 */
public class PessoaFisicaPOJO {
    private String nome;
    private String cpf;
    private String rg;
    private Date datanascimento;
    private PessoaPOJO pessoa;

    public PessoaFisicaPOJO() {
    }
    
    

    public PessoaFisicaPOJO(String nome, String cpf, String rg, Date datanascimento, PessoaPOJO pessoa) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.datanascimento = datanascimento;
        this.pessoa = pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public PessoaPOJO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaPOJO pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "\nPessoaFisica{" + "nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", datanascimento=" + datanascimento + ", pessoaFisica=" + pessoa + '}';
    }
    
    
}
