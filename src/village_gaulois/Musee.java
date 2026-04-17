package village_gaulois;

import objets.Equipement;
import objets.Trophee;
import personnages.Gaulois;

public class Musee {
    
    private Trophee[] trophees;
    private int nbTrophee;
    
    // Constructeur : on crée un musée avec de la place pour 200 trophées
    public Musee() {
        this.trophees = new Trophee[200];
        this.nbTrophee = 0;
    }
    
    // Méthode pour ajouter un trophée au musée
    public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
        if (nbTrophee < trophees.length) {
            trophees[nbTrophee] = new Trophee(gaulois, equipement);
            nbTrophee++;
        } else {
            System.out.println("Le musée est plein ! Impossible d'ajouter plus de trophées.");
        }
    }
    
    // Méthode pour afficher tous les trophées du musée
    public void afficherTrophees() {
        System.out.println("Voici les trophées du musée :");
        for (int i = 0; i < nbTrophee; i++) {
            System.out.println("- " + trophees[i].donnerNom() + " : " + trophees[i].getEquipement());
        }
    }
    
    public String extraireInstructionsOCaml() {
        if (nbTrophee == 0) {
            return "let musee = [];;";
        }
        
        String resultat = "let musee = [\n";
        
        for (int i = 0; i < nbTrophee; i++) {
            String nomGaulois = trophees[i].donnerNom();
            String nomEquipement = trophees[i].getEquipement().toString().toLowerCase(); // 👈 toLowerCase()
            
            resultat += "  \"" + nomGaulois + "\", \"" + nomEquipement + "\"";
            
            if (i < nbTrophee - 1) {
                resultat += ";\n";
            } else {
                resultat += "\n";
            }
        }
        
        resultat += "];;";  // 👈 double ;; à la fin comme en OCaml
        return resultat;
    }
}