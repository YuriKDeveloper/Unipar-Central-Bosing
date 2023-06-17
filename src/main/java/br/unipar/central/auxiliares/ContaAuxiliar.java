/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.auxiliares;

import br.unipar.central.model.AgenciaPOJO;
import br.unipar.central.model.Interfaces.SQLCom;
import br.unipar.central.model.ContaPOJO;
import br.unipar.central.model.PessoaPOJO;
import br.unipar.central.model.enums.TipoContaEnum;
import br.unipar.central.services.ContaServices;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author yuriz
 */
public class ContaAuxiliar implements SQLCom {
      
    
    @Override
      public String insert() {
        
    try {
        ContaPOJO conta = new ContaPOJO();
        String input;

        input = JOptionPane.showInputDialog("Insira o id da conta: ");
        conta.setId(Integer.parseInt(input));

        input = JOptionPane.showInputDialog("Insira o digito da conta: ");
        conta.setDigito(input);
        
        input = JOptionPane.showInputDialog("Insira o numero da conta: ");
        conta.setNumero(input);
        
        input = JOptionPane.showInputDialog("Insira o saldo da conta: ");
        conta.setSaldo(Double.parseDouble(input));
        
        String TipoTrasacao = JOptionPane.showInputDialog(("Informe a forma de transação (1 - Corrente, 2 - Poupança , 3 - Salário): "));
            TipoContaEnum tipoOp;

            switch (TipoTrasacao) {
                case "1":
                    tipoOp = TipoContaEnum.CORRENTE;
                    break;
                case "2":
                    tipoOp = TipoContaEnum.POUPANCAO;
                    break;
                case "3":
                    tipoOp = TipoContaEnum.SALARIO;
                    break;
                default:
                    tipoOp = null;
                    break;
            }
            conta.setTipoConta(tipoOp);
        
        

        input = JOptionPane.showInputDialog("Informe o ra: ");
        conta.setRegistroAcademico(input);
        
        input = JOptionPane.showInputDialog("insira o id de agencia: ");
        AgenciaPOJO agenciaPOJO = new AgenciaPOJO();
        agenciaPOJO.setId(Integer.parseInt(input));
        conta.setAgencia(agenciaPOJO);

        input = JOptionPane.showInputDialog("insira o id da pessoa: ");
        PessoaPOJO pessoaPOJO = new PessoaPOJO();
        pessoaPOJO.setId(Integer.parseInt(input));
        conta.setPessoa(pessoaPOJO);


        ContaServices contaService = new ContaServices();
        contaService.insert(conta);
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
            ContaServices contaServices = new ContaServices();
            List<ContaPOJO> contas = contaServices.findAll();

            // Criação do JTextArea para exibir o conteúdo
            JTextArea textArea = new JTextArea(20, 50);
            textArea.setEditable(false);

            // Construção do conteúdo a ser exibido
            StringBuilder content = new StringBuilder();
            content.append("Todos os itens encontrados:\n");
            for (ContaPOJO conta : contas) {
                content.append(conta.toString()).append("\n");
            }
            textArea.setText(content.toString());

            // Criação do JScrollPane para adicionar a funcionalidade de rolagem
            JScrollPane scrollPane = new JScrollPane(textArea);

            // Exibe o JOptionPane com o JTextArea dentro do JScrollPane
            JOptionPane.showMessageDialog(null, scrollPane, "Lista de Contas", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            String msg = "Erro ao realizar a busca por todos os itens: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
        }
            return null;
        
    }

      @Override
      public String findById() {
    try {
        ContaServices contaService = new ContaServices();
        ContaPOJO conta = new ContaPOJO();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID:"));
        conta.setId(id);
        String msg = "Item encontrado: " + contaService.findById(conta.getId());
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
        String idStr = JOptionPane.showInputDialog("Informe o ID de conta:");
        int id = Integer.parseInt(idStr);

        ContaServices contaService = new ContaServices();
        contaService.delete(id);
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
        ContaPOJO conta = new ContaPOJO();

        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id de conta:"));
        conta.setId(id);
        
        conta.setDigito(JOptionPane.showInputDialog("Insira o digito da conta:"));
        
        conta.setNumero(JOptionPane.showInputDialog("Insira o numero da conta:"));
        
        conta.setSaldo(Double.parseDouble(JOptionPane.showInputDialog("Insira o numero da conta:")));
        
        String TipoTrasacao = JOptionPane.showInputDialog(("Informe a forma de transação (1 - CREDITO, 2 - DEBITO, 3 - PIX, 4 - TED): "));
            TipoContaEnum tipoOp;

            switch (TipoTrasacao) {
                case "1":
                    tipoOp = TipoContaEnum.CORRENTE;
                    break;
                case "2":
                    tipoOp = TipoContaEnum.POUPANCAO;
                    break;
                case "3":
                    tipoOp = TipoContaEnum.SALARIO;
                    break;
                default:
                    tipoOp = null;
                    break;
            }
            conta.setTipoConta(tipoOp);
        
        
        
        String input = JOptionPane.showInputDialog("insira o id de pessoa: ");
        AgenciaPOJO agenciaPOJO = new AgenciaPOJO();
        agenciaPOJO.setId(Integer.parseInt(input));
        conta.setAgencia(agenciaPOJO);

        input = JOptionPane.showInputDialog("insira o id da cidade: ");
        PessoaPOJO cidadePOJO = new PessoaPOJO();
        cidadePOJO.setId(Integer.parseInt(input));
        conta.setPessoa(cidadePOJO);
        
        conta.setRegistroAcademico(JOptionPane.showInputDialog("Insira o ra:"));

        ContaServices contaService = new ContaServices();
        contaService.update(conta);
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
