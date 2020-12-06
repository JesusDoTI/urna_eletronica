package model.bean;

public class Candidato {

    private Integer cod;
    private String name;
    private Integer num;
    private String chapa;
    private Imagem image;

    public Candidato() {
    }

    public Candidato(String name, Integer num, String chapa, Imagem image) {
        this.name = name;
        this.num = num;
        this.chapa = chapa;
        this.image = image;
    }

    public Candidato(String name, Integer num, String chapa) {
        this.name = name;
        this.num = num;
        this.chapa = chapa;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getChapa() {
        return chapa;
    }

    public void setChapa(String chapa) {
        this.chapa = chapa;
    }

    public Imagem getImage() {
        return image;
    }

    public void setImage(Imagem image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return name + " " + num;
    }
}
