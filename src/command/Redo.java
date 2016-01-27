package command;

import memento.Recorder;
import invoker.IHM;

/**
 * Classe Redo effectuant la commande défaire
 * 
 * @author sibrihen naliche
 * @version 1.0
 */
public class Redo implements Command{
	
	// L'ihm associée a la commande 
	private IHM ihm;
	
	// L'enregistreur associée a la commande 
	private Recorder recorder;
	
	/** 
	 * Constructeur de la classe
	 * 
	 * @param recorder l'enregistreur a associer avec la commande
	 */
	public Redo(Recorder recorder) {
		this.recorder = recorder;
	}
	
	/** 
	 * Execute la commande associée, en faisant appel a l'enregistreur
	 * 
	 */
	@Override
	public void execute() {
		recorder.redo();	
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