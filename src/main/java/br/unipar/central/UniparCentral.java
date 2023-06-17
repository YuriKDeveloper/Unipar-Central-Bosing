package br.unipar.central;

import br.unipar.central.auxiliares.*;
import javax.swing.JOptionPane;

public class UniparCentral {

    public static void main(String[] args) {

        AgenciaAuxiliar agenciaAuxiliar = new AgenciaAuxiliar();
        BancoAuxiliar bancoAuxiliar = new BancoAuxiliar();
        CidadeAuxiliar cidadeAuxiliar = new CidadeAuxiliar();
        ContaAuxiliar contaAuxiliar = new ContaAuxiliar();
        EnderecoAuxiliar enderecoAuxiliar = new EnderecoAuxiliar();
        EstadoAuxiliar estadoAuxiliar = new EstadoAuxiliar();
        PaisAuxiliar paisAuxiliar = new PaisAuxiliar();
        PessoaAuxiliar pessoaAuxiliar = new PessoaAuxiliar();
        PessoaFisicaAuxiliar pessoaFisicaAuxiliar = new PessoaFisicaAuxiliar();
        PessoaJuridicaAuxiliar pessoaJuridicaAuxiliar = new PessoaJuridicaAuxiliar();
        TelefoneAuxiliar telefoneAuxiliar = new TelefoneAuxiliar();
        TransacaoAuxiliar transacaoAuxiliar = new TransacaoAuxiliar();

        int opcao;
        int opcao2;
        boolean sair = false;
        boolean sair2 = false;

        while (!sair) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Informe os números abaixo"
                    + "\n1  - Agência" + "\n2  - Banco" + "\n3  - Cidade" + "\n4  - Conta" + "\n5  - Endereço" + "\n6  - Estado"
                    + "\n7  - País" + "\n8  - Pessoa" + "\n9  - Pessoa Física" + "\n10 - Pessoa Jurídica" + "\n11 - Telefone"
                    + "\n12 - Transação" + "\n13 - Sair" + "\nInforme o valor abaixo: "));
            switch (opcao) {

                case 1:
                    sair2 = false;
                    while (!sair2) {

                        opcao2 = Integer.parseInt(JOptionPane.showInputDialog("Agência\n"
                                + "1 - Inserir nova agência\n"
                                + "2 - Ver todas as agências cadastradas\n"
                                + "3 - Ver a agência pelo id\n"
                                + "4 - Deletar uma agência pelo id\n"
                                + "5 - Atualizar dados pelo id\n"
                                + "6 - Volte ao menu anterior" + "\nOs métodos podem demorar"
                                + "\nInforme o valor abaixo: "));

                        switch (opcao2) {
                            case 1:

                                agenciaAuxiliar.insert();
                                break;
                            case 2:

                                agenciaAuxiliar.findAll();
                                break;
                            case 3:
                                agenciaAuxiliar.findById();
                                break;
                            case 4:

                                agenciaAuxiliar.delete();
                                break;
                            case 5:

                                agenciaAuxiliar.update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida");
                        }
                    }
                    break;
                case 2:
                    sair2 = false;
                    while (!sair2) {

                        opcao2 = Integer.parseInt(JOptionPane.showInputDialog("Banco\n"
                                + "1 - Inserir novo banco\n"
                                + "2 - Ver todos os bancos cadastrados\n"
                                + "3 - Ver o banco pelo id\n"
                                + "4 - Deletar um banco pelo id\n"
                                + "5 - Atualizar o banco pelo id\n"
                                + "6 - Volte ao menu anterior" + "\nOs métodos podem demorar"
                                + "\nInforme o valor abaixo: "));
                        switch (opcao2) {
                            case 1:

                                bancoAuxiliar.insert();
                                break;
                            case 2:

                                bancoAuxiliar.findAll();
                                break;
                            case 3:

                                bancoAuxiliar.findById();
                                break;
                            case 4:

                                bancoAuxiliar.delete();
                                break;
                            case 5:

                                bancoAuxiliar.update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida");
                        }
                    }
                    break;
                case 3:
                    sair2 = false;
                    while (!sair2) {

                        opcao2 = Integer.parseInt(JOptionPane.showInputDialog("Cidade\n"
                                + "1 - Inserir nova cidade\n"
                                + "2 - Ver todas as cidades cadastradas\n"
                                + "3 - Ver cidade pelo ID\n"
                                + "4 - Deletar cidade pelo ID\n"
                                + "5 - Atualizar os dados da cidade ID\n"
                                + "6 - Volte ao menu anterior" + "\nOs métodos podem demorar"
                                + "\nInforme o valor abaixo: "));

                        switch (opcao2) {
                            case 1:

                                cidadeAuxiliar.insert();
                                break;
                            case 2:

                                cidadeAuxiliar.findAll();
                                break;
                            case 3:

                                cidadeAuxiliar.findById();
                                break;
                            case 4:

                                cidadeAuxiliar.delete();
                                break;
                            case 5:

                                cidadeAuxiliar.update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida");
                        }
                    }
                    break;
                case 4:
                    sair2 = false;
                    while (!sair2) {

                        opcao2 = Integer.parseInt(JOptionPane.showInputDialog("Conta:\n"
                                + "1 - Inserir conta nova\n"
                                + "2 - Ver contas cadastradas\n"
                                + "3 - ver a conta pelo ID\n"
                                + "4 - deletar conta pelo ID\n"
                                + "5 -atualizar conta pelonID\n"
                                + "6 - Volte ao menu anterior" + "\nOs métodos podem demorar"
                                + "\nInforme o valor abaixo: "));

                        switch (opcao2) {
                            case 1:

                                contaAuxiliar.insert();
                                break;
                            case 2:

                                contaAuxiliar.findAll();
                                break;
                            case 3:

                                contaAuxiliar.findById();
                                break;
                            case 4:

                                contaAuxiliar.delete();
                                break;
                            case 5:

                                contaAuxiliar.update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida");
                        }
                    }
                    break;
                case 5:
                    sair2 = false;
                    while (!sair2) {

                        opcao2 = Integer.parseInt(JOptionPane.showInputDialog("Endereço\n"
                                + "1 - Inserir novo endereço\n"
                                + "2 - Ver todos endereços cadastrados\n"
                                + "3 - Ver endereço pelo ID\n"
                                + "4 - Deletar endereço pelo ID\n"
                                + "5 - Atualizar endereço pelo ID\n"
                                + "6 - Volte ao menu anterior" + "\nOs métodos podem demorar"
                                + "\nInforme o valor abaixo: "));

                        switch (opcao2) {
                            case 1:

                                enderecoAuxiliar.insert();
                                break;
                            case 2:

                                enderecoAuxiliar.findAll();
                                break;
                            case 3:

                                enderecoAuxiliar.findById();
                                break;
                            case 4:

                                enderecoAuxiliar.delete();
                                break;
                            case 5:

                                enderecoAuxiliar.update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida");
                        }
                    }
                    break;
                case 6:
                    sair2 = false;
                    while (!sair2) {

                        opcao2 = Integer.parseInt(JOptionPane.showInputDialog("Estado\n"
                                + "1 - Inserir um novo estado\n"
                                + "2 - Ver todos os estados \n"
                                + "3 - Ver estado pelo ID\n"
                                + "4 - Deletar estado pelo ID\n"
                                + "5 - Atualizar estado pelo ID\n"
                                + "6 - Volte ao menu anterior" + "\nOs métodos podem demorar"
                                + "\nInforme o valor abaixo: "));

                        switch (opcao2) {
                            case 1:

                                estadoAuxiliar.insert();
                                break;
                            case 2:

                                estadoAuxiliar.findAll();
                                break;
                            case 3:

                                estadoAuxiliar.findById();
                                break;
                            case 4:

                                estadoAuxiliar.delete();
                                break;
                            case 5:

                                estadoAuxiliar.update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida");
                        }
                    }
                    break;
                case 7:
                    sair2 = false;
                    while (!sair2) {

                        opcao2 = Integer.parseInt(JOptionPane.showInputDialog("País\n"
                                + "1 - Inserir um novo País\n"
                                + "2 - Ver todos os Paises cadastrados\n"
                                + "3 - Ver País pelo ID\n"
                                + "4 - Deletar um País pelo ID\n"
                                + "5 - Atualizar um País pelo ID\n"
                                + "6 - Volte ao menu anterior" + "\nOs métodos podem demorar"
                                + "\nInforme o valor abaixo: "));

                        switch (opcao2) {
                            case 1:

                                paisAuxiliar.insert();
                                break;
                            case 2:

                                paisAuxiliar.findAll();
                                break;
                            case 3:

                                paisAuxiliar.findById();
                                break;
                            case 4:

                                paisAuxiliar.delete();
                                break;
                            case 5:

                                paisAuxiliar.update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida");
                        }
                    }
                    break;
                case 8:
                    sair2 = false;
                    while (!sair2) {

                        opcao2 = Integer.parseInt(JOptionPane.showInputDialog("Pessoa\n"
                                + "1 - Inserir uma nova pessoa\n"
                                + "2 - Ver pessoas cadastradas\n"
                                + "3 - Ver pessoas pelo ID\n"
                                + "4 - Deletar pessoa pelo ID\n"
                                + "5 - Atualizar pessoa pelo ID\n"
                                + "6 - Volte ao menu anterior" + "\nOs métodos podem demorar"
                                + "\nInforme o valor abaixo: "));

                        switch (opcao2) {
                            case 1:

                                pessoaAuxiliar.insert();
                                break;
                            case 2:

                                pessoaAuxiliar.findAll();
                                break;
                            case 3:

                                pessoaAuxiliar.findById();
                                break;
                            case 4:

                                pessoaAuxiliar.delete();
                                break;
                            case 5:

                                pessoaAuxiliar.update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida");
                        }
                    }
                    break;
                case 9:
                    sair2 = false;
                    while (!sair2) {

                        opcao2 = Integer.parseInt(JOptionPane.showInputDialog("Pessoa Fisica\n"
                                + "1 - Inserir pessoa fisica\n"
                                + "2 - Ver todas as pessoas fisicas cadastradas\n"
                                + "3 - Ver pelossoa fisica pelo CPF\n"
                                + "4 - Deletar pessoa fisica pelo CPF\n"
                                + "5 - Atualizar os dados de pessoa fisica pelo CPF\n"
                                + "6 - Volte ao menu anterior" + "\nOs métodos podem demorar"
                                + "\nInforme o valor abaixo: "));
                        switch (opcao2) {
                            case 1:

                                pessoaFisicaAuxiliar.insert();
                                break;
                            case 2:

                                pessoaFisicaAuxiliar.findAll();
                                break;
                            case 3:

                                pessoaFisicaAuxiliar.findById();
                                break;
                            case 4:

                                pessoaFisicaAuxiliar.delete();
                                break;
                            case 5:

                                pessoaFisicaAuxiliar.update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida");
                        }
                    }
                    break;
                case 10:
                    sair2 = false;
                    while (!sair2) {

                        opcao2 = Integer.parseInt(JOptionPane.showInputDialog("Pessoa Jurídica\n"
                                + "1 - Inserir nova Pessoa Jurídica\n"
                                + "2 - Ver todas as Pessoas Jurídicas cadastradas\n"
                                + "3 - Ver a Pessoa Jurídica pelo CNPJ\n"
                                + "4 - Deletar a Pessoa Jurídica pelo CNPJ\n"
                                + "5 - Atualizar dados de Pessoa Jurídica pelo CNPJ\n"
                                + "6 - Volte ao menu anterior" + "\nOs métodos podem demorar"
                                + "\nInforme o valor abaixo: "));

                        switch (opcao2) {
                            case 1:

                                pessoaJuridicaAuxiliar.insert();
                                break;
                            case 2:

                                pessoaJuridicaAuxiliar.findAll();
                                break;
                            case 3:

                                pessoaJuridicaAuxiliar.findById();
                                break;
                            case 4:

                                pessoaJuridicaAuxiliar.delete();
                                break;
                            case 5:

                                pessoaJuridicaAuxiliar.update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida");
                        }
                    }
                    break;
                case 11:
                    sair2 = false;
                    while (!sair2) {

                        opcao2 = Integer.parseInt(JOptionPane.showInputDialog("Telefone\n"
                                + "1 - Inserir novo telefone\n"
                                + "2 - Ver todos telefones cadastrados\n"
                                + "3 - Ver o telefone pelo ID\n"
                                + "4 - Deletar telefone pelo ID\n"
                                + "5 - Atualizar telefone pelo ID\n"
                                + "6 - Volte ao menu anterior" + "\nOs métodos podem demorar"
                                + "\nInforme o valor abaixo: "));

                        switch (opcao2) {
                            case 1:

                                telefoneAuxiliar.insert();
                                break;
                            case 2:

                                telefoneAuxiliar.findAll();
                                break;
                            case 3:

                                telefoneAuxiliar.findById();
                                break;
                            case 4:

                                telefoneAuxiliar.delete();
                                break;
                            case 5:

                                telefoneAuxiliar.update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida");
                        }
                    }
                    break;
                case 12:
                    sair2 = false;
                    while (!sair2) {

                        opcao2 = Integer.parseInt(JOptionPane.showInputDialog("Transação\n"
                                + "1 - Fazer nova transação\n"
                                + "2 - Ver todas as transações realizadas\n"
                                + "3 - Ver transação pelo ID\n"
                                + "4 - Deletar uma transação feita pelo ID\n"
                                + "5 - Atualizar dados de transação pelo ID\n"
                                + "6 - Volte ao menu anterior" + "\nOs métodos podem demorar"
                                + "\nInforme o valor abaixo: "));

                        switch (opcao2) {
                            case 1:

                                transacaoAuxiliar.insert();
                                break;
                            case 2:

                                transacaoAuxiliar.findAll();
                                break;
                            case 3:

                                transacaoAuxiliar.findById();
                                break;
                            case 4:

                                transacaoAuxiliar.delete();
                                break;
                            case 5:

                                transacaoAuxiliar.update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida");
                        }
                    }
                    break;
                case 13:
                    sair = true;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }
    }
}
