import java.util.Scanner;

public class MorseTest {
    public static void main(String[] args) {
        MorseTree tree = new MorseTree();
        tree.initialize();
        tree.load();
        Scanner input = new Scanner(System.in);
        int option = -1;
        while (option != 0) {
            System.out.println("\n1 - Texto para Morse");
            System.out.println("2 - Morse para texto");
            System.out.println("3 - Mostrar arvore");
            System.out.println("4 - Buscar codigo Morse");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            if (!input.hasNextInt()) {
                System.out.println("Digite um numero.");
                input.nextLine();
                continue;
            }
            option = input.nextInt();
            input.nextLine();
            if (option == 1) {
                System.out.print("Mensagem: ");
                System.out.println(tree.encode(input.nextLine()));
            } else if (option == 2) {
                System.out.print("Morse (separe letras com espacos e palavras com /): ");
                System.out.println(tree.decode(input.nextLine()));
            } else if (option == 3) {
                tree.show();
            } else if (option == 4) {
                System.out.print("Codigo: ");
                System.out.println(tree.search(input.nextLine()));
            } else if (option != 0) {
                System.out.println("Opcao invalida.");
            }
        }
        input.close();
    }
}
