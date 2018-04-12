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

public class spiral extends PApplet {

float n = 0.5f;
int c = 18;

public void setup() {
	
	background(0);
}

public void draw() {
	float a = n * 137.5f;
	float r = c * sqrt(n);

	float x = n * cos(a) + width / 2;
	float y = n * sin(a) + height / 2;

	fill(255);
	ellipse(x, y, 8, 8);

	n += 0.5f;
}
  public void settings() { 	size(512, 512); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "spiral" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
