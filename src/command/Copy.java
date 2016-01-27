package command;

import invoker.IHM;
import memento.Recorder;
import receiver.Engine;

/**
 * Classe Copy effectuant la commande de copie
 * 
 * @author sibrihen naliche
 * @version 1.0
 */
public class Copy implements Command {
	
	// L'engine auquel la commande fait appel
	private Engine engine;
	
	// L'ihm associée a la commande
	private IHM ihm;
	
	private Recorder recorder;
	
	/** 
	 * Constructeur de la classe
	 * 
	 * @param engine l'engine a associer avec la commande
	 */
	public Copy(Engine engine, Recorder recorder) {
		this.engine = engine;
		this.recorder = recorder;
	}
	
	/** 
	 * Affecte une ihm a la commande
	 * 
	 * @param ihm l'ihm a associer a this
	 */
	public void setIHM(IHM ihm) {
		this.ihm = ihm;
	}
	
	/** 
	 * Execute la commande associée, en faisant appel a l'engine
	 * 
	 */
	@Override
	public void execute() {
		recorder.saveEngine();
		engine.copy(ihm.getSelection());
	}

}
