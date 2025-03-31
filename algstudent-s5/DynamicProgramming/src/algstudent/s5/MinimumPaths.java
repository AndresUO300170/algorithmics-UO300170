package algstudent.s5;

import java.util.Random;

public class MinimumPaths {

	static String[] v; //node vector
	static int[][] weights; //weight matrix
	static int[][] costs; //Floyd's paths cost matrix
	static int[][] p; //predecessor matrix (steps) in Floyd paths

	public static void main() {
		int n = 5; //nodes of example graph
		v = new String[n];
		for (int i = 0; i < n; i++)
			v[i] = "NODE" + i;

		weights = new int[n][n];
		costs = new int[n][n];
		p = new int[n][n];

		fillInWeights(weights); //weights for the example
		System.out.println("WEIGHT MATRIX IS:");
		printMatrix(weights);

		floyd(weights, costs, p);

		System.out.println("MINIMUM COST MATRIX IS:");
		printMatrix(costs);

		System.out.println("P MATRIX IS:");
		printMatrix(p);

		System.out.println();
		System.out.println("MINIMUM PATHS IN THE EXAMPLE GRAPH (for every pair of different nodes):");
		System.out.println();
		for (int source = 0; source <= n-1; source++)
			for (int target = 0; target <= n-1; target++)
				if (source != target) {
					System.out.print("FROM " + v[source] + " TO " + v[target] + " = ");
					minimumPath(v, weights, costs, p, source, target);
					if (costs[source][target] < 10000000)
						System.out.println("MINIMUM COST=" + costs[source][target]);
					System.out.println("**************");
				}

	}

	/* ITERATIVE WITH CUBIC COMPLEXITY O(n^3) */
	static void floyd(int[][] weights, int[][] costs, int[][] p) {
		int n = weights.length;
		for(int pivot = 0; pivot < n; pivot++)
			for(int origin = 0; origin < n; origin++)
				for(int destination = 0; destination < n; destination++) {
					p[origin][destination] = weights[origin][destination];
					if(origin != destination && pivot != origin && pivot != destination)
						if(weights[origin][destination] > weights[origin][pivot] + weights[pivot][destination]) {
							weights[origin][destination] = weights[origin][pivot] + weights[pivot][destination];
							costs[origin][destination] = pivot;
						}
				}
	}
	

	static void minimumPath(String[] v, int[][] weights, int[][] costs, int[][] steps, int source, int target) {
		if(p[source][target] == 10000000) {
			System.out.println("THERE IS NO PATH");
			return;
		}
		System.out.print(v[source] + "-->");
		path(v, steps, source, target);
		System.out.println(v[target]);
	}

	/* IT IS RECURSIVE and WORST CASE is O(n), IT IS O(n) if you write all nodes */
	static void path(String[] v, int[][] steps, int i, int j) {
		if(costs[i][j] == 0) 
			return;
		int pivot = costs[i][j];
		path(v, steps, i, pivot);
		System.out.print(v[pivot] + "-->");
	}

	/* load the example cost matrix */
	static void fillInWeights(int[][] w) {
		int length = w.length;
		for (int i = 0; i < length; i++)
			for (int j = 0; j < length; j++)
				w[i][j] = 10000000;
		Random random = new Random();
		int nEdges = ((length * length) - length) / 2;
		int counter = 0;
		while(counter < nEdges) {
			int origin = random.nextInt(length);
			int destination = random.nextInt(length);
			if(origin != destination && w[origin][destination] == 10000000) {
				w[origin][destination] = random.nextInt(99) + 10;
				counter++;
			}
		}
	}
	
	
	/* print the cost matrix */
	static void printMatrix(int[][] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(String.format("%10s", a[i][j]));
			System.out.println();
		}
		System.out.println();
	}
}
