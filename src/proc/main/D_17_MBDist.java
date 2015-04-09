///////////////////////////////////
//
//	竹内淳『高校数学でわかるボルツマンの原理』
//	p.171
//	
//	A graph of Maxwell-Boltzmann distribution
//
//	<Keys>
//		1. 'a'	Increase the power of e^(-E/kBT)
//		2. 'd'	Decrease the power of e^(-E/kBT)
//
//
///////////////////////////////////
package proc.main;
import java.util.Locale;

import proc.utils.Methods;
import processing.core.PApplet;

public class D_17_MBDist extends PApplet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	////////////////////////////////

	// fields

	////////////////////////////////
	private int sleep_time;
	
	//REF color datatype http://forum.processing.org/two/discussion/2753/color-data-type-is-not-recognized-in-eclipse/p1 koogs January 31
	private int blue, green, red, white, black, yellow;

	///////////////////////////////////
	//
	// screen
	//
	///////////////////////////////////
	private final int disp_W = 1000;
	private final int disp_H = 800;

	///////////////////////////////////
	//
	// frame: graph
	//
	///////////////////////////////////
	private final int w1 = 300;
	private final int h1 = 100;
	
	///////////////////////////////////
	//
	// data
	//
	///////////////////////////////////
	final int data_Len = 600;
	
	double[] f = new double[this.data_Len]; 

	int scaling = 100;
//	int scaling = 10;	//=> working when Math.E --> no "-" flag
	
