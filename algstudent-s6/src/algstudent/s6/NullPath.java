package algstudent.s6;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class NullPath<T> {
	
	// Factorial Complexity: O(n!)

	public static final int INITIAL_VALUE = 100000;
	public static final int TOLERANCE = 99;

	private static Random random = new Random();

	public static void main(String[] args) {
		int[][] graph = new int[5][5];
		fillWeights(graph);
		printGraph(graph);
		int origin = random.nextInt(graph.length);
		System.out.println("Origin: " + origin);
		int destination = 0;
		do {
			destination = random.nextInt(graph.length);
		}while(destination == origin);
		System.out.println("Destination: " + destination);
		System.out.println(nullPath(graph, origin, destination));
	}

	public static void fillWeights(int[][] graph) {
		int length = graph.length;
		for(int i = 0; i < length; i++)
			for(int j = 0; j < length; j++)
				graph[i][j] = INITIAL_VALUE;
		
		int halfGraph = (length * length - length);
		int counter = 0;
		fillHalfWeights(halfGraph, counter, 10, 90, graph);
	}

	public static void fillHalfWeights(int halfGraph, int counter, int minimum, int maximum, int[][] graph) {
		while(counter < halfGraph) {
			int origin = random.nextInt(graph.length);
			int destination = random.nextInt(graph.length);
			if(origin != destination && graph[origin][destination] == INITIAL_VALUE) {
				if(counter < halfGraph / 2)
					graph[origin][destination] = random.nextInt(maximum) + minimum;
				else
					graph[origin][destination] = - random.nextInt(maximum) + minimum;
				counter++;
			}
		}
	}

	public static void printGraph(int[][] graph) {
		int length = graph.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++)
				System.out.print(String.format("%10s", graph[i][j]));
			System.out.println();
		}
		System.out.println();
	}

	private static boolean isInTolerance(int result) {
		return Math.abs(result) < TOLERANCE;
	}
	
	private static String valueOf(int value) {
		return String.valueOf(value);
	}

	public static List<String> nullPath(int[][] graph, int origin, int destination){
		List<String> nullPath = new LinkedList<String>();
		int result = 0;
		nullPath.add(valueOf(origin));
		int tries = 0;
		return nullPath(graph, origin, destination, result, nullPath, tries);
	}
	
	private static List<String> nullPath(int[][] graph, int position, int destination, int result, List<String> nullPath, int tries){
		int nextPosition = -1;
	    int size = graph.length;

	    do {
	        nextPosition = random.nextInt(size);
	    } while (nextPosition < 0 || nextPosition >= size);

	    if (nullPath.contains(valueOf(nextPosition)) || nextPosition == destination) {
	        return nullPath(graph, position, destination, result, nullPath, tries);
	    }

	    nullPath.add(valueOf(nextPosition));
	    result += graph[position][nextPosition];

	    if (nullPath.size() == size - 1) {
	        result += graph[nextPosition][destination];
	        tries++;
	        if (tries > fact(size)) {
	            nullPath.clear();
	            System.out.println("No path");
	            return nullPath;
	        }
	        if (isInTolerance(result)) {
	            nullPath.add(valueOf(destination));
	            System.out.println("Result: " + result);
	            return nullPath;
	        } else {
	        	
	            nullPath.remove(valueOf(nextPosition));
	            return nullPath(graph, position, destination, result - graph[position][nextPosition], nullPath, tries);
	        }
	    } else {
	        return nullPath(graph, nextPosition, destination, result, nullPath, tries);
	    }
	}
	
	private static int fact(int number) {
		if(number < 0)
			throw new IllegalArgumentException();
		if(number == 0 || number == 1)
			return 1;
		return number * fact(number - 1);
	}
}
