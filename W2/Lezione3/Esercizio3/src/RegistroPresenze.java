import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;

public class RegistroPresenze {
	
	private static final String ENCODING = "utf-8";
	
				String nome;
				int presenze;
	
	public RegistroPresenze(String nome, int presenze) {
		this.nome=nome;
		this.presenze = presenze;
	}

	
	public String getPresenze() {
		String x =this.nome + "@" + this.presenze + "#";
		return x;
	}

	public void aggiungiPresenze(File fileInfo) {
		try {
			FileUtils.writeStringToFile(fileInfo, getPresenze(), ENCODING, true);
			System.out.println("-----------------------");
			System.out.printf("%s è stato aggiunto al registro%n", this.nome);
			System.out.println("-----------------------");
		} catch (IOException e) {
			System.out.println("ERRORE! File non trovato");
		}
	}
	
	static public void getUsers(File fileinfo)throws IOException {
		try {
			String content = FileUtils.readFileToString(fileinfo, ENCODING);
			String[] segments = content.split("#");
			for (int i = 0; i < segments.length; i++ ) {
				String[] user = segments[i].split("@");
				System.out.println(user[0] +" - " + "Presenze: " + user[1]);
				
			}
		} catch (IOException e) {
			System.out.println("Errore nella lettura del file");
		}
	}
	
}
