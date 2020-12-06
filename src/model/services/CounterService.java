/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.connection.ConnectionFactory;
import model.dao.VotoDAO;

/**
 *
 * @author Rafael
 */
public class CounterService {

    Connection connection = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    VotoDAO votoDAO = new VotoDAO();

    public int countCandidato(Integer cod) {
        Integer total = 0;
        try {
            connection = ConnectionFactory.getConnection();
            pstmt = connection.prepareStatement(
                    "SELECT COUNT(*) AS Votos FROM voto WHERE voto.cod_candidato = ?");
            pstmt.setInt(1, cod);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                total = rs.getInt("Votos");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return total;

    }

    public int countWhite() {
        Integer total = 0;
        try {
            connection = ConnectionFactory.getConnection();
            pstmt = connection.prepareStatement(
                    "SELECT COUNT(*) AS Votos FROM voto WHERE voto.cod_candidato is null");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                total = rs.getInt("Votos");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return total;

    }

    public int total() {
        Integer total = 0;
        try {
            connection = ConnectionFactory.getConnection();
            pstmt = connection.prepareStatement("SELECT COUNT(*) AS Votos FROM voto");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                total = rs.getInt("Votos");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return total;

    }

    public void resetAll() {     
            try {
                LogService.log(votoDAO.list());
                connection = ConnectionFactory.getConnection();
                pstmt = connection.prepareStatement("DELETE FROM voto");
                pstmt.execute();
                pstmt = connection.prepareStatement("DELETE FROM candidato");
                pstmt.execute();
                pstmt = connection.prepareStatement("DELETE FROM imagem");
                pstmt.execute();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
    }

}
