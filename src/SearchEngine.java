import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * ----------------------------------------------------------------------------  <br>
 * SearchEngine.java created byTheo Dimopoulos on 07-07-2017.                                <br>
 * Email:   dimopoulosth.td@gmail.com | td41@st-andrews.ac.uk                             <br>
 * ----------------------------------------------------------------------------  <br>
 *
 * @author Theo Dimopoulos
 * @version 07-07-2017
 */
public class SearchEngine {


    public static List<Article> findArticles(Collection<Article> articles, List<String> terms) {
        return articles.stream().filter(articleMatches(terms)).collect(Collectors.toList());
    }

    public static Predicate<Article> articleMatches(List<String> terms) {
        return a -> terms.stream()
                         .allMatch(t -> a.getTitle().contains(t) || a.getBody().contains(t));
    }
}
