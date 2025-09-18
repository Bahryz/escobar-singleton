import java.util.HashMap;
import java.util.Map;

public class accountManager {

    // A única instância da classe (padrão Singleton)
    private static accountManager instancia;

    // O mapa que armazena o ID da conta e o saldo
    private Map<String, Double> contas;

    // Construtor privado para que ninguém possa criar instâncias livremente
    private accountManager() {
        contas = new HashMap<>();
        // Adicionando contas iniciais para o exemplo
        contas.put("cliente-01", 1500.0);
        contas.put("cliente-02", 250.0);
    }

    // Método público para obter a única instância da classe
    public static accountManager getInstance() {
        if (instancia == null) {
            instancia = new accountManager();
        }
        return instancia;
    }

    // --- MÉTODOS DE GERENCIAMENTO DE CONTA ---

    /**
     * Deposita um valor na conta especificada.
     */
    public void depositar(String contaId, double valor) {
        if (valor <= 0) {
            System.out.println("O valor do depósito deve ser positivo.");
            return;
        }
        if (contas.containsKey(contaId)) {
            double saldoAtual = contas.get(contaId);
            contas.put(contaId, saldoAtual + valor);
            System.out.println("Depósito de R$" + valor + " realizado com sucesso na conta " + contaId);
        } else {
            System.out.println("Erro: Conta " + contaId + " não encontrada.");
        }
    }

    /**
     * Saca um valor da conta, se houver saldo suficiente.
     */
    public void sacar(String contaId, double valor) {
        if (valor <= 0) {
            System.out.println("O valor do saque deve ser positivo.");
            return;
        }
        if (contas.containsKey(contaId)) {
            double saldoAtual = contas.get(contaId);
            if (saldoAtual >= valor) {
                contas.put(contaId, saldoAtual - valor);
                System.out.println("Saque de R$" + valor + " realizado com sucesso da conta " + contaId);
            } else {
                System.out.println("Saldo insuficiente na conta " + contaId + " para sacar R$" + valor);
            }
        } else {
            System.out.println("Erro: Conta " + contaId + " não encontrada.");
        }
    }

    /**
     * Exibe o saldo atual de uma conta.
     */
    public void verSaldo(String contaId) {
        if (contas.containsKey(contaId)) {
            double saldo = contas.get(contaId);
            System.out.println("O saldo da conta " + contaId + " é: R$" + saldo);
        } else {
            System.out.println("Erro: Conta " + contaId + " não encontrada.");
        }
    }

    /**
     * Exibe todas as contas ativas e seus saldos.
     */
    public void listarContasAtivas() {
        System.out.println("\n--- Contas Ativas ---");
        for (Map.Entry<String, Double> entry : contas.entrySet()) {
            System.out.println("Conta: " + entry.getKey() + " | Saldo: R$" + entry.getValue());
        }
        System.out.println("---------------------\n");
    }
}