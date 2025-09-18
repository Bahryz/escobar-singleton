public class main {
    public static void main(String[] args) {
        // Criando alguns clientes
        cliente cliente1 = new cliente("cliente-01", "Ana");
        cliente cliente2 = new cliente("cliente-02", "Bruno");

        // Obtendo a ÚNICA instância do AccountManager
        accountManager manager = accountManager.getInstance();

        System.out.println(">>> Operações de " + cliente1.getNome());
        // Cliente 1 realiza operações
        manager.depositar(cliente1.getIdCliente(), 200.0);
        manager.verSaldo(cliente1.getIdCliente());
        manager.sacar(cliente1.getIdCliente(), 1000.0);
        manager.verSaldo(cliente1.getIdCliente());

        System.out.println("\n>>> Operações de " + cliente2.getNome());
        // Cliente 2 realiza operações
        manager.verSaldo(cliente2.getIdCliente());
        manager.sacar(cliente2.getIdCliente(), 300.0); // Isso vai falhar (saldo insuficiente)
        manager.verSaldo(cliente2.getIdCliente());

        // Listando todas as contas no final
        manager.listarContasAtivas();
    }
}