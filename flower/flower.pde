float n = 0.5;
int c = 18;

void setup() {
	size(800, 800);
	background(0);
}

void draw() {
	float a = n * 137.5;
	float r = c * sqrt(n);

	float x = n * cos(a) + width / 2;
	float y = n * sin(a) + height / 2;

	fill(255);
	ellipse(x, y, 8, 8);

	n += 0.5;
}