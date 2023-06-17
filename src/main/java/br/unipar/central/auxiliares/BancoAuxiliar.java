/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.auxiliares;

import br.unipar.central.model.BancoPOJO;
import br.unipar.central.model.Interfaces.SQLCom;
import br.unipar.central.services.BancoServices;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author yuriz
 */
public class BancoAuxiliar implements SQLCom {
    
       @Override
       public String insert() {
        
    try {
        BancoPOJO banco = new BancoPOJO();
        String input;

        input = JOptionPane.showInputDialog("Insira o id de banco: ");
        banco.setId(Integer.parseInt(input));

        input = JOptionPane.showInputDialog("Insira o nome do banco: ");
        banco.setNome(input);

        input = JOptionPane.showInputDialog("Informe o ra: ");
        banco.setRegistroAcademico(input);


        BancoServices bancoService = new BancoServices();
        bancoService.insert(banco);
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
            BancoServices bancoServices = new BancoServices();
            List<BancoPOJO> bancos = bancoServices.findAll();

            // Criação do JTextArea para exibir o conteúdo
            JTextArea textArea = new JTextArea(20, 30);
            textArea.setEditable(false);

            // Construção do conteúdo a ser exibido
            StringBuilder content = new StringBuilder();
            content.append("Todos os itens encontrados:\n");
            for (BancoPOJO banco : bancos ) {
                content.append(banco.toString()).append("\n");
            }
            textArea.setText(content.toString());

            // Criação do JScrollPane para adicionar a funcionalidade de rolagem
            JScrollPane scrollPane = new JScrollPane(textArea);

            // Exibe o JOptionPane com o JTextArea dentro do JScrollPane
            JOptionPane.showMessageDialog(null, scrollPane, "Lista de Bancos", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            String msg = "Erro ao realizar a busca por todos os itens: " + ex.getMessage();
            JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
        }
            return null;
        
    }

       @Override
       public String findById() {
    try {
        BancoServices bancoService = new BancoServices();
        BancoPOJO banco = new BancoPOJO();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID:"));
        banco.setId(id);
        String msg = "Item encontrado: " + bancoService.findById(banco.getId());
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

        BancoServices bancoService = new BancoServices();
        bancoService.delete(id);
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
        BancoPOJO banco = new BancoPOJO();

        int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id de banco:"));
        banco.setId(id);
        
        banco.setNome(JOptionPane.showInputDialog("Informe o nome do banco:"));
        
        banco.setRegistroAcademico(JOptionPane.showInputDialog("Informe o ra:"));

        BancoServices bancoService = new BancoServices();
        bancoService.update(banco);
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
