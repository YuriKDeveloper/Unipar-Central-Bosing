/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.reposiitories;

import br.unipar.central.model.TransacaoPOJO;
import br.unipar.central.model.enums.TipoTransacaoEnums;
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
public class TransacaoDAO {
    
      private static final String INSERT = "INSERT INTO transacao(id, valor, tipo, ra, conta_origem, conta_destino, datahora) VALUES(?, ?, ?, ?, ?, ?, ?)";

      private static final String FIND_ALL = "SELECT id, valor, tipo, ra, conta_origem, conta_destino, datahora FROM transacao ";

      private static final String FIND_BY_ID = "SELECT id, valor, tipo, ra, conta_origem, conta_destino, datahora FROM transacao WHERE id = ? ";

      private static final String DELETE_BY_ID = "DELETE FROM transacao WHERE id = ?";

      private static final String UPDATE = "UPDATE transacao SET valor = ?, tipo = ? ra = ?, conta_origem = ?, conta_destino = ? datahora = ? WHERE id = ?";
    
    
    
    
        public List<TransacaoPOJO> findAll() throws SQLException {
        
        ArrayList<TransacaoPOJO> retorno = new ArrayList<>();
        
        Connection conn = null;
        
        PreparedStatement pstmt = null;
        
        ResultSet rs = null;

        try {

            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                
                TransacaoPOJO transacao = new TransacaoPOJO();
                
                transacao.setId(rs.getInt("id"));
                
                transacao.setValor(rs.getDouble("valor"));
                
                transacao.setTipo(TipoTransacaoEnums.paraEnum(rs.getInt("tipo")));
                
                transacao.setDataHora(rs.getTimestamp("datahora"));
               
                transacao.setRegistroAcademico(rs.getString("ra"));
                
                transacao.setContaOrigem(new ContaDAO().findById(rs.getInt("conta_origem")));
                
                transacao.setContaDestino(new ContaDAO().findById(rs.getInt("conta_destino")));

                retorno.add(transacao);
            }
            //id, valor, tipo, ra, conta_origem, conta_destino
        } finally {

            if (conn != null) {
                conn.close();
            }

            if (conn != null) {
                pstmt.close();
            }
        }

        return retorno;
    }

    public TransacaoPOJO findById(int id) throws SQLException {

        Connection conn = null;
        
        PreparedStatement pstmt = null;
        
        ResultSet rs = null;
        
        TransacaoPOJO retorno = null;

        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                
                retorno = new TransacaoPOJO();
                
                retorno.setId(rs.getInt("id"));
                
                retorno.setValor(Double.parseDouble(rs.getString("valor")));
                
                retorno.setTipo(TipoTransacaoEnums.paraEnum(rs.getInt("tipo")));
                
                retorno.setDataHora(rs.getTimestamp("datahora"));
                
                retorno.setRegistroAcademico(rs.getString("ra"));
                
                retorno.setContaOrigem(new ContaDAO().findById(rs.getInt("conta_origem")));
                
                retorno.setContaDestino(new ContaDAO().findById(rs.getInt("conta_origem")));

            }
        } finally {

            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return retorno;
    }

    public void insert(TransacaoPOJO transacao) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setInt(1, transacao.getId());
            
            pstmt.setDouble(2, transacao.getValor());
            
            pstmt.setString(3, transacao.getTipo().name());
            
            pstmt.setString(4, transacao.getRegistroAcademico());
            
            pstmt.setInt(5, transacao.getContaOrigem().getId());
            
            pstmt.setInt(6, transacao.getContaDestino().getId());
            
            pstmt.setTimestamp(7, transacao.getDataHora());
            
            pstmt.executeUpdate();

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public void update(TransacaoPOJO transacao) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setDouble(1, transacao.getValor());
            
            pstmt.setString(2, transacao.getTipo().name());
            
            pstmt.setString(3, transacao.getRegistroAcademico());
            
            pstmt.setInt(4, transacao.getContaOrigem().getId());
            
            pstmt.setInt(5, transacao.getContaDestino().getId());
            
            pstmt.setTimestamp(6, transacao.getDataHora());
            
            pstmt.setInt(7, transacao.getId());

            pstmt.executeUpdate();

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
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

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
