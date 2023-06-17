/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.model.enums;

/**
 *
 * @author yuriz
 */
public enum TipoOperadoraEnum {
    
    CLARO(1),
    TIM(2),
    VIVO(3),
    OI(4),
    NEXTEL(5),
    ALGARTELECOM(6),
    SERCOMTEL(7),
    CORREIOSCELULAR(8),
    NUMERO11(11),
    NUMERO21(21),
    NUMERO34(34),
    NUMERO44(44),
    NUMERO45(45);
    
    

    private final int numero;

    private TipoOperadoraEnum(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
    
    public static TipoOperadoraEnum paraEnum(int numero){
        for (TipoOperadoraEnum tipo : TipoOperadoraEnum.values()) {
            if(tipo.getNumero() == numero) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código inválido");
    }
}
