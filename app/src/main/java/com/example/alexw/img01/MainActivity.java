package com.example.alexw.img01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button b1, b2, b3;
    ImageView im;

    private Bitmap bmp;
    private Bitmap operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button);
        im = (ImageView) findViewById(R.id.imageView);

        BitmapDrawable abmp = (BitmapDrawable) im.getDrawable();
        bmp = abmp.getBitmap();
    }
    public void gray(View view) {
        //灰階
        operation = Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(), bmp.getConfig());
        //變灰階的係數
        double red = 0.33;
        double green = 0.59;
        double blue = 0.11;
        //算出來的丟lum
        int lum;
        for (int i = 0; i < bmp.getWidth(); i++) {
            for (int j = 0; j < bmp.getHeight(); j++) {
                int p = bmp.getPixel(i, j);
                int r = Color.red(p);
                int g = Color.green(p);
                int b = Color.blue(p);
                lum = (int)(r * red + g * green + b * blue);
                operation.setPixel(i, j, Color.argb(Color.alpha(p), lum, lum, lum));
            }
        }
        im.setImageBitmap(operation);
    }
}
