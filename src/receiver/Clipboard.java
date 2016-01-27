package receiver;

/**
 * Classe représentant le presse-papiers, elle stocke le texte selectionné apres une commande Copy
 *
 * @author sibrihen naliche
 * @version 1.0
 */
public class Clipboard {
	
	// Contenu actuel du presse-papiers
	private String text;
	
	// Engine associé au presse-papiers
	private EngineImpl attachedEngine;
	
	/** 
	 * Constructeur de classe, associe l'engine passé en paramètre, et initialise le contenu du presse-papiers a vide
	 * 
	 * @param engine l'engine a associer aux presse-papiers
	 */
	public Clipboard(EngineImpl engine) {
		this.text = new String();
		this.attachedEngine = engine;
	}
	
	public Clipboard() {
		this.text = new String();
	}
	
	/** 
	 * Recupère le contenu actuel du presse-papiers
	 * 
	 * @return le contenu actuel du presse-papiers
	 */
	public String getText() {
		 return this.text;
	}
	
	/** 
	 * Met a jour le contenu actuel du presse-papiers
	 * 
	 * @param le nouveau contenu du presse-papiers
	 */
	public void setText(String text) {
		 this.text = text;
	}
}
