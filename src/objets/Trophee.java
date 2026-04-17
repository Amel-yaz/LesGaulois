package objets;

import personnages.Gaulois;

public class Trophee {
    
    private Gaulois gaulois;
    private Equipement equipement;
    
    // Constructeur
    public Trophee(Gaulois gaulois, Equipement equipement) {
        this.gaulois = gaulois;
        this.equipement = equipement;
    }
    
    // Getteur pour gaulois
    public Gaulois getGaulois() {
        return gaulois;
    }
    
    // Getteur pour equipement
    public Equipement getEquipement() {
        return equipement;
    }
    
    // Méthode qui retourne le nom du Gaulois
    public String donnerNom() {
        return gaulois.getNom();
    }
}