package dev.jcps;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * <p>
 * ATrain class extends JFrame and implements several interfaces for handling Java applets, mouse events, and key events.
 * This class represents the main frame of the ATrain application, which includes the graphical user interface and event handling functionalities.
 * It provides methods to control the animation of a train moving on tracks with various obstacles and challenges.
 * </p>
 * <p>
 * This class serves as the entry point for the ATrain application and contains the main logic for initializing and running the animation.
 * It utilizes the JFrame class for creating the main application window and handles user interactions through mouse and keyboard events.
 * </p>
 * <p>
 * This class implements the JavaAppletAdapter, MouseListener, and KeyListener interfaces to adapt to different Java environments and handle user input.
 * </p>
 *
 * @see JFrame
 * @see JavaAppletAdapter
 * @see MouseListener
 * @see KeyListener
 */
public class ATrain extends JFrame implements JavaAppletAdapter, MouseListener, KeyListener {
    /**
     * Chimes sound. Played at intermission.
     */
    protected static Clip madeIt;
    /**
     * Crash sound for when train crashes.
     */
    protected static Clip crash;
    /**
     * Plop sound. Played when hitting a hole on the lava level.
     */
    protected static Clip hole;
    /**
     * Clank sound. Played when wheels hit track after a jump.
     */
    protected static Clip drum2;
    /**
     * Ricochet sound. Played at start of level.
     */
    protected static Clip bullet;
    /**
     * The Jump sound. Played when jumping.
     */
    protected static Clip jumpSnd;
    /**
     * Hiss sound
     */
    protected static Clip hiss;
    /**
     * Drum roll sound
     */
    protected static Clip finish;
    /**
     * Fill up sound. Played when collecting energy
     */
    protected static Clip fillUp;
    /**
     * Jets sound. Played on Level 3
     */
    protected static Clip jets;
    /**
     * Tree color
     */
    protected static Color treecolor;
    /**
     * The color of the tree's stump.
     */
    protected static Color stumpcolor;

    /**
     * The color of the train's shadow.
     */
    protected static Color shadowcolor;

    /**
     * The color of the ocean.
     */
    protected static Color oceancolor;

    /**
     * The current lava level.
     */
    protected static int lava;

    /**
     * The current cloud position.
     */
    protected static int cloud;

    /**
     * The current grass position.
     */
    protected static int grass;

    /**
     * The sleeper variable.
     */
    protected static int sleeper;

    /**
     * Animation clock.
     */
    protected static int aniClock;

    /**
     * Finish time variable.
     */
    protected static int finishTime;

    /**
     * Step variable.
     */
    protected static int step;

    /**
     * Speed of the train.
     */
    protected static int speed;

    /**
     * Last recorded speed of the train.
     */
    protected static int lastSpeed;

    /**
     * Top speed of the train.
     */
    protected static int topSpeed;

    /**
     * Minimum speed of the train.
     */
    protected static int minSpeed;

    /**
     * Vertical speed.
     */
    protected static int vSpeed;

    /**
     * Timer variable.
     */
    protected static int timer;

    /**
     * LC Time variable.
     */
    protected static int lcTime;

    /**
     * SR Time variable.
     */
    protected static int srTime;

    /**
     * SN Time variable.
     */
    protected static int snTime;

    /**
     * E Time variable.
     */
    protected static int eTime;

    /**
     * T Time variable.
     */
    protected static int tTime;

    /**
     * B Time variable.
     */
    protected static int bTime;

    /**
     * Jump variable.
     */
    protected static int jump;

    /**
     * Jump count variable.
     */
    protected static int jumpCount;

    /**
     * Dead status variable.
     */
    protected static int dead;

    /**
     * All done status variable.
     */
    protected static int allDone;

    /**
     * Current stage of the game.
     */
    protected static int stage;

    /**
     * Current level of the game.
     */
    protected static int level;

    /**
     * Current position of track 1.
     */
    protected static int track1Y;

    /**
     * Current position of the train.
     */
    protected static int trainY;

    /**
     * Current x-coordinate of the train.
     */
    protected static int dx;

    /**
     * Current y-coordinate of the train.
     */
    protected static int dy;

    /**
     * Goal variable.
     */
    protected static int goal;

    /**
     * Distance variable.
     */
    protected static int distance;

    /**
     * X-coordinate of the tank.
     */
    protected static int tankX;

    /**
     * Y-coordinate of the tank.
     */
    protected static int tankY;

    /**
     * Rock time variable.
     */
    protected static int rockTime;

    /**
     * Early rock time variable.
     */
    protected static int earlyRock;

    /**
     * Color 0.
     */
    protected static Color c0;

    /**
     * Color 1.
     */
    protected static Color c1;

    /**
     * Color 2.
     */
    protected static Color c2;

    /**
     * Color 3.
     */
    protected static Color c3;

    /**
     * Color 4.
     */
    protected static Color c4;

    /**
     * Color 5.
     */
    protected static Color c5;

    /**
     * Color 6.
     */
    protected static Color c6;

    /**
     * Color 7.
     */
    protected static Color c7;

    /**
     * Color 8.
     */
    protected static Color c8;

    /**
     * Color 9.
     */
    protected static Color c9;

    /**
     * Color A.
     */
    protected static Color ca;

    /**
     * Color B.
     */
    protected static Color cb;

    /**
     * Color C.
     */
    protected static Color cc;

    /**
     * Array of star colors.
     */
    protected static Color[] starcolor;

    /**
     * Image object.
     */
    public static Image image;

    /**
     * Array of grass images.
     */
    protected static Image[] grassPics;

    /**
     * Horizontal size variable.
     */
    protected static int hSize;

    /**
     * Reverse horizontal size variable.
     */
    protected static int rhSize;

    /**
     * Vertical size variable.
     */
    protected static int vSize;

    /**
     * Reverse vertical size variable.
     */
    protected static int rvSize;

    /**
     * Image width variable.
     */
    protected static int iw;

    /**
     * Image height variable.
     */
    protected static int ih;

    static {
        ATrain.madeIt = null;
        ATrain.crash = null;
        ATrain.hole = null;
        ATrain.drum2 = null;
        ATrain.bullet = null;
        ATrain.jumpSnd = null;
        ATrain.hiss = null;
        ATrain.finish = null;
        ATrain.fillUp = null;
        ATrain.jets = null;
        ATrain.treecolor = new Color(20, 160, 20);
        ATrain.stumpcolor = new Color(180, 60, 20);
        ATrain.shadowcolor = new Color(30, 100, 0);
        ATrain.oceancolor = new Color(30, 120, 240);
        ATrain.lava = 80;
        ATrain.sleeper = 10;
        ATrain.step = 15;
        ATrain.topSpeed = 20;
        ATrain.minSpeed = 10;
        ATrain.lcTime = 2900;
        ATrain.srTime = 2900;
        ATrain.bTime = 10000;
        ATrain.track1Y = 80;
        ATrain.trainY = 80;
        ATrain.goal = 50000;
        ATrain.tankX = 378;
        ATrain.tankY = 100;
        ATrain.earlyRock = 99;
        ATrain.c0 = Color.black;
        ATrain.c1 = Color.blue;
        ATrain.c2 = Color.cyan;
        ATrain.c3 = Color.darkGray;
        ATrain.c4 = Color.gray;
        ATrain.c5 = Color.green;
        ATrain.c6 = Color.lightGray;
        ATrain.c7 = Color.magenta;
        ATrain.c8 = Color.orange;
        ATrain.c9 = Color.pink;
        ATrain.ca = Color.red;
        ATrain.cb = Color.white;
        ATrain.cc = Color.yellow;
        ATrain.starcolor = new Color[]{ATrain.c1, ATrain.c2, ATrain.c7, ATrain.c8, ATrain.c9,
                ATrain.ca, ATrain.cc, ATrain.c6};
        ATrain.grassPics = new Image[4];
        ATrain.iw = 96;
        ATrain.ih = 96;
    }

