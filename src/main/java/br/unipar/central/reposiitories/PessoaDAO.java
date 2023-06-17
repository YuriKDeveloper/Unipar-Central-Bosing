/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.reposiitories;

import br.unipar.central.model.PessoaPOJO;
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
public class PessoaDAO {
    
     private static final String INSERT = "INSERT INTO pessoa(id, email, ra) VALUES(?, ?, ?)";

    private static final String FIND_ALL = "SELECT id, email, ra FROM pessoa ";

    private static final String FIND_BY_ID = "SELECT id, email, ra FROM pessoa WHERE id = ? ";

    private static final String DELETE_BY_ID = "DELETE FROM pessoa WHERE id = ?";

    private static final String UPDATE = "UPDATE pessoa SET email = ?, ra = ? WHERE ID = ?";
    
    
    public List<PessoaPOJO> findAll() throws SQLException {
        ArrayList<PessoaPOJO> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                PessoaPOJO pessoa = new PessoaPOJO();
                pessoa.setId(rs.getInt("id"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setRegistroAcademico(rs.getString("ra"));
                retorno.add(pessoa);
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

    public PessoaPOJO findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaPOJO retorno = null;

        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new PessoaPOJO();
                retorno.setId(rs.getInt("ID"));
                retorno.setEmail(rs.getString("email"));
                retorno.setIdRegistroAcademico(rs.getString("RA"));
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

    public void insert(PessoaPOJO pessoa) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setInt(1, pessoa.getId());
            pstmt.setString(2, pessoa.getEmail());
            pstmt.setString(3, pessoa.getRegistroAcademico());

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

    public void update(PessoaPOJO pessoa) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, pessoa.getEmail());
            pstmt.setString(2, pessoa.getRegistroAcademico());
            pstmt.setDouble(3, pessoa.getId());

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
