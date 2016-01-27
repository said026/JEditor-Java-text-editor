package receiver;

/**
 * Classe représentant un Pair contenat le début et la fin d'une selection
 * 
 * @author sibrihen naliche
 * @version 1.0
 */
public class Pair {
	
	// Entier représentant le début d'une selection
	private int start;
	
	// Entier représentant la fin d'une selection
	private int end;
	
	/** 
	 * Constructeur de classe
	 * 
	 * @param start position de début de selection
	 * @param end position de fin de selection
	 */
	public Pair(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	/** 
	 * Met a jour la selection actuelle
	 * 
	 * @param start nouvelle position de début de selection
	 * @param end nouvelle position de fin de selection
	 */
	public void setPair(Pair newPair) {
		 this.start = newPair.start;
		 this.end = newPair.end;
	}
	
	/** 
	 * Recupere le début de la selection actuelle
	 * 
	 * @return position de début de selection
	 */
	public int getStart() {
		 return this.start;
	}
	
	/** 
	 * Recupere la fin de la selection actuelle
	 * 
	 * @return position de fin de selection
	 */
	public int getEnd() {
		return this.end;
	}
	
	@Override
	public String toString() {
		return "Start: " + start + ", End: " + end;
	}
}
