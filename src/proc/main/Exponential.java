package proc.main;
import processing.core.*;

public class Exponential extends PApplet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	float[] yvalues;
	int xspacing = 5;   // How far apart should each horizontal location be spaced
//	int xspacing = 10;   // How far apart should each horizontal location be spaced
	int w;              // Width of entire wave
	double amplitude = 40.0;  // Height of wave
	double dx;  // Value for incrementing X, a function of period and xspacing
	
	double x = 0;

	double power = 0.1;
	
	public void setup() {
		size(1000, 360);
		
		w = width+16;
		dx = 5;
		yvalues = new float[w/xspacing];
		
		background(0);

	}

	public void draw() {
//		background(color(0, 0, count));
	  background(0);
		
		calcWave();
		renderWave();

//		this.sleep(1);
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		setup_View();
		
	}

	void calcWave() {
		
		for (int i = 0; i < yvalues.length; i++) {
			
			yvalues[i] = (float) (this.amplitude * (float) Math.pow(i, power));
//			yvalues[i] = (float) Math.pow(i, power);
//			yvalues[i] = (float) Math.pow(x, power);
			
//			x+=dx;
		}
		
//		x+=dx;
		
		power += 0.1;
//		
		if (power > 2) {
			
			power = 0;
			
		}
		
	}

	void 
	renderWave() {
		noStroke();
		
//			if (count > 255) {
////		count = 0;
//			f_reverse = true;
//			
//		} else if (count < 0) {
//			
//			f_reverse = false;
//			
//		}
//
//			if (f_reverse == true) {
//			
//			count --;
//			
//			} else {
//			
//			count ++;
//			
//			}
			
			
//	  fill(this.color(255, count, count));
		
//	  fill(200);
		// A simple way to draw the wave with an ellipse at each location
		for (int x = 0; x < yvalues.length; x++) {
			
			fill(this.color(255, 0, 0));
			
//	    ellipse(x*xspacing, height/2 - yvalues[x], 5, 5);
			ellipse(x*xspacing, height/2 - yvalues[x], 5, 5);
			
//			fill(this.color(255 - count, 255, 255 - count));
//			
//			ellipse(x*xspacing, height/2+yvalues_Cos[x], 5, 5);
//			
//			fill(this.color(255, 0, 0));
//			
//			ellipse(x*xspacing, height/2+yvalues_Aggregate[x], 5, 5);
			
		}
		
		
//		////////////////////////////////
//	
//		// circle
//	
//		////////////////////////////////
//		if (alpha > 2 * Math.PI) {
//			
//			alpha = 0.0;
//			
//		}
//		
//		fill(this.color(0, 0, 255));
//		
//		ellipse(
//			width/2 + 100 * cos((float) alpha), 
//			height/2 + 100 * sin((float) alpha), 
//			20, 20);
//		
//		alpha += Math.PI / (60 + 100 * random(3));
////		alpha += Math.PI / (180 + 60 * random(3));
////		alpha += Math.PI / 180;
////		alpha += Math.PI / 360;
		
	}//renderWave

	public void setup_View() {
		
		stroke(this.color(0, 255, 0));
		
		line(0, height/2, width, height/2);
		
		stroke(this.color(0, 0, 255));
		
		line(width/2, 0, width/2, height);
		
	}
}
