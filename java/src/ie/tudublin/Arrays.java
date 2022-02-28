package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {

    float[] rainfall = { 45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};

    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

    float[] a1 = new float[100];
    float[] a2;

    public void settings(){
        size(500,500);
    }

    public void setup(){
        for(int i = 0; i < rainfall.length; i++)
        {
            println(rainfall[i] + "\t" + months[i]);
        }
        for(float r:rainfall)
        {
            println(r);
        }

        for(int i = rainfall.length - 1; i>= 0; i--)
        {
            println(rainfall[i] + "\t" + months[i]);
        }
        
        int index = 0;
        int index2 = 0;
        float min = rainfall[0];
        float max = rainfall[0];

        for(int i = 0; i < rainfall.length; i++) {
            if (min > rainfall[i]){
                min = rainfall[i];
                index = i;
            }
            if (max < rainfall[i])
            {
                max = rainfall[i];
                index2 = i;
            }
        }
        println("\nMIN RAINFALL : " + min + " in " + months[index]);
        println("\nMAX RAINFALL : " + max + " in " + months[index2]);
         
    }


    public void draw(){
        background(0);
        colorMode(HSB);
		float w = width/(float)rainfall.length;
		for(int i = 0; i < rainfall.length; i++)
		{
            noStroke();
			fill(map(i, 0, rainfall.length, 100, 255), 255, 255);
            float x = w * i;
			rect(x, height, w, -rainfall[i] *4);
            fill(255);  
            text(months[i], (w*i)+10, height-10);
    }
    }
}
