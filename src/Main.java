import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static javafx.scene.input.KeyCode.L;

/**
 * ----------------------------------------------------------------------------  <br>
 * Main.java created byTheo Dimopoulos on 07-07-2017.                                <br>
 * Email:   dimopoulosth.td@gmail.com | td41@st-andrews.ac.uk                             <br>
 * ----------------------------------------------------------------------------  <br>
 *
 * @author Theo Dimopoulos
 * @version 07-07-2017
 */
public class Main {

    public static void main(String[] args) {
        List<String> argList = Arrays.asList(Arrays.copyOfRange(args, 1, args.length));
        CSVFileReader csvFileReader = new CSVFileReader();
        String file = args[0];

        argList = argList.stream().map(String::toLowerCase).collect(Collectors.toList());
        argList.remove(file);
        argList.forEach(t -> System.out.println(t));

        System.out.print("Successful search on: ");
        argList.forEach(t -> System.out.print(t+", "));
        System.out.println();

        Map<String,Article> articles = csvFileReader.readCSV(file);
        SearchEngine.findArticles(articles.values(),argList).forEach(System.out::println);

    }
}
