import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ComprovanteVenda {
    private static final double DESCONTO_1 = 0.1;
    private static final double DESCONTO_2 = 0.15; 
    private static final double DESCONTO_3 = 0.2; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Produto[] produtos = new Produto[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Produto " + (i + 1) + ":");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Preço unitário: ");
            double precoUnitario = scanner.nextDouble();
            System.out.print("Quantidade vendida: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); 

            produtos[i] = new Produto(nome, precoUnitario, quantidade);
            System.out.println();
        }

        System.out.println("COMPROVANTE DE VENDA");
        System.out.println("EMPRESA");
        System.out.println("Data: " + obterDataAtual());
        System.out.println("Hora: " + obterHoraAtual());
        System.out.println("Produto\t\tValor");
        double totalVenda = 0;

        for (Produto produto : produtos) {
            double valorTotal = produto.calcularValorTotal();
            totalVenda += valorTotal;
            System.out.printf("%s\t\tR$ %.2f%n", produto.getNome(), valorTotal);
        }

        double desconto = calcularDesconto(totalVenda);
        double totalPagar = totalVenda - desconto;

        System.out.println("Total:\t\tR$ " + totalVenda);
        System.out.println("Descontinho de cria:\tR$ " + desconto);
        System.out.println("Total a Pagar:\tR$ " + totalPagar);

        scanner.close();
    }

    private static String obterDataAtual() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(new Date());
    }

    private static String obterHoraAtual() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(new Date());
    }

    private static double calcularDesconto(double valorTotal) {
        if (valorTotal < 100) {
            return 0;
        } else if (valorTotal < 200) {
            return valorTotal * DESCONTO_1;
        } else if (valorTotal < 500) {
            return valorTotal * DESCONTO_2;
        } else {
            return valorTotal * DESCONTO_3;
        }
    }
}