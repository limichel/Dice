import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

Die one;
Die two;
Die three;
Die four;
public void setup()
{
	size(500, 500);
	noLoop();
}
public void draw()
{
	background(200);
	one = new Die(75, 75);
	two = new Die(275, 75);
	three = new Die(75, 275);
	four = new Die(275, 275);
	one.roll();
	two.roll();
	one.show();
	two.show();
	three.roll();
	four.roll();
	three.show();
	four.show();
	textSize(20);
	text(one.numDots+two.numDots, 240, 175);
	text(one.numDots+three.numDots, 150, 260);
	text(three.numDots+four.numDots, 240, 340);
	text(two.numDots+four.numDots, 340, 260);
	noStroke();
	fill(255, 100);
	rect(225, 225, 50, 50);
	fill(0);
	textSize(30);
	text(one.numDots+two.numDots+three.numDots+four.numDots, 230, 260);
}
public void mousePressed()
{
	redraw();
}
class Die //models one single dice cube
{
	int dieX, dieY, numDots;
	Die(int x, int y) //constructor
	{
		dieX = x;
		dieY = y;
		numDots = (int)(Math.random() * 6 + 1);
	}
	public void roll()
	{
		noStroke();
		fill((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
		rect(dieX, dieY, 150, 150);
	}
	public void show()
	{
		//one dot
		if(numDots == 1)
		{	
			fill(0);
			ellipse(dieX+75, dieY+75, 40, 40);
		}
		//two dots
		if(numDots == 2)
		{	
			fill(0);
			ellipse(dieX+125, dieY+25, 40, 40);
			ellipse(dieX+25, dieY+125, 40, 40);
		}
		//three dots
		if(numDots == 3)
		{	
			fill(0);
			ellipse(dieX+125, dieY+25, 40, 40);
			ellipse(dieX+75, dieY+75, 40, 40);
			ellipse(dieX+25, dieY+125, 40, 40);
		}
		//four dots
		if(numDots == 4)
		{
			fill(0);
			for(int x = 35; x <= 130; x += 80)
			{
				for(int y = 35; y <= 130; y += 80)
				{
					ellipse(dieX+x, dieY+y, 40, 40);
				}
			}
		}
		//five dots
		if(numDots == 5)
		{
			fill(0);
			for(int x = 35; x <= 130; x += 80)
			{
				for(int y = 35; y <= 130; y += 80)
				{
					ellipse(dieX+x, dieY+y, 40, 40);
				}
			}
			ellipse(dieX+75, dieY+75, 40, 40);
		}
		//six dots
		if(numDots == 6)
		{
			fill(0);
			for(int y = 35; y <= 135; y += 85)
			{
				for(int x = 25; x <= 125; x += 50)
				{
					ellipse(dieX+x, dieY+y, 40, 40);
				}
			}
		}
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
