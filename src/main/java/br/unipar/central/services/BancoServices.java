/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoPreenchidaException;
import br.unipar.central.exceptions.NumeroExcedidoTamanhoException;
import br.unipar.central.model.BancoPOJO;
import br.unipar.central.reposiitories.BancoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yuriz
 */
public class BancoServices {
    
            public void validar(BancoPOJO banco) throws EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
        if (banco == null) {
            throw new EntidadeNaoPreenchidaException("banco");
        }
        
        if (banco.getNome()== null || banco.getNome().isEmpty() || banco.getNome().isBlank()) {
            throw new CampoNaoInformadoException("nome");
        }

        if (banco.getRegistroAcademico()== null || banco.getRegistroAcademico().isEmpty() || banco.getRegistroAcademico().isBlank()) {
            throw new CampoNaoInformadoException("ra");
        }
        
         if (String.valueOf(banco.getId()).isBlank() || String.valueOf(banco.getId()).isEmpty() || String.valueOf(banco.getId()) == null) {
            throw new CampoNaoInformadoException("id");
        }
         
         if (!(banco.getRegistroAcademico().length() > 8)) {
            throw new NumeroExcedidoTamanhoException("ra", 8);
        }

    }

    public List<BancoPOJO> findAll() throws SQLException {
        BancoDAO bancoDAO = new BancoDAO();
        List<BancoPOJO> resultado = bancoDAO.findAll();

        return resultado;
    }
    
      public BancoPOJO findById(int id) throws SQLException, CampoNaoInformadoException, Exception, EntidadeNaoPreenchidaException, NumeroExcedidoTamanhoException{
                        
          if(id <= 0)
          throw new CampoNaoInformadoException("id");
          
          BancoDAO bancoDAO = new BancoDAO();
          
          BancoPOJO retorno =  bancoDAO.findById(id);
          
          
          if(retorno == null)
              throw new Exception("Não foi possivel encontrar um banco com o id: " + id + "informado");

          return retorno;
    }
    
      public void insert(BancoPOJO banco) throws SQLException , EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
          BancoDAO bancoDAO = new BancoDAO();
          bancoDAO.insert(banco);
      }
      
      public void update(BancoPOJO banco) throws SQLException, EntidadeNaoPreenchidaException, CampoNaoInformadoException, NumeroExcedidoTamanhoException {
           validar(banco);
          BancoDAO bancoDAO = new BancoDAO();
          bancoDAO.update(banco);
      }
      
      public void delete(int id) throws SQLException {
          BancoDAO bancoDAO = new BancoDAO();
          
          bancoDAO.delete(id);
      }
}
