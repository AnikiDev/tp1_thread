import javax.swing.*;
import java.awt.*;

public class UneFenetre extends JFrame {
    private final int LARG = 400, HAUT = 250;
    int qtMobile = 5;  // Nombre d'éléments mobile à afficher

    public UneFenetre() {
        // Initialisation de la fenêtre
        setSize(LARG, HAUT);
        Container leConteneur = getContentPane();
        GridLayout grid = new GridLayout(qtMobile, 1);  // 5 lignes, 1 colonne
        UnMobile[] sonMobileN = new UnMobile[qtMobile];  // Déclaration avec qtMobile
        leConteneur.setLayout(grid);

        Thread[] laThread = new Thread[qtMobile];  // Un thread pour chaque mobile

        // Création des UnMobile et de leurs threads
        for (int i = 0; i < qtMobile; i++) {  // On commence à 0 et on va jusqu'à qtMobile - 1
            sonMobileN[i] = new UnMobile(LARG, HAUT/qtMobile);  // Crée un mobile avec la taille de la fenêtre
            leConteneur.add(sonMobileN[i]);  // Ajouter le mobile au conteneur
            laThread[i] = new Thread(sonMobileN[i]);  // Créer un thread pour chaque mobile
            laThread[i].start();  // Démarrer le thread
        }

        setVisible(true);  // Afficher la fenêtre après avoir ajouté les composants
    }
}