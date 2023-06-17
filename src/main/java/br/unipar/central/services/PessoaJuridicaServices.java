/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoPreenchidaException;
import br.unipar.central.exceptions.NumeroExcedidoTamanhoException;
import br.unipar.central.model.PessoaJuridicaPOJO;
import br.unipar.central.reposiitories.PessoaJuridicaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yuriz
 */
public class PessoaJuridicaServices {
    
           public void validar(PessoaJuridicaPOJO pessoa) throws EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
        if (pessoa == null) {
            throw new EntidadeNaoPreenchidaException("pessoa Juridica");
        }
        
        if (pessoa.getCnpj()== null || pessoa.getCnpj().isEmpty() || pessoa.getCnpj().isBlank()) {
            throw new CampoNaoInformadoException("cnpj");
        }
        
          if ((pessoa.getCnpj().length() > 18)) {
            throw new NumeroExcedidoTamanhoException("cpf", 18);
        }

        if (pessoa.getFantasia()== null || pessoa.getFantasia().isEmpty() || pessoa.getFantasia().isBlank()) {
            throw new CampoNaoInformadoException("fantasia");
        }
        
        if ((pessoa.getFantasia().length() > 60)) {
            throw new NumeroExcedidoTamanhoException("fantasia", 60);
        }

        
        if ((pessoa.getRazaoSocial().length() > 60)) {
            throw new NumeroExcedidoTamanhoException("razão social", 60);
        }
        
        if (pessoa.getRazaoSocial()== null || pessoa.getRazaoSocial().isEmpty() || pessoa.getRazaoSocial().isBlank()) {
            throw new CampoNaoInformadoException("razão social");
        }
        
        if (pessoa.getCnaePrincipal()== null || pessoa.getCnaePrincipal().isEmpty() || pessoa.getCnaePrincipal().isBlank()) {
            throw new CampoNaoInformadoException("cnae");
        }
        
        if ((pessoa.getCnaePrincipal().length() > 100)) {
            throw new NumeroExcedidoTamanhoException("cnae", 60);
        }
        
        if (pessoa.getPessoa() == null) {
            throw new EntidadeNaoPreenchidaException("pessoa");
        }
        

    }

    public List<PessoaJuridicaPOJO> findAll() throws SQLException {
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        List<PessoaJuridicaPOJO> resultado = pessoaJuridicaDAO.findAll();

        return resultado;
    }
    
      public PessoaJuridicaPOJO findById(String cnpj) throws SQLException, CampoNaoInformadoException, Exception, EntidadeNaoPreenchidaException, NumeroExcedidoTamanhoException{
                        
          if(cnpj.length() <= 0)
          throw new NumeroExcedidoTamanhoException("cnpj",1);
          
          PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
          
          PessoaJuridicaPOJO retorno =  pessoaJuridicaDAO.findById(cnpj);
          
          
          if(retorno == null)
              throw new Exception("Não foi possivel encontrar uma pessoa com o cnpj: " + cnpj + " informado");

          return retorno;
    }
    
      public void insert(PessoaJuridicaPOJO pessoa) throws SQLException , EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
          PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
          pessoaJuridicaDAO.insert(pessoa);
      }
      
      public void update(PessoaJuridicaPOJO pessoa) throws SQLException, EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
           validar(pessoa);
          PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
          pessoaJuridicaDAO.update(pessoa);
      }
      
      public void delete(String cpnj) throws SQLException {
          PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
          
          pessoaJuridicaDAO.delete(cpnj);
      }
}
