import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.Serializable;
import java.io.*;



public class Bibliotheque implements Serializable {

    private List<Utilisateur> utilisateurs;
    
    private static final long serialVersionUID = 1L;

    private ArrayList<Livre> listeLivres;
    private HashMap<Utilisateur, ArrayList<Livre>> empruntsUtilisateurs;

    public List<Livre> getLivres() {
        return new ArrayList<>(listeLivres); // Retourne une copie de listeLivres pour ne pas exposer l'implémentation interne
    }

    public Bibliotheque() {
        this.listeLivres = new ArrayList<>();
        this.empruntsUtilisateurs = new HashMap<>();
        this.utilisateurs = new ArrayList<>();
    }
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateurs.add(utilisateur);
    }
    public boolean supprimerUtilisateur(int identifiant) {
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getNumeroIdentification() == identifiant) {
                utilisateurs.remove(utilisateur);
                return true;
            }
        }
        return false;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
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
            if (livre.getTitre().toLowerCase().contains(critere)
            || livre.getAuteur().toLowerCase().contains(critere)
            || livre.getIsbn().toLowerCase().contains(critere)) {
                resultats.add(livre);
        }}
        return resultats;
    }
    public Utilisateur chercherUtilisateur(int id) {
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getNumeroIdentification()==id) {
                 return utilisateur;
            }
        }
        return null;
    }
    public void enregistrerEmprunt(Utilisateur utilisateur, Livre livre) {
        
        if(utilisateur.getCotisation()){
            if (!empruntsUtilisateurs.containsKey(utilisateur)) {
                empruntsUtilisateurs.put(utilisateur, new ArrayList<>());
            }
    
            empruntsUtilisateurs.get(utilisateur).add(livre);
        }
    }

    public void enregistrerRetour(Utilisateur utilisateur, Livre livre) {
        if (empruntsUtilisateurs.containsKey(utilisateur)) {
            empruntsUtilisateurs.get(utilisateur).remove(livre);
        }
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
    public Livre chercherLivre(String s){
        for (Livre livre : listeLivres) {
            if (livre.getIsbn().equals(s)) {
                return livre;
            }
        }
        return null;
    }
    public void modifierLivre(Livre livreAModifier, InterfaceUtilisateur interfaceUtilisateur) {
        System.out.println("Livre à modifier : " + livreAModifier);
    
        // Afficher les options de modification
        System.out.println("Quel attribut souhaitez-vous modifier ?");
        System.out.println("1. Titre");
        System.out.println("2. Auteur");
        System.out.println("3. Année de publication");
        System.out.println("4. ISBN");
        System.out.println("5. Retour au menu");
    
        int choix = interfaceUtilisateur.saisirEntier("Choix");
    
        switch (choix) {
            case 1:

                String nouveauTitre = interfaceUtilisateur.saisirString("Nouveau titre du livre ");
                interfaceUtilisateur.saisirString("");
                livreAModifier.setTitre(nouveauTitre);
                break;
            case 2:
                String nouvelAuteur = interfaceUtilisateur.saisirString("Nouvel auteur du livre :");
               
                interfaceUtilisateur.saisirString("");
                livreAModifier.setAuteur(nouvelAuteur);
                break;
            case 3:
            
               
                int nouvelleAnnee = interfaceUtilisateur.saisirEntier("Nouvelle année de publication du livre :");
                interfaceUtilisateur.saisirString("");
                
                livreAModifier.setAnneePublication(nouvelleAnnee);
                break;
            case 4:
               
                String nouveauISBN = interfaceUtilisateur.saisirString("Nouvel ISBN du livre :");
                interfaceUtilisateur.saisirString("");
               
                livreAModifier.setIsbn(nouveauISBN);
                break;
            case 5:
                System.out.println("Retour au menu principal.");
                return;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
                break;
        }
    
        System.out.println("Livre modifié avec succès : " + livreAModifier);
    }

    
    
    public void afficherEmprunts() {
        for (Map.Entry<Utilisateur, ArrayList<Livre>> entry : empruntsUtilisateurs.entrySet()) {
            Utilisateur utilisateur = entry.getKey();
            ArrayList<Livre> emprunts = entry.getValue();
    
            System.out.println("Utilisateur: " + utilisateur.getNom());
            System.out.println("Emprunts:");
    
            for (Livre livre : emprunts) {
                System.out.println("- " + livre.getTitre());
            }
        }
    }

}


