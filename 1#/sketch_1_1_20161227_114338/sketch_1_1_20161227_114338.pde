/*



*/

color c = color(255, 204, 0);

void setup() {
  
  
  //ref https://forum.processing.org/two/discussion/12179/processing-3-resizable
  //ref https://github.com/processing/processing/wiki/Window-Size-and-Full-Screen
  surface.setResizable(true);
  
  size(480, 120);
}

void draw() {
  
  if(keyPressed) {
   
    if(key == 'n') {
     
      //noLoop();
      return;
      
    }
    
  }
  
  if (mousePressed) {
    
    if(mouseButton == LEFT) {
      
      c = color(random(255), 0, 255);
      
    } else if(mouseButton == RIGHT) {
      
      c = color(255,0,random(255));
      
    } else {
      
      c = color(255,0,random(255));
      
    }
    
    //fill(0);
    
    //c = color(255,0,random(255));
    
    fill(c);
    
    
  } else {
    
    
    fill(255);
  }
  ellipse(mouseX, mouseY, 80, 80);
}