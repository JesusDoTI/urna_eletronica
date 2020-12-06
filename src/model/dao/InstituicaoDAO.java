package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import model.bean.Instituicao;
import model.connection.ConnectionFactory;

public class InstituicaoDAO {

    private static Connection conn = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    public Instituicao select(Integer cod) {
        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM instituicao WHERE cod = ?");
            pstmt.setInt(1, cod);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Instituicao i = new Instituicao();
                i.setCod(cod);
                i.setCampus(rs.getString("campus"));
                i.setAddress(rs.getString("endereco"));
                i.setPhone(rs.getString("telefone"));
                return i;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
        return null;
    }

    public List<Instituicao> list() {
        List<Instituicao> list = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement("SELECT cod, campus FROM instituicao");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Instituicao inst = new Instituicao();
                inst.setCod(rs.getInt(1));
                inst.setCampus(rs.getString(2));

                list.add(inst);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
        return list;
    }
}
