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

public class EleitorDAO {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static Connection conn = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    public void insert(Eleitor eleitor) {
        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(
                    "INSERT INTO eleitor (nome,dataNasc,telefone,endereco,rg,cpf,matricula,instituicao) "
                    + "VALUES (?,?,?,?,?,?,?,?)");
            pstmt.setString(1, eleitor.getName());
            pstmt.setDate(2, (Date) eleitor.getBirthDate());
            pstmt.setString(3, eleitor.getPhone());
            pstmt.setString(4, eleitor.getAddress());
            pstmt.setString(5, eleitor.getRg());
            pstmt.setString(6, eleitor.getCpf());
            pstmt.setInt(7, eleitor.getMatricula());
            pstmt.setInt(8, eleitor.getInstituicao().getCod());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Êxito ao efetuar cadastro");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "RG e/ou CPF inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
    }

    public Eleitor selectByCpf(String cpf) {
        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(
                    "SELECT * FROM eleitor WHERE cpf = ?");
            pstmt.setString(1, cpf);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Eleitor e = new Eleitor();
                e.setCod(rs.getInt("cod"));
                e.setName(rs.getString("nome"));
                e.setBirthDate(rs.getDate("dataNasc"));
                e.setPhone(rs.getString("telefone"));
                e.setAddress(rs.getString("endereco"));
                e.setRg(rs.getString("rg"));
                e.setCpf(cpf);
                e.setMatricula(rs.getInt("matricula"));
                e.setInstituicao(new InstituicaoDAO().select(rs.getInt("instituicao")));
                return e;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
        return null;
    }

    public Eleitor selectByCod(Integer cod) {
        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(
                    "SELECT * FROM eleitor WHERE cod = ?");
            pstmt.setInt(1, cod);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Eleitor e = new Eleitor();
                e.setCod(cod);
                e.setName(rs.getString("nome"));
                e.setBirthDate(rs.getDate("dataNasc"));
                e.setPhone(rs.getString("telefone"));
                e.setAddress(rs.getString("endereco"));
                e.setRg(rs.getString("rg"));
                e.setCpf(rs.getString("cpf"));
                e.setMatricula(rs.getInt("matricula"));
                e.setInstituicao(new InstituicaoDAO().select(rs.getInt("instituicao")));
                return e;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
        return null;
    }

    public void update(Eleitor eleitor, String cpf) {
        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(
                    "UPDATE eleitor SET "
                    + "nome = ?, "
                    + "dataNasc = ?, "
                    + "telefone = ?, "
                    + "endereco = ?, "
                    + "matricula = ?, "
                    + "instituicao = ? "
                    + "WHERE rg = ?");
            pstmt.setString(1, eleitor.getName());
            pstmt.setDate(2, (Date) eleitor.getBirthDate());
            pstmt.setString(3, eleitor.getPhone());
            pstmt.setString(4, eleitor.getAddress());
            pstmt.setInt(5, eleitor.getMatricula());
            pstmt.setInt(6, eleitor.getInstituicao().getCod());
            pstmt.setString(7, cpf);
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Êxito na alteração");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "RG e/ou CPF inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
    }

    public List<Eleitor> list() {
        List<Eleitor> list = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(
                    "SELECT * FROM eleitor ORDER BY nome ASC"
            );
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Eleitor e = new Eleitor();
                e.setCod(rs.getInt("cod"));
                e.setName(rs.getString("nome"));
                e.setBirthDate(rs.getDate("dataNasc"));
                e.setPhone(rs.getString("telefone"));
                e.setAddress(rs.getString("endereco"));
                e.setRg(rs.getString("rg"));
                e.setCpf(rs.getString("cpf"));
                e.setMatricula(rs.getInt("matricula"));
                e.setInstituicao(new InstituicaoDAO().select(rs.getInt("instituicao")));
                list.add(e);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
        return list;
    }

    public void delete(String cpf) {
        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(
                    "DELETE FROM eleitor "
                    + "WHERE cpf = ?");
            pstmt.setString(1, cpf);
            pstmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
    }
}
