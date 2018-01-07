package wsnhenshin;


import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.eclipse.core.internal.resources.Resource;;

public class Main {

	public static final String PATH = "src/wsnhenshin/"; //"modeling"
	
	public static void run(String path, boolean saveResult) {
		HenshinResourceSet resourceSet = new HenshinResourceSet(path);
		Module module = resourceSet.getModule("model/wsn.henshin", false);
		Resource model = (Resource) resourceSet.getResource("xmi/WSN_empty.xmi");
		
		Engine engine= new EngineImpl();
		EGraph graph = new EGraphImpl();
		
		UnitApplication createAccountApp = new UnitApplicationImpl(engine);
		createAccountApp.setEGraph(graph);
		
		if (saveResult) {
			resourceSet.saveEObject(graph.getRoots().get(0), "xmi/example-result.xmi");
			System.out.println("Saved result file.");
		}
	}
	
	public static void main(String[] args) {
		run(PATH, true);
	}

}
