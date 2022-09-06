package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NewsDetails extends AppCompatActivity {
    ImageView newsDetailsImage;
    TextView newsDetailTitle, tvNewsDetailDes;
    FloatingActionButton faButton;

    public static String TITLE = "";
    public static String DESCRIPTION = "";
    public  static Bitmap MY_BITMAP = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        newsDetailsImage = findViewById(R.id.newsDetailsImage);
        newsDetailTitle = findViewById(R.id.newsDetailTitle);
        tvNewsDetailDes = findViewById(R.id.tvNewsDetailDes);
        faButton = findViewById(R.id.faButton);

        newsDetailTitle.setText(TITLE);
        tvNewsDetailDes.setText(DESCRIPTION);
        if (MY_BITMAP !=null) newsDetailsImage.setImageBitmap(MY_BITMAP);

        // text to speech...
        TextToSpeech textToSpeech;
        textToSpeech = new TextToSpeech(NewsDetails.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
            }
        });
        faButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tvNewsDetailDes.getText().toString();
                textToSpeech.speak(text ,TextToSpeech.QUEUE_FLUSH,null,null);
            }
        });


    }
}