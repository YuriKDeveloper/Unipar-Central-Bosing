/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.reposiitories;

import br.unipar.central.model.EnderecoPOJO;
import br.unipar.central.model.EnderecoPOJO;
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
public class EnderecoDAO {
    
    private static final String INSERT = "INSERT INTO endereco(id, logradouro, numero, bairro, cep, complemento, ra, pessoa_id, cidade_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT id, logradouro, numero, bairro, cep, complemento, ra, pessoa_id, cidade_id FROM endereco ";

    private static final String FIND_BY_ID = "SELECT id, logradouro, numero, bairro, cep, complemento, ra, pessoa_id, cidade_id FROM endereco WHERE id = ? ";

    private static final String DELETE_BY_ID = "DELETE FROM endereco WHERE id = ?";

    private static final String UPDATE = "UPDATE endereco SET logradouro = ?, numero = ?, bairro = ? cep = ?, complemento = ?, ra = ?, pessoa_id = ?, cidade_id = ? WHERE id = ?";
    
    
    public List<EnderecoPOJO> findAll() throws SQLException  {
        
        ArrayList<EnderecoPOJO> retorno = new ArrayList<>();
        
        Connection conn = null;
        
        PreparedStatement pstmt = null;
        
        ResultSet rs = null;
        try {
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                
                EnderecoPOJO endereco = new EnderecoPOJO();
                
                endereco.setId_endereco(rs.getInt("id"));
                
                endereco.setLogradouro(rs.getString("logradouro"));
                
                endereco.setComplemento(rs.getString("complemento"));
                
                endereco.setNumero(rs.getString("numero"));
                
                endereco.setBairro(rs.getString("bairro"));
                
                endereco.setCep(rs.getString("cep"));
                
                endereco.setRegistroAcademico(rs.getString("ra"));
                
                endereco.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));
                
                endereco.setCidade( new CidadeDAO().findById(rs.getInt("cidade_id")));
                
                retorno.add(endereco);
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
    
     public EnderecoPOJO findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        EnderecoPOJO retorno = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_BY_ID);
            
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                
               retorno = new EnderecoPOJO();
               
               retorno.setId_endereco(rs.getInt("id"));
                
                retorno.setLogradouro(rs.getString("logradouro"));
                
                retorno.setComplemento(rs.getString("complemento"));
                
                retorno.setNumero(rs.getString("numero"));
                
                retorno.setBairro(rs.getString("bairro"));
                
                retorno.setCep(rs.getString("cep"));
                
                retorno.setRegistroAcademico(rs.getString("ra"));
                
                retorno.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));
                
                retorno.setCidade( new CidadeDAO().findById(rs.getInt("cidade_id")));
                
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
     
      public void insert(EnderecoPOJO estado) throws SQLException {
        
        
        Connection conn = null;
        
        PreparedStatement pstmt = null;
        
        try {
            
             conn = new DatabaseUtils().getConnection();
             
             pstmt = conn.prepareStatement(INSERT);
              
             pstmt.setInt(1, estado.getId_endereco());
               
             pstmt.setString(2, estado.getLogradouro());
             
             pstmt.setString(3, estado.getNumero());
             
             pstmt.setString(4, estado.getBairro());
             
             pstmt.setString(5, estado.getCep());
             
             pstmt.setString(6, estado.getComplemento());
             
             pstmt.setString(7, estado.getRegistroAcademico());
             
             pstmt.setInt(8, estado.getPessoa().getId());
             
             pstmt.setInt(9, estado.getCidade().getId_cidade());
                       
             pstmt.executeUpdate();
             
             //INSERT INTO endereco(id, logradouro, numero, bairro, cep, complemento, ra, pessoa_id, cidade_id
             
        } finally {
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
    }
      
      public void update(EnderecoPOJO endereco) throws SQLException {
        
        Connection conn = null;
        
        PreparedStatement pstmt = null;

        
        try {
            
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setString(1, endereco.getLogradouro());
             
             pstmt.setString(2, endereco.getNumero());
             
             pstmt.setString(3, endereco.getBairro());
             
             pstmt.setString(4, endereco.getCep());
             
             pstmt.setString(5, endereco.getComplemento());
             
             pstmt.setString(6, endereco.getRegistroAcademico());
             
             pstmt.setInt(7, endereco.getPessoa().getId());
             
             pstmt.setInt(8, endereco.getCidade().getId_cidade());
             
             pstmt.setInt(8, endereco.getId_endereco());
           
             pstmt.executeUpdate();
           //UPDATE endereco SET logradouro = ?, numero = ?, bairro = ? cep = ?, complemento = ?, ra = ?, pessoa_id = ?, cidade_id = ? WHERE id = ?  
            
            
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
