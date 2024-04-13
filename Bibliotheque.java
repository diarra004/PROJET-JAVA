import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.Serializable;
import java.io.*;


public class Bibliotheque implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<Livre> listeLivres;
    private HashMap<Utilisateur, ArrayList<Livre>> empruntsUtilisateurs;

    public List<Livre> getLivres() {
        return new ArrayList<>(listeLivres); // Retourne une copie de listeLivres pour ne pas exposer l'implémentation interne
    }

    public Bibliotheque() {
        this.listeLivres = new ArrayList<>();
        this.empruntsUtilisateurs = new HashMap<>();
    }

    public void ajouterLivre(Livre livre) {
        listeLivres.add(livre);
    }

    public void supprimerLivre(Livre livre) {
        listeLivres.remove(livre);
    }

    public ArrayList<Livre> rechercherLivres(String critere) {
        ArrayList<Livre> resultats = new ArrayList<>();
        for (Livre livre : listeLivres) {
            if (livre.getTitre().contains(critere) ||
                livre.getAuteur().contains(critere) ||
                livre.getIsbn().contains(critere)) {
                resultats.add(livre);
            }
        }
        return resultats;
    }

    public void enregistrerEmprunt(Utilisateur utilisateur, Livre livre) {
        if (!empruntsUtilisateurs.containsKey(utilisateur)) {
            empruntsUtilisateurs.put(utilisateur, new ArrayList<>());
        }
        empruntsUtilisateurs.get(utilisateur).add(livre);
    }

    public void enregistrerRetour(Utilisateur utilisateur, Livre livre) {
        if (empruntsUtilisateurs.containsKey(utilisateur)) {
            empruntsUtilisateurs.get(utilisateur).remove(livre);
        }
    }

    public boolean verifierEligibilite(Utilisateur utilisateur) {
        // Implémentez vos règles d'éligibilité ici
        return true; // Exemple simplifié pour toujours autoriser l'emprunt
    }

    public void afficherStatistiques() {
        int totalLivres = listeLivres.size();
        int livresEmpruntes = 0;
        for (ArrayList<Livre> emprunts : empruntsUtilisateurs.values()) {
            livresEmpruntes += emprunts.size();
        }

        System.out.println("Statistiques de la bibliothèque :");
        System.out.println("Nombre total de livres : " + totalLivres);
        System.out.println("Nombre d'exemplaires empruntés : " + livresEmpruntes);
        // Ajoutez d'autres statistiques selon vos besoins
    }
    public void sauvegarderBibliotheque(String nomFichier) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomFichier))) {
            out.writeObject(this);
            System.out.println("Bibliothèque sauvegardée avec succès dans " + nomFichier);
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde de la bibliothèque : " + e.getMessage());
        }
    }

    public static Bibliotheque chargerBibliotheque(String nomFichier) {
        Bibliotheque bibliotheque = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomFichier))) {
            bibliotheque = (Bibliotheque) in.readObject();
            System.out.println("Bibliothèque chargée avec succès depuis " + nomFichier);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement de la bibliothèque : " + e.getMessage());
        }
        return bibliotheque;
    }


}
