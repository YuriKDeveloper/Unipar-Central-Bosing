/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.auxiliares;

import br.unipar.central.model.Interfaces.SQLCom;
import br.unipar.central.model.PessoaPOJO;
import br.unipar.central.services.PessoaServices;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author yuriz
 */
public class PessoaAuxiliar implements SQLCom {
    
      @Override
      public String insert() {
        
    try {
        PessoaPOJO pessoa = new PessoaPOJO();
        String input;

        input = JOptionPane.showInputDialog("Insira o id da pessoa: ");
        pessoa.setId(Integer.parseInt(input));

        input = JOptionPane.showInputDialog("Insira o email da pessoa: ");
        pessoa.setEmail(input);

        input = JOptionPane.showInputDialog("Informe o ra: ");
        pessoa.setRegistroAcademico(input);


        PessoaServices pessoaService = new PessoaServices();
        pessoaService.insert(pessoa);
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
            PessoaServices pessoaServices = new PessoaServices();
            List<PessoaPOJO> pessoas = pessoaServices.findAll();

            // Criação do JTextArea para exibir o conteúdo
            JTextArea textArea = new JTextArea(20, 50);
            textArea.setEditable(false);

            // Construção do conteúdo a ser exibido
            StringBuilder content = new StringBuilder();
            content.append("Todos os itens encontrados:\n");
            for (PessoaPOJO pessoa : pessoas) {
                content.append(pessoa.toString()).append("\n");
            }
            textArea.setText(content.toString());

            // Criação do JScrollPane para adicionar a funcionalidade de rolagem
            JScrollPane scrollPane = new JScrollPane(textArea);

            // Exibe o JOptionPane com o JTextArea dentro do JScrollPane
            JOptionPane.showMessageDialog(null, scrollPane, "Lista de Pessoas", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            String msg = "Erro ao realizar a busca por todos os itens: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
        }
            return null;
        
    }

      @Override
      public String findById() {
    try {
        PessoaServices pessoaService = new PessoaServices();
        PessoaPOJO pessoa = new PessoaPOJO();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID:"));
        pessoa.setId(id);
        String msg = "Item encontrado: " + pessoaService.findById(pessoa.getId());
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
        String idStr = JOptionPane.showInputDialog("Informe o ID de pessoa:");
        int id = Integer.parseInt(idStr);

        PessoaServices pessoaService = new PessoaServices();
        pessoaService.delete(id);
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
        PessoaPOJO pessoa = new PessoaPOJO();

        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id de pessoa:"));
        pessoa.setId(id);
        
        pessoa.setEmail(JOptionPane.showInputDialog("Insira o email da pessoa:"));
        
        pessoa.setRegistroAcademico(JOptionPane.showInputDialog("Insira o ra:"));

        PessoaServices pessoaService = new PessoaServices();
        pessoaService.update(pessoa);
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
