/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.auxiliares;

import br.unipar.central.model.AgenciaPOJO;
import br.unipar.central.model.BancoPOJO;
import br.unipar.central.model.Interfaces.SQLCom;
import br.unipar.central.services.AgenciaServices;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author yuriz
 */
public class AgenciaAuxiliar implements SQLCom {
    
          @Override
          public String insert() {
        
    try {
        
        AgenciaPOJO agencia = new AgenciaPOJO();
        String input;

        input = JOptionPane.showInputDialog("Insira o id de banco: ");
        agencia.setId(Integer.parseInt(input));

        input = JOptionPane.showInputDialog("Insira o cnpj da agência: ");
        agencia.setCnpj(input);
        
        input = JOptionPane.showInputDialog("Insira o digito da agência: ");
        agencia.setDigito(input);
        
        input = JOptionPane.showInputDialog("Insira o codigo da agência: ");
        agencia.setCodigo(input);
        
        input = JOptionPane.showInputDialog("Insira a razão social da agência: ");
        agencia.setRazaoSocial(input);

        input = JOptionPane.showInputDialog("Informe o ra: ");
        agencia.setRegistroAcademico(input);
        
        BancoPOJO bancoPOJO = new BancoPOJO();
        bancoPOJO.setId(Integer.parseInt(JOptionPane.showInputDialog("Informe o nome id do banco:")));
        agencia.setBanco(bancoPOJO);


        AgenciaServices agenciaServices = new AgenciaServices();
        agenciaServices.insert(agencia);
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
            AgenciaServices agenciaServices = new AgenciaServices();
            List<AgenciaPOJO> agencias = agenciaServices.findAll();

            // Criação do JTextArea para exibir o conteúdo
            JTextArea textArea = new JTextArea(20, 30);
            textArea.setEditable(false);

            // Construção do conteúdo a ser exibido
            StringBuilder content = new StringBuilder();
            content.append("Todos os itens encontrados:\n");
            for (AgenciaPOJO agencia : agencias ) {
                content.append(agencia.toString()).append("\n");
            }
            textArea.setText(content.toString());

            // Criação do JScrollPane para adicionar a funcionalidade de rolagem
            JScrollPane scrollPane = new JScrollPane(textArea);

            // Exibe o JOptionPane com o JTextArea dentro do JScrollPane
            JOptionPane.showMessageDialog(null, scrollPane, "Lista de Agências", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            String msg = "Erro ao realizar a busca por todos os itens: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
        }
            return null;
        
    }

          @Override
          public String findById() {
    try {
        AgenciaServices agenciaServices = new AgenciaServices();
        AgenciaPOJO banco = new AgenciaPOJO();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID:"));
        banco.setId(id);
        String msg = "Item encontrado: " + agenciaServices.findById(banco.getId());
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
        String idStr = JOptionPane.showInputDialog("Informe o ID de banco:");
        int id = Integer.parseInt(idStr);

        AgenciaServices AgenciaServices = new AgenciaServices();
        AgenciaServices.delete(id);
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
        AgenciaPOJO agencia = new AgenciaPOJO();

        int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id de banco:"));
        agencia.setId(id);
        
        agencia.setCnpj(JOptionPane.showInputDialog("Informe o nome do cnpj da agência:"));
        
        agencia.setCodigo(JOptionPane.showInputDialog("Informe o nome do codigo da agência:"));
        
        agencia.setDigito(JOptionPane.showInputDialog("Informe o numero do digito da agência:"));
         
        BancoPOJO bancoPOJO = new BancoPOJO();
        bancoPOJO.setId(Integer.parseInt(JOptionPane.showInputDialog("Informe o nome id do banco:")));
        agencia.setBanco(bancoPOJO);
        
        agencia.setRegistroAcademico(JOptionPane.showInputDialog("Informe o ra:"));
        
        agencia.setRazaoSocial(JOptionPane.showInputDialog("Informe a razão social da agência:"));

        AgenciaServices AgenciaServices = new AgenciaServices();
        AgenciaServices.update(agencia);
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
