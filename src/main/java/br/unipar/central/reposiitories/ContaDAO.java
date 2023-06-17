/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.reposiitories;

import br.unipar.central.model.ContaPOJO;
import br.unipar.central.model.enums.TipoContaEnum;
import br.unipar.central.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yuriz
 */
public class ContaDAO {
    
    private static final String INSERT = "INSERT INTO conta(numero, digito, saldo, tipo, ra, agencia_id, pessoa_id) VALUES(?, ?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT id, numero, digito, saldo, tipo, ra, agencia_id, pessoa_id FROM conta ";

    private static final String FIND_BY_ID = "SELECT id, numero, digito, saldo, tipo, ra, agencia_id, pessoa_id FROM conta WHERE id = ? ";

    private static final String DELETE_BY_ID = "DELETE FROM conta WHERE id = ?";

    private static final String UPDATE = "UPDATE conta SET  numero = ?, digito = ?, saldo = ? tipo = ?, ra = ?, agencia_id = ?, pessoa_id = ? WHERE id = ?";
    
    public List<ContaPOJO> findAll() throws SQLException  {
        
        ArrayList<ContaPOJO> retorno = new ArrayList<>();
        
        Connection conn = null;
        
        PreparedStatement pstmt = null;
        
        ResultSet rs = null;
        try {
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                
                ContaPOJO conta = new ContaPOJO();
                
                conta.setId(rs.getInt("id"));
                
                conta.setNumero(rs.getString("numero"));
                
                conta.setDigito(rs.getString("digito"));
                
                conta.setSaldo(rs.getDouble("saldo"));
                
                conta.setTipoConta(TipoContaEnum.paraEnum(rs.getInt("tipo")));
                
                conta.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));
                
                conta.setRegistroAcademico(rs.getString("ra"));
                
                conta.setAgencia(new AgenciaDAO().findById(rs.getInt("estado_id")));
                
                retorno.add(conta);
            }
            
        } finally {
            
            if(rs != null)
            rs.close();
                
            if(pstmt != null)
            pstmt.close();
                
            if(conn != null)
                conn.close();
            
        }
        return retorno;
    }
    
    public ContaPOJO findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ContaPOJO retorno = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_BY_ID);
            
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                
                retorno = new ContaPOJO();
               
                retorno.setId(rs.getInt("id"));
                
                retorno.setNumero(rs.getString("numero"));
                
                retorno.setDigito(rs.getString("digito"));
                
                retorno.setSaldo(rs.getDouble("saldo"));
                
                retorno.setTipoConta(TipoContaEnum.paraEnum(rs.getInt("tipo")));
                
                retorno.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));
                
                retorno.setRegistroAcademico(rs.getString("ra"));
                
                retorno.setAgencia(new AgenciaDAO().findById(rs.getInt("estado_id")));
               
            }
            
        } finally {
            if (rs != null)
                rs.close();
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
        return retorno;
    }
    
    public void insert(ContaPOJO conta) throws SQLException {
        
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
             conn = new DatabaseUtils().getConnection();
             
             pstmt = conn.prepareStatement(INSERT);
              
             pstmt.setString(1, conta.getNumero());
             
             pstmt.setString(2, conta.getDigito());
               
             pstmt.setDouble(3, conta.getSaldo());
                       
             pstmt.setString(4, conta.getTipoConta().name());
             
             pstmt.setString(5, conta.getRegistroAcademico());
             
             pstmt.setInt(6, conta.getAgencia().getId());
             
             pstmt.setInt(6, conta.getPessoa().getId());
            
             pstmt.executeUpdate();
             //INSERT INTO conta(numero, digito, saldo, tipo, ra, agencia_id, pessoa_id
             
        } finally {
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
    }
    
     public void update(ContaPOJO conta) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        
        try {
            
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setString(1, conta.getNumero());
             
             pstmt.setString(2, conta.getDigito());
               
             pstmt.setDouble(3, conta.getSaldo());
                       
             pstmt.setString(4, conta.getTipoConta().name());
             
             pstmt.setString(5, conta.getRegistroAcademico());
             
             pstmt.setInt(6, conta.getAgencia().getId());
             
             pstmt.setInt(6, conta.getPessoa().getId());
             
             pstmt.setInt(6, conta.getId());
            
             pstmt.executeUpdate();
           //UPDATE conta SET  numero = ?, digito = ?, saldo = ? tipo = ?, ra = ?, agencia_id = ?, pessoa_id = ? WHERE id = ?

        } finally {
          
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
    }
       
    public void delete(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        
        try {
            
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(DELETE_BY_ID);
            
            pstmt.setInt(1, id);
           
            pstmt.executeUpdate();
            
        } finally {
          
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
    }
}
