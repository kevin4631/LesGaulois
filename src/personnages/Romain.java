package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return this.nom;
	}

	public void parler(String texte) {
		System.out.println(this.prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + this.nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		this.force -= forceCoup;
		if (this.force > 0) {
			this.parler("Aïe");
		} else {
			this.parler("J'abandonne...");
		}
	}

	public static void main(String[] args) {
		Romain lou = new Romain("lou", 2);
		lou.parler("nponnoonnonno");
		lou.parler("nponnoonnonno");
		lou.recevoirCoup(1);
	}
}
