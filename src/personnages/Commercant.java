package personnages;

public class Commercant extends Humain {
   
    public Commercant(String nom, int argent) {
        super(nom, "thé", argent); // on appelle le constructeur de Humain
    }

   
    public int seFaireExtorquer() {
        int somme = argent; 
        perdreArgent(argent);
        parler("J'ai tout perdu! Le monde est trop injuste...");
        return somme;
    }

   
    public void recevoir(int somme) {
        gagnerArgent(somme);
        parler(somme + " sous ! Je te remercie généreux donateur!");
    }
}