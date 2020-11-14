package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.bean.Voto;
import model.dao.EleitorDAO;
import model.dao.VotoDAO;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		VotoDAO vDAO = new VotoDAO();
		String path = "C:\\Curso JAVA\\Workspace\\ws-directvote\\log.txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			for (Voto vt : vDAO.log()) {
				bw.write(vt.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
