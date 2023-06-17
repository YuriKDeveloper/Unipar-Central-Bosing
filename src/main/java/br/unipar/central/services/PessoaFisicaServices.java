/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoPreenchidaException;
import br.unipar.central.exceptions.NumeroExcedidoTamanhoException;
import br.unipar.central.model.PessoaFisicaPOJO;
import br.unipar.central.reposiitories.PessoaFisicaDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author yuriz
 */
public class PessoaFisicaServices {
    
        public void validar(PessoaFisicaPOJO pessoa) throws EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
        if (pessoa == null) {
            throw new EntidadeNaoPreenchidaException("pessoa Juridica");
        }
        
        if (pessoa.getCpf()== null || pessoa.getCpf().isEmpty() || pessoa.getCpf().isBlank()) {
            throw new CampoNaoInformadoException("cnpj");
        }
        
          if ((pessoa.getCpf().length() > 11)) {
            throw new NumeroExcedidoTamanhoException("cpf", 18);
        }

        if (pessoa.getNome()== null || pessoa.getNome().isEmpty() || pessoa.getNome().isBlank()) {
            throw new CampoNaoInformadoException("fantasia");
        }
        
        if ((pessoa.getNome().length() > 60)) {
            throw new NumeroExcedidoTamanhoException("fantasia", 60);
        }

        if ((pessoa.getRg().length() > 15)) {
            throw new NumeroExcedidoTamanhoException("razão social", 60);
        }
        
        if (pessoa.getRg()== null || pessoa.getRg().isEmpty() || pessoa.getRg().isBlank()) {
            throw new CampoNaoInformadoException("razão social");
        }
        
        Date dateAtual = new Date();
        if(pessoa.getDatanascimento().after(dateAtual)){
            throw new IllegalArgumentException("A data de nascimento deve ser anterior à data atual.");
        }
        
        if (pessoa.getPessoa() == null) {
            throw new EntidadeNaoPreenchidaException("pessoa");
        }

    }

    public List<PessoaFisicaPOJO> findAll() throws SQLException {
        PessoaFisicaDAO pessoaDAO = new PessoaFisicaDAO();
        List<PessoaFisicaPOJO> resultado = pessoaDAO.findAll();

        return resultado;
    }
    
      public PessoaFisicaPOJO findById(String cpf) throws SQLException, CampoNaoInformadoException, Exception, EntidadeNaoPreenchidaException, NumeroExcedidoTamanhoException{
                        
          if(cpf == "")
          throw new CampoNaoInformadoException("cpf");
          
          PessoaFisicaDAO pessoaDAO = new PessoaFisicaDAO();
          
          PessoaFisicaPOJO retorno =  pessoaDAO.findById(cpf);
          
          
          if(retorno == null)
              throw new Exception("Não foi possivel encontrar uma pessoa com o cpf: " + cpf + "informado");

          return retorno;
    }
    
      public void insert(PessoaFisicaPOJO pessoa) throws SQLException , EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
          PessoaFisicaDAO pessoaDAO = new PessoaFisicaDAO();
          pessoaDAO.insert(pessoa);
      }
      
      public void update(PessoaFisicaPOJO pessoa) throws SQLException, EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
           validar(pessoa);
          PessoaFisicaDAO pessoaDAO = new PessoaFisicaDAO();
          pessoaDAO.update(pessoa);
      }
      
      public void delete(String cpf) throws SQLException {
          PessoaFisicaDAO pessoaDAO = new PessoaFisicaDAO();
          
          pessoaDAO.delete(cpf);
      }
}
