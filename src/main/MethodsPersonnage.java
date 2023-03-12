package main;

import Jauges.Jauge;

public class MethodsPersonnage extends Personnage{
    /**
     * Crée un nouveau personnage avec le nom et le genre spécifiés,
     * puis initialise les jauges de Clergé, Peuple, Armée et Finances.
     *
     * @param nom   Le nom du personnage
     * @param genre Le genre du personnage
     */
    public MethodsPersonnage(String nom, Genre genre) {
        super(nom, genre);
    }


    /**
     * Retourne le nom du personnage
     * @return le nom du personnage
     */
    public static String getNom() {
        return nom;
    }
    /**
     * Modifie le nom du personnage
     * @param nom Le nouveau nom du personnage
     */
    public void setNom(String nom) {
        Personnage.nom = nom;
    }



    /**
     * Retourne le genre du personnage
     * @return le genre du personnage
     */
    public static Genre getGenre() {
        return genre;
    }
    /**
     * Modifie le genre du personnage
     * @param genre Le nouveau genre du personnage
     */
    public void setGenre(Genre genre) {
        Personnage.genre = genre;
    }
}
