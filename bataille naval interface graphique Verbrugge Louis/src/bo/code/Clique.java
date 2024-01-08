

package bo.code;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class Clique implements ActionListener {

    private boolean cliqueSurBouton;
    private int[] listeCoordonneClique;
    private JButton boutonModif;

    public Clique() {
        this.cliqueSurBouton = false;
        this.boutonModif = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton temp = (JButton)(e.getSource());
        // je cherche a convertir le String du nom du bouton, en liste exemple "00"  en  {0, 0}
        listeCoordonneClique = new int[2];
        String a = temp.getText();
        char coordonneCliqueX = a.charAt(0);
        char coordonneCliqueY = a.charAt(1);

        // -48 pour passer du code ascci en integer:
        listeCoordonneClique[0] = (Integer.valueOf(coordonneCliqueX))-48;
        listeCoordonneClique[1] = (Integer.valueOf(coordonneCliqueY))-48;

        boutonModif = temp;
        cliqueSurBouton = true;
    }


    public boolean getCliqueSurBouton() {
        return cliqueSurBouton;
    }

    public void setCliqueSurBouton(boolean newCliqueSurBouton) {
        cliqueSurBouton = newCliqueSurBouton;
    }

    public int getCoordonneCliqueX() {
        return listeCoordonneClique[0];
    }

    public int getCoordonneCliqueY() {
        return listeCoordonneClique[1];
    }

    public JButton getBoutonModif() {
        return boutonModif;
    }

}
