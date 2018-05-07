package menus;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import entidades.Boss;
import entidades.Diario;
import entidades.Monstro;
import entidades.Personagem;

/**
 * Saves � uma classe para salvar o jogo
 * @author Kadu
 * Version 1.0
 */
public class Saves {
	/**
	 * ArrayList para os Saves dos personagens
	 */
	private List<Personagem> Saves;

	public Saves(List<Personagem> saves) {
		Saves = saves;
	}

	public Saves() {
		this.Saves = new ArrayList<Personagem>();
	}
	/**
	 * Fun��o para salvar o personagem
	 */
	public void salvarPersonagem(Personagem x) {
		Saves.add(x);
	}
	/**
	 * Fun��o para apagar o personagem
	 */
	public void apagarPersonagem(String nome) {
		for (Personagem p : Saves) {
			if (p.getNome().equals(nome)) {
				Saves.remove(p);
			}
		}
	}
	/**
	 * Fun��o para retornar um objeto personagem
	 * metodo de busca é o atributo nome do objeto personagem
	 */
	public Personagem getPersonagemByName(String nome) {
		for (Personagem p : Saves) {
			if (p.getNome().equals(nome)) {
				return p;
			}
		}
		return null;
	}
	/**
	 * Fun��o para mostrar os Saves existentes no jogo
	 */
	public void mostrarSaves() {
		lerDoXmlSaves();
		for (Personagem p : Saves) {
			System.out.print(p.getNome());
		}
	}
	/**
	 * Fun��o para ler o Saves, salvos em XML, utilizando exceptions
	 */
	@SuppressWarnings("unchecked")
	public void lerDoXmlSaves() {
		try {
			XStream xStream = new XStream(new StaxDriver());
			XStream.setupDefaultSecurity(xStream);
			xStream.addPermission(AnyTypePermission.ANY);
			xStream.processAnnotations(Saves.class);
			xStream.processAnnotations(List.class);
			xStream.processAnnotations(Personagem.class);
			xStream.processAnnotations(Diario.class);
			xStream.processAnnotations(Monstro.class);
			xStream.processAnnotations(Boss.class); 
			BufferedInputStream input = new BufferedInputStream(new FileInputStream("Saves.xml"));
			Saves = (List<Personagem>) xStream.fromXML(input);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * Fun��o para gravar os Saves em XML utilizando exceptions 
	 */
	@SuppressWarnings("unchecked")
	public void gravarNoXmlSaves() {
		if (!Saves.isEmpty()) {
			XStream xStream = new XStream(new StaxDriver());
			xStream.alias("boss", Boss.class);
			xStream.alias("monstro", Monstro.class);
			xStream.alias("diario", Diario.class);
			xStream.alias("personagem", Personagem.class);
			xStream.alias("Saves", List.class);
			File arquivo = new File("Saves.xml");
			FileOutputStream gravar;
			try {
				gravar = new FileOutputStream(arquivo);
				gravar.write(xStream.toXML(Saves).getBytes());
				gravar.close();	
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	/**
	 * Fun��o para checar se o Save existe, utilizando exceptions
	 */
	public void checkSave(Saves save) throws IOException {
		File arquivo = new File("Saves.xml");
		if (arquivo.exists()) {
			save.lerDoXmlSaves();
		} else {
			arquivo.createNewFile();
		}
	}


	public String toString() {
		return "Saves [Saves=" + Saves + "]";
	}


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Saves == null) ? 0 : Saves.hashCode());
		return result;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Saves other = (Saves) obj;
		if (Saves == null) {
			if (other.Saves != null)
				return false;
		} else if (!Saves.equals(other.Saves))
			return false;
		return true;
	}

	
}

