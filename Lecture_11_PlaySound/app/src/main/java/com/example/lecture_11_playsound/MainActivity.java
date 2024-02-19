package com.example.lecture_11_playsound;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mPlayer;
    private TextView tv;
    private int mySong[] = {R.raw.birdy, R.raw.music, R.raw.musicfun};
    private String name[] = {"birdy.rtttl", "music.wav", "musicfun.mp3"};
    private String info="";
    private int noSong = 0;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPlayer = MediaPlayer.create( this, mySong[noSong]);
//        mPlayer.setLooping(true);
        info = getInfo(mPlayer);
        tv = (TextView) findViewById(R.id.showText);
        tv.setText(info);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Start playing : " +
                        name[noSong],Toast.LENGTH_SHORT).show();

                mPlayer.start();
//                btn.setEnabled(false);
//                timer.start();
            }
        });
        timer = new CountDownTimer(4000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                info = getInfo(mPlayer);
                tv.setText(info);
            }
            @Override
            public void onFinish() {
                mPlayer.pause();
                btn.setEnabled(true);
                info = getInfo(mPlayer);
                tv.setText(info);
            }
        };
    }
    public String getInfo(MediaPlayer mPlayer) {
        String info = "File : " + name[noSong] + " \n";
        info += "Time : " + mPlayer.getDuration() + " milliseconds\n";
        info += "Lopp is " + mPlayer.isLooping() +"\n";
        info += "Play is " + mPlayer.isPlaying() +"\n";
        info += "Now position is " + mPlayer.getCurrentPosition() + "\n";
        return info;
    }
}