package main;

import Jauges.TypeJauge;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * La classe Reigns représente le programme principal du jeu Reigns
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Initiator {

    /**
     * le personnage joué
     */

    protected static Personnage personnage;

    /**
     * la banque de questions
     */
    private static ArrayList<Question> questions;

    /**
     * Cette fonction permet d'initialiser le personnage joué. Elle demande à l'utilisateur de saisir le nom du personnage
     * et le genre (Roi ou Reine). Elle crée ensuite le personnage.
     */

    static void  initPersonnage(){
        // choix du nom du personnage
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du personnage: ");
        System.out.flush();
        String nom = scanner.nextLine();

        // choix du genre du personnage
        String genre = "";
        Genre roiReine;
        while(!genre.equals("1") && !genre.equals("2")){
            System.out.println("Faut-il vous appeler Roi ou Reine ? (1 pour Roi, 2 pour Reine)");
            System.out.flush();
            genre = scanner.nextLine();
        }

        if(genre.equals("1")){
            roiReine = Genre.ROI;
            System.out.println("Long règne au Rois " + nom);
        }else{
            roiReine = Genre.REINE;
            System.out.println("Long règne à la Reine " + nom);
        }

        Initiator.personnage = new Personnage(nom,roiReine);
    }

    /**
     * Cette fonction initialise la banque de questions. Elle crée les questions et les ajoute à la banque.
     */
    static void initBanqueQuestions(){
        questions = new ArrayList<>();
        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",
                "Oui",
                "Non");
        question1.addEffect(TypeJauge.ARMEE, -5);
        question1.addEffect(TypeJauge.PEUPLE, +5);
        question1.addEffect(TypeJauge.PEUPLE, -7);
        questions.add(question1);
        Question question2 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                "Importer de la nourriture",
                "Ne rien faire");
        question2.addEffect(TypeJauge.FINANCE,-5);
        question2.addEffect(TypeJauge.PEUPLE, +5);
        question2.addEffect(TypeJauge.PEUPLE, -5);
        questions.add(question2);
        Question question3 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                "Faire un sacrifice",
                "Ne rien faire");
        question3.addEffect(TypeJauge.CLERGE, +5);
        question3.addEffect(TypeJauge.PEUPLE, -3);
        question3.addEffect(TypeJauge.CLERGE, -5);
        questions.add(question3);
        Question question4 = new Question(
                "Main du roi",
                "Le roi Baratheon rassemble son armée",
                "Le soutenir",
                "Rester neutre");
        question4.addEffect(TypeJauge.ARMEE, +3);
        question4.addEffect(TypeJauge.FINANCE, -3);
        question4.addEffect(TypeJauge.CLERGE, -3);
        question4.addEffect(TypeJauge.PEUPLE, +3);
        questions.add(question4);
        Question question5 = new Question(
                "Paysan",
                "Abondance de récoltes cette année",
                "Taxer énormément",
                "Taxer un tout petit peu");
        question5.addEffect(TypeJauge.FINANCE, +10);
        question5.addEffect(TypeJauge.PEUPLE, -5);
        question5.addEffect(TypeJauge.FINANCE, +1);
        question5.addEffect(TypeJauge.PEUPLE, -3);
        questions.add(question5);
    }

    /**
     * Cette fonction permet de tirer une question aléatoire dans la banque de questions.
     * @return Une question aléatoire
     */
    static Question getQuestionAleatoire(){
        int numQuestion = (int) (Math.random()*questions.size());
        return questions.get(numQuestion);
    }

    /**
     * Cette fonction permet de gérer la réponse à une question donnée. Elle affiche la question, demande à
     * l'utilisateur d'entrer une réponse (soit "G" soit "D") et en fonction de la réponse, elle appelle la méthode
     * appropriée pour appliquer les conséquences sur les jauges du personnage.
     * @param question La question à laquelle il faut répondre
     */
    static void reponseQuestion(Question question){
        question.afficheQuestion();
        // récupère la réponse
        Scanner scanner = new Scanner(System.in);
        String reponse = "";
        while(!reponse.equals("G") && !reponse.equals("D")){
            System.out.println("Entrez la réponse (G ou D)");
            System.out.flush();
            reponse = scanner.nextLine();
        }
        // applique les malus
        if(reponse.equals("G")){
            question.appliqueEffets(personnage);
        }else{
            question.appliqueEffets(personnage);
        }
    }
}
