/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.exceptions;

/**
 *
 * @author yuriz
 */
public class ValorInformadoInvalidoException extends Exception {
     public ValorInformadoInvalidoException(String valor){
        super("O valor inserido " + valor + " é invalido");
    }
}
