package ie.tudublin;


import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet {
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    public void settings(){
        size(1024, 500);
    }

    public void setup(){
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix;
        colorMode(HSB);

    }
    float average;
    public void draw(){
        background(0);
        stroke(255);
        average = 0;
        float halfH = height / 2;
        for(int i = 0 ; i< ab.size() ; i++)
        {
            float c = map(i, 0, ab.size(), 0, 255);
            stroke(c, 255, 255);
            line(i, halfH, i, halfH + ab.get(i) * halfH);
            average += abs(ab.get(i));
        }
        average /= ab.size();
        stroke(255);
        fill(100, 255, 255);
        circle(width / 2, halfH, average * 100);
        circle(100, y, 50);
        y += random(-10, 10);
        smoothedY = lerp(smoothedY, y, 0.1f);
    }

    float y;
    float smoothedY;
}


