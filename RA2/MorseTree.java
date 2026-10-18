import java.util.Scanner;

public class MorseTree {
    private Node root;

    public void initialize() {
        root = new Node(' ');
    }

    public void insert(String code, char letter) {
        if (root == null) initialize();
        Node current = root;
        Scanner signals = new Scanner(code);
        signals.useDelimiter("");
        while (signals.hasNext()) {
            String signal = signals.next();
            switch (signal) {
                case ".":
                    if (current.left == null) current.left = new Node(' ');
                    current = current.left;
                    break;
                case "-":
                    if (current.right == null) current.right = new Node(' ');
                    current = current.right;
                    break;
                default:
                    signals.close();
                    throw new IllegalArgumentException("Codigo Morse invalido.");
            }
        }
        signals.close();
        current.letter = letter;
    }

    public char search(String code) {
        if (root == null) return '?';
        Node current = root;
        Scanner signals = new Scanner(code);
        signals.useDelimiter("");
        while (signals.hasNext()) {
            String signal = signals.next();
            switch (signal) {
                case ".": current = current.left; break;
                case "-": current = current.right; break;
                default: signals.close(); return '?';
            }
            if (current == null) {
                signals.close();
                return '?';
            }
        }
        signals.close();
        return current.letter == ' ' ? '?' : current.letter;
    }

    public String codeOf(char letter) {
        if (letter >= 'a' && letter <= 'z') letter = (char)(letter - 32);
        if (root == null) return "?";
        String code = find(root, letter, "");
        return code == null ? "?" : code;
    }

    private String find(Node node, char letter, String path) {
        if (node == null) return null;
        if (node.letter == letter) return path;
        String found = find(node.left, letter, path + ".");
        if (found != null) return found;
        return find(node.right, letter, path + "-");
    }

    private char readLetter(String symbol) {
        switch (symbol) {
            case "a": case "A": return 'A';
            case "b": case "B": return 'B';
            case "c": case "C": return 'C';
            case "d": case "D": return 'D';
            case "e": case "E": return 'E';
            case "f": case "F": return 'F';
            case "g": case "G": return 'G';
            case "h": case "H": return 'H';
            case "i": case "I": return 'I';
            case "j": case "J": return 'J';
            case "k": case "K": return 'K';
            case "l": case "L": return 'L';
            case "m": case "M": return 'M';
            case "n": case "N": return 'N';
            case "o": case "O": return 'O';
            case "p": case "P": return 'P';
            case "q": case "Q": return 'Q';
            case "r": case "R": return 'R';
            case "s": case "S": return 'S';
            case "t": case "T": return 'T';
            case "u": case "U": return 'U';
            case "v": case "V": return 'V';
            case "w": case "W": return 'W';
            case "x": case "X": return 'X';
            case "y": case "Y": return 'Y';
            case "z": case "Z": return 'Z';
            case "0": return '0'; case "1": return '1';
            case "2": return '2'; case "3": return '3';
            case "4": return '4'; case "5": return '5';
            case "6": return '6'; case "7": return '7';
            case "8": return '8'; case "9": return '9';
            default: return '?';
        }
    }

    public String encode(String message) {
        String result = "";
        Scanner letters = new Scanner(message);
        letters.useDelimiter("");
        while (letters.hasNext()) {
            String symbol = letters.next();
            if (result.length() > 0) result += " ";
            switch (symbol) {
                case " ": result += "/"; break;
                default: result += codeOf(readLetter(symbol));
            }
        }
        letters.close();
        return result;
    }

    public String decode(String message) {
        String result = "";
        Scanner groups = new Scanner(message);
        while (groups.hasNext()) {
            String code = groups.next();
            switch (code) {
                case "/": result += " "; break;
                default: result += search(code);
            }
        }
        groups.close();
        return result;
    }

    public void show() {
        if (root != null) showNode(root, "", "Raiz");
    }

    private void showNode(Node node, String indent, String side) {
        if (node == null) return;
        System.out.println(indent + side + ": " + (node.letter == ' ' ? "*" : node.letter));
        showNode(node.left, indent + "   ", ".");
        showNode(node.right, indent + "   ", "-");
    }

    public void load() {
        insert(".-", 'A'); insert("-...", 'B'); insert("-.-.", 'C');
        insert("-..", 'D'); insert(".", 'E'); insert("..-.", 'F');
        insert("--.", 'G'); insert("....", 'H'); insert("..", 'I');
        insert(".---", 'J'); insert("-.-", 'K'); insert(".-..", 'L');
        insert("--", 'M'); insert("-.", 'N'); insert("---", 'O');
        insert(".--.", 'P'); insert("--.-", 'Q'); insert(".-.", 'R');
        insert("...", 'S'); insert("-", 'T'); insert("..-", 'U');
        insert("...-", 'V'); insert(".--", 'W'); insert("-..-", 'X');
        insert("-.--", 'Y'); insert("--..", 'Z');
        insert(".----", '1'); insert("..---", '2'); insert("...--", '3');
        insert("....-", '4'); insert(".....", '5'); insert("-....", '6');
        insert("--...", '7'); insert("---..", '8'); insert("----.", '9');
        insert("-----", '0');
    }
}
