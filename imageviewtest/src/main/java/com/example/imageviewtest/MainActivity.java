package com.example.imageviewtest;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int[] images = new int[]{
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a7,
            R.drawable.a8,
            R.drawable.a10,
            R.drawable.a11,
            R.drawable.a12,
            R.drawable.a13,
            R.drawable.a14
    };
    int currentImg = 1;
    private int alpha = 225;
    Button plus;
    Button minus;
    Button next;
    ImageView image1;
    ImageView image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        next = (Button) findViewById(R.id.next);
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image1.setImageResource(images[++currentImg % images.length]);
        BitmapDrawable bitmap = (BitmapDrawable) image1.getDrawable();
        Bitmap bm = bitmap.getBitmap();
        double scale = 1.0 * bm.getHeight() / image1.getHeight();
        int x = 0;
        int y = 0;

        if (x + 120 > bm.getWidth()) {
            x = bm.getWidth() - 120;
        }
        if (y + 120 > bm.getHeight()) {
            y = bm.getHeight() - 120;
        }
        image2.setImageBitmap(Bitmap.createBitmap(bm, x, y, 120, 120));
        image2.setImageAlpha(alpha);


        image1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                BitmapDrawable bitmap = (BitmapDrawable) image1.getDrawable();
                Bitmap bm = bitmap.getBitmap();
                double scale = 1.0 * bm.getHeight() / image1.getHeight();
                int x = (int) (event.getX() * scale);
                int y = (int) (event.getY() * scale);

                if (x + 120 > bm.getWidth()) {
                    x = bm.getWidth() - 120;
                }
                if (y + 120 > bm.getHeight()) {
                    y = bm.getHeight() - 120;
                }
                image2.setImageBitmap(Bitmap.createBitmap(bm, x, y, 120, 120));
                image2.setImageAlpha(alpha);

                return false;
            }
        });
    }

    public void plusRun(View v) {
        alpha += 20;
        alpha %= 255;
        image1.setImageAlpha(alpha);
    }

    public void minusRun(View v) {
        alpha -= 20;
        if (alpha < 0) {
            alpha = 0;
        }
        image1.setImageAlpha(alpha);
    }

    public void nextRun(View v) {
        image1.setImageResource(images[++currentImg % images.length]);
    }


}
