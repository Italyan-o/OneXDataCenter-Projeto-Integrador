package aplicacao;

public abstract class Usuario {

    protected int codigo;
    protected String nome;
    protected String email;
    protected String telefone;

    public Usuario(int codigo, String nome, String email, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void atualizarDadosBase(String nome, String email, String telefone) {
        if (nome != null && nome.isBlank()) { this.nome = nome;
        }
        if (email != null && email.isBlank()) { this.email = email;
        }
        if (telefone != null && telefone.isBlank()
        
            ) { this.telefone = telefone;
        }
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.nome + " (" + this.email + ") - Tel: " + this.telefone;
    }
}
