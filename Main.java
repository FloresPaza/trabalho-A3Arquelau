import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String[] operacoes = {"+", "-", "*", "/"};

        try {
            String valor1, valor2;
            do {
                System.out.print("Digite o primeiro valor binário: ");
                valor1 = scanner.nextLine();
            } while (verificarValorBinario(valor1));

            String operacao;
            boolean sair = false;
            while (true) {
                System.out.print("Digite a operação (+, -, *, /): ");
                operacao = scanner.nextLine();
                for (String op : operacoes) {
                    if (operacao.equals(op)) {
                        sair = true;
                        break;
                    }
                }
                if (sair) {
                    break;
                } else {
                    System.out.println("Operação inválida! Tente novamente.");
                }
            }

            while (true) {
                do {
                    System.out.print("Digite o segundo valor binário: ");
                    valor2 = scanner.nextLine();
                } while (verificarValorBinario(valor2));
                if (operacao.equals("/") && (Integer.parseInt(valor2) == 0)) {
                    System.out.println("Não é possível dividir por zero, por favor digite outro número.");
                } else {
                    break;
                }
            }

            int resultado = switch (operacao) {
                case "+" -> Integer.parseInt(valor1, 2) + Integer.parseInt(valor2, 2);
                case "-" -> Integer.parseInt(valor1, 2) - Integer.parseInt(valor2, 2);
                case "*" -> Integer.parseInt(valor1, 2) * Integer.parseInt(valor2, 2);
                case "/" -> Integer.parseInt(valor1, 2) / Integer.parseInt(valor2, 2);
                default -> 0;
            };

            System.out.println("Resultado binário: " + Integer.toBinaryString(resultado));
        }
        catch(Exception e) {
            System.out.print("Alerta de erro desconhecido: ");
            System.out.println(e.getMessage());
        }
    }

    public static boolean verificarValorBinario(String valor) {
        try {
            Integer.parseInt(valor, 2);
            return false;
        } catch (Exception e) {
            System.out.println("Isto não é um valor válido! Digite novamente!");
            return true;
        }
    }
}