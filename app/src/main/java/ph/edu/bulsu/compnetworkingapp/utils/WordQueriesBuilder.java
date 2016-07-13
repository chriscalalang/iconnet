package ph.edu.bulsu.compnetworkingapp.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sheychan on 7/14/2016.
 */
public class WordQueriesBuilder {
    public static List<String> getWordQueries(String rawText) {
        List<String> wordQueries = new ArrayList<>();
        String [] trimmedTexts=rawText.split("\\W+");
        return wordQueries;
    }
}
