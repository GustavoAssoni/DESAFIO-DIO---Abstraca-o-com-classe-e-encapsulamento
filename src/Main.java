import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ContaBancaria conta = new ContaBancaria("Gustavo", 1000.0);

        int opcao;

        do {
            System.out.println("---- MENU BANCÁRIO ----\n");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar cheque especial");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Pagar boleto");
            System.out.println("6 - Verificar uso do cheque especial");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;

                case 2:
                    conta.consultarChequeEspecial();
                    break;

                case 3:
                    System.out.print("Digite o valor para depósito: ");
                    double valorDeposito = sc.nextDouble();
                    conta.depositar(valorDeposito);
                    break;

                case 4:
                    System.out.print("Digite o valor para saque: ");
                    double valorSaque = sc.nextDouble();
                    conta.sacar(valorSaque);
                    break;

                case 5:
                    System.out.print("Digite o valor do boleto: ");
                    double valorBoleto = sc.nextDouble();
                    conta.pagarBoleto(valorBoleto);
                    break;

                case 6:
                    conta.verificarUsoChequeEspecial();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}
