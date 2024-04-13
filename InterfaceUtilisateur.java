import java.util.List;

public interface InterfaceUtilisateur {
    void afficherMenuPrincipal();
    void afficherMenuGestionLivres();
    void afficherMenuGestionEmprunts();

    void afficherLivres(List<Livre> livres);
    void afficherLivresEmpruntes(Utilisateur utilisateur, List<Livre> livres);

    String saisirString(String message);
    int saisirEntier(String message);
    Utilisateur saisirInformationsUtilisateur();
}
