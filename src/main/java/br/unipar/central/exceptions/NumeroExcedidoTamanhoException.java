/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.exceptions;

/**
 *
 * @author yuriz
 */
public class NumeroExcedidoTamanhoException extends Exception {
    public NumeroExcedidoTamanhoException(String campo, int tamanho){
        super("O Campo " + campo+ " foi informado com tamanho " + tamanho + " caracteres)" + " Invalido. Verifique");
    }
}
