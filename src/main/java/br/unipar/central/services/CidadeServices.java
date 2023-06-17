/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoPreenchidaException;
import br.unipar.central.exceptions.NumeroExcedidoTamanhoException;
import br.unipar.central.model.CidadePOJO;
import br.unipar.central.reposiitories.CidadeDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yuriz
 */
public class CidadeServices {
    
     public void validar(CidadePOJO cidade) throws EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException{
        if (cidade == null) {
            throw new EntidadeNaoPreenchidaException("Cidade");
        }
        
        if(cidade.getEstado() == null) {
              throw new CampoNaoInformadoException("Estado");
        }
        

        if (cidade.getNome() == null || cidade.getNome().isEmpty() || cidade.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome");
        }
        
        if (cidade.getRegistroAcademico()== null || cidade.getRegistroAcademico().isEmpty() || cidade.getRegistroAcademico().isBlank()) {
            throw new CampoNaoInformadoException("ra");
        }
         
         if(cidade.getNome().length() > 60) {
             throw new NumeroExcedidoTamanhoException("Nome",60); 
         }
         
         if (!(cidade.getRegistroAcademico().length() > 8)) {
            throw new NumeroExcedidoTamanhoException("ra", 8);
        }
         
         
    }
    
     public List<CidadePOJO> findAll() throws SQLException {
        CidadeDAO bancoDAO = new CidadeDAO();
         List<CidadePOJO> resultado = bancoDAO.findAll();

        return resultado;
    }
    
      public CidadePOJO findById(int id) throws SQLException, CampoNaoInformadoException, Exception, EntidadeNaoPreenchidaException, NumeroExcedidoTamanhoException{
                        
          if(id <= 0)
          throw new CampoNaoInformadoException("id");
          
          CidadeDAO bancoDAO = new CidadeDAO();
          
          CidadePOJO retorno =  bancoDAO.findById(id);
          
          
          if(retorno == null)
              throw new Exception("Não foi possivel encontrar uma cidade com o id: " + id + "informado");

          return retorno;
    }
    
      public void insert(CidadePOJO banco) throws SQLException , EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
          CidadeDAO bancoDAO = new CidadeDAO();
          bancoDAO.insert(banco);
      }
      
      public void update(CidadePOJO banco) throws SQLException, EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
           validar(banco);
          CidadeDAO bancoDAO = new CidadeDAO();
          bancoDAO.update(banco);
      }
      
      public void delete(int id) throws SQLException {
          CidadeDAO bancoDAO = new CidadeDAO();
          
          bancoDAO.delete(id);
      }
}
