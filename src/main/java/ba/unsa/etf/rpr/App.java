package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.domain.Artikli;
import ba.unsa.etf.rpr.domain.Kategorije;
import ba.unsa.etf.rpr.exceptions.ArtikliException;
import org.apache.commons.cli.*;
import ba.unsa.etf.rpr.business.*;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * Hello world!
 *
 * @author Hanka Musinbegovic
 */
public class App
{

    /**
     * Defining final variables to describe all code having options
     */

        private static final Option addArtikal = new Option("a", "add-artikal", false, "Dodavanje novog artikla u bazu" );

        private static final Option addCategory = new Option("c", "add-category", false, "Dodavanje nove kategorije u bazu");

        private static final Option getArtikal = new Option("getA", "get-artikal", false, "Ispis artikala");

        private static final Option getCategories = new Option("getC", "get-categories", false, " Ispis kategorija");

        private static final Option categoryDefinition = new Option(null, "category", false, "Defining categories");


        public static void printFormattedOptions(Options options){
            HelpFormatter helpFormatter = new HelpFormatter();
            PrintWriter printWriter = new PrintWriter(System.out);
            helpFormatter.printUsage(printWriter,150,"java -jar ProjekatRPR-0.1.jar [option] 'something else'");
            helpFormatter.printOptions(printWriter,150,options,2,7);
            printWriter.close();
        }


        public static Options addOptions(){
            Options options = new Options();
            options.addOption(addArtikal);
            options.addOption(addCategory);
            options.addOption(getArtikal);
            options.addOption(getCategories);
            options.addOption(categoryDefinition);
            return options;
        }

        public static Kategorije searchThroughCategories(List<Kategorije> listOfCategories, String naziv){
            Kategorije kategorija = null;
            kategorija = listOfCategories.stream().filter(kategorije -> kategorije.getKategorija().toLowerCase().equals(naziv.toLowerCase())).findAny().get();
            return kategorija;
        }


    public static void main( String[] args ) throws ArtikliException, ParseException {
        Options options = addOptions();

        CommandLineParser commandLineParser = new PosixParser();

        CommandLine cl = commandLineParser.parse(options, args);

        if ((cl.hasOption(((addArtikal.getOpt()))) || cl.hasOption(addArtikal.getLongOpt())) && cl.hasOption(categoryDefinition.getLongOpt())) {
            ArtikliManager artikliManager = new ArtikliManager();
            KategorijeManager kategorijeManager = new KategorijeManager();
            Kategorije category = null;

            Artikli artikal = new Artikli();
            artikal.setKategorija(category);
            artikal.setIstekRoka(Date.valueOf(LocalDate.now()));
            artikal.setNaziv("naziv");
            artikal.setCijena(3);
            artikliManager.addArtikal(artikal);
            System.out.println("Dodali ste artikal");

        } else if (cl.hasOption(getArtikal.getOpt()) || cl.hasOption(getArtikal.getLongOpt())) {
            ArtikliManager artikliManager = new ArtikliManager();
            artikliManager.getAll().forEach(q -> System.out.println(q.getNaziv()));
//                break;
        } else if (cl.hasOption(addCategory.getOpt()) || cl.hasOption(addCategory.getLongOpt())) {
            try {
                KategorijeManager categoryManager = new KategorijeManager();
                Kategorije cat = new Kategorije();
                cat.setKategorija((String) cl.getArgList().get(0));
                categoryManager.addCategory(cat);
                System.out.println("Category has been added successfully");
//                    break;
            } catch (Exception e) {
                System.out.println("There is already category with same name in database! Try again");
                System.exit(1);
//                   break;
            }

        } else if (cl.hasOption(getCategories.getOpt()) || cl.hasOption(getCategories.getLongOpt())) {
            KategorijeManager categoryManager = new KategorijeManager();
            categoryManager.getAll().forEach(c -> System.out.println(c.getKategorija()));
//                break;
        } else {
            printFormattedOptions(options);
            System.exit(-1);
//                break;

            System.out.println("Hello World!");
        }
    }
}
