package modelo.entidades;

public class NotaFiscal {
	private Double pagamentoBasico;
	private Double taxa;
	
	public NotaFiscal() {
	}

	public NotaFiscal(Double pagamentoBasico, Double taxa) {
		this.pagamentoBasico = pagamentoBasico;
		this.taxa = taxa;
	}

	public Double getPagamentoBasico() {
		return pagamentoBasico;
	}

	public void setPagamentoBasico(Double pagamentoBasico) {
		this.pagamentoBasico = pagamentoBasico;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
	
	public double totalPagamento() {
		return taxa + pagamentoBasico;
	}
}
