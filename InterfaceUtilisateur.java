import java.util.List;

public interface InterfaceUtilisateur {
    void afficherMenuPrincipal();
    void afficherMenuGestionLivres();
    void afficherMenuGestionEmprunts();
    void afficherMenuGestionUtilisateurs();
    void afficherUtilisateurs(List<Utilisateur> utilisateurs);
    void afficherLivres(List<Livre> livres);
    void afficherLivresEmpruntes(Utilisateur utilisateur, List<Livre> livres);
    boolean saisirBoolean(String message);

    String saisirString(String message);
    int saisirEntier(String message);
    Utilisateur saisirInformationsUtilisateur();
}
