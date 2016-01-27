package invoker;

import command.Command;
import command.Copy;
import command.Cut;
import command.Insert;
import command.Paste;
import receiver.Buffer;
import receiver.Engine;
import receiver.EngineImpl;
import receiver.Pair;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Classe représentant notre IHM, elle joue deux roles dans le diagramme de classes : Invoker et Observer
 * 
 * Elle affiche le champ de saisie et les boutons de commande : Copy, Paste et Cut
 * 
 * @author sibrihen naliche
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IHMImpl extends JFrame implements IHM , Observer{
	
	// Commandes utilisées par l'IHM
	private Engine engine;
	
	private Command copy;
	
	private Command paste;
	
	private Command cut;
	
	private Command insert;
	
	private Command delete;
	
	private Command undo;
	
	private Command redo;
	
	// Conteneur des element graphiques
	private JPanel container;
	
	// Champ de saisie du texte
	private JTextArea textArea;
	
	// Les boutons pour executer les différentes commandes
	private JButton copyButton;
	
	private JButton pasteButton;
	
	private JButton cutButton;
	
	private JButton undoButton;
	
	private JButton redoButton;
	
	
	// Variable contenant le dernier caractère saisi au clavier
	private char currentChar;
	
    /**
     * Constructeur IHMImpl
     * 
     * @param copy commande de copie de texte
     * @param paste commande de collage de texte
     * @param cut commande coupage de texte
     * @param insert commande d'insertion de texte
     * @param delete commande de suppression de texte 
     * @param engine moteur associé a l'IHM
     */
	public IHMImpl(Command copy, Command paste, Command cut, final Command insert, final Command delete, Command undo, Command redo, Engine engine) {
		
		// Initialisation des attributs
		this.engine = engine;
		this.copy = copy;
		this.paste = paste;
		this.cut = cut;
		this.insert = insert;
		this.delete = delete;
		this.undo = undo;
		this.redo = redo;
		this.currentChar = ' ';
		
		// Association ihm-commandes
        copy.setIHM(this);
        paste.setIHM(this);
        cut.setIHM(this);
        insert.setIHM(this);
        delete.setIHM(this);
        
		// Création des éléments graphiques
		this.container = new JPanel();
		this.textArea = new JTextArea(30, 50);
		this.copyButton = new Button("Copy", this.copy);
		this.pasteButton = new Button("Paste", this.paste);
		this.cutButton = new Button("Cut", this.cut); 
		
		this.undoButton = new Button("Undo", this.undo);
		this.redoButton = new Button("Redo", this.redo);
		
		this.setTitle("Mini editor v2");
	    this.setSize(600, 600);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    container.setLayout(new BorderLayout());
	    
	    textArea.getCaret().setVisible(true);
	    
	    container.add(textArea, BorderLayout.PAGE_START);
	    
        container.add(copyButton, BorderLayout.LINE_START);
        copyButton.setPreferredSize(new Dimension(200, 50));
        
        container.add(pasteButton, BorderLayout.CENTER);
        pasteButton.setPreferredSize(new Dimension(200, 50));
        
        container.add(cutButton, BorderLayout.LINE_END);
        cutButton.setPreferredSize(new Dimension(200, 50));
        
        // Container pour les boutons de la V3
        JPanel container2 = new JPanel();
        container2.setLayout(new BorderLayout());
        
        // Paramétrage du bouton Undo
        container2.add(undoButton, BorderLayout.LINE_START);
        cutButton.setPreferredSize(new Dimension(200, 50));
       
        // Paramétrage du bouton Redo
        container2.add(redoButton, BorderLayout.LINE_END);
        cutButton.setPreferredSize(new Dimension(200, 50));
    
        container.add(container2, BorderLayout.PAGE_END);
        
        // Lancement de l'interface graphique
        
        this.setContentPane(container);
        this.setVisible(true);
        		
        // Gestion du clavier
        textArea.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				 // Annule le comportement par défaut
			     e.consume();
			     
				// Cas de la saisie d'un caractere ou de la touche "ENTER"				 
				if (e.getKeyChar() != '\b') {
					currentChar = e.getKeyChar();
					System.out.println(currentChar);
					insert.execute();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// Si la touche est un caractère "normal"
				if (!e.isActionKey()) {
					// Annule le comportement par défaut
					e.consume(); 
					if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						delete.execute();
					}
				}
			}
		});
	}
	
	/** 
	 * Retourne le dernier caractère saisi au clavier
	 * 
	 * @return le dernier caractere saisi
	 */
	public char getChar() {
		return currentChar;
	}
	
	/** 
	 * Retourne les coordonnées de la selection courante 
	 * 
	 * @return le pair contenant la position de début et de la fin de la selection
	 */
	public Pair getSelection() {
		return (new Pair(textArea.getSelectionStart(), textArea.getSelectionEnd()));
	}
	
	/** 
	 * Retourne la position actuelle du curseur de saisie
	 * 
	 * @return entier > 0, position actuelle du curseur
	 */
	public int getCursorPosition(){
		return textArea.getCaretPosition();
	}
	
	public void setSelection(Pair selection) {
		textArea.setSelectionStart(selection.getStart());
		textArea.setSelectionEnd(selection.getEnd());
	}
	/** 
	 *  Méthode appelée automatiquement lors d'un changement d'état du Buffer
	 * 
	 * @param o l'objet observé, le buffer dans notre cas
	 * @param obj argument passé par la méthode notifyObservers
	 */
	@Override
	public void update(Observable o, Object obj) {
        if(o instanceof Buffer) {       
        		Buffer buffer = (Buffer) o;
        		// On met a jour le texte et la position du curseur
        		textArea.setText(buffer.getText());
        		textArea.setCaretPosition(buffer.getCaretPosition());
        		textArea.requestFocusInWindow();
        }     
	}
}

