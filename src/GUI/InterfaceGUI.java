package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


import Metadonnee.Metadonnees;
import Securite.Entrer;
import Securite.ErreurException;
import Securite.Help;
import Steganographie.SteganoLecture;
import Steganographie.steganographie1;



public class InterfaceGUI {
	
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/	
	//Composant de la class:
	
	String adresse;
	
	steganographie1 steg;
	SteganoLecture steg1;
	
	//Dimension pour la fenetre frameimage
	int largueur;
	int longueur;
	
	//Metadonnée pour avoir dimension fenetre frameimage
	Metadonnees metaI;
	
	//Création d'une interphase Graphique
	JFrame frame = new JFrame("Projet_S3");
	JFrame framehelp= new JFrame("Help");
	JFrame frameimage= new JFrame("Lecteur Image");
	
	
	
	
	//Image icone application
	ImageIcon icon= new ImageIcon("C:\\Users\\mathi\\OneDrive\\Bureau\\Projet_S3\\icon.png");
	
	
	//Création d'un espace "reserver" dans la fenetre qui sont utilisé dans le code
	JPanel panel1 = new JPanel();
	JPanel panel2= new JPanel();
	JPanel panel3= new JPanel();
	JPanel panel4= new JPanel();
	JPanel panel5= new JPanel();
	JPanel panel6= new JPanel();
	JPanel panel7= new JPanel();
	JPanel panel8= new JPanel();
	JPanel panel13= new JPanel();
	JPanel panel14= new JPanel();
	JPanel panel15= new JPanel();
	JPanel panel16= new JPanel();
	JPanel panel17= new JPanel();
	JPanel panel18= new JPanel();
	JPanel panel28= new JPanel();
	
	
	//JPanel vide 
	JPanel panel9= new JPanel();
	JPanel panel10= new JPanel();
	JPanel panel11= new JPanel();
	JPanel panel12= new JPanel();
	
	//JPanel pour Steganographie
	JPanel panel19= new JPanel();
	JPanel panel20= new JPanel();
	JPanel panel21= new JPanel();
	JPanel panel22= new JPanel();
	
	//JPanel vide Steganographie
	JPanel panel23= new JPanel();
	JPanel panel24= new JPanel();
	JPanel panel25= new JPanel();
	
	//JPanel pour framehelp
	JPanel panel26= new JPanel();
	
	//JPanel pour frameimage
	JPanel panel27= new JPanel();
	
	//Création d'un bouton 
	JButton b1= new JButton("Rechercher");
	JButton b2= new JButton("Ouvrir Repertoire");//Button 
	JButton b3= new JButton("Lire Message");
	JButton b4= new JButton("Insérer");
	
	//Crétion de texte
	JLabel l1=new JLabel("Arborescence");
	JLabel l2= new JLabel("Méta-donnée");
	JLabel l3= new JLabel("Stéganographie");
	JLabel l4= new JLabel("Tableau resultat");
	JLabel l5= new JLabel("Tableau resultat");
	JLabel l6= new JLabel("Tableau resultat");
	JLabel l7= new JLabel("Entrer l'adresse de votre dossier ou fichier");
	JLabel l8= new JLabel("Entrer un nouveau message");
	JLabel l9= new JLabel();
	//JLabel l10 = new JLabel();
	JLabel imageicon= new JLabel();
	
	
	//Crétion d'entré de caratère dans la fenetre 
	JTextField f1= new JTextField();//entrer du dossier ou du fichier
	JTextField f2= new JTextField();//entrer message Stéganographie
	
	//Création d'un Menu
	JMenuBar menuBar= new JMenuBar();
	JMenu Menu= new JMenu("Menu");
	JMenuItem helpMenu= new JMenuItem("Help");
	JMenuItem quitMenu= new JMenuItem("Quitter");
	JMenuItem newframe= new JMenuItem("Nouveau");
	JMenuItem lecteurimage= new JMenuItem("Lecteur image");
	
	//Création d'une JList
	JList<String> dossier; 
	
	//Création d'un DefaultListModel
	DefaultListModel<String> model;
	
	//Création d'un JTextArea
	JTextArea textarea=new JTextArea();//Affiche Metadonne
	JTextArea textarea1=new JTextArea();//Affiche Message Steganographie
	JTextArea textareahelp= new JTextArea();//Affiche la Notice de l'Application
	
	
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/	
	//Constructeur:
	