//	int scaling = 100;
	
	///////////////////////////////////
	//
	// render
	//
	///////////////////////////////////
	
	////////////////////////////////

	// funcs

	////////////////////////////////
	public void setup() {
		
		////////////////////////////////
		
		// color
		
		////////////////////////////////
		init_Colors();
		
		////////////////////////////////

		// screen

		////////////////////////////////
		this.init_Screen();
		
		////////////////////////////////

		// init: vars

		////////////////////////////////
		init_Vars();

		///////////////////////////////////
		//
		// draw: grid
		//
		///////////////////////////////////
		this.draw_Grids();
		
		///////////////////////////////////
		//
		// draw: graph frame
		//
		///////////////////////////////////
		this.draw_GraphFrame();

		///////////////////////////////////
		//
		// calc
		//
		///////////////////////////////////
		this.calc_Data();
		
//		for (int i = 0; i < this.f.length; i++) {
//			
//			f[i] = Math.pow(Math.E, i);
//			
//		}
		
		///////////////////////////////////
		//
		// draw: data
		//
		///////////////////////////////////
		this.draw_Data();
		
		////////////////////////////////
		
		// show: basic vars
		
		////////////////////////////////
//		show_BasicVars();

//		////////////////////////////////
//
//		// calc
//
//		////////////////////////////////
//		this.calc_Line();
//		
		////////////////////////////////

		// render

		////////////////////////////////
		
	}//public void setup()

	private void draw_Data() {
		// TODO Auto-generated method stub
		
//		fill(this.blue);
		
		int radius = 3;
		
		int range = width - 2 * this.w1;
		
//		String msg;
//		msg = String.format(Locale.JAPAN, "[%s : %d] range=%d", Thread
//				.currentThread().getStackTrace()[1].getFileName(), Thread
//				.currentThread().getStackTrace()[1].getLineNumber(), range);
//
//		System.out.println(msg);
		
		
		for (int i = 0; i < this.data_Len; i++) {
			
			ellipse(
				this.w1 + (int)Math.floor(this.f[i] * range), 
				this.h1 + i, 
				radius, radius);
			
//			ellipse(this.w1 + (int)this.f[i] * range, this.h1 + i, radius, radius);
//			ellipse(this.w1 + (int)this.f[i], this.h1 + i, radius, radius);
			
////			String msg;
//			msg = String.format(Locale.JAPAN, "[%s : %d] w = %d", Thread
//					.currentThread().getStackTrace()[1].getFileName(), Thread
//					.currentThread().getStackTrace()[1].getLineNumber(), 
//					(int)Math.floor(this.f[i] * range));
//			.currentThread().getStackTrace()[1].getLineNumber(), Math.ceil(this.f[i] * range));
			
//			msg = String.format(Locale.JAPAN, "[%s : %d] w = %f", Thread
//					.currentThread().getStackTrace()[1].getFileName(), Thread
//					.currentThread().getStackTrace()[1].getLineNumber(), this.f[i] * range);
//			
//			msg = String.format(Locale.JAPAN, "[%s : %d] w = %d", Thread
//					.currentThread().getStackTrace()[1].getFileName(), Thread
//					.currentThread().getStackTrace()[1].getLineNumber(), (int)this.f[i] * range);
//			
//			System.out.println(msg);
			
		}
		
		
		
	}//draw_Data

	private void calc_Data() {
		// TODO Auto-generated method stub
		
		for (int i = this.f.length - 1; i >= 0; i--) {
//			for (int i = 0; i < this.f.length; i++) {
			
			f[(this.f.length - 1) - i] = Math.pow(Math.E, (-1) * i / (double) this.scaling);
//			f[i] = Math.pow(Math.E, (-1) * i / (double) this.scaling);
//			f[i] = Math.pow(Math.E, i / (-1) * (double) this.scaling);
//			f[i] = Math.pow(Math.E, i / (double) this.scaling);
//			f[i] = Math.pow(Math.E, i / (double) 100);
//			f[i] = Math.pow(Math.E, i);
			
//			String msg;
//			msg = String.format(Locale.JAPAN, "[%s : %d] f[%d]=%f", Thread
//					.currentThread().getStackTrace()[1].getFileName(), Thread
//					.currentThread().getStackTrace()[1].getLineNumber(), i, f[i]);
//
//			System.out.println(msg);
			
			
		}

	}//calc_Data

	private void draw_GraphFrame() {
		// TODO Auto-generated method stub
		
		///////////////////////////////////
		//
		// draw
		//
		///////////////////////////////////
		stroke(this.black);
		
		strokeWeight(1);
		
		rect(this.w1, this.h1, width - 2 * w1, height - 2 * h1);
//		rect(this.w1, this.h1, width - this.w1, height - this.h1);
		
		
	}//draw_GraphFrame

	private void draw_Grids() {
		// TODO Auto-generated method stub
		
		color(this.red);

//		stroke(this.red);
//		stroke(10);
		
		strokeWeight(2);
		
		///////////////////////////////////
		//
		// frame
		//
		///////////////////////////////////
		stroke(this.blue);
		
		rect(0, 0, width - 1, height - 1);
		
		///////////////////////////////////
		//
		// axe: x
		//
		///////////////////////////////////
		stroke(this.red);
		
		line(0, height/2, width, height/2);
		
		///////////////////////////////////
		//
		// axe: y
		//
		///////////////////////////////////
		line(width/2, 0, width/2, height);
		
	}//draw_Grids

	private void init_Screen() {
		// TODO Auto-generated method stub
		
		////////////////////////////////

		// screen

		////////////////////////////////
		size(this.disp_W, this.disp_H);
//		size(1000, 800);

//		background(this.yellow);
		background(white);
//		background(0);

//		fill(this.yellow);
		
		///////////////////////////////////
		//
		// lines
		//
		///////////////////////////////////
//		color(this.red);
//
//		stroke(10);
//		
//		line(0, height/2, width, height/2);

	}

	private void 
	init_Colors() {
		// TODO Auto-generated method stub
		
		green = color(0, 255, 0);
		
		red = color(255, 0, 0);
		
		blue = color(0, 0, 255);
		
		white = color(255, 255, 255);
		
		black = color(0, 0, 0);
		
		yellow = color(255, 255, 0);
		
	}//init_Colors()

	private void 
	init_Vars() {
		// TODO Auto-generated method stub
		
		
		
		////////////////////////////////

		// others

		////////////////////////////////
		
		sleep_time = 1;
//		sleep_time = 100;
		
	}//init_Vars

	private void 
	show_BasicVars() {
		// TODO Auto-generated method stub
		
//		textSize(20);
//		
////		fill(this.blue);
////		color(this.blue);
//		
//		text("scaling = " + this.scaling, (width - this.w1 - 100), (this.h1 + 50));

		String msg;
		msg = String.format(Locale.JAPAN, "[%s : %d] scaling=%d", Thread
				.currentThread().getStackTrace()[1].getFileName(), Thread
				.currentThread().getStackTrace()[1].getLineNumber(), this.scaling);

		System.out.println(msg);
		
		
	}

	public void draw() {

		///////////////////////////////////
		//
		// draw: grid
		//
		///////////////////////////////////
		this.draw_Grids();
		
		///////////////////////////////////
		//
		// draw: graph frame
		//
		///////////////////////////////////
		this.draw_GraphFrame();

		///////////////////////////////////
		//
		// calc
		//
		///////////////////////////////////
		this.calc_Data();
		
//		for (int i = 0; i < this.f.length; i++) {
//			
//			f[i] = Math.pow(Math.E, i);
//			
//		}
		
		///////////////////////////////////
		//
		// draw: data
		//
		///////////////////////////////////
		this.draw_Data();
	
		
		///////////////////////////////////
		//
		// text
		//
		///////////////////////////////////
//		this.show_BasicVars();
		
		
		try {
			
			Thread.sleep(this.sleep_time);
//			Thread.sleep(100);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}//public void draw()

	void calc_Line() {
		
		
	}//void calc_Line()

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
		
	}
	
	private void 
	listener() {
		// TODO Auto-generated method stub
		
		switch(key) {
		
		case 'x': exit(); break;
		
		case 'a': this.scaling ++; break;
			
		case 'd': this.scaling --; break;

		default:
			
				break;
				
		}

		String msg;
		msg = String.format(Locale.JAPAN, "[%s : %d] key=%c / scaling=%d", Thread
				.currentThread().getStackTrace()[1].getFileName(), Thread
				.currentThread().getStackTrace()[1].getLineNumber(), key, this.scaling);

		System.out.println(msg);
		
		
	}//listener
	
}
