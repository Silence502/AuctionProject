package fr.eni.encheres.bo;

public class Utilisateur {
    private Integer noUtilisateur;
    private String pseudo;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String rue;
    private Integer codePostal;
    private String ville;
    private String motDePasse;
    private Integer credit;
    private boolean administrateur;
    /**
     * Constructeur par défaut
     */
    public Utilisateur() {
    }
    /**
     * @param noUtilisateur
     * @param pseudo
     * @param nom
     * @param prenom
     * @param email
     * @param telephone
     * @param rue
     * @param codePostal
     * @param ville
     * @param motDePasse
     * @param credit
     * Constructeur complet pour un utilisateur non administrateur
     */
    public Utilisateur(Integer noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
	    String rue, Integer codePostal, String ville, String motDePasse, Integer credit) {
	this.noUtilisateur = noUtilisateur;
	this.pseudo = pseudo;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.telephone = telephone;
	this.rue = rue;
	this.codePostal = codePostal;
	this.ville = ville;
	this.motDePasse = motDePasse;
	this.credit = credit;
    }
    /**
     * @param noUtilisateur
     * @param pseudo
     * @param nom
     * @param prenom
     * @param email
     * @param telephone
     * @param rue
     * @param codePostal
     * @param ville
     * @param motDePasse
     * @param credit
     * @param administrateur
     * Constructeur complet pour un utilisateur administrateur
     */
    public Utilisateur(Integer noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
	    String rue, Integer codePostal, String ville, String motDePasse, Integer credit, boolean administrateur) {
	this.noUtilisateur = noUtilisateur;
	this.pseudo = pseudo;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.telephone = telephone;
	this.rue = rue;
	this.codePostal = codePostal;
	this.ville = ville;
	this.motDePasse = motDePasse;
	this.credit = credit;
	this.administrateur = administrateur;
    }
    /**
     * Getter de noUtilisateur
     * @return noUtilisateur
     */
    public Integer getNoUtilisateur() {
        return noUtilisateur;
    }
    /**
     * Setter de noUtilisateur
     * @param noUtilisateur étant noUtilisateur à paramétrer de type String
     */
    public void setNoUtilisateur(Integer noUtilisateur) {
        this.noUtilisateur = noUtilisateur;
    }
    /**
     * Getter de pseudo
     * @return pseudo
     */
    public String getPseudo() {
        return pseudo;
    }
    /**
     * Setter de pseudo
     * @param pseudo étant pseudo à paramétrer de type String
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    /**
     * Getter de nom
     * @return nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * Setter de nom
     * @param nom étant nom à paramétrer de type String
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Getter de prenom
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * Setter de prenom
     * @param prenom étant prenom à paramétrer de type String
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    /**
     * Getter de email
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /**
     * Setter de email
     * @param email étant email à paramétrer de type String
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Getter de telephone
     * @return telephone
     */
    public String getTelephone() {
        return telephone;
    }
    /**
     * Setter de telephone
     * @param telephone étant telephone à paramétrer de type String
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    /**
     * Getter de rue
     * @return rue
     */
    public String getRue() {
        return rue;
    }
    /**
     * Setter de rue
     * @param rue étant rue à paramétrer de type String
     */
    public void setRue(String rue) {
        this.rue = rue;
    }
    /**
     * Getter de codePostal
     * @return codePostal
     */
    public Integer getCodePostal() {
        return codePostal;
    }
    /**
     * Setter de codePostal
     * @param codePostal étant codePostal à paramétrer de type Integer
     */
    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }
    /**
     * Getter de ville
     * @return ville
     */
    public String getVille() {
        return ville;
    }
    /**
     * Setter de ville
     * @param ville étant ville à paramétrer de type String
     */
    public void setVille(String ville) {
        this.ville = ville;
    }
    /**
     * Getter de motDePasse
     * @return motDePasse
     */
    public String getMotDePasse() {
        return motDePasse;
    }
    /**
     * Setter de motDePasse
     * @param motDePasse étant motDePasse à paramétrer de type String
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    /**
     * Getter de credit
     * @return credit
     */
    public Integer getCredit() {
        return credit;
    }
    /**
     * Setter de credit
     * @param credit étant credit à paramétrer de type Integer
     */
    public void setCredit(Integer credit) {
        this.credit = credit;
    }
    /**
     * Getter de administrateur
     * @return administrateur
     */
    public boolean isAdministrateur() {
        return administrateur;
    }
    /**
     * Setter de administrateur
     * @param administrateur étant administrateur à paramétrer de type boolean
     */
    public void setAdministrateur(boolean administrateur) {
        this.administrateur = administrateur;
    }
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Utilisateur [noUtilisateur = ");
	builder.append(noUtilisateur);
	builder.append(", pseudo = ");
	builder.append(pseudo);
	builder.append(", nom = ");
	builder.append(nom);
	builder.append(", prenom = ");
	builder.append(prenom);
	builder.append(", email = ");
	builder.append(email);
	builder.append(", telephone = ");
	builder.append(telephone);
	builder.append(", rue = ");
	builder.append(rue);
	builder.append(", codePostal = ");
	builder.append(codePostal);
	builder.append(", ville = ");
	builder.append(ville);
	builder.append(", motDePasse = ");
	builder.append(motDePasse);
	builder.append(", credit = ");
	builder.append(credit);
	builder.append(", administrateur = ");
	builder.append(administrateur);
	builder.append("]");
	return builder.toString();
    }
    
    
}
