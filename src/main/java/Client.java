import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.*;
import java.awt.event.*;

public class Client {
    private static DictionaryService service;

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            service = (DictionaryService) registry.lookup("DictionaryService");

            JFrame frame = new JFrame("Dicionário RMI");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton btnConsultar = new JButton("Consultar palavra");
            JButton btnAdicionar = new JButton("Adicionar palavra");
            JButton btnRemover = new JButton("Remover palavra");

            btnConsultar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String word = JOptionPane.showInputDialog(frame, "Digite a palavra que deseja consultar:");
                    try {
                        String meaning = service.getMeaning(word);
                        JOptionPane.showMessageDialog(frame, "Significado de " + word + ": " + meaning);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, ex.getMessage());
                    }
                }
            });

            btnAdicionar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String newWord = JOptionPane.showInputDialog(frame, "Digite a nova palavra:");
                    String newMeaning = JOptionPane.showInputDialog(frame, "Digite o significado da nova palavra:");
                    try {
                        String result = service.addWord(newWord, newMeaning);
                        JOptionPane.showMessageDialog(frame, result);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, ex.getMessage());
                    }
                }
            });

            btnRemover.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String removedWord = JOptionPane.showInputDialog(frame, "Digite a palavra que deseja remover:");
                    try {
                        String result = service.removeWord(removedWord);
                        JOptionPane.showMessageDialog(frame, result);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, ex.getMessage());
                    }
                }
            });

            JPanel panel = new JPanel();
            panel.add(btnConsultar);
            panel.add(btnAdicionar);
            panel.add(btnRemover);
            frame.add(panel);

            frame.setVisible(true);

        } catch (Exception e) {
            System.err.println("Exceção do cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}