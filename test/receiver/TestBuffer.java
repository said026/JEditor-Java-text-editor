package receiver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de test du Buffer
 * 
 * Elle teste les différentes fonctionnalités du Buffer
 * 
 * @author sibrihen naliche
 * @version 1.0
 */

public class TestBuffer {
	
	private Buffer buffer;
	private EngineImpl engine;
	
	@Before  
	public void initBuffer() {
		engine = new EngineImpl();
		buffer = new Buffer(engine);
	}
	
	// Test de l'initialisation du Buffer
	@Test
	public void testInit() {
		assertEquals(0, buffer.getLength());
	}
	
	// Test d'ajout d'un seul caractere dans le Buffer
	@Test
	public void testAddCar() {
		char toAdd = 'a';
		buffer.addCar(toAdd, 0);
		
		assertEquals(1, buffer.getLength());
	}
	
	// Test d'ajout de plusieurs caracteres dans le Buffer
	@Test
	public void testaddText() {
		String toAdd = "abc";
		buffer.addText(toAdd, 0);
		
		assertEquals(3, buffer.getLength());
	}
	
	// Test de la fonction de récuperation de texte
	@Test
	public void testGetText() {
		String toAdd = "abc";
		buffer.addText(toAdd, 0);
		
		assertTrue(toAdd.equals(buffer.getText()));
	}
	
	// Test de la fonction de suppression d'un seul caractere
	@Test
	public void testDeleteTextv1() {
		char toAdd = 'a';
		buffer.addCar(toAdd, 0);
		
		int oldLength = buffer.getLength(); 
		Pair toDelete = new Pair(0, 1);
		buffer.deleteText(toDelete);
		
		assertTrue(oldLength > buffer.getLength());
	}
	
	// Test de la fonction de suppression de plusieurs caracteres 
	@Test
	public void testDeleteTextv2() {
		String toAdd = "abc";
		buffer.addText(toAdd, 0);
		
		Pair toDelete = new Pair(0, 3);
		buffer.deleteText(toDelete);
		
		assertTrue(buffer.getLength() == 0);
	}
	
	// Test de la récuperation de la position du curseur
	@Test
	public void testGetCaretPosition() {
		String toAdd = "abc";
		buffer.addText(toAdd, 0);
		
		System.out.println(buffer.getCaretPosition());
		assertEquals(3, buffer.getCaretPosition());
	}
	
	// Test de la fonction de recuperation d'une selection depuis le Buffer
	@Test
	public void testGetSelectedText() {
		String toAdd = "abc";
		buffer.addText(toAdd, 0);
		
		String expectedSelection = "c";
		Pair selection = new Pair(2,3);
		
		assertTrue(expectedSelection.equals(buffer.getSelectedText(selection)));;
	}
}
