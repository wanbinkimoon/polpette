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

public class moving_points extends PApplet {

int numFrames = 100;
int m = 100;

public void setup(){
  
 
  stroke(255);
  fill(255);
}
 
public float x1(float t){
  return 0.25f*width + 50*cos(TWO_PI*t);
}

public float y1(float t){
  return 0.5f*height + 50*sin(TWO_PI*t);
}
 
public float x2(float t){
  return 0.75f*width + 50*cos(2*TWO_PI*t);
}

public float y2(float t){
  return 0.5f*height + 50*sin(2*TWO_PI*t);
}
 
public void draw(){
  float t = 1.0f * (frameCount - 1) / numFrames;
 
  background(0);
 
  ellipse(x1(t),y1(t),6,6);
  ellipse(x2(t),y2(t),6,6);

  float delay_factor = 2.0f;

  pushStyle();
  strokeWeight(2);
  stroke(255,100);
  for(int i = 0; i <= m; i++){
    float tt = 1.0f * i / m;
    float x = lerp(x1 (t - delay_factor*tt), x2(t), tt);
    float y = lerp(y1 (t - delay_factor*tt), y2(t), tt);
   
    point(x,y);
  }
  popStyle();

}
  public void settings() {  size(800,800,P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "moving_points" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
