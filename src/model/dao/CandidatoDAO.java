package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.bean.Candidato;
import model.connection.ConnectionFactory;
import model.connection.DBException;

public class CandidatoDAO {
	
	public static Connection conn = null;
	public static PreparedStatement st = null; 
	
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
	
}
