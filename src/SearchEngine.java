import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * ----------------------------------------------------------------------------  <br>
 * SearchEngine.java created byTheo Dimopoulos on 08-07-2017.                                <br>
 * Email:   dimopoulosth.td@gmail.com | td41@st-andrews.ac.uk                             <br>
 * ----------------------------------------------------------------------------  <br>
 *
 * @author Theo Dimopoulos
 * @version 08-07-2017
 */
public class SearchEngine {


    /**
     * Finds articles that include all the search terms.
     *
     * @param articles Articles to search terms into.
     * @param terms Search according to these terms
     * @return Returns list of articles that contain all
     * the given terms
     */
    public static List<Article> findArticles(Collection<Article> articles, List<String> terms) {
        return articles.stream().filter(articleMatches(terms)).collect(Collectors.toList());
    }

    /**
     * Find out if article contain a collection of terms.
     *
     * @param terms
     * @return Returns True if article matches all the terms,
     * false otherwise.
     */
    public static Predicate<Article> articleMatches(List<String> terms) {
        return a -> terms.stream()
                         .allMatch(t -> a.getTitle().contains(t) || a.getBody().contains(t));
    }
}
