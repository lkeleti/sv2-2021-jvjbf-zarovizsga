package sentences;

import java.util.Locale;

public class SentenceTransformer {
    public String shortenSentence(String sentence) {

        if (!sentence.substring(0, 1).equals(sentence.substring(0, 1).toUpperCase(Locale.ROOT))) {
            throw new IllegalArgumentException("Must start with capital letter!");
        }

        String lastChar = sentence.substring(sentence.length() - 1);
        if (!(lastChar.equals(".") || lastChar.equals("!") || lastChar.equals("?"))) {
            throw new IllegalArgumentException("Must end with . ! or ?");
        }

        String[] words = sentence.split(" ");
        if (words.length >= 5) {
            return words[0] + " ... " + words[words.length - 1];
        }
        return sentence;
    }
}
