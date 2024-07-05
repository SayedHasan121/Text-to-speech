package com.example.newtexttospeech;

import android.media.AudioManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText  Texttospeech;
    Button   speechbutton;
    TextToSpeech tts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Texttospeech=findViewById(R.id.Texttospeech);
       speechbutton=findViewById(R.id.speechbutton);





        speechbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 tts = new TextToSpeech (getApplicationContext(), new TextToSpeech. OnInitListener() {
                     @Override
                    public void onInit(int i) {

                         if (i == TextToSpeech.SUCCESS) {
                             tts.setLanguage(Locale.ENGLISH);
                             tts.setSpeechRate(1.0f);
                             //..........Increase the volume by sayed hasan..
                             AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                             int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                             audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, 0);

                             tts.speak(Texttospeech.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                         }
                     }
                });
            }
        });
    }
}
