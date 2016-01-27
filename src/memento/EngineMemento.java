package memento;

import receiver.Buffer;
import receiver.Clipboard;

/**
 * Classe contenant l'état de l'Engine a un instant donné
 *
 * @author sibrihen naliche
 * @version 1.0
 */
public class EngineMemento implements Memento {
	
	// Buffer associé au Memento
	private Buffer buffer;
	
	// Presse-papiers associé au Memento
	private Clipboard clipboard;
	
	/** 
	 * Constructeur de classe
	 * 
	 */
	public EngineMemento() {
		this.buffer = new Buffer();
		this.clipboard = new Clipboard();
	}

	/** 
	 * Recupère le buffer associé au Memento
	 * 
	 * @return le buffer associé a l'engine
	 */
	public Buffer getBuffer() {
		return buffer;
	}

	/** 
	 * Affecte un Buffer au Memento
	 * 
	 * @return le nouveau Buffer
	 */
	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

	/** 
	 * Recupère le Clipboard associé au Memento
	 * 
	 * @return le Clipboard associé a l'engine
	 */
	public Clipboard getClipboard() {
		return clipboard;
	}

	/** 
	 * Affecte un Clipboard au Memento
	 * 
	 * @return le nouveau Buffer
	 */
	public void setClipboard(Clipboard clipboard) {
		this.clipboard = clipboard;
	}

}
