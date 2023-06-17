/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.auxiliares;

import br.unipar.central.model.AgenciaPOJO;
import br.unipar.central.model.Interfaces.SQLCom;
import br.unipar.central.model.PessoaPOJO;
import br.unipar.central.model.TelefonePOJO;
import br.unipar.central.model.enums.TipoOperadoraEnum;
import br.unipar.central.services.TelefoneServices;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author yuriz
 */
public class TelefoneAuxiliar implements SQLCom {
    
          @Override
          public String insert() {
        
    try {
        TelefonePOJO telefone = new TelefonePOJO();
        String input;

        input = JOptionPane.showInputDialog("Insira o id do telefone: ");
        telefone.setId_telefone(Integer.parseInt(input));
        
        input = JOptionPane.showInputDialog("Informe o numero do telefone: ");
        telefone.setNumero(input);

        AgenciaPOJO agenciaPOJO = new AgenciaPOJO();
        agenciaPOJO.setId(Integer.parseInt(JOptionPane.showInputDialog("Insira o id de agência:")));
        telefone.setAgencia(agenciaPOJO);
        
        PessoaPOJO pessoaPOJO = new PessoaPOJO();
        pessoaPOJO.setId(Integer.parseInt(JOptionPane.showInputDialog("Insira o id de pessoa:")));
        telefone.setPessoa(pessoaPOJO);
        
                     String TipoOperadora = JOptionPane.showInputDialog(("Informe a operadora (1 - TIM, 2 - CLARO, 3 - VIVO, 4 - OI, 5 - CORREIOS, 6 - LARICELL, 7 - TESLA, 8 - IPHONE, 9 - OUTROS): "));
            TipoOperadoraEnum tipoOp;

            switch (TipoOperadora) {
                case "1":
                    tipoOp = TipoOperadoraEnum.TIM;
                    break;
                case "2":
                    tipoOp = TipoOperadoraEnum.CLARO;
                    break;
                case "3":
                    tipoOp = TipoOperadoraEnum.VIVO;
                    break;
                case "4":
                    tipoOp = TipoOperadoraEnum.OI;
                    break;
                case "5":
                    tipoOp = TipoOperadoraEnum.NEXTEL;
                    break;
                case "6":
                    tipoOp = TipoOperadoraEnum.ALGARTELECOM;
                    break;
                case "7":
                    tipoOp = TipoOperadoraEnum.SERCOMTEL;
                    break;
                case "8":
                    tipoOp = TipoOperadoraEnum.CORREIOSCELULAR;
                    break;
                case "11":
                    tipoOp = TipoOperadoraEnum.NUMERO11;
                    break;
                case "21":
                    tipoOp = TipoOperadoraEnum.NUMERO21;
                    break;
                case "34":
                    tipoOp = TipoOperadoraEnum.NUMERO34;
                    break;
                case "44":
                    tipoOp = TipoOperadoraEnum.NUMERO44;
                    break;
                case "45":
                    tipoOp = TipoOperadoraEnum.NUMERO45;
                    break;
                default:
                    tipoOp = null;
                    break;
            }
            telefone.setOperadora(tipoOp);

        input = JOptionPane.showInputDialog("Informe o ra: ");
        telefone.setRegistroAcademico(input);


        TelefoneServices telefoneServices = new TelefoneServices();
        telefoneServices.insert(telefone);
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
            TelefoneServices telefoneServices = new TelefoneServices();
            List<TelefonePOJO> paises = telefoneServices.findAll();

            // Criação do JTextArea para exibir o conteúdo
            JTextArea textArea = new JTextArea(20, 30);
            textArea.setEditable(false);

            // Construção do conteúdo a ser exibido
            StringBuilder content = new StringBuilder();
            content.append("Todos os itens encontrados:\n");
            for (TelefonePOJO pais : paises) {
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
        TelefoneServices telefoneServices = new TelefoneServices();
        TelefonePOJO telefone = new TelefonePOJO();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID:"));
        telefone.setId_telefone(id);
        String msg = "Item encontrado: " + telefoneServices.findById(telefone.getId_telefone());
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

        TelefoneServices telefoneServices = new TelefoneServices();
        telefoneServices.delete(id);
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
        TelefonePOJO telefone = new TelefonePOJO();

        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id de pessoa:"));
        telefone.setId_telefone(id);
        
        telefone.setNumero(JOptionPane.showInputDialog("Insira o numero de telefone:"));
        
                  String TipoOperadora = JOptionPane.showInputDialog(("Informe a operadora (1 - TIM, 2 - CLARO, 3 - VIVO, 4 - OI, 5 - NEXTEL, 6 - ALGARTELECOM, 7 - SERCOMTEL, 8 - CORREIOSCELULAR): "));
            TipoOperadoraEnum tipoOp;

            switch (TipoOperadora) {
                case "1":
                    tipoOp = TipoOperadoraEnum.TIM;
                    break;
                case "2":
                    tipoOp = TipoOperadoraEnum.CLARO;
                    break;
                case "3":
                    tipoOp = TipoOperadoraEnum.VIVO;
                    break;
                case "4":
                    tipoOp = TipoOperadoraEnum.OI;
                    break;
                case "5":
                    tipoOp = TipoOperadoraEnum.NEXTEL;
                    break;
                case "6":
                    tipoOp = TipoOperadoraEnum.ALGARTELECOM;
                    break;
                case "7":
                    tipoOp = TipoOperadoraEnum.SERCOMTEL;
                    break;
                case "8":
                    tipoOp = TipoOperadoraEnum.CORREIOSCELULAR;
                    break;
                case "11":
                    tipoOp = TipoOperadoraEnum.NUMERO11;
                    break;
                case "21":
                    tipoOp = TipoOperadoraEnum.NUMERO21;
                    break;
                case "34":
                    tipoOp = TipoOperadoraEnum.NUMERO34;
                    break;
                case "44":
                    tipoOp = TipoOperadoraEnum.NUMERO44;
                    break;
                case "45":
                    tipoOp = TipoOperadoraEnum.NUMERO45;
                    break;
                default:
                    tipoOp = null;
                    break;
            }
            telefone.setOperadora(tipoOp);
        
        AgenciaPOJO agenciaPOJO = new AgenciaPOJO();
        agenciaPOJO.setId(Integer.parseInt(JOptionPane.showInputDialog("Insira o id de agência:")));
        telefone.setAgencia(agenciaPOJO);
        
        PessoaPOJO pessoaPOJO = new PessoaPOJO();
        pessoaPOJO.setId(Integer.parseInt(JOptionPane.showInputDialog("Insira o id de pessoa:")));
        telefone.setPessoa(pessoaPOJO);
     
        
        telefone.setRegistroAcademico(JOptionPane.showInputDialog("Insira o ra:"));

        TelefoneServices pessoaService = new TelefoneServices();
        pessoaService.update(telefone);
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
