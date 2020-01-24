import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Exercicio {

	public static void main(String[] args) throws IOException {

		int delay = 5000; // delay de 5 seg.
		int interval = 5000; // intervalo de 5 seg.
		Timer timer = new Timer();

		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {

				Exercicio metodos = new Exercicio();
				try {
					metodos.executarTarefa();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, delay, interval);
	}

	private void executarTarefa() throws IOException {

		File arquivos[];

		Exercicio metodos = new Exercicio();

		String caminhoentrada = "C://Users//Alan//Desktop//exercicioapagar//entrada";

		String caminhoSaida = "C://Users//Alan//Desktop//exercicioapagar//saida//";

		File diretorio = new File(caminhoentrada);

		arquivos = diretorio.listFiles();

		for (String arq : diretorio.list()) {
			Path path = Paths.get("C:/Users/Alan/Desktop/exercicioapagar/entrada/" + arq.toString());

			List<String> linhasArquivo = Files.readAllLines(path);

			List<String> listaVendedor = new ArrayList<>();
			List<String> listaCliente = new ArrayList<>();
			List<String> listaVenda = new ArrayList<>();

			String infoVendedor = null;
			String infoCliente = null;

			String nomeArquivo = diretorio.toString();

			for (String linha : linhasArquivo) {

				String dadosVendedor = "001";
				String dadosCliente = "002";
				String dadosVenda = "003";
				if (linha.equals("")) {

				} else {
					if (linha.substring(0, 3).equals(dadosVendedor)) {

						listaVendedor.add(linha);
						infoVendedor = "Quantidade de vendedores: " + listaVendedor.size();

					} else if (linha.substring(0, 3).equals(dadosCliente)) {
						listaCliente.add(linha);
						infoCliente = "Quantidade de clientes: " + listaCliente.size();

					} else if (linha.substring(0, 3).equals(dadosVenda)) {
						listaVenda.add(linha);
					}
				}
			}
			
			metodos.escreverArquivos(caminhoSaida + arq.toString(), infoCliente, infoVendedor);
			File diretorioDelete = new File(caminhoentrada + "//" + arq.toString());
			diretorioDelete.delete();
		}
	}

	private void createArquivo(String caminhoSaida) throws IOException {
		File f = new File(caminhoSaida);
		if (!f.exists()) {
			f.createNewFile();
		}
	}

	private void escreverArquivos(String caminhoSaida, String dadosCliente, String dadosVendedores) throws IOException {
		this.createArquivo(caminhoSaida);

		File f = new File(caminhoSaida);
		PrintWriter pw = new PrintWriter(f);

		pw.println(dadosCliente);
		pw.println(dadosVendedores);

		pw.flush();
		pw.close();
	}
}
