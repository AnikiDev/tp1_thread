import java.awt.*;
import javax.swing.*;

class UneFenetre extends JFrame 
{
    UnMobile sonMobile;
    private final int LARG=400, HAUT=250;
    
    public UneFenetre()
    {
	// TODO 
	// ajouter sonMobile a la fenetre
        setSize(LARG,HAUT);
        Container leConteneur =getContentPane();
        sonMobile = new UnMobile(LARG,HAUT);
        leConteneur.add(sonMobile);

        Thread laTache = new Thread(sonMobile);
        setVisible(true);
        laTache.start();
	// creer une thread laThread avec sonMobile
	// afficher la fenetre
	// lancer laThread 
    }
}
