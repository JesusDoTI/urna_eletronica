package model.bean;

import java.util.Date;

public class Eleitor implements Comparable<Eleitor> {

    private Integer cod;
    private String name;
    private Date birthDate;
    private String phone;
    private String address;
    private String rg;
    private String cpf;
    private Integer matricula;
    private Instituicao instituicao;

    public Eleitor() {
    }

    public Eleitor(String name, Date birthDate, String phone, String address, String rg, String cpf,
            Integer matricula, Instituicao instituicao) {
        this.name = name;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
        this.rg = rg;
        this.cpf = cpf;
        this.matricula = matricula;
        this.instituicao = instituicao;
    }

    public Eleitor(String name, Date birthDate, String phone, String address, Integer matricula, Instituicao instituicao) {
        this.name = name;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
        this.matricula = matricula;
        this.instituicao = instituicao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
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
        return "Eleitor{" + "cod=" + cod + ", name=" + name + ", birthDate=" + birthDate + ", phone=" + phone + ", address=" + address + ", rg=" + rg + ", cpf=" + cpf + ", matricula=" + matricula + ", instituicao=" + instituicao + '}';
    }

    @Override
    public int compareTo(Eleitor o) {
        return rg.compareTo(o.getRg());
    }

}
