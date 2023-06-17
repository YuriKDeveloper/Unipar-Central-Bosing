/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.exceptions;

/**
 *
 * @author yuriz
 */
public class EntidadeNaoPreenchidaException extends Exception {
    
    public EntidadeNaoPreenchidaException(String entidade) {
        super(entidade + " Não foi informada(o) e deve ser preenchida" + " Verifique");
    }
}
