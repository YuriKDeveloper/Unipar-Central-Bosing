/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.reposiitories;

import br.unipar.central.model.PessoaJuridicaPOJO;
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
public class PessoaJuridicaDAO {
    
            private static final String INSERT = "INSERT INTO pessoajuridica(razaosocial, cnpj, cnaeprincipal, fantasia, pessoa_id) VALUES(?, ?, ?, ?, ?)";

           private static final String FIND_ALL = "SELECT razaosocial, cnpj, cnaeprincipal, fantasia, pessoa_id FROM pessoajuridica ";

           private static final String FIND_BY_ID = "SELECT razaosocial, cnpj, cnaeprincipal, fantasia, pessoa_id FROM pessoajuridica WHERE cnpj = ? ";

           private static final String DELETE_BY_ID = "DELETE FROM pessoajuridica WHERE cnpj = ?";

           private static final String UPDATE = "UPDATE pessoajuridica SET razaosocial = ?, cnaeprincipal = ?, fantasia = ?, pessoa_id = ? WHERE cnpj = ?";

         public List<PessoaJuridicaPOJO> findAll() throws SQLException {
        ArrayList<PessoaJuridicaPOJO> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                
                PessoaJuridicaPOJO pessoajuridica = new PessoaJuridicaPOJO();
                pessoajuridica.setRazaoSocial(rs.getString("razaosocial"));
                pessoajuridica.setCnpj(rs.getString("cnpj"));
                pessoajuridica.setCnaePrincipal(rs.getString("cnaeprincipal"));
                pessoajuridica.setFantasia(rs.getString("fantasia"));
                pessoajuridica.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));
                
                retorno.add(pessoajuridica);
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
     
     public PessoaJuridicaPOJO findById(String cnpj) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaJuridicaPOJO retorno = null;

        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setString(1, cnpj);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                
                retorno = new PessoaJuridicaPOJO();
                retorno.setRazaoSocial(rs.getString("razaosocial"));
                retorno.setCnpj(rs.getString("cnpj"));
                retorno.setCnaePrincipal(rs.getString("cnaeprincipal"));
                retorno.setFantasia(rs.getString("fantasia"));
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
     
     public void insert(PessoaJuridicaPOJO pessoa) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setString(1, pessoa.getRazaoSocial());
            pstmt.setString(2, pessoa.getCnpj());
            pstmt.setString(3, pessoa.getCnaePrincipal());
            pstmt.setString(4 , pessoa.getFantasia());
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
//INSERT INTO pessoajuridica(razaosocial, cnpj, cnaeprincipal, fantasia, pessoa_id) VALUES(?, ?, ?, ?, ?)";
    }

    public void update(PessoaJuridicaPOJO pessoa) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

           pstmt.setString(1, pessoa.getRazaoSocial());
            pstmt.setString(2, pessoa.getCnaePrincipal());
            pstmt.setString(3, pessoa.getFantasia());
            pstmt.setInt(4 , pessoa.getPessoa().getId());
            pstmt.setString(5, pessoa.getCnpj());
            
            
            pstmt.executeUpdate();

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        //"UPDATE pessoajuridica SET razaosocial = ?, cnaeprincipal = ?, fantasia = ?, pessoa_id = ? WHERE cnpj = ?";

    }
    
    //private static final String UPDATE = "UPDATE pessoafisica SET nome = ?, rg = ?, datanascimento = ?, pessoa_id = ? WHERE cpf = ?";

    public void delete(String cnpj) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);

            pstmt.setString(1, cnpj);

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
