package Metadonnee;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;

public class Metadonnees {
	
	protected BufferedImage img; 		//Utile pour nombrepixels et dimensions
	
	private Path file;					//
	private BasicFileAttributes attr;	//Utile pour InfoFichier
	
	private File directory;				//
	private Date date1;					//Utile pour LastSave
	private String date2;				//
	
	private File file2;					//Utile pour FileTaille
	
	
	public Metadonnees(String url) throws IOException {
		img = ImageIO.read(new File(url));
		file = Paths.get(url) ;
		attr = Files.readAttributes(file, BasicFileAttributes.class);
		directory = new File(url);
		date1 = new Date(directory.lastModified());
		file2 = new File(url);
		
	}
	
	// Obtenir le nombre de pixels d'une image
		public long nombrepixels() {
			long nombre= 0;
			for (int i=0; i<img.getHeight();i++) {
				for (int j=0; j<img.getWidth(); j++) {
					nombre++;
				}
			}
			return nombre;
		}
		
		  /* Même méthode pour calculer le nombre de pixels par couleurs :
		  public static long nombrepixels(BufferedImage image, Couleur color) {
			long nombre= 0;
			for (int i=0; i<image.getHeight();i++) {
				for (int j=0; j<image.getWidth(); j++) {
					if ( equals(couleur, image.getRGB(i, j)) ){
						nombre++;
					}
				}
			}
			return nombre; */
		
		public String dimensions() {
			int largeur = img.getWidth();
			int longueur = img.getHeight();
			return largeur+"x"+longueur;
		}
		
		public int largueur() {
			return img.getWidth();
		}
		
		public int longueur() {
			return img.getHeight();
		}
		
		/*Cette classe permet de renvoie le jour de création et sa dernière utilisation d'un fichier pris en paramètre
		 * Cette classe vérifie aussi si le fichier est un Dossier ou un fichier ou autre chose, 
		 * si il possède des Liens.
		*/
		public String InfosFichier() {
			/*System.out.println("Jour de création: " + attr.creationTime());
			System.out.println("Dernière ouverture du fichier: " + attr.lastAccessTime());
			//System.out.println("Dernière Sauvegarde : " + attr.lastModifiedTime());

			System.out.println("C'est un Dossier: " + attr.isDirectory());
			System.out.println("C'est autre chose: " + attr.isOther());
			System.out.println("C'est un fichier: " + attr.isRegularFile());
			System.out.println("Possède-t-il un lien: " + attr.isSymbolicLink());*/
			
			return ("\nJour de création: " + attr.creationTime()+"\nDernière ouverture du fichier: " + attr.lastAccessTime()+"\nC'est un Dossier: " + attr.isDirectory()+"\nC'est autre chose: " + attr.isOther()+"\nC'est un fichier: " + attr.isRegularFile()+"\nPossède-t-il un lien: " + attr.isSymbolicLink());
		}
		
		public String LastSave() {
			SimpleDateFormat  simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
			date2 = simpleFormat.format(date1);
			/*System.out.println("Derniere sauvegarde :"+date1);
			System.out.println("Derniere sauvegarde :"+date2);*/
			return ("\nDerniere sauvegarde :"+date1+"\nDerniere sauvegarde :"+date2);
		}
		
		public String FileTaille() {
			String taille="";
			if(file2.exists()){
				 
			       double bytes = file2.length();
			       double bits = bytes * 8;
			       double kilobytes = bytes / 1024;
			       double megabytes = kilobytes / 1024;
			       double gigabytes = megabytes / 1024;
			       double terabytes = gigabytes / 1024;
			 
			       if(1000>bits) {
			    	   //System.out.println("bits : " + bits+" bits");
			    	   taille="\nbits : " + bits+" bits";
			       }
			       if(kilobytes>1) {
			    	   //System.out.println("bytes : " + bytes+ " octets");
			    	   taille="\nbytes : " + bytes+ " octets";
			       }
			       if(megabytes>1) {
			    	   //System.out.println("kilooctet : " + megabytes+ "Ko");
			    	   taille="\nkilooctet : " + megabytes+ "Ko";
			       }
			       if(gigabytes>1) {
			    	   //System.out.println("gigaoctet : " + gigabytes + "Go");
			    	   taille="\ngigaoctet : " + gigabytes + "Go";
			       }
			       if(terabytes>1) {
			    	   //System.out.println("teraoctet : " + terabytes + "To");
			    	   taille="\nteraoctet : " + terabytes + "To";
			       }
			     
			}
			else{			    
			       //System.out.println("Fichier innexistant");
			       taille="\nFichier innexistant";
			    }
			return taille;			
		}
		
		public String tostring() {
			return ("nombre pixels:"+ nombrepixels()+"\ndimension:"+dimensions()+InfosFichier()+LastSave()+FileTaille());
		}

		
}
