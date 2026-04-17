package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;
import village_gaulois.Musee;
import objets.Equipement;

public class Scenario {

    public static void main(String[] args) {
        // Création des personnages
        Druide panoramix = new Druide("Panoramix", 2);
        Gaulois asterix = new Gaulois("Asterix", 8);
        Gaulois obelix = new Gaulois("Obélix", 50);
        Romain minus = new Romain("Minus", 6);
        // 👇 AJOUTE CES 2 LIGNES POUR MINUS
        minus.sEquiper(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.CASQUE);
        
        Romain brutus = new Romain("Brutus", 14);
        // 👇 AJOUTE CES 2 LIGNES POUR BRUTUS
        brutus.sEquiper(Equipement.CASQUE);
        brutus.sEquiper(Equipement.CASQUE);
        
        // Dialogue
        asterix.parler("Bonjour Obélix.");
        obelix.parler("Bonjour Astérix. Ca te dirais d'aller chasser des sangliers ?)");
        asterix.parler("Oui très bonne idée.");
        
        System.out.println("Dans la forêt Astérix et Obélix tombent nez à nez sur le romain " + minus.getNom() + ".");
        
        
        obelix.frapper(minus);
        obelix.frapper(minus);
        obelix.frapper(minus);
        
        // Potion
        panoramix.fabriquerPotion(4, 3);
        panoramix.booster(obelix);
        panoramix.booster(asterix);
        
        // Combat contre Brutus (par Obélix)
        obelix.frapper(brutus);
        obelix.frapper(brutus);
        obelix.frapper(brutus);
        
        // PARTIE MUSEE
        System.out.println("\nPARTIE MUSEE");
        
        // Afficher les trophées d'Obélix
        obelix.afficherTrophees();
        
        // Créer le musée
        Musee musee = new Musee();
        
        // Obélix fait une donation
        obelix.faireUneDonnation(musee);
        
        // Afficher les trophées du musée
        musee.afficherTrophees();
        
        // Générer et afficher le code OCaml
        System.out.println("\nCODE OCAML GÉNÉRÉ");
        System.out.println(musee.extraireInstructionsOCaml());
    }
}