package proc.main;
import processing.core.*;

public class SineCurve_3 extends PApplet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	////////////////////////////////

	// fields

	////////////////////////////////
	//REF color datatype http://forum.processing.org/two/discussion/2753/color-data-type-is-not-recognized-in-eclipse/p1 koogs January 31
	private int blue, green, red, white, black;

	// lines
	float[] yvals;
	
	int start_X, end_X, len_yvals, range, tick_X, sleep_time,
			padding_X = 50;
//	int start_X, end_X, len_yvals, range, tick_X, sleep_time;
//	int start_X, end_X, len_yvals, range, xspacing, sleep_time;
	
	int disp_X = 1000, disp_Y = 800;
	
	double amplitude, phase, freq, tick_Theta;
//	double amplitude, tick_X, phase, freq;
	
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
		
//		////////////////////////////////
//		
//		// show: basic vars
//		
//		////////////////////////////////
//		show_BasicVars();
//
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
		size(disp_X, disp_Y);

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
		
		////////////////////////////////

		// coordinates

		////////////////////////////////
		start_X = this.padding_X;
		end_X = width - this.padding_X;
//		start_X = 10;
//		end_X = width - 10;
		
		tick_X = 3;
		
		this.range = end_X - start_X;
		
		len_yvals = (int) (this.range / this.tick_X);
		
		yvals = new float[len_yvals];
	
		////////////////////////////////

		// others

		////////////////////////////////
		amplitude = 100;
		
		phase = 0;
		
		freq = 1;
		
		sleep_time = 100;
		
		tick_Theta = 0.1;
		
	}//init_Vars

	private void 
	show_BasicVars() {
		// TODO Auto-generated method stub
		
	}

	public void draw() {
	
//		this.setup_View();
		
//		background(white);
		
//		this.calc_Line();
//		
//		this.render_Wave();
//		
//		phase += tick_X;
//		
////		if (phase > 10) {
////			
////			phase = 0;
////			
////		}
//		
//		try {
//			
//			Thread.sleep(this.sleep_time);
////			Thread.sleep(100);
//			
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
			
			x += tick_Theta;
			
		}

	}

	void 
	render_Wave() {
		
		noStroke();
		
		int p_X, p_Y;
		
		for (int i = 0; i < yvals.length; i++) {
			
			fill(red);
			
			p_X = start_X + tick_X * i;
			p_Y = (int) (height / 2 - this.yvals[i]);
			
			ellipse(p_X, p_Y, 5, 5);
//			ellipse(x * xspacing, height/2 - yvals[x], 5, 5);
			
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
