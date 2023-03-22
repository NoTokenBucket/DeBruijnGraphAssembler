package com.baidu.Drivers;

import com.baidu.Graphs.Edge;
import com.baidu.Graphs.Graph;
import com.baidu.Graphs.Vertice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Drive1 {

	private Graph g;
	private ArrayList<Edge> e;
	private ArrayList<Vertice> v;


	public Drive1() {
		this.v = new ArrayList<Vertice>();
		Vertice v1 = new Vertice("first");
		v.add(v1);
		Vertice v2 = new Vertice("second");
		v.add(v2);
		Vertice v3 = new Vertice("third");
		v.add(v3);
		this.e = new ArrayList<Edge>();
		Edge e1 = new Edge(v1, v2);
		e.add(e1);
		Edge e2 = new Edge(v2,v3);
		e.add(e2);
		this.g = new Graph(v,e);
	}

	public static void main(String[] args) throws IOException {
		Drive1 d = new Drive1();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome sir. Let me give you todays news:");
		System.out.println(String.format("The graph given to me is %s vertices long and connects with %s edges\nYou want to see the valence spectrum? [Y/N]",d.g.getVerticeCount(),d.g.getEdgeCount()));
		String ans = input.nextLine();

		if (ans.toUpperCase().contentEquals("Y")) {
			ArrayList<Integer> vSpek = d.g.getValensSprektrum();
			System.out.println("The valens spectrum for this graph is: "+vSpek.toString() + " and it works in theory? " + Graph.canMakeGraph(vSpek));
			vSpek.add(1);
			System.out.println("Can this spektrum make a graph: "+vSpek.toString() + ". " + Graph.canMakeGraph(vSpek) +" \nThat was all! See you!");

		}

		}
	}
