package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Artikli;
import ba.unsa.etf.rpr.exceptions.ArtikliException;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
public interface ArtikliDao extends Dao<Artikli> {
    /**
     * vraca sve artikle sa zadanim istekom roka
     *
     * @param rok za trazenje artikala s isteknutim rokom
     * @return listu trazenih artikala
     */
    List<Artikli> traziPoIstekuRoka(Date rok) throws ArtikliException, SQLException;

    /**
     * vraca sve artikle sa zadanom cijenom
     * @param cijena za trazenje artikala
     * @return listu zadanih artikala
     */
    List<Artikli> traziPoCijeni(int cijena) throws ArtikliException;

}