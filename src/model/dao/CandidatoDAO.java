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
import model.connection.DBException;

public class CandidatoDAO {

    public static Connection conn = null;
    public static PreparedStatement st = null;
    public static ResultSet rs = null;

    public void inserir(Candidato candidato) {
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(
                    "INSERT INTO candidato (nome,num,chapa,imagem) "
                    + "VALUES (?,?,?,?)");
            st.setString(1, candidato.getName());
            st.setInt(2, candidato.getNum());
            st.setString(3, candidato.getChapa());
            st.setInt(4, candidato.getImagem().getCod());
            st.execute();
            JOptionPane.showMessageDialog(null, "Êxito ao efetuar o cadastro");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Número de Candidato existente", "Erro", JOptionPane.ERROR_MESSAGE);
            throw new DBException(e.getMessage());
        }
    }
    
    public void insertWithoutImage(Candidato candidato) {
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(
                    "INSERT INTO candidato (nome,num,chapa) "
                    + "VALUES (?,?,?)");
            st.setString(1, candidato.getName());
            st.setInt(2, candidato.getNum());
            st.setString(3, candidato.getChapa());
            st.execute();
            JOptionPane.showMessageDialog(null, "Êxito ao efetuar o cadastro");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Número de Candidato existente", "Erro", JOptionPane.ERROR_MESSAGE);
            throw new DBException(e.getMessage());
        }
    }
    
    public Candidato select(Integer num) {
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(
                    "SELECT * FROM candidato WHERE num = ?");
            st.setInt(1, num);
            rs = st.executeQuery();
            if (rs.next()) {
                Candidato c = new Candidato();
                c.setCod(rs.getInt("cod"));
                c.setName(rs.getString("nome"));
                c.setNum(num);
                c.setChapa(rs.getString("chapa"));
                c.setImagem(new ImagemDAO().buscar(rs.getInt("imagem")));
                return c;
            }
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
        return null;
    }

    public Candidato selectByCod(Integer cod) {
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(
                    "SELECT * FROM candidato WHERE cod = ?");
            st.setInt(1, cod);
            rs = st.executeQuery();
            if (rs.next()) {
                Candidato c = new Candidato();
                c.setCod(cod);
                c.setName(rs.getString("nome"));
                c.setNum(rs.getInt("num"));
                c.setChapa(rs.getString("chapa"));
                c.setImagem(new ImagemDAO().buscar(rs.getInt("imagem")));
                return c;
            }
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
        return null;
    }

    public List<Candidato> listar() {
        List<Candidato> list = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(
                    "SELECT * FROM candidato ORDER BY nome ASC"
            );
            rs = st.executeQuery();
            while(rs.next()){
                Candidato c = new Candidato();
                c.setCod(rs.getInt("cod"));
                c.setName(rs.getString("nome"));
                c.setNum(rs.getInt("num"));
                c.setChapa(rs.getString("chapa"));
                c.setImagem(new ImagemDAO().buscar(rs.getInt("imagem")));
                list.add(c);
            }
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
        return list;
    }
    
    public void excluir(int num) {
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(
                    "DELETE FROM candidato "
                    + "WHERE num = ?");
            st.setInt(1, num);
            st.execute();
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
    }
    
    public void update(Candidato candidato, int cod) {
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(
                    "UPDATE candidato SET "
                            + "nome = ?, "
                            + "num = ?, "
                            + "chapa = ?, "
                            + "imagem = ? "
                    + "WHERE cod = ?");
            st.setString(1, candidato.getName());
            st.setInt(2, candidato.getNum());
            st.setString(3, candidato.getChapa());
            st.setInt(4, candidato.getImagem().getCod());
            st.setInt(5, cod);
            st.execute();
            JOptionPane.showMessageDialog(null, "Êxito na alteração");
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
    }
    
    public void updateWithoutImage(Candidato candidato) {
        try {
            conn = ConnectionFactory.getConnection();
            st = conn.prepareStatement(
                    "UPDATE candidato SET "
                            + "nome = ?, "
                            + "num = ?, "
                            + "chapa = ? "
                    + "WHERE cod = ?");
            st.setString(1, candidato.getName());
            st.setInt(2, candidato.getNum());
            st.setString(3, candidato.getChapa());
            st.setInt(4, candidato.getCod());
            st.execute();
            JOptionPane.showMessageDialog(null, "Êxito na alteração");
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
    }
}
