package main;

import java.util.Scanner;

public class MethodsInitialisationGame{


    /**
     * Cette fonction permet d'initialiser le personnage joué. Elle demande à l'utilisateur de saisir le nom du personnage
     * et le genre (Roi ou Reine). Elle crée ensuite le personnage.
     */

    public static void initPersonnage(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Entrez le nom du personnage: ");
            System.out.flush();
            String nom = scanner.nextLine();
            System.out.println(
                    "Faut-il vous appeler Roi ou Reine ? (1 pour Roi, 2 pour Reine)");
            int genre = scanner.nextInt();
            Genre roiReine;
            if(genre==1){
                roiReine = Genre.ROI;
            }else{
                roiReine = Genre.REINE;
            }

            Reigns.personnage = new Personnage(nom,roiReine);
        }
    }

    public static void initGame(){
        // début du jeu
        System.out.println("Bienvenue sur Reigns");
        MethodsQuestion.initBanqueQuestions();
        System.out.println("Création du personnage...");
        MethodsInitialisationGame.initPersonnage();
        System.out.println(MethodsPersonnage.getGenre().longRegne() +" "+MethodsPersonnage.getNom());
        MethodsJauge.AfficheJauges();

    }

    public static int Game(){
        // tirage des questions
        int nbTours = 0;
        while(!MethodsJauge.finDuJeu()){
            nbTours++;
            Question question = MethodsQuestion.getQuestionAleatoire();
            MethodsQuestion.reponseQuestion(question);
            MethodsJauge.AfficheJauges();
        }
        return nbTours;
    }

    public static void Restart(){

    }
}
