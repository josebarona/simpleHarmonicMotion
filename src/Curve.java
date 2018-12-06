import processing.core.PApplet ;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

public class Curve{
    private List<PVector> path ;
    private PVector current ;

    public Curve() {
        this.path = new ArrayList<PVector>()  ;
        this.current = new PVector() ;
    }

    public void setX(float x) {
        current.x = x;
    }

    public void setY(float y) {
        current.y = y;
    }

    public void addPoint(){
        path.add(current) ;
        current = new PVector() ;
    }

}
