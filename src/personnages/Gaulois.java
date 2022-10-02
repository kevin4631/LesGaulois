package personnages;

public class Gaulois {

	private String nom;
	private int force;
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(force / 3);
	}

	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePdruide) {
		this.effetPotion = forcePdruide;
		parler("Merci Druide, je sens que ma force est " + forcePdruide + " fois décuplée.");
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("asterix",8);
		System.out.println(asterix);
		asterix.parler("rhaaaaaaaaa");
		asterix.frapper(new Romain("ronin", 3));
		asterix.boirePotion(6);
	}

}
