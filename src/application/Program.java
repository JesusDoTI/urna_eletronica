package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import model.bean.Candidato;
import model.bean.Eleitor;
import model.bean.Instituicao;
import model.dao.CandidatoDAO;
import model.dao.EleitorDAO;
import model.dao.VotoDAO;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Instituicao i = new Instituicao("bairro", "4899900-0099", "Sombrio");
		i.setCod(1);
		Candidato c = new Candidato("Joao", 12, "Galo", null);
		Eleitor e = new Eleitor("Marcos", sdf.parse("12/10/2020"), "03899999-9999", "rua", "2123497153", "212321312",
				20202323, i);

		CandidatoDAO cDAO = new CandidatoDAO();
		cDAO.insert(c);
		System.out.println(cDAO.select(12));
		EleitorDAO eDAO = new EleitorDAO();
		eDAO.inserir(e);
		System.out.println(eDAO.selectByRg(e.getRg()));

		VotoDAO vDAO = new VotoDAO();
		vDAO.inserir(c.getNum(), e.getRg());

	}

}
