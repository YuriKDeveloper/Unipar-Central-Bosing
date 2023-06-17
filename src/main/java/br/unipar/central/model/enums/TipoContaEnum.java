/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.model.enums;

/**
 *
 * @author yuriz
 */
public enum TipoContaEnum {
    
    CORRENTE(1),
    SALARIO(2),
    POUPANCAO(3);
    
    private final int codigo;

    private TipoContaEnum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
    
     public static TipoContaEnum paraEnum(int codigo){
        for (TipoContaEnum tipo : TipoContaEnum.values()) {
            if(tipo.getCodigo() == codigo) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código inválido");
    }
}
