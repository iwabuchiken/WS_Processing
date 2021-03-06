/*
  file:  sketch_1_1_20161227_114338.pde
  
  created at: 2016/12/27 13:33:00

*/

import java.awt.Toolkit;

//ref https://forum.processing.org/two/discussion/9877/how-to-use-enums
static final int TYPE_SERIAL      = 1;
static final int TYPE_FORMATTED    = 2;

color c = color(255, 204, 0);

void setup() {
  
  
  //ref https://forum.processing.org/two/discussion/12179/processing-3-resizable
  //ref https://github.com/processing/processing/wiki/Window-Size-and-Full-Screen
  surface.setResizable(true);
  
  size(480, 120);
  
  // no stroke
  noStroke();
  
}

void draw() {
  
  if(keyPressed) {
   
    if(key == 'n') {
     
      //noLoop();
      return;
      
    } else if(key == 's') {
      
      //String fname = "1_1." + nf(second(),2) + ".png";
      
      String fname = "1_1." + get_time_label__Now(TYPE_SERIAL) + ".png";

      saveFrame(fname);
      
      //ref https://forum.processing.org/one/topic/beep-sound.html
      Toolkit.getDefaultToolkit().beep();
      
    }
    
  }
  
  if (mousePressed) {
    
    //ref https://www.processing.org/reference/mouseButton.html
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

/***************************************
  @original location: C:\WORKS_2\WS\WS_Processing\1#\sketch_1_1_20161227_114338\sketch_1_1_20161227_114338.pde
  @created-at: 2016/12/27 13:39:04
  @use variables:
    static final int TYPE_SERIAL      = 1;
    static final int TYPE_FORMATTED    = 2;
  @return
  TYPE_SERIAL       => serial      20161227_131300
  TYPE_FORMATTED    => formatted   2016/12/27 13:13:00
***************************************/
String get_time_label__Now(int type) {

  String label;
  
  switch(type) {
   
    case 1:
    
      label = nf(year(),4) + nf(month(),2) + nf(day(),2)
                
                + "_"
      
                + nf(hour(),2) + nf(minute(),2) + nf(second(),2);
    
      break;
    
    case 2:
    
      label = nf(year(),4) + "/" + nf(month(),2) + "/" + nf(day(),2)
                
                + " "
      
                + nf(hour(),2)  + ":" + nf(minute(),2) + ":" + nf(second(),2);
    
      break;
      
    default:
    
      label = nf(year(),4) + nf(month(),2) + nf(day(),2)
            
            + "_"
  
            + nf(hour(),2) + nf(minute(),2) + nf(second(),2);
    
      break;

  }
  
      // return
      return label;
     
}//get_time_label__Now(int type)