	public InterfaceGUI() {

/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/
	//Organisation des couleurs
	
	//Rajoute la couleur en arrière plan de l'espace reserver (pour les Panels)
		panel1.setBackground(Color.WHITE);
		panel2.setBackground(Color.WHITE);
		panel3.setBackground(Color.WHITE);
		panel4.setBackground(Color.WHITE);
		panel5.setBackground(Color.WHITE);
		panel6.setBackground(Color.WHITE);
		panel7.setBackground(Color.WHITE);
		panel8.setBackground(Color.WHITE);
		panel9.setBackground(Color.WHITE);
		panel10.setBackground(Color.WHITE);
		panel11.setBackground(Color.WHITE);
		panel12.setBackground(Color.WHITE);
		panel13.setBackground(Color.BLACK);
		panel14.setBackground(Color.BLACK);
		panel15.setBackground(Color.BLACK);
		panel16.setBackground(Color.WHITE);
		panel17.setBackground(Color.WHITE);
		panel18.setBackground(Color.WHITE);
		panel19.setBackground(Color.WHITE);
		panel20.setBackground(Color.WHITE);
		panel21.setBackground(Color.WHITE);
		panel22.setBackground(Color.BLACK);
		panel23.setBackground(Color.WHITE);
		panel24.setBackground(Color.WHITE);
		panel25.setBackground(Color.WHITE);
		panel26.setBackground(Color.WHITE);
		panel28.setBackground(Color.WHITE);
		
	//Change la couleur de fond d'un JLabel
		l1.setBackground(Color.BLACK);
		l2.setBackground(Color.BLACK);
		l3.setBackground(Color.BLACK);
		l7.setBackground(Color.BLACK);
		l8.setBackground(Color.BLACK);
		
		
	//Change la couleur du texte d'un JLabel
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.WHITE);
		l7.setForeground(Color.BLACK);
		l8.setForeground(Color.WHITE);
		l9.setForeground(Color.RED);
		
		
	//Couleur des bouton
		b1.setBackground(Color.BLACK);
		b3.setBackground(Color.BLACK);
				
	//Couleur du texte du boutton
		b1.setForeground(Color.WHITE);
		b3.setForeground(Color.WHITE);
		
		/*Modèle 1
		panel1.setLayout(new GridLayout(1,2,15,15));
		panel6.setLayout(new GridLayout(2,1,40,40));
		panel6.add(l7);
		panel6.add(f1);
		panel1.add(panel6);
		panel1.add(b1);*/
		//Ancien modèle:panel7.setLayout(new GridLayout(2,1));
		
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/	
	//Partie haut de la fenetre:
	
	//Organisation du panel1
		panel1.setLayout(new GridLayout(3,1));
		l7.setHorizontalAlignment(JLabel.CENTER);
		l7.setVerticalAlignment(JLabel.CENTER);
		panel1.add(l7);
		panel8.setLayout(new BorderLayout());
		panel8.add(f1, BorderLayout.CENTER);
		panel8.add(panel9, BorderLayout.NORTH);
		panel8.add(panel10, BorderLayout.SOUTH);
		panel8.add(panel11, BorderLayout.WEST);
		panel8.add(panel12, BorderLayout.EAST);
		panel1.add(panel8);
		
		
	//Organisation du panel7
		panel7.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel7.add(b2);
		panel7.add(b1);
		panel28.setLayout(new GridLayout(2,1));
		panel28.add(panel7);
		l9.setHorizontalAlignment(JLabel.CENTER);
		l9.setVerticalAlignment(JLabel.CENTER);
		panel28.add(l9);
		panel1.add(panel28);
		
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/
	//Partie bas de la fenetre:	
		
	//Organisation du panel2
		panel2.setLayout(new GridLayout(1,3));
		panel2.add(panel3);//Arborescence
		panel2.add(panel4);//Metadonnée
		panel2.add(panel5);//Stéganographie
		
	//Organisation du panel3(Arborescence)
		panel3.setLayout(new BorderLayout(15,15));
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setVerticalAlignment(JLabel.CENTER);
		l4.setHorizontalAlignment(JLabel.CENTER);
		l4.setVerticalAlignment(JLabel.CENTER);
		dossier= new JList<>();
		panel13.add(l1);
		panel3.add(panel13, BorderLayout.NORTH);
		panel3.add(panel16, BorderLayout.CENTER);
		panel16.setLayout(new BorderLayout(15,15));
		panel16.add(l4, BorderLayout.NORTH);
		
		
		
