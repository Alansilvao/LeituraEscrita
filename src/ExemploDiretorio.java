import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ExemploDiretorio {
	
	public static void main(String[] args) {
		// Determina o diretório que será acessado e o nome do arquivo que será criado
		String caminhoDiretorio = "C://Users//Alan//Desktop//exercicioapagar//entrada";
		String nomeArquivoTxt = "ExemploArquivo.txt";
		
		ExemploDiretorio exemploDiretorio = new ExemploDiretorio();
		
		File file = new File(caminhoDiretorio);		
		ArrayList<String> lstFiles = new ArrayList<String>();
		
		// Realiza interação em todas as pastas e arquivos
		for (File f : file.listFiles()) {
			// adiciona os nomes das pastas e arquivos em uma lista
			lstFiles.add(f.getName());
		}
		
		try {
			// chama o metodo para realizar escrita dos valores no arquivo txt
			exemploDiretorio.escreverArquivo(caminhoDiretorio + nomeArquivoTxt,lstFiles);
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}
	
	/**
	 * Realiza criação do arquivo TXT
	 * 
	 * @param caminhoArquivo
	 * @throws IOException
	 */
	private void createArquivo(String caminhoArquivo) throws IOException{
		File f = new File(caminhoArquivo);
		if (!f.exists()){
			f.createNewFile();
		}
	}
	
	/**
	 * Realiza a escrita dos valores no arquivo TXT
	 * 
	 * @param caminhoArquivo - path do arquivo
	 * @param lstFiles - lista de valores a serem escritos
	 * @throws IOException
	 */
	private void escreverArquivo(String caminhoArquivo, List<String> lstFiles) throws IOException{
		this.createArquivo(caminhoArquivo);
		
		File f = new File(caminhoArquivo);
		PrintWriter pw = new PrintWriter(f);
		
		for (String valor : lstFiles) {
			pw.println(valor);
		}
		
		pw.flush();
		pw.close();
	}
}