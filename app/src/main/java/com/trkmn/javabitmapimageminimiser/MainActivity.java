package com.trkmn.javabitmapimageminimiser;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    Bitmap bitmapImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    //Example button
    public void save(View view){
        //We need to minimise the bitmap image size in order to save it to SQLite
        Bitmap minimisedImage = minimiseImage(bitmapImage, 300);

        //To put it in the database, we convert it into a data array consisting of 0s and 1s, that is, a byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        minimisedImage.compress(Bitmap.CompressFormat.PNG,50, outputStream);
        byte[] byteArray = outputStream.toByteArray();
    }

    public Bitmap minimiseImage(Bitmap image, int maximumsize){

        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;

        if (bitmapRatio > 1){
            //landscape image
            width = maximumsize;
            height = (int) (width / bitmapRatio);
        }else{
            //portrait image
            height = maximumsize;
            width = (int) (height * bitmapRatio);
        }

        //Parameters(source, width, height, filter)
        return Bitmap.createScaledBitmap(image, width, height, true);
    }
}