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

public class perlin_noise extends PApplet {


int res = 40;
float seed = 0;

public void setup() {
	
	background(0);
	colorMode(HSB);

}

public void draw() {

	int rows = width / res;
	int cols = height / res;

	for (int i = 0; i < res; ++i) {
		int x = rows * i;


		for (int j = 0; j < res; ++j) {
			int y = cols * j;
			int defaultHue = j * i + 160;
			float hue = noise(seed * (j + 1) * (i + 1) * .5f);


			fill(hue * defaultHue, 255, 255);
			rect(x, y, res, res);
		}

	}

	seed += .1f;
}
  public void settings() { 	size(801, 801); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "perlin_noise" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
