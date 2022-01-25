package modelo.servicos;

import modelo.entidades.Aluguel;
import modelo.entidades.NotaFiscal;

public class ServicoAluguel {
	private Double precoHora;
	private Double precoDia;
	
	private TaxaServ taxaServico;
	
	public ServicoAluguel() {
	}

	public ServicoAluguel(Double precoHora, Double precoDia, TaxaServ taxaServico) {
		this.precoHora = precoHora;
		this.precoDia = precoDia;
		this.taxaServico = taxaServico;
	}

	public void processoNota(Aluguel aluguel) {
		long inicio = aluguel.getInicio().getTime();
		long fim = aluguel.getFim().getTime();
		
		double horas = (double)(fim-inicio)/1000/60/60;
		double pagamentoBasico;
		if (horas <= 12.0) {
			pagamentoBasico = Math.ceil(horas) * precoHora;
		} else {
			pagamentoBasico = Math.ceil(horas/24) * precoDia;
		}
		
		double taxa = taxaServico.taxa(pagamentoBasico);
		aluguel.setNotaFiscal(new NotaFiscal(pagamentoBasico, taxa));
	}
}
