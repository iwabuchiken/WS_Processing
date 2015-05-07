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

public class D_18_Rotate extends PApplet {
	
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
	// vertexes
	int x1, y1;
	int x2, y2;
	int x3, y3;
	int x4, y4;

	double th = 0;
	
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
		


	}//public void setup()

	public void draw() {

		///////////////////////////////////
		//
		// repaint
		//
		///////////////////////////////////
		fill(white);
		
		///////////////////////////////////
		//
		// draw: grid
		//
		///////////////////////////////////
		this.draw_Grids();

		///////////////////////////////////
		//
		// images
		//
		///////////////////////////////////
//		fill(red);
		
		stroke(green);
		
		beginShape();
		vertex(x1,y1);
		vertex(x2,y2);
		vertex(x3,y3);
		vertex(x4,y4);
//		vertex(width/2, height/2);
//		vertex(width/2+100, height/2);
//		vertex(width/2+100, height/2-100);
//		vertex(width/2+0, height/2-100);
		
		endShape(CLOSE);
		
		///////////////////////////////////
		//
		// rotate: theta
		//
		///////////////////////////////////
		this.th += Math.PI / 720;
		
		///////////////////////////////////
		//
		// recalc
		//
		///////////////////////////////////
		this.calc();
		
		///////////////////////////////////
		//
		// text
		//
		///////////////////////////////////
		this.draw_Texts();

		///////////////////////////////////
		//
		// sleep
		//
		///////////////////////////////////
		try {
			
			Thread.sleep(this.sleep_time);
//			Thread.sleep(100);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}//public void draw()

	public void
	calc() {
		
//		x1 = this.rotate_X(x1, y1) + width/2;
//		y1 = this.rotate_Y(y1, x1) + height/2;
//		
//		x2 = this.rotate_X(x2, y2) + width/2;
//		y2 = this.rotate_Y(y2, x2) + height/2;
//		
//		x3 = this.rotate_X(x3, y3) + width/2;
//		y3 = this.rotate_Y(y3, x3) + height/2;
//		
//		x4 = this.rotate_X(x4, y4) + width/2;
//		y4 = this.rotate_Y(y4, x4) + height/2;
		
		x1 = this.rotate_X(x1, y1);
		y1 = this.rotate_Y(y1, x1);
		
		x2 = this.rotate_X(x2, y2);
		y2 = this.rotate_Y(y2, x2);
		
		x3 = this.rotate_X(x3, y3);
		y3 = this.rotate_Y(y3, x3);
		
		x4 = this.rotate_X(x4, y4);
		y4 = this.rotate_Y(y4, x4);
		
		
	}//calc

	public int
	rotate_X(double x, double y) {
		
		return (int) (x*Math.cos(this.th) + y*Math.sin(this.th));
		
	}
	
	public int
	rotate_Y(double y, double x) {
		
		return (int) (y*Math.cos(this.th) - x*Math.sin(th));
		
	}
	
	private void draw_Texts() {
		// TODO Auto-generated method stub
		
		String msg = "yes";
		
		textSize(30);
		
		fill(blue);
		
		text(msg, 30, 30);

		
	}//draw_Texts
	

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
	init_Screen() {
		// TODO Auto-generated method stub
		
		////////////////////////////////

		// screen

		////////////////////////////////
		size(this.disp_W, this.disp_H);

		background(white);
		
	}

	private void 
	init_Vars() {
		// TODO Auto-generated method stub

		///////////////////////////////////
		//
		// coordinates
		//
		///////////////////////////////////
		x1 = width/2;		y1 = height/2;
		
		x2 = width/2 + 200;	y2 = height/2;

		x3 = width/2 + 200;	y3 = height/2 - 100;
		
		x4 = width/2;		y4 = height/2 - 100;
		
		////////////////////////////////

		// others

		////////////////////////////////
		
		sleep_time = 100;
//		sleep_time = 1;
//		sleep_time = 100;
		
	}//init_Vars

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

}
