/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.reposiitories;

import br.unipar.central.model.TelefonePOJO;
import br.unipar.central.model.TelefonePOJO;
import br.unipar.central.model.enums.TipoOperadoraEnum;
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
public class TelefoneDAO {
    private static final String INSERT = "INSERT INTO telefone(id, numero, operadora, ra, agencia_id, pessoa_id) VALUES(?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT id, numero, operadora, ra, agencia_id, pessoa_id FROM telefone ";

    private static final String FIND_BY_ID = "SELECT id, numero, operadora, ra, agencia_id, pessoa_id FROM telefone WHERE id = ? ";

    private static final String DELETE_BY_ID = "DELETE FROM telefone WHERE id = ?";

    private static final String UPDATE = "UPDATE telefone SET  numero = ?, operadora = ?, ra = ? agencia_id = ?, pessoa_id = ? WHERE id = ?";
    
     public List<TelefonePOJO> findAll() throws SQLException {
        ArrayList<TelefonePOJO> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                
                TelefonePOJO telefone = new TelefonePOJO();
                telefone.setId_telefone(rs.getInt("id"));
                telefone.setNumero(rs.getString("numero"));
                telefone.setOperadora(TipoOperadoraEnum.paraEnum(rs.getInt("operadora")));
                telefone.setRegistroAcademico(rs.getString("ra"));
                telefone.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));
                telefone.setAgencia(new AgenciaDAO().findById(rs.getInt("agencia_id")));
                
                retorno.add(telefone);
            }
        } finally {

            if (rs != null) {
                rs.close();
            }

            if (conn != null) {
                conn.close();
            }

            if (conn != null) {
                pstmt.close();
            }
        }

        return retorno;
    }
     
     public TelefonePOJO findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        TelefonePOJO retorno = null;

        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                
                retorno = new TelefonePOJO();
                retorno.setId_telefone(rs.getInt("id"));
                retorno.setNumero(rs.getString("numero"));
                retorno.setOperadora(TipoOperadoraEnum.paraEnum(rs.getInt("operadora")));
                retorno.setRegistroAcademico(rs.getString("ra"));
                retorno.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));
                retorno.setAgencia(new AgenciaDAO().findById(rs.getInt("agencia_id")));
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
     
     public void insert(TelefonePOJO telefone) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setInt(1, telefone.getId_telefone());
            pstmt.setString(2, telefone.getNumero());
            pstmt.setString(3, telefone.getOperadora().name());
            pstmt.setString(4 , telefone.getRegistroAcademico());
            pstmt.setInt(5, telefone.getAgencia().getId());
            pstmt.setInt(5, telefone.getPessoa().getId());

            pstmt.executeUpdate();
            
        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
//INSERT INTO telefone(id, numero, operadora, ra, agencia_id, pessoa_id) VALUES(?, ?, ?, ?, ?, ?)
    }

    public void update(TelefonePOJO telefone) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

           pstmt.setString(2, telefone.getNumero());
            pstmt.setString(3, telefone.getOperadora().name());
            pstmt.setString(4 , telefone.getRegistroAcademico());
            pstmt.setInt(5, telefone.getAgencia().getId());
            pstmt.setInt(5, telefone.getPessoa().getId());
            pstmt.setInt(1, telefone.getId_telefone());
            
            
            pstmt.executeUpdate();

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        //UPDATE telefone SET  numero = ?, operadora = ?, ra = ? agencia_id = ?, pessoa_id = ? WHERE id = ?

    }
    
    //private static final String UPDATE = "UPDATE pessoafisica SET nome = ?, rg = ?, datanascimento = ?, pessoa_id = ? WHERE cpf = ?";

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
