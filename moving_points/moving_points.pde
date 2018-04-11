int numFrames = 100;
int m = 100;

void setup(){
  size(800,800,P3D);
 
  stroke(255);
  fill(255);
}
 
float x1(float t){
  return 0.25*width + 50*cos(TWO_PI*t);
}

float y1(float t){
  return 0.5*height + 50*sin(TWO_PI*t);
}
 
float x2(float t){
  return 0.75*width + 50*cos(2*TWO_PI*t);
}

float y2(float t){
  return 0.5*height + 50*sin(2*TWO_PI*t);
}
 
void draw(){
  float t = 1.0 * (frameCount - 1) / numFrames;
 
  background(0);
 
  ellipse(x1(t),y1(t),6,6);
  ellipse(x2(t),y2(t),6,6);

  float delay_factor = 2.0;

  pushStyle();
  strokeWeight(2);
  stroke(255,100);
  for(int i = 0; i <= m; i++){
    float tt = 1.0 * i / m;
    float x = lerp(x1 (t - delay_factor*tt), x2(t), tt);
    float y = lerp(y1 (t - delay_factor*tt), y2(t), tt);
   
    point(x,y);
  }
  popStyle();

}