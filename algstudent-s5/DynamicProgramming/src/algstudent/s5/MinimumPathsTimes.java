package algstudent.s5;

import java.util.HashMap;
import java.util.Map;

public class MinimumPathsTimes {

	public static void main(String[] args) {
		long t1, t2;

		Map<Integer, Long> measurements = new HashMap<Integer, Long>();

		for(int i = 200; i < 100000; i*=2) {

			t1 = System.currentTimeMillis();

			for(int j = 0; j < 1000; j+=10)
				MinimumPaths.main(args);

			t2 = System.currentTimeMillis();

			System.out.println(i + "\t" + (t2 - t1));
			measurements.put(i, (t2-t1));
		}

		for(Integer measurement: measurements.keySet())
			System.out.println("" + measurement + "-->"+  measurements.get(measurement));
	}

}
