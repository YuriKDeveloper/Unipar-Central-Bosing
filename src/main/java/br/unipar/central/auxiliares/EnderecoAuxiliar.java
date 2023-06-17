/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.auxiliares;

import br.unipar.central.model.*;
import br.unipar.central.model.Interfaces.SQLCom;
import br.unipar.central.reposiitories.*;
import br.unipar.central.services.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EnderecoAuxiliar implements SQLCom {
    @Override
    public String insert() {
        
    try {
        EnderecoPOJO endereco = new EnderecoPOJO();
        String input;

        input = JOptionPane.showInputDialog("Insira o id de endereco: ");
        endereco.setId_endereco(Integer.parseInt(input));

        input = JOptionPane.showInputDialog("Insira o nome do logradouro: ");
        endereco.setLogradouro(input);

        input = JOptionPane.showInputDialog("Insira o número da casa: ");
        endereco.setNumero(input);

        input = JOptionPane.showInputDialog("Insira o bairro: ");
        endereco.setBairro(input);

        input = JOptionPane.showInputDialog("Insira o CEP: ");
        endereco.setCep(input);

        input = JOptionPane.showInputDialog("Insira o complemento: ");
        endereco.setComplemento(input);

        input = JOptionPane.showInputDialog("insira o ra: ");
        endereco.setRegistroAcademico(input);

        input = JOptionPane.showInputDialog("insira o id de pessoa: ");
        PessoaPOJO pessoaPOJO = new PessoaPOJO();
        pessoaPOJO.setId(Integer.parseInt(input));
        endereco.setPessoa(pessoaPOJO);

        input = JOptionPane.showInputDialog("insira o id da cidade: ");
        CidadePOJO cidadePOJO = new CidadePOJO();
        cidadePOJO.setId_cidade(Integer.parseInt(input));
        endereco.setCidade(cidadePOJO);

        EnderecoServices enderecoService = new EnderecoServices();
        enderecoService.insert(endereco);
        String msg = "Dados inseridos com sucesso";
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
            EnderecoServices enderecoServices = new EnderecoServices();
            List<EnderecoPOJO> enderecos = enderecoServices.findAll();

            // Criação do JTextArea para exibir o conteúdo
            JTextArea textArea = new JTextArea(20, 30);
            textArea.setEditable(false);

            // Construção do conteúdo a ser exibido
            StringBuilder content = new StringBuilder();
            content.append("Todos os itens encontrados:\n");
            for (EnderecoPOJO endereco : enderecos ) {
                content.append(endereco.toString()).append("\n");
            }
            textArea.setText(content.toString());

            // Criação do JScrollPane para adicionar a funcionalidade de rolagem
            JScrollPane scrollPane = new JScrollPane(textArea);

            // Exibe o JOptionPane com o JTextArea dentro do JScrollPane
            JOptionPane.showMessageDialog(null, scrollPane, "Lista de Endereços", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            String msg = "Erro ao realizar a busca por todos os itens: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
        }
            return null;
        
    }

    @Override
    public String findById() {
    try {
        EnderecoServices enderecoService = new EnderecoServices();
        EnderecoPOJO endereco = new EnderecoPOJO();
        String idStr = JOptionPane.showInputDialog("Informe o ID:");
        int id = Integer.parseInt(idStr);
        endereco.setId_endereco(id);
        String msg = "Item encontrado: " + enderecoService.findById(endereco.getId_endereco());
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
        String idStr = JOptionPane.showInputDialog("Informe o ID de endereco:");
        int id = Integer.parseInt(idStr);

        EnderecoServices enderecoService = new EnderecoServices();
        enderecoService.delete(id);
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
        EnderecoPOJO endereco = new EnderecoPOJO();

        String idStr = JOptionPane.showInputDialog("insira o id de endereco:");
        int id = Integer.parseInt(idStr);
        endereco.setId_endereco(id);

        endereco.setLogradouro(JOptionPane.showInputDialog("insira o nome da rua:"));
        endereco.setNumero(JOptionPane.showInputDialog("insira o número da casa:"));
        endereco.setBairro(JOptionPane.showInputDialog("insira o bairro:"));
        endereco.setCep(JOptionPane.showInputDialog("insira o cep:"));
        endereco.setComplemento(JOptionPane.showInputDialog("insira o complemento:"));

        String ra = JOptionPane.showInputDialog("insira o ra:");
        endereco.setRegistroAcademico(ra);

        String pessoaIdStr = JOptionPane.showInputDialog("insira o id de pessoa:");
        int pessoaId = Integer.parseInt(pessoaIdStr);
        PessoaPOJO pessoaPOJO = new PessoaPOJO();
        pessoaPOJO.setId(pessoaId);
        endereco.setPessoa(pessoaPOJO);

        String cidadeIdStr = JOptionPane.showInputDialog("insira o id da cidade:");
        int cidadeId = Integer.parseInt(cidadeIdStr);
        CidadePOJO cidadePOJO = new CidadePOJO();
        cidadePOJO.setId_cidade(cidadeId);
        endereco.setCidade(cidadePOJO);

        EnderecoServices enderecoService = new EnderecoServices();
        enderecoService.update(endereco);
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
