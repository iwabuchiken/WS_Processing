package proc.main;
import java.util.Locale;

import proc.utils.Methods;
import processing.core.PApplet;

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

	//REF https://docs.google.com/spreadsheets/d/1_9jHcRs-onRsSFT9cG1ep527LsbTo3XL9Fmwq_N_Lc8/edit#gid=607285292
	private double[] days = {1.1, 0.4, 0.3, 0.2, 2.6, 12.5, 12.3, 13.3, 14.3, 7.9, 1.8, 0.9};
	private double[] hours = {272.8, 251.4, 288.3, 273, 251.1, 207, 223.2, 229.4, 195, 244.9, 258, 254.2};

	private double[] range_Days = {0, 16};
//	private double[] range_Hours = {150, 301};
	private double[] range_Hours = {150, 300};

	int numOf_Histo = 4;
	
	int[] histo = new int[4];

	double[] starts = new double[4];
	double[] ends = new double[4];

	///////////////////////////////////
	//
	// render
	//
	///////////////////////////////////
	int offset_X = 100;
	int W = 100;
//	int W = 50;
//	int W = 200;
	
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
		// build: histo
		//
		///////////////////////////////////
		this.build_Histo();
		
		////////////////////////////////

		// setup

		////////////////////////////////
		this.setup_View();
		
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
		this.render_Pict();
		
	}//public void setup()

	private void 
	build_Histo() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < this.hours.length; i++) {
			
			for (int j = 0; j < this.starts.length; j++) {
				
				if (this.hours[i] >= this.starts[j] 
						&& this.hours[i] <= this.ends[j]) {
					
					this.histo[j] ++;
							
				}//if (this.hours[i] >= this.)
				
			}//for (int j = 0; j < this.starts.length; j++)
			
		}//for (int i = 0; i < this.hours.length; i++)

		///////////////////////////////////
		//
		// report
		//
		///////////////////////////////////
		for (int i = 0; i < this.histo.length; i++) {
			
			String msg;
			msg = String.format(
					Locale.JAPAN,
					"histo[%d]=%d", i, this.histo[i]
					);
			System.out.println(msg);
			
		}
		
	}//build_Histo

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
		double start = this.range_Hours[0];
		double end;
		
//		double[] starts = new double[4];
//		double[] ends = new double[4];
		
//		numOf_Histo = 5;
		
//		double diff_Hours = Methods.round((this.range_Hours[1] - this.range_Hours[0]) / 4, 3);
		double diff_Hours = Methods.round(
						(this.range_Hours[1] - this.range_Hours[0]) / numOf_Histo, 
						1);
//		double diff_Hours = Methods.round((this.range_Hours[1] - this.range_Hours[0]) / 4, 1);
		
//		starts[0] = start;
//		ends[3] = this.range_Hours[1];
		
		String msg;
		msg = String.format(
				Locale.JAPAN,
				"diff_Hours => %f", diff_Hours
				);
		System.out.println(msg);
		
		// index 1 ~ -2
		int i = 0;
		
		for (i = 0; i < starts.length -1; i++) {
			
			starts[i]	= start + diff_Hours * i;
			ends[i]		= starts[i] + diff_Hours - 0.1;
			
		}
		
		starts[i] = start + diff_Hours * i;
		ends[i] = this.range_Hours[1];
		
//		String msg;
		msg = String.format(
				Locale.JAPAN,
				"starts[0]=%f, ends[0]=%f / starts[3]=%f, ends[3]=%f",
				starts[0], ends[0], starts[3], ends[3]
				);
		System.out.println(msg);
		
		
		////////////////////////////////

		// others

		////////////////////////////////
		
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
		
//		this.calc_Line();
//		
//		this.render_Wave();
		
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

	void 
	render_Pict() {
		
		noStroke();
		
		///////////////////////////////////
		//
		// histogram
		//
		///////////////////////////////////
		int tmp = 255 / this.starts.length;
		
		for (int i = 0; i < this.starts.length; i++) {
			
			fill((this.histo[i] * tmp), 255, 0);
//			fill((i * tmp), 255, 0);
			
			rect(
					(float)offset_X, 
					(float)this.starts[i], 
//					(float)this.starts[0] + this.offset_X * i, 
					(float)W, 
//					(float)offset_X + W, 
					(float)(this.ends[i] - this.starts[i])
//					(float)this.ends[0] + this.offset_X * i
			);
//			rect((float)offset_X, (float)this.starts[0], (float)offset_X + W, (float)this.ends[0]);
			
			String msg;
			msg = String.format(
					Locale.JAPAN,
					"starts[%d]=%f, ends[%d]=%f", i, starts[i], i, ends[i]
					);
			System.out.println(msg);
			
			
		}
		
//		fill(255, 255, 0);
//		
//		rect((float)offset_X, (float)this.starts[0], (float)offset_X + W, (float)this.ends[0]);
		
		///////////////////////////////////
		//
		// points
		//
		///////////////////////////////////

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
