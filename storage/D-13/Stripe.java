import processing.core.*;

public class Stripe {
	
	int col;
	
	
	float x;       // horizontal location of stripe
	float speed;   // speed of stripe
	float w;       // width of stripe
	boolean mouse; // state of stripe (mouse is over or not?)
	PApplet parent; // The parent PApplet that we will render ourselves onto

	Stripe(PApplet p) {
		parent = p;
		x = 0;              // All stripes start at 0
		speed = parent.random(1);  // All stripes have a random positive speed
		w = parent.random(10,30);
		mouse = false;
	}

	// Draw stripe
	void display() {
		
//		col = parent.color(parent.random(200), parent.random(200), 100);
		
		parent.fill(col,100);
//		parent.fill(200,100);
		parent.noStroke();
		parent.rect(x,0,w,parent.height);
	}

	// Move stripe
	void move() {
		x += speed;
		if (x > parent.width+20) x = -20;
	}
	
	void setColor(int col) {
		
		this.col = col;
		
	}
	
}

// Learning Processing
// Daniel Shiffman
// http://www.learningprocessing.com

// Example 9-10: Interactive stripes

//public class Stripe {
//  
//	PApplet parent;
//	
//  float x;     // horizontal location of stripe
//  float speed; // speed of stripe
//  float w;     // width of stripe
//  
//  // A boolean variable keeps track of the object's state.
//  boolean mouse; // state of stripe (mouse is over or not?)
//
//  Stripe(PApplet p) {
//	    parent = p;
//  }
//  
//  Stripe() {
//    // All stripes start at 0
//    x = 0; 
//    // All stripes have a random positive speed
//    speed = parent.random(1); 
//    w = parent.random(10,30);
//    mouse = false;
//  }
//
//  // Draw stripe
//  void display() {
//    
//    // Boolean variable determines Stripe color.
//    if (mouse) { 
//    	parent.fill(255);
//    } else {
//    	parent.fill(255,100);
//    }
//    
//    parent.noStroke();
//    parent.rect(x,0,w,parent.height);
//  }
//
//  // Move stripe
//  void move() {
//    x += speed;
//    if (x > parent.width + 20) x = -20;
//  }
//
//// Check to see if point (mx,my) is inside the Stripe.
//  void rollover(int mx, int my) { 
//    // Left edge is x, Right edge is x + w
//    if (mx > x && mx < x + w) {
//      mouse = true;
//    } else {
//      mouse = false;
//    }
//  }
//}