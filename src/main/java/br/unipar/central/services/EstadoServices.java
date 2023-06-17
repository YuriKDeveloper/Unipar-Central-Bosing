/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoPreenchidaException;
import br.unipar.central.exceptions.NumeroExcedidoTamanhoException;
import br.unipar.central.model.EstadoPOJO;
import br.unipar.central.reposiitories.EstadoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yuriz
 */
public class EstadoServices {
    
    public void validar(EstadoPOJO estado) throws EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException{
        if (estado == null) {
            throw new EntidadeNaoPreenchidaException("Estado");
        }
        
        if (estado.getPais() == null) {
            throw new CampoNaoInformadoException("Pais");
        }
        
        if (estado.getNome() == null || estado.getNome().isEmpty() || estado.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome");
        }
         
         if (estado.getSigla() == null || estado.getSigla().isEmpty() || estado.getSigla().isBlank()) {
             throw new CampoNaoInformadoException("Sigla");
        }
         
          if (estado.getSigla() == null || estado.getSigla().isEmpty() || estado.getSigla().isBlank()) {
             throw new CampoNaoInformadoException("Sigla");
        }
         
         if (!(estado.getSigla().length() == 2)){
             throw new NumeroExcedidoTamanhoException("Sigla",2);
         }
         
         if(estado.getNome().length() > 60) {
             throw new NumeroExcedidoTamanhoException("Nome",60); 
         }
         
         if (!(estado.getRegistroAcademico().length() > 8)) {
            throw new NumeroExcedidoTamanhoException("ra", 8);
        }
         
         if (estado.getRegistroAcademico()== null || estado.getRegistroAcademico().isEmpty() || estado.getRegistroAcademico().isBlank()) {
             throw new CampoNaoInformadoException("Sigla");
        }
    }
    
    public List<EstadoPOJO> findAll() throws SQLException {
        EstadoDAO estadoDAO = new EstadoDAO();
        List<EstadoPOJO> resultado = estadoDAO.findAll();

        return resultado;
    }
    
      public EstadoPOJO findById(int id) throws SQLException, CampoNaoInformadoException, Exception, EntidadeNaoPreenchidaException, NumeroExcedidoTamanhoException{
                        
          if(id <= 0)
          throw new CampoNaoInformadoException("id");
          
          EstadoDAO estadoDAO = new EstadoDAO();
          
          EstadoPOJO retorno =  estadoDAO.findById(id);
          
          
          if(retorno == null)
              throw new Exception("Não foi possivel encontrar um estado com o id: " + id + "informado");

          return retorno;
    }
    
      public void insert(EstadoPOJO estado) throws SQLException , EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
          EstadoDAO estadoDAO = new EstadoDAO();
          estadoDAO.insert(estado);
      }
      
      public void update(EstadoPOJO estado) throws SQLException, EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
           validar(estado);
          EstadoDAO estadoDAO = new EstadoDAO();
          estadoDAO.update(estado);
      }
      
      public void delete(int id) throws SQLException {
          EstadoDAO estadoDAO = new EstadoDAO();
          
          estadoDAO.delete(id);
      }
}
