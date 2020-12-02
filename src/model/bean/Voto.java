package model.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Voto {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    private Integer cod;
    private Date dataHora;
    private Candidato candidato;
    private Eleitor eleitor;

    public Voto() {
    }

    public Voto(Integer cod, Date dataHora, Candidato candidato, Eleitor eleitor) {
        this.cod = cod;
        this.dataHora = dataHora;
        this.candidato = candidato;
        this.eleitor = eleitor;
    }

    public Voto(Date dataHora, Candidato candidato, Eleitor eleitor) {
        this.dataHora = dataHora;
        this.candidato = candidato;
        this.eleitor = eleitor;
    }

    public Integer getCod() {
        return cod;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Eleitor getEleitor() {
        return eleitor;
    }

    public void setEleitor(Eleitor eleitor) {
        this.eleitor = eleitor;
    }

    @Override
    public String toString() {
        return eleitor.getNome() + "(" + eleitor.getRg() + ")" + " - " + sdf.format(dataHora) + " - " + candidato.getName();
    }

}
