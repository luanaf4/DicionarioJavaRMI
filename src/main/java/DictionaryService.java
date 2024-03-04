import java.rmi.Remote;
import java.rmi.RemoteException;
    public interface DictionaryService extends Remote {
        String getMeaning(String word) throws RemoteException, WordNotFoundException;

        String addWord(String word, String meaning) throws RemoteException;

        String removeWord(String word) throws RemoteException, WordNotFoundException;
    }
