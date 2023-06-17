/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoPreenchidaException;
import br.unipar.central.exceptions.NumeroExcedidoTamanhoException;
import br.unipar.central.exceptions.ValorInformadoInvalidoException;
import br.unipar.central.model.TransacaoPOJO;
import br.unipar.central.reposiitories.TransacaoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yuriz
 */
public class TransacaoServices {
     public void validar(TransacaoPOJO transacao) throws EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException , ValorInformadoInvalidoException{
    
     String idStr = String.valueOf(transacao.getId());

        if (transacao == null) {
            throw new EntidadeNaoPreenchidaException("transacao");
        }

        if (transacao.getId()== 0) {
            throw new CampoNaoInformadoException("id");
        }

        if (!idStr.matches("\\d+")) {
            throw new ValorInformadoInvalidoException("id");
        }

         if (transacao.getValor() == 0) {
            throw new CampoNaoInformadoException("saldo em conta");
        }

        if (transacao.getDataHora()== null) {
            throw new CampoNaoInformadoException("Data e Hora da transação");
        }
        

        if (transacao.getRegistroAcademico()== null|| transacao.getRegistroAcademico().isEmpty() || transacao.getRegistroAcademico().isBlank()) {
            throw new CampoNaoInformadoException("ra");
        }

        if (!(transacao.getRegistroAcademico().length() > 8)) {
            throw new NumeroExcedidoTamanhoException("ra", 8);
        }

         if (transacao.getContaDestino() == null) {
            throw new EntidadeNaoPreenchidaException("conta destino");
        }


         if (transacao.getContaOrigem()== null) {
            throw new EntidadeNaoPreenchidaException("conta origem");
        }

    }

    public List<TransacaoPOJO> findAll() throws SQLException {

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        List<TransacaoPOJO> resultado = transacaoDAO.findAll();

        return resultado;
    }

    public TransacaoPOJO findById(int id) throws SQLException, NumeroExcedidoTamanhoException, Exception {

        if (id <= 0) {
            throw new NumeroExcedidoTamanhoException("id", 1);
        }

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        TransacaoPOJO retorno = transacaoDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um transacao com o id: " + id + " informado");
        }

        return transacaoDAO.findById(id);
    }

    public void insert(TransacaoPOJO transacao) throws SQLException, EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException , ValorInformadoInvalidoException {
        validar(transacao);
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.insert(transacao);
    }

    public void update(TransacaoPOJO transacao) throws SQLException, EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException , ValorInformadoInvalidoException {
        validar(transacao);
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.update(transacao);
    }

    public void delete(int id) throws SQLException {
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.delete(id);

    }
}
