/**
 * This obviously is the main entry to the application.
 * 
 * @author Damien Hunter
 * @version 0.1
 */

public class servStart{
	public static void main(String [] args){
		new Server(1038); // Set to 1025, Bind error below 1024.
	}
}