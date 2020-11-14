package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.JOptionPane;

import model.connection.ConnectionFactory;
import model.connection.DBException;

public class VotoDAO {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static Connection conn = null;
	private static PreparedStatement st = null;
	private static ResultSet rs = null;

	public void inserir(Integer num, String rg) throws ParseException {
		try {
			conn = ConnectionFactory.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO voto (dataHora, cod_candidato, cod_eleitor) VALUES (?,?,?)");
			st.setString(1, sdf.format(new java.sql.Date(Calendar.getInstance().getTimeInMillis())));
			st.setInt(2, new CandidatoDAO().select(num).getCod());
			st.setInt(3, new EleitorDAO().selectByRg(rg).getCod());
			st.execute();
			JOptionPane.showMessageDialog(null, "success");
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	}
}
