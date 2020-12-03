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

/**
 *
 * @author Rafael
 */
public class CounterService {
    

    public static int countCandidato(Integer cod) {
        Connection connection = null;
        Integer total = 0;

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT COUNT(*) AS Votos FROM voto WHERE voto.cod_candidato = ?");
            pstmt.setInt(1, cod);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                total = rs.getInt("Votos");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro");
            e.printStackTrace();
        }
        return total;
    }

    public static int total() {
        Connection connection = null;
        Integer total = 0;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT COUNT(*) AS Votos FROM voto");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                total = rs.getInt("Votos");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro");
            e.printStackTrace();
        }
        return total;
    }

}
