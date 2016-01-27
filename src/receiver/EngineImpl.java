package receiver;

import memento.EngineMemento;

/**
 * Classe représentant le Moteur-Editeur, qui effectue differentes opérations sur le buffer et le presse-papiers
 *
 * @author sibrihen naliche
 * @version 1.0
 */
public class EngineImpl implements Engine {
	
	// Presse-papiers 
	private Clipboard clipboard;

	// Buffer 
	private Buffer buffer;
	
	/** 
	 * Recupere la selection et l'enregistre dans le presse-papiers
	 * 
	 * @param toCopy Pair représentant le début et la fin de la chaine a copier 
	 */
	public EngineImpl() {
		this.clipboard = new Clipboard(this);
		this.buffer = new Buffer(this);
	}
	
	/** 
	 * Recupere la selection et l'enregistre dans le presse-papiers
	 * 
	 * @param toCopy Pair représentant le début et la fin de la chaine a copier 
	 */
	public void copy(Pair toCopy) {
		clipboard.setText(buffer.getSelectedText(toCopy));
	}
	
	/** 
	 * Ajoute le contenu du presse-papiers au buffer, a la position passée en paramètre 
	 * 
	 * @param position la position dans le buffer a partir de laquelle le texte sera ajouté
	 */
	public void paste(int position) {
		buffer.addText(clipboard.getText(), position);
	}
	
	/** 
	 * Recupere la selection l'enregistre dans le presse-papiers, et la supprime du buffer ensuite
	 * 
	 * @param toCut Pair représentant le début et la fin de la chaine a couper 
	 */
	public void cut(Pair toCut) {
		clipboard.setText(buffer.getSelectedText(toCut));
		buffer.deleteText(toCut);
	}
	
	/** 
	 * Ajoute un caractère a la fin du buffer
	 * 
	 * @param c le caractère a ajouter
	 * @param position la position a laquelle le caractere sera inséré
	 */
	public void insert(char text, int position) {
		buffer.addCar(text, position);
	}
	
	/** 
	 * Supprime la selection actuelle du buffer
	 * 
	 * @param toDelete Pair représentant le début et la fin de la chaine a supprimer du buffer 
	 */
	public void delete(Pair toDelete) {
		buffer.deleteText(toDelete);
	}
	
	/** 
	 * Recupère le buffer associé au 
	 * 
	 * @return le buffer associé a l'engine
	 */
	public Buffer getBuffer(){
		return this.buffer;
	}
	
	/** 
	 * Recupère la longueur du texte stocké dans le Buffer
	 * 
	 * @return longueur du texte stocké dans le Buffer
	 */
	public int getLength() {
		return buffer.getLength();
	}
	
	/** 
	 * Recupère la texte stocké dans le presse-papiers
	 * 
	 * @return la texte stocké dans le presse-papiers
	 */
	public String getClipboard() {
		return this.clipboard.getText();
	}
	
	/** 
	 * Met a jour  la texte stocké dans le presse-papiers
	 * 
	 * @param text la texte a metre dans le presse-papiers
	 */
	public void setClipboard(String text) {
		this.clipboard.setText(text);
	}

	/** 
	 * Recupère le du texte stocké dans le Buffer
	 * 
	 * @return le texte stocké dans le Buffer
	 */
	public String getText() {
		return buffer.getText();
	}
	
	/** 
	 * Affecte un Memento a l'Engine
	 * 
	 */
	public void setMemento(EngineMemento m) {
		this.buffer.setText(m.getBuffer().getText());
		this.clipboard.setText(m.getClipboard().getText());
	}

	/** 
	 * Recupère le Memento associé a l'Engine
	 * 
	 * @return le Memento associé a l'Engine
	 */
	public EngineMemento getMemento() {
		EngineMemento m = new EngineMemento();
		Buffer copyBuffer = new Buffer();
		copyBuffer.setText(this.buffer.getText());
		Clipboard copyClipboard = new Clipboard(); 
		copyClipboard.setText(this.clipboard.getText());
		m.setBuffer(copyBuffer);
		m.setClipboard(copyClipboard);
		return m;
	}

}
