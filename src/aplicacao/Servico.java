package aplicacao;

public class Servico {

    private int codigo;
    private String nome;
    private String descricao;
    private double valorMensal;
    private boolean ativo;

    public Servico(int codigo, String nome, String descricao, double valorMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.valorMensal = valorMensal;
        this.ativo = true;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public double getValorMensal() {
        return this.valorMensal;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void atualizarDados(String nome, String descricao, double valorMensal) {
        if (nome != null && nome.isBlank()
        
            ) { this.nome = nome;
        }
        if (descricao != null && descricao.isBlank()
        
            ) { this.descricao = descricao;
        }
        if (valorMensal > 0
        
            ) { this.valorMensal = valorMensal;
        }
    }

    public void desativar() {
        this.ativo = false;
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.nome + " (R$ " + this.valorMensal + "/mês) - Status: " + (this.ativo ? "Ativo" : "Inativo") + " - Desc: " + this.descricao;
    }
}
