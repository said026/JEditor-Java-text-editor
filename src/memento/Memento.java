package memento;

import receiver.Buffer;
import receiver.Clipboard;

/**
 * Interface Memento
 * 
 * @author sibrihen naliche
 * @version 1.0
 */

public interface Memento {
	
	/** 
	 * Recupère le buffer associé au Memento
	 * 
	 * @return le buffer associé a l'engine
	 */
	public Buffer getBuffer();

	/** 
	 * Affecte un Buffer au Memento
	 * 
	 * @return le nouveau Buffer
	 */
	public void setBuffer(Buffer buffer);

	/** 
	 * Recupère le Clipboard associé au Memento
	 * 
	 * @return le Clipboard associé a l'engine
	 */
	public Clipboard getClipboard();

	/** 
	 * Affecte un Clipboard au Memento
	 * 
	 * @return le nouveau Buffer
	 */
	public void setClipboard(Clipboard clipboard);
	
}
