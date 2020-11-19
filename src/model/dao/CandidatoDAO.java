package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			JOptionPane.showMessageDialog(null, "success");
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
				c.setImagem(new ImagemDAO().buscar(rs.getInt("imagem")));
				return c;
			}
		}catch(SQLException e) {
			throw new DBException(e.getMessage());
		}
		return null;
	}
	
	public Candidato selectByCod(Integer cod) {
		try{
			conn = ConnectionFactory.getConnection();
			st = conn.prepareStatement(
					"SELECT * FROM candidato WHERE cod = ?");
			st.setInt(1, cod);
			rs = st.executeQuery();
			if(rs.next()) {
				Candidato c = new Candidato();
				c.setCod(cod);
				c.setName(rs.getString("nome"));
				c.setNum(rs.getInt("num"));
				c.setChapa(rs.getString("chapa"));
				c.setImagem(new ImagemDAO().buscar(rs.getInt("imagem")));
				return c;
			}
		}catch(SQLException e) {
			throw new DBException(e.getMessage());
		}
		return null;
	}
}
