package main;


import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.eclipse.core.internal.resources.Resource;;

public class Main {

	public static final String PATH = "modeling"; //"modeling"
	
	public static void run(String path, boolean saveResult) {
		HenshinResourceSet resourceSet = new HenshinResourceSet(PATH);
		Module module = resourceSet.getModule("model/wsn.henshin", false);
		Resource model = resourceSet.getResource("xmi/WSN_empty.xmi");
		
		Engine engine= new EngineImpl();
		EGraph graph = new EGraphImpl(model);
	}
	
	public static void main(String[] args) {
		
	}

}
