/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.model.enums;


   public enum TipoTransacaoEnums {
    
    PIX(1),
    DEBITO(2),
    TED(3),
    CREDITO(4);
    

    private final int numero;

    private TipoTransacaoEnums(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
    
     public static TipoTransacaoEnums paraEnum(int numero){
        for (TipoTransacaoEnums tipo : TipoTransacaoEnums.values()) {
            if(tipo.getNumero() == numero) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código inválido");
    }

   }

