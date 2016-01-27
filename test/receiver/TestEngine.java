package receiver;

import static org.junit.Assert.*;

import org.junit.Test;
import receiver.*;

/**
 * Classe de test de l'Engine
 * 
 * Elle teste les différentes fonctionnalités de l'Engine
 * 
 * @author sibrihen naliche
 * @version 1.0
 */

public class TestEngine {
	
	Engine engine = new EngineImpl();  
	
	// Test de l'installation du Buffer
	@Test 
	public void testInit() {
		assertTrue(engine.getBuffer().getLength() == 0);
	}
	
	// Test de l'ajout de caracteres dans le buffer
	@Test
	public void testInsertText() {
		engine.insert('a', 0);
		engine.insert('b', 1);
		engine.insert('c', 2);
		
		assertTrue(engine.getBuffer().getLength() == 3);
	}
	
	// Test de la fonction Copy du Moteur
	@Test
	public void testCopy() {
		engine.insert('a', 0);
		engine.insert('b', 1);
		engine.insert('c', 2);
		
		Pair toCopy = new Pair(0,3);
		engine.copy(toCopy);
		
		// On teste si le contenu du presse papiers est correct
		assertTrue(engine.getClipboardText().equals("abc"));
	}
	
	// Test de la fonction copie
	@Test
	public void testCut(){
		engine.insert('a', 0);
		engine.insert('b', 1);
		engine.insert('c', 2);
		
		Pair toCut = new Pair(0,3);
		engine.cut(toCut);
		
		assertTrue(engine.getBuffer().getText().equals(""));
	}
	
	// Test de la fonction Paste apres la fonction Copy
	@Test
	public void testCopyPaste(){
		engine.insert('a', 0);
		engine.insert('b', 1);
		engine.insert('c', 2);
		
		Pair toCopy = new Pair(0,3);
		engine.copy(toCopy);
		engine.paste(3);
		
		assertTrue(engine.getBuffer().getText().equals("abcabc"));
	}
	
	// Test de la fonction Paste apres la fonction Cut
	@Test
	public void testCutPaste(){
		engine.insert('a', 0);
		engine.insert('b', 1);
		engine.insert('c', 2);
		
		Pair toCut = new Pair(0,3);
		engine.cut(toCut);
		engine.paste(0);
		
		assertTrue(engine.getBuffer().getText().equals("abc"));
	}
	
	@Test
	public void testDelete(){
		engine.insert('a', 0);
		engine.insert('b', 1);
		engine.insert('c', 2);
		
		Pair toDelete = new Pair(0,3);
		engine.delete(toDelete);
		
		assertTrue(engine.getBuffer().getText().equals(""));
	}
	
}
