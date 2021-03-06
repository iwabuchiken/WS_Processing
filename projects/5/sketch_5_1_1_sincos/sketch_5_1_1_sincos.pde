/*
  https://www.openprocessing.org/sketch/121912
  

*/
void setup()
{
  rectMode(CENTER);
  size(400, 400);
  frameRate(60);
}

float radius = 0, theta = 0;
float scrX, scrY;

float tick = 0.1;

void draw()
{
  if(theta >= 200)
    noLoop();
    
  scrX = theta * cos(theta);
  scrY = theta * sin(theta);

  //theta += 0.25;
  theta += tick;

  rect(scrX + width/2, scrY + height/2, 1, 1);   
  println("X: " + scrX + " Y: " + scrY);
}