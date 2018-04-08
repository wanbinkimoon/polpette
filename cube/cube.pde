import peasy.*;

PeasyCam cam;

void setup() {
	size(800, 800, P3D);
	cam = new PeasyCam(this, 600);
}

void draw() {
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