package main;


import Jauges.MethodsJauge;

public class Main extends Initiator {

    /**
     * La méthode main lance le jeu Reigns. Il initialise les questions, le personnage,
     * affiche les jauges du personnage et lance une boucle de jeu qui se termine lorsque le personnage perd.
     * Il affiche également le nombre de tours de jeu que le personnage a joué.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args){

        System.out.println("Bienvenue sur Reigns");
        initBanqueQuestions();
        System.out.println("Création du personnage...");
        initPersonnage();
        System.out.println(MethodsPersonnage.getGenre() +" "+MethodsPersonnage.getNom());
        MethodsJauge.AfficheJauges(personnage.jauges);

        // tirage des questions
        int nbTours = 0;
        while(!MethodsJauge.finDuJeu(personnage.jauges)){
            nbTours++;
            Question question = getQuestionAleatoire();
            reponseQuestion(question);
            MethodsJauge.AfficheJauges(personnage.jauges);
        }

        // fin du jeu
        System.out.println(MethodsPersonnage.getNom() + " a perdu ! Son règne a duré " + nbTours + " tours");
    }
}