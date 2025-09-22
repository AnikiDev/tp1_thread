import java.awt.*;
import javax.swing.*;

class UneFenetre extends JFrame 
{
    UnMobile sonMobile;
    UnMobile sonMobile2;
    private final int LARG=400, HAUT=250;
    
    public UneFenetre()
    {
	// TODO 
	// ajouter sonMobile a la fenetre
        setSize(LARG,HAUT);
        Container leConteneur =getContentPane();
        GridLayout grid = new GridLayout(2,1);
        leConteneur.setLayout(grid);
        sonMobile = new UnMobile(LARG,HAUT);
        leConteneur.add(sonMobile);

        sonMobile2 = new UnMobile(LARG,HAUT);
        leConteneur.add(sonMobile2);

	// creer une thread laThread avec sonMobile
        Thread laThread = new Thread(sonMobile);
        Thread laThread2 = new Thread(sonMobile2);

	// afficher la fenetre
        setVisible(true);

	// lancer laThread
        laThread.start();
        laThread2.start();


    }
}
