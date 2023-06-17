/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.auxiliares;

import br.unipar.central.model.EstadoPOJO;
import br.unipar.central.model.Interfaces.SQLCom;
import br.unipar.central.model.PaisPOJO;
import br.unipar.central.services.EstadoServices;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author yuriz
 */
public class EstadoAuxiliar implements SQLCom {
    
         @Override
         public String insert() {
        
    try {
        EstadoPOJO estado = new EstadoPOJO();
        String input;

        input = JOptionPane.showInputDialog("Insira o id de estado: ");
        estado.setId_estado(Integer.parseInt(input));

        input = JOptionPane.showInputDialog("Insira o nome do estado: ");
        estado.setNome(input);
        
        input = JOptionPane.showInputDialog("Insira a sigla do estado: ");
        estado.setNome(input);
   
        PaisPOJO paisPOJO = new PaisPOJO();
        paisPOJO.setId_pais(Integer.parseInt(JOptionPane.showInputDialog("Informe o id do pais:")));
        estado.setPais(paisPOJO);
        
        input = JOptionPane.showInputDialog("Informe o ra: ");
        estado.setRegistroAcademico(input);


        EstadoServices estadoService = new EstadoServices();
        estadoService.insert(estado);
        String msg = "Dados inserido com sucesso";
        JOptionPane.showMessageDialog(null, msg);
        return msg;
        
    } catch (Exception ex) {
        String msg = "Erro ao inserir dados " + ex.getMessage();
        JOptionPane.showMessageDialog(null, msg);
        return msg;
    }
    
    
  }
  
         @Override
    public String findAll() {
        try {
            EstadoServices estadoServices = new EstadoServices();
            List<EstadoPOJO> estados = estadoServices.findAll();

            // Criação do JTextArea para exibir o conteúdo
            JTextArea textArea = new JTextArea(20, 30);
            textArea.setEditable(false);

            // Construção do conteúdo a ser exibido
            StringBuilder content = new StringBuilder();
            content.append("Todos os itens encontrados:\n");
            for (EstadoPOJO estado : estados ) {
                content.append(estado.toString()).append("\n");
            }
            textArea.setText(content.toString());

            // Criação do JScrollPane para adicionar a funcionalidade de rolagem
            JScrollPane scrollPane = new JScrollPane(textArea);

            // Exibe o JOptionPane com o JTextArea dentro do JScrollPane
            JOptionPane.showMessageDialog(null, scrollPane, "Lista de Países", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            String msg = "Erro ao realizar a busca por todos os itens: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
        }
            return null;
        
    }

         @Override
         public String findById() {
    try {
        EstadoServices estadoService = new EstadoServices();
        EstadoPOJO estado = new EstadoPOJO();
        String idStr = JOptionPane.showInputDialog("Informe o ID:");
        int id = Integer.parseInt(idStr);
        estado.setId_estado(id);
        String msg = "Item encontrado: " + estadoService.findById(estado.getId_estado());
        JOptionPane.showMessageDialog(null, msg);
        return msg;
    } catch (Exception ex) {
        String msg = "Erro ao tentar excluir o item por ID: " + ex.getMessage();
        JOptionPane.showMessageDialog(null, msg);
        return msg;
    }
}

         @Override
         public String delete() {
    try {
        String idStr = JOptionPane.showInputDialog("Informe o ID de estado:");
        int id = Integer.parseInt(idStr);

        EstadoServices estadoService = new EstadoServices();
        estadoService.delete(id);
        String msg = "Item deletado com sucesso";
        JOptionPane.showMessageDialog(null, msg);
        return msg;
    } catch (Exception ex) {
        String msg = "Erro ao deletar o item por ID: " + ex.getMessage();
        JOptionPane.showMessageDialog(null, msg);
        return msg;
    }
}

         @Override
         public String update() {
    try {
        EstadoPOJO estado = new EstadoPOJO();

        int id = Integer.parseInt(JOptionPane.showInputDialog("insira o id de estado:"));
        estado.setId_estado(id);
        
        estado.setNome(JOptionPane.showInputDialog("insira o nome do estado:"));
        
        PaisPOJO paisPOJO = new PaisPOJO();
        paisPOJO.setId_pais(Integer.parseInt(JOptionPane.showInputDialog("Informe o id do pais:")));
        estado.setPais(paisPOJO);
        
        estado.setSigla(JOptionPane.showInputDialog("insira a sigla do estado:"));
        
        estado.setRegistroAcademico(JOptionPane.showInputDialog("insira o ra:"));

        EstadoServices estadoService = new EstadoServices();
        estadoService.update(estado);
        String msg = "Update realizado com sucesso";
        JOptionPane.showMessageDialog(null, msg);
        return msg;
    } catch (Exception ex) {
        String msg = "Erro ao realizar o update: " + ex.getMessage();
        JOptionPane.showMessageDialog(null, msg);
        return msg;
    }
}
}
