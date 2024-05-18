import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class JogoDaForca {
    private static final String[] PALAVRAS = {"java", "programacao", "computador", "desenvolvimento", "openai"};
    private static final int MAX_TENTATIVAS = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palavraSecreta = selecionarPalavraSecreta();
        char[] palavraEscondida = new char[palavraSecreta.length()];
        Set<Character> letrasUtilizadas = new HashSet<>();
        int tentativasRestantes = MAX_TENTATIVAS;

        while (tentativasRestantes > 0 && !palavraRevelada(palavraEscondida)) {
            System.out.println("Palavra: " + obterPalavraEscondida(palavraEscondida));
            System.out.println("Tentativas restantes: " + tentativasRestantes);
            System.out.println("Letras já tentadas: " + letrasUtilizadas);
            System.out.print("Digite uma letra: ");
            String input = scanner.next().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Entrada inválida. Digite uma única letra.");
                continue;
            }

            char letra = input.charAt(0);

            if (letrasUtilizadas.contains(letra)) {
                System.out.println("Você já tentou essa letra. Tente outra.");
                continue;
            }

            letrasUtilizadas.add(letra);

            if (palavraSecreta.indexOf(letra) < 0) {
                System.out.println("Letra não encontrada na palavra secreta.");
                tentativasRestantes--;
            } else {
                System.out.println("Letra encontrada na palavra secreta!");
                atualizarPalavraEscondida(palavraSecreta, palavraEscondida, letra);
            }
        }

        if (palavraRevelada(palavraEscondida)) {
            System.out.println("Parabéns! Você ganhou! A palavra secreta era: " + palavraSecreta);
        } else {
            System.out.println("Você perdeu! A palavra secreta era: " + palavraSecreta);
        }

        scanner.close();
    }

    private static String selecionarPalavraSecreta() {
        return PALAVRAS[new Random().nextInt(PALAVRAS.length)];
    }

    private static boolean palavraRevelada(char[] palavraEscondida) {
        for (char c : palavraEscondida) {
            if (c == 0) {
                return false;
            }
        }
        return true;
    }

    private static String obterPalavraEscondida(char[] palavraEscondida) {
        StringBuilder sb = new StringBuilder();
        for (char c : palavraEscondida) {
            if (c == 0) {
                sb.append("_ ");
            } else {
                sb.append(c).append(" ");
            }
        }
        return sb.toString();
    }

    private static void atualizarPalavraEscondida(String palavraSecreta, char[] palavraEscondida, char letra) {
        for (int i = 0; i < palavraSecreta.length(); i++) {
            if (palavraSecreta.charAt(i) == letra) {
                palavraEscondida[i] = letra;
            }
        }
    }
}
