package main;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import WSN_Language.WSN_LanguagePackage;
import WSN_Language.WirelessSensorNetwork;

public class Simulation { 
	private  ResourceSet resSet;
	private WirelessSensorNetwork wsn;
	private Resource resource;
	
	public Simulation() {
		resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(ResourceFactoryRegistryImpl.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
	}

	public void loadXMI(String path) {

		WSN_LanguagePackage.eINSTANCE.getClass();

		File file = new File(path);
//		
//		if (!file.exists()) {
//			file = new File("instances/WSNSample.xmi");
//		}
//		
		
		resource = resSet.createResource(URI.createFileURI(file.getAbsolutePath()));

		try {
			resource.load(null);
			EObject loadedObject = resource.getContents().get(0);
			wsn = (WirelessSensorNetwork) loadedObject;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public WirelessSensorNetwork getWsn() {
		return wsn;
	}
	
	
	public void save() {
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
