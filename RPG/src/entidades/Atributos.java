package entidades;

import java.io.Serializable;

/**
 * Atributos � uma classe para definir o ataque e defesa tanto do personagem como do monstro,
 * tambem serve para a batalha, calculando o dano 
 * @author Kadu/Romano
 * Version 1.0
 */
public abstract class Atributos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Double para o valor do ataque
	 * Double para o valor de defesa
	 */
	private double atck;
	private double def;

	public Atributos(double atck, double def) {
		super();
		this.atck = atck;
		this.def = def;
	}

	public double getAtck() {
		return atck;
	}

	public void setAtck(double atck) {
		this.atck = atck;
	}

	public double getDef() {
		return def;
	}

	public void setDef(double def) {
		this.def = def;
	}
	/**
	 * Fun�ao para que o personagem ataque o monstro
	 */
	public void atacarMonstro(Personagem p, Monstro m) {
		double x = p.getAtck() - m.getDef();
		double y = m.getVida() - x;
		m.setVida(y);
		System.out.println(m.getMonstro() + " Recebe " + x + " de dano ");
	}
	/**
	 * Fun��o para que o monstro ataque o personagem
	 */
	public void atacarPersonagem(Monstro m, Personagem p) {
		double x = m.getAtck() - p.getDef();
		double y = p.getVida() - x;
		p.setVida(y);
		System.out.println(p.getNome() + " Recebe " + x + " de dano ");
	}
	/**
	 * Fun��o para ataque forte do personagem no monstro
	 */
	public boolean atacarForte(Monstro m, Personagem p) {
		double x = p.getMana() - (p.getMaxmana() / 4);
		if (x < 0) {
			System.out.println("Voce nao tem mana!");
			return false;
		} else {
			double y = m.getVida() - p.getAtck();
			m.setVida(y);
			p.setMana(x);
			System.out.println(m.getMonstro() + " Recebe " + p.getAtck() + " de dano! ");
			return true;
		}

	}
	/**
	 * Fun��o que retorna a vida do personagem durante a batalha
	 */
	public boolean batalhaPm(Personagem p) {
		if (p.getVida() <= 0) {
			return true;
		}
		return false;
	}
	/**
	 * Fun��o que retorna a vida do monstro durante a batalha
	 */
	public boolean batalhaMp(Monstro m) {
		if (m.getVida() <= 0) {
			return true;
		}
		return false;
	}
	/**
	 * Fun��o que retorna a vida do Boss durante a batalha
	 */
	public boolean batalhaBoss(Boss b) {
		if (b.getVida() <= 0) {
			return true;
		}
		return false;
	}
	/**
	 * Fun��o para que o personagem ataque o boss
	 */
	public void atacarBoss(Personagem p, Boss b) {
		double x = p.getAtck() - b.getDef();
		double y = b.getVida() - x;
		b.setVida(y);
		System.out.println(b.getNome() + " Recebe " + x + " de dano ");
	}
	/**
	 * Fun��o para que o Boss ataque o personagem
	 */
	public void bossAtacarPersonagem(Boss b, Personagem p) {
		double x = b.getAtck() - p.getDef();
		double y = p.getVida() - x;
		p.setVida(y);
		System.out.println(p.getNome() + " Recebe " + x + " de dano ");
	}
	/**
	 * Fun��o para que o personagem ataque mais forte o Boss
	 */
	public boolean atacarForteBoss(Boss b, Personagem p) {
		double x = p.getMana() - (p.getMaxmana() / 4);
		if (x < 0) {
			System.out.println("Voce nao tem mana!");
			return false;
		} else {
			double y = b.getVida() - p.getAtck();
			b.setVida(y);
			p.setMana(x);
			System.out.println(b.getNome() + " Recebe " + p.getAtck() + " de dano! ");
			return true;
		}

	}


	public abstract void aumentaAtckDef(int lvl);

	public String toString() {
		return "Atributos [atck=" + atck + ", def=" + def + "]";
	}


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(atck);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(def);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atributos other = (Atributos) obj;
		if (Double.doubleToLongBits(atck) != Double.doubleToLongBits(other.atck))
			return false;
		if (Double.doubleToLongBits(def) != Double.doubleToLongBits(other.def))
			return false;
		return true;
	}

	
}
