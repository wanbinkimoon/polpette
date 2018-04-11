import peasy.*;

PeasyCam cam;

PVector[][] globe;
int res = 75;

void setup() {
	size(800, 800, P3D);
	colorMode(HSB);
	cam = new PeasyCam(this, 600);
	globe = new PVector[res+1][res+1];

}

	float a = 1;
	float b = 1;

float superShape(float theta, float m, float n1, float n2, float n3){


	float t1 = abs((1/a) * cos(m * theta / 4));
	t1 = pow(t1, n2);
	float t2 = abs((1/b) * sin(m * theta / 4));
	t2 = pow(t2, n3);
	float t3 = t1 + t2;

	float r = pow(t3, - 1 / n1);
	return r;
}

void draw() {
	background(0);
	lights();
	noStroke();
	float r = 200;

	for (int i = 0; i < res + 1; ++i) {
		float lat = map(i, 0, res, -HALF_PI, HALF_PI);
		float r2  = superShape(lat, 7, 0.2, 1.7, 1.7);
		for (int j = 0; j < res + 1; ++j) {
			float lon = map(j, 0, res, -PI, PI);
			float r1  = superShape(lon, 7, 0.2, 1.7, 1.7);	
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