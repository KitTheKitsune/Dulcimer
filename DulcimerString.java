import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * Class to simulate the vibration of a string.
 * 
 * @author Kendrick Smith
 * @version 9/24/2020
 */
public class DulcimerString {
	Queue<Double> q = new LinkedList<Double>();
	ArrayList<String> scale = new ArrayList<>(Arrays.asList("A","A#","B","C","C#","D","D#","E","F","F#","G","G#"));
	int SAMPLE_RATE = 44100;
	String note;

	/**
	 * Constructs a string of the specified note
	 * @param note the name of the string
	 */
	public DulcimerString(String note) {
		this.note = note;
		for(int i = 0;i< SAMPLE_RATE*Math.pow(2, (22-getOffsetFromMiddleC())/12)/440;i++) {
			this.q.add(0.0);
		}
		
	}

	/**
	 * Calculates the distance of this string's note from middle C
	 * @return the distance from middle C 
	 */
	public int getOffsetFromMiddleC() {
		int offset = 0;
		int plus = 0;
		int minus = 0;
		String note = this.note;
		
		while (note.contains("+")||note.contains("-")) {
			if (note.contains("+")) {
				plus++;
				note.replace("+", "");
			}else{
				minus++;
				note.replace("-", "");
			}
		}
		
		offset = this.scale.indexOf(note)-3;
		
		while (plus>0||minus>0) {
			if(plus>0) {
				offset += 12;
				plus--;
			}else{
				offset -= 12;
				minus--;
			}
		}
		
		
		return offset;
	}
	
	/**
	 * Getter for this string's note
	 * @return this string's note
	 */
	public String getNote() {
		return this.note;
	}
	
	/**
	 * Simulates a random vibration by altering the values in this string's list
	 */
	public void strike() {
		for(int i=0;i<q.size();i++) {
			q.remove();
			q.add(Math.random()-0.5);
		}
	}
	
	/**
	 * Generates a new value based on the first two values in the list added to the end and removes the first
	 * @return the first value in this string's list
	 */
	public double sample() {
		double front = q.peek();
		q.remove();
		double next = q.peek();
		q.add(.996 * 0.5 * (front+next));
		return front;
	}
}
