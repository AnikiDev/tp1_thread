import java.awt.*;
import javax.swing.*;

class UnMobile extends JPanel implements Runnable
{
    int saLargeur, saHauteur, sonDebDessin;
    final int sonPas = 10, sonTemps = 50, sonCote = 40;
    boolean versDroite = true;  // Pour savoir si on va vers la droite ou la gauche

    UnMobile(int telleLargeur, int telleHauteur)
    {
        super();
        saLargeur = telleLargeur;
        saHauteur = telleHauteur;
        setSize(telleLargeur, telleHauteur);
    }
    

    public void run() {
        while (true) {
            if (versDroite) {
                sonDebDessin += sonPas;
                if (sonDebDessin >= saLargeur - sonCote) {  // Atteint le bord droit
                    versDroite = false;
                }
            } else {
                sonDebDessin -= sonPas;
                if (sonDebDessin <= 0) {  // Atteint le bord gauche
                    versDroite = true;
                }
            }
            repaint();
            try {
                Thread.sleep(sonTemps);
            } catch (InterruptedException telleExcp) {
                telleExcp.printStackTrace();
            }
        }
    }

    public void paintComponent(Graphics telCG)
    {
        super.paintComponent(telCG);
        telCG.fillRect(sonDebDessin, saHauteur / 2, sonCote, sonCote);
    }
}
