package personnages;

import village_gaulois.Village;
import village_gaulois.Musee;
import objets.Equipement;

public class Gaulois {

    private String nom;
    private int force;
    private int effetPotion = 1;
    private Village village;
    private int nbTrophees;
    private static final int TAILLE_TROPHEES = 100;
    private Equipement[] trophees = new Equipement[TAILLE_TROPHEES];

    public Gaulois(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }

    public String getNom() {
        return nom;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public Village getVillage() {
        return village;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "\"" + texte + "\"");
    }

    private String prendreParole() {
        return "Le gaulois " + nom + " : ";
    }

    public int getForce() {
        return force;
    }
    public int getNbTrophees() {
        return nbTrophees;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void frapper(Romain romain) {
        System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
        Equipement[] tropheesBataille = romain.recevoirCoup((force / 2) * effetPotion);
        
        if (effetPotion > 1) {
            effetPotion--;
        }
        
        if (tropheesBataille != null) {
            for (int i = 0; i < tropheesBataille.length; i++) {
                if (nbTrophees < TAILLE_TROPHEES) {
                    trophees[nbTrophees] = tropheesBataille[i];
                    nbTrophees++;
                }
            }
        }
    }

    public void boirePotion(int forcePotion) {
        effetPotion = forcePotion;
    }

    public void sePresenter() {
        if (village != null && village.getChef() == this) {
            parler("Bonjour, je m'appelle " + nom + ". Je suis le chef du village : " + village.getNom() + ".");
        } else if (village != null) {
            parler("Bonjour, je m'appelle " + nom + ". J'habite le village : " + village.getNom() + ".");
        } else {
            parler("Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.");
        }
    }

    public void afficherTrophees() {
        System.out.println("Les trophées de " + nom + " :");
        for (int i = 0; i < nbTrophees; i++) {
            System.out.println("- " + trophees[i]);
        }
    }

    @Override
    public String toString() {
        return nom;
    }
    public void faireUneDonnation(Musee musee) {
        if (nbTrophees == 0) {
            parler("Je n'ai aucun trophée à donner...");
            return;
        }
        
        String message = "Je donne au musee tous mes trophees :";
        for (int i = 0; i < nbTrophees; i++) {
            message += "\n- " + trophees[i];
        }
        parler(message);
        
        // Donner chaque trophée au musée
        for (int i = 0; i < nbTrophees; i++) {
            musee.donnerTrophees(this, trophees[i]);
        }
        
        // Vider le tableau des trophées du Gaulois
        for (int i = 0; i < nbTrophees; i++) {
            trophees[i] = null;
        }
        nbTrophees = 0;
    }
    
    
    
    
    
    
    
}