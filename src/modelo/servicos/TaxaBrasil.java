package modelo.servicos;

public class TaxaBrasil implements TaxaServ{
	
	public double taxa(double valor) {
		if (valor <= 100.0) {
			return valor * 0.20;
		} else {
			return valor * 0.15;
		}
	}
}
