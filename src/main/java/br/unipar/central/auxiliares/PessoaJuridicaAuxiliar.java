/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.auxiliares;

import br.unipar.central.model.Interfaces.SQLCom;
import br.unipar.central.model.PessoaJuridicaPOJO;
import br.unipar.central.model.PessoaPOJO;
import br.unipar.central.services.PessoaJuridicaServices;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author yuriz
 */
public class PessoaJuridicaAuxiliar implements SQLCom {
    
       @Override
      public String insert() {
        
    try {
        PessoaJuridicaPOJO pessoa = new PessoaJuridicaPOJO();
        String input;

        input = JOptionPane.showInputDialog("Insira o cpf da pessoa juridica: ");
        pessoa.setCnpj(input);
        
        input = JOptionPane.showInputDialog("Insira o nome fantasia da pessoa juridica: ");
        pessoa.setFantasia(input);

        input = JOptionPane.showInputDialog("Insira o cnae da pessoa juridica: ");
        pessoa.setCnaePrincipal(input);

        input = JOptionPane.showInputDialog("Insira a razão social da pessoa juridica: ");
        pessoa.setRazaoSocial(input);
       
        input = JOptionPane.showInputDialog("insira o id da pessoa: ");
        PessoaPOJO pessoaPOJO = new PessoaPOJO();
        pessoaPOJO.setId(Integer.parseInt(input));
        pessoa.setPessoa(pessoaPOJO);
        
        
        PessoaJuridicaServices pessoaService = new PessoaJuridicaServices();
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
            PessoaJuridicaServices pessoaJuridicaServices = new PessoaJuridicaServices();
            List<PessoaJuridicaPOJO> pessoasJuridicas = pessoaJuridicaServices.findAll();

            // Criação do JTextArea para exibir o conteúdo
            JTextArea textArea = new JTextArea(20, 50);
            textArea.setEditable(false);

            // Construção do conteúdo a ser exibido
            StringBuilder content = new StringBuilder();
            content.append("Todos os itens encontrados:\n");
            for (PessoaJuridicaPOJO pessoaJuridica : pessoasJuridicas) {
                content.append(pessoaJuridica.toString()).append("\n");
            }
            textArea.setText(content.toString());

            // Criação do JScrollPane para adicionar a funcionalidade de rolagem
            JScrollPane scrollPane = new JScrollPane(textArea);

            // Exibe o JOptionPane com o JTextArea dentro do JScrollPane
            JOptionPane.showMessageDialog(null, scrollPane, "Lista de Pessoas Juridica", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            String msg = "Erro ao realizar a busca por todos os itens: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
        }
            return null;
        
    }

      @Override
      public String findById() {
    try {
        PessoaJuridicaServices pessoaJuridicaService = new PessoaJuridicaServices();
        PessoaJuridicaPOJO pessoa = new PessoaJuridicaPOJO();
        String cnpj = JOptionPane.showInputDialog("Insira o cnpj:");
        pessoa.setCnpj(cnpj);
        String msg = "Item encontrado: " + pessoaJuridicaService.findById(pessoa.getCnpj());
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
        String cnpj = JOptionPane.showInputDialog("Informe o cnpj da pessoa:");

        PessoaJuridicaServices pessoaJuridicaService = new PessoaJuridicaServices();
        pessoaJuridicaService.delete(cnpj);
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
        PessoaJuridicaPOJO pessoa = new PessoaJuridicaPOJO();

        String cnpj = JOptionPane.showInputDialog("Insira o cnpj de pessoa:");
        pessoa.setCnpj(cnpj);
        
        pessoa.setFantasia(JOptionPane.showInputDialog("Insira o nome fantasia da pessoa juridica:"));
        
        pessoa.setCnaePrincipal(JOptionPane.showInputDialog("Insira o cnae da pessoa juridica:"));
        
        pessoa.setRazaoSocial(JOptionPane.showInputDialog("Insira a razão social da pessoa juridica:"));
        
        String input = JOptionPane.showInputDialog("insira o id da pessoa: ");
        PessoaPOJO pessoaPOJO = new PessoaPOJO();
        pessoaPOJO.setId(Integer.parseInt(input));
        pessoa.setPessoa(pessoaPOJO);
        
        
        PessoaJuridicaServices pessoaJuridicaService = new PessoaJuridicaServices();
        pessoaJuridicaService.update(pessoa);
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
