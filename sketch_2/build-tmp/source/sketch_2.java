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

public class sketch_2 extends PApplet {

public void setup() {
	
	background(0);
}

public void draw() {
	background(0);
	// translate(width/2, height/2);


	int res = 100;

	for (int i = 0; i < res; ++i) {
		float lon = (width/res) * i; 
	
		for (int j = 0; j < res; ++j) {
			float lat = (height/res) * j;

			println("lon: "+ lon);

			float x = map(cos(lon), 0, 100, 0, width);
			float y = lat;
			
			stroke(255);
			strokeWeight(2);
			point(x, y);



		}
	}
}
  public void settings() { 	size(600, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch_2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
