package main;

import WSN_Language.WSN_LanguageFactory;
import WSN_Language.WirelessSensorNetwork;
import WSN_Language.impl.WSN_LanguageFactoryImpl;

public class Main {
	public static void main(String[] args) {
		Simulation sim = new Simulation();
		WSN_LanguageFactory factory = new WSN_LanguageFactoryImpl();
		sim.loadXMI("instances/WirelessSensorNetwork.xmi");
		WirelessSensorNetwork wsn = sim.getWsn();
		
		sim.save();
	}
	
	
}