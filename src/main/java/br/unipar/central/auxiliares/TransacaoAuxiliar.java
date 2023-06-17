/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.auxiliares;

import br.unipar.central.model.ContaPOJO;
import br.unipar.central.model.Interfaces.SQLCom;
import br.unipar.central.model.TransacaoPOJO;
import br.unipar.central.model.enums.TipoTransacaoEnums;
import br.unipar.central.services.TransacaoServices;
import java.sql.Timestamp;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author yuriz
 */
public class TransacaoAuxiliar implements SQLCom {

   @Override
      public String insert() {
        
    try {
        TransacaoPOJO transacao = new TransacaoPOJO();
        String input;

        input = JOptionPane.showInputDialog("Insira o id da transacao: ");
        transacao.setId(Integer.parseInt(input));
        
        input = JOptionPane.showInputDialog("Insira o valor da transacao: ");
        transacao.setValor(Double.parseDouble(input));
        
         ContaPOJO contaPOJO = new ContaPOJO();
        contaPOJO.setId(Integer.parseInt(JOptionPane.showInputDialog("Insira o id de conta de origem:")));
        transacao.setContaOrigem(contaPOJO);
        
        contaPOJO.setId(Integer.parseInt(JOptionPane.showInputDialog("Insira o id de conta de origem:")));
        transacao.setContaDestino(contaPOJO);

        input = JOptionPane.showInputDialog("Informe o ra: ");
        transacao.setRegistroAcademico(input);
        
       
        
        String TipoTrasacao = JOptionPane.showInputDialog(("Informe a forma de transação (1 - Crédito, 2 - Débito, 3 - pix, 4 - ted): "));
            TipoTransacaoEnums tipoOp;

            switch (TipoTrasacao) {
                case "1":
                    tipoOp = TipoTransacaoEnums.CREDITO;
                    break;
                case "2":
                    tipoOp = TipoTransacaoEnums.DEBITO;
                    break;
                case "3":
                    tipoOp = TipoTransacaoEnums.PIX;
                    break;
                case "4":
                    tipoOp = TipoTransacaoEnums.TED;
                    break;    
                default:
                    tipoOp = null;
                    break;
            }
            transacao.setTipo(tipoOp);
            
            Timestamp dataHora = new Timestamp(System.currentTimeMillis() );
            transacao.setDataHora(dataHora);
        


        TransacaoServices transacaoService = new TransacaoServices();
        transacaoService.insert(transacao);
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
            TransacaoServices transacaoServices = new TransacaoServices();
            List<TransacaoPOJO> transacaos = transacaoServices.findAll();

            // Criação do JTextArea para exibir o conteúdo
            JTextArea textArea = new JTextArea(20, 50);
            textArea.setEditable(false);

            // Construção do conteúdo a ser exibido
            StringBuilder content = new StringBuilder();
            content.append("Todos os itens encontrados:\n");
            for (TransacaoPOJO transacao : transacaos) {
                content.append(transacao.toString()).append("\n");
            }
            textArea.setText(content.toString());

            // Criação do JScrollPane para adicionar a funcionalidade de rolagem
            JScrollPane scrollPane = new JScrollPane(textArea);

            // Exibe o JOptionPane com o JTextArea dentro do JScrollPane
            JOptionPane.showMessageDialog(null, scrollPane, "Lista de Transações", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            String msg = "Erro ao realizar a busca por todos os itens: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
        }
            return null;
        
    }

      @Override
      public String findById() {
    try {
        TransacaoServices transacaoService = new TransacaoServices();
        TransacaoPOJO transacao = new TransacaoPOJO();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID:"));
        transacao.setId(id);
        String msg = "Item encontrado: " + transacaoService.findById(transacao.getId());
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
        String idStr = JOptionPane.showInputDialog("Informe o ID de transacao:");
        int id = Integer.parseInt(idStr);

        TransacaoServices transacaoService = new TransacaoServices();
        transacaoService.delete(id);
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
        TransacaoPOJO transacao = new TransacaoPOJO();

        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id de transacao:"));
        transacao.setId(id);
        
        transacao.setValor(Double.parseDouble(JOptionPane.showInputDialog("Insira o email da transacao:")));
        
        transacao.setRegistroAcademico(JOptionPane.showInputDialog("Insira o ra:"));
        
         String TipoTrasacao = JOptionPane.showInputDialog(("Informe a forma de transação (1 - CREDITO, 2 - DEBITO, 3 - PIX, 4 - TED): "));
            TipoTransacaoEnums tipoOp;

            switch (TipoTrasacao) {
                case "1":
                    tipoOp = TipoTransacaoEnums.CREDITO;
                    break;
                case "2":
                    tipoOp = TipoTransacaoEnums.DEBITO;
                    break;
                case "3":
                    tipoOp = TipoTransacaoEnums.PIX;
                    break;
                case "4":
                    tipoOp = TipoTransacaoEnums.TED;
                    break;    
                default:
                    tipoOp = null;
                    break;
            }
            transacao.setTipo(tipoOp);
            
            
            
        ContaPOJO contaPOJO = new ContaPOJO();
        contaPOJO.setId(Integer.parseInt(JOptionPane.showInputDialog("Insira o id de conta de origem:")));
        transacao.setContaOrigem(contaPOJO);
        
        contaPOJO.setId(Integer.parseInt(JOptionPane.showInputDialog("Insira o id de conta de origem:")));
        transacao.setContaDestino(contaPOJO);

        TransacaoServices transacaoService = new TransacaoServices();
        transacaoService.update(transacao);
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
