import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

public class Sketch extends PApplet {

   // Declaring variables
  PImage imgBack;
  PImage imgRock;
  PImage imgShip;
  PImage imgSun;

  Random myRandom = new Random();
	
  float Rockx1 = myRandom.nextInt((width - 0) + 1) + 0;
  float Rocky1 = myRandom.nextInt((height - 0) + 1) + 0;

  float Rockx2 = myRandom.nextInt((width - 0) + 1) + 0;
  float Rocky2 = myRandom.nextInt((height - 0) + 1) + 0;

  float CircleX = myRandom.nextInt((width - 0) + 1) + 0;
  float CircleY = myRandom.nextInt((height - 0) + 1) + 0;

  float Shipx = 0;
  float Shipy = 0;

  float RockSpeedX1 = myRandom.nextInt((5 - 1) + 1) + 1;
  float RockSpeedY1 = RockSpeedX1/2;

  float RockSpeedX2 = myRandom.nextInt((5 - 1) + 1) + 1;;
  float RockSpeedY2 = RockSpeedX2/2;

  float CircleSpeedx = myRandom.nextInt((5 - 1) + 1) + 1;;
  float CircleSpeedy = CircleSpeedx/2;

  double ShipSpeedX = 2;
  double ShipSpeedY = 2;
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
     // Loading the images
    imgBack = loadImage("spacebackground.jpg");
    imgRock = loadImage("rock.png");
    imgShip = loadImage("spacerocket.png");
    imgSun = loadImage("sun.png");
    
    background(imgBack);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  background(imgBack);

    
     // draw first rock and moves it
    image(imgRock, Rockx1, Rocky1);
    Rockx1 += RockSpeedX1;
    Rocky1 += RockSpeedY1;

    if (Rockx1 < 0 || Rockx1 > width-50) {
      RockSpeedX1 *= -1;
    }
  
    if (Rocky1 < 0 || Rocky1 > height-50) {
      RockSpeedY1 *= -1;
    }

    
     // draw second rock and moves it
    image(imgRock, Rockx2, Rocky2);
    Rockx2 += RockSpeedX2;
    Rocky2 += RockSpeedY2;

    if (Rockx2 < 0 || Rockx2 > width-50) {
      RockSpeedX2 *= -1;
    }
  
    if (Rocky2 < 0 || Rocky2 > height-50) {
      RockSpeedY2 *= -1;
    }

     // draw circle and moves it
    ellipse(CircleX, CircleY, 50, 50);
    CircleX += CircleSpeedx;
    CircleY += CircleSpeedy;

    if (CircleX < 0+25 || CircleX > width-25) {
      CircleSpeedx *= -1;
    }
  
    if (CircleY < 0+25 || CircleY > height-25) {
      CircleSpeedy *= -1;
    }
    

     // Sun draw
    image(imgSun, (width/2)-50, (height/2)-50);

     // Draws the rocket ship to the screen. 
    image(imgShip, Shipx, Shipy);

    Shipx += ShipSpeedX;
    Shipy = (float) Math.pow(Shipx, 2) / 750;
    Shipy += ShipSpeedX;

    
    if (Shipx < 0 || Shipx > width-50) {
      ShipSpeedX *= -1;
    }

    
    if (Shipy < 0 || Shipy > height-50) {
      ShipSpeedY *= -1;
    }
    
    
  }
  
  
  // define other methods down here.
}