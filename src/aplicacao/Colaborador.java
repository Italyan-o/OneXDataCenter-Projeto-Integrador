package aplicacao;

public class Colaborador extends Usuario {

    private String cargo;
    private String departamento;
    private int nivelAcesso;

    public Colaborador(int codigo, String nome, String email, String telefone, String cargo, String departamento, int nivelAcesso) {
        super(codigo, nome, email, telefone);
        this.cargo = cargo;
        this.departamento = departamento;
        this.nivelAcesso = nivelAcesso;
    }

    public String getCargo() {
        return this.cargo;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public int getNivelAcesso() {
        return this.nivelAcesso;
    }

    public void atualizarDados(String nome, String email, String telefone, String cargo, String departamento, int nivelAcesso) {
        super.atualizarDadosBase(nome, email, telefone);
        if (cargo != null && cargo.isBlank()) {
            this.cargo = cargo;
        }
        if (departamento != null && departamento.isBlank()) {
            this.departamento = departamento;
        }
        if (nivelAcesso > 0) {
            this.nivelAcesso = nivelAcesso;
        }
    }

    @Override
    public String toString() {
        return "[COLABORADOR] " + super.toString() + " - Cargo: " + this.cargo + " - Depto: " + this.departamento + " - Nível Acesso: " + this.nivelAcesso;
    }
}
