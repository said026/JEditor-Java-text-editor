package command;

import memento.Recorder;
import invoker.IHM;

/**
 * Classe Undo effectuant la commande défaire
 * 
 * @author sibrihen naliche
 * @version 1.0
 */
public class Undo implements Command{
	
	// L'ihm associée a la commande 
	private IHM ihm;
	
	// L'enregistreur associée a la commande 
	private Recorder recorder;
	
	/** 
	 * Constructeur de la classe
	 * 
	 * @param recorder l'enregistreur a associer avec la commande
	 */
	public Undo(Recorder recorder) {
		this.recorder = recorder;
	}
	
	/** 
	 * Execute la commande associée, en faisant appel a l'enregistreur
	 * 
	 */
	@Override
	public void execute() {
		recorder.undo();	
	}

	
	/** 
	 * Affecte une ihm a la commande
	 * 
	 * @param ihm l'ihm a associer a this
	 */
	@Override
	public void setIHM(IHM ihm) {
		this.ihm = ihm;
	}

}