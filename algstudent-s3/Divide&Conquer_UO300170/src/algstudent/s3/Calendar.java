package algstudent.s3;

import java.util.Random;

public class Calendar {
	
	private String[] participants;
	private String[] possibleParticipants;
	
	public Calendar() {
		possibleParticipants = new String[]{"Vanesa", "Victor", "Tomas", "Alba", "Andrés", "Luis", "Javier", "Oscar", "Sergio", "Irene",
				"Martina", "Charlotte", "Marcos", "Alex", "Sofia", "Nacho"};
		participants = new String[randomNumber()];
		for(int i = 0; i < participants.length; i++)
			participants[i] = possibleParticipants[i];
	}
	
	private int randomNumber() {
		Random random = new Random();
		int exponent = random.nextInt(4) + 1;
		return (int) Math.pow(2, exponent);
	}
	
	private int numberOfDays() {
		return participants.length - 1;
	}
	
	private String printDays() {
		String str = "";
		int index = 0;
		return printDays(str, index);
	}
	
	private String printDays(String str, int index) {
		if(index < numberOfDays()) {
			str += "DAY " +  (index + 1) + "\t";
			return printDays(str, index + 1);
		}
		return str;		
	}
	
	
	
	private String printParticipantsDay() {
		String str = "";
		int index = 0;
		return printParticipantsDay(str, index);
	}
	
	private String printParticipantsDay(String str, int index) {
		if(index < participants.length) {
			str+= "\n" + participants[index] + "\t" + participants[index+1];
			str+= "\n" + participants[index+1] + "\t" + participants[index];
			return printParticipantsDay(str, index + 2);
		}
		return str + "\n".repeat(2);
	}
	
	private void moveElementsArray() {
		String zero = participants[0];
		String one = participants[1];
		int index = 0;
		moveElementsArray(index);	
		participants[participants.length-2] = zero;
		participants[participants.length-1] = one;
	}
	
	private void moveElementsArray(int index) {
		if(index < participants.length - 2) {
			participants[index] = participants[index + 2];
			moveElementsArray(index + 1);
		}
	}
	
	private String firstLine() {
		return "PLAYER/OPPONENT" + "\t" + printDays();
	}
	
	public void write(){
		System.out.println(firstLine());
		int index = 0;
		write(index);
		System.out.println(firstLine());
	}
	
	private void write(int index) {
		if(index < participants.length) {
			System.out.print(printParticipantsDay());
			moveElementsArray();
			write(index+2);
		}
		
	}

}
