public class Admin {

    private String email;
    private String passe;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPasse() {
        return passe;
    }
    public void setPasse(String passe) {
        this.passe = passe;
    }
    public Admin(String email, String passe) {
        this.email = email;
        this.passe = passe;
    }


    
    
}
