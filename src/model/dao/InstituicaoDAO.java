package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.Instituicao;
import model.connection.ConnectionFactory;
import model.connection.DBException;

public class InstituicaoDAO {

	private static Connection conn = null;
	private static PreparedStatement st = null;
	private static ResultSet rs = null;

	public Instituicao select(Integer cod) {
		try {
			conn = ConnectionFactory.getConnection();
			st = conn.prepareStatement("SELECT * FROM instituicao WHERE cod = ?");
			st.setInt(1, cod);
			rs = st.executeQuery();
			if (rs.next()) {
				Instituicao i = new Instituicao();
				i.setCod(cod);
				i.setCampus(rs.getString("campus"));
				i.setEndereco(rs.getString("endereco"));
				i.setTelefone(rs.getString("telefone"));
				return i;
			}
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
		return null;
	}
}
