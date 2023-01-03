package Steganographie;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Color;

public class steganographie1 {
	
	public BufferedImage img;
	public BufferedImage imgf;
	public Color[][] Pixels;
	public String texte;
	public String texteO;
	public String cle;
	public String taille;
	public String tailleO;
	public String cleO;
	public String T;
	public String TO;
	int largeur;
	int longueur;
	public File URL;
	
	
						 //////////////////////////////////////
						// CACHER UN MESSAGE DANS UNE IMAGE //
					   //////////////////////////////////////
	
	public steganographie1(String url, String message) throws IOException {
		
		URL = new File(url);//fichier ayant chemin d'accee -> url (donc l'image)
		img=ImageIO.read(new File(url));//création d'un BufferedImage
		largeur = img.getWidth();			
		longueur = img.getHeight();
		//System.out.println("\nChemin d'accès à l'image :"+ url);
		texte = message;	//Message à cacher
		cle = "&";//clé utilisée afin de avoir si il y a déja eu une steganographie
		taille = String.valueOf(texte.length());//taille du message définie en string
		//System.out.println(taille);
		T = String.valueOf(taille.length());//String qui indique si la taille du message est compris entre 0<=x<10 ou 10<=x<100 etc...
		//System.out.println(T);
		TO = StringToBit(T);//Valeur de T en Octets
		tailleO = StringToBit(taille);//Valeur de taille en Octets
		//System.out.println(tailleO);
		//System.out.println(TO);
		texteO = StringToBit(texte);//Valeur du message en Octets
		cleO = StringToBit(cle);//Valeur de la clé (&) en Octets
		//System.out.println(cleO);
		InitImage(url);
		SetPixels();
		Trait();
		/*System.out.println(VerifDecode());
		//System.out.println(BitToStringVerif(VerifDecode()));
		System.out.println(BitToStringOctet(b));
		System.out.println(BitToStringOctet(c));
		System.out.println(Decodetaille());
		System.out.println(BitToStringTaille(Decodetaille()));
		System.out.println(BitToStringVerif(VerifDecode()));
		System.out.println(BitToString(Decode()));
		System.out.println(tailleO);
		System.out.println(Decode());
		System.out.println(StringToBit(NomNouvelleImage));*/
		
		
	}
	    static int count_digit(int x)
	    {
	        int count = 0;
	        while (x != 0) {
	            x = x / 10;
	            ++count;
	        }
	        return count;
	    }
	
