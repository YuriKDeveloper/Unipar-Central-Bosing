/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoPreenchidaException;
import br.unipar.central.exceptions.NumeroExcedidoTamanhoException;
import br.unipar.central.model.AgenciaPOJO;
import br.unipar.central.reposiitories.AgenciaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yuriz
 */
public class AgenciaServices  {
    
        public void validar(AgenciaPOJO agencia) throws EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
        if (agencia == null) {
            throw new EntidadeNaoPreenchidaException("agência");
        }
        
        if (agencia.getBanco() == null) {
            throw new EntidadeNaoPreenchidaException("banco");
        }

        if (agencia.getRazaoSocial()== null || agencia.getRazaoSocial().isEmpty() || agencia.getRazaoSocial().isBlank()) {
            throw new CampoNaoInformadoException("Razão social");
        }

        if (agencia.getCodigo()== null || agencia.getCodigo().isEmpty() || agencia.getCodigo().isBlank()) {
            throw new CampoNaoInformadoException("Código");
        }
        
        if (agencia.getDigito()== null || agencia.getDigito().isEmpty() || agencia.getDigito().isBlank()) {
            throw new CampoNaoInformadoException("Digito");
        }
        
        if (agencia.getCnpj()== null || agencia.getCnpj().isEmpty() || agencia.getCnpj().isBlank()) {
            throw new CampoNaoInformadoException("Cnpj");
        }
        
        if (!(agencia.getRegistroAcademico().length() > 8)) {
            throw new NumeroExcedidoTamanhoException("ra", 8);
        }
        
        if (agencia.getRegistroAcademico()== null || agencia.getRegistroAcademico().isEmpty() || agencia.getRegistroAcademico().isBlank()) {
            throw new CampoNaoInformadoException("ra");
        }
        

    }

    public List<AgenciaPOJO> findAll() throws SQLException {
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        List<AgenciaPOJO> resultado = agenciaDAO.findAll();

        return resultado;
    }
    
      public AgenciaPOJO findById(int id) throws SQLException, CampoNaoInformadoException, Exception, EntidadeNaoPreenchidaException, NumeroExcedidoTamanhoException{
                        
          if(id <= 0)
          throw new CampoNaoInformadoException("id");
          
          AgenciaDAO agenciaDAO = new AgenciaDAO();
          
          AgenciaPOJO retorno =  agenciaDAO.findById(id);
          
          
          if(retorno == null)
              throw new Exception("Não foi possivel encontrar uma agencia com o id: " + id + "informado");

          return retorno;
    }
    
      public void insert(AgenciaPOJO agencia) throws SQLException , EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
          AgenciaDAO agenciaDAO = new AgenciaDAO();
          agenciaDAO.insert(agencia);
      }
      
      public void update(AgenciaPOJO agencia) throws SQLException, EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
           validar(agencia);
          AgenciaDAO agenciaDAO = new AgenciaDAO();
          agenciaDAO.update(agencia);
      }
      
      public void delete(int id) throws SQLException {
          AgenciaDAO agenciaDAO = new AgenciaDAO();
          
          agenciaDAO.delete(id);
      }
}
