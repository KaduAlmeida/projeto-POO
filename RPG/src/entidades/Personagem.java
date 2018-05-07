package entidades;

import java.io.Serializable;

/**
 * Personagem � uma clase para criacao e gerencia do objeto Personagem
 * @author Kadu
 * @version 1.0
 */
public class Personagem extends Atributos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * String para o nome do personagem
	 * Int para o level do personagem
	 * Double para o Xp do personagem
	 * Double para a vida m�xima do personagem
	 * Double para a vida do personagem
	 * Double para a mana m�xima do personagem
	 * Double para a mana do personagem
	 */
	private String nome;
	private int lvl;
	private double xp;
	private double maxvida;
	private double vida;
	private double maxmana;
	private double mana;
	private Diario diario;
	/**
	 * Construtor para a criar o personagem, recebendo apenas o nome pois os valores dos atributos iniciais ja sao pre-definidos.
	 */
	public Personagem(String nome) {
		super(10, 0);
		this.nome = nome;
		this.maxvida = 50;
		this.vida = 50;
		this.maxmana = 100;
		this.mana = 100;
		this.lvl = 1;
		this.xp = 0;
		this.diario = new Diario(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getMaxvida() {
		return maxvida;
	}

	public void setMaxvida(double maxvida) {
		this.maxvida = maxvida;
	}

	public double getVida() {
		return vida;
	}

	public void setVida(double vida) {
		this.vida = vida;
	}

	public double getMaxmana() {
		return maxmana;
	}

	public void setMaxmana(double maxmana) {
		this.maxmana = maxmana;
	}

	public double getMana() {
		return mana;
	}

	public void setMana(double mana) {
		this.mana = mana;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public double getXp() {
		return xp;
	}

	public void setXp(double xp) {
		this.xp = xp;
	}
	/**
	 * Fun��o para adicionar experiencia ao valor total de experiencia que o personagem ja tem
	 */
	public void maisXp(double xp) {
		this.xp += xp;
	}
	/**
	 * Fun��o para testar se o personagem tem o necessario para passar de n�vel
	 * caso ele tenha o necessario, as funcoes de melhoramento de status sao chamadas 
	 */
	public void lvlUP(double xp) {
		if (this.xp > 10 * this.lvl) {
			this.xp = 0;
			this.lvl++;
			aumentaAtckDef(lvl);
			aumentaVida(lvl);
		}
	}
	/**
	 * Fun��o para aumentar o ataque e defesa de acordo com o n�vel do personagem
	 */
	public void aumentaAtckDef(int lvl) {
		if (lvl > 1 && lvl < 5) {
			double x = this.getAtck() + (2 * lvl);
			setAtck(x);
			double y = this.getDef() + (2 * lvl);
			setDef(y);
		}
		if (lvl == 5) {
			double x = this.getAtck() + 15;
			setAtck(x);
			double y = this.getDef() + 10;
			setDef(y);
		}
		if (lvl > 5 && lvl < 15) {
			double x = this.getAtck() + (3 * lvl);
			setAtck(x);
			double y = this.getDef() + (3 * lvl);
			setDef(y);
		}
		if (lvl == 15) {
			double x = this.getAtck() + 35;
			setAtck(x);
			double y = this.getDef() + 25;
			setDef(y);
		}
		if (lvl > 15 && lvl < 30) {
			double x = this.getAtck() + (4 * lvl);
			setAtck(x);
			double y = this.getDef() + (3 * lvl);
			setDef(y);
		}
		if (lvl == 30) {
			double x = this.getAtck() + 40;
			setAtck(x);
			double y = this.getDef() + 30;
			setDef(y);
		}
		if (lvl > 30 && lvl < 50) {
			double x = this.getAtck() + (5 * lvl);
			setAtck(x);
			double y = this.getDef() + (4 * lvl);
			setDef(y);
		}
		if (lvl == 50) {
			double x = this.getAtck() + 50;
			setAtck(x);
			double y = this.getDef() + 40;
			setDef(y);
		}
	}
	/**
	 * Fun��o para aumentar a vida de acordo n�vel do personagem
	 */
	public void aumentaVida(int lvl) {
		if (lvl > 1 && lvl <= 5) {
			this.maxvida += 10;
			this.vida = this.maxvida;
		}
		if (lvl > 5 && lvl <= 15) {
			this.maxvida += 15;
			this.vida = this.maxvida;
		}
		if (lvl > 15 && lvl <= 30) {
			this.maxvida += 20;
			this.vida = this.maxvida;
		}
		if (lvl > 30 && lvl < 50) {
			this.maxvida += 30;
			this.vida = this.maxvida;
		}
		if (lvl == 50) {
			this.maxvida += 50;
			this.vida = this.maxvida;
		}
		if (lvl > 50) {
			this.maxvida += 40;
			this.vida = this.maxvida;
		}
	}
	/**
	 * Fun��o para adicionar ao diario um monstro recem encontrado
	 */
	public void usarDiario(Monstro m) {
		this.diario.adcMonstro(m);
	}
	/**
	 * Fun��o para adicionar ao diario um Boss recem encontrado.
	 */
	public void usarDiario(Boss b) {
		this.diario.adcBoss(b);
	}
	/**
	 * Fun��o para ler a capa do diario, onde estarao descritos:
	 *  o nome do dono do diario, a quantidade de monstros presentes e a quantidade de bosses presentes.
	 */
	public void capaDoDiario() {
		this.diario.statusDiario();
	}
	/**
	 * Fun��o usada para ler cada monstro e boss do diario, bosses aparecem depois dos monstros. 
	 */
	public void paginasDiario() {
		this.diario.lerDiario();
	}

	@Override
	public String toString() {
		return "Personagem [nome=" + nome + ", lvl=" + lvl + ", xp=" + xp + ", maxvida=" + maxvida + ", vida=" + vida
				+ ", maxmana=" + maxmana + ", mana=" + mana + ", diario=" + diario + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diario == null) ? 0 : diario.hashCode());
		result = prime * result + lvl;
		long temp;
		temp = Double.doubleToLongBits(mana);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(maxmana);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(maxvida);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		temp = Double.doubleToLongBits(vida);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(xp);
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
		Personagem other = (Personagem) obj;
		if (diario == null) {
			if (other.diario != null)
				return false;
		} else if (!diario.equals(other.diario))
			return false;
		if (lvl != other.lvl)
			return false;
		if (Double.doubleToLongBits(mana) != Double.doubleToLongBits(other.mana))
			return false;
		if (Double.doubleToLongBits(maxmana) != Double.doubleToLongBits(other.maxmana))
			return false;
		if (Double.doubleToLongBits(maxvida) != Double.doubleToLongBits(other.maxvida))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(vida) != Double.doubleToLongBits(other.vida))
			return false;
		if (Double.doubleToLongBits(xp) != Double.doubleToLongBits(other.xp))
			return false;
		return true;
	}
	
	
}
