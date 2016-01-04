package javis.loopviewpager;

/**
 * Created by Jeffrey Liu on 12/31/15.
 */
public class DisplayItem {
    private String text;
    private int color;

    public DisplayItem(String text, int color) {
        this.text = text;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public String getText() {
        return text;
    }
}
