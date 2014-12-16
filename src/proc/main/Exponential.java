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
	double amplitude = 400.0;  // Height of wave
	double dx;  // Value for incrementing X, a function of period and xspacing
	
	double x = 0;

	double power = 2, base = 1, tick_Base = 0.0005;
//	double power = 2, base = 0.0005, tick_Base = 0.0005;

	int offset_X = 100, offset_Y = 150, text_X, text_Y;

	int magnify = 0;

	////////////////////////////////

	// funcs

	////////////////////////////////
	public void setup() {
		
		size(1000, 360);

		background(0);

		////////////////////////////////

		// init: vars

		////////////////////////////////
		init_Vars();
		
		////////////////////////////////
		
		// show: basic vars
		
		////////////////////////////////
		show_BasicVars();
		
//		textSize(20);
//		
//		fill(0, 255, 255);
//		
//		text("base = " + base, 100, 100);
//		
//		text("power = " + power, 100, 125);
//		
//		text("tick_Base = " + tick_Base, 100, 150);
		
		////////////////////////////////

		// setup

		////////////////////////////////
		w = width+16;
		dx = 5;
		yvalues = new float[w/xspacing];
		
		calcWave_2();
		
		renderWave_2();

	}

	private void 
	init_Vars() {
		// TODO Auto-generated method stub
		
		text_X = this.width / 2 + 100;
		
		text_Y = this.height / 2 + 50;
	}

	private void 
	show_BasicVars() {
		// TODO Auto-generated method stub
		
		textSize(20);
		
		fill(0, 255, 255);
		
		text("base = " + base, text_X, text_Y);
		
		text("power = " + power, text_X, text_Y + 25);
		
		text("tick_Base = " + tick_Base, text_X, text_Y + 50);

		text("amplitude = " + amplitude, text_X, text_Y + 75);
		
		text("offset_Y = " + offset_Y, text_X, text_Y + 100);

		fill(0, 255, 0);
		
		text("width = " + this.width, text_X, text_Y + 125);
		
	}

	public void draw() {
		
//		background(0);
//		
//		calcWave();
//		renderWave();
//
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	void calcWave() {
		
		for (int i = 0; i < yvalues.length; i++) {
			
			yvalues[i] = (float) (this.amplitude * (float) Math.pow(i, power));
//			yvalues[i] = (float) (this.amplitude * (float) Math.pow(i, power));
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

	void calcWave_2() {

//		double base = 0.1;
		
		for (int i = 0; i < yvalues.length; i++) {
			
			yvalues[i] = magnify 
							+ (float) (this.amplitude * (float) Math.pow(base, power));
//			yvalues[i] = (float) (this.amplitude * (float) Math.pow(i, power));
//			yvalues[i] = (float) (this.amplitude * (float) Math.pow(i, power));
//			yvalues[i] = (float) Math.pow(i, power);
//			yvalues[i] = (float) Math.pow(x, power);
			
			base += tick_Base;
			
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

	void 
	renderWave_2() {
		
		noStroke();
		
		// A simple way to draw the wave with an ellipse at each location
		for (int x = 0; x < yvalues.length; x++) {
			
			fill(this.color(255, 0, 0));
			
			ellipse(offset_X + x*xspacing, offset_Y + height/2 - yvalues[x], 5, 5);
			
		}
		
	}//renderWave_2
	
	public void setup_View() {
		
		stroke(this.color(0, 255, 0));
		
		line(0, height/2, width, height/2);
		
		stroke(this.color(0, 0, 255));
		
		line(width/2, 0, width/2, height);
		
	}
}
