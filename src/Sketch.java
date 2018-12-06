import processing.core.PApplet ;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;


public class Sketch extends PApplet implements Drawing{

    float angle = 0 ;
    int w = 80 ;
    int cols ;
    int rows ;
    float diameter = w-10 ;
    float radius = diameter/2 ;
    Curve[][] curves ;

    public void settings(){
        size(800,800) ;
    }

    public void setup(){
        this.cols = width/w -1 ;
        this.rows = height/w -1;
        this.curves = new Curve[rows][cols] ;

        for(int i=0 ; i<rows ; i++){
            for(int j=0 ; j<cols ; j++){
                curves[i][j] = new Curve() ;
            }
        }

    }

    //esta verga es un loop infinito!
    public void draw(){
        background(0);
        stroke(255) ;
        noFill();


        for(int i=0 ; i<cols ; i++){
            float centerX = (i*w) + w/2 + w ;
            float centerY = w/2 ;
            stroke(255) ;
            strokeWeight(1) ;
            ellipse(centerX,centerY,diameter,diameter) ;
            float x = radius * cos( angle*(i+1) - HALF_PI ) ;
            float y = radius * sin(angle*(i+1) - HALF_PI ) ;
            stroke(255) ;
            strokeWeight(8) ;
            point( centerX+x , centerY+y );
            stroke(255,25) ;
            strokeWeight(1) ;
            line(centerX+x, 0 ,centerX+x,height);

            for(int j=0 ; j<rows ; j++){
                curves[j][i].setX( centerX+x );
            }

        }

        angle += 0.0090 ;

        for(int j=0 ; j<cols ; j++){
            float centerX = w/2  ;
            float centerY = (j*w) + w/2 + w  ;
            stroke(255) ;
            strokeWeight(1) ;
            ellipse(centerX, centerY, diameter, diameter) ;
            float x = radius * cos(angle*(j+1) +PI/2) ;
            float y = radius * sin(angle*(j+1) +PI/2) ;
            stroke(255) ;
            strokeWeight(8) ;
            point( centerX+x , centerY+y ) ;
            stroke(255,25) ;
            strokeWeight(1) ;
            line(0, centerY+y ,width,centerY+y) ;

            for (int i = 0; i < cols; i++) {
                curves[j][i].setY(centerY+y );
            }

        }


        for(int i=0 ; i<rows ; i++){
            for(int j=0 ; j<cols ; j++){
                curves[j][i].addPoint() ;
                curves[j][i].show() ;
            }
        }

        //angle -= 0.0098 ;

    }

    private class Curve{
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

        public void show(){
            int color = (int) random(0,255) ;
            stroke(color) ;
            strokeWeight(1) ;
            noFill() ;
            beginShape() ;
            for(PVector vector : path){
                vertex( vector.x , vector.y );
            }
            endShape();
        }
    }


}
