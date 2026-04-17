package personnages;

public class Ronin extends Humain {

    private int honneur = 1;

   
    public Ronin(String nom, String boissonFavorite, int argent) {
        super(nom, boissonFavorite, argent);
    }

    
    public void donner(Commercant beneficiaire) {
        int somme = argent / 10; 
        perdreArgent(somme);
        parler(beneficiaire.getNom() + " prend ces " + somme + " sous.");
        beneficiaire.recevoir(somme);
    }
    
    
    public void provoquer(Yakuza adversaire) {
        int force = honneur * 2;  // la force du ronin = honneur x 2
        parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");

        if (force >= adversaire.getReputation()) {
            // Le ronin GAGNE
            int somme = adversaire.perdre(); // le yakuza perd et retourne son argent
            gagnerArgent(somme);             // le ronin prend cet argent
            honneur++;                       // le ronin gagne 1 honneur
            parler("Je t'ai eu petit yakusa!");
        } else {
            // Le ronin PERD
            int somme = argent;              // on sauvegarde l'argent du ronin
            perdreArgent(argent);            // le ronin perd tout son argent
            honneur--;                       // le ronin perd 1 honneur
            adversaire.gagner(somme);        // le yakuza gagne cet argent
            parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
        }
    }
}