import java.awt.Font;

/**
 * Driver class for the keyboard-based virtual dulcimer.
 * 
 * @author Kendrick Smith
 * @version 9/24/2020
 */
public class DulcimerDriver {
   public static void main(String[] args) {
        String bassKeys = "a   s   d   f   g   h   j   k   l   ;   '"; 
        String trebleOneKeys = "1   2   3   4   5   6   7   8   9   0   -   ="; 
        String trebleTwoKeys = "q   w   e   r   t   y   u   i   o   p   [   ]"; 
        String dashes = "--- --- --- --- --- --- --- --- --- --- --- ---";
        String bassNotes      = "G-  A   B   C   D   E   F   G   A+ A#+  C+ ";
        String trebleOneNotes = "G#  A+  B+ C#+  D+  E+ F#+  G+ A++ B++ C++ D++ ";
        String trebleTwoNotes = "C#  D   E   F#  G   A+  B+  C+  D+  E+ F#+  G+ ";
        
        StdDraw.setFont(new Font("Monospaced", Font.PLAIN, 12));
        StdDraw.textLeft(0.00, 1.00, "DULCIMER KEY MAPPINGS");
        StdDraw.textLeft(0.00, 0.90, "        keys:  " + trebleOneKeys);
        StdDraw.textLeft(0.00, 0.87, "TREBEL 1      " + dashes);
        StdDraw.textLeft(0.00, 0.84, "       notes:  " + trebleOneNotes);
        StdDraw.textLeft(0.00, 0.81, "        keys:  " + trebleTwoKeys);
        StdDraw.textLeft(0.00, 0.78, "TREBEL 2      " + dashes);
        StdDraw.textLeft(0.00, 0.75, "       notes:  " + trebleTwoNotes);
        StdDraw.textLeft(0.00, 0.72, "        keys:  " + bassKeys);
        StdDraw.textLeft(0.00, 0.69, "BASS          " + dashes);
        StdDraw.textLeft(0.00, 0.66, "       notes:  " + bassNotes);
        
        
        String keys = bassKeys.replace(" ","")+trebleOneKeys.replace(" ","")+trebleTwoKeys.replace(" ","");  
        
        Dulcimer dulc = new Dulcimer(bassNotes + trebleOneNotes + trebleTwoNotes);
        while (true) { 
            if (StdDraw.hasNextKeyTyped()) {
                int typed = keys.indexOf(StdDraw.nextKeyTyped());
                dulc.hammer(typed);
            }
            dulc.play();
        }
    }    
}
