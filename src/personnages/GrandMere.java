package personnages;

import java.util.Random;

public class GrandMere extends Humain {
    
    private static final int MEMOIRE_GRAND_MERE = 5;
    private Random random = new Random();
    
    public GrandMere(String nom, int argent) {
        super(nom, "tisane", argent);
    }
    
    @Override
    protected void memoriser(Humain humain) {
        if (nbConnaissance >= MEMOIRE_GRAND_MERE) {
            parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
            return;
        }
        super.memoriser(humain);
    }
    
    private String humainHasard() {
        String[] types = {"Commercant", "Ronin", "Samourai", "Yakuza", "Traitre", "habitant"};
        int index = random.nextInt(types.length);
        return types[index];
    }
    
    public void ragoter() {
        for (int i = 0; i < nbConnaissance; i++) {
            Humain h = memoire[i];
            if (h == null) continue;
            
            if (h instanceof Traitre) {
                parler("Je sais que " + h.getNom() + " est un traître. Petit chenapan !");
            } else {
                String type = humainHasard();
                parler("Je crois que " + h.getNom() + " est " + type);
            }
        }
    }
}