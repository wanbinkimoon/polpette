void setup() {
	size(600, 600);
	background(0);
}

void draw() {
	background(0);
	// translate(width/2, height/2);


	int res = 100;

	for (int i = 0; i < res; ++i) {
		float lon = (width/res) * i; 
	
		for (int j = 0; j < res; ++j) {
			float lat = (height/res) * j;

			println("lon: "+ lon);

			float x = map(cos(lon), 0, 100, 0, width);
			float y = lat;
			
			stroke(255);
			strokeWeight(2);
			point(x, y);



		}
	}
}