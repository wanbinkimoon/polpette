
int res = 40;
float seed = 0;

void setup() {
	size(801, 801);
	background(0);
	colorMode(HSB);

}

void draw() {

	int rows = width / res;
	int cols = height / res;

	for (int i = 0; i < res; ++i) {
		int x = rows * i;


		for (int j = 0; j < res; ++j) {
			int y = cols * j;
			int defaultHue = j * i + 160;
			float hue = noise(seed * (j + 1) * (i + 1) * .5);

			fill(hue * defaultHue, 255, 255);
			rect(x, y, res, res);
		}

	}

	seed += .1;
}