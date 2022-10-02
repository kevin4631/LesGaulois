package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Romain  minus     = new Romain("Minus", 6);
		Gaulois asterix   = new Gaulois("Astérix", 8);
		Gaulois obelix    = new Gaulois("Obélix", 8);
		Druide  panoramix = new Druide("Paronamix",5,10);
		
		panoramix.parler("Je vais aller péparer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		
		obelix.parler("Par Bélénos, ce n'st pas juste !");
		
		asterix.parler("Bonjour");
		
		minus.parler("UN GAU... UN GAUGAU...");
		
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);		
		
	}

}
