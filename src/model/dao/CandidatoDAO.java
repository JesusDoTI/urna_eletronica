package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.Candidato;
import model.connection.ConnectionFactory;
import model.connection.DBException;

public class CandidatoDAO {
	
	public static Connection conn = null;
	public static PreparedStatement st = null; 
	public static ResultSet rs = null;
	
	public void insert(Candidato candidato) {
		try {
			conn = ConnectionFactory.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO candidato (cod,nome,num,chapa,imagem) "
					+ "VALUES (?,?,?,?,?");
			st.setInt(1, candidato.getCod());
			st.setString(2, candidato.getName());
			st.setInt(3, candidato.getNum());
			st.setString(4, candidato.getChapa());
			st.setObject(5, candidato.getImagem());
		}catch(SQLException e){
			throw new DBException(e.getMessage());
		}
	}
	
	public Candidato select(Integer num) {
		try{
			conn = ConnectionFactory.getConnection();
			st = conn.prepareStatement(
					"SELECT * FROM candidato WHERE num = ?");
			st.setInt(1, num);
			rs = st.executeQuery();
			if(rs.next()) {
				Candidato c = new Candidato();
				c.setCod(rs.getInt("cod"));
				c.setName(rs.getString("nome"));
				c.setNum(num);
				c.setChapa(rs.getString("chapa"));
				c.setImagem(rs.getBlob("imagem"));
				return c;
			}
		}catch(SQLException e) {
			throw new DBException(e.getMessage());
		}
		return null;
	}
	
	
}
