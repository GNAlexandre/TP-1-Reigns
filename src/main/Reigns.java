package main;

/**
 * La classe Reigns représente le programme principal du jeu Reigns
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Reigns {
    /**
     * le personnage joué
     */
    public static Personnage personnage;


    /**
     * La méthode main lance le jeu Reigns. Il initialise les questions, le personnage,
     * affiche les jauges du personnage et lance une boucle de jeu qui se termine lorsque le personnage perd.
     * Il affiche également le nombre de tours de jeu que le personnage a joué.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args){
        MethodsInitialisationGame.initGame();
        int nbTours = MethodsInitialisationGame.Game();

        // fin du jeu
        System.out.println(MethodsPersonnage.getNom() + " a perdu ! Son règne a duré " + nbTours + " tours");


    }
}