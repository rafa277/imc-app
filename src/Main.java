import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(new Locale("pt", "BR"));

        try {
            System.out.print("Digite o peso (kg): ");
            double peso = scanner.nextDouble();

            System.out.print("Digite a altura (m):");
            double altura = scanner.nextDouble();

            scanner.nextLine(); // Consome a quebra de linha pendente
            System.out.print("Digite o gênero (M para masculino, F para feminino): ");
            String genero = scanner.nextLine().trim().toUpperCase();

            String resultado = Imc.calcularCondicao(peso, altura, genero);
            if (resultado.equals("Valores inválidos") || resultado.equals("Gênero inválido")) {
                System.out.println(resultado);
            } else {
                double imc = peso / (altura * altura);
                System.out.printf("IMC: %.2f, Condição: %s%n", imc, resultado);
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Use números com vírgula (ex.: 1,83) para peso e altura, e M ou F para gênero.");
        } finally {
            scanner.close();
        }
    }
}
