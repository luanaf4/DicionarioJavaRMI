import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            // Criação da instância do serviço de dicionário
            DictionaryService service = new DictionaryServiceImpl();

            // Criação do registro RMI na porta 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Registro do serviço no registro RMI
            registry.rebind("DictionaryService", service);

            System.out.println("Servidor pronto");
        } catch (Exception e) {
            System.err.println("Exceção do servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
