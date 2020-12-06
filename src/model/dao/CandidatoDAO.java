package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.bean.Candidato;
import model.connection.ConnectionFactory;

public class CandidatoDAO {

    public static Connection conn = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;

    public void insert(Candidato candidato) {
        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(
                    "INSERT INTO candidato (nome,num,chapa,imagem) "
                    + "VALUES (?,?,?,?)");
            pstmt.setString(1, candidato.getName());
            pstmt.setInt(2, candidato.getNum());
            pstmt.setString(3, candidato.getChapa());
            pstmt.setInt(4, candidato.getImage().getCod());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Êxito ao efetuar o cadastro");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Número de Candidato existente", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
    }

    public void insertWithoutImage(Candidato candidato) {
        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(
                    "INSERT INTO candidato (nome,num,chapa) "
                    + "VALUES (?,?,?)");
            pstmt.setString(1, candidato.getName());
            pstmt.setInt(2, candidato.getNum());
            pstmt.setString(3, candidato.getChapa());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Êxito ao efetuar o cadastro");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Número de Candidato existente", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
    }

    public Candidato select(Integer num) {
        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(
                    "SELECT * FROM candidato WHERE num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Candidato c = new Candidato();
                c.setCod(rs.getInt("cod"));
                c.setName(rs.getString("nome"));
                c.setNum(num);
                c.setChapa(rs.getString("chapa"));
                c.setImage(new ImagemDAO().select(rs.getInt("imagem")));
                return c;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
        return null;
    }

    public Candidato selectByCod(Integer cod) {
        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(
                    "SELECT * FROM candidato WHERE cod = ?");
            pstmt.setInt(1, cod);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Candidato c = new Candidato();
                c.setCod(cod);
                c.setName(rs.getString("nome"));
                c.setNum(rs.getInt("num"));
                c.setChapa(rs.getString("chapa"));
                c.setImage(new ImagemDAO().select(rs.getInt("imagem")));
                return c;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
        return null;
    }

    public List<Candidato> list() {
        List<Candidato> list = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(
                    "SELECT * FROM candidato ORDER BY nome ASC"
            );
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Candidato c = new Candidato();
                c.setCod(rs.getInt("cod"));
                c.setName(rs.getString("nome"));
                c.setNum(rs.getInt("num"));
                c.setChapa(rs.getString("chapa"));
                c.setImage(new ImagemDAO().select(rs.getInt("imagem")));
                list.add(c);
                return list;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
        return list;
    }

    public void delete(int num) {
        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(
                    "DELETE FROM candidato "
                    + "WHERE num = ?");
            pstmt.setInt(1, num);
            pstmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
    }

    public void update(Candidato candidato, int cod) {
        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(
                    "UPDATE candidato SET "
                    + "nome = ?, "
                    + "num = ?, "
                    + "chapa = ?, "
                    + "imagem = ? "
                    + "WHERE cod = ?");
            pstmt.setString(1, candidato.getName());
            pstmt.setInt(2, candidato.getNum());
            pstmt.setString(3, candidato.getChapa());
            pstmt.setInt(4, candidato.getImage().getCod());
            pstmt.setInt(5, cod);
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Êxito na alteração");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateWithoutImage(Candidato candidato, int cod) {
        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(
                    "UPDATE candidato SET "
                    + "nome = ?, "
                    + "num = ?, "
                    + "chapa = ? "
                    + "WHERE cod = ?");
            pstmt.setString(1, candidato.getName());
            pstmt.setInt(2, candidato.getNum());
            pstmt.setString(3, candidato.getChapa());
            pstmt.setInt(4, cod);
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Êxito na alteração");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
