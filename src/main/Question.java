package main;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;

/**
 * La classe Question représente une question avec ses effets sur les jauges d'un personnage
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Question {
    /**
     * nom du personnage associé à la question
     */
    protected String nomPersonnage;
    /**
     * la question
     */
    protected String question;
    /**
     * l'effet de la réponse de gauche
     */
    protected String effetGauche;
    /**
     * l'effet de la réponse de droite
     */
    protected String effetDroite;
    /**
     * les effets sur les jauges pour la réponse de gauche
     */
    protected Map<TypeJauge, Integer> effetJaugeGauche;
    /**
     * les effets sur les jauges pour la réponse de droite
     */
    protected Map<TypeJauge, Integer> effetJaugeDroite;

    /**
     * Construit une nouvelle question avec les informations données
     *
     * @param nomPersonnage Le nom du personnage associé à la question
     * @param question La question à poser
     * @param effetGauche L'effet de la réponse de gauche
     * @param effetDroite L'effet de la réponse de droite
     */
    public Question(String nomPersonnage,
                    String question,
                    String effetGauche,
                    String effetDroite) {
        this.nomPersonnage = nomPersonnage;
        this.question = question;
        this.effetGauche = effetGauche;
        this.effetDroite = effetDroite;
        this.effetJaugeDroite = new TreeMap<>();
        this.effetJaugeGauche = new TreeMap<>();
    }

    /**
     * Affiche la question avec les effets associés aux choix gauche et droit.
     */
    public void afficheQuestion() {
        String result = "["+nomPersonnage+"] "
                + question
                + "[G: "+effetGauche
                + ",D: "+effetDroite
                + "]";
        System.out.println(result);
        System.out.println("Effet G:"+afficheEffets(effetJaugeGauche));
        System.out.println("Effet D:"+afficheEffets(effetJaugeDroite));
        System.out.flush();
    }

    /**
     * Retourne une chaîne de caractères représentant les effets d'une jauge.
     *
     * @param effets La map des effets de jauge
     * @return la chaîne de caractères représentant les effets de la jauge
     */
    private String afficheEffets(Map<TypeJauge, Integer> effets) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<TypeJauge, Integer> effet : effets.entrySet()) {
            result.append("; jauge ").append(effet.getKey()).append(":");
            if (effet.getValue() > 0) {
                result.append("+");
            }
            result.append(effet.getValue());
        }
        return result.toString();
    }

    /**
     * Applique les effets associés au choix gauche sur un personnage donné.
     *
     */
    public void appliqueEffetsGauche(){
        this.appliqueEffets(effetJaugeGauche);
    }

    /**
     * Applique les effets associés au choix droit sur un personnage donné.
     *
     */
    public void appliqueEffetsDroite(){
        this.appliqueEffets(effetJaugeDroite);
    }

    public static HashMap<TypeJauge, Consumer<Integer>> effetMap = new HashMap<>();

    /**
     * Applique les effets d'une jauge sur un personnage donné.
     *
     * @param effets     les effets de jauge à appliquer
     */
    private void appliqueEffets(Map<TypeJauge,Integer> effets){
        for(TypeJauge typeJauge : effets.keySet()){
            MethodsPersonnage.getJauge(typeJauge).setValeur(MethodsPersonnage.getJauge(typeJauge).getValeur() + effets.get(typeJauge));
        }
    }

    /**
     * Ajoute un effet à la jauge associée au choix gauche.
     *
     * @param jauge la jauge à laquelle l'effet doit être ajouté
     * @param valeur la valeur de l'effet à ajouter
     */
    public void ajouteEffetGauche(TypeJauge jauge,
                                  int valeur){
        effetJaugeGauche.put(jauge,valeur);
    }

    /**
     * Ajoute un effet à la jauge associée au choix droit.
     *
     * @param jauge la jauge à laquelle l'effet doit être ajouté
     * @param valeur la valeur de l'effet à ajouter
     */
    public void ajouteEffetDroite(TypeJauge jauge,
                                  int valeur){
        effetJaugeDroite.put(jauge,valeur);
    }

    /**
     * Retourne le nom du personnage associé à la question.
     *
     * @return le nom du personnage associé à la question
     */
    public String getNomPersonnage() {
        return nomPersonnage;
    }

    /**
     * Modifie le nom du personnage associé à la question.
     *
     * @param nomPersonnage le nouveau nom du personnage associé à la question
     */
    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }

    /**
     * Retourne la question.
     *
     * @return la question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Modifie la question.
     *
     * @param question la nouvelle question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Retourne l'effet gauche de la question.
     *
     * @return l'effet gauche de la question.
     */
    public String getEffetGauche() {
        return effetGauche;
    }

    /**
     * Modifie l'effet gauche de la question.
     *
     * @param effetGauche le nouvel effet gauche de la question
     */
    public void setEffetGauche(String effetGauche) {
        this.effetGauche = effetGauche;
    }

    /**
     * Retourne l'effet droit de la question.
     *
     * @return l'effet droit de la question.
     */
    public String getEffetDroite() {
        return effetDroite;
    }

    /**
     * Modifie l'effet droit de la question.
     *
     * @param effetDroite le nouvel effet droit de la question
     */
    public void setEffetDroite(String effetDroite) {
        this.effetDroite = effetDroite;
    }

}
