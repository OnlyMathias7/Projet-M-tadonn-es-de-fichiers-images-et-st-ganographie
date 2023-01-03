package Securite;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Steganographie.SteganoLecture;
import Steganographie.steganographie1;

/*Cette class vérifie les entrées de fichiers
 *Etape 1: Verifier le premiere caratère de la ligne de commande
 *Etape 2: Verifier si les dossier ou fichier existe
 *Etape 3: Verifier si les fichiers sont des fichiers png ou jpeg
 * */
 

public class Entrer {
	private String v1;
	private String v2;
	private String v3;
	private ArrayList stockNom= new ArrayList<String>();
	
	private boolean cmdCorrect=false;
	private String adresse;
	
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/	
	//Précondition: vérifier le nombre d'élémént du tableau 
	
	//Constructeur 1.0: entrer standard
	
	public Entrer(String p1, String p2) throws ErreurException  {
		this.v1=p1;
		this.v2=p2;
		
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/
		//Etape 1:
		
		if(this.verification1(v1)==true) {
			if(v1.equals("-h") || v1.equals("-help")) {
				this.help();
			}
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/
		//Etape 2: Partie fichier
			
			if(v1.equals("-f")) {
				if(this.verificationFichier1(v2)) {
					if(this.verificationPNGJPEG(v2)) {
						//System.out.println("Ca marche");
						this.adresse=v2;
						this.stockNom.add(this.nomFichier(v2));
						cmdCorrect=true;
					}else {
						this.erreur();
					}
				}else {
					this.erreur();
				}
			}
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/
		//Etape 2: Partie Dossier
			
			if(v1.equals("-d")) {
				if(this.verificationDossier(v2)) {
					//parcourir le repertoire et conserver les fichier png ou jpng dans une liste
					this.verificationDossierPNGJPNG5(v2);
					cmdCorrect=true;
					//this.afficheListe();
					
				}else {
					this.erreur();
				}
			}
			
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/	
			
		}else {
			this.erreur();
		}
		 
	}
	
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/		
	//Constructeur 2.0: entrer Stéganographie Lire le message cacher
	public Entrer(String p1, String p2, String p3) throws ErreurException  {
		this(p1,p2);
		this.v3=p3;
		if(!verificationSteganography2(v3)) {
			cmdCorrect=false;
			this.erreur();
		}else {
			if(cmdCorrect) {
				try {
					SteganoLecture stegL= new SteganoLecture(p2);
					System.out.println("\n"+stegL.toString());
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				this.erreur();
			}
			
		}
		
	}
	
	
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/	
	
	//Constructeur 3.0: entrer Stéganographie entrer un message cacher
		public Entrer(String p1, String p2, String p3,String p4) throws ErreurException  {
			this(p1,p2);
			this.v3=p3;
			if(!verificationSteganography1(v3)) {
				cmdCorrect=false;
				this.erreur();
			}else {
				if(cmdCorrect) {
					try {
						steganographie1 stegL= new steganographie1(p2,p4);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					this.erreur();
				}
			}
			
		}
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/		
	//Constructeur 4.0: entrer GUI ou entrer help pour la console
	public Entrer(String p1) throws ErreurException {
		if(p1.equals("-h") || p1.equals("-help")) {
			this.help();
		}else {
		this.v2=p1;
		if(this.verificationDossier(v2) || this.verificationFichier1(v2)) {
			if(this.verificationFichier1(v2)) {
				if(this.verificationPNGJPEG(v2)) {
					//System.out.println("Ca marche");
					this.adresse=v2;
					this.stockNom.add(this.nomFichier(v2));
					cmdCorrect=true;
				}else {
					this.erreur();
				}
			}else {
				this.verificationDossierPNGJPNG5(v2);
				cmdCorrect=true;
				//this.afficheListe();
			}
		}else {
			this.erreur();
		}
		}
	}
		
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/	
	
	//Méthodes:
	
	
	//Vérifie si les premieres commandes sont correctes
	public boolean verification1(String m) {
		
		return(m.equals("-h") || m.equals("-help") || m.equals("-d") || m.equals("-f"));
	}
	
	//Affiche les entrer possible a l'utilisateur pour mieux comprendre
	public void help() {
		Help h=new Help();
		System.out.println(h.toString());
	}
	
	//Affiche à l'utilisateur qu'il y a une erreur dans la commande entrée
	public void erreur() throws ErreurException {
		cmdCorrect=false;
		throw new ErreurException("Erreur");
		
	}
	
	//Vérifie si un fichier existe ou pas 
	public boolean verificationFichier1(String m) {
		File file= new File(m);
		return(file.exists() && !file.isDirectory());
		
	}
	
	//Verifie si un dossier existe ou pas 
	public boolean verificationDossier(String m) {
		File file= new File(m);
		return(file.exists() && file.isDirectory());
	}
	
	//Retourne le nom du fichier
	public String nomFichier(String fichier) {
		File dossier= new File(fichier);
		return dossier.getName();
	}
	
	//Verifier si le fihier est un fichier png ou jpeg
	public boolean verificationPNGJPEG(String fichier) {
		String[] tab1= fichier.split("/");
		String[] tab2= tab1[tab1.length-1].split("\\.");
		if(tab2[tab2.length-1].equals("jpeg") || tab2[tab2.length-1].equals("png") || tab2[tab2.length-1].equals("jpg") ) { 
			return true;
		}else {
			return false;
		}
		
	}
	
	//Parcours d'un dossier et rajoute les fichiers qui sont png et jpng dans une Liste
	public void verificationDossierPNGJPNG5(String nom){
		this.adresse=nom;
		File dossier= new File(nom);
		for (File file : dossier.listFiles()) {
			if (!file.isDirectory()) {
				if(verificationPNGJPEG(file.getName())) {
					this.stockNom.add(file.getName());
				}
			} else {
				File dossier1= new File(nom+"\\"+file.getName());
				for (File file2 : dossier1.listFiles()) {
					if (!file2.isDirectory()) {
						if(verificationPNGJPEG(file2.getName())) {
							this.stockNom.add(file.getName()+"\\"+file2.getName());
						}
					}else {
						verificationDossierPNGJPNG5(nom+"\\"+file.getName());
						adresse=nom;
					}
				}
			}
		}
		
	}
	
	//Vérifie si la troisième commande est correcte
	public boolean verificationSteganography1(String v3) {
		return v3.equals("-s");
	}
	
	//Vérifie si la troisième commande est correcte
	public boolean verificationSteganography2(String v3) {
		return v3.equals("-e");
	}
	
	//Retourne si la commande est bonne
	public boolean comdCorrect() {
		return this.cmdCorrect;
	}
	
	//Méthode qui retourne la taille de la liste 
	public int tailleL() {
		return stockNom.size();
	}
	
	//Méthode qui retourne l'element de la liste souhaiter
	public String eltListe(int i) throws ArrayIndexOutOfBoundsException {
		if(this.tailleL()>i) {
			return (String) stockNom.get(i);
		}else {
			throw new ArrayIndexOutOfBoundsException("Il y a pas d'élément a cette position");
		}
		
	}
	
	//Méthode qui retourne la liste des fichier png ou jpeg
	public ArrayList<String> getStockName(){
		return this.stockNom;
	}

	//Méthodes qui retourne l'adresse du Dossier
	public String adresseDossier() {
		return this.adresse;
	}
	
	
	public String adresseLastElt(String adresse) {
		String[] tab1= adresse.split("/");
		return tab1[tab1.length-1];
	}
	
	//Méthodes qui retourne la variable v1
	public String V1() {
		return this.v1;
	}
	
	//Méthodes qui retourne la variable v2
	public String V2() {
		return this.v2;
	}
	
	//affiche la liste des fichier png et jpng
	public void afficheListe() {
		if(stockNom.size()==0) {
			System.out.println("Il n'y a aucun fichier png et jpng dans ce Dossier");
		}else {
			for(int i=0;i<stockNom.size();i++) {
				System.out.println(stockNom.get(i));
			}
		}
		
	}
	
	
	
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/		
	//Fonction Main pour Tester les différentes entrées
	
	
	public static void main(String[] args) {
		
		
		if(args.length==2) {
			try {
				new Entrer(args[0], args[1]);
			} catch (ErreurException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			if(args.length==3) {
				try {
					new Entrer(args[0], args[1],args[2]);
				} catch (ErreurException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
			if(args.length==4) {
				try {
					new Entrer(args[0], args[1],args[2], args[3]);
				} catch (ErreurException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
