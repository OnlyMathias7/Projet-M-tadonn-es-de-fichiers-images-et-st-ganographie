package Steganographie;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class SteganoLecture{
	
	public BufferedImage img;// = ImageIO.read(new File("C:\\Users\\Clément\\Pictures\\Vache.jpg"));
	public Color[][] Pixels;
	public String cle;
	public String cleO;
	public String T;
	public String taille;
	public String TO;
	public String tailleO;
	public String texteO;
	public int largeur;
	public int longueur;
	public int ta;
	public int tt;
	public String b;
	public int lock;
	
	public SteganoLecture(String url) throws IOException {
		img = ImageIO.read(new File(url));//Création d'un BufferedImage
		largeur = img.getWidth();
		longueur = img.getHeight();
		
		cle = "&";//clé utilisée afin de avoir si il y a déja eu une steganographie
		cleO = StringToBit(cle);//Valeur de la clé (&) en Octets
		SetPixels();
		//b = "11010101";
		
		
		lock = DecodeCle();//Permet d'activer, ou pas, le processus de Lecture du message caché dans l'image
		//System.out.println("\n"+toString());
		
		
		
		/*System.out.println(t);
		System.out.println(Val1Oct(Decode()));
		
		System.out.println(Val1Oct(b));
		
		System.out.println(BitToString(Decode()));
		//System.out.println(BitToString3(Decode()));*/
		
		
		
	}
	
	// méthode pour convertir chaque lettre d'un string en octet
		public String StringToBit(String txt) {
			String x = new String();		 
			for (int i=0; i<txt.length(); i++) {
				x += String.format("%8s", Integer.toBinaryString((byte)txt.charAt(i) & 0xFF)).replace(' ', '0');
			}
			return x;
		}
	
		 
		//On crée un tableau de chauqe pixels de l'image pour pouvoir les manipuler facilement
		 public void SetPixels() {
				
			 Pixels = new Color[largeur][longueur];
				for(int i=0; i<largeur;i++)
				{
					for(int j=0; j<longueur;j++)
					{
						Pixels[i][j] = new Color(img.getRGB(i, j));
					}
				}
			}
		 
		//Recupere la partie rouge du pixel
		public char RecupLSB(Color pixel){
			
				//System.out.println(pixel.getRed() +"valeur en entrée ");
				 char bit='0';
				
				if(pixel.getRed()%2==1)
		 		{
					 bit='1';
				 }
				
				//System.out.println("Char retourné = "+bit);
				return bit;
		}
		
		//Recupere la partie bleue du pixel
		public char RecupBlueLSB(Color pixel){
			
			 char bit='0';
			
			if(pixel.getBlue()%2==1)
	 		{
				 bit='1';
			 }
			
			return bit;
		}
		
		public char RecupGreenLSB(Color pixel){
			
			 char bit='0';
			
			if(pixel.getGreen()%2==1)
			{
				 bit='1';
			 }
			
			return bit;
		}
		
		//Decodage de la taille de taille
		public String DecodeTsize() {
			String decode="";
		    for(int i=1; i<2;i++) {
			
				for(int j=0; j<8;j++)
				{
						
					decode+=RecupGreenLSB(new Color(img.getRGB(i, j)));
					
				}
			}
		    
		    return decode;
		}
		
		//Decodage de la taille du message caché
		public String Decodetaille() {
			String decode="";
		    for(int i=0; i<1;i++) {
			
				for(int j=0; j<tt*8;j++)
				{
						
					decode+=RecupGreenLSB(new Color(img.getRGB(i, j)));
					
				}
			}
		    
		    return decode;
		}
		
		//Methode qui verifie si le caractère de verification dans la partie bleue du premier pixel est présent (décodage tu texte clé)
		public int DecodeCle() {
			String decode="";
		    for(int i=0; i<1;i++) {
			
				for(int j=0;j<cleO.length();j++)
				{
						
					decode+=RecupBlueLSB(new Color(img.getRGB(i, j)));
					
				}
			}
		    if (decode.equals(cleO)) {
		    	return 1;
		    }
		    else {
		    	return 0;
		    }
		}
		
		//Methode qui verifie si le caractère de verification dans la partie rouge du premier pixel est présent (décodage tu message caché)
		 public String DecodTexteOctet(){
	         String decode="";
	         
	         for(int i=0; i<1;i++)
			{
				for(int j=0; j<ta*8;j++)
				{
					decode+=RecupLSB(new Color(img.getRGB(i, j)));
					
				}
			}
			
			return decode;
	     }
		 
		 public String Decode(){
	         String decode="";
	         for(int i=0; i<1;i++)
			{
				for(int j=0; j<texteO.length();j++)
				{
					
					decode+=RecupLSB(new Color(img.getRGB(i, j)));
				}
			}
			
			return decode;
	     }
		 
		 public String BitToStringSize(String ChaineDeBits){
			 
				String resultat="";
				String[] temp  = TO.split("(?<=\\G........)");
					
					
				for(int i=0; i<temp.length;i++){
						resultat+=(char)Byte.parseByte(temp[i], 2);
					}
					
				return resultat;
			 
		 }
		 
		 public String BitToStringTaille(String ChaineDeBits){
			 
				String resultat="";
				String[] temp  = tailleO.split("(?<=\\G........)");
					
					
				for(int i=0; i<temp.length;i++){
						resultat+=(char)Byte.parseByte(temp[i], 2);
					}
					
				return resultat;
			 
		 }
		 
		 public String BitToStringCle(String ChaineDeBits){
			 
				String resultat="";
				String[] temp  = cleO.split("(?<=\\G........)");
					
					
				for(int i=0; i<temp.length;i++){
						resultat+=(char)Byte.parseByte(temp[i], 2);
					}
					
				return resultat;
			 
		 }
		 
		 public String BitToStringOctet(String ChaineDeBits){
			 
			 	String resultat="";
				String[] temp  = b.split("(?<=\\G........)");
					
					
				for(int i=0; i<temp.length;i++){
						resultat+=(char)Byte.parseByte(temp[i], 2);
					}
					
				return resultat;
		 }
		
		 
		 
		 public String Val1Oct(String octet) {
			 	
			String x="";
			char bit ='0';
		    char[] chars = octet.toCharArray();
		    if (chars[0] == bit) {
		       	x = "0";
		    }
		    else {
		       	x = "1";
		    }
		    return x;
		        
		 }
		 
		 public String BitToString( String ChaineDeBits){
			 String resultat="";
							 
				 
				 String[] temp  = texteO.split("(?<=\\G........)");
			 	
				 for(int i=0; i<temp.length;i++){
					 
				    resultat+=(char)Byte.parseByte(temp[i], 2);
				 }
				
			return resultat; 
		 }
		 
		 public String BitToStringF( String ChaineDeBits){
			 String resultat="";
			 
			 			 
				 
				 String[] temp  = texteO.split("(?<=\\G........)");
			 	
				 for(int i=0; i<temp.length;i++){
					 
				    resultat+=(char)Byte.parseByte(temp[i], 2);
				 }
				
			 
			return resultat; 
		 }
		 		 
		 
		
		 public String toString() {
			 if (lock == 1) {
				
				TO = DecodeTsize();//Valeur de T en Octets
				//System.out.println(TO);
				T = String.valueOf(BitToStringSize(TO));//String qui indique si la taille du message est compris entre 0<=x<10 (1) ou 10<=x<100 (2) etc...
				//System.out.println(T);
				tt = Integer.parseInt(T);//Valeur de T en int
				//System.out.println(tt);
				
				tailleO = Decodetaille();//Valeur de taille en Octets
				//System.out.println(tailleO);
				taille = String.valueOf(BitToStringTaille(tailleO));//taille du message définie en string
				//System.out.println(taille);
				ta = Integer.parseInt(taille);//Valeur de taille en int
				//System.out.println(ta);
				
				texteO = DecodTexteOctet();//Valeur du message caché en Octets
				//System.out.println(texteO);
				return (BitToString(Decode()));
					
				}
			else {
				return ("pas de message caché");
				}
		 }
		
		
			 
	    
		 
		 public static void main(String[] args) throws IOException {
			 
			 SteganoLecture ste8 = new SteganoLecture("C:\\Users\\Clément\\Pictures\\Arbre.jpg");
			 /*SteganoLecture ste3 = new SteganoLecture("C:\\Users\\Clément\\eclipse-workspace\\PROJET\\PaysageSTE.jpg");
			 SteganoLecture ste7 = new SteganoLecture("C:\\Users\\Clément\\Pictures\\Fleur.jpg");
			 SteganoLecture ste1 = new SteganoLecture("C:\\Users\\Clément\\Pictures\\FleurSTE.jpg");
			 System.out.println(ste1.toString());
			 
			 SteganoLecture ste2 = new SteganoLecture("C:\\Users\\Clément\\Pictures\\Vache.jpg");
			 SteganoLecture ste = new SteganoLecture("C:\\Users\\Clément\\Pictures\\Paysage.jpg");
			 
			 
			 
			 SteganoLecture ste4 = new SteganoLecture("C:\\Users\\Clément\\Pictures\\Arbre.jpg");
			 SteganoLecture ste5 = new SteganoLecture("C:\\Users\\Clément\\Pictures\\ImageMODEL.jpg");
		 }*/
		 }
}		 
