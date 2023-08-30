package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * sums profit every time an item has been selected or searched for
 * @author Hanka Musinbegovic
 */
public class Prodaje implements Idable {

    //Atributes
    private int id;
    private int zarada;

    //Setters and getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getZarada() {
        return zarada;
    }

    public void setZarada(int zarada) {
        this.zarada = zarada;
    }

    //Hash, toString, equals methods


    @Override
    public String toString() {
        return "Prodaje{" +
                "id=" + id +
                ", zarada=" + zarada +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodaje prodaje = (Prodaje) o;
        return id == prodaje.id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, zarada);
    }
}
