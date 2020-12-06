package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;
import model.bean.Eleitor;

import model.bean.Voto;
import model.connection.ConnectionFactory;

public class VotoDAO {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static Connection conn = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    public void vote(Integer num, String cpf) {
        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement("INSERT INTO voto (dataHora, cod_candidato, cod_eleitor) VALUES (?,?,?)");
            pstmt.setString(1, sdf.format(new java.sql.Date(Calendar.getInstance().getTimeInMillis())));
            pstmt.setInt(2, new CandidatoDAO().select(num).getCod());
            pstmt.setInt(3, new EleitorDAO().selectByCpf(cpf).getCod());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Operação concluída com êxito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Número de Candidato inexistente", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
    }

    public void whiteVote(String cpf) {
        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement("INSERT INTO voto (dataHora, cod_eleitor) VALUES (?,?)");
            pstmt.setString(1, sdf.format(new java.sql.Date(Calendar.getInstance().getTimeInMillis())));
            pstmt.setInt(2, new EleitorDAO().selectByCpf(cpf).getCod());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Operação concluída com êxito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
    }

    public List<Voto> list() {
        List<Voto> result = new ArrayList<>();

        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM voto");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Voto v = new Voto();
                v.setCandidato(new CandidatoDAO().selectByCod(rs.getInt("cod_candidato")));
                v.setEleitor(new EleitorDAO().selectByCod(rs.getInt("cod_eleitor")));
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                v.setDataHora(sdf.parse(rs.getString("dataHora")));
                result.add(v);
            }
        } catch (SQLException | ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
        return result;

    }

    public boolean select(Eleitor eleitor) {
        try {
            conn = ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(
                    "SELECT * FROM voto WHERE cod_eleitor = ?");
            pstmt.setInt(1, eleitor.getCod());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
        return false;
    }

}
