/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.auxiliares;

import br.unipar.central.model.Interfaces.SQLCom;
import br.unipar.central.model.PaisPOJO;
import br.unipar.central.services.PaisServices;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author yuriz
 */
public class PaisAuxiliar implements SQLCom {
    
        @Override
        public String insert() {
        
    try {
        PaisPOJO pais = new PaisPOJO();
        String input;

        input = JOptionPane.showInputDialog("Insira o id de pais: ");
        pais.setId_pais(Integer.parseInt(input));

        input = JOptionPane.showInputDialog("Insira o nome do pais: ");
        pais.setNome(input);

        input = JOptionPane.showInputDialog("Insira a sigla do pais: ");
        pais.setSigla(input);

        input = JOptionPane.showInputDialog("Informe o ra: ");
        pais.setRegistroAcademico(input);


        PaisServices paisService = new PaisServices();
        paisService.insert(pais);
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
            PaisServices paisService = new PaisServices();
            List<PaisPOJO> paises = paisService.findAll();

            // Criação do JTextArea para exibir o conteúdo
            JTextArea textArea = new JTextArea(20, 30);
            textArea.setEditable(false);

            // Construção do conteúdo a ser exibido
            StringBuilder content = new StringBuilder();
            content.append("Todos os itens encontrados:\n");
            for (PaisPOJO pais : paises) {
                content.append(pais.toString()).append("\n");
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
        PaisServices paisService = new PaisServices();
        PaisPOJO pais = new PaisPOJO();
        String idStr = JOptionPane.showInputDialog("Insira o ID:");
        int id = Integer.parseInt(idStr);
        pais.setId_pais(id);
        String msg = "Item encontrado: " + paisService.findById(pais.getId_pais());
        JOptionPane.showMessageDialog(null, msg);
        return msg;
    } catch (Exception ex) {
        String msg = "Erro ao realizar a busca do item por ID: " + ex.getMessage();
        JOptionPane.showMessageDialog(null, msg);
        return msg;
    }
}

        @Override
        public String delete() {
    try {
        String idStr = JOptionPane.showInputDialog("Informe o ID de pais:");
        int id = Integer.parseInt(idStr);

        PaisServices paisService = new PaisServices();
        paisService.delete(id);
        String msg = "Item deletado com sucesso";
        JOptionPane.showMessageDialog(null, msg);
        return msg;
    } catch (Exception ex) {
        String msg = "Erro ao tentar excluir o item por ID: " + ex.getMessage();
        JOptionPane.showMessageDialog(null, msg);
        return msg;
    }
}

        @Override
        public String update() {
    try {
        PaisPOJO pais = new PaisPOJO();

        int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id de pais:"));
        pais.setId_pais(id);
        
        pais.setNome(JOptionPane.showInputDialog("insira o nome do pais:"));
        pais.setSigla(JOptionPane.showInputDialog("insira a sigla do pais:"));
        String ra = JOptionPane.showInputDialog("insira o ra:");
        pais.setRegistroAcademico(ra);

        PaisServices paisService = new PaisServices();
        paisService.update(pais);
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
