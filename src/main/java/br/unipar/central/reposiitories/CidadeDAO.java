/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.reposiitories;

import br.unipar.central.model.CidadePOJO;
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
public class CidadeDAO {
    
    private static final String INSERT = "INSERT INTO CIDADE(id,nome,ra,estado_id)" + "VALUES(?,?,?,?,?)";
    
    private static final String FIND_ALL = "SELECT id, nome, ra, estado_id FROM cidade";
    
    private static final String FIND_BY_ID = "SELECT id, nome, ra, estado_id FROM cidade WHERE ID = ?";
    
    private static final String DELETE_BY_ID = "DELETE FROM CIDADE WHERE ID = ?";
    
    private static final String UPDATE = "UPDATE CIDADE SET nome = ?, ra = ?, estado_id = ? WHERE ID = ?";
    
    public List<CidadePOJO> findAll() throws SQLException  {
        ArrayList<CidadePOJO> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                CidadePOJO estado = new CidadePOJO();
                estado.setId_cidade(rs.getInt("id"));
                estado.setNome(rs.getString("nome"));
                estado.setRegistroAcademico(rs.getString("ra"));
                estado.setEstado(new EstadoDAO().findById(rs.getInt("estado_id")));
                
                retorno.add(estado);
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
    
    public CidadePOJO findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        CidadePOJO retorno = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_BY_ID);
            
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
               retorno = new CidadePOJO();
               retorno.setId_cidade(rs.getInt("id"));
               retorno.setNome(rs.getString("nome"));
               retorno.setRegistroAcademico(rs.getString("ra"));
               retorno.setEstado(new EstadoDAO().findById(rs.getInt("estado_id")));
               
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
    
    public void insert(CidadePOJO cidade) throws SQLException {
        
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
             conn = new DatabaseUtils().getConnection();
             
             pstmt = conn.prepareStatement(INSERT);
              
             pstmt.setInt(1, cidade.getId_cidade());
               
             pstmt.setString(2, cidade.getNome());
                       
             pstmt.setString(3, cidade.getRegistroAcademico());
             
             pstmt.setInt(4, cidade.getEstado().getId_estado());
            
             pstmt.executeUpdate();
             
        } finally {
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
    }
    
       public void update(CidadePOJO cidade) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        
        try {
            
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setString(1, cidade.getNome());
            
            pstmt.setString(2, cidade.getRegistroAcademico());
            
            pstmt.setInt(3, cidade.getEstado().getId_estado());
            
            pstmt.setInt(4, cidade.getId_cidade());
                    
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
