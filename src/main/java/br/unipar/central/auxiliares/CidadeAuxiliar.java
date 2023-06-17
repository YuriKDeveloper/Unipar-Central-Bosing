/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.auxiliares;

import br.unipar.central.model.CidadePOJO;
import br.unipar.central.model.EstadoPOJO;
import br.unipar.central.model.Interfaces.SQLCom;
import br.unipar.central.services.CidadeServices;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author yuriz
 */
public class CidadeAuxiliar implements SQLCom {
    
     @Override
     public String insert() {
        
    try {
        CidadePOJO cidade = new CidadePOJO();
        String input;

        input = JOptionPane.showInputDialog("Insira o id de cidade: ");
        cidade.setId_cidade(Integer.parseInt(input));

        input = JOptionPane.showInputDialog("Insira o nome do cidade: ");
        cidade.setNome(input);
   
        EstadoPOJO estadoPOJO = new EstadoPOJO();
        estadoPOJO.setId_estado(Integer.parseInt(JOptionPane.showInputDialog("Informe o id do estado:")));
        cidade.setEstado(estadoPOJO);
        
        input = JOptionPane.showInputDialog("Informe o ra: ");
        cidade.setRegistroAcademico(input);


        CidadeServices cidadeService = new CidadeServices();
        cidadeService.insert(cidade);
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
            CidadeServices cidadeServices = new CidadeServices();
            List<CidadePOJO> cidades = cidadeServices.findAll();

            // Criação do JTextArea para exibir o conteúdo
            JTextArea textArea = new JTextArea(20, 30);
            textArea.setEditable(false);

            // Construção do conteúdo a ser exibido
            StringBuilder content = new StringBuilder();
            content.append("Todos os itens encontrados:\n");
            for (CidadePOJO cidade : cidades ) {
                content.append(cidade.toString()).append("\n");
            }
            textArea.setText(content.toString());

            // Criação do JScrollPane para adicionar a funcionalidade de rolagem
            JScrollPane scrollPane = new JScrollPane(textArea);

            // Exibe o JOptionPane com o JTextArea dentro do JScrollPane
            JOptionPane.showMessageDialog(null, scrollPane, "Lista de Cidades", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            String msg = "Erro ao realizar a busca por todos os itens: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
        }
            return null;
        
    }

     @Override
     public String findById() {
    try {
        CidadeServices cidadeService = new CidadeServices();
        CidadePOJO cidade = new CidadePOJO();
        String idStr = JOptionPane.showInputDialog("Informe o ID:");
        int id = Integer.parseInt(idStr);
        cidade.setId_cidade(id);
        String msg = "Item encontrado: " + cidadeService.findById(cidade.getId_cidade());
        JOptionPane.showMessageDialog(null, msg);
        return msg;
    } catch (Exception ex) {
        String msg = "Erro ao buscar o item por ID: " + ex.getMessage();
        JOptionPane.showMessageDialog(null, msg);
        return msg;
    }
}

     @Override
     public String delete() {
    try {
        String idStr = JOptionPane.showInputDialog("Informe o ID de cidade:");
        int id = Integer.parseInt(idStr);

        CidadeServices cidadeService = new CidadeServices();
        cidadeService.delete(id);
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
        CidadePOJO cidade = new CidadePOJO();

        int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id de cidade:"));
        cidade.setId_cidade(id);
        
        cidade.setNome(JOptionPane.showInputDialog("Informe o nome da cidade:"));
        EstadoPOJO estadoPOJO = new EstadoPOJO();
        estadoPOJO.setId_estado(Integer.parseInt(JOptionPane.showInputDialog("Informe o id do estado:")));
        cidade.setEstado(estadoPOJO);
        cidade.setRegistroAcademico(JOptionPane.showInputDialog("Informe o ra:"));

        CidadeServices cidadeService = new CidadeServices();
        cidadeService.update(cidade);
        String msg = "Update realizado com sucesso";
        JOptionPane.showMessageDialog(null, msg);
        return msg;
    } catch (Exception ex) {
        String msg = "Erro ao dar update: " + ex.getMessage();
        JOptionPane.showMessageDialog(null, msg);
        return msg;
    }
}
}
