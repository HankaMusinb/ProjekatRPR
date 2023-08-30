package ba.unsa.etf.rpr.dao;

/**
 * Factory method for singleton implementation of DAOs
 *
 * @author Hanka Musinbegovic
 */
public class DaoFactory {

    private static final KategorijeDao kategorijeDao = KategorijeDaoSQLImpl.getInstance();
    private static final ArtikliDao artikliDao = ArtikliDaoSQLImpl.getInstance();
    private static final ProdajeDao prodajeDao = ProdajeDaoSQLImpl.getInstance();
    private DaoFactory(){
    }


    //    public static ArtikliDao artikliDao() {
//        if(artikliDao==null) {
//            artikliDao =  new ArtikliDaoSQLImpl();
//            return artikliDao;
//        }
//        return artikliDao;
//    }
    public static ArtikliDao artikliDao(){
        return artikliDao;
    }
    public static KategorijeDao kategorijeDao(){
        return kategorijeDao;
    }
    public static ProdajeDao prodajeDao(){
        return prodajeDao;
    }
}
