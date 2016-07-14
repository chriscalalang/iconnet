package ph.edu.bulsu.compnetworkingapp.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Sheychan on 7/14/2016.
 */
public class WordQueriesBuilder {
    public static List<String> getWordQueries(String rawText) {
        List<String> wordQueries = new ArrayList<>();
        String[] splittedTexts = rawText.split("\\W+");

        for (int a = 0; a < splittedTexts.length; a++) {
            wordQueries.add(splittedTexts[a]);
            String c = splittedTexts[a];
            for (int b = a + 1; b < splittedTexts.length; b++) {
                c += " " + splittedTexts[b];
                wordQueries.add(c);
            }
        }
        Collections.sort(wordQueries, stringLengthComparer);
        return wordQueries;
    }

    public static Comparator<String> stringLengthComparer = new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            return ((Integer) b.length()).compareTo(a.length());
        }
    };

}
