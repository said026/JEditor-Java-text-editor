package client;

import java.util.HashMap;

import javax.security.auth.kerberos.DelegationPermission;

import command.*;
import invoker.*;
import memento.*;
import receiver.*;

/**
 * Classe représentant le client, il joue le role de configurateur
 * 
 * Elle instancie les commandes et les passe en paramètre a l'IHM
 * 
 * @author sibrihen naliche
 * @version 1.0
 */
public class Client {

    public static void main(String[] args) throws Exception {
    	
    	// Création du moteur
        Engine engine = new EngineImpl();      
    	
    	// Création du recorder
    	
    	Recorder recorder = new Recorder(engine);
    	
        // Création des commandes
        Copy copy = new Copy(engine, recorder);
        Cut recCut = new Cut(engine, recorder);
        Paste recPaste = new Paste(engine, recorder);
        Insert recInsert = new Insert(engine, recorder);
        Delete recDelete = new Delete(engine, recorder);
        
        Undo undo = new Undo(recorder);
        Redo redo = new Redo(recorder);
        

        // Création de l'IHM, avec les commandes et l'engine passées en paramètre
        IHM ihm = new IHMImpl(copy, recPaste, recCut, recInsert, recDelete, undo, redo, engine);
       
        
        // Ajout de l'IHM en tant qu'observer du Buffer
        engine.getBuffer().addObserver(ihm);
    }
}
