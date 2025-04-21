package algstudent.s6;

import java.util.Random;

public class NullPathTimes {
	
	static Random random = new Random();

	public static void main(String[] args) {
		for(int n = 20; n <= 50; n+=5) {
			long duration = 0;
			for(int i = 0; i < 100; i++) {
				int[][] graph = new int[n][n];
				NullPath.fillWeights(graph);
				long startTime = System.currentTimeMillis();
				int origin = random.nextInt(graph.length);
				int destination = 0;
				do {
					destination = random.nextInt(graph.length);
				}while(destination == origin);
				NullPath.nullPath(graph, 0, n - 1);
				long endTime = System.currentTimeMillis();
				duration += (endTime - startTime);
			}
			System.out.println("Size: " + n + "-->" + "Duration: " + duration/100);
		}
	}
}