    /**
     * Animation timer.
     */
    Timer aniTimer;

    /**
     * Main method to start the ATrain application.
     * <p>
     * This method is responsible for creating an instance of the ATrain class and initializing it.
     * It sets the size of the application window to 400x210 pixels, sets the title to "A-Train", sets the default close operation to exit on close,
     * adds a mouse listener to the application window, and adds a key listener to the application window.
     * It also sets the window to be undecorated, centered on the screen, and visible.
     * Finally, it starts the animation by calling the start() method on the ATrain instance.
     * </p>
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        ATrain game = new ATrain();
        game.init();
        game.setSize(400, 210);
        game.setTitle("A-Train");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.addMouseListener(game);
        game.addKeyListener(game);
        game.setUndecorated(true);
        game.setLocationRelativeTo(null);
        game.setVisible(true);
        game.start();
    }

    /**
     * Initializes the ATrain application.
     * <p>
     * This method is responsible for initializing the ATrain application by setting up the graphical user interface and event handling.
     * It sets the background color to black, sets the foreground color to white, loads the images and sounds used in the game, and sets up the timer for the animation.
     * </p>
     */
    public synchronized void init() {
        this.setForeground(Color.white);
        this.setBackground(Color.black);
        ATrain.image = this.getImage(this.getDocumentBase(), "atrain.gif");
        ATrain.grassPics[0] = this.getImage(this.getDocumentBase(), "1grassc.gif");
        ATrain.grassPics[1] = this.getImage(this.getDocumentBase(), "1palm.gif");
        ATrain.grassPics[2] = this.getImage(this.getDocumentBase(), "1lava.gif");
        ATrain.grassPics[3] = this.getImage(this.getDocumentBase(), "1lavab.gif");
        ATrain.bullet = this.getAudioClip(this.getDocumentBase(), "bullet.wav");
        //if (ATrain.bullet == null) ATrain.bullet = this.getAudioClip(this.getCodeBase().toString(), "bullet.wav");
        ATrain.hole = this.getAudioClip(this.getDocumentBase(), "hole.wav");
        ATrain.drum2 = this.getAudioClip(this.getDocumentBase(), "drum2.wav");
        ATrain.jumpSnd = this.getAudioClip(this.getDocumentBase(), "pin.wav");
        ATrain.madeIt = this.getAudioClip(this.getDocumentBase(), "madeit.wav");
        ATrain.crash = this.getAudioClip(this.getDocumentBase(), "crash.wav");
        ATrain.hiss = this.getAudioClip(this.getDocumentBase(), "hiss.wav");
        (ATrain.finish = this.getAudioClip(this.getDocumentBase(), "finish.wav")).start();
        (ATrain.jets = this.getAudioClip(this.getDocumentBase(), "jets.wav")).start();
        ATrain.fillUp = this.getAudioClip(this.getDocumentBase(), "fillup.wav");
    }

    /**
     * Updates the graphical display of the component.
     * <p>
     * This method is responsible for updating the graphical display of the component.
     * It clips the graphics context based on the current train speed, then invokes the 'paint' method to repaint the component.
     * </p>
     *
     * @param graphics The graphics context used for rendering the components.
     */
    public synchronized void update(final Graphics graphics) {
        // Clip the graphics context based on the current train speed
        if (ATrain.speed > 0) {
            graphics.clipRect(0, 0, 400, 180);
        } else {
            graphics.clipRect(0, 0, 400, 210);
        }

        // Invoke the 'paint' method to repaint the component
        this.paint(graphics);
    }


    /**
     * <p>
     * Paints the graphical components on the screen.
     * </p>
     * <p>
     * This method is responsible for rendering the graphical elements on the screen.
     * It is automatically called by the system when the component needs to be painted or repainted.
     * If the train speed is zero, it invokes the 'drawPins' method to render the pins.
     *
     * @param graphics The graphics context used for rendering the components.
     */
    public void paint(final Graphics graphics) {
        // Check if the train speed is zero
        if (ATrain.speed == 0) {
            // If so, invoke the 'drawPins' method to render the pins
            this.drawPins();
        }
    }


    /**
     * <p>
     * Starts the animation timer.
     * </p>
     * <p>
     * This method initializes and starts a Timer object responsible for triggering the animation loop.
     * The Timer is set to execute the animation loop at regular intervals defined by the specified delay.
     * Upon execution, the animation loop invokes the {@code run} method to update the animation state.
     */
    public void start() {
        // Initialize a Timer object with a delay of 1 millisecond,
        // triggering the animation loop at regular intervals
        // and invoking the 'run' method to update the animation state
        aniTimer = new Timer(1, e -> this.run());
        aniTimer.start();
    }

    /**
     * This method represents the main logic for controlling the animation and movement
     * of the ATrain object.
     */
    public void run() {
        // Increment the timer and animation clock
        ++ATrain.timer;
        ++ATrain.aniClock;

        // Set the sleeper variable to control animation speed
        ATrain.sleeper = 12; //6
        if (ATrain.speed == 0) {
            // Increase sleeper when the train is stationary
            ATrain.sleeper += 14;
        }

        // Increase sleeper when the train reaches stage 3
        if (ATrain.stage == 3) {
            ATrain.sleeper += 100;
        }

        // Set the delay of the animation timer based on sleeper value
        aniTimer.setDelay(ATrain.sleeper * 2);

        // Repaint the component if the train is stationary
        if (ATrain.speed == 0) {
            this.repaint();
        }

        // Handle movement logic if the train is moving
        if (ATrain.speed > 0) {
            this.move();

            // Increase speed under certain conditions
            if (ATrain.jump == 0 && ATrain.speed < 20 && ATrain.aniClock % 100 == 99 && ATrain.stage < 2) {
                ++ATrain.speed;
            }

            // Update train's distance travelled
            ATrain.distance = ATrain.distance + ATrain.speed + (int) (Math.random() * 2.0);

            // Reset train's Y position if not jumping and not in stage 2
            if (ATrain.jump == 0 && ATrain.stage != 2) {
                ATrain.trainY = ATrain.track1Y;
            }

            // Handle end conditions if the train reaches its goal
            if (ATrain.distance > ATrain.goal && (ATrain.trainY == ATrain.track1Y || ATrain.stage == 2)) {
                --ATrain.aniClock;
                ATrain.speed = 0;
                ATrain.distance = ATrain.goal;
                ATrain.timer = 0;
                //ATrain.finish.loop(1);
            }

            // Handle jumping logic based on different stages and play corresponding sounds
            if (ATrain.jump == 1 && ATrain.stage < 2) {
                ATrain.jumpCount = 10;
                ATrain.jump = 2;
                ATrain.jumpSnd.setFramePosition(0);
                ATrain.jumpSnd.start();
            }
            if (ATrain.jump == 1 && ATrain.stage == 2) {
                ATrain.jumpCount = 12;
                ATrain.jump = 2;
                ATrain.jets.loop(1);
            }
            if (ATrain.jump == 1 && ATrain.stage == 3) {
                ATrain.allDone = 0;
                ATrain.stage = 0;
                ATrain.level = 0;
                ATrain.aniClock = 100;
                ATrain.goal = 1;
                ATrain.eTime = 0;
                ATrain.timer = 100;
                ATrain.speed = 0;
            }

            // Handle jumping motion and sound effects
            if (ATrain.jump == 2 && ATrain.jumpCount > 0) {
                ATrain.vSpeed += 6;
                --ATrain.jumpCount;
            }
            if (ATrain.jump == 2 && ATrain.jumpCount == 0) {
                ATrain.jump = 3;
                ATrain.trainY -= ATrain.vSpeed;
                ATrain.vSpeed = 0;
            }
            if (ATrain.jump == 3 && ATrain.stage != 2) {
                ATrain.trainY += 4;
                if (ATrain.trainY > ATrain.track1Y) {
                    ATrain.jump = 0;
                    ATrain.drum2.setFramePosition(0);
                    ATrain.drum2.start();
                }
            }
            if (ATrain.jump == 3 && ATrain.stage == 2) {
                ATrain.jump = 0;
            }

            // Adjust train's Y position based on stage
            if (ATrain.stage == 2) {
                ATrain.trainY += 4;
            }

            // Ensure train's Y position does not exceed maximum height
            if (ATrain.trainY > 160) {
                ATrain.trainY = 160;
            }
        }
    }

