package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/** 
 * Diario � uma classe para criar um Diario para o personagem onde ele
 * pode ver suas conquistas
 * @author Kadu/Phelipe
 * Version 1.0
 * 
 */
public class Diario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * String para o dono do Diario 
	 * ArrayList para montar uma lista dos monstros no Diario
	 * ArrayList para montar a lista de trofeus dos Boss no Diario
	 */
	private String dono;
	private List<Monstro> diario;
	private List<Boss> trofeus;
	/**
	 * Fun��o para criar o Diario do personagem
	 */
	public Diario(String dono) {
		this.dono = dono;
		diario = new ArrayList<Monstro>();
		trofeus = new ArrayList<Boss>();
	}
	/**
	 * Fun��o para adicionar o monstro ao Diario
	 */
	public void adcMonstro(Monstro m) {
		diario.add(m);
	}
	/**
	 * Fun��o para adicionar ao personagem o trofel do boss
	 */
	public void adcBoss(Boss b) {
		trofeus.add(b);
	}
	/**
	 * Fun��o para ler o Diario do personagem 
	 */
	public void lerDiario() {
		System.out.println("Monstros:");
		for (Monstro m : diario) {
			System.out.println(m);
		}
		System.out.println("Trofeus:");
		for (Boss b : trofeus) {
			System.out.println(b);
		}
	}
	/**
	 * Fun��o para mostrar o Diario do personagem
	 */
	public void statusDiario() {
		System.out.println("Diario de " + dono);
		System.out.println("Paginas escritas: " + diario.size());
		System.out.println("Trofeus alcancados: " + trofeus.size());
	}


	public String toString() {
		return "Diario [dono=" + dono + ", diario=" + diario + ", trofeus=" + trofeus + "]";
	}


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diario == null) ? 0 : diario.hashCode());
		result = prime * result + ((dono == null) ? 0 : dono.hashCode());
		result = prime * result + ((trofeus == null) ? 0 : trofeus.hashCode());
		return result;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diario other = (Diario) obj;
		if (diario == null) {
			if (other.diario != null)
				return false;
		} else if (!diario.equals(other.diario))
			return false;
		if (dono == null) {
			if (other.dono != null)
				return false;
		} else if (!dono.equals(other.dono))
			return false;
		if (trofeus == null) {
			if (other.trofeus != null)
				return false;
		} else if (!trofeus.equals(other.trofeus))
			return false;
		return true;
	}

	
}
