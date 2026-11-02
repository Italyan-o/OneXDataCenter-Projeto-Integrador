package aplicacao;

public class Fatura {

    private int codigo;
    private Contrato contrato;
    private double valorTotal;
    private double valorPago;
    private String statusPagamento;

    public Fatura(int codigo, Contrato contrato) {
        this.codigo = codigo;
        this.contrato = contrato;
        this.valorTotal = contrato.getValorMensalTotal();
        this.valorPago = 0.0;
        this.statusPagamento = "Pendente";
    }

    public int getCodigo() {
        return this.codigo;
    }

    public Contrato getContrato() {
        return this.contrato;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public double getValorPago() {
        return this.valorPago;
    }

    public String getStatusPagamento() {
        return this.statusPagamento;
    }

    public boolean registrarPagamento(double valor) {
        if (valor <= 0 || this.statusPagamento.equals("Pago")) {
            return false;
        }
        this.valorPago += valor;
        if (this.valorPago >= this.valorTotal) {
            this.statusPagamento = "Pago";
        } else {
            this.statusPagamento = "Pago Parcial";
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fatura #" + codigo + " - Contrato #" + contrato.getCodigo() + " (" + contrato.getCliente().getNome() + ") - Total: R$ " + valorTotal + " - Pago: R$ " + valorPago + " - Status: " + statusPagamento;
    }
}
