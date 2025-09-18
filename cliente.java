public class cliente {

    private String idCliente;
    private String nome;


    public cliente(String idCliente, String nome) {
        this.idCliente = idCliente;
        this.nome = nome;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}