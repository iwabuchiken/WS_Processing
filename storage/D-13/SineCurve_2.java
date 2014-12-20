package proc.main;
import processing.core.*;

public class SineCurve_2 extends PApplet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	////////////////////////////////

	// fields

	////////////////////////////////
	private int text_X;
	private int text_Y;

	//REF color datatype http://forum.processing.org/two/discussion/2753/color-data-type-is-not-recognized-in-eclipse/p1 koogs January 31
	private int blue, green, red, white, black;

	// lines
	float[] yvals;
	
	int start_X, end_X, len_yvals, range, xspacing, sleep_time;
	
	double amplitude, tick_X, phase, freq;
	
	////////////////////////////////

	// funcs

	////////////////////////////////
	public void setup() {
		
		////////////////////////////////

		// screen

		////////////////////////////////
		this.init_Screen();
		
		////////////////////////////////

		// init: vars

		////////////////////////////////
		init_Vars();
		
		////////////////////////////////
		
		// color
		
		////////////////////////////////
		init_Colors();
		
		////////////////////////////////

		// setup

		////////////////////////////////
		this.setup_View();
		
		////////////////////////////////
		
		// show: basic vars
		
		////////////////////////////////
		show_BasicVars();

		////////////////////////////////

		// calc

		////////////////////////////////
		this.calc_Line();
		
		////////////////////////////////

		// render

		////////////////////////////////
		this.render_Wave();
		
	}

	private void init_Screen() {
		// TODO Auto-generated method stub
		
		////////////////////////////////

		// screen

		////////////////////////////////
		size(1000, 800);

		background(white);
//		background(0);


	}

	private void 
	init_Colors() {
		// TODO Auto-generated method stub
		
		green = color(0, 255, 0);
		
		red = color(255, 0, 0);
		
		blue = color(0, 0, 255);
		
		white = color(255, 255, 255);
		
		black = color(0, 0, 0);
		
	}

	private void 
	init_Vars() {
		// TODO Auto-generated method stub
		////////////////////////////////

		// text locations

		////////////////////////////////
		text_X = this.width / 2 + 100;
		
		text_Y = this.height / 2 + 50;
		
		////////////////////////////////

		// coordinates

		////////////////////////////////
		tick_X = 0.05;
//		tick_X = 0.1;
//		tick_X = 3;
		
		start_X = 10;
		end_X = width - 10;
		
		range = (int) ((end_X - start_X) / tick_X);
		
		
		len_yvals = (int)(range * tick_X);
		
		yvals = new float[len_yvals];
	
		////////////////////////////////

		// others

		////////////////////////////////
		amplitude = 100;
		
		xspacing = (int)(range / len_yvals);
		
		phase = 0;
		
		freq = 1;
		
		sleep_time = 100;
		
	}//init_Vars

	private void 
	show_BasicVars() {
		// TODO Auto-generated method stub
		
	}

	public void draw() {
	
//		this.setup_View();
		
		background(white);
		
		this.calc_Line();
		
		this.render_Wave();
		
		phase += tick_X;
		
//		if (phase > 10) {
//			
//			phase = 0;
//			
//		}
		
		try {
			
			Thread.sleep(this.sleep_time);
//			Thread.sleep(100);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		////////////////////////////////

		// key input

		////////////////////////////////
//		this.listener();
		
//		phase += sin((float) phase);
		
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

	private void 
	listener() {
		// TODO Auto-generated method stub
		
		switch(key) {
		
		case 'x': exit(); break;
		
		case 'a': freq += 0.1; break;
		case 'd': freq -= 0.1; break;
		
		case 'e': this.amplitude += 10; break;
		case 'c': this.amplitude -= 10; break;
		
		case 'r': this.sleep_time += 10; break;
		case 'v': 
			
			if (this.sleep_time > 0) this.sleep_time -= 10;
			
			break;
		
		}
		
		if (key == 'x') {
			
//			exit();
			
//		} else if (key == 'a') {
//			
//			freq += 0.1;
//			
//		} else if (key == 'd') {
//			
//			freq -= 0.1;
//			
//		} else if (key == 'e') {
//			
//			this.amplitude += 10;
//			
//		} else if (key == 'c') {
//			
//			this.amplitude -= 10;
//			
//		} else if (key == 'r') {
//			
//			this.sleep_time += 10;
//			
//		} else if (key == 'v') {
//			
//			if (this.sleep_time > 0) {
//				
//				this.sleep_time -= 10;
//				
//			}
			
		}

	}//listener

	void calc_Line() {
		
		double x = 0;
		float sin_value;
		
		for (int i = 0; i < yvals.length; i++) {
			
			sin_value = sin((float) (freq * x + phase));
//			sin_value = sin((float) ((float) x + phase));
//			sin_value = sin((float) x);
			
			yvals[i] = (float) (this.amplitude * sin_value);
//			yvals[i] = (float) (this.amplitude * (float) Math.sin(i));
			
			x += tick_X;
//			x += xspacing;
			
		}

	}

	void 
	render_Wave() {
		
		noStroke();
		
		for (int x = 0; x < yvals.length; x++) {
			
			fill(red);
			
//			stroke(red);
//			line(x * xspacing, height/2 - yvals[x], x * xspacing, height);
			
//			ellipse(10 + x * xspacing, height/2 - yvals[x], 5, 5);
			ellipse(x * xspacing, height/2 - yvals[x], 5, 5);
//			ellipse(x * tick_X, height/2 - yvals[x], 5, 5);
//			ellipse(x * tick_X, height/2 - yvals[x], tick_X, tick_X);
			
		}

		
	}//renderWave

	public void setup_View() {

		////////////////////////////////
		
		// frame
		
		////////////////////////////////
		stroke(blue);
		
		rect(0, 0, width - 1, height - 1);
		
		////////////////////////////////

		// base lines

		////////////////////////////////
		stroke(green);
		
		line(0, height/2, width, height/2);
		
		line(width/2, 0, width/2, height);
		
	}

	public void keyPressed() {

		this.listener();
		
		////////////////////////////////

		// exit

		////////////////////////////////
//		if (key == 'x') {
//			
//			exit();
//			
//		}
		
	}
	
	
}
