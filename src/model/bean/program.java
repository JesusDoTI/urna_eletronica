/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.dao.EleitorDAO;

/**
 *
 * @author Rafael
 */
public class program {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Instituicao inst = new Instituicao("dff", "123123", "arara");
        inst.setCod(2);
        Date data = sdf.parse("20/10/2020");
        Eleitor eleitor = new Eleitor("j", data, "123", "rr", "12312323", "54123", 351242, inst);
        EleitorDAO eDAO = new EleitorDAO();
        eDAO.inserir(eleitor);
    }
}
