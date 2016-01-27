package receiver;

import memento.EngineMemento;

/**
 * Interface représentant le Moteur-Editeur, il effectue differentes opérations sur le buffer et le presse-papiers
 *
 * @author sibrihen naliche
 * @version 1.0
 */
public interface Engine {
	
	/** 
	 * Ajoute le contenu du presse-papiers au buffer, a la position passée en paramètre 
	 * 
	 * @param position la position dans le buffer a partir de laquelle le texte sera ajouté
	 */
	public void paste(int position);
	
	/** 
	 * Recupere la selection et l'enregistre dans le presse-papiers
	 * 
	 * @param toCopy Pair représentant le début et la fin de la chaine a copier 
	 */
	public void copy(Pair toCopy);
	
	/** 
	 * Recupere la selection l'enregistre dans le presse-papiers, et la supprime du buffer ensuite
	 * 
	 * @param toCut Pair représentant le début et la fin de la chaine a couper 
	 */
	public void cut(Pair toCut);
	
	/** 
	 * Ajoute un caractère a la fin du buffer
	 * 
	 * @param c le caractère a ajouter
	 * @param position la position a laquelle le caractere sera inséré
	 */
	public void insert(char c, int position);
	
	/** 
	 * Supprime la selection actuelle du buffer
	 * 
	 * @param toDelete Pair représentant le début et la fin de la chaine a supprimer du buffer 
	 */
	public void delete(Pair toDelete);
	
	/** 
	 * Recupère le buffer associé au Moteur
	 * 
	 * @return le buffer associé a l'engine
	 */
	public Buffer getBuffer();
	
	/** 
	 * Recupère la longeur du texte stocké dans le Buffer
	 * 
	 * @return la longeur du texte stocké dans le Buffer
	 */
	public int getLength();
	
	/** 
	 * Recupère la texte stocké dans le presse-papiers
	 * 
	 * @return la texte stocké dans le presse-papiers
	 */
	public String getClipboard();
	
	/** 
	 * Met a jour  la texte stocké dans le presse-papiers
	 * 
	 * @param text la texte a metre dans le presse-papiers
	 */
	public void setClipboard(String text);
	
	/** 
	 * Recupère le du texte stocké dans le Buffer
	 * 
	 * @return le texte stocké dans le Buffer
	 */
	public String getText();
	
	/** 
	 * Affecte un Memento a l'Engine
	 * 
	 */
	public void setMemento(EngineMemento m);
	
	/** 
	 * Recupère le Memento associé a l'Engine
	 * 
	 * @return le Memento associé a l'Engine
	 */
	public EngineMemento getMemento();
	
}
