import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Localiza o registro RMI no localhost
            Registry registry = LocateRegistry.getRegistry("localhost");

            // Busca a referência para o serviço de dicionário no registro RMI
            DictionaryService service = (DictionaryService) registry.lookup("DictionaryService");

            Scanner scanner = new Scanner(System.in);

            while(true) {
                System.out.println("Escolha uma opção: ");
                System.out.println("1. Consultar palavra");
                System.out.println("2. Adicionar palavra");
                System.out.println("3. Remover palavra");
                System.out.println("4. Sair");

                int option = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over

                switch(option) {
                    case 1:
                        System.out.println("Digite a palavra que deseja consultar: ");
                        String word = scanner.nextLine();
                        try {
                            String meaning = service.getMeaning(word);
                            System.out.println("Significado de " + word + ": " + meaning);
                        } catch (WordNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.println("Digite a nova palavra: ");
                        String newWord = scanner.nextLine();
                        System.out.println("Digite o significado da nova palavra: ");
                        String newMeaning = scanner.nextLine();
                        service.addWord(newWord, newMeaning);
                        System.out.println("Palavra adicionada com sucesso!");
                        break;
                    case 3:
                        System.out.println("Digite a palavra que deseja remover: ");
                        String removedWord = scanner.nextLine();
                        service.removeWord(removedWord);
                        System.out.println("Palavra removida com sucesso!");
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }

        } catch (Exception e) {
            System.err.println("Exceção do cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}