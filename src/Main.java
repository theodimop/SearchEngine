import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ----------------------------------------------------------------------------  <br>
 * Main.java created byTheo Dimopoulos on 08-07-2017.                                <br>
 * Email:   dimopoulosth.td@gmail.com | td41@st-andrews.ac.uk                             <br>
 * ----------------------------------------------------------------------------  <br>
 *
 * @author Theo Dimopoulos
 * @version 08-07-2017
 */
public class Main {

    public static void main(String[] args) {

        validateArguments(args);

        List<String> argumentList = Arrays.asList(Arrays.copyOfRange(args, 1, args.length));
        String file = args[0];

        argumentList = argumentList.stream().map(String::toLowerCase).collect(Collectors.toList());
        argumentList.remove(file);

        //IO-Read file from disk
        CSVFileReader csvFileReader = new CSVFileReader();
        Map<String,Article> articles = csvFileReader.readCSV(file);

        //Print terms that search is based on
        System.out.print("Successful search on: ");
        argumentList.forEach(t -> System.out.print(t+", "));
        System.out.println();

        //Search articles
        SearchEngine.findArticles(articles.values(),argumentList).forEach(System.out::println);

    }

    /**
     * Simple argument validation. Program exits if
     * arguments not valid.
     *
     * @param args Program arguments
     */
    private static void validateArguments(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide <file> and <terms> as program arguments");
            System.out.println("Program exits...");
            System.exit(0);
        }
    }
}
