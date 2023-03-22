package com.baidu.Graphs;

public class Edge {
	private boolean directed;
	private Integer weight;


	private Vertice v1;
	private Vertice v2;

	public Edge(Vertice v1, Vertice v2){
		this.v1 = v1;
		this.v2 = v2;
		this.directed = false;
	}

	public Edge(Vertice v1, Vertice v2, Integer weight){
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
		this.directed = false;

	}

	public Edge(Vertice v1, Vertice v2, Integer weight, boolean directed){
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
		this.directed = directed;

	}

	boolean isDirected(){
		return directed;
	}

	public Vertice giveEndpoint(){
		if (isDirected()){
			return v2;
		} else {
			System.out.println("Has no end point");
			return new Vertice("Error");
		}
	}
	public Vertice getV1() {
		return v1;
	}

	public void setV1(Vertice v1) {
		this.v1 = v1;
	}

	public Vertice getV2() {
		return v2;
	}

	public void setV2(Vertice v2) {
		this.v2 = v2;
	}
}
