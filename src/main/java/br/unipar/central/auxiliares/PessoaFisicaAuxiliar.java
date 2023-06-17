/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.auxiliares;

import br.unipar.central.model.Interfaces.SQLCom;
import br.unipar.central.model.PessoaFisicaPOJO;
import br.unipar.central.model.PessoaPOJO;
import br.unipar.central.services.PessoaFisicaServices;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author yuriz
 */
public class PessoaFisicaAuxiliar implements SQLCom {
    
     @Override
      public String insert() {
        
    try {
        PessoaFisicaPOJO pessoa = new PessoaFisicaPOJO();
        String input;

        input = JOptionPane.showInputDialog("Insira o cpf da pessoa: ");
        pessoa.setCpf(input);

        input = JOptionPane.showInputDialog("Insira o nome da pessoa: ");
        pessoa.setNome(input);

        input = JOptionPane.showInputDialog("Insira o rg da pessoa: ");
        pessoa.setRg(input);
        
        int day = Integer.parseInt(JOptionPane.showInputDialog("Informe o dia em que a pessoa nasceu:"));
        int month = Integer.parseInt(JOptionPane.showInputDialog("Informe o mês em que a pessoa nasceu:"));
        int year = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano em que a pessoa nasceu:"));

        Date dataNascimento = new Date(year - 1900, month - 1, day);
        pessoa.setDatanascimento(dataNascimento);
        
        input = JOptionPane.showInputDialog("insira o id da pessoa: ");
        PessoaPOJO pessoaPOJO = new PessoaPOJO();
        pessoaPOJO.setId(Integer.parseInt(input));
        pessoa.setPessoa(pessoaPOJO);
        
        
        PessoaFisicaServices pessoaService = new PessoaFisicaServices();
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
            PessoaFisicaServices pessoaFisicaServices = new PessoaFisicaServices();
            List<PessoaFisicaPOJO> pessoas = pessoaFisicaServices.findAll();

            // Criação do JTextArea para exibir o conteúdo
            JTextArea textArea = new JTextArea(20, 50);
            textArea.setEditable(false);

            // Construção do conteúdo a ser exibido
            StringBuilder content = new StringBuilder();
            content.append("Todos os itens encontrados:\n");
            for (PessoaFisicaPOJO pessoa : pessoas) {
                content.append(pessoa.toString()).append("\n");
            }
            textArea.setText(content.toString());

            // Criação do JScrollPane para adicionar a funcionalidade de rolagem
            JScrollPane scrollPane = new JScrollPane(textArea);

            // Exibe o JOptionPane com o JTextArea dentro do JScrollPane
            JOptionPane.showMessageDialog(null, scrollPane, "Lista de Pessoas Fisicas", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            String msg = "Erro ao realizar a busca por todos os itens: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
        }
            return null;
        
    }

      @Override
      public String findById() {
    try {
        PessoaFisicaServices pessoaService = new PessoaFisicaServices();
        PessoaFisicaPOJO pessoa = new PessoaFisicaPOJO();
        String cpf = JOptionPane.showInputDialog("Insira o ID:");
        pessoa.setCpf(cpf);
        String msg = "Item encontrado: " + pessoaService.findById(pessoa.getCpf());
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
        String cpf = JOptionPane.showInputDialog("Informe o cpf da pessoa:");

        PessoaFisicaServices pessoaService = new PessoaFisicaServices();
        pessoaService.delete(cpf);
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
        PessoaFisicaPOJO pessoa = new PessoaFisicaPOJO();

        String id = JOptionPane.showInputDialog("Insira o id de pessoa:");
        pessoa.setCpf(id);
        
        pessoa.setNome(JOptionPane.showInputDialog("Insira o nome da pessoa fisica:"));
        
        pessoa.setRg(JOptionPane.showInputDialog("Insira o rg da pessoa fisica:"));
        
        int day = Integer.parseInt(JOptionPane.showInputDialog("Informe o dia em que a pessoa nasceu:"));
        int month = Integer.parseInt(JOptionPane.showInputDialog("Informe o mês em que a pessoa nasceu:"));
        int year = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano em que a pessoa nasceu:"));

        Date dataNascimento = new Date(year - 1900, month - 1, day);
        pessoa.setDatanascimento(dataNascimento);
        
        String input = JOptionPane.showInputDialog("insira o id da pessoa: ");
        PessoaPOJO pessoaPOJO = new PessoaPOJO();
        pessoaPOJO.setId(Integer.parseInt(input));
        pessoa.setPessoa(pessoaPOJO);
        
        
        PessoaFisicaServices pessoaService = new PessoaFisicaServices();
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
