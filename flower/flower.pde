float n = 1;
int c = 4;
float angle = 137.5;
// float angle = 180;

void setup() {
	size(800, 800);
	background(0);
}

void draw() {
	translate(width / 2 , height / 2);

	float a = n * angle;
	float r = c * sqrt(n);

	float x = n * cos(radians(a));
	float y = n * sin(radians(a));

	fill(255);
	noStroke();
	ellipse(x, y, 4, 4);

	n += 0.5;
}