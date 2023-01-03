package Securite;

public class Help {
	private String message;
	
	public Help(){
		
	}
	
	public String toString() {
		message="Bonjour, \nVoici la notice de l'Application: ";
		message+="\nLe But de cette Application est d'afficher toutes les M�tadonn�es d'un fichier de type png ou jpeg. ";
		message+="\nIl est possible de prendre en param�tre d'entrer l'adresse d'un dossier et de lister tous les fichiers png et jpeg et en extraire les M�tadonn�es de ces fichiers.";
		message+="\nCette Application poss�de aussi une option St�ganographie qui permet de cacher du texte dans une image (le texte n'est pas visible � l'oeil nu).";
		message+="\nEt on peut r�cup�rer ce texte cacher dans une image avec l'Application.\n \n";
		message+="L'Application peut etre utilis� sous deux format: \n-Sous le mode Console; \n-Sous une Interphase Graphique;\n \n";
		message+="Utilisation:";
		message+="\nEn Mode Console: \nLes commandes accept�es sont :";
		message+="\n-help(ou -help) //pour afficher la notice de l'Application.";
		message+="\n-f adressedufichier //pour extraire toutes les M�tadonn�es d'un fichier png ou jpeg.\n";
		message+="-d adressedudossier //pour extraire toutes les M�tadonn�es des fichiers (png ou jpeg) du dossier. \n";
		message+="-f(ou -d) adresseFichier(ou adressedossier) -e //pour extraire le texte cacher de l'image.\n";
		message+="-f(ou -d) adresseFichier(ou adressedossier) -s -Texte ASCII- //pour ins�rer un message (non visible a l'oeil nu) dans l'image.\n";
		message+="Si vous ne rentrer pas correctement votre adressefichier(ou adressedossier) avec les commandes correctes l'application risque de ne pas fonction.\n";
		message+="\nEn Mode Interphase Graphique: \nIl faut bien entrer l'adresse de votre dossier ou image.\n";
		message+="Grace au bouton -OUVRIR REPERTOIRE- vous pouvez acc�der � votre r�pertoire pour recherche votre image.\n";
		message+="ATTENTION!! cette fonction va vous retourner l'adresse d'une image et ne prend que les imange png ou jpeg.\n";
		message+="Apr�s avoir entrer l'adresse de votre dossier ou image appuier sur -RECHECHER- pour lancer l'Application. \n";
		message+="Normalement en bas � gauche sera afficher le nom du fichier ou les noms des fichier png et jpeg present dans le dossier entrer.\n";
		message+="Si vous voullez rajouter un message cacher vous n'avez qu'� selectionner dans l'Arborescense le fichier souhait�,\n";
		message+="Et entrer le texte souhait� dans la zone de texte en bas � droite et appuier sur -INSERER-.\n";
		message+="Pour lire les message cacher vous n'avez qu'� selectionner dans l'Arborescense le fichier que vous voullez et appuier sur -Lire Message-";
		message+="\nCliquer sur le fichier que vous souhaitez, ses Metadonn�es seront afficher juste � cot�.\n";
		message+="En cliquant sur le -MENU- vous allez pouvoir utiliser trois fonction:\n";
		message+="-NOUVEAU- qui va ouvrir une nouvelle fenetre de l'Application;\n";
		message+="-HELP- qui va afficher la notice dans une nouvelle fenetre;\n";
		message+="-QUITTER- qui va fermer la fenetre de l'Application et la fenetre de la notice si elle est ouverte\n";
		message+="Il est possible d'afficher l'image.\n";
		message+="Lorsque vous avez selectionn� un fichier dans l'Arborescence vous pouvez affichier l'image en appuier dans le -MENU-\npuis appuier sur -Lecteur image-.";
		message+="\n \nAvec ses informations vous savez utiliser notre Application maintenant.";
		return message;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Help n= new Help();
		System.out.println(n.toString());
	}

}
