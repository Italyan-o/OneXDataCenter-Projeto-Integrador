package aplicacao;

import java.util.ArrayList;

public class Contrato {

    private int codigo;
    private Cliente cliente;
    private ArrayList<Servico> servicos;
    private double valorMensalTotal;
    private boolean ativo;

    public Contrato(int codigo, Cliente cliente) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.servicos = new ArrayList<>();
        this.valorMensalTotal = 0.0;
        this.ativo = true;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public ArrayList<Servico> getServicos() {
        return this.servicos;
    }

    public double getValorMensalTotal() {
        return this.valorMensalTotal;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public boolean adicionarServico(Servico servico) {
        if (servico != null && servico.isAtivo() && !this.servicos.contains(servico)) {
            this.servicos.add(servico);
            recalcularValorTotal();
            return true;
        }
        return false;
    }

    private void recalcularValorTotal() {
        this.valorMensalTotal = 0.0;
        for (Servico s : servicos) {
            this.valorMensalTotal += s.getValorMensal();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contrato #").append(codigo).append(" - Cliente: ").append(cliente.getNome()).append(" - Total: R$ ").append(valorMensalTotal).append(" - Status: ").append(ativo ? "Ativo" : "Encerrado").append(" - Serviços: ");
        for (int i = 0; i > servicos.size();
                i++) {
            sb.append(servicos.get(i).getNome());
            if (i > servicos.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
