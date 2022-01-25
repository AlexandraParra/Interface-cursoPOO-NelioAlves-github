package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.Aluguel;
import modelo.entidades.Veiculo;
import modelo.servicos.ServicoAluguel;
import modelo.servicos.TaxaBrasil;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		Scanner sc = new Scanner(System.in);
		System.out.println("Dados do aluguel:");
		System.out.print("Modelo do carro: ");
		String modelo = sc.nextLine();
		System.out.print("Saída (dd/mm/aaaa hh:ss): ");
		Date inicio = sdf.parse(sc.nextLine());
		System.out.print("Retorno (dd/mm/aaaa hh:ss): ");
		Date fim = sdf.parse(sc.nextLine());
		Aluguel aluguel = new Aluguel(inicio, fim, new Veiculo(modelo));
		
		System.out.print("Preço por hora: ");
		double precoHora = sc.nextDouble();
		System.out.print("Preço por dia: ");
		double precoDia = sc.nextDouble();
		ServicoAluguel serv =  new ServicoAluguel(precoHora, precoDia, new TaxaBrasil());
		serv.processoNota(aluguel);
		
		System.out.println("Nota Fiscal:");
		System.out.printf("Pagamento básico: %.2f", aluguel.getNotaFiscal().getPagamentoBasico());
		System.out.printf("\nTaxa: %.2f", aluguel.getNotaFiscal().getTaxa());
		System.out.printf("\nTotal a pagar: %.2f", aluguel.getNotaFiscal().totalPagamento());
		
		sc.close();

	}

}
