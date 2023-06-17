/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.reposiitories;
import br.unipar.central.model.AgenciaPOJO;
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
public class AgenciaDAO {
    
    private static final String INSERT = "INSERT INTO agencia(id, codigo, digito, razaosocial, cnpj, ra, banco_id) VALUES(?, ?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT id, codigo, digito, razaosocial, cnpj, ra , banco_id FROM agencia ";

    private static final String FIND_BY_ID = "SELECT id, codigo, digito, razaosocial, cnpj, ra, banco_id FROM agencia WHERE id = ? ";

    private static final String DELETE_BY_ID = "DELETE FROM agencia WHERE id = ?";

    private static final String UPDATE = "UPDATE agencia SET codigo = ?, digito = ?, razaosocial = ?, cnpj = ?, ra = ?, banco_id = ? WHERE ID = ?";
    
    public List<AgenciaPOJO> findAll() throws SQLException  {
        ArrayList<AgenciaPOJO> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                
                AgenciaPOJO agencia = new AgenciaPOJO();
                agencia.setId(rs.getInt("id"));
                agencia.setCodigo(rs.getString("codigo"));
                agencia.setDigito(rs.getString("digito"));
                agencia.setRazaoSocial(rs.getString("razaosocial"));
                agencia.setCnpj(rs.getString("cnpj"));
                agencia.setRegistroAcademico(rs.getString("ra"));
                agencia.setBanco(new BancoDAO().findById(rs.getInt("banco_id")));

                
                retorno.add(agencia);
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
    
    public AgenciaPOJO findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        AgenciaPOJO retorno = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_BY_ID);
            
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
               retorno = new AgenciaPOJO();
               retorno.setId(rs.getInt("id"));
               retorno.setRazaoSocial(rs.getString("nome"));
               retorno.setDigito(rs.getString("digito"));
               retorno.setCodigo(rs.getString("codigo"));
               retorno.setCnpj(rs.getString("cnpj"));
               retorno.setBanco(new BancoDAO().findById(rs.getInt("banco_id")));
               retorno.setRegistroAcademico(rs.getString("RA"));
               
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
    
    public void insert(AgenciaPOJO agencia) throws SQLException {
        
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
             conn = new DatabaseUtils().getConnection();
             
             pstmt = conn.prepareStatement(INSERT);
              
             pstmt.setInt(1, agencia.getId());
               
             pstmt.setString(2, agencia.getCodigo());
                       
             pstmt.setString(3, agencia.getDigito());
             
             pstmt.setString(4, agencia.getRazaoSocial());
             
             pstmt.setString(5,agencia.getCnpj());
             
             pstmt.setString(6,agencia.getRegistroAcademico());
             
             pstmt.setInt(7, agencia.getBanco().getId());
            
             pstmt.executeUpdate();
             
        } finally {
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
    }
    
       public void update(AgenciaPOJO agencia) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        
        try {
            
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setInt(1, agencia.getId());
               
            pstmt.setString(2, agencia.getCodigo());
                       
            pstmt.setString(3, agencia.getDigito());
             
            pstmt.setString(4, agencia.getRazaoSocial());
             
            pstmt.setString(5,agencia.getCnpj());
             
            pstmt.setString(6,agencia.getRegistroAcademico());
             
            pstmt.setInt(7, agencia.getBanco().getId());
           
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