	//Organisation du panel4(Métadonnée)
		panel4.setLayout(new BorderLayout(15,15));
		l2.setHorizontalAlignment(JLabel.CENTER);
		l2.setVerticalAlignment(JLabel.CENTER);
		l5.setHorizontalAlignment(JLabel.CENTER);
		l5.setVerticalAlignment(JLabel.CENTER);
		panel14.add(l2);
		panel4.add(panel14, BorderLayout.NORTH);
		panel4.add(panel17, BorderLayout.CENTER);
		panel17.setLayout(new BorderLayout(15,15));
		panel17.add(l5, BorderLayout.NORTH);
		panel17.add(textarea,BorderLayout.CENTER);
		textarea.setEditable(false);
		textarea.setFont(new Font(textarea.getFont().getName(), textarea.getFont().getStyle(), textarea.getFont().getSize()-4));
		
		
	//Organisation du panel5(Stéganographie)
		panel5.setLayout(new BorderLayout(15,15));
		l3.setHorizontalAlignment(JLabel.CENTER);
		l3.setVerticalAlignment(JLabel.CENTER);
		l6.setHorizontalAlignment(JLabel.CENTER);
		l6.setVerticalAlignment(JLabel.CENTER);
		panel15.add(l3);
		panel5.add(panel15, BorderLayout.NORTH);
		panel5.add(panel18, BorderLayout.CENTER);
		panel18.setLayout(new BorderLayout(15,15));
		panel18.add(l6, BorderLayout.NORTH);
		
		
	//Organisation du panel19(Stéganographie 2.0) 2.0
		panel19.setLayout(new GridLayout(4,1));
		l8.setHorizontalAlignment(JLabel.CENTER);
		l8.setVerticalAlignment(JLabel.CENTER);
		panel22.add(l8);
		panel21.setLayout(new BorderLayout());
		panel21.add(panel22, BorderLayout.NORTH);
		panel21.add(panel23, BorderLayout.CENTER);
		panel21.add(panel24, BorderLayout.EAST);
		panel21.add(panel25, BorderLayout.WEST);
		panel20.setLayout(new FlowLayout());
		panel20.add(b4);
		panel20.add(b3);
		panel19.add(panel21);
		panel19.add(f2);
		panel19.add(panel20);
		panel19.add(textarea1);
		textarea1.setEditable(false);
		
		
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/		
		
	//Rajoute dans la fenetre des panel1 et panel2(partie haut+partie bas)
		frame.add(panel1, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.CENTER); 

/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/
	//Fonctionnement des bouton:
	
