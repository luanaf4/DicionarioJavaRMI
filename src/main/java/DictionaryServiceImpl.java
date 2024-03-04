import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService {
    private HashMap<String, String> dictionary;

    public DictionaryServiceImpl() throws RemoteException {
        super();
        // Carrega o dicionário do arquivo na inicialização
        dictionary = PersistenceManager.load();
    }

    @Override
    public String getMeaning(String word) throws RemoteException, WordNotFoundException {
        if (!dictionary.containsKey(word)) {
            throw new WordNotFoundException("A palavra " + word + " não foi encontrada.");
        }
        return dictionary.get(word);
    }

    @Override
    public String addWord(String word, String meaning) throws RemoteException {
        if (dictionary.containsKey(word)) {
            return "Palavra já existe";
        } else {
            dictionary.put(word, meaning);
            // Salva o dicionário no arquivo sempre que uma palavra é adicionada
            PersistenceManager.save(dictionary);
            return "Palavra adicionada com sucesso";
        }
    }

    @Override
    public String removeWord(String word) throws RemoteException {
        if (dictionary.containsKey(word)) {
            dictionary.remove(word);
            // Salva o dicionário no arquivo sempre que uma palavra é removida
            PersistenceManager.save(dictionary);
            return "Palavra removida com sucesso";
        } else {
            return "Palavra não encontrada";
        }
    }
}