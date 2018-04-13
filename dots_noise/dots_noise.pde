
int res = 16;
float seed = 0;

void setup() {
	size(801, 801);
	background(0);
	colorMode(HSB);

}

void draw() {

	int w = width / res;
	int h = height / res;

	for (int i = 0; i < res; ++i) {
		int x = w * i;


		for (int j = 0; j < res; ++j) {
			int y = h * j;
			int defaultHue = j * i + 160;
			float hue = noise(seed * (j + 1) * (i + 1) * .5);

			fill(hue * defaultHue, 255, 255);
			rect(x, y, w, h);
		}

	}

	seed += .1;
}