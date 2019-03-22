package com.longnd.parser.plugin.binding;
import java.io.File;
import java.nio.file.Paths;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

public class ScriptRunning extends Binding {
	
	GroovyClassLoader loadDer;
	GroovyShell sell;
	static File file;
	
	public static void main(String[] args) {
		ScriptRunning script = new ScriptRunning();
		script.sell = new GroovyShell();
		try {
			String path = Paths.get(".").toAbsolutePath().normalize().toString();
			ScriptRunning.file = new File(path + "\\src\\com\\longnd\\parser\\plugin\\src\\allied_telesis\\allied_telesis.groovy");
			System.out.println(file.exists() + "" + path);
			
			Script src =  script.sell.parse(file);
			Binding blinding = src.getBinding();
			//Object attributes = src.getProperty("attributes");
			
			System.out.println(blinding.getVariables() + "" + blinding);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("wrong path");
		}
		
		
	}
	
	

}
