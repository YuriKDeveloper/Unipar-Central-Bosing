/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoPreenchidaException;
import br.unipar.central.exceptions.NumeroExcedidoTamanhoException;
import br.unipar.central.model.PessoaPOJO;
import br.unipar.central.reposiitories.PessoaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yuriz
 */
public class PessoaServices {
    
          public void validar(PessoaPOJO pessoa) throws EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
        if (pessoa == null) {
            throw new EntidadeNaoPreenchidaException("pessoa");
        }
        
        if (pessoa.getEmail()== null || pessoa.getEmail().isEmpty() || pessoa.getEmail().isBlank()) {
            throw new CampoNaoInformadoException("email");
        }

        if (pessoa.getRegistroAcademico()== null || pessoa.getRegistroAcademico().isEmpty() || pessoa.getRegistroAcademico().isBlank()) {
            throw new CampoNaoInformadoException("ra");
        }
        
         if (String.valueOf(pessoa.getId()).isBlank() || String.valueOf(pessoa.getId()).isEmpty() || String.valueOf(pessoa.getId()) == null) {
            throw new CampoNaoInformadoException("id");
        }
         
        if (!(pessoa.getRegistroAcademico().length() > 8)) {
            throw new NumeroExcedidoTamanhoException("ra", 8);
        }

    }

    public List<PessoaPOJO> findAll() throws SQLException {
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<PessoaPOJO> resultado = pessoaDAO.findAll();

        return resultado;
    }
    
      public PessoaPOJO findById(int id) throws SQLException, CampoNaoInformadoException, Exception, EntidadeNaoPreenchidaException, NumeroExcedidoTamanhoException{
                        
          if(id <= 0)
          throw new CampoNaoInformadoException("id");
          
          PessoaDAO pessoaDAO = new PessoaDAO();
          
          PessoaPOJO retorno =  pessoaDAO.findById(id);
          
          
          if(retorno == null)
              throw new Exception("Não foi possivel encontrar uma pessoa com o id: " + id + "informado");

          return retorno;
    }
    
      public void insert(PessoaPOJO pessoa) throws SQLException , EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
          PessoaDAO pessoaDAO = new PessoaDAO();
          pessoaDAO.insert(pessoa);
      }
      
      public void update(PessoaPOJO pessoa) throws SQLException, EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
           validar(pessoa);
          PessoaDAO pessoaDAO = new PessoaDAO();
          pessoaDAO.update(pessoa);
      }
      
      public void delete(int id) throws SQLException {
          PessoaDAO pessoaDAO = new PessoaDAO();
          
          pessoaDAO.delete(id);
      }
}
