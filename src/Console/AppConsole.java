package Console;

import java.io.IOException;

import Metadonnee.Metadonnees;
import Securite.Entrer;
import Securite.ErreurException;

public class AppConsole {
	
	//Création d'une instance Entrer
	Entrer entrer;
	
	//Création d'une instance Metadonnes
	Metadonnees meta;

/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/	
	//Constructeur:
	
	public AppConsole(String args[]) {
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/	
		//Entrer d'un fichier ou d'un dossier
		if(args.length==2) {
			try {
				entrer=new Entrer(args[0], args[1]);
				if(entrer.comdCorrect()) {
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/						
					//Entrer d'un fichier
					if(entrer.V1().equals("-f")) {
						try {
							System.out.println(entrer.V2());
							meta=new Metadonnees(entrer.V2());
							System.out.println(meta.tostring());
							System.out.println();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("Erreur sur l'entrée de la commande, pour plus d'information utiliser la commande -h ou -help");
						}
					}else {
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/	
					//Entrer d'un dossier
						if(entrer.V1().equals("-d")) {
							System.out.println("Dossier: "+entrer.adresseDossier());
							System.out.println();
							for(int i=0; i<entrer.tailleL();i++) {
								try {
									System.out.println(entrer.eltListe(i));
									meta=new Metadonnees(entrer.V2()+"/"+entrer.eltListe(i));
									System.out.println(meta.tostring());
									System.out.println();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									System.out.println("Erreur sur l'entrée de la commande, pour plus d'information utiliser la commande -h ou -help");
								}
							}
						}
					}
				}
			} catch (ErreurException e) {
				// TODO Auto-generated catch block
				System.out.println("Erreur sur l'entrée de la commande, pour plus d'information utiliser la commande -h ou -help");
			}
		}else {
	
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/	
			//Entrer pour la Stéganographie (lire le message)
			if(args.length==3) {
				try {
					entrer=new Entrer(args[0], args[1],args[2]);
				} catch (ErreurException e) {
					// TODO Auto-generated catch block
					System.out.println("Erreur sur l'entrée de la commande, pour plus d'information utiliser la commande -h ou -help");
				}
			}	

/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/	
			//Entrer pour la Stéganographie (inserer le message)
			if(args.length==4) {
				try {
					entrer=new Entrer(args[0], args[1],args[2], args[3]);
				} catch (ErreurException e) {
					// TODO Auto-generated catch block
					System.out.println("Erreur sur l'entrée de la commande, pour plus d'information utiliser la commande -h ou -help");
				}
			}
			
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/	
			//Entrer pour afficher la notice
			if(args.length==1) {
				try {
					entrer=new Entrer(args[0]);
				} catch (ErreurException e) {
					// TODO Auto-generated catch block
					System.out.println("Erreur sur l'entrée de la commande, pour plus d'information utiliser la commande -h ou -help");
				}
			}
			
		}
		
	}

/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/	
	//Fonction Main:
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AppConsole(args);
	}

}
