package bo.code;

public class Attaque {


    private final String[][] grillePlateauAttaque;
    private boolean run;
    private final Clique clique;

    public Attaque(String[][] grillePlateauAttaque, String[][] plateauSolutionEnnemi, Clique clique) {
        this.grillePlateauAttaque = grillePlateauAttaque;
        this.clique = clique;
    }




    public void attaqueEnnemi() {
        run = true;
        clique.setCliqueSurBouton(false);
        while ( run ) {
            System.out.print("");
            if (clique.getCliqueSurBouton()) {
                if (testIfClickIsPossible(clique.getCoordonneCliqueX(), clique.getCoordonneCliqueY())) {
                    run = false;
                } else {
                    clique.setCliqueSurBouton(false);
                }

            }
        }
    }

    public boolean testIfClickIsPossible(int attaquePosX, int attaquePosY) {
        return grillePlateauAttaque[attaquePosY][attaquePosX] == ".";  // je test si l'utilisateur a clique sur une case qui a jamais ete cliqué
    }

    public void modifApresAttaque(int attaquePosX, int attaquePosY, String[][] plateauSolutionEnnemi) {
        if ( plateauSolutionEnnemi[attaquePosY][attaquePosX] != "." ) {
            grillePlateauAttaque[attaquePosY][attaquePosX] = "B";

        } else {
            grillePlateauAttaque[attaquePosY][attaquePosX] = "W"; // il a rien touché
        }
    }
}