	//On initialise une nouvelle image aux mêmes dimensions que l'image de base
	 public void InitImage(String adresseImage) throws IOException{
		 
		
		try {
			BufferedImage img = ImageIO.read(new File(adresseImage));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		if(img != null)
		{
			imgf = new BufferedImage(largeur, longueur, BufferedImage.TYPE_INT_ARGB);  
			
		}		
		
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
	 
	 
	
	// méthode pour convertir chaque lettre d'un string en octet
	public String StringToBit(String txt) {
		String x = new String();		 
		for (int i=0; i<txt.length(); i++) {
			x += String.format("%8s", Integer.toBinaryString((byte)txt.charAt(i) & 0xFF)).replace(' ', '0');
		}
		return x;
	}
	
	
	public Color verifLSBBlue(char bit, Color pixel) {
		if(bit%2==0) {
			 if(pixel.getBlue()%2==1)
			 {
				
				 Color x= pixel;
				 pixel = new Color(x.getRed(), x.getGreen(), x.getBlue()-1, x.getAlpha());
			 }
			 else {			 	
				
			 }
		}
		else {			
			if(pixel.getBlue()%2==0)
			{
				Color x= pixel;
				pixel = new Color(x.getRed(), x.getGreen(), x.getBlue()+1, x.getAlpha());
				
			}
			else {
				
			}
		}
		Color x = pixel;
		return x;
	}
	
	public Color verifLSBGreen(char bit, Color pixel) {
		if(bit%2==0) {
			 if(pixel.getGreen()%2==1)
			 {
				
				 Color x= pixel;
				 pixel = new Color(x.getRed(), x.getGreen()-1, x.getBlue(), x.getAlpha());
			 }
			 else {			 	
				
			 }
		}
		else {			
			if(pixel.getGreen()%2==0)
			{
				Color x= pixel;
				pixel = new Color(x.getRed(), x.getGreen()+1, x.getBlue(), x.getAlpha());
				
			}
			else {
				
			}
		}
		Color x = pixel;
		return x;
	}
	
	
	//méthode qui prend la couleur ainsi que son LSB à modifier et nous retourne la nouvelle couleur après modification du LSB
	public Color NewLSBRED(char bit, Color pixel) {
		if(bit%2==0) {
			 if(pixel.getRed()%2==1)
			 {
				
				 Color x= pixel;
				 pixel = new Color(x.getRed()-1, x.getGreen(), x.getBlue(), x.getAlpha());
			 }
			 else {			 	
				
			 }
		}
		else {			
			if(pixel.getRed()%2==0)
			{
				Color x= pixel;
				pixel = new Color(x.getRed()+1, x.getGreen(), x.getBlue(), x.getAlpha());
				
			}
			else {
				
			}
		}
		Color x = pixel;
		return x;
	}
	
		
	// méthode qui parcours tout le tableau de pixels pour modifier chaque LSB puis sauvegarde notre nouvelle image avec message caché
	public void Trait() {
		
		int c=0;
		//System.out.println(Pixels.length);
		for(int i=0; i<Pixels.length;i++){
			for(int j=0; j<Pixels[i].length;j++){
				if(c<texteO.length()){
						//System.out.println("Lavaleur rouge du pixel = "+Pixels[i][j].getRed());
						//On repete l'opération pour toute la chaine de caractères
						Pixels[i][j]=NewLSBRED(texteO.charAt(c),Pixels[i][j]);
						//On modifie la couleur RED avec un nouveau LSB grace à la fonction NewLSBAlpha
						//System.out.println("Après modifiaction de l'octet RED, la valeur rouge du pixel ="+Pixels[i][j].getRed());
						c++;
				}
                        //On complète le reste de l'image avec les reste des pixels
				imgf.setRGB(i, j, Pixels[i][j].getRGB());
				
				}
		}
		c=0;		
		for(int i=0; i<Pixels.length;i++){
			for(int j=0; j<Pixels[i].length;j++){
				if(c<cleO.length()){
					/* tant qu'on a pas utilisé toute notre chaine on répète l'opération*/
						//System.out.println("Le pixel rentre et vaut sa valeur Bleu = "+Pixels[i][j].getBlue());
						

						Pixels[i][j] =verifLSBBlue(cleO.charAt(c),Pixels[i][j]);
						//On change la valeur Red avec celle de notre chaine de bits
						//System.out.println("Le pixel sort et vaut "+Pixels[i][j].getBlue());
						c++;
					
				}
                                 /*dès qu'on a fini on mets le reste des pixels de l'image*/
				imgf.setRGB(i, j, Pixels[i][j].getRGB());
			}
		}
		c=0;		
		for(int i=0; i<Pixels.length;i++){
			for(int j=0; j<Pixels[i].length;j++){
				if(c<tailleO.length()){
					/* tant qu'on a pas utilisé toute notre chaine on répète l'opération*/
						//System.out.println("Le pixel rentre et vaut sa valeur Vert = "+Pixels[i][j].getGreen());
						

						Pixels[i][j] =verifLSBGreen(tailleO.charAt(c),Pixels[i][j]);
						//On change la valeur Red avec celle de notre chaine de bits
						//System.out.println("Le pixel sort et vaut "+Pixels[i][j].getGreen());
						c++;
					
				}
                                 /*dès qu'on a fini on mets le reste des pixels de l'image*/
				imgf.setRGB(i, j, Pixels[i][j].getRGB());
			}
		}
		c=0;
		for(int i=1; i<Pixels.length;i++){
			for(int j=0; j<Pixels[i].length;j++){
				if(c<TO.length()){
					/* tant qu'on a pas utilisé toute notre chaine on répète l'opération*/
						//System.out.println("Le pixel rentre et vaut sa valeur Vert = "+Pixels[i][j].getGreen());
						

						Pixels[i][j] =verifLSBGreen(TO.charAt(c),Pixels[i][j]);
						//On change la valeur Red avec celle de notre chaine de bits
						//System.out.println("Le pixel sort et vaut "+Pixels[i][j].getGreen());
						c++;
					
				}
                                 /*dès qu'on a fini on mets le reste des pixels de l'image*/
				imgf.setRGB(i, j, Pixels[i][j].getRGB());
			}
			
		}
		
		try {
			ImageIO.write(imgf,"png",URL);//sauvegarde de l'image
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
/*							/////////////////////////////////////////
						   // RECUPERER UN MESSAGE DANS UNE IMAGE //
                          /////////////////////////////////////////
	
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
	
	
	//Convertit caine de bit en string
	public String BitToString( String ChaineDeBits){
		 String resultat="";
		 
		 if(VerifDecode().equals("00100110")) {
			 
			 
			 String[] temp  = texteO.split("(?<=\\G........)");
		 	
			 for(int i=0; i<temp.length;i++){
				 
			    resultat+=(char)Byte.parseByte(temp[i], 2);
			 }
			
		 }
		 else {
			 resultat="pas de message caché";
		 }
		return resultat; 
	 }
	
	 public String BitToStringVerif(String ChaineDeBits){
		 
			String resultat="";
			String[] temp  = txtverif.split("(?<=\\G........)");
				
				
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
	 
	 public String BitToStringOctet(String ChaineDeBits){
		 
		 String resultat="";
			String[] temp  = ChaineDeBits.split("(?<=\\G........)");
				
				
			for(int i=0; i<temp.length;i++){
					resultat+=(char)Byte.parseByte(temp[i], 2);
				}
				
			return resultat;
	 }
		
			
			
	//Methode qui verifie si le caractère de verification dans la partie bleue du premier pixel est présent (décodage tu texte clé)
	public String VerifDecode() {
		String decode="";
	    for(int i=0; i<1;i++) {
		
			for(int j=0; j<txtverif.length();j++)
			{
					
				decode+=RecupBlueLSB(new Color(imgf.getRGB(i, j)));
				
			}
		}
	    
	    return decode;
	}
	
	//Decodage de la taille du message caché
	public String Decodetaille() {
		String decode="";
	    for(int i=0; i<1;i++) {
		
			for(int j=0; j<16;j++)
			{
					
				decode+=RecupGreenLSB(new Color(imgf.getRGB(i, j)));
				
			}
		}
	    
	    return decode;
	}
			
	//Methode qui verifie si le caractère de verification dans la partie rouge du premier pixel est présent (décodage tu message caché)
	 public String Decode(){
         String decode="";
         for(int i=0; i<1;i++)
		{
			for(int j=0; j<texteO.length();j++)
			{
				
				decode+=RecupLSB(new Color(imgf.getRGB(i, j)));
			}
		}
		
		return decode;
     }
     
     */
	 
	
	
	        
	public static void main(String[] args) throws IOException {
		
		steganographie1 ste = new steganographie1("C:\\Users\\Clément\\Pictures\\Vache.jpg", "Ce message hbhbhb");
		//steganographie1 ste1 = new steganographie1("C:\\Users\\Clément\\eclipse-workspace\\PROJET\\PaysageSTE.jpg", "J'ai mal a la tete");
		//steganographie1 ste2 = new steganographie1("C:\\Users\\Clément\\Pictures\\Paysage.jpg", "Je suis");
		 
		 
		 
	}
	
}

