/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.reposiitories;
import br.unipar.central.model.BancoPOJO;
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
public class BancoDAO {
    
    private static final String INSERT = "INSERT INTO banco(id, nome, ra) VALUES(?, ?, ?)";

    private static final String FIND_ALL = "SELECT id, nome, ra FROM banco ";

    private static final String FIND_BY_ID = "SELECT id, nome, ra FROM banco WHERE id = ? ";

    private static final String DELETE_BY_ID = "DELETE FROM banco WHERE id = ?";

    private static final String UPDATE = "UPDATE banco SET  nome = ?, ra = ? WHERE ID = ?";
    
    public List<BancoPOJO> findAll() throws SQLException  {
        ArrayList<BancoPOJO> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                
                BancoPOJO banco = new BancoPOJO();
                banco.setId(rs.getInt("ID"));
                banco.setNome(rs.getString("NOME"));
                banco.setRegistroAcademico(rs.getString("RA"));
                
                retorno.add(banco);
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
    
    public BancoPOJO findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        BancoPOJO retorno = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareCall(FIND_BY_ID);
            
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                
               retorno = new BancoPOJO();
               retorno.setId(rs.getInt("id"));
               retorno.setNome(rs.getString("nome"));
               retorno.setRegistroAcademico(rs.getString("ra"));
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
    
    public void insert(BancoPOJO banco) throws SQLException {
        
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
             conn = new DatabaseUtils().getConnection();
             
             pstmt = conn.prepareStatement(INSERT);
              
             pstmt.setInt(1, banco.getId());
               
             pstmt.setString(2, banco.getNome());
                       
             pstmt.setString(3, banco.getRegistroAcademico());
             
            
             pstmt.executeUpdate();
             
        } finally {
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
    }
    
     public void update(BancoPOJO banco) throws SQLException {
        
         
         Connection conn = null;
        PreparedStatement pstmt = null;

        
        try {
            
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setString(1, banco.getNome());
            
            pstmt.setString(2, banco.getRegistroAcademico());
            
            pstmt.setInt(3, banco.getId());
                    
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
