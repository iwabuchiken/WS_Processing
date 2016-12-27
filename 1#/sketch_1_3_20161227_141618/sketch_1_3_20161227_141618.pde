/*
  file:  sketch_1_3_20161227_141618.pde
  
  created at: 2016/12/27 13:33:46
  
  <steps>
  1. copy/paster
    from: previous file or, C:\WORKS_2\WS\WS_Processing\1#\sketch_1_1_20161227_114338\sketch_1_1_20161227_114338.pde
  2. edit:
    1) fname_trunk
    
*/
import java.awt.Toolkit;

/**********************************
    constants
**********************************/
static final int TYPE_SERIAL      = 1;
static final int TYPE_FORMATTED    = 2;

static int STROKE    = 1;

static final String  fname_trunk  = "1_3";  
static final String  fname_ext  = ".png";

/**********************************
    variables
**********************************/
//color c = color(255, 204, 0);

color c_STROKE = color(0,0,0);

/**********************************
    functions
**********************************/
// Run this program only in the Java mode inside the IDE,
// not on Processing.js (web mode)!!

// To convert images to a movie you can use:
// ffmpeg -i seq-%04d.tga -r 25 -threads 4 video.mp4

int c = 255;

void setup() {
  size(640, 480);
  background(0);
  frameRate(25);
  noStroke();
  rectMode(CENTER);
}
void draw() {
  fill(c, random(100));

  float sz = random(200);

  rect(random(width), random(height), sz, sz);

  if(frameCount % 200 == 0) {
    c = 255 - c; // 255 0 255 0 255 0 ..
  }
  saveFrame("frame-####.tif");

  if(frameCount > 500) { // 20 seconds * 25 fps = 500
    noLoop();
  }
}




/***************************************
  String get_time_label__Now(int type)
  
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