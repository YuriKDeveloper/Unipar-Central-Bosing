/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.model;

/**
 *
 * @author yuriz
 */
public class PessoaJuridicaPOJO {
    private String razaoSocial;
    private String cnpj;
    private String cnaePrincipal;
    private String fantasia;
    private PessoaPOJO pessoa;

    public PessoaJuridicaPOJO() {
    }

    public PessoaJuridicaPOJO(String razaoSocial, String cnpj, String cnaePrincipal, String fantasia, PessoaPOJO pessoa) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cnaePrincipal = cnaePrincipal;
        this.fantasia = fantasia;
        this.pessoa = pessoa;
    }

    public PessoaPOJO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaPOJO pessoa) {
        this.pessoa = pessoa;
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

    public String getCnaePrincipal() {
        return cnaePrincipal;
    }

    public void setCnaePrincipal(String cnaePrincipal) {
        this.cnaePrincipal = cnaePrincipal;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    @Override
    public String toString() {
        return "\nPessoaJuridica{" + "razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", cnaePrincipal=" + cnaePrincipal + ", fantasia=" + fantasia + '}';
    }
    
    
}
