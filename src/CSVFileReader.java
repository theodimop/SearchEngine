import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * ----------------------------------------------------------------------------  <br>
 * ReadInput.java created byTheo Dimopoulos on 07-07-2017.                                <br>
 * Email:   dimopoulosth.td@gmail.com | td41@st-andrews.ac.uk                             <br>
 * ----------------------------------------------------------------------------  <br>
 *
 * @author Theo Dimopoulos
 * @version 07-07-2017
 */
public class CSVFileReader {

    public Map<String,Article> readCSV(String file) {
        String line = "";
        String csvSeparator = ",";
        Map<String,Article> articles = new Hashtable<>();

        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(file))){
            while ((line = bufferedReader.readLine()) != null) {
                String[] row = line.split(csvSeparator);

                Article article = createArticle(row);

                if(article != null)
                    articles.put(article.getId(),article);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return articles;
    }

    private Article createArticle(String[] row) {
        if (row.length < 3)
            return null;

        HashSet<String> title = new LinkedHashSet<>();
        HashSet<String> body = new HashSet<>();

        String id = row[0];
        String[] titleWords = row[1].replace("'","").split(" ");
        String[] bodyWords = row[2].replace("'","").split(" "); //remove ' character

        for (String word: titleWords) {
            title.add(word.toLowerCase());
        }

        for (String word: bodyWords) {
            body.add(word.toLowerCase());
        }

        return new Article(id,title,body);
    }
}
