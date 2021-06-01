package fr.eni.encheres.bo;

public class AppliTestBO {

    public static void main(String[] args) {
	//Test constructeurs
	
	Utilisateur user = new Utilisateur(1,"silence","Vidal","Mickael","email@meil.com","0601122345","12 rue du charme",10000,"Troyes","Pa$$w0rd",150,false);
	System.out.println(user.toString());
    }

}
