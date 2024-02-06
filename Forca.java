package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Forca {
    public Forca() {
        // Inicialização do vetor de palavras
        ArrayList<String> palavras = new ArrayList<>();
        
        // Lista de letras digitadas
        Set<Character> letrasDigitadas = new HashSet<>();

        // Adição de palavras à lista
        palavras.add("tartaruga");
        palavras.add("gato");
        palavras.add("foca");
        palavras.add("boto");
        palavras.add("humano");
        palavras.add("capivara");

        // Escolha aleatória de uma palavra da lista
        Random random = new Random();
        int idRandom = random.nextInt(palavras.size());
        String itemEscolhido = palavras.get(idRandom);

        // Inicialização do vetor de letras ocultas
        char[] letras = new char[itemEscolhido.length()];
        for (int i = 0; i < itemEscolhido.length(); i++) {
            letras[i] = '_';
        }

        Scanner scanner = new Scanner(System.in);
    	int tentativa;
    	
        while (true) {
        	System.out.println("Digite 1 - fácil, 2 - médio, 3 - difícil");
        	System.out.print("Digite o modo: ");
        	int modo = scanner.nextInt();
        	if (modo == 1) {
                tentativa = 10;
                break;
            } else if (modo == 2) {
                tentativa = 5;
                break;
            } else if (modo == 3) {
            	tentativa = 2;
                break;
            } else {
                System.out.println("Modo indisponível. Encerrando o programa.");
                scanner.close();
                return;
            }
        }

        System.out.println("Número de tentativas: " + tentativa);
        boolean letraEncontrada = false;

        // Loop principal do jogo
        while (tentativa > 0) {
        	System.out.print("\n");
        	System.out.println("Palavra: " + new String(letras));

            System.out.print("Digite uma letra: ");
            char letraDigitada = scanner.next().charAt(0);
            
            // Verifica se a letra já foi digitada
            if (letrasDigitadas.contains(letraDigitada)) {
                System.out.println("Você já digitou essa letra. Tente novamente.");
                continue;
            }

            // Adiciona a letra à lista de letras digitadas
            letrasDigitadas.add(letraDigitada);

            letraEncontrada = false;

            // Verifica se a letra digitada está na palavra
            for (int i = 0; i < itemEscolhido.length(); i++) {
                if (itemEscolhido.charAt(i) == letraDigitada) {
                    letras[i] = letraDigitada;
                    letraEncontrada = true;
                }
            }

            // Atualiza a tentativa e exibe mensagens ao usuário
            if (!letraEncontrada) {
                tentativa--;
                System.out.println("Letra incorreta! Tentativas restantes = " + tentativa);
            } else {
                System.out.println("Letra correta!");
            }

            // Verifica se todas as letras foram encontradas
            if (new String(letras).equals(itemEscolhido)) {
                System.out.println("Parabéns! Você acertou a palavra: " + itemEscolhido);
                break;
            }
            System.out.println("Letras digitadas: " + letrasDigitadas);
        }

        // Exibe mensagem de resultado ao usuário
        if (tentativa == 0) {
            System.out.println("Você não conseguiu acertar a palavra. A palavra era: " + itemEscolhido);
        }

        scanner.close();
    }

    // Método principal que inicia o jogo
    public static void main(String[] args) {
        new Forca();
    }
}
