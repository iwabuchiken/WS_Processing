/*


*/

int corner = 10;

int i;

int i_max = 6;

void setup() {
  size(400, 400);
  background(125);
  fill(255);
  noLoop();
}

void draw() {  
  
  noStroke();
  
  //rectMode(CENTER);
  
  frameRate(30);
  
  translate(30, 20);
  rect(0, 0, 55, 55);
  
  translate(30, 20);
  rect(0, 0, 55, 55);

  for(i = 1; i < i_max; i ++) {
    
    fill(255 - i*30);
    
    corner = corner * i;
    
    translate(30 + i * 5, 20 + i * 5);
    rect(0, 0, 55, 55, corner);
    
    
    
  }
 
  //translate(30, 20);
  //rect(0, 0, 55, 55, corner);
  
}