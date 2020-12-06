/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Voto;
/**
 *
 * @author Rafael
 */
public class LogService {

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy(hh-mm-ss)");

    public static void log(List<Voto> votos) {
        String path = "C:\\Curso JAVA\\Workspace\\ws-directvote\\Direct Vote\\log\\" + sdf.format((Calendar.getInstance().getTimeInMillis())) + ".txt";
        System.out.println(path);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            for (Voto vt : votos) {
                bw.write(vt.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
