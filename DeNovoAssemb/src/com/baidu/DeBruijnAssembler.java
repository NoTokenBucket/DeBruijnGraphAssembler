package com.baidu;

import javafx.util.Pair;

import java.util.*;


public class DeBruijnAssembler {

	public static String assemble(String text, Integer k, boolean print){
		//Modificer
		String ends = new String(new char[k-2]).replace("\0", "x");
		text = ends + "X" + text + "X" + ends;

		// Simuler sekventering
		ArrayList<String> reads = new ArrayList<String>(text.length()-k+1);
		String readPrint = "Udvundede k-mere: ";
		for (int i=0; i< text.length()-k+2;i++){
			reads.add(text.substring(i,i+k-1));
			readPrint += ", " + text.substring(i,i+k-1);
		}
		if (print == true) {
			System.out.println(readPrint + "\n");
		}
		//Konstruer de Bruijn graf
		Set vertices = new Set();
		ArrayList<Pair<String, String>> edges = new ArrayList<>();
		for (String read: reads){
			String v1 = read.substring(0,k-2);
			String v2 = read.substring(1,k-1);
			vertices.add(v1);
			vertices.add(v2);
			edges.add(new Pair(v1,v2));
		}
		Collections.shuffle(edges, new Random());
		//Find tilfældige ruter og deres sammenhængspunkter
		HashMap<ArrayList<Pair<String, String>>,String> routeJoint = new HashMap<>();
		Pair<String, Boolean> joint = new Pair("", true);
		Pair<String, String> cur_edge = new Pair<>("","");
		while (!edges.isEmpty()){
			if (joint.getValue() == true){
				/*Random rand = new Random();
				cur_edge = edges.get(rand.nextInt(edges.size()));*/
				cur_edge = findNext(ends, edges);
			} else {
				cur_edge = findNext(joint.getKey(), edges);
			}
			String start = cur_edge.getKey();
			ArrayList<Pair<String, String>> route = new ArrayList<>();
			//Hvis der ikke er flere kanter at følge eller startpunktet er nået, gem gåtur
			while (cur_edge.getValue() != start & cur_edge.getKey() != "None"){
				route.add(cur_edge);
				edges.remove(cur_edge); //CAREFULL
				cur_edge = findNext(cur_edge.getValue(), edges);
			}
			joint = findJoint(route,edges);
			routeJoint.put(route, joint.getKey());
		}
		//Lav ud og hjemtur
		boolean swtich = false;
		LinkedList<Pair<String, String>> masterRoute = new LinkedList<>();
		Stack<ArrayList<Pair<String, String>>> returnRoutes = new Stack<>();
		for (ArrayList<Pair<String, String>> route: routeJoint.keySet()){
			ArrayList<Pair<String, String>> returnRoute = new ArrayList<>();
			for (Pair<String, String> edge : route){
				if (edge.getKey() == routeJoint.get(route)){
					swtich = true;
				}
				if (swtich == true){
					returnRoute.add(edge);
				} else {
					masterRoute.add(edge);
				}
			}
			returnRoutes.add(returnRoute);
		}
		//Vend stack om og tilføj til superrouten
		for (ArrayList<Pair<String, String>> route : returnRoutes){
			for (Pair<String, String> edge : route){
				masterRoute.add(edge);
			}
		}
		//Gåtur
		String modSS = masterRoute.get(0).getKey();
		for (Pair<String, String> edge : masterRoute){
			modSS += edge.getValue().substring(k-3, k-2);
		}
		String SS = modSS.substring(k-1,modSS.length()-(k-1));
		return SS;
	}

	private static Pair<String, String> findNext(String vertice, ArrayList<Pair<String, String>> edges){
		for (Pair<String, String> edge: edges) {
				if (edge.getKey().contentEquals(vertice)) {
				return edge;
			}
		}
		return new Pair<>("None", "None");
	}

	private static Pair<String, Boolean> findJoint(ArrayList<Pair<String, String>> route, ArrayList<Pair<String, String>> edges){
		for (Pair<String, String> edge : route){
			Pair<String, String> x = findNext(edge.getValue(), edges);
			if (x.getKey() != "None"){
				return new Pair(x.getKey(), false);
			}
		}
		return new Pair(route.get(route.size()-1).getValue(),true);
	}

}
