package model.bean;

import java.util.Date;
import java.util.Objects;

public class Eleitor implements Comparable<Eleitor> {

    private Integer cod;
    private String nome;
    private Date dataNasc;
    private String telefone;
    private String endereco;
    private String rg;
    private String cpf;
    private Integer matricula;
    private Instituicao instituicao;

    public Eleitor() {
    }

    public Eleitor(String nome, Date dataNasc, String telefone, String endereco, String rg, String cpf,
            Integer matricula, Instituicao instituicao) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
        this.endereco = endereco;
        this.rg = rg;
        this.cpf = cpf;
        this.matricula = matricula;
        this.instituicao = instituicao;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    @Override
    public String toString() {
        return "Eleitor [cod=" + cod + ", nome=" + nome + ", dataNasc=" + dataNasc + ", telefone=" + telefone
                + ", endereco=" + endereco + ", rg=" + rg + ", cpf=" + cpf + ", matricula=" + matricula
                + ", instituicao=" + instituicao + "]";
    }

    @Override
    public int compareTo(Eleitor o) {
        return rg.compareTo(o.getRg());
    }

}
