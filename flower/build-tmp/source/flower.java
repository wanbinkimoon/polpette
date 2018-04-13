import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class flower extends PApplet {

float n = 1;
int c = 4;
float angle = 137.5f;
// float angle = 180;

public void setup() {
	
	background(0);
}

public void draw() {
	translate(width / 2 , height / 2);

	float a = n * angle;
	float r = c * sqrt(n);

	float x = n * cos(radians(a));
	float y = n * sin(radians(a));

	fill(255);
	noStroke();
	ellipse(x, y, 4, 4);

	n += 0.5f;
}
  public void settings() { 	size(800, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "flower" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
