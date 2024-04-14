import java.util.ArrayList;

public class Utilisateur {
    private String nom;
    private int numeroIdentification;
    private ArrayList<Livre> livresEmpruntes;
    private boolean estAJourCotisation;

    // Constructeur
    public Utilisateur(String nom, int numeroIdentification) {
        this.nom = nom;
        this.numeroIdentification = numeroIdentification;
        this.livresEmpruntes = new ArrayList<>();
    }
    public boolean getCotisation() {
        return estAJourCotisation;
    }

    public void setEstAJourCotisation(boolean estAJourCotisation) {
        this.estAJourCotisation = estAJourCotisation;
    }
    // Méthode pour obtenir le nom de l'utilisateur
    public String getNom() {
        return this.nom;
    }

    // Méthode pour obtenir le numéro d'identification de l'utilisateur
    public int getNumeroIdentification() {
        return this.numeroIdentification;
    }

    
    


    // Méthode pour emprunter un livre
    public void emprunterLivre(Livre livre) {
        livresEmpruntes.add(livre);
    }

    // Méthode pour retourner un livre
    public void retournerLivre(Livre livre) {
        livresEmpruntes.remove(livre);
    }

    // Méthode pour afficher les livres empruntés par l'utilisateur
    public void afficherLivresEmpruntes() {
        System.out.println("Livres empruntés par " + nom + ":");
        for (Livre livre : livresEmpruntes) {
            System.out.println("- " + livre.getTitre());
        }
    }

    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", identifiant=" + numeroIdentification +
              
                '}';
    }
}
