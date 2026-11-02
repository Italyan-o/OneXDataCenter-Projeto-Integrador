package aplicacao;

public class ChamadoSuporte {

    private int codigo;
    private Cliente cliente;
    private Colaborador tecnicoResponsavel;
    private String assunto;
    private String prioridade;
    private String status;

    public ChamadoSuporte(int codigo, Cliente cliente, String assunto, String prioridade) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.assunto = assunto;
        this.prioridade = prioridade;
        this.status = "Aberto";
        this.tecnicoResponsavel = null;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Colaborador getTecnicoResponsavel() {
        return this.tecnicoResponsavel;
    }

    public String getStatus() {
        return this.status;
    }

    public void atribuirTecnico(Colaborador tecnico) {
        this.tecnicoResponsavel = tecnico;
        if (this.status.equals("Aberto")) {
            this.status = "Em Andamento";
        }
    }

    public void encerrarChamado() {
        this.status = "Encerrado";
    }

    @Override
    public String toString() {
        String tecNome = (tecnicoResponsavel != null) ? tecnicoResponsavel.getNome() : "Não Atribuído";
        return "Chamado #" + codigo + " - Cliente: " + cliente.getNome() + " - Assunto: " + assunto + " - Prioridade: " + prioridade + " - Técnico: " + tecNome + " - Status: " + status;
    }
}
