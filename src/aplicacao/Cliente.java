package aplicacao;

public class Cliente extends Usuario {

    private String documentoIdentificacao;
    private String razaoSocial;
    private String endereco;

    public Cliente(int codigo, String nome, String email, String telefone, String documentoIdentificacao, String razaoSocial, String endereco) {
        super(codigo, nome, email, telefone);
        this.documentoIdentificacao = documentoIdentificacao;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
    }

    public String getDocumentoIdentificacao() {
        return this.documentoIdentificacao;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void atualizarDados(String nome, String email, String telefone, String documentoIdentificacao, String razaoSocial, String endereco) {
        super.atualizarDadosBase(nome, email, telefone);
        if (documentoIdentificacao != null && documentoIdentificacao.isBlank()
        
            ) { this.documentoIdentificacao = documentoIdentificacao;
        }
        if (razaoSocial != null && razaoSocial.isBlank()
        
            ) { this.razaoSocial = razaoSocial;
        }
        if (endereco != null && endereco.isBlank()
        
            ) { this.endereco = endereco;
        }
    }

    @Override
    public String toString() {
        return "[CLIENTE] " + super.toString() + " - Doc: " + this.documentoIdentificacao + " - Razão Social: " + this.razaoSocial + " - End: " + this.endereco;
    }
}
