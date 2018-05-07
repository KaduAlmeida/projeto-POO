package entidades;

import java.io.Serializable;

/**
 * Boss � uma classe para definir os Bosses do jogo
 * @author Phelipe/Romano
 * @version 1.0
 */
public class Boss extends Atributos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * String para o nome 
	 * Double para o valor da vida
	 */
	private String nome;
	private double vida;
	/**
	 * Fun��o para que crie o boss de acordo com o n�vel do personagem
	 */
	public Boss(int lvl) {
		super(0, 0);
		if (lvl == 5) {
			this.nome = "Ratazana";
			this.vida = 200;
		}
		if (lvl == 15) {
			this.nome = "Rei esqueleto";
			this.vida = 500;
		}
		if (lvl == 30) {
			this.nome = "Vampiro Superior";
			this.vida = 700;
		}
		if (lvl == 50) {
			this.nome = "A mao que da medo";
			this.vida = 1000;
		}
		if (lvl == 100) {
			this.nome = "Cutchulu";
			this.vida = 100000;
		}
		aumentaAtckDef(lvl);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getVida() {
		return vida;
	}

	public void setVida(double vida) {
		this.vida = vida;
	}
	/**
	 * Fun��o para os valores de ataque e defesa dos bosses
	 * baseado no lvl do personagem que ele estará enfrentando,
	 * lvl é recebido como parametro
	 */
	public void aumentaAtckDef(int lvl) {
		if (lvl == 5) {
			setAtck(15);
			setDef(15);
		}
		if (lvl == 15) {
			setAtck(100);
			setDef(100);
		}
		if (lvl == 30) {
			setAtck(200);
			setDef(150);
		}
		if (lvl == 50) {
			setAtck(300);
			setDef(300);
		}
		if (lvl == 100) {
			setAtck(500);
			setDef(500);
		}
	}
	/**
	 * Fun��o para retornar a quantidade de experiencia ap�s derrotar um boss
	 * @return double
	 */
	public double xpBoss(int lvl) {
		if (lvl == 5) {
			return 50;
		}
		if (lvl == 15) {
			return 150;
		}
		if (lvl == 30) {
			return 300;
		}
		if (lvl == 50) {
			return 500;
		}
		if (lvl == 100) {
			return 1000;
		}
		return 0;
	}


	public String toString() {
		return "Nome:" + nome + ", Vida:" + vida + ", Ataque: " + this.getAtck() + ", Defesa: " + this.getDef() + ".";
	}


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(vida);
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
		Boss other = (Boss) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(vida) != Double.doubleToLongBits(other.vida))
			return false;
		return true;
	}

	
}
