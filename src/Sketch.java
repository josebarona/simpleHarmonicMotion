import processing.core.PApplet ;


public class Sketch extends PApplet implements Drawing{

    float angle = 0 ;
    int w = 80 ;
    int cols ;
    float diameter = w-10 ;
    float radius = diameter/2 ;
    Curve[][] curves ;

    public void settings(){
        size(800,800) ;
        this.cols = width / w-1 ;
    }

    public void setup(){

    }

    //esta verga es un loop infinito!
    public void draw(){
        background(0);
        stroke(255) ;
        noFill();

        int j = 1 ;
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
        }

        angle += 0.0098 ;

        for(int i= 0 ; i<cols ; i++){
            float centerX = w/2  ;
            float centerY = (i*w) + w/2 + w  ;
            stroke(255) ;
            strokeWeight(1) ;
            ellipse(centerX, centerY, diameter, diameter) ;
            float x = radius * cos(angle*(i+1) +PI/2) ;
            float y = radius * sin(angle*(i+1) +PI/2) ;
            stroke(255) ;
            strokeWeight(8) ;
            point( centerX+x , centerY+y ) ;
            stroke(255,25) ;
            strokeWeight(1) ;
            line(0, centerY+y ,width,centerY+y);
        }

    }
}
