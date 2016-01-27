package command;

import invoker.IHM;

/**
 * Interface Command disposant des méthodes "execute" et "setIHM"
 * 
 * @author sibrihen naliche
 * @version 1.0
 */
public interface Command {
	
	/** 
	 * Méthode appelée par l'IHM, elle fait appel a l'engine
	 * 
	 */
	void execute();
	
	/** 
	 * Méthode pour associer l'IHM a la commande 
	 * 
	 * @param ihm l'ihm a associer a la commande
	 */
	void setIHM(IHM ihm);
}