    /**
     * Draws the 'pins' during the game. Pins are like cards that appear on screen with information.
     */
    public synchronized void drawPins() {
        final Graphics graphics = this.getGraphics();
        if (ATrain.speed == 0) {
            // Draws explosion
            if (ATrain.aniClock < 250) {
                int colorInt = ATrain.aniClock * 2 % 256;
                if (colorInt > 127) {
                    colorInt = 255 - colorInt;
                }
                graphics.setColor(new Color(colorInt + 127, 0, 0));
                ATrain.finishTime = 0;
                if (ATrain.dead == 1 && ATrain.aniClock < 200 && Math.random() * 100.0 < 50.0) {
                    graphics.setColor(Color.yellow);
                }
                graphics.fillOval(50 - ATrain.aniClock, ATrain.trainY - ATrain.aniClock,
                        ATrain.aniClock * 4, ATrain.aniClock * 2);
                ATrain.aniClock += 2;
                if (ATrain.aniClock > 240 && ATrain.dead == 1) {
                    ATrain.crash.stop();
                }
            }
            // Draws the intermission 'pin'
            if (ATrain.goal == ATrain.distance && ATrain.finishTime == 0) {
                graphics.setColor(Color.black);
                graphics.fillRect(0, 178, 340, 16);
                graphics.setColor(Color.yellow);
                graphics.drawString("GREAT JOB!  YOU MADE IT IN ONLY " + formatTime(aniClock) + " sec!", 10, 190);
                ATrain.eTime += ATrain.aniClock;
                ATrain.finishTime = 1;
                ATrain.timer = 0;
                ++ATrain.level;
            }
            if (ATrain.aniClock >= 250) { // don't change from 250
                pinLoop:
                {
                    switch (ATrain.stage) {
                        case 0: {
                            switch (ATrain.level) {
                                // Draws the intro pin
                                case 0: {
                                    if (ATrain.aniClock < 252) {
                                        graphics.setColor(ATrain.stumpcolor);
                                        graphics.fillRect(80, 4, 240, 40);
                                        graphics.setColor(Color.yellow);
                                        graphics.drawRect(81, 5, 238, 38);
                                        graphics.drawRect(82, 6, 236, 36);
                                        graphics.setColor(Color.black);
                                        graphics.drawRect(80, 4, 240, 40);
                                        graphics.drawString("A-TRAIN", 98, 32);
                                        drawShadowText(graphics, "by Steve A. Baker", Color.white, 189, 31);
                                    }
                                    graphics.drawImage(ATrain.grassPics[0], 0, 50, 80, 120, null);
                                    graphics.drawImage(ATrain.grassPics[1], 44, 0, null);
                                    graphics.setColor(Color.white);
                                    graphics.drawString("A-TRAIN", 100, 30);
                                    graphics.drawString("Your job is to pilot the bullet-class,", 100, 60);
                                    graphics.drawString("A-Train on the SAWTOOTH RIDGE run along", 100, 74);
                                    graphics.drawString("the Pacific coast.  There are 6 stops to", 100, 88);
                                    graphics.drawString("make to complete this run.", 100, 102);
                                    graphics.drawString("Watch out for kid's beach balls that", 100, 116);
                                    graphics.drawString("have blown up from the coastline.", 100, 130);
                                    if (ATrain.aniClock < 408) {
                                        graphics.setColor(Color.orange);
                                        if (ATrain.aniClock / 8 % 2 == 1) {
                                            graphics.drawString("Please wait for images to board before departing," +
                                                    " thanx.", 30, 190);
                                        } else {
                                            graphics.setColor(ATrain.stumpcolor);
                                            graphics.drawString("Please wait for images to board before departing," +
                                                    " thanx.", 30, 190);
                                        }
                                    }
                                    graphics.setColor(Color.yellow);
                                    graphics.drawString("Best Track Record Time: " + formatTime(ATrain.bTime), 100, 144);
                                    break pinLoop;
                                }
                                // draw the inter-stage pin
                                case 1:
                                case 2:
                                case 3:
                                case 4: {
                                    if (ATrain.timer < 4) {
                                        graphics.setColor(ATrain.stumpcolor);
                                        graphics.fillRect(80, 4, 240, 90);
                                        graphics.setColor(Color.yellow);
                                        graphics.drawRect(81, 5, 238, 88);
                                        graphics.drawRect(82, 6, 236, 86);
                                        // Draw shadow text
                                        graphics.setColor(Color.black);
                                        graphics.drawRect(80, 4, 240, 90);
                                        drawShadowText(graphics, "SAWTOOTH RIDGE RUN", Color.white, 99, 21);
                                        drawShadowText(graphics, "Stage " + ATrain.level + " Complete", Color.white, 99, 41);
                                        drawShadowText(graphics, "There are " + (6 - ATrain.level) + " stops left.", Color.white, 99, 55);
                                        drawShadowText(graphics, "You're doing great kid.", Color.white, 99, 69);
                                        drawShadowText(graphics, "Elapsed Time: " + formatTime(ATrain.eTime) + " seconds.", Color.white, 99, 88);
                                        break pinLoop;
                                    }
                                    break pinLoop;
                                }
                                // Draw the inter-stage pin saying one stop left
                                case 5: {
                                    if (ATrain.timer < 4) {
                                        graphics.setColor(ATrain.stumpcolor);
                                        graphics.fillRect(80, 4, 240, 90);
                                        graphics.setColor(Color.yellow);
                                        graphics.drawRect(81, 5, 238, 88);
                                        graphics.drawRect(82, 6, 236, 86);
                                        graphics.setColor(Color.black);
                                        graphics.drawRect(80, 4, 240, 90);
                                        drawShadowText(graphics, "SAWTOOTH RIDGE RUN", Color.white, 99, 21);
                                        drawShadowText(graphics, "Stage " + ATrain.level + " Complete", Color.white, 99, 41);
                                        drawShadowText(graphics, "There is only ONE stop left!", Color.white, 99, 55);
                                        drawShadowText(graphics, "Bring'er on home, kid.", Color.white, 99, 69);
                                        drawShadowText(graphics, "Elapsed Time: " + formatTime(ATrain.eTime) +
                                                " seconds.", Color.white, 99, 88);
                                        graphics.setColor(Color.white);
                                        break pinLoop;
                                    }
                                    break pinLoop;
                                }
                                // draw the level complete pin
                                case 6: {
                                    if (ATrain.timer < 4) {
                                        graphics.setColor(ATrain.stumpcolor);
                                        graphics.fillRect(80, 4, 240, 90);
                                        graphics.setColor(Color.yellow);
                                        graphics.drawRect(81, 5, 238, 88);
                                        graphics.drawRect(82, 6, 236, 86);
                                        graphics.setColor(Color.black);
                                        graphics.drawRect(80, 4, 240, 90);
                                        drawShadowText(graphics, "SAWTOOTH RIDGE RUN", Color.white, 99, 21);
                                        drawShadowText(graphics, "*** All Stages Complete ***", Color.white, 99, 41);
                                        drawShadowText(graphics, "Not too bad for a kid.", Color.white, 99, 55);
                                        ATrain.srTime = ATrain.eTime;
                                        drawShadowText(graphics, "SAWTOOTH RIDGE Time: " + formatTime(ATrain.eTime),
                                                Color.white, 99, 88);
                                        graphics.setColor(Color.white);
                                        ATrain.srTime = ATrain.eTime;
                                        break pinLoop;
                                    }
                                    break pinLoop;
                                }
                            }
                            break;
                        }
                        case 1: {
                            switch (ATrain.level) {
                                case 0: {
                                    graphics.drawImage(ATrain.grassPics[2], 0, 50, 80, 120, null);
                                    graphics.drawImage(ATrain.grassPics[3], 40, 20, null);
                                    graphics.setColor(Color.white);
                                    graphics.drawString("I've reviewed your record, kid. You're now", 100, 40);
                                    graphics.drawString("a rookie!  Try the LAVA CAVERN run under", 100, 54);
                                    graphics.drawString("the Big Island of Hawaii.  There are 6 stops to", 100, 68);
                                    graphics.drawString("make to complete this run.", 100, 82);
                                    graphics.drawString("Watch that track and try not to get", 100, 96);
                                    graphics.drawString("burned up in the lava flows, rookie.", 100, 110);
                                    if (ATrain.aniClock >= 408) {
                                        break pinLoop;
                                    }
                                    graphics.setColor(Color.orange);
                                    if (ATrain.aniClock / 8 % 2 == 1) {
                                        graphics.drawString(
                                                "Please wait for images to board before departing, thanx.", 30, 190);
                                        break pinLoop;
                                    }
                                    graphics.setColor(ATrain.stumpcolor);
                                    graphics.drawString(
                                            "Please wait for images to board before departing, thanx.", 30, 190);
                                    break pinLoop;
                                }
                                case 1:
                                case 2:
                                case 3:
                                case 4: {
                                    if (ATrain.timer < 4) {
                                        graphics.setColor(ATrain.stumpcolor);
                                        graphics.fillRect(80, 4, 240, 90);
                                        graphics.setColor(Color.yellow);
                                        graphics.drawRect(81, 5, 238, 88);
                                        graphics.drawRect(82, 6, 236, 86);
                                        graphics.setColor(Color.black);
                                        graphics.drawRect(80, 4, 240, 90);
                                        drawShadowText(graphics, "LAVA CAVERN RUN", Color.white, 99, 21);
                                        drawShadowText(graphics, "Stage " + ATrain.level + " Complete",
                                                Color.white, 99, 41);
                                        drawShadowText(graphics, "There are " + (6 - ATrain.level) + " stops left.",
                                                Color.white, 99, 55);
                                        drawShadowText(graphics, "You're doing fine, rookie.",
                                                Color.white, 99, 69);
                                        drawShadowText(graphics, "Elapsed Time: " + formatTime(ATrain.eTime) +
                                                " seconds.", Color.white, 99, 88);
                                        graphics.setColor(Color.white);
                                        break pinLoop;
                                    }
                                    break pinLoop;
                                }
                                case 5: {
                                    if (ATrain.timer < 4) {
                                        graphics.setColor(ATrain.stumpcolor);
                                        graphics.fillRect(80, 4, 240, 90);
                                        graphics.setColor(Color.yellow);
                                        graphics.drawRect(81, 5, 238, 88);
                                        graphics.drawRect(82, 6, 236, 86);
                                        graphics.setColor(Color.black);
                                        graphics.drawRect(80, 4, 240, 90);
                                        drawShadowText(graphics, "LAVA CAVERN RUN",
                                                Color.white, 99, 21);
                                        drawShadowText(graphics, "Stage " + ATrain.level + " Complete",
                                                Color.white, 99, 41);
                                        drawShadowText(graphics, "There is only ONE stop left!",
                                                Color.white, 99, 55);
                                        drawShadowText(graphics, "Do it for the Big Kahuna, rookie.",
                                                Color.white, 99, 69);
                                        drawShadowText(graphics, "Elapsed Time: " + formatTime(ATrain.eTime) + " seconds.",
                                                Color.white, 99, 88);
                                        break pinLoop;
                                    }
                                    break pinLoop;
                                }
                                case 6: {
                                    if (ATrain.timer < 4) {
                                        graphics.setColor(ATrain.stumpcolor);
                                        graphics.fillRect(80, 4, 240, 90);
                                        graphics.setColor(Color.yellow);
                                        graphics.drawRect(81, 5, 238, 88);
                                        graphics.drawRect(82, 6, 236, 86);
                                        graphics.setColor(Color.black);
                                        graphics.drawRect(80, 4, 240, 90);
                                        drawShadowText(graphics, "LAVA CAVERN RUN",
                                                Color.white, 99, 21);
                                        drawShadowText(graphics, "*** All Stages Complete ***",
                                                Color.white, 99, 41);
                                        drawShadowText(graphics, "Good Job, Rookie!",
                                                Color.white, 99, 55);
                                        drawShadowText(graphics, "LAVA CAVERN Time: " + formatTime(ATrain.eTime),
                                                Color.white, 99, 88);
                                        graphics.setColor(Color.white);
                                        ATrain.lcTime = ATrain.eTime;
                                        break pinLoop;
                                    }
                                    break pinLoop;
                                }
                            }
                            break;
                        }
                        case 2: {
                            switch (ATrain.level) {
                                case 0: {
                                    graphics.setColor(Color.white);
                                    graphics.drawString("You're really on the ball, Rookie. You've made", 100, 40);
                                    graphics.drawString("it to Novice!  Next, STARRY NIGHT orbital run", 100, 54);
                                    graphics.drawString("about 100 miles above Earth.  I'll see you in", 100, 68);
                                    graphics.drawString("6, if you can make the grade.", 100, 82);
                                    graphics.drawString("Energy recharge satellites can be found in", 100, 96);
                                    graphics.drawString("low to high stationary orbits.", 100, 110);
                                    break pinLoop;
                                }
                                case 1:
                                case 2:
                                case 3:
                                case 4: {
                                    if (ATrain.timer < 4) {
                                        graphics.setColor(ATrain.stumpcolor);
                                        graphics.fillRect(80, 4, 240, 90);
                                        graphics.setColor(Color.yellow);
                                        graphics.drawRect(81, 5, 238, 88);
                                        graphics.drawRect(82, 6, 236, 86);
                                        graphics.setColor(Color.black);
                                        graphics.drawRect(80, 4, 240, 90);
                                        drawShadowText(graphics, "STARRY NIGHT RUN",
                                                Color.white, 99, 21);
                                        drawShadowText(graphics, "Stage " + ATrain.level + " Complete",
                                                Color.white, 99, 41);
                                        drawShadowText(graphics, "There are " + (6 - ATrain.level) + " stops left.",
                                                Color.white, 99, 55);
                                        drawShadowText(graphics, "Cutting it close, Novice.",
                                                Color.white, 99, 69);
                                        drawShadowText(graphics, "Elapsed Time: " + formatTime(ATrain.eTime) + " seconds.",
                                                Color.white, 99, 88);
                                        graphics.setColor(Color.white);
                                        break pinLoop;
                                    }
                                    break pinLoop;
                                }
                                case 5: {
                                    if (ATrain.timer < 4) {
                                        graphics.setColor(ATrain.stumpcolor);
                                        graphics.fillRect(80, 4, 240, 90);
                                        graphics.setColor(Color.yellow);
                                        graphics.drawRect(81, 5, 238, 88);
                                        graphics.drawRect(82, 6, 236, 86);
                                        graphics.setColor(Color.black);
                                        graphics.drawRect(80, 4, 240, 90);
                                        drawShadowText(graphics, "STARRY NIGHT RUN",
                                                Color.white, 99, 21);
                                        drawShadowText(graphics, "Stage " + ATrain.level + " Complete",
                                                Color.white, 99, 41);
                                        drawShadowText(graphics, "There is only ONE stop left!",
                                                Color.white, 99, 55);
                                        drawShadowText(graphics, "Do it to it, Novice.",
                                                Color.white, 99, 69);
                                        drawShadowText(graphics, "Elapsed Time: " + formatTime(ATrain.eTime) + " seconds.",
                                                Color.white, 99, 88);
                                        graphics.setColor(Color.white);
                                        break pinLoop;
                                    }
                                    break pinLoop;
                                }
                                case 6: {
                                    if (ATrain.timer < 4) {
                                        graphics.setColor(ATrain.stumpcolor);
                                        graphics.fillRect(80, 4, 240, 90);
                                        graphics.setColor(Color.yellow);
                                        graphics.drawRect(81, 5, 238, 88);
                                        graphics.drawRect(82, 6, 236, 86);
                                        graphics.setColor(Color.black);
                                        graphics.drawRect(80, 4, 240, 90);
                                        drawShadowText(graphics, "STARRY NIGHT RUN", Color.white, 99, 21);
                                        drawShadowText(graphics, "*** All Stages Complete ***", Color.white, 99, 41);
                                        drawShadowText(graphics, "Job Well Done, Novice!", Color.white, 99, 55);
                                        drawShadowText(graphics, "STARRY NIGHT Time: " + formatTime(ATrain.eTime),
                                                Color.white, 99, 88);
                                        graphics.setColor(Color.white);
                                        ATrain.snTime = ATrain.eTime;
                                        break pinLoop;
                                    }
                                    break pinLoop;
                                }
                            }
                            break;
                        }
                        case 3: {
                            if (ATrain.allDone == 0) {
                                ATrain.track1Y = 80;
                                ATrain.trainY = 80;
                                ATrain.allDone = 1;
                                graphics.setColor(Color.black);
                                drawShadowText(graphics, "Outstanding! Excellent Driving!", Color.white, 99, 31);
                                drawShadowText(graphics, "Let's look at your Scenario Times:", Color.white, 99, 45);
                                graphics.setColor(Color.white);
                                ATrain.tTime = ATrain.srTime + ATrain.lcTime + ATrain.snTime;
                                drawShadowText(graphics, "SAWTOOTH RIDGE    Time: " + formatTime(ATrain.srTime), Color.green, 99, 71);
                                drawShadowText(graphics, "LAVA CAVERN       Time: " + formatTime(ATrain.lcTime), Color.yellow, 99, 85);
                                drawShadowText(graphics, "STARRY NIGHT      Time: " + formatTime(ATrain.snTime), Color.white, 99, 99);
                                drawShadowText(graphics, "Your Track Record Time: " + formatTime(ATrain.tTime), Color.yellow, 99, 123);
                                if (ATrain.tTime < ATrain.bTime) {
                                    ATrain.bTime = ATrain.tTime;
                                    drawShadowText(graphics, "IT'S A NEW TRACK RECORD!!!", Color.yellow, 99, 147);
                                }
                                if (ATrain.tTime > ATrain.bTime) {
                                    drawShadowText(graphics, "Best Track Record Time: " + formatTime(ATrain.bTime), Color.yellow, 99, 147);
                                }
                            }
                            if (ATrain.bTime < 9100) {
                                ATrain.hSize = (ATrain.hSize + 5) % (ATrain.iw * 2);
                                ATrain.rhSize = ATrain.hSize;
                                if (ATrain.rhSize > ATrain.iw) {
                                    ATrain.rhSize = ATrain.iw * 2 - ATrain.hSize;
                                }
                                ATrain.vSize = (ATrain.vSize + 7) % (ATrain.ih * 2);
                                ATrain.rvSize = ATrain.vSize;
                                if (ATrain.rvSize > ATrain.ih) {
                                    ATrain.rvSize = ATrain.ih * 2 - ATrain.vSize;
                                }
                                ++ATrain.rvSize;
                                ++ATrain.rhSize;
                                graphics.setColor(ATrain.stumpcolor);
                                graphics.fillRect(0, 0, ATrain.iw / 2 - ATrain.rhSize / 2, ATrain.ih);
                                graphics.fillRect(ATrain.iw / 2 + ATrain.rhSize / 2, 0, ATrain.iw / 2 -
                                        ATrain.rhSize / 2, ATrain.ih);
                                graphics.fillRect(0, 0, ATrain.iw, ATrain.ih / 2 - ATrain.rvSize / 2);
                                graphics.fillRect(0, ATrain.ih / 2 + ATrain.rvSize / 2, ATrain.iw,
                                        ATrain.ih / 2 - ATrain.rvSize / 2);
                                graphics.drawImage(ATrain.image, ATrain.iw / 2 - ATrain.rhSize / 2,
                                        ATrain.ih / 2 - ATrain.rvSize / 2, ATrain.rhSize, ATrain.rvSize, null);
                                break;
                            }
                            break;
                        }
                    }
                }
                if (ATrain.timer == 20 || ATrain.timer == 21) { //200 201
                    graphics.setColor(Color.gray);
                    graphics.fillRect(80, 144, 240, 20);
                    graphics.setColor(Color.lightGray);
                    graphics.drawRect(80, 144, 240, 20);
                    ATrain.madeIt.start();
                }
                if (ATrain.timer > 20) { //200
                    int n2 = ATrain.aniClock * 4 % 256;
                    if (n2 > 127) {
                        n2 = 255 - n2;
                    }
                    graphics.setColor(new Color(n2 * 2, 0, 0));
                    ATrain.dead = 0;
                    if (ATrain.stage != 3) {
                        graphics.drawString("ALL ABOARD! FULL SPEED AHEAD!", 96, 160);
                    } else {
                        graphics.drawString("CAN YOU MAKE IT TO THE 90 SECOND CLUB?", 66, 164);
                    }
                    if (ATrain.level == 6) {
                        ++ATrain.stage;
                        ATrain.level = 0;
                        ATrain.aniClock = 240;
                        ATrain.goal = 1;
                        ATrain.eTime = 0;
                    }
                }
            }
        }
        graphics.dispose();
    }

