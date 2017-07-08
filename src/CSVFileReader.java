import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * ----------------------------------------------------------------------------  <br>
 * ReadInput.java created byTheo Dimopoulos on 08-07-2017.                                <br>
 * Email:   dimopoulosth.td@gmail.com | td41@st-andrews.ac.uk                             <br>
 * ----------------------------------------------------------------------------  <br>
 *
 * @author Theo Dimopoulos
 * @version 08-07-2017
 */
public class CSVFileReader {

    /**
     * Read a csv file with articles
     * @param file The file containing articles
     * @return Returns a Map that contains the articles
     */
    public Map<String,Article> readCSV(String file) {
        String line;
        Map<String,Article> articles = new Hashtable<>();

        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(file))){
            while ((line = bufferedReader.readLine()) != null) {

                Article article = createArticle(line);

                if(article != null)
                    articles.put(article.getId(),article);

            }
        } catch (IOException e) {
            if(e instanceof FileNotFoundException)
                System.out.println("No csv file found with this name.");
            else
                e.printStackTrace();

            System.out.println("Program exits...");
            System.exit(0);
        }
        return articles;
    }

    /**
     * Auxiliary function to create article
     * @param line Contains the line that contains article info
     * @return Returns an Article
     */
    private Article createArticle(String line) {
        String[] articleInArray = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); //Split CSV file with Quotes

        if (articleInArray.length < 3)
            return null;

        HashSet<String> title = new HashSet<>();
        HashSet<String> body = new HashSet<>();

        String id = articleInArray[0];
        String orginalTitle = articleInArray[1];
        String[] titleWords = articleInArray[1].replaceAll("[\\W_]"," ").split(" "); //Filter words
        String[] bodyWords = articleInArray[2].replaceAll("[\\W_]"," ").split(" ");

        for (String word: titleWords) {
            title.add(word.toLowerCase());
        }

        for (String word: bodyWords) {
            body.add(word.toLowerCase());
        }

        return new Article(id,orginalTitle,title,body);
    }
}
