// https://processing.org/examples/scale.html

float a = 0.0;
float s = 0.0;

int rect_size = 50;
float scale_val = 3.0;

void setup() {
  size(640, 360);
  noStroke();
  rectMode(CENTER);
  frameRate(30);
  
  background(100);
}

void draw() {
  
  translate(width/2, height/2);
  
  fill(255);
  
  rect(30, 20, rect_size, rect_size);

  scale(scale_val);
  fill(255,0,0);
  rect(30, 20, rect_size, rect_size);

  //scale(scale_val -0.1);
  //fill(0,255,0);
  //rect(30, 20, rect_size, rect_size);

}