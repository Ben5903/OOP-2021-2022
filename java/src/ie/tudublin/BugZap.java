package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
    public void settings()
    {
        size(500,500);
    }

    public void setup()
    {   
        reset();   
    }

        float playerX, playerY;
        float playerWidth = 40;
        float playerSpeed = 10;
        float bugX, bugY;
        float bugWidth = 30;
        float halfBugWidth = bugWidth/2;
        
        int score = 0;

        public void reset()
        {
            resetBug();
            playerX = width/2;
            playerY = random(350, 450);
        }

        public void resetBug()
        {
            bugX = random(bugWidth/2, width-(bugWidth/2));
            bugY = 50;
        }



        public void drawPlayer(float x, float y, float w)
        {
            clear();
            square(x, y, w);
        }

        public void drawBug(float x, float y)
        {
            // Draw the bug
            stroke(255);
            float saucerHeight = bugWidth * 0.7f;
            line(x, y - saucerHeight, x - halfBugWidth, y);
            line(x, y - saucerHeight, x + halfBugWidth, y);
            // line(x - halfBugWidth, y, x - halfBugWidth, y);
            line(x - halfBugWidth, y, x + halfBugWidth, y);
            float feet = bugWidth * 0.1f;
            line(x - feet, y, x - halfBugWidth, y + halfBugWidth);
            line(x + feet, y, x + halfBugWidth, y + halfBugWidth);

            feet = bugWidth * 0.3f;
            line(x - feet, y, x - halfBugWidth, y + halfBugWidth);
            line(x + feet, y, x + halfBugWidth, y + halfBugWidth);

            float eyes = bugWidth * 0.1f;
            line(x - eyes, y - eyes, x - eyes, y - eyes * 2f);
            line(x + eyes, y - eyes, x + eyes, y - eyes * 2f);
        }

        public void draw()
        {
            background(0);
            stroke(0, 0, 0);
            drawPlayer(playerX, playerY, playerWidth);
            drawBug(bugX, bugY);
            moveBug();

            text("Score: " + score, 30, 30);
        }


    
        public void keyPressed()
        {
            if (keyCode == LEFT)
            {
                playerX -= playerSpeed;
                if (playerX < 0) {
                    playerX = -playerX;
                }
            }
            if (keyCode == RIGHT)
            {
                playerX += playerSpeed;
                if (playerX > width) {
                    playerX = -playerX;
                }      
            }
    
            if (key == ' ')
            {
                if (playerX > bugX - halfBugWidth && playerX < bugX + halfBugWidth)
                {
                    strokeWeight(2);
                    stroke(255,0,0);
                    line(playerX, playerY, playerX, bugY);
                    score++;
                    resetBug();
                }
            }
        }
        
        public void moveBug() {
            if ((frameCount % 5) == 0)
            {
                bugX += random(-5, 5);
                if (bugX < halfBugWidth)
                {
                    bugX = halfBugWidth;
                }
                if (bugX > width - halfBugWidth)
                {
                    bugX = width - halfBugWidth;
                }
                bugY += 2;
            }
        }
        
        
}
