package bo.afichage;

import bo.code.Clique;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class affichage extends JFrame {

    private int nbCaseX;
    private int nbCaseY;
    private Clique clique;


    public affichage(int nbCaseX, int nbCaseY, int HEIGHT, int WIDTH, String titleName, Clique clique, int[] possitionWindows) {
        // variable/constante:
        this.nbCaseX = nbCaseX;
        this.nbCaseY = nbCaseY;
        this.clique = clique;



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(possitionWindows[0], possitionWindows[1]);
        this.setTitle(titleName);

    }

    public void afficheMap(String[][] plateauSolution, String[][] grillePlateauAttaque) {


        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout( new GridLayout(1, 2) ); // je divise l'ecran en deux

        JPanel screenGauche = new JPanel();
        screenGauche.setLayout( new GridLayout(10, 10));
        contentPane.add(screenGauche);

        JPanel screenDroite = new JPanel();
        screenDroite.setLayout( new GridLayout(10, 10));

        contentPane.add(screenDroite);


        screenGauche.setBorder(BorderFactory.createTitledBorder(null, "Bateaux ennemis", TitledBorder.CENTER,TitledBorder.DEFAULT_JUSTIFICATION));
        screenDroite.setBorder(BorderFactory.createTitledBorder(null, "Vos bateaux", TitledBorder.CENTER,TitledBorder.DEFAULT_JUSTIFICATION));


        // pour le cote gauche de le fenetre:
        for (int y = 0; y < nbCaseY; y++) {
            for (int x = 0; x < nbCaseX; x++) {
                JButton button = new JButton(x+""+y);
                if (grillePlateauAttaque[y][x] == "B") {
                    button.setBackground(Color.RED);

                } else if (grillePlateauAttaque[y][x] == "M") {
                    button.setBackground(Color.BLUE);
                } else {
                    button.setBackground(Color.GRAY);

                }

                button.addActionListener(clique);
                screenGauche.add(button);
            }
        }

        // pour le code droit de la fenetre:
        for (int y = 0; y < nbCaseY; y++) {
            for (int x = 0; x < nbCaseX; x++) {
                JButton button = new JButton(x+""+y);

                if (plateauSolution[y][x] == "B") {
                    button.setBackground(Color.BLACK);

                } else  {
                    button.setBackground(Color.BLUE);
                }

                button.addActionListener(clique);
                screenDroite.add(button);
            }
        }
        setVisible(true);

    }

    public void afficheModifMap(JButton boutonModif, int attaquePosX, int attaquePosY, String[][] plateauSolutionEnnemi) {
        if (plateauSolutionEnnemi[attaquePosY][attaquePosX] == "B") {
            boutonModif.setBackground(Color.RED);
        } else {
            boutonModif.setBackground(Color.BLUE);
        }
    }

    public void afficheFinGame(String texteFinGameJoueur) {

        // affiche si il a gagné ou perdu:
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JLabel label = new JLabel(texteFinGameJoueur);
        label.setFont(new Font("Verdana", Font.BOLD, 20));

        // affiche texte au centre
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(label, gbc);
        add(panel);


        setVisible(true);



    }

}
