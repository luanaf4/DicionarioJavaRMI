public class WordNotFoundException extends Exception {
    public WordNotFoundException(String message) {
        super("Palavra não encontrada");
    }
}