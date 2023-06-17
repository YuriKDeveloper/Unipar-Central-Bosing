/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.exceptions;

/**
 *
 * @author yuriz
 */
public class DataNascimentoInvalida extends Exception {
    public DataNascimentoInvalida(String campo){
        super("a data inserida deve ser anterior a data atual:  " + campo + " Verifique!");
    }
}
