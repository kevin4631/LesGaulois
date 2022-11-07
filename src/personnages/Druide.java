package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		this.parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin
				+ " à " + effetPotionMax + ".");
	}

	public String getNom() {
		return this.nom;
	}

	public void parler(String texte) {
		System.out.println(this.prendreParole() + "« " + texte + " »");
	}

	private String prendreParole() {
		return "Le druide " + this.nom + " : ";
	}

	public void preparerPotion() {
		Random r = new Random();
		this.forcePotion = r.nextInt(this.effetPotionMin, this.effetPotionMax + 1);

		if (this.forcePotion > 7) {
			this.parler("j'ai préparé une super potion de force " + this.forcePotion);
		} else {
			this.parler(
					"je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + this.forcePotion);
		}
	}

	public void booster(Gaulois gaulois) {
		if (gaulois.getNom().equals("Obélix")) {
			this.parler("Non, Obélix !... T n'auras pas de potion magique!");
		} else {
			gaulois.boirePotion(this.forcePotion);
		}
	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("Paronamix", 5, 10);

		panoramix.preparerPotion();
		panoramix.preparerPotion();
		panoramix.preparerPotion();
		panoramix.preparerPotion();

	}
}
