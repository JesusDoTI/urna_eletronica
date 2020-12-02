/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.bean.Voto;

/**
 *
 * @author Rafael
 */
public class LogService {

    public static void log(List<Voto> votos) {
        String path = "C:\\Curso JAVA\\Workspace\\ws-directvote\\log.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            for (Voto vt : votos) {
                bw.write(vt.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
