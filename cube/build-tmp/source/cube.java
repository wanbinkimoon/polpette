import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import peasy.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class cube extends PApplet {



PeasyCam cam;

public void setup() {
	
	cam = new PeasyCam(this, 600);
}

public void draw() {
	background(0);
	noStroke();
	lights();

	float side = 200;

	beginShape();
		fill(255, 100, 0);
		box(side);
	endShape();

	// stroke(255, 100, 125);
	// rotateY(QUARTER_PI);
	// rotateZ(QUARTER_PI);
	// box(side);
	
	beginShape();
		fill(255, 50, 0);
		rotateX(QUARTER_PI);
		rotateY(PI / 8);
		// rotateZ(QUARTER_PI);
		box(side);
	endShape();


}
  public void settings() { 	size(800, 800, P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "cube" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
