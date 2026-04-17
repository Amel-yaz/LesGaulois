package personnages;

import objets.Equipement;

public class Romain {

    private String nom;
    private int force;
    private Equipement[] equipements = new Equipement[2];
    private int nbEquipement = 0;

    public Romain(String nom, int force) {
        this.nom = nom;
        this.setForce(force);
        assert isInvariantVerified();
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "\"" + texte + "\"");
    }

    private String prendreParole() {
        return "Le romain " + nom + " : ";
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public Equipement[] recevoirCoup(int forceCoup) {
        Equipement[] equipementEjecte = null;
        forceCoup = calculerResistanceEquipement(forceCoup);
        int forceAvantCoup = force;
        force = force - forceCoup;
        
        if (force <= 0) {
            force = 0;
            parler("Aïe");
        } else {
            parler("Aïe");
        }
        
        if (force == 0 && forceAvantCoup > 0) {
            equipementEjecte = ejecterEquipement();
            parler("J'abandonne...");
        }
        
        return equipementEjecte;
    }
    
   
    private int calculerResistanceEquipement(int forceCoup) {
        String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
        int resistanceEquipement = 0;
        if (nbEquipement != 0) {
            for (int i = 0; i < nbEquipement; i++) {
                if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
                    resistanceEquipement += 8;
                } else if (equipements[i] != null && equipements[i].equals(Equipement.CASQUE)) {
                    resistanceEquipement += 5;
                }
            }
            
            // Si la résistance est plus grande ou égale à la force du coup
            if (resistanceEquipement >= forceCoup) {
                texte += "\nMais heureusement, grâce à mon équipement sa force a été complètement absorbée.";
                parler(texte);
                return 0;
            } else {
                texte += "\nMais heureusement, grâce à mon équipement sa force a été diminuée de " + resistanceEquipement + " !";
                parler(texte);
                forceCoup -= resistanceEquipement;
                return forceCoup;
            }
        } else {
            parler(texte);
            return forceCoup;
        }
    }
    
    

    private Equipement[] ejecterEquipement() {
        Equipement[] equipementEjecte = new Equipement[nbEquipement];
        System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
        int nbEquipementEjecte = 0;
        for (int i = 0; i < nbEquipement; i++) {
            if (equipements[i] != null) {
                equipementEjecte[nbEquipementEjecte] = equipements[i];
                nbEquipementEjecte++;
                equipements[i] = null;
            }
        }
        
        // Mettre à jour nbEquipement car on a perdu des équipements
        int nouveauNbEquipement = 0;
        for (int i = 0; i < equipements.length; i++) {
            if (equipements[i] != null) {
                nouveauNbEquipement++;
            }
        }
        nbEquipement = nouveauNbEquipement;
        
        return equipementEjecte;
    }

    private boolean isInvariantVerified() {
        return force >= 0;
    }

    public void sEquiper(Equipement equipement) {
        switch (nbEquipement) {
            case 2:
                System.out.println("Le soldat " + nom + " est deja bien protege !");
                break;
            case 1:
                if (equipements[0] == equipement) {
                    System.out.println("Le soldat " + nom + " possede deja un " + equipement + " !");
                } else {
                    ajouterEquipement(equipement);
                }
                break;
            default:
                ajouterEquipement(equipement);
                break;
        }
    }

    private void ajouterEquipement(Equipement equipement) {
        equipements[nbEquipement] = equipement;
        nbEquipement++;
        System.out.println("Le soldat " + nom + " s'equipe avec un " + equipement + ".");
    }

    public static void main(String[] args) {
        Romain minus = new Romain("Minus", 6);
        System.out.println(Equipement.CASQUE);
        System.out.println(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.CASQUE);
    }
}