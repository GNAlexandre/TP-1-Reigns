package main;

import java.util.ArrayList;
import java.util.Scanner;

public class MethodsQuestion{
    /**
     * la banque de questions
     */
    public static ArrayList<Question> questions;


    /**
     * Cette fonction initialise la banque de questions. Elle crée les questions et les ajoute à la banque.
     */
    public static void initBanqueQuestions(){
        questions = new ArrayList<>();
        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",
                "Oui",
                "Non");
        question1.ajouteEffetGauche(TypeJauge.ARMEE, -5);
        question1.ajouteEffetGauche(TypeJauge.PEUPLE, +5);
        question1.ajouteEffetDroite(TypeJauge.PEUPLE, -7);
        questions.add(question1);



        Question question2 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                "Importer de la nourriture",
                "Ne rien faire");
        question2.ajouteEffetGauche(TypeJauge.FINANCE,-5);
        question2.ajouteEffetGauche(TypeJauge.PEUPLE, +5);
        question2.ajouteEffetDroite(TypeJauge.PEUPLE, -5);
        questions.add(question2);



        Question question3 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                "Faire un sacrifice",
                "Ne rien faire");
        question3.ajouteEffetGauche(TypeJauge.CLERGE, +5);
        question3.ajouteEffetGauche(TypeJauge.PEUPLE, -3);
        question3.ajouteEffetDroite(TypeJauge.CLERGE, -5);
        questions.add(question3);



        Question question4 = new Question(
                "Main du roi",
                "Le roi Baratheon rassemble son armée",
                "Le soutenir",
                "Rester neutre");
        question4.ajouteEffetGauche(TypeJauge.ARMEE, +3);
        question4.ajouteEffetGauche(TypeJauge.FINANCE, -3);
        question4.ajouteEffetGauche(TypeJauge.CLERGE, -3);
        question4.ajouteEffetDroite(TypeJauge.PEUPLE, +3);
        questions.add(question4);



        Question question5 = new Question(
                "Paysan",
                "Abondance de récoltes cette année",
                "Taxer énormément",
                "Taxer un tout petit peu");
        question5.ajouteEffetGauche(TypeJauge.FINANCE, +10);
        question5.ajouteEffetGauche(TypeJauge.PEUPLE, -5);
        question5.ajouteEffetDroite(TypeJauge.FINANCE, +1);
        question5.ajouteEffetDroite(TypeJauge.PEUPLE, -3);
        questions.add(question5);

    }


    public static void CreateNewQuestion(String NomPersonnage, String Question, String effetGauche, String effetDroite,
                                         int effet_G_Finance, int effet_G_Peuple, int effet_G_Clerge, int effet_G_Armee,
                                         int effet_D_Finance, int effet_D_Peuple, int effet_D_Clerge, int effet_D_Armee){

        Question MyQuestion = new Question(
                NomPersonnage,
                Question,
                effetGauche,
                effetDroite);

        MyQuestion.ajouteEffetGauche(TypeJauge.FINANCE, effet_G_Finance);
        MyQuestion.ajouteEffetGauche(TypeJauge.PEUPLE, effet_G_Peuple);
        MyQuestion.ajouteEffetGauche(TypeJauge.CLERGE, effet_G_Clerge);
        MyQuestion.ajouteEffetGauche(TypeJauge.ARMEE, effet_G_Armee);

        MyQuestion.ajouteEffetDroite(TypeJauge.FINANCE,effet_D_Finance);
        MyQuestion.ajouteEffetDroite(TypeJauge.PEUPLE,effet_D_Peuple);
        MyQuestion.ajouteEffetDroite(TypeJauge.CLERGE,effet_D_Clerge);
        MyQuestion.ajouteEffetDroite(TypeJauge.ARMEE,effet_D_Armee);


        MethodsQuestion.questions.add(MyQuestion);

    }


    /**
     * Cette fonction permet de tirer une question aléatoire dans la banque de questions.
     * @return Une question aléatoire
     */
    public static Question getQuestionAleatoire(){
        int numQuestion = (int) (Math.random()*MethodsQuestion.questions.size());
        return MethodsQuestion.questions.get(numQuestion);
    }



    /**
     * Cette fonction permet de gérer la réponse à une question donnée. Elle affiche la question, demande à
     * l'utilisateur d'entrer une réponse (soit "G" soit "D") et en fonction de la réponse, elle appelle la méthode
     * appropriée pour appliquer les conséquences sur les jauges du personnage.
     * @param question La question à laquelle il faut répondre
     */
    public static void reponseQuestion(Question question){
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
            question.appliqueEffetsGauche(Reigns.personnage);
        }else{
            question.appliqueEffetsDroite(Reigns.personnage);
        }
    }
}
