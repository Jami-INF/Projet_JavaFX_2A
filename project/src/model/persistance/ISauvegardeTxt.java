package model.persistance;
import model.score;
import model.scoresParties;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ISauvegardeTxt implements IPersistanceTemps  {

    @Override
    public List chargerTemps() {
        System.out.println("CHARGEMENT DES SCORES");
        List<score> listeScores = new ArrayList<score>();
        scoresParties sc = new scoresParties(listeScores);

        String[] tab;
        InputStream flux;
        try {
            File fi =new File("scores");
            if(!fi.exists()) {
                flux = getClass().getClassLoader().getResourceAsStream("Resultats/scores");
                assert flux != null;
            }
            else {
                flux = new FileInputStream(fi);
            }
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader in = new BufferedReader(lecture);
            String ligne;
            String separateur = " ";
            while ((ligne = in.readLine()) != null) {
                tab = ligne.split(separateur);
                sc.ajouterScore(tab[0], Integer.parseInt(tab[1]));
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listeScores;
    }

    @Override
    public void sauverTemps(List<score> listeScores) {
        try {
            File fi =new File("scores");
            try (BufferedWriter out = new BufferedWriter(new FileWriter(fi))) {
                for(score sc : listeScores)
                    out.write(sc.getPseudo() + " " + sc.getTemps() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
