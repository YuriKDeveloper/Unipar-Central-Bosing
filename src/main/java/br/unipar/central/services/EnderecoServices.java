/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoPreenchidaException;
import br.unipar.central.exceptions.NumeroExcedidoTamanhoException;
import br.unipar.central.model.EnderecoPOJO;
import br.unipar.central.reposiitories.EnderecoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yuriz
 */
public class EnderecoServices {
    
    public void validar(EnderecoPOJO endereco) throws EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException{
        if (endereco == null) {
            throw new EntidadeNaoPreenchidaException("Endereco");
        }
        
        if (endereco.getBairro()== null || endereco.getBairro().isEmpty() || endereco.getBairro().isBlank()) {
            throw new CampoNaoInformadoException("Bairro");
        }
        
         if (endereco.getCep()== null || endereco.getCep().isEmpty() || endereco.getCep().isBlank()) {
             throw new CampoNaoInformadoException("CEP");
        }
         
         if (endereco.getComplemento()== null || endereco.getComplemento().isEmpty() || endereco.getComplemento().isBlank()) {
             throw new CampoNaoInformadoException("Complemento");
        }
         
         if (endereco.getLogradouro()== null || endereco.getLogradouro().isEmpty() || endereco.getLogradouro().isBlank()) {
             throw new CampoNaoInformadoException("Logradouro");
        }
         
         if (endereco.getNumero()== null || endereco.getNumero().isEmpty() || endereco.getNumero().isBlank()) {
             throw new CampoNaoInformadoException("Logradouro");
        }
         
        if (String.valueOf(endereco.getNumero()).isBlank() || String.valueOf(endereco.getNumero()).isEmpty() || String.valueOf(endereco.getNumero()) == null) {
            throw new CampoNaoInformadoException("Número");
        }
        
        if (endereco.getPessoa() == null) {
            throw new EntidadeNaoPreenchidaException("pessoa");
        }

         if (endereco.getCidade()== null) {
             throw new CampoNaoInformadoException("Cidade");
        }
         
         if (!(endereco.getComplemento().length() == 2)){
             throw new NumeroExcedidoTamanhoException("Sigla",2);
         }
         
         if(endereco.getBairro().length() > 60) {
             throw new NumeroExcedidoTamanhoException("Bairro",60); 
         }
         
         if(endereco.getCep().length() > 9) {
             throw new NumeroExcedidoTamanhoException("CEP",9); 
         }
         
         if(endereco.getComplemento().length() > 60) {
             throw new NumeroExcedidoTamanhoException("CEP",60); 
         }
         
         if(endereco.getNumero().length() > 60) {
             throw new NumeroExcedidoTamanhoException("CEP",60); 
         }
         
         if (!(endereco.getRegistroAcademico().length() > 8)) {
            throw new NumeroExcedidoTamanhoException("ra", 8);
        }
    }
    
    public List<EnderecoPOJO> findAll() throws SQLException {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        List<EnderecoPOJO> resultado = enderecoDAO.findAll();

        return resultado;
    }
    
      public EnderecoPOJO findById(int id) throws SQLException, CampoNaoInformadoException, Exception, EntidadeNaoPreenchidaException, NumeroExcedidoTamanhoException{
                        
          if(id <= 0)
          throw new CampoNaoInformadoException("id");
          
          EnderecoDAO enderecoDAO = new EnderecoDAO();
          
          EnderecoPOJO retorno =  enderecoDAO.findById(id);
          
          
          if(retorno == null)
              throw new Exception("Não foi possivel encontrar um endereco com o id: " + id + "informado");

          return retorno;
    }
    
      public void insert(EnderecoPOJO endereco) throws SQLException , EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
          EnderecoDAO enderecoDAO = new EnderecoDAO();
          enderecoDAO.insert(endereco);
      }
      
      public void update(EnderecoPOJO endereco) throws SQLException, EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
           validar(endereco);
          EnderecoDAO enderecoDAO = new EnderecoDAO();
          enderecoDAO.update(endereco);
      }
      
      public void delete(int id) throws SQLException {
          EnderecoDAO enderecoDAO = new EnderecoDAO();
          
          enderecoDAO.delete(id);
      }
}
