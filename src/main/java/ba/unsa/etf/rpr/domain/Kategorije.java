package ba.unsa.etf.rpr.domain;

import java.util.Objects;


public class Kategorije implements Idable {
    //Atributes
    private int id;
    private String kategorija;
    //Setters and Getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    //Hash, equals toString methods

    @Override
    public String toString() {
        return kategorija;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kategorije that = (Kategorije) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kategorija);
    }
}
