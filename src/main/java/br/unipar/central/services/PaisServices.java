/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoPreenchidaException;
import br.unipar.central.exceptions.NumeroExcedidoTamanhoException;
import br.unipar.central.model.PaisPOJO;
import br.unipar.central.reposiitories.PaisDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yuriz
 */
public class PaisServices {

    public void validar(PaisPOJO pais) throws EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
        if (pais == null) {
            throw new EntidadeNaoPreenchidaException("Pais");
        }

        if (pais.getNome() == null || pais.getNome().isEmpty() || pais.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome");
        }

        if (pais.getSigla() == null || pais.getSigla().isEmpty() || pais.getSigla().isBlank()) {
            throw new CampoNaoInformadoException("Sigla");
        }

        if (!(pais.getSigla().length() == 2)) {
            throw new NumeroExcedidoTamanhoException("Sigla", 2);
        }

        if (pais.getNome().length() > 60) {
            throw new NumeroExcedidoTamanhoException("Nome", 60);
        }
        
         if (!(pais.getRegistroAcademico().length() > 8)) {
            throw new NumeroExcedidoTamanhoException("ra", 8);
        }
         
         if (pais.getRegistroAcademico()== null || pais.getRegistroAcademico().isEmpty() || pais.getRegistroAcademico().isBlank()) {
             throw new CampoNaoInformadoException("Sigla");
        }

    }

    public List<PaisPOJO> findAll() throws SQLException {
        PaisDAO paisDAO = new PaisDAO();
        List<PaisPOJO> resultado = paisDAO.findAll();

        return resultado;
    }
    
      public PaisPOJO findById(int id) throws SQLException, CampoNaoInformadoException, Exception, EntidadeNaoPreenchidaException, NumeroExcedidoTamanhoException{
                        
          if(id <= 0)
          throw new CampoNaoInformadoException("id");
          
          PaisDAO paisDAO = new PaisDAO();
          
          PaisPOJO retorno =  paisDAO.findById(id);
          
          
          if(retorno == null)
              throw new Exception("Não foi possivel encontrar um pais com o id: " + id + "informado");

          return retorno;
    }
    
      public void insert(PaisPOJO pais) throws SQLException , EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
          PaisDAO paisDAO = new PaisDAO();
          paisDAO.insert(pais);
      }
      
      public void update(PaisPOJO pais) throws SQLException, EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
           validar(pais);
          PaisDAO paisDAO = new PaisDAO();
          paisDAO.update(pais);
      }
      
      public void delete(int id) throws SQLException {
          PaisDAO paisDAO = new PaisDAO();
          
          paisDAO.delete(id);
      }
}
