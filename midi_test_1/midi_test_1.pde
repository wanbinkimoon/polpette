import themidibus.*; //Import the library

MidiBus myBus; // The MidiBus
int val = 0;
void setup() {
  size(800, 800);
  background(125);

  MidiBus.list(); 
  myBus = new MidiBus(this, 0, 1); // Create a new MidiBus with no input device and the default Java Sound Synthesizer as the output device.
}

void controllerChange(int channel, int number, int value) {
  val = value;
  
  // Receive a controllerChange
  println();
  println("Controller Change:");
  println("--------");
  println("Channel:" + channel);
  println("Number:" + number);
  println("Value:" + value);
}

void draw() {
  stroke(255);
  line(0, val, width, val);
  println("val: "+val);
}