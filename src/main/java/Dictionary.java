import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }

    public String getMeaning(String word) {
        return dictionary.get(word);
    }

    public String addWord(String word, String meaning) {
        if (dictionary.containsKey(word)) {
            return "Palavra já existe";
        } else {
            dictionary.put(word, meaning);
            return "Palavra adicionada com sucesso";
        }
    }

    public String removeWord(String word) {
        if (dictionary.containsKey(word)) {
            dictionary.remove(word);
            return "Palavra removida com sucesso";
        } else {
            return "Palavra não encontrada";
        }
    }
}