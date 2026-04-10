package personnages;

public class Chaudron {
    private int quantitePotion;
    private int forcePotion; // renommé pour cohérence

    public boolean resterPotion() {
        return quantitePotion != 0;
    }

    public int prendreLouche() {
        quantitePotion--;
        return forcePotion;
    }

    public void remplirChaudron(int quantite, int forcePotion) {
        this.quantitePotion = quantite;
        this.forcePotion = forcePotion; // corrigé
    }
}