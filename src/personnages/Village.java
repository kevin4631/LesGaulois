package personnages;

public class Village {

	private String nom;
	private Chef chef;
	private Gaulois villageois[];
	private int nbVillageois = 0;
	private int nbVillageoisMaximum;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageoisMaximum = nbVillageoisMaximum;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (this.nbVillageois < this.villageois.length) {
			this.villageois[this.nbVillageois++] = gaulois;
		}
	}

	public Gaulois trouverHabitant(int numVillageois) {
		if (numVillageois >= this.nbVillageoisMaximum) {
			System.err.println("ERREUR : numVillageois est > à villageois.length.");
			System.exit(1);
		}
		return this.villageois[numVillageois];
	}

	public void afficherVillageois() {
		System.out.println("Dans le village " + this.getNom() + "vivent de légendaires gaulois :");

		for (int i = 0; i < this.nbVillageois; i++) {
			System.out.println("- " + this.villageois[i].getNom());
		}
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return this.nom;
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);

		// Gaulois gaulois = village.trouverHabitant(30);
		/*
		 * le tableau a pour index 0 -> 29 de taille 30 donc accéder à la case 30 n'est
		 * pas possible car elle n'existe pas
		 */

		village.setChef(new Chef("Abraracourcix", 6, village));
		village.ajouterHabitant(new Gaulois("Astérix", 8));

		// Gaulois gaulois = village.trouverHabitant(1);
		// System.out.println(gaulois);
		/*
		 * le tableau a pour index 0 -> 29 mais pour l'instant seul à l'index 0 se
		 * trouve un object, le reste de tableau est vide
		 *
		 **/

		village.ajouterHabitant(new Gaulois("Obélix", 25));
		village.afficherVillageois();

	}
}
