import peasy.*;

PeasyCam cam;

PVector[][] globe;
int res = 5;

void setup() {
	size(800, 800, P3D);
	colorMode(HSB);
	cam = new PeasyCam(this, 600);
	globe = new PVector[res+1][res+1];

}

float superShape(float theta, sfloat m, float n1, float n2, float n3){
	float r = 1;
	return r;
}

void draw() {
	background(0);
	lights();
	noStroke();
	float r = 200;

	for (int i = 0; i < res + 1; ++i) {
		float lat = map(i, 0, res, 0, PI);
		float r1  = superShape(lat, 7, .2, 1.7, 1.7);	
		for (int j = 0; j < res + 1; ++j) {
			float lon = map(j, 0, res, 0, TWO_PI);
			float r2  = superShape(lon, 7, .2, 1.7, 1.7);
			float x   = r * r1 * cos(lat) * r2 * cos(lon);
			float y   = r * r1 * sin(lat) * r2 * cos(lon);
			float z   = r * sin(lat) * r2;
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