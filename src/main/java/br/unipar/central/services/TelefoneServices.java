/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoPreenchidaException;
import br.unipar.central.exceptions.NumeroExcedidoTamanhoException;
import br.unipar.central.exceptions.ValorInformadoInvalidoException;
import br.unipar.central.model.TelefonePOJO;
import br.unipar.central.reposiitories.TelefoneDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yuriz
 */
public class TelefoneServices {
    
    public void validar(TelefonePOJO telefone) throws EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException , ValorInformadoInvalidoException{
    
     String idStr = String.valueOf(telefone.getId_telefone());

        if (telefone == null) {
            throw new EntidadeNaoPreenchidaException("telefone");
        }

        if (telefone.getId_telefone()== 0) {
            throw new CampoNaoInformadoException("id");
        }

        if (!idStr.matches("\\d+")) {
            throw new ValorInformadoInvalidoException("id");
        }

        if (telefone.getNumero() == null || telefone.getNumero().isEmpty() || telefone.getNumero().isBlank()) {
            throw new CampoNaoInformadoException("numero do telefone");
        }

        if (!(telefone.getNumero().length() > 30)) {
            throw new NumeroExcedidoTamanhoException("numero do telefone", 8);
        }

        if (telefone.getOperadora() == null) {
            throw new CampoNaoInformadoException("operadora");
        }

        if (telefone.getRegistroAcademico()== null|| telefone.getRegistroAcademico().isEmpty() || telefone.getRegistroAcademico().isBlank()) {
            throw new CampoNaoInformadoException("ra");
        }

        if (!(telefone.getRegistroAcademico().length() > 8)) {
            throw new NumeroExcedidoTamanhoException("ra", 8);
        }

        if (telefone.getAgencia() == null) {
            throw new EntidadeNaoPreenchidaException("agencia");
        }

        if (telefone.getPessoa() == null) {
            throw new EntidadeNaoPreenchidaException("pessoa");
        }

    }

    public List<TelefonePOJO> findAll() throws SQLException {

        TelefoneDAO telefoneDAO = new TelefoneDAO();
        List<TelefonePOJO> resultado = telefoneDAO.findAll();

        return resultado;
    }

    public TelefonePOJO findById(int id) throws SQLException, NumeroExcedidoTamanhoException, Exception {

        if (id <= 0) {
            throw new NumeroExcedidoTamanhoException("id", 1);
        }

        TelefoneDAO telefoneDAO = new TelefoneDAO();
        TelefonePOJO retorno = telefoneDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id: " + id + " informado");
        }

        return telefoneDAO.findById(id);
    }

    public void insert(TelefonePOJO telefone) throws SQLException, EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException , ValorInformadoInvalidoException {
        validar(telefone);
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.insert(telefone);
    }

    public void update(TelefonePOJO telefone) throws SQLException, EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException , ValorInformadoInvalidoException {
        validar(telefone);
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.update(telefone);
    }

    public void delete(int id) throws SQLException {
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.delete(id);

    }
}
