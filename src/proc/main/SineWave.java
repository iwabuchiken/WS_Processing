package proc.main;
import processing.core.*;

public class SineWave extends PApplet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int xspacing = 10;   // How far apart should each horizontal location be spaced
//	int xspacing = 16;   // How far apart should each horizontal location be spaced
	int w;              // Width of entire wave

	double theta = 0.0;  // Start angle at 0
	double amplitude = 75.0;  // Height of wave
	double period = 500.0;  // How many pixels before the wave repeats
	double dx;  // Value for incrementing X, a function of period and xspacing
	float[] yvalues;  // Using an array to store height values for the wave
	
	float[] yvalues_Cos;  // Using an array to store height values for the wave

	int col = this.color(200, 100, 100);

	int count = 0;
	
	
	boolean f_reverse = false;
	
	public void setup() {
	  size(1000, 360);
//	  size(640, 360);
	  w = width+16;
	  dx = (TWO_PI / period) * xspacing;
	  yvalues = new float[w/xspacing];
	  
	  yvalues_Cos = new float[w/xspacing];
	  
	  background(0);

	  ////////////////////////////////

	// setup

	////////////////////////////////
//	  calcWave();
//	  
//	  this.setup_View();
	  
	}

	public void draw() {
	  background(0);
	  
	  calcWave();
	  renderWave();
	  
	  setup_View();
	  
	}

	void calcWave() {
	  // Increment theta (try different values for 'angular velocity' here
	  theta += 0.02;

	  // For every x value, calculate a y value with sine function
	  double x = theta;
	  for (int i = 0; i < yvalues.length; i++) {
//	    yvalues[i] = (float) (Math.sqrt(x) * this.amplitude);
	    yvalues[i] = (float) (sin((float) x)*amplitude);
	    
	    yvalues_Cos[i] = (float) (cos((float) x)*amplitude);
	    
	    x+=dx;
	  }
	}

	void renderWave() {
	  noStroke();
	  
	   if (count > 255) {
//		count = 0;
		   f_reverse = true;
		   
		} else if (count < 0) {
			
			f_reverse = false;
			
		}

	   if (f_reverse == true) {
		   
		   count --;
		   
	   } else {
		   
		   count ++;
		   
	   }
	   
	   
//	  fill(this.color(255, count, count));
	  
//	  fill(200);
	  // A simple way to draw the wave with an ellipse at each location
	  for (int x = 0; x < yvalues.length; x++) {
		  
		  fill(this.color(255, count, count));
		  
//	    ellipse(x*xspacing, height/2 - yvalues[x], 5, 5);
	    ellipse(x*xspacing, height/2+yvalues[x], 5, 5);
	    
	    fill(this.color(255 - count, 255, 255 - count));
	    
	    ellipse(x*xspacing, height/2+yvalues_Cos[x], 5, 5);
	    
	  }
	}

	public void setup_View() {
		
		stroke(this.color(0, 255, 0));
		
		line(0, height/2, width, height/2);
		
		stroke(this.color(0, 0, 255));
		
		line(width/2, 0, width/2, height);
		
	}
}
