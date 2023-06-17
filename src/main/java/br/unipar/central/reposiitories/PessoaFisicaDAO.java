/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.reposiitories;

import br.unipar.central.model.PessoaFisicaPOJO;
import br.unipar.central.model.PessoaFisicaPOJO;
import br.unipar.central.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yuriz
 */
public class PessoaFisicaDAO {
    
    private static final String INSERT = "INSERT INTO pessoafisica(nome, cpf, rg, datanascimento, pessoa_id) VALUES(?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT nome, cpf, rg, datanascimento, pessoa_id FROM pessoafisica ";

    private static final String FIND_BY_ID = "SELECT nome, cpf, rg, datanascimento, pessoa_id FROM pessoafisica WHERE cpf = ? ";

    private static final String DELETE_BY_ID = "DELETE FROM pessoafisica WHERE cpf = ?";

    private static final String UPDATE = "UPDATE pessoafisica SET nome = ?, rg = ?, datanascimento = ?, pessoa_id = ? WHERE cpf = ?";
    
     public List<PessoaFisicaPOJO> findAll() throws SQLException {
        ArrayList<PessoaFisicaPOJO> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                
                PessoaFisicaPOJO pessoafisica = new PessoaFisicaPOJO();
                pessoafisica.setNome(rs.getString("nome"));
                pessoafisica.setCpf(rs.getString("cpf"));
                pessoafisica.setRg(rs.getString("rg"));
                pessoafisica.setDatanascimento(rs.getDate("data"));
                pessoafisica.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));
                
                retorno.add(pessoafisica);
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
     
     public PessoaFisicaPOJO findById(String cpf) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaFisicaPOJO retorno = null;

        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setString(1, cpf);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new PessoaFisicaPOJO();
                retorno.setNome(rs.getString("nome"));
                retorno.setCpf(rs.getString("cpf"));
                retorno.setRg(rs.getString("rg"));
                retorno.setDatanascimento(rs.getDate("data"));
                retorno.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));
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
     
     public void insert(PessoaFisicaPOJO pessoa) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setString(1, pessoa.getNome());
            pstmt.setString(2, pessoa.getCpf());
            pstmt.setString(3, pessoa.getRg());
            pstmt.setDate(4 , Date.valueOf(pessoa.getDatanascimento().toString()));
            pstmt.setInt(5, pessoa.getPessoa().getId());
            
            
            pstmt.executeUpdate();
            
        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
//"INSERT INTO pessoafisica(nome, cpf, rg, datanascimento, pessoa_id) VALUES(?, ?, ?, ?, ?)";
    }

    public void update(PessoaFisicaPOJO pessoa) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, pessoa.getNome());
            pstmt.setString(2, pessoa.getRg());
            pstmt.setDate(1 , Date.valueOf(pessoa.getDatanascimento().toString()));
            pstmt.setInt(2, pessoa.getPessoa().getId());
            pstmt.setString(2, pessoa.getCpf());
            
            
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
    
    //private static final String UPDATE = "UPDATE pessoafisica SET nome = ?, rg = ?, datanascimento = ?, pessoa_id = ? WHERE cpf = ?";

    public void delete(String cpf) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);

            pstmt.setString(1, cpf);

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
