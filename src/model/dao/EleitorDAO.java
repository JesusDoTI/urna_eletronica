package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.bean.Eleitor;
import model.connection.ConnectionFactory;
import model.connection.DBException;

public class EleitorDAO {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static Connection conn = null;
    private static PreparedStatement st = null;
    private static ResultSet rs = null;

    public void inserir(Eleitor eleitor) {
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(
                    "INSERT INTO eleitor (nome,dataNasc,telefone,endereco,rg,cpf,matricula,instituicao) "
                    + "VALUES (?,?,?,?,?,?,?,?)");
            st.setString(1, eleitor.getNome());
            st.setDate(2, (Date) eleitor.getDataNasc());
            st.setString(3, eleitor.getTelefone());
            st.setString(4, eleitor.getEndereco());
            st.setString(5, eleitor.getRg());
            st.setString(6, eleitor.getCpf());
            st.setInt(7, eleitor.getMatricula());
            st.setInt(8, eleitor.getInstituicao().getCod());
            st.execute();
            JOptionPane.showMessageDialog(null, "Êxito ao efetuar cadastro");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "RG ou CPF inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
            throw new DBException(e.getMessage());
        }
    }

    public Eleitor selectByRg(String rg) {
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(
                    "SELECT * FROM eleitor WHERE rg = ?");
            st.setString(1, rg);
            rs = st.executeQuery();
            if (rs.next()) {
                Eleitor e = new Eleitor();
                e.setCod(rs.getInt("cod"));
                e.setNome(rs.getString("nome"));
                e.setDataNasc(rs.getDate("dataNasc"));
                e.setTelefone(rs.getString("telefone"));
                e.setEndereco(rs.getString("endereco"));
                e.setRg(rg);
                e.setCpf(rs.getString("cpf"));
                e.setMatricula(rs.getInt("matricula"));
                e.setInstituicao(new InstituicaoDAO().select(rs.getInt("instituicao")));
                return e;
            }
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
        return null;
    }

    public Eleitor selectByCod(Integer cod) {
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(
                    "SELECT * FROM eleitor WHERE cod = ?");
            st.setInt(1, cod);
            rs = st.executeQuery();
            if (rs.next()) {
                Eleitor e = new Eleitor();
                e.setCod(cod);
                e.setNome(rs.getString("nome"));
                e.setDataNasc(rs.getDate("dataNasc"));
                e.setTelefone(rs.getString("telefone"));
                e.setEndereco(rs.getString("endereco"));
                e.setRg(rs.getString("rg"));
                e.setCpf(rs.getString("cpf"));
                e.setMatricula(rs.getInt("matricula"));
                e.setInstituicao(new InstituicaoDAO().select(rs.getInt("instituicao")));
                return e;
            }
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
        return null;
    }

    public void update(Eleitor eleitor, String rg) {
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(
                    "UPDATE eleitor SET "
                    + "nome = ?, "
                    + "dataNasc = ?, "
                    + "telefone = ?, "
                    + "endereco = ?, "
                    + "matricula = ?, "
                    + "instituicao = ? "
                    + "WHERE rg = ?");
            st.setString(1, eleitor.getNome());
            st.setDate(2, (Date) eleitor.getDataNasc());
            st.setString(3, eleitor.getTelefone());
            st.setString(4, eleitor.getEndereco());
            st.setInt(5, eleitor.getMatricula());
            st.setInt(6, eleitor.getInstituicao().getCod());
            st.setString(7, rg);
            st.execute();
            JOptionPane.showMessageDialog(null, "Êxito na alteração");
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "RG ou CPF inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
           throw new DBException(e.getMessage());
         
        }
    }

    public List<Eleitor> list() {
        List<Eleitor> list = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(
                    "SELECT * FROM eleitor ORDER BY nome ASC"
            );
            rs = st.executeQuery();
            while (rs.next()) {
                Eleitor e = new Eleitor();
                e.setCod(rs.getInt("cod"));
                e.setNome(rs.getString("nome"));
                e.setDataNasc(rs.getDate("dataNasc"));
                e.setTelefone(rs.getString("telefone"));
                e.setEndereco(rs.getString("endereco"));
                e.setRg(rs.getString("rg"));
                e.setCpf(rs.getString("cpf"));
                e.setMatricula(rs.getInt("matricula"));
                e.setInstituicao(new InstituicaoDAO().select(rs.getInt("instituicao")));
                list.add(e);
            }
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
        return list;
    }
    
    public void delete(String rg) {
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(
                    "DELETE FROM eleitor "
                    + "WHERE rg = ?");
            st.setString(1, rg);
            st.execute();
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
    }
}
