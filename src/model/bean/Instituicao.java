package model.bean;

public class Instituicao {

    private Integer cod;
    private String address;
    private String phone;
    private String campus;

    public Instituicao() {
    }

    public Instituicao(String address, String phone, String campus) {
        this.address = address;
        this.phone = phone;
        this.campus = campus;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    @Override
    public String toString() {
        return campus;
    }

}
