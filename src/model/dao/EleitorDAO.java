package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import model.bean.Eleitor;
import model.connection.ConnectionFactory;
import model.connection.DBException;

public class EleitorDAO {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static Connection conn = null;
	private static PreparedStatement st = null;
	private static ResultSet rs = null;
	
	public void inserir(Eleitor eleitor) {
		try {
			conn = ConnectionFactory.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO eleitor (nome,dataNasc,telefone,endereco,rg,cpf,matricula,instituicao) "
					+ "VALUES (?,?,?,?,?,?,?,?)");
			st.setString(1, eleitor.getNome());
			st.setDate(2, new java.sql.Date(eleitor.getDataNasc().getDate()));
			st.setString(3, eleitor.getTelefone());
			st.setString(4, eleitor.getEndereco());
			st.setString(5,  eleitor.getRg());
			st.setString(6, eleitor.getCpf());
			st.setInt(7, eleitor.getMatricula());
			st.setInt(8, eleitor.getInstituicao().getCod());
			st.execute(); 
			JOptionPane.showMessageDialog(null, "success");
		}catch(SQLException e){
			throw new DBException(e.getMessage());
		}
	}
}
