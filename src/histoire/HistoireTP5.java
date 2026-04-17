package histoire;

import personnages.Commercant;
import personnages.Ronin;
import personnages.Samourai;
import personnages.Traitre;
import personnages.Yakuza;
import personnages.GrandMere;

public class HistoireTP5 {

    public static void main(String[] args) {
        Commercant marco = new Commercant("Marco", 20);
        Commercant chonin = new Commercant("Chonin", 40);
        Commercant kumi = new Commercant("Kumi", 10);
        Yakuza yaku = new Yakuza("Yaku Le Noir", "whisky", 30, "Warsong");
        Ronin roro = new Ronin("Roro", "shochu", 60);
        
        marco.faireConnaissanceAvec(roro);
        marco.faireConnaissanceAvec(yaku);
        marco.faireConnaissanceAvec(chonin);
        marco.faireConnaissanceAvec(kumi);
        
        marco.listerConnaissance();
        roro.listerConnaissance();
        yaku.listerConnaissance();
        
        
        Samourai akimoto = new Samourai("Akimoto", "Miyamoto", "saké", 80);
        akimoto.direBonjour();
        akimoto.boire();
        akimoto.boire("thé");
        
        
        Traitre masako = new Traitre("Miyamoto" , "Masako" , "whisky" , 100);
        masako.direBonjour();
        
        
        GrandMere grandMere = new GrandMere("Grand-Mère", 10);
        grandMere.faireConnaissanceAvec(akimoto);
        grandMere.faireConnaissanceAvec(yaku);
        grandMere.faireConnaissanceAvec(masako);
        grandMere.faireConnaissanceAvec(kumi);
        grandMere.faireConnaissanceAvec(marco);
        grandMere.faireConnaissanceAvec(chonin);
        grandMere.ragoter();
    }
}