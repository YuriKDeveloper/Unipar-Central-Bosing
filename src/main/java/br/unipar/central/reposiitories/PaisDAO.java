/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.reposiitories;

import br.unipar.central.model.PaisPOJO;
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
public class PaisDAO {
    
    private static final String INSERT = "INSERT INTO pais(id,nome,sigla,ra)" + "VALUES(?,?,?,?)";
    
    private static final String FIND_ALL = "SELECT ID, NOME, SIGLA, RA FROM PAIS";
    
    private static final String FIND_BY_ID = "SELECT ID, NOME, SIGLA, RA FROM PAIS WHERE ID = ?";
    
    private static final String DELETE_BY_ID = "DELETE FROM PAIS WHERE ID = ?";
    
    private static final String UPDATE = "UPDATE PAIS SET NOME = ?, SIGLA = ?, RA = ? WHERE ID = ?";
    
    public List<PaisPOJO> findAll() throws SQLException  {
        ArrayList<PaisPOJO> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                PaisPOJO pais = new PaisPOJO();
                pais.setId_pais(rs.getInt("ID"));
                pais.setNome(rs.getString("NOME"));
                pais.setRegistroAcademico(rs.getString("RA"));
                pais.setSigla(rs.getString("SIGLA"));
                
                retorno.add(pais);
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
    
    public PaisPOJO findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PaisPOJO retorno = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareCall(FIND_BY_ID);
            
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
               retorno = new PaisPOJO();
               retorno.setId_pais(rs.getInt("ID"));
               retorno.setNome(rs.getString("NOME"));
               retorno.setRegistroAcademico(rs.getString("RA"));
               retorno.setSigla(rs.getString("SIGLA"));
               
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
    
    public void insert(PaisPOJO pais) throws SQLException {
        
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
             conn = new DatabaseUtils().getConnection();
             
             pstmt = conn.prepareStatement(INSERT);
              
             pstmt.setInt(1, pais.getId_pais());
               
             pstmt.setString(2, pais.getNome());
             
             pstmt.setString(3, pais.getSigla());
             
             pstmt.setString(4, pais.getRegistroAcademico());
            
             pstmt.executeUpdate();
             
        } finally {
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
    }
    
    public void update(PaisPOJO pais) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        
        try {
            
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setString(1, pais.getNome());
            
            pstmt.setString(2, pais.getSigla());
            
            pstmt.setString(3, pais.getRegistroAcademico());
            
            pstmt.setInt(4, pais.getId_pais());
           
            pstmt.executeUpdate();
               
            
            
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
            
            pstmt = conn.prepareCall(DELETE_BY_ID);
            
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
