void setup() {
	size(800, 800);
	background(0);
}



void polygon(float x, float y, float radius, int npoints) {
  float angle = TWO_PI / npoints;

  beginShape();
  for (float a = 0; a < TWO_PI; a += angle) {
    float sx = x + cos(a) * radius;
    float sy = y + sin(a) * radius;
    vertex(sx, sy);
  }    
  endShape(CLOSE);

  beginShape();
  for (float a = 0; a < TWO_PI; a += angle) {    
    float sx = x + cos(a) * radius; 
    float sy = y + sin(a) * radius;
    float sxb = x + cos(a + 1) * radius;
    float syb = y + sin(a + 1) * radius;
    float sx1 = lerp(sx, sxb, .5);
    float sy1 = lerp(sy, syb, .5);
    vertex(sx1, sy1);
  }
  endShape(CLOSE);

}

void draw() {
  background(0);
  translate(width / 2, height /2);
  rotate(frameCount / 8);
  strokeWeight(1);
  noFill();

  float distance = 40;
  float numbOf = 6;
  float init = 60;

  stroke(255, 200, 125);
  beginShape();
  for (int i = 0; i < numbOf; ++i) {
    float r = distance * i + init;
    polygon(0, 0, r, 6);  
  }
  endShape();

  beginShape();
  rotate((frameCount / 16) * -1); 
  stroke(255, 125, 0);
  float side = ((distance + init) * numbOf);
  float x = - (side / 2);
  float y = - (side / 2);
  float w = side;
  float h = side; 
  rect(x, y, w, h);
  endShape();

  stroke(255, 125, 125);
  ellipse(0, 0, side, side);
  // line();
}