package main;

import java.util.ArrayList;

public class MethodsJauge extends Personnage{

    /**
     * Crée un nouveau personnage avec le nom et le genre spécifiés,
     * puis initialise les jauges de Clergé, Peuple, Armée et Finances.
     *
     * @param nom   Le nom du personnage
     * @param genre Le genre du personnage
     */




    public MethodsJauge(String nom, Genre genre) {
        super(nom, genre);
    }

    /**
     * Affiche une jauge avec un format graphique, en utilisant des "#" pour représenter la valeur de la jauge
     * et des "_" pour représenter la valeur manquante.
     *
     * @param jauge La jauge à afficher
     */

    public static void afficheJauge(Jauge jauge) {
        String resultat = "[";
        // valeur : ####
        for(int i=0;i<jauge.getValeur();i++){
            resultat += "#";
        }
        // on complète avec ____
        for(int i=0;i<50-(jauge.getValeur()>0?jauge.getValeur():0);i++){
            resultat += "_";
        }
        resultat += "] ";
        // affichage du nom
        resultat += jauge.getNom();
        System.out.println(resultat);
    }



    /**
     * Affiche les jauges de Clergé, Peuple, Armée et Finances du personnage.
     */
    public static void AfficheJauges() {
        for (Jauge Element:ListeJauge) {
            MethodsJauge.afficheJauge(Element);
        }
        System.out.println();
    }



    /**
     * Vérifie si le jeu est fini en vérifiant si une des jauges est à 0 ou 50.
     *
     * @return true si le jeu est fini, false sinon
     */
    public static boolean finDuJeu(){
        for (Jauge Element:ListeJauge) {
            if(Element.getValeur()<=0 || Element.getValeur()>=50){
                return true;
            }
        }
        return false;
    }
}
