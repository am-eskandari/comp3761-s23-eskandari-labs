package com.example.comp3761s23eskandari.labs.lab07;

import java.util.ArrayDeque;
import java.util.Queue;

public class AdjGraph {

	private int matrix[][];
	private boolean directed = false;
	private int[] visited;

	public AdjGraph(int num) {
		matrix = new int[num][num];
	}

	public boolean isDirected() {
		return directed;
	}

	public void setDirected() {
		this.directed = true;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int[] row : matrix) {
			for (int cell : row) {
				result.append(cell).append(' ');
			}
			result.append('\n');
		}
		return result.toString();
	}

	public void addEdge(int x, int y) {
		matrix[x][y] = 1;
		if (!directed) {
			matrix[y][x] = 1;
		}
	}

	public int degree(int x) {
		int degree = 0;
		for (int i = 0; i < matrix[x].length; i++) {
			degree += matrix[x][i];
		}
		return degree;
	}

	public int inDegree(int vert) {
		int in = 0;
		for (int i = 0; i < matrix.length; i++) {
			in += matrix[i][vert];
		}
		return in;
	}

	public int outDegree(int vert) {
		int out = 0;
		for (int i = 0; i < matrix[vert].length; i++) {
			out += matrix[vert][i];
		}
		return out;
	}

	public void DFS() {
		visited = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			if (visited[i] == 0) {
				dfs(i);
			}
		}
	}

	public void dfs(int y) {
		visited[y] = 1;
		System.out.println("Visiting vertex: " + y);
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[y][i] == 1 && visited[i] == 0) {
				dfs(i);
			}
		}
	}

	public void BFS() {
		visited = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			if (visited[i] == 0) {
				bfs(i);
			}
		}
	}

	public void bfs(int y) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(y);
		visited[y] = 1;
		while (!q.isEmpty()) {
			int node = q.poll();
			System.out.println("Visiting vertex: " + node);
			for (int i = 0; i < matrix[node].length; i++) {
				if (matrix[node][i] == 1 && visited[i] == 0) {
					q.add(i);
					visited[i] = 1;
				}
			}
		}
	}
}
