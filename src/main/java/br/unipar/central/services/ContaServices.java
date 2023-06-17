/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoPreenchidaException;
import br.unipar.central.exceptions.NumeroExcedidoTamanhoException;
import br.unipar.central.exceptions.ValorInformadoInvalidoException;
import br.unipar.central.model.ContaPOJO;
import br.unipar.central.model.EnderecoPOJO;
import br.unipar.central.reposiitories.ContaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yuriz
 */
public class ContaServices  {
    
     public void validar(ContaPOJO conta) throws EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException , ValorInformadoInvalidoException {
    
            String idConta = String.valueOf(conta.getId());
        String idSaldo = String.valueOf(conta.getSaldo());

        if (conta == null) {
            throw new EntidadeNaoPreenchidaException("conta");
        }

        if (conta.getId() == 0) {
            throw new CampoNaoInformadoException("id da conta");
        }

        if (!idConta.matches("\\d+")) {
            throw new ValorInformadoInvalidoException("id da conta");
        }

        if (conta.getNumero() == null
                || conta.getNumero().isEmpty()
                || conta.getNumero().isBlank()) {
            throw new CampoNaoInformadoException("numero da conta");
        }

        if (!(conta.getNumero().length() > 10)) {
            throw new NumeroExcedidoTamanhoException("numero da conta", 10);
        }

        if (conta.getDigito() == null
                || conta.getDigito().isEmpty()
                || conta.getDigito().isBlank()) {
            throw new CampoNaoInformadoException("dígito da conta");
        }

        if (!(conta.getDigito().length() > 1)) {
            throw new NumeroExcedidoTamanhoException("dígito da conta", 1);
        }

        if (conta.getSaldo() == 0) {
            throw new CampoNaoInformadoException("saldo em conta");
        }

        if (!idSaldo.matches("\\d+")) {
            throw new ValorInformadoInvalidoException("saldo em conta");
        }

        if (conta.getTipoConta() == null) {
            throw new CampoNaoInformadoException("tipo da conta");
        }

        if (conta.getRa() == null || conta.getRa().isEmpty() || conta.getRa().isBlank()) {
            throw new CampoNaoInformadoException("ra");
        }

        if (!(conta.getRa().length() > 8)) {
            throw new NumeroExcedidoTamanhoException("ra", 8);
        }

        if (conta.getAgencia() == null) {
            throw new EntidadeNaoPreenchidaException("agência");
        }

        if (conta.getPessoa() == null) {
            throw new EntidadeNaoPreenchidaException("pessoa");
        }

    }

    public List<ContaPOJO> findAll() throws SQLException {

        ContaDAO contaDAO = new ContaDAO();
        List<ContaPOJO> resultado = contaDAO.findAll();

        return resultado;
    }

    public ContaPOJO findById(int id) throws SQLException, NumeroExcedidoTamanhoException, Exception {

        if (id <= 0) {
            throw new NumeroExcedidoTamanhoException("id", 1);
        }

        ContaDAO contaDAO = new ContaDAO();
        ContaPOJO retorno = contaDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar uma conta com o id: " + id + " informado");
        }

        return contaDAO.findById(id);
    }

    public void insert(ContaPOJO conta) throws SQLException, EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException , ValorInformadoInvalidoException {
        validar(conta);
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.insert(conta);
    }

    public void update(ContaPOJO conta) throws SQLException, EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException , ValorInformadoInvalidoException {
        validar(conta);
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.update(conta);
    }

    public void delete(int id) throws SQLException {
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.delete(id);

    }
}
