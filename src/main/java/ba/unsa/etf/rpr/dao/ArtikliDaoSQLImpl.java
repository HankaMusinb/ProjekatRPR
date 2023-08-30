package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Artikli;
import ba.unsa.etf.rpr.exceptions.ArtikliException;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class ArtikliDaoSQLImpl extends AbstractDao<Artikli>  implements ArtikliDao {
    private static ArtikliDaoSQLImpl instance = null;
    private ArtikliDaoSQLImpl() {super("Artikli");}


    public static ArtikliDaoSQLImpl getInstance(){
        if(instance == null)
            instance = new ArtikliDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance != null)
            instance = null;
    }
    @Override
    public Artikli row2object(ResultSet rs) throws ArtikliException {
        try{
            Artikli a = new Artikli();
            a.setId(rs.getInt("id"));
            a.setNaziv(rs.getString("naziv"));
            a.setCijena(rs.getInt("cijena"));
            a.setIstekRoka(rs.getDate("istekRoka"));
//            int i = rs.getInt("idKategorije");
//            Kategorije k = DaoFactory.kategorijeDao().getById(i);
//            a.setKategorija(k);
            a.setKategorija(DaoFactory.kategorijeDao().getById(rs.getInt("idKategorije")));
            a.setProdaje(DaoFactory.prodajeDao().getById(rs.getInt("idProdaje")));
            return a;
        } catch (Exception e) {
            throw new ArtikliException("Problem sa row2object u ArtikliDaoSQLImpl");
        }
    }
    /**
     * @param object - object to be mapped
     * @return map representation of object
     */
    @Override
    public Map<String, Object> object2row(Artikli object) {
        Map<String,Object> artikal = new TreeMap<>();
        artikal.put("id", object.getId());
        artikal.put("naziv",object.getNaziv());
        artikal.put("cijena",object.getCijena());
        artikal.put("istekRoka",object.getIstekRoka());
        artikal.put("idKategorije", object.getKategorija().getId());
        artikal.put("idProdaje",object.getProdaje().getId());
        return artikal;
    }
    @Override
    public List<Artikli> traziPoIstekuRoka(Date rok) throws ArtikliException {
        return executeQuery("SELECT * FROM Artikli WHERE istekRoka = ?", new Object[]{rok});
    }

    @Override
    public List<Artikli> traziPoCijeni(int cijena) throws ArtikliException {

        return executeQuery("SELECT * FROM Artikli WHERE cijena = ?", new Object[]{cijena});

    }

}
