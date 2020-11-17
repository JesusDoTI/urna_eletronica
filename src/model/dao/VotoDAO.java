package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import model.bean.Voto;
import model.connection.ConnectionFactory;
import model.connection.DBException;

public class VotoDAO {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static Connection conn = null;
	private static PreparedStatement st = null;
	private static ResultSet rs = null;

	public void inserir(Integer num, String rg) {
		try {
			conn = ConnectionFactory.getConnection();
			st = conn.prepareStatement("INSERT INTO voto (dataHora, cod_candidato, cod_eleitor) VALUES (?,?,?)");
			st.setString(1, sdf.format(new java.sql.Date(Calendar.getInstance().getTimeInMillis())));
			st.setInt(2, new CandidatoDAO().select(num).getCod());
			st.setInt(3, new EleitorDAO().selectByRg(rg).getCod());
			st.execute();
			JOptionPane.showMessageDialog(null, "success");
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	}

	public Set<Voto> log() {
		Set<Voto> result = new HashSet<>();
		
		try {
			conn = ConnectionFactory.getConnection();
			st = conn.prepareStatement("SELECT * FROM voto");
			rs = st.executeQuery();
			while (rs.next()) {
				Voto v = new Voto();
				v.setCandidato(new CandidatoDAO().selectByCod(rs.getInt("cod_candidato")));
				v.setEleitor(new EleitorDAO().selectByCod(rs.getInt("cod_eleitor")));
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				v.setDataHora(sdf.parse(rs.getString("dataHora")));
				result.add(v);
			}
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;

	}
	
	public Set<Voto> logCandidato(Integer cod){
		Set<Voto> votos = new HashSet<Voto>();
		try {
			conn = ConnectionFactory.getConnection();
			st = conn.prepareStatement("SELECT * FROM voto WHERE cod_candidato = ?");
			rs = st.executeQuery();
			while(rs.next()) {
				Voto v = new Voto();
				v.setCandidato(new CandidatoDAO().selectByCod(rs.getInt("cod_candidato")));
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				v.setDataHora(sdf.parse(rs.getString("dataHora")));
				v.setEleitor(new EleitorDAO().selectByCod(rs.getInt("cod_eleitor")));
				votos.add(v);
			}
		}catch(SQLException e) {
			throw new DBException(e.getMessage());
		}catch(ParseException e) {
			e.printStackTrace();
		}
		return votos;
	}
        
}