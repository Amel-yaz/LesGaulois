package personnages;

public class Yakuza extends Humain {

    private String clan;
    private int reputation = 0;

    
    public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
        super(nom, boissonFavorite, argent); 
        this.clan = clan;
    }

   
    public void extorquer(Commercant victime) {
        parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
        parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
        int somme = victime.seFaireExtorquer(); // le commerçant perd tout
        gagnerArgent(somme);                    // le yakuza gagne cet argent
        reputation++;                           
        parler("J'ai piqué les " + somme + " sous de " + victime.getNom() 
             + ", ce qui me fait " + argent + " sous dans ma poche. Hi ! Hi !");
    }
    public int getReputation() {
    	return reputation;
    }
    
    public int perdre() {
    	int somme = argent ;
    	perdreArgent(argent);
    	reputation--;
    	parler("J'ai perdu mon duel et mes " + somme + "sous, snif ...J'ai deshonoré le clan de " + clan + ".");
    	return somme ;
    }
    
    
    public void gagner(int gain) {
    	gagnerArgent(gain);
    	reputation++;
    	parler("Ce ronin pensait vraiment battre" + getNom() + " du clan de  " + clan + "? Je l'ai depouillé de ses " + gain + "sous.");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}