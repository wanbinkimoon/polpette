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

public class strange_sphere extends PApplet {



PeasyCam cam;

PVector[][] globe;
int res = 75;

public void setup() {
	
	colorMode(HSB);
	cam = new PeasyCam(this, 600);
	globe = new PVector[res+1][res+1];

}


public float superShape(float theta, float m, float n1, float n2, float n3){

	float a = 1;
	float b = (frameCount / 100);

	float t1 = abs((1/a) * cos(m * theta / 4));
	t1 = pow(t1, n2);
	float t2 = abs((1/b) * sin(m * theta / 4));
	t2 = pow(t2, n3);
	float t3 = t1 + t2;

	float r = pow(t3, - 1 / n1);
	return r;
}

public void draw() {
	background(0);
	lights();
	noStroke();
	float r = 200;

	for (int i = 0; i < res + 1; ++i) {
		float lat = map(i, 0, res, -HALF_PI, HALF_PI);
		float r1  = superShape(lat, 7, 0.2f, 1.7f, 1.7f);	
		for (int j = 0; j < res + 1; ++j) {
			float lon = map(j, 0, res, -PI, PI);
			float r2  = superShape(lon, 7, 0.2f, 1.7f, 1.7f);
			float x   = r * r1 * cos(lon) * r2 * cos(lat);
			float y   = r * r1 * sin(lon) * r2 * cos(lat);
			float z   = r * r2 * sin(lat);
			globe[i][j] = new PVector(x, y, z);
		}
	}

	for (int i = 0; i < res; ++i) {
		beginShape(TRIANGLE_STRIP);
		// float hue = map(i, 0, res, 0, 255 * 6);
		// fill(hue % 255, 255, 255);

		stroke(255);
		noFill();

		for (int j = 0; j < res+1; ++j) {
		
			PVector v1 = globe[i][j];
			vertex(v1.x, v1.y, v1.z);
			PVector v2 = globe[i + 1][j];
			vertex(v2.x, v2.y, v2.z);
		}

		endShape();
	}
}	
  public void settings() { 	size(800, 800, P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "strange_sphere" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
