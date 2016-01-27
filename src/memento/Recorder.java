package memento;

import java.util.Stack;


import receiver.Engine;

/**
 * Classe Recorder, eenregistre des EngineMemento et s'occupe de la fonction "faire/défaire"
 *
 * @author sibrihen naliche
 * @version 1.0
 */
public class Recorder {
	
	// Pile contenant les Mementos déja faits
	private Stack<EngineMemento> doneMementos;
	
	// Pile contenant les Mementos défaits
	private Stack<EngineMemento> undoneMementos;
	
	// Memento stockant l'etat courant de l'Engine
	private EngineMemento currentMemento;
	
	// Engine associé au Recorder
	private Engine engine;
	
	/** 
	 * Constructeur de classe
	 * 
	 * @param engine l'Engine a associer au Recorder
	 */
	public Recorder(Engine engine) {
		this.engine = engine;
		this.doneMementos = new Stack<EngineMemento>();
		this.undoneMementos = new Stack<EngineMemento>();
		this.initialize();
	}
	
	/**
	 * Annule une commande effectue si la pile doneMementos n'est pas vide
	 * 
	 */
	public void undo() {
		if(!this.doneMementos.isEmpty()) {
			if(this.undoneMementos.isEmpty()) {
				this.undoneMementos.push(this.engine.getMemento());
			}
			this.engine.setMemento(this.currentMemento);
			this.undoneMementos.push(this.currentMemento);
			this.currentMemento = this.doneMementos.pop();
		}
	}
	
	/**
	 * Rétablit une commande effectue si la pile doneMementos n'est pas vide
	 * 
	 */
	public void redo() {
		if(this.undoneMementos.size() > 1) {
			this.doneMementos.push(this.currentMemento);
			this.currentMemento = this.undoneMementos.pop();
			this.engine.setMemento(this.undoneMementos.peek());
		}
	}
	
	/**
	 * Initialise l'etat currentMemento
	 * 
	 */
	public void initialize() {
		this.currentMemento = this.engine.getMemento();
	}
	
	/**
	 * Sauvegarde un etat de l'Engine avant qu'uen commande soit executée
	 * 
	 */
	public void saveEngine() {
		this.doneMementos.push(this.currentMemento);
		this.currentMemento = this.engine.getMemento();
		this.undoneMementos = new Stack<EngineMemento>();
	}
	
	/**
	 * Getters et Setters pour les tests
	 */
	
	public EngineMemento getcurrentMemento() {
		return currentMemento;
	}
	
	public void setcurrentMemento(EngineMemento currentMemento) {
		this.currentMemento = currentMemento;
	}
	
	public Stack<EngineMemento> getundoneMementos() {
		return undoneMementos;
	}
	
	public void setundoneMementos(Stack<EngineMemento> undoneMementos) {
		this.undoneMementos = undoneMementos;
	}
	
	public Stack<EngineMemento> getdoneMementos() {
		return doneMementos;
	}
	
	public void setdoneMementos(Stack<EngineMemento> doneMementos) {
		this.doneMementos = doneMementos;
	}
}
