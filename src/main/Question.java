package main;

import Jauges.TypeJauge;

import java.util.HashMap;
import java.util.Map;

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
    protected Map<TypeJauge, Integer> effects;


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
        this.effects = new HashMap<>();
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
        System.out.println("Effets appliqué:"+ afficheEffets(effects));
//      System.out.println("Effet G:"+afficheEffets(effetJaugeGauche));
//      System.out.println("Effet D:"+afficheEffets(effetJaugeDroite));
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
     * Applique les effets d'une jauge sur un personnage donné.
     */
    protected void appliqueEffets(Personnage personnage){
        for(Map.Entry<TypeJauge, Integer> effect : effects.entrySet()){
            for(Map.Entry<TypeJauge, Integer> gauge : personnage.jauges.entrySet()){
                if(effect.getKey() == gauge.getKey()){
                    gauge.setValue(gauge.getValue() + effect.getValue());
                }
            }
        }
    }

    public void addEffect(TypeJauge gauge, int value){
        effects.put(gauge, value);
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
