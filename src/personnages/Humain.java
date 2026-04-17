package personnages;

public class Humain {

    private String nom;
    private String boissonFavorite;
    protected int argent;

    // Constructeur : reçoit les 3 infos de base
    public Humain(String nom, String boissonFavorite, int argent) {
        this.nom = nom;
        this.boissonFavorite = boissonFavorite;
        this.argent = argent;
    }

    // Accesseurs en lecture (get)
    public String getNom() {
        return nom;
    }

    public int getArgent() {
        return argent;
    }

    // parler est "protected" car utile aux sous-classes aussi
    protected void parler(String texte) {
        System.out.println("(" + nom + ") - " + texte);
    }

    // dire bonjour
    public void direBonjour() {
        parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonFavorite + ".");
    }

    // boire
    public void boire() {
        parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
    }

    public void acheter(String bien, int prix) {
        if (argent >= prix) {
            parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir un " + bien + " à " + prix + " sous");
            perdreArgent(prix); // 👈 on affiche D'ABORD, puis on retire l'argent
        } else {
            parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir un " + bien + " à " + prix + " sous.");
        }
    }
    // Ces 2 méthodes sont privées (seulement utilisables dans Humain)
    protected void gagnerArgent(int gain) {
        argent += gain;
    }

    protected void perdreArgent(int perte) {
        argent -= perte;
    }
}