package questions;

import java.util.Scanner;

public class ServerIsRunning {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input the time:");
		int time = sc.nextInt();
		boolean isRunning = checkServerRunning(time);
		System.out.println("Service is running? " + isRunning);
	}

	private static boolean checkServerRunning(int time) {
		boolean isServerRunning = false;
		
		int[][] timeslot = {{0,30},{35,40},{45, 60}, {100,104},{105,110}};
		for(int i=0;i<timeslot.length;i++) {
			if(time > timeslot[i][0] && time < timeslot[i][1]) {
				isServerRunning = true;
				break;
			}
		}
		return isServerRunning;
	}
}
