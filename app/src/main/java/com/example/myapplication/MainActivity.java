package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

        Chronometer chronometer; // Nesnelerimizi Tanımladık
        ImageView imgStart,imgReset;
        Button btnStart,btnPause,btnReset;
        long pauseTime = 0;  // Hangi sürede durduralacağını alacağımız değişken


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            tanimla();

            btnStart.setOnClickListener(view ->{ //Başlat Butonuna bastığımızda
                chronometer.setBase(SystemClock.elapsedRealtime()+pauseTime);
                // ElapsedRealtime =  Sistemin başlatılmasından
                // bu yana geçen süreyi gösterir
                chronometer.start(); // Kronometre Başlatılır
                imgStart.setImageDrawable(getDrawable(R.drawable.pause));
                btnStart.setVisibility(View.GONE ); // ButtonSTART Görünmez olur
                btnPause.setVisibility(View.VISIBLE); // ButtonPause Görünür Olur
            });

            btnPause.setOnClickListener(view -> { // Durdur Butonuna bastığımızda
                pauseTime = chronometer.getBase()-SystemClock.elapsedRealtime();
                // pausetime değişkenine Kronometrenin durduğu zaman aktarılır
                chronometer.stop(); // Kronometre durdurulur
                imgStart.setImageDrawable(getDrawable(R.drawable.start));
                btnPause.setVisibility(View.GONE); // ButtonPause görünmez olur
                btnStart.setVisibility(View.VISIBLE); // ButtonStart Görünür olur
            });

            btnReset.setOnClickListener(view -> { // Sıfırla  Butonuna bastığımızda
                chronometer.setBase(SystemClock.elapsedRealtime()); // Kronometrenin zamanını alıyor
                chronometer.stop();
                pauseTime = 0; // Pausetime 0'a eşitliyor ve kronometre sıfırlanıyor
                btnPause.setVisibility(View.GONE);
                btnStart.setVisibility(View.VISIBLE);
                imgStart.setImageDrawable(getDrawable(R.drawable.start));
            });





            }



        public void tanimla(){
            btnStart = (Button) findViewById(R.id.buttonStart);
            btnPause = (Button) findViewById(R.id.buttonPause);
            btnReset = (Button) findViewById(R.id.buttonReset);
            chronometer = (Chronometer) findViewById(R.id.kronometre);
            imgStart = (ImageView) findViewById(R.id.imgStart);
            imgReset = (ImageView) findViewById(R.id.imgReset);
        }
}