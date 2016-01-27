package invoker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import command.Command;

/**
 * Classe représentant un bouton de l'IHM chargé d'exécuter une commande lorsqu'il reçoit un clic.
 * 
 * 
 */
@SuppressWarnings("serial")
public class Button extends JButton {
	
	private String name;

	/**
	 * Constructeur de la classe Bouton.
	 * 
	 * @param name le nom visible du bouton
	 * @param cmd la commande à exécuter lors d'un clic
	 */
	public Button(String name, final Command cmd) {
		super(name);
		this.name = name;
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cmd.execute();
			}
		});
	}
	
	/**
	 *Recupere le nom associé au bouton 
	 * 
	 * @return le nom associé au bouton 
	 */
	public String getName() {
		return name;
	}
}

