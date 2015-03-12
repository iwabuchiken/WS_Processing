package proc.main;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import processing.core.*;

public class PlotScatter extends PApplet {
	
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

	// lines
	List<Double> list_X;
	List<Double> list_Y;
	
	double radian;
	
	double tick = Math.PI / 180;	//=> tick = 1 degree
	
	int spacing = 100;
	int radius = 5;
	int offset_X = width / 2;
	int offset_Y = height / 2;
	
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
		
		////////////////////////////////

		// setup

		////////////////////////////////
		this.setup_View();
		
		////////////////////////////////
		
		// show: basic vars
		
		////////////////////////////////
//		show_BasicVars();

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
		
		yellow = color(255, 255, 0);
		
	}//init_Colors()

	private void 
	init_Vars() {
		// TODO Auto-generated method stub
		
		////////////////////////////////

		// coordinates

		////////////////////////////////
	
		
		////////////////////////////////

		// others

		////////////////////////////////
		this.list_X = new ArrayList<Double>();
		this.list_Y = new ArrayList<Double>();
		
		this.radian = 0;
		
		this.offset_X = width / 2;
		this.offset_Y = height / 2;
		
		sleep_time = 1;
//		sleep_time = 100;
		
	}//init_Vars

	private void 
	show_BasicVars() {
		// TODO Auto-generated method stub
		
	}

	public void draw() {
	
//		this.setup_View();
		
//		background(white);
		
		this.calc_Line();
		
		this.render_Wave();
		
		try {
			
			Thread.sleep(this.sleep_time);
//			Thread.sleep(100);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}//public void draw()

	void calc_Line() {
		
		///////////////////////////////////
		//
		// new coordinates
		//
		///////////////////////////////////
		this.list_X.add(Math.sin(radian));
		this.list_Y.add(Math.cos(radian));

		///////////////////////////////////
		//
		// update: radian
		//
		///////////////////////////////////
		this.radian += this.tick;
		
	}//void calc_Line()

	void 
	render_Wave() {
		
		noStroke();
		
		///////////////////////////////////
		//
		// points
		//
		///////////////////////////////////
		double tmp = 0;
		
		int col_R;
		
		for (int i = 0; i < this.list_X.size(); i++) {
		
//			fill(red);
			
			if(tmp > Math.PI / 4) tmp = 0;
//			if(tmp > Math.PI / 2) tmp = 0;
//			if(tmp > Math.PI) tmp = 0;
//			if(tmp > Math.PI * 2) tmp = 0;
//			if(tmp > 360) tmp = 0;
			
			tmp = tmp + this.tick;
			
			col_R = (int) (255 * (tmp / Math.PI * 4));
//			col_R = (int) (255 * (tmp / Math.PI * 2));
//			col_R = (int) (255 * (tmp / Math.PI));
//			col_R = (int) (255 * (tmp / Math.PI / 2));
//			col_R = (int) (255 * (tmp / Math.PI * 4));
//			col_R = (int) (255 * (tmp / Math.PI * 2));
//			if(tmp > 255) tmp = 0;
			
//			//debug
//			String msg = String.format(
//					Locale.JAPAN,
//					"tmp=%f / col_R=%d / Math.PI=%f", tmp, col_R, Math.PI
//					);
//			System.out.println(msg);
			
			
			fill(col_R, 255,0);
//			fill(i,255,0);
			
			ellipse(
				(float)(list_X.get(i) * this.spacing + this.offset_X), 
				(float)(list_Y.get(i) * this.spacing + this.offset_Y),
				(float)(this.radius), (float)this.radius);
			
//			tmp = (int) (this.tick * (tmp / (double) 255));
//			tmp ++;
			
		}
		
		///////////////////////////////////
		//
		// reset screen
		//
		///////////////////////////////////
//		String msg = String.format(
//				Locale.JAPAN,
//				"list_X => %d", this.list_X.size()
//				);
//		System.out.println(msg);
		
		
		if (this.list_X.size() == 360) {
//			if (this.list_X.size() == 90) {
			
//			background(white);
			this.list_X.clear();
			this.list_Y.clear();
			
//			msg = String.format(
//					Locale.JAPAN,
//					"cleared"
//					);
//			System.out.println(msg);
			
			background(this.white);
			
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

//		this.listener();
		
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
