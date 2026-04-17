package personnages;

import java.util.Random;

public class Traitre extends Samourai {
    
    // Attributs
    private int niveauTraitrise;
    private Random random;
    
    // Constructeur
    public Traitre(String seigneur, String nom, String boissonFavorite, int argent) {
        super(nom, seigneur, boissonFavorite, argent);
        this.niveauTraitrise = 0;
        this.random = new Random();
    }
    
    // Getter pour le niveau de traîtrise
    public int getNiveauTraitrise() {
        return niveauTraitrise;
    }
    
    // Redéfinition de direBonjour
    @Override
    public void direBonjour() {
        super.direBonjour();
        parler("Mais je suis un traître et mon niveau de traîtrise est : " + niveauTraitrise + ". Chut !");
    }
    
    // Méthode pour rançonner un commerçant
    public void ranconner(Commercant commercant) {
        if (niveauTraitrise >= 3) {
            parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");
            return;
        }
        
        // Calcul de la rançon : 2/10 de l'argent du commerçant
        int somme = commercant.getArgent() * 2 / 10;
        if (somme > 0) {
            parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer !");
            parler("Donne-moi " + somme + " sous ou gare à toi !");
            commercant.parler("Tout de suite grand " + getNom() + ".");
            commercant.perdreArgent(somme);
            gagnerArgent(somme);
            niveauTraitrise++;
        }
    }
    
    // Méthode pour faire le gentil (donner de l'argent)
    public void faireLeGentil() {
        if (nbConnaissance == 0) {
            parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
            return;
        }
        
        // Choisir une connaissance au hasard
        int index = random.nextInt(nbConnaissance);
        Humain ami = memoire[index];
        
        int don = argent / 20;  // 1/20 de son argent
        if (don > 0) {
            parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + ami.getNom() + ".");
            parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant " + don + " sous.");
            perdreArgent(don);
            ami.gagnerArgent(don);
            ami.parler("Merci " + getNom() + ". Vous êtes quelqu'un de bien.");
            if (niveauTraitrise > 0) {
                niveauTraitrise--;
            }
        }
    }
}