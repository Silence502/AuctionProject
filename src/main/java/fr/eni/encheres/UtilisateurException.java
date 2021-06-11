package fr.eni.encheres;

public class UtilisateurException extends Exception {
    private static final long serialVersionUID = 1L;

    public UtilisateurException(String message) {
	super(message);
    }

    @Override
    public String getMessage() {
	StringBuffer sb = new StringBuffer("Couche DAL - ");
	sb.append(super.getMessage());
	return sb.toString();
    }
}
