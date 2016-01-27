package invoker;

import java.util.Observer;

import receiver.Pair;

/**
 * Interface de IHM
 * 
 * Elle dispose de 3 méthodes, utilisées pour recuperer les informations sur l'état courant de l'IHM
 * 
 * @author sibrihen naliche
 * @version 1.0
 */

public interface IHM extends Observer{
	
	/** 
	 * Retourne le dernier caractère saisi au clavier
	 * 
	 * @return le dernier caractere saisi
	 */
	public char getChar();
	
	/** 
	 * Retourne les coordonnées de la selection courante 
	 * 
	 * @return le pair contenant la position de début et de la fin de la selection
	 */
	public Pair getSelection();
	
	
	/** 
	 * Retourne la position actuelle du curseur de saisie
	 * 
	 * @return entier > 0, position actuelle  du curseur
	 */
	public int getCursorPosition();
	
	/** 
	 * Modifie la selection courante du champ de saisie
	 * 
	 * @param selection la nouvelle selection
	 */
	public void setSelection(Pair selection);
	
}
