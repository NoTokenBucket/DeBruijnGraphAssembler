package com.baidu.Graphs;

import java.util.ArrayList;
import java.util.Collections;

public class Graph {
	private ArrayList<Vertice> VerticeList;


	private ArrayList<Edge> EdgeList;

	public Graph(ArrayList<Vertice> VerticeList,ArrayList<Edge> EdgeList){
		this.VerticeList = VerticeList;
		this.EdgeList = EdgeList;
	}

	public void addVertice(Vertice v){
		VerticeList.add(v);
	}

	public void addEdge(Edge e){
		if (!VerticeList.contains(e.getV1())){
			this.addVertice(e.getV1());
		}
		if (!VerticeList.contains(e.getV2())){
			this.addVertice(e.getV2());
		}
		EdgeList.add(e);
	}

	public ArrayList<Integer> getValensSprektrum(){
		ArrayList s = new ArrayList<Integer>(this.getVerticeCount());
		for (Vertice v: this.VerticeList){
			Integer counter = 0;
			for (Edge e: this.EdgeList)	{
				if ((e.getV1()== v) || (e.getV2()== v)){
					counter += 1;
				}

			}
			s.add(counter);
		}
		Collections.sort(s, Collections.reverseOrder());
		return s;
	}

	//public String getValensSprektrumAsString(){

	//}

	public ArrayList<Edge> getEdgeList() {
		return EdgeList;
	}
	public ArrayList<Vertice> getVerticeList() {
		return VerticeList;
	}

	public static boolean canMakeGraph(ArrayList<Integer> valSpek){
		Integer uneven = 0;
		for (Integer i: valSpek){
			uneven += i%2;
		}
		return (uneven%2==0);
	}

	public Integer getVerticeCount(){
		return VerticeList.size();
	}

	public Integer getEdgeCount(){
		return EdgeList.size();
	}


}
