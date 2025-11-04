public class ContaBancaria {

    private String titular;
    private double saldo;
    private double chequeEspecial;
    private double limiteChequeEspecial;
    private boolean usandoChequeEspecial;

    //Metodo construtor que inicia o saldo da pessoa com parametros especificos
    public ContaBancaria(String titular, Double depositoInicial) {
        this.titular = titular;
        this.saldo = depositoInicial;

        if (depositoInicial <= 500) {
            this.limiteChequeEspecial = 50;
        } else {
            this.limiteChequeEspecial = depositoInicial * 0.5;
        }

        this.chequeEspecial = this.limiteChequeEspecial; // valor disponível inicialmente
    }


    //metodo que mostra o saldo da conta
    public void consultarSaldo() {
        System.out.println("Seu saldo é: R$ " + saldo);
    }

    public void consultarChequeEspecial() {
        System.out.println("Seu cheque especial é: R$ " + chequeEspecial);
    }

    public void depositar(double deposito) {
        ;

        if (deposito < 0) {
            System.out.println("Valor invalido para o deposito!");
        } else {
            saldo += deposito;
            System.out.println("Deposito de: R$ " + deposito + " realizado com sucesso");
            System.out.println("Novo saldo de: R$ " + saldo);
        }

    }
    public void sacar(double valor){
        if (valor < 0){
            System.out.println("Valor invalido para saque!");
        } else if (valor <= saldo){
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " Realizado com sucesso!");
        } else if (valor <= saldo + chequeEspecial) {
            double valorUsado = valor - saldo;
            saldo = 0;
            chequeEspecial -= valorUsado;
            usandoChequeEspecial = true;
            System.out.println("Saque realizado utilizando o cheque especial!");
            System.out.println("Valor usado do cheque especial: R$ " + valorUsado);
        } else {
            System.out.println("Saldo insuficiente, mesmo com cheque especial.");
        }
    }
    public void pagarBoleto(double valor) {
        if (valor < 0) {
            System.out.println("Valor inválido para pagamento!");
            return;
        }

        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Boleto pago com sucesso!");
            System.out.println("Saldo atual de R$ " + saldo);
        } else if (saldo + chequeEspecial >= valor) {
            double valorUsado = valor - saldo;
            saldo = 0;
            chequeEspecial -= valorUsado;
            usandoChequeEspecial = true;
            System.out.println("Boleto pago utilizando o cheque especial!");
            System.out.println("Valor usado do cheque especial: R$ " + valorUsado);
            System.out.println("Cheque especial restante: R$ " + chequeEspecial);
        } else {
            System.out.println("Saldo insuficiente, mesmo com cheque especial.");
        }
    }

    public void verificarUsoChequeEspecial() {
        if (usandoChequeEspecial) {
            System.out.println("A conta está usando o cheque especial.");
            System.out.println("Limite disponível restante: R$ " + chequeEspecial);
        } else {
            System.out.println("A conta não está utilizando o cheque especial.");
            System.out.println("Saldo atual: R$ " + saldo);
        }
    }

}
