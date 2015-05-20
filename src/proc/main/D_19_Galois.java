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
//import java.util.Locale;

import proc.utils.Methods;
import processing.core.PApplet;

//import processing.opengl.*;

public class D_19_Galois extends PApplet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	////////////////////////////////

	// fields

	////////////////////////////////
	private int sleep_time;

	float x,y,z;
	
	float rot_Z, tick_Z = (float) 0.5;

	public void setup() {
//	  size(200,200,P3D);
		size(640,360,P3D);
	  x = width/2;
	  y = height/2;
	  z = 0;
	  
	  this.rot_Z = (float) 0.5;
	  
	  this.init_Vars();
	  
	}

	public void draw() {

		//REF http://learning.codasign.com/index.php?title=Drawing_in_3D_in_Processing
		background(100, 100, 150);
		 
		  pushMatrix(); 
		  translate(150, 150, 0);
		  rotateY(this.rot_Z);
//		  rotateY((float) 0.5);
		  rotateZ(this.rot_Z);
//		  rotateZ((float) 0.3);
		  box(100);
		  popMatrix();
		  
		  translate(250, 210, -100+this.rot_Z*10);
//		  translate(250, 210, -100);
		  rotateY(this.rot_Z);
		  sphere(100);
		
		  ///////////////////////////////////
		//
		// update:
		//
		///////////////////////////////////
		this.rot_Z += this.tick_Z;
		  
		///////////////////////////////////
		//
		// sleep
		//
		///////////////////////////////////
		try {
			
			Thread.sleep(this.sleep_time);
//				Thread.sleep(100);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
//		//REF https://processing.org/examples/primitives3d.html
//		background(0);
//		lights();
//
//		pushMatrix();
//		translate(130, height/2, 0);
//		rotateY((float) 1.25);
//		rotateX((float) -0.4);
//		noStroke();
//		box(100);
//		popMatrix();

//		pushMatrix();
//		translate(500, (float) (height*0.35), -200);
//		noFill();
//		stroke(255);
//		sphere(280);
//		popMatrix();
		
//	  translate(x,y,z);
//	  rectMode(CENTER);
//	  rect(0,0,100,100);
//
//	  z++; // The rectangle moves forward as z increments.
	}

	private void 
	init_Vars() {
		
		////////////////////////////////

		// others

		////////////////////////////////
		
		sleep_time = 200;
		
		tick_Z = (float) 0.5;
		
	}//init_Vars

	
}
