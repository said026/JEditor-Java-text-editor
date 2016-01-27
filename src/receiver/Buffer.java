package receiver;

import java.util.Observable;

/**
 * Classe représentant le Buffer, il stocke le texte saisi au clavier
 * 
 * Elle des fonctions d'édition de texte (insertion, suppression)
 * 
 * @author sibrihen naliche
 * @version 1.0
 */
public class Buffer extends Observable{
	
	// Zone de stockage de texte, editable
	private StringBuffer text;
	
	// L'engine associé au Buffer
	private Engine attachedEngine;
	
	// Position courante du curseur
	private int caretPosition;

	/** 
	 * Constructeur de classe, associe le Buffer a l'engine passé en paramètre. et initialise le buffer a vide 
	 * 	
	 * @param engine l'engine a associer avec la commande
	 */
	public Buffer(Engine engine) {
		this.text = new StringBuffer();
		this.attachedEngine = engine;
		this.caretPosition = 0;
	}
	
	public Buffer() {
		this.text = new StringBuffer();
		this.caretPosition = 0;
	}
	
	/** 
	 * Recupère le texte contenu dans le buffer 
	 * 
	 * @return chaine contenant le texte actuel du buffer
	 */
	public String getText() {
		return this.text.toString();
	}
	
	/** 
	 * Ajoute la chaine passé en paramètre au buffer
	 * 
	 * @param toAdd chaine a ajouter au buffer
	 * @param position la position a partir de laquelle le texte sera ajoutée
	 */
	public void addText(String toAdd,int position) {
		this.text.insert(position,toAdd);
		this.caretPosition = position + toAdd.length();
		notifyIHM();
	}
	
	/** 
	 * Ajoute le caractère passé en paramètre a la fin du buffer
	 * 
	 * @param toAdd caractère a ajouter au buffer
	 * @param position la position a laquelle le caractere sera inséré
	 */
	public void addCar(char newChar, int position) {
		this.text.insert(position, newChar);
		this.caretPosition = position;
		this.caretPosition++;
		notifyIHM();
	}
	
	/** 
	 * Supprime le texte correspondant aux coordonnées passées en paramètre
	 * 
	 * @param position le Pair contenant le début et la fin de la selection a supprimer du buffer
	 */
	public void deleteText(Pair position) {
		int start = position.getStart();
		int end = position.getEnd();
		
		if (getLength() > 0 && end > 0) {
			if (start == end) {
				this.text.delete(start-1, end);
				this.caretPosition--;
			} else {
				this.text.delete(start, end);
				this.caretPosition = start;
				
			}
			notifyIHM();
		}
	}
	
	/** 
	 * Retourne la longueur actuelle du buffer
	 * 
	 * @param retourne l'entier représentant la longueur actuelle du Buffer
	 */
	public int getLength() {
		return text.length();
	}
	
	/** 
	 * Retourne la position actuelle du curseur
	 * 
	 * @param retourne l'entier représentant la position actuelle du curseur
	 */
	public int getCaretPosition() {
		return this.caretPosition;
	}
	
	
	/** 
	 * Retourne la selection associée au Pair passé en paramètre
	 * 
	 * @param selection contenant le début et la fin de la selection
	 */
	public String getSelectedText(Pair selection) {
		return this.text.substring(selection.getStart(), selection.getEnd());
	}
	
	public void setText(String newText){
		this.text = new StringBuffer(newText);
		this.caretPosition = text.length();
		notifyIHM();
	}
	
	/** 
	 * Méthode permettant de notifier l'IHM lors d'un changement du contenu du buffer
	 * 
	 */
	public void notifyIHM() {
		// Changement de l'état actuel
		setChanged();
		// Notifie les observateur
		notifyObservers();
	}
}
