import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Chessman {
    private String color;
    private String id;
    private String position;
    private String type;

    Chessman(String color, String id, String position, String type) {
        this.color = color;
        this.id = id;
        this.position = position;
        this.type = type;
    }

    public void setID(String id) {
        this.id = id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }

    public String getID() {
        return this.id;
    }

    public String[] check(String position, String[] positions) {
        String[] n = { "" };
        return n;
    }

}
