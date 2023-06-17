/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unipar.central.model.Interfaces;

/**
 *
 * @author yuriz
 */
public interface SQLCom {
    
    String insert();
    String delete();
    String findById();
    String findAll();
    String update();
}
