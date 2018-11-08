package com.example.user.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button play, pause, stop;
    MediaPlayer mediaPlayer;
    int pausecurrentposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        stop = (Button) findViewById(R.id.stop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.play:
                if (mediaPlayer==null){
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.music);
                mediaPlayer.start();}
                else if(mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(pausecurrentposition);
                    mediaPlayer.start();
                }
                break;
            case R.id.pause:
                if (mediaPlayer!=null){

                    mediaPlayer.pause();

                    pausecurrentposition=mediaPlayer.getCurrentPosition();
                }
                break;
            case R.id.stop:
                if (mediaPlayer!=null) {
                    mediaPlayer.stop();
                    mediaPlayer = null;
                }
                break;



        }
    }
}