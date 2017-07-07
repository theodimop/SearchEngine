import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ----------------------------------------------------------------------------  <br>
 * Article.java created byTheo Dimopoulos on 07-07-2017.                                <br>
 * Email:   dimopoulosth.td@gmail.com | td41@st-andrews.ac.uk                             <br>
 * ----------------------------------------------------------------------------  <br>
 *
 * @author Theo Dimopoulos
 * @version 07-07-2017
 */
public class Article {

    private String id;
    private Set<String> title;
    private Set<String> body;

    /**
     *
     * @param id Article id.
     * @param title Article title
     * @param body  Article body
     */
    public Article(String id, Set<String> title, Set<String> body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    /**
     * Getter
     * @return article id
     */
    public String getId() {
        return id;
    }

    /**
     * Getter
     * @return article's title
     */
    public Set<String> getTitle() {
        return title;
    }

    /**
     * Getter
     * @return article's body
     */
    public Set<String> getBody() {
        return body;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (String word: title) {
            stringBuilder.append(word+" ");
        }

        return id + " -> " + stringBuilder.toString();
    }




}
