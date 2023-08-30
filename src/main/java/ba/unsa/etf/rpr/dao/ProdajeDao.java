package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Prodaje;
import ba.unsa.etf.rpr.exceptions.ArtikliException;

import java.util.List;

public interface ProdajeDao extends Dao<Prodaje> {


    List<Prodaje> vratiProfit(int id) throws  ArtikliException;

}