	//Fontionnement du bouton1 (b1)
		b1.setMnemonic(KeyEvent.VK_ENTER);//alt+entrer pour accèder directement à la commande
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					frameimage.dispose();
					Entrer entrer=new Entrer(f1.getText());
					if(entrer.comdCorrect()) {
						l9.setText("");
						dossier.setVisible(true);
						panel19.setVisible(true);
						f2.setText("");
						
						model = new DefaultListModel<>();
						adresse=entrer.adresseDossier();
						if(entrer.tailleL()==1) {
							textarea.setVisible(false);
							textarea1.setVisible(false);
							model.addElement(entrer.adresseLastElt(entrer.eltListe(0)));
							
							dossier.setModel(model);
						    panel16.add(dossier, BorderLayout.CENTER);
						    panel18.add(panel19, BorderLayout.CENTER);
						    
						} else {
						for(int i=0; i<entrer.tailleL();i++) {
							model.addElement(entrer.eltListe(i));
						}
						 textarea.setVisible(false);
						 textarea1.setVisible(false);
					     dossier.setModel(model);
					     panel16.add(dossier, BorderLayout.CENTER);
					     panel18.add(panel19, BorderLayout.CENTER);
					     
					}
				}
					
				
				
			} catch (ErreurException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					l9.setText("L'entrer n'est pas correct, veuillez changer l'Adresse");
					dossier.setVisible(false);
					panel19.setVisible(false);
					textarea.setVisible(false);
				}
				
			}
			});
		
	//Fonctionnement du bouton2 (b2)
		b2.setMnemonic(KeyEvent.VK_R);//alt+r pour accèder directement à la commande
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b2) {
					JFileChooser fileChoose= new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
					fileChoose.showOpenDialog(null);
					fileChoose.setDialogTitle("Selectionnez une image");
				    fileChoose.setAcceptAllFileFilterUsed(false);
				    FileNameExtensionFilter filter = new FileNameExtensionFilter("Images JPEG et PNG", "jpeg", "png");
				    fileChoose.addChoosableFileFilter(filter);
				    int res = fileChoose.showOpenDialog(null);
				    if (res == JFileChooser.APPROVE_OPTION) {
				      f1.setText(fileChoose.getSelectedFile().getPath());
				    }
				}
				
			}
			
			
		});
		
		//Affiche toutes les Métadonnées d'un fichier selectionner dans la JList
		dossier.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				Menu.add(lecteurimage);
				textarea.setVisible(true);
				String ad= adresse+"\\"+dossier.getSelectedValue();
				File newFichier= new File(adresse);
				if(newFichier.isDirectory()) {
					//System.out.println("la");
					//System.out.println(adresse+"\\"+dossier.getSelectedValue());
					try {
						Metadonnees m1=new Metadonnees(adresse+"\\"+dossier.getSelectedValue());
						//System.out.println(m1.tostring());
						textarea.setText(m1.tostring());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
					
				}else {
					//System.out.println(adresse);
					try {
						Metadonnees m1=new Metadonnees(adresse);
						//System.out.println(m1.tostring());
						textarea.setText(m1.tostring());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
			
		});
		
		//Afficher le message cacher dans l'image(Lecture)
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String ad= adresse+"\\"+dossier.getSelectedValue();
				File newFichier= new File(adresse);
				if(newFichier.isDirectory()) {
					try {
						steg1= new SteganoLecture(ad);
						textarea1.setText(steg1.toString());
						textarea1.setVisible(true);
						f2.setText("");
						steg1 = null;
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
					
					}
				}else {
					try {
						steg1= new SteganoLecture(adresse);
						textarea1.setText(steg1.toString());
						textarea1.setVisible(true);
						f2.setText("");
						steg1 = null;
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						
					}
				}
				
			}
			
		});
		
		//Insere un message cacher dans l'image (Insertion)
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String ad= adresse+"\\"+dossier.getSelectedValue();
				File newFichier= new File(adresse);
				if(newFichier.isDirectory()) {
					try {
						steg = new steganographie1(ad, f2.getText());
						textarea1.setText("Message inserer");
						textarea1.setVisible(true);
						f2.setText("");
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						textarea1.setText("Le message n'a pas été inseré");
						textarea1.setVisible(true);
						f2.setText("");
					}
				}else {
					try {
						steg = new steganographie1(adresse, f2.getText());
						textarea1.setText("Message inserer");
						textarea1.setVisible(true);
						f2.setText("");
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						textarea1.setText("Le message n'a pas été inseré");
						textarea1.setVisible(true);
						f2.setText("");
					}
				}
				
			}
			
		});
				 
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/		
	//Menu:
	menuBar.add(Menu);
	Menu.setForeground(Color.WHITE);
	Menu.setMnemonic(KeyEvent.VK_M);//alt+m pour accèder directement à la commande
	menuBar.setBackground(Color.BLACK);
	Menu.add(newframe);
	Menu.add(helpMenu);
	Menu.add(quitMenu);
	
	
	//Ouvre une nouvelle fenetre de l'Application
	newframe.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new InterfaceGUI();
		}
		
	});
	
	
	//Affiche la notice dans une nouvelle fenetre(framehelp)
	helpMenu.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Help h= new Help();
			textareahelp.setText(h.toString());
			panel26.setLayout(new GridLayout(1,1));
			textareahelp.setEditable(false);
			textareahelp.setFont(new Font(textareahelp.getFont().getName(), textareahelp.getFont().getStyle(), textareahelp.getFont().getSize()-4));
			panel26.add(textareahelp);
			framehelp.add(panel26);
			framehelp.setSize(580, 450);
			framehelp.setVisible(true);
		}
		
	});
	
	//Ferme toutes les fenetres
	quitMenu.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			frame.dispose();
			framehelp.dispose();
			frameimage.dispose();
			
		}
		
	});
	
	//Ouvre un nouvelle fenetre avec l'image(frameimage)
	lecteurimage.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			File f= new File(adresse);
			if(!f.isDirectory()) {
				
				imageicon.setIcon(new ImageIcon(adresse));
				try {
					Metadonnees metaI= new Metadonnees(adresse);
					largueur=metaI.largueur();
					longueur=metaI.longueur();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					
				}
			}else {
				
				imageicon.setIcon(new ImageIcon(adresse+"\\"+dossier.getSelectedValue()));
				try {
					Metadonnees metaI= new Metadonnees(adresse+"\\"+dossier.getSelectedValue());
					largueur=metaI.largueur();
					longueur=metaI.longueur();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					
				}
			}
			panel27.setLayout(new GridLayout(1,1));
			panel27.add(imageicon);
			frameimage.add(panel27);
			
			frameimage.setLocationRelativeTo(null);
			frameimage.setSize(largueur+30, longueur+30);
			frameimage.setVisible(true);
		}
		
	});
	
	
	
	menuBar.setVisible(true);
	frame.setJMenuBar(menuBar);
		
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/	
	//Rajout d'un icon de la fenetre
	
	
	//Donne la taille de la fenetre
	frame.setSize(690,500);
	    
	//Organisation de la fenetre principale (frame)
	frame.setLayout(new GridLayout(2,1));
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	//Methode qui affiche la fenetre à l'écran
	frame.setVisible(true);
	
	}
	
/*-------------------------------------------------------------------------------------------------------------------------------------------------------*/		
	//Fonction Main:
	
	public static void main(String[] args) {
		new InterfaceGUI();
	}
}