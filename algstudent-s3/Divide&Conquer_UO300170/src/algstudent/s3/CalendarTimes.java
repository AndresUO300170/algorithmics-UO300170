package algstudent.s3;


public class CalendarTimes {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); 

        Calendar calendar = new Calendar();
        calendar.write();

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime; 

        System.out.println("Execution time: " + duration + " miliseconds");
    }
}
