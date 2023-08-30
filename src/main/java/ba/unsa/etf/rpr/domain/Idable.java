package ba.unsa.etf.rpr.domain;

/**
 * Interface that forces all POJO beans to have ID field. Name is stupid but per standard
 *
 * @author Hanka Musinbegovic
 */

public interface Idable {
    void setId(int id);

    int getId();
}
