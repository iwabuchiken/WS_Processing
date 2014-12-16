package proc.main;
import processing.core.*;

public class Exponential extends PApplet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	float[] yvalues, yvals, yvals_2;
	
	int xspacing = 3;   // How far apart should each horizontal location be spaced
//	int xspacing = 10;   // How far apart should each horizontal location be spaced
	int w;              // Width of entire wave
	double amplitude = 400.0;  // Height of wave
	double dx;  // Value for incrementing X, a function of period and xspacing
	
	double x = 0;

//	double power = 2, base = 1, tick_Base = 0.0005;
	double power = 0.2, power_2 = 1.2, base = 0.5, 
			tick_Base = 0.01, tick_X = 0.1;
//	double power = 0.1, base = 0.5, tick_Base = 0.01;
//	double power = 0.1, base = 0.1, tick_Base = 0.01;
//	double power = 0.1, base = 0.01, tick_Base = 0.01;
//	double power = 0.1, base = 0.0005, tick_Base = 0.0005;

//	int offset_X = 100, offset_Y = -100, text_X, text_Y;
	int offset_X = 100, offset_Y = 550, text_X, text_Y;

	int start_X = 0, end_X = 20;
	
	int magnify = 0;

	////////////////////////////////

	// funcs

	////////////////////////////////
	public void setup() {
		
		size(1000, 800);

		background(0);

		////////////////////////////////

		// init: vars

		////////////////////////////////
		init_Vars();
		
		////////////////////////////////

		// setup

		////////////////////////////////
		w = width+16;
		dx = 5;
		
		yvals = new float[(int) ((end_X - start_X) / tick_X)];
		yvals_2 = new float[(int) ((end_X - start_X) / tick_X)];
//		yvalues = new float[(int) ((end_X - start_X) / tick_X)];
//		yvalues = new float[w/xspacing];
		
		
		calcWave_3();
		
		renderWave_3();
//		calcWave_2();
//		
//		renderWave_2();

		////////////////////////////////
		
		// show: basic vars
		
		////////////////////////////////
		show_BasicVars();
		
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
		
		text("yvals.length = " + yvals.length, text_X, text_Y - 25);
		
		text("base = " + base, text_X, text_Y);
		
		text("power = " + power, text_X, text_Y + 25);
		
		text("tick_X = " + tick_X, text_X, text_Y + 50);
//		text("tick_Base = " + tick_Base, text_X, text_Y + 50);

		text("amplitude = " + amplitude, text_X, text_Y + 75);
		
		text("offset_Y = " + offset_Y, text_X, text_Y + 100);

		fill(0, 255, 0);
		
		text("width = " + this.width, text_X, text_Y + 125);
		
		text("yvals[0] = " + yvals[0], text_X, text_Y + 150);
		
		text("yvals[10] = " + yvals[10], text_X, text_Y + 175);
		
		text("yvals[20] = " + yvals[20], text_X, text_Y + 200);
		
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
		
		for (int i = start_X; i < yvalues.length; i++) {
//			for (int i = 0; i < yvalues.length; i++) {
			
			yvalues[i] = (float) (this.amplitude * (float) Math.pow(i, power));
//			yvalues[i] = (float) (this.amplitude * (float) Math.pow(base, power));
//			yvalues[i] = magnify 
//					+ (float) (this.amplitude * (float) Math.pow(base, power));
//			yvalues[i] = (float) (this.amplitude * (float) Math.pow(i, power));
//			yvalues[i] = (float) (this.amplitude * (float) Math.pow(i, power));
//			yvalues[i] = (float) Math.pow(i, power);
//			yvalues[i] = (float) Math.pow(x, power);
			
			base += tick_X;
//			base += tick_Base;
			
//			x+=dx;
		}
		
//		x+=dx;
		
		power += 0.1;
//		
		if (power > 2) {
			
			power = 0;
			
		}
		
	}
	
	void calcWave_3() {
		
		double x = 0;
		
		for (int i = start_X; i < yvals.length; i++) {
			
			yvals[i] = (float) (this.amplitude * (float) Math.pow(x, power));
			
			yvals_2[i] = (float) (this.amplitude * (float) Math.pow(x, power_2));
//			yvals_2[i] = (float) (this.amplitude * (float) Math.pow(x, power + 0.1));
			
			x += tick_X;
//			base += tick_X;
			
		}
		
	}
	
	void calcWave_3(double power) {
		
		double x = 0;
		
		for (int i = start_X; i < yvals.length; i++) {
			
			yvals[i] = (float) (this.amplitude * (float) Math.pow(x, power));
			
			yvals_2[i] = (float) (this.amplitude * (float) Math.pow(x, power_2));
//			yvals_2[i] = (float) (this.amplitude * (float) Math.pow(x, power + 0.1));
			
			x += tick_X;
//			base += tick_X;
			
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
			
//			ellipse(offset_X + x*xspacing, offset_Y + height - yvalues[x], 5, 5);
			ellipse(offset_X + x*xspacing, offset_Y + height/2 - yvalues[x], 5, 5);
			
		}
		
	}//renderWave_2
	
	void
	renderWave_3() {
		
		noStroke();
		
		// A simple way to draw the wave with an ellipse at each location
		for (int x = 0; x < yvals.length; x++) {
			
			fill(this.color(255, 0, 0));
			
//			ellipse(x*xspacing, yvals[x], 5, 5);
			ellipse(x*xspacing, height - yvals[x], 5, 5);
			
//			ellipse(x*xspacing, height/2 - yvals[x], 5, 5);
			
		}
		
		for (int x = 0; x < yvals_2.length; x++) {
			
			fill(this.color(0, 255, 0));
			
			ellipse(x*xspacing, height - yvals_2[x], 5, 5);
			
//			ellipse(x*xspacing, height/2 - yvals[x], 5, 5);
			
		}
		
	}//renderWave_2
	
	public void setup_View() {
		
		stroke(this.color(0, 255, 0));
		
		line(0, height/2, width, height/2);
		
		stroke(this.color(0, 0, 255));
		
		line(width/2, 0, width/2, height);
		
	}

	public void keyPressed() {
		
		if (key == 'i') {
			
			power += 0.01;
			power_2 += 0.01;
			
		} else if (key == 'd'){

			power -= 0.01;
			power_2 -= 0.01;
			
		}
		
//		power += 0.1;
		
		this.calcWave_3();
		
		background(0);
		
		this.renderWave_3();
		
		this.show_BasicVars();
		
//		textSize(30);
//		
//		fill(0, 200, 100);
//		
//		text("index => " + this.key, 100, 100);
		
	}
	
	
}
