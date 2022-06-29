import java.util.ArrayList;

/**
 * Class that models a dulcimer. Currently, only the bass strings are represented.
 * 
 * @author Kendrick Smith
 * @version 9/24/2020
 */
public class Dulcimer {
    public ArrayList<DulcimerString> baseStrings;

    /**
     * Constructs a Dulcimer with the specified bass strings.
     *   @param bassNotes a String specifying the bass notes, from bottom to top
     */
    public Dulcimer(String bassNotes) {
        this.baseStrings = new ArrayList<DulcimerString>(36);
        for (String str : bassNotes.split("\\s+")) {
            this.baseStrings.add(new DulcimerString(str));
        } 
    }
    
    /**
     * Strikes the specified string and sets it to vibrating.
     *   @param stringNum the string number (starting at the bottom with 0)
     */
    public void hammer(int stringNum) {
        if (stringNum >= 0 && stringNum < this.baseStrings.size()) {
            this.baseStrings.get(stringNum).strike();
        }
    }

    /**
     * Plays the sounds corresponding to all of the struck strings.
     */
    public void play() {
        double combinedFrequencies = 0.0;
        for (int i = 0; i < this.baseStrings.size(); i++) {
            combinedFrequencies += this.baseStrings.get(i).sample();
        }
        StdAudio.play(combinedFrequencies);
    }
}
