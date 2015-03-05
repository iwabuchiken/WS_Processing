package proc.main;
import java.util.Locale;

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
	float[] yvals_2;
	float[] yvals_3;
	float[] yvals_4;
	float[] yvals_5;
	float[] yvals_sum;
	
	int start_X, end_X, len_yvals, range, xspacing, sleep_time;
	
	double amplitude, tick_X, phase, freq;

	float sin_value;
	float sin_value_2;	// freq = 2
	float sin_value_3;	// freq = 1/2
	float sin_value_4;	// 
	float sin_value_5;	// 

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

		///////////////////////////////////
		//
		// lines
		//
		///////////////////////////////////
		color(this.red);

		stroke(10);
		
		line(0, height/2, width, height/2);

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
		tick_X = 0.07;
//		tick_X = 0.1;
//		tick_X = 0.1;
//		tick_X = 3;
		
		start_X = 10;
		end_X = width - 10;
		
		range = (int) ((end_X - start_X) / tick_X);
		
		
		len_yvals = 2000;
//		len_yvals = (int)(range * tick_X);
		
		yvals = new float[len_yvals];
		yvals_2 = new float[len_yvals];
		yvals_3 = new float[len_yvals];
		yvals_4 = new float[len_yvals];
		yvals_5 = new float[len_yvals];
		yvals_sum = new float[len_yvals];
	
		////////////////////////////////

		// others

		////////////////////////////////
		amplitude = 100;
		
		xspacing = (int)(range / len_yvals);
		
		phase = 0;
		
		freq = 2;
//		freq = 8;
//		freq = 10;
		
		sleep_time = 1;
//		sleep_time = 100;
		
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
//		float sin_value;
//		float sin_value_2;	// freq = 2
//		float sin_value_3;	// freq = 1/2
		
		for (int i = 0; i < yvals.length; i++) {
			
			sin_value = sin((float) (freq * x + phase));
			sin_value_2 = sin((float) (freq * 2 * x + phase));
			sin_value_3 = sin((float) (freq * ((float)1/2) * x + phase));
			sin_value_4 = sin((float) (freq * x + Math.PI / 4));
//			sin_value_3 = sin((float) (freq * (1/2) * x + phase));
//			sin_value = sin((float) ((float) x + phase));
//			sin_value = sin((float) x);
			
			yvals[i] = (float) (this.amplitude * sin_value);
			yvals_2[i] = (float) (this.amplitude * sin_value_2);
			yvals_3[i] = (float) (this.amplitude * sin_value_3);
			yvals_4[i] = (float) (this.amplitude * sin_value_4);
			
			yvals_sum[i] = yvals[i] + yvals_2[i] + yvals_3[i] + yvals_4[i];
//			yvals[i] = (float) (this.amplitude * (float) Math.sin(i));
			
			x += tick_X;
//			x += xspacing;
			
		}

	}//void calc_Line()

	void 
	render_Wave() {
		
		noStroke();
		
		for (int x = 0; x < yvals.length; x++) {
			
//			fill(black);
			fill(red);
			
//			stroke(red);
//			line(x * xspacing, height/2 - yvals[x], x * xspacing, height);
			
//			ellipse(10 + x * xspacing, height/2 - yvals[x], 5, 5);
			ellipse(x * xspacing, height/2 - yvals[x], 5, 5);
			
			fill(this.blue);
			ellipse(x * xspacing, height/2 - yvals_2[x], 5, 5);
			
			fill(this.green);
			ellipse(x * xspacing, height/2 - yvals_3[x], 5, 5);
			
//			//debug
//			textSize(32);
//			text("sum.length = " + yvals_sum.length
//					+ " / x = " + x
//					, 50, 50);

//			String msg = "x = " + x;
//			String msg = String.format(
//						"x = %d / sum.length = %d (%s)", 
//						x, yvals_sum.length,
//						(x > yvals_sum.length / 2)
//						);
//			System.out.println(msg);
			
			// sum
			if (x > yvals_sum.length / 2) {
//				if (x == yvals_sum.length / 2) {
				
//				String msg = String.format(
//						Locale.JAPAN,
//						"x = %d --> larger; fill is red", x
//						);
//				System.out.println(msg);
//				
//				fill(this.red);
//				ellipse(x * xspacing, height/2 - yvals_sum[x], 5, 5);
				
			} else if (x <= yvals_sum.length / 2) {//if (x = yvals_sum.length / 2)
//			} else {//if (x = yvals_sum.length / 2)
				
//				String msg = String.format(
//						Locale.JAPAN,
//						"x = %d --> smaller; fill is blue", x
//						);
//				System.out.println(msg);
				
//				fill(this.blue);
				fill(this.black);
				ellipse(x * xspacing, height/2 - yvals_sum[x], 5, 5);
				
			}//if (x = yvals_sum.length / 2)
			
//			fill(this.black);
//			ellipse(x * xspacing, height/2 - yvals_sum[x], 5, 5);
//			ellipse(x * xspacing, height/2 - yvals[x]/2, 5, 5);
//			ellipse(x * tick_X, height/2 - yvals[x], 5, 5);
//			ellipse(x * tick_X, height/2 - yvals[x], tick_X, tick_X);
			
//			String msg = String.format(
//					Locale.JAPAN,
//					"next x"
//					);
//			System.out.println(msg);
			
		}

		stroke(10);
		line(0, height/2, width, height/2);
		line(width/2, 0, width/2, height);
		
		///////////////////////////////////
		//
		// text
		//
		///////////////////////////////////
		textSize(32);
		text("yes", 50, 50);
		
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