    /**
     * Draws text with a shadow effect on the given Graphics object.
     * <p>
     * This method draws the specified text at the specified coordinates on the Graphics object,
     * with a shadow effect created by rendering the text in black color slightly offset from the original position.
     * The shadow effect enhances the visibility and aesthetics of the text on the graphical component.
     * </p>
     *
     * @param graphics  the Graphics object on which to draw the text
     * @param text      the text to be drawn
     * @param textColor the color of the text
     * @param x         the x-coordinate of the starting point of the text
     * @param y         the y-coordinate of the baseline of the text
     */
    private void drawShadowText(Graphics graphics, String text, Color textColor, int x, int y) {
        // Draw shadow text in black color at the coordinates
        graphics.setColor(Color.black);
        graphics.drawString(text, x, y);

        // Draw the actual text in the specified color using 1 pixel offset
        graphics.setColor(textColor);
        graphics.drawString(text, x + 1, y - 1);
    }

    /**
     * Formats the time in to a seconds point milliseconds format.
     */
    private String formatTime(int time) {
        int secs = time / 100;
        int tenths = (time - secs * 100) / 10;
        int hundredths = (time - secs * 100 - tenths * 10) % 10;

        return secs + "." + tenths + hundredths;
    }

    /**
     * This method controls the movement of the train based on its stage.
     * It updates the graphical representation of the train and its surroundings.
     * The train moves differently depending on the stage it's in.
     */
    public synchronized void move() {
        // Get the graphics context
        Graphics graphics = this.getGraphics();

        // Switch statement to handle different stages of the train movement
        switch (ATrain.stage) {
            case 0: {
                // Stage 0: Moving on normal tracks
                // Train's vertical position decreases every other animation cycle
                if (ATrain.aniClock % 2 == 1) {
                    --ATrain.track1Y;
                }

                // Reset track position if it goes above a certain threshold
                if (ATrain.track1Y < 60) {
                    ATrain.track1Y = 150;
                    // Initiate a jump if the train is not already jumping
                    if (ATrain.jump == 0) {
                        ATrain.jump = 2;
                        ATrain.jumpCount = 2 + (int) (Math.random() * 4.0);
                    }
                }

                // Calculate train's position and draw it
                ATrain.dy = 24 - ATrain.speed + ATrain.trainY - 25 - ATrain.vSpeed;
                ATrain.dx = ATrain.speed + 30;
                try {
                    // Move the graphics area to simulate train movement
                    if (ATrain.speed > 0) {
                        graphics.copyArea(ATrain.speed, 0, 400 - ATrain.speed, 170, -ATrain.speed, 0);
                    }
                    // Generate trail
                    for (int i = 0; i < 15; i++) {
                        graphics.copyArea(0, 0, 1, 1, 0, 1);
                    }
                } catch (final Exception ignored) {
                }
                // Draw the train and its surroundings
                graphics = this.getGraphics();
                graphics.setColor(Color.white);
                graphics.fillRect(ATrain.dx, ATrain.dy, 16, 20);
                graphics.drawOval(ATrain.dx + 12, ATrain.dy, 16, 16);
                graphics.setColor(Color.blue);
                graphics.fillRect(ATrain.dx, 8 + ATrain.dy, 16, 4);
                graphics.fillRect(ATrain.dx, 20 + ATrain.dy, 20, 2);

                // Draw additional elements like wheels, tracks, etc.
                graphics.setColor(Color.lightGray);
                graphics.fillOval(ATrain.dx + 20, 20 + ATrain.dy, 8, 8);
                graphics.setColor(Color.black);
                graphics.drawOval(ATrain.dx + 20, 20 + ATrain.dy, 8, 8);
                int trackYOffset = ATrain.track1Y * 2 - ATrain.dy - 2 + (20 - ATrain.speed) * 2;
                if (trackYOffset > 158) {
                    trackYOffset = 158;
                }
                graphics.setColor(Color.black);
                graphics.fillOval(ATrain.dx - 6, trackYOffset + 2, 24, 8);
                graphics.fillOval(ATrain.dx - 6 + 20, trackYOffset - 2, 8, 4);
                ATrain.dy += 20;
                switch (ATrain.aniClock % 4) {
                    case 0: {
                        graphics.drawLine(ATrain.dx + 24, ATrain.dy, ATrain.dx + 24, 8 + ATrain.dy);
                        break;
                    }
                    case 1: {
                        graphics.drawLine(ATrain.dx + 26, 2 + ATrain.dy, ATrain.dx + 22, 6 + ATrain.dy);
                        break;
                    }
                    case 2: {
                        graphics.drawLine(ATrain.dx + 20, 4 + ATrain.dy, ATrain.dx + 28, 4 + ATrain.dy);
                        break;
                    }
                    case 3: {
                        graphics.drawLine(ATrain.dx + 22, 2 + ATrain.dy, ATrain.dx + 26, 6 + ATrain.dy);
                        break;
                    }
                }
                ATrain.dx = 400 - ATrain.speed;
                if (ATrain.track1Y < 80) {
                    graphics.setColor(Color.cyan);
                    graphics.fillRect(ATrain.dx, 0, ATrain.speed, ATrain.track1Y - 1);
                } else {
                    graphics.setColor(Color.cyan);
                    graphics.fillRect(ATrain.dx, 0, ATrain.speed, 80);
                    graphics.setColor(ATrain.oceancolor);
                    graphics.fillRect(ATrain.dx, 80, ATrain.speed, ATrain.track1Y - 79);
                }
                graphics.setColor(Color.green);
                graphics.drawImage(ATrain.grassPics[0], 370, ATrain.track1Y + 10, 30, 170 - (ATrain.track1Y + 10), null);
                graphics.setColor(Color.lightGray);
                graphics.drawRect(ATrain.dx, ATrain.track1Y, ATrain.speed, 1);
                graphics.setColor(Color.white);
                graphics.drawRect(ATrain.dx, ATrain.track1Y + 2, ATrain.speed, 1);
                graphics.setColor(Color.gray);
                graphics.drawRect(ATrain.dx, ATrain.track1Y + 3, ATrain.speed, 1);
                graphics.setColor(ATrain.stumpcolor);
                graphics.fillRect(ATrain.dx, ATrain.track1Y + 4, ATrain.speed, 4);
                graphics.setColor(Color.black);
                graphics.drawRect(ATrain.dx, ATrain.track1Y + 8, ATrain.speed, 1);
                graphics.setColor(Color.white);
                ATrain.cloud = (int) (Math.random() * ATrain.track1Y) / 2;
                graphics.drawLine(370, ATrain.cloud - 10, 400, ATrain.cloud - 16);
                graphics.setColor(Color.orange);
                ATrain.grass = (int) (Math.random() * (160 - ATrain.track1Y)) / 2 + ATrain.track1Y + 10;
                graphics.drawLine(394, ATrain.grass + 5, 397, ATrain.grass);
                graphics.drawLine(394, ATrain.grass + 5, 391, ATrain.grass);
                graphics.drawLine(383, ATrain.grass + 4, 386, ATrain.grass);
                graphics.drawLine(383, ATrain.grass + 4, 379, ATrain.grass);
                if (Math.random() * 100.0 > 94.0) {
                    graphics.drawImage(ATrain.grassPics[1], 370, ATrain.track1Y - 50, null);
                } else if (ATrain.rockTime == 0 && ATrain.aniClock % (40 - ATrain.level * 4 + (int) (Math.random() * 10.0)) < 2 && ATrain.goal - ATrain.distance > 500 && ATrain.distance > 500) {
                    ATrain.tankY = ATrain.track1Y - 20;
                    graphics.setColor(Color.magenta);
                    graphics.fillOval(ATrain.tankX, ATrain.tankY, 20, 20);
                    graphics.setColor(Color.red);
                    graphics.fillOval(ATrain.tankX, ATrain.tankY, 16, 16);
                    graphics.setColor(Color.yellow);
                    graphics.fillOval(ATrain.tankX, ATrain.tankY, 12, 8);
                    graphics.setColor(Color.darkGray);
                    graphics.fillOval(ATrain.tankX - 4, ATrain.tankY + 20, 20, 6);
                    if (ATrain.rockTime == 0 && ATrain.speed > 0) {
                        ATrain.rockTime = 320 / ATrain.speed;
                    }
                }
                if (ATrain.rockTime <= 0) {
                    break;
                }
                --ATrain.rockTime;
                if (ATrain.rockTime == 0) {
                    ATrain.hole.setFramePosition(0);
                    ATrain.hole.start();
                    --ATrain.speed;
                    ATrain.jump = 2;
                    ATrain.jumpCount = 4;
                    --ATrain.topSpeed;
                }
                if (ATrain.speed < ATrain.minSpeed) {
                    ATrain.track1Y = 80;
                    ATrain.tTime = 0;
                    ATrain.eTime = 0;
                    ATrain.speed = 0;
                    ATrain.aniClock = 0;
                    ATrain.dead = 1;
                    ATrain.crash.loop(Clip.LOOP_CONTINUOUSLY);
                    ATrain.level = 0;
                    ATrain.stage = 0;
                }
                if (ATrain.rockTime != 1 || ATrain.trainY + 10 - ATrain.vSpeed >= ATrain.track1Y) {
                    break;
                }
                ATrain.rockTime = 0;
                if (ATrain.speed < ATrain.topSpeed) {
                    ++ATrain.speed;
                    break;
                }
                break;
            }
            case 1: {
                // Stage 1: Moving on tracks with lava
                // Train's position and surroundings are drawn differently
                // compared to Stage 0
                ATrain.track1Y = 120;
                ATrain.dy = ATrain.trainY - 25 - ATrain.vSpeed - 2;
                ATrain.dx = ATrain.speed + 30;
                if (ATrain.speed > 0) {
                    graphics.copyArea(ATrain.speed, 0, 400 - ATrain.speed, 170, -ATrain.speed, 0);
                }
                graphics = this.getGraphics();
                graphics.setColor(Color.white);
                graphics.fillRect(ATrain.dx, ATrain.dy, 16, 20);
                graphics.drawOval(ATrain.dx + 12, ATrain.dy, 16, 16);
                graphics.setColor(Color.blue);
                graphics.fillRect(ATrain.dx, 8 + ATrain.dy, 16, 4);
                graphics.fillRect(ATrain.dx, 20 + ATrain.dy, 20, 2);
                graphics.setColor(Color.lightGray);
                graphics.fillOval(ATrain.dx + 20, 20 + ATrain.dy, 8, 8);
                graphics.setColor(Color.black);
                graphics.drawOval(ATrain.dx + 20, 20 + ATrain.dy, 8, 8);
                int yOffset = ATrain.track1Y * 2 - ATrain.dy - 18 + 7;
                if (yOffset > 159) {
                    yOffset = 159;
                }
                graphics.setColor(ATrain.stumpcolor);
                graphics.fillOval(ATrain.dx - 6, yOffset + 2, 24, 8);
                graphics.fillOval(ATrain.dx - 6 + 20, yOffset - 2, 8, 4);
                ATrain.dy += 20;
                switch (ATrain.aniClock % 4) {
                    case 0: {
                        graphics.drawLine(ATrain.dx + 24, ATrain.dy, ATrain.dx + 24, 8 + ATrain.dy);
                        break;
                    }
                    case 1: {
                        graphics.drawLine(ATrain.dx + 26, 2 + ATrain.dy, ATrain.dx + 22, 6 + ATrain.dy);
                        break;
                    }
                    case 2: {
                        graphics.drawLine(ATrain.dx + 20, 4 + ATrain.dy, ATrain.dx + 28, 4 + ATrain.dy);
                        break;
                    }
                    case 3: {
                        graphics.drawLine(ATrain.dx + 22, 2 + ATrain.dy, ATrain.dx + 26, 6 + ATrain.dy);
                        break;
                    }
                }
                ATrain.dx = 400 - ATrain.speed;
                ATrain.lava = ATrain.lava + (int) (Math.random() * 5.0) - 2;
                if (ATrain.lava > 88) {
                    ATrain.lava = 88;
                }
                if (ATrain.lava < 72) {
                    ATrain.lava = 72;
                }
                graphics.drawImage(ATrain.grassPics[2], ATrain.dx, ATrain.lava - 100, ATrain.speed, 100, null);
                graphics.setColor(Color.red);
                graphics.fillRect(ATrain.dx, ATrain.lava, ATrain.speed, ATrain.track1Y - ATrain.lava);
                graphics.fillRect(ATrain.dx, ATrain.track1Y + 10, ATrain.speed, 170 - (ATrain.track1Y + 10));
                if (ATrain.rockTime < ATrain.earlyRock) {
                    graphics.setColor(Color.lightGray);
                    graphics.drawRect(ATrain.dx, ATrain.track1Y, ATrain.speed, 1);
                    graphics.setColor(Color.white);
                    graphics.drawRect(ATrain.dx, ATrain.track1Y + 2, ATrain.speed, 1);
                    graphics.setColor(Color.gray);
                    graphics.drawRect(ATrain.dx, ATrain.track1Y + 3, ATrain.speed, 1);
                    graphics.setColor(Color.orange);
                    graphics.fillRect(ATrain.dx, ATrain.track1Y + 4, ATrain.speed, 4);
                    graphics.setColor(Color.black);
                    graphics.drawRect(ATrain.dx, ATrain.track1Y + 8, ATrain.speed, 1);
                    if (ATrain.aniClock % (ATrain.speed / 3 + 1) == 1) {
                        graphics.setColor(Color.black);
                        graphics.fillRect(ATrain.dx, ATrain.track1Y + 9, ATrain.speed, 4);
                    }
                    graphics.setColor(ATrain.stumpcolor);
                    graphics.fillRect(ATrain.dx, ATrain.track1Y + 13 + (int) (Math.random() * 2.0), ATrain.speed, 3);
                } else {
                    graphics.setColor(Color.red);
                    graphics.fillRect(ATrain.dx - ATrain.speed, ATrain.track1Y, ATrain.speed * 2, 14);
                }
                final int randomizedOffset = (int) (Math.random() * (176 - ATrain.track1Y)) / 2 + ATrain.track1Y + 10;
                graphics.setColor(Color.orange);
                if (randomizedOffset % 2 == 1) {
                    graphics.setColor(Color.yellow);
                }
                graphics.drawOval(379, randomizedOffset + 4, 18, 5);
                graphics.drawOval(383, 20 + randomizedOffset / 2, 16, 4);
                if (Math.random() * 100.0 <= 94.0 && ATrain.rockTime == 0 && ATrain.aniClock %
                        (40 - ATrain.level * 4 + (int) (Math.random() * 10.0)) < 2 && ATrain.goal -
                        ATrain.distance > 500 && ATrain.distance > 500) {
                    if (ATrain.rockTime == 0 && ATrain.speed > 0) {
                        ATrain.rockTime = 320 / ATrain.speed + 1;
                    }
                    ATrain.earlyRock = ATrain.rockTime * 9 / 10;
                }
                graphics.setColor(Color.red);
                graphics.drawImage(ATrain.grassPics[3], 368, (int) (Math.random() * ATrain.track1Y) / 2 + 4, null);
                if (ATrain.rockTime <= 0) {
                    break;
                }
                --ATrain.rockTime;
                if (ATrain.rockTime == 0) {
                    ATrain.hiss.setFramePosition(0);
                    ATrain.hiss.start();
                    ATrain.trainY += 16;
                    ATrain.speed -= 2;
                    ATrain.jump = 2;
                    ATrain.jumpCount = 8;
                    --ATrain.topSpeed;
                }
                if (ATrain.speed < ATrain.minSpeed) {
                    ATrain.track1Y = 120;
                    ATrain.eTime = 0;
                    ATrain.speed = 0;
                    ATrain.aniClock = 0;
                    ATrain.dead = 1;
                    ATrain.crash.loop(Clip.LOOP_CONTINUOUSLY);
                    ATrain.level = 0;
                    if (ATrain.stage > 0) {
                        --ATrain.stage;
                    }
                }
                if (ATrain.rockTime != 1 || ATrain.trainY + 2 - ATrain.vSpeed >= ATrain.track1Y) {
                    break;
                }
                ATrain.rockTime = 0;
                if (ATrain.speed < ATrain.topSpeed) {
                    ++ATrain.speed;
                    break;
                }
                break;
            }
            case 2: {
                // Stage 2: no tracks in space
                // Train's position and surroundings are drawn differently compared to Stage 0 and 1
                ATrain.track1Y = (int) (Math.random() * 160.0) + 20;
                ATrain.dy = ATrain.trainY - 25 - ATrain.vSpeed - 2;
                ATrain.dx = ATrain.speed + 30;
                if (ATrain.speed > 0) {
                    graphics.copyArea(ATrain.speed, 0, 400 - ATrain.speed, 170, -ATrain.speed, 0);
                }
                graphics = this.getGraphics();
                graphics.setColor(Color.white);
                graphics.fillRect(ATrain.dx, ATrain.dy, 16, 20);
                graphics.drawOval(ATrain.dx + 12, ATrain.dy, 16, 16);
                graphics.setColor(Color.blue);
                graphics.fillRect(ATrain.dx, 8 + ATrain.dy, 16, 4);
                graphics.fillRect(ATrain.dx, 20 + ATrain.dy, 20, 2);
                graphics.setColor(Color.red);
                graphics.fillOval(ATrain.dx + 20, 20 + ATrain.dy, 8 - ATrain.jumpCount / 2,
                        8 + ATrain.jumpCount / 2);
                graphics.setColor(Color.yellow);
                graphics.drawOval(ATrain.dx + 20, 20 + ATrain.dy, 8 - ATrain.jumpCount / 4,
                        8 + ATrain.jumpCount);
                ATrain.dx = 400 - ATrain.speed;
                graphics.setColor(Color.black);
                graphics.fillRect(ATrain.dx, 0, ATrain.speed, 170);
                ATrain.cloud = (int) (Math.random() * 168.0);
                graphics.setColor(ATrain.starcolor[ATrain.cloud % 8]);
                graphics.fillRect(396, ATrain.cloud, 2, 2);
                graphics.setColor(Color.white);
                graphics.fillRect(390, ATrain.cloud = (int) (Math.random() * 168.0), 1, 1);
                if (Math.random() * 100.0 > 94.0) {
                    graphics.setColor(Color.gray);
                    graphics.fillOval(386, ATrain.cloud = (int) (Math.random() * 158.0), 12, 12);
                    graphics.setColor(Color.white);
                    graphics.drawOval(384, ATrain.cloud + 3, 20, 4);
                } else if (ATrain.rockTime == 0 && ATrain.aniClock % (40 - ATrain.level * 4 +
                        (int) (Math.random() * 10.0)) < 2 && ATrain.goal - ATrain.distance > 500 &&
                        ATrain.distance > 500) {
                    ATrain.track1Y = (int) (Math.random() * 140.0) + 20;
                    ATrain.tankY = ATrain.track1Y - 20;
                    graphics.setColor(Color.yellow);
                    graphics.fillOval(ATrain.tankX, ATrain.tankY, 20, 10);
                    graphics.setColor(Color.red);
                    graphics.fillOval(ATrain.tankX + 2, ATrain.tankY, 16, 7);
                    graphics.setColor(Color.yellow);
                    graphics.drawLine(ATrain.tankX, ATrain.tankY + 4, ATrain.tankX + 10, ATrain.tankY - 10);
                    graphics.drawLine(ATrain.tankX + 10, ATrain.tankY - 10, ATrain.tankX + 20,
                            ATrain.tankY + 4);
                    graphics.drawLine(ATrain.tankX + 10, ATrain.tankY - 10, ATrain.tankX + 10,
                            ATrain.tankY + 4);
                    if (ATrain.rockTime == 0 && ATrain.speed > 0) {
                        ATrain.rockTime = 320 / ATrain.speed + 1;
                    }
                    ATrain.earlyRock = ATrain.rockTime * 9 / 10;
                }
                if (ATrain.rockTime <= 0) {
                    break;
                }
                --ATrain.rockTime;
                if (ATrain.rockTime == 0) {
                    --ATrain.speed;
                }
                if (ATrain.speed < ATrain.minSpeed) {
                    ATrain.track1Y = 120;
                    ATrain.eTime = 0;
                    ATrain.speed = 0;
                    ATrain.aniClock = 0;
                    ATrain.dead = 1;
                    ATrain.crash.loop(Clip.LOOP_CONTINUOUSLY);
                    ATrain.level = 0;
                    if (ATrain.stage > 0) {
                        --ATrain.stage;
                    }
                }
                if (ATrain.rockTime != 1 || ATrain.trainY - ATrain.vSpeed - ATrain.tankY >= 44 ||
                        ATrain.trainY - ATrain.vSpeed - ATrain.tankY <= -20) {
                    break;
                }
                ATrain.jump = 2;
                ATrain.jumpCount = 4;
                ATrain.fillUp.setFramePosition(0);
                ATrain.fillUp.start();
                ATrain.rockTime = 0;
                if (ATrain.speed < ATrain.topSpeed) {
                    ++ATrain.speed;
                    break;
                }
                break;
            }
        }
        if (ATrain.stage != 3 && ATrain.lastSpeed != ATrain.speed) {
            if (ATrain.lastSpeed == -1) {
                graphics.setColor(Color.black);
                graphics.fillRect(0, 178, 400, 16);
                graphics.setColor(Color.yellow);
                graphics.drawRect(109, 181, 42, 10);
                graphics.drawString("STATUS", 10, 190);
                graphics.drawString("LEVEL: " + (ATrain.stage + 1) + " | STAGE: " + (ATrain.level + 1), 178, 190);
                graphics.setColor(Color.black);
                graphics.drawString("A-Train (c) 19961018,  Steve A. Baker,  All Rights Reserved", 10, 206);
            }
            graphics.setColor(Color.red);
            if (ATrain.speed > 10) {
                graphics.setColor(Color.pink);
            }
            if (ATrain.speed > 11) {
                graphics.setColor(Color.orange);
            }
            if (ATrain.speed > 13) {
                graphics.setColor(Color.yellow);
            }
            if (ATrain.speed > 16) {
                graphics.setColor(Color.green);
            }
            graphics.fillRect(110, 182, 40, 8);
            ATrain.lastSpeed = ATrain.speed;
        }

        // Update the graphics context
        graphics.dispose();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been pressed on a component. Handles the click events for the game.
     * <p>
     * See the class description for {@link MouseEvent} for a definition of
     * a mouse button press event.
     * </p>
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (ATrain.timer > 100 && ATrain.dead == 0) {
            if (ATrain.speed == 0) {
                ATrain.finishTime = 0;
                ATrain.aniClock = 0;
                ATrain.speed = 20;
                ATrain.goal = 10000;
                ATrain.distance = 0;
                ATrain.topSpeed = 20;
                ATrain.dead = 0;
                ATrain.bullet.setFramePosition(0);
                ATrain.bullet.start();
                ATrain.lastSpeed = -1;
            }
            if (ATrain.jump == 0 && ATrain.goal - ATrain.distance > 100) {
                ATrain.trainY -= 2;
                ATrain.jump = 1;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * <p>
     * Exits the application when {@code ESC} is pressed.
     * </p>
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
            ATrain.crash.stop();
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
