package com.example.assign05_6406021630039;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Random;

public class MatchingGameActivity extends AppCompatActivity implements View.OnClickListener{

    private int[] Images = {
            R.drawable.apple, R.drawable.express, R.drawable.github,
            R.drawable.ionic, R.drawable.linux, R.drawable.sequelize,
            R.drawable.slack, R.drawable.typescript, R.drawable.visualstudio,
            R.drawable.yarn
    };
    private int[] RandomImages = new int[8];
    private Random rand = new Random();
    private CountDownTimer[] gameTimer = new CountDownTimer[2];

    private ImageButton[] btnCards = new ImageButton[16];
    private TextView[] gameInfoView = new TextView[2];
    HashMap<Integer, Integer> imageIndexs = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> btnIndexs = new HashMap<Integer, Integer>();
    private int cardFliped ,timeRemaining,score = 0;
    private boolean isCardFliping = false;
    private int[] flipCard = new int[2];
    private int[] currentflipCards = new int[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_game);
        setTitle("Matching Game");
        btnCards[0] = findViewById(R.id.btnCard_0);
        btnCards[0].setOnClickListener(this);
        btnCards[1] = findViewById(R.id.btnCard_1);
        btnCards[1].setOnClickListener(this);
        btnCards[2] = findViewById(R.id.btnCard_2);
        btnCards[2].setOnClickListener(this);
        btnCards[3] = findViewById(R.id.btnCard_3);
        btnCards[3].setOnClickListener(this);
        btnCards[4] = findViewById(R.id.btnCard_4);
        btnCards[4].setOnClickListener(this);
        btnCards[5] = findViewById(R.id.btnCard_5);
        btnCards[5].setOnClickListener(this);
        btnCards[6] = findViewById(R.id.btnCard_6);
        btnCards[6].setOnClickListener(this);
        btnCards[7] = findViewById(R.id.btnCard_7);
        btnCards[7].setOnClickListener(this);
        btnCards[8] = findViewById(R.id.btnCard_8);
        btnCards[8].setOnClickListener(this);
        btnCards[9] = findViewById(R.id.btnCard_9);
        btnCards[9].setOnClickListener(this);
        btnCards[10] = findViewById(R.id.btnCard_10);
        btnCards[10].setOnClickListener(this);
        btnCards[11] = findViewById(R.id.btnCard_11);
        btnCards[11].setOnClickListener(this);
        btnCards[12] = findViewById(R.id.btnCard_12);
        btnCards[12].setOnClickListener(this);
        btnCards[13] = findViewById(R.id.btnCard_13);
        btnCards[13].setOnClickListener(this);
        btnCards[14] = findViewById(R.id.btnCard_14);
        btnCards[14].setOnClickListener(this);
        btnCards[15] = findViewById(R.id.btnCard_15);
        btnCards[15].setOnClickListener(this);

        gameInfoView[0] = findViewById(R.id.scoreView);
        gameInfoView[1] = findViewById(R.id.timeView);

        INIT();
    }
    private void INIT() {

        /**
         * ทำการสุ่มรูปเริ่มต้นจำนวน 8 รูปปจาก Images เพื่อใช้ในทำงานต่อไป
         * **/
        int startImageIndex = rand.nextInt(Images.length); //0-9
        for (int i = 0; i < btnCards.length/2; i++) { //i=0-7
            startImageIndex++;
            if (startImageIndex == Images.length) {
                startImageIndex = 0;
            }
            RandomImages[i] = Images[startImageIndex];
        }

        /**
         * เอารูปเริ่มต้นที่ได้จากการสุ่มมา ทำการใส่สุ่มในตัวแปรเพื่อไม่ให้ซ้ำกันในแต่ละรอบ
         * และมีรูปแบบที่หลากหลายมากขึ้น
         * **/
        int startBtnIndex = rand.nextInt(btnCards.length);
        for (int j = 1; j < 3; j++) {
            startImageIndex = j * rand.nextInt(RandomImages.length);
            for (int i = 0; i < btnCards.length/2; i++) {

                if (startImageIndex > RandomImages.length-1) {
                    startImageIndex = 0;
                }

                if (startBtnIndex > btnCards.length-1) {
                    startBtnIndex = 0;
                }

                imageIndexs.put(btnCards[startBtnIndex].getId(), startImageIndex);
                btnIndexs.put(btnCards[startBtnIndex].getId(), startBtnIndex);

                startBtnIndex++;
                startImageIndex++;
            }
        }
    }
    private void START() {

        flipCard[0] = 0;
        flipCard[1] = 1;
        currentflipCards[0] = 0;
        currentflipCards[1] = 1;
        score = 0;
        cardFliped = 0;
        timeRemaining = 60;
        isCardFliping = false;

        for (int i = 0; i < 16; i++) {
            btnCards[i].setImageResource(R.drawable.card_deck);
        }

        gameTimer[0] = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                gameInfoView[1].setText("" + timeRemaining);
                timeRemaining--;
            }

            @Override
            public void onFinish() {
                timeRemaining = 0;
                onGameEnded();
                INIT();
//                START();
            }
        };
        gameTimer[0].start();
        onGameStarted();

    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnGameStart) {
            if (timeRemaining == 0) {
                START();
            }
        } else if (timeRemaining > 0 && !isCardFliping) {
            int viewId = v.getId(); //5584587
            int randomId = imageIndexs.get(viewId); // 07 -> 4
            int btnId = btnIndexs.get(viewId); // 07 -> 7

            if (cardFliped < 2) { //0-1
                Log.i("MY_APP", "-> cardFliped : " + cardFliped);
                flipCard[cardFliped] = randomId;
                currentflipCards[cardFliped] = btnId; // 0 -> 1 | 1 -> 4
                btnCards[btnId].setClickable(false);
                btnCards[btnId].setImageResource(RandomImages[randomId]);
                cardFliped++;
            }

            if (cardFliped == 2) {
                isCardFliping = true;
                Log.i("MY_APP","-> CHECK FLIP CARD");
                if (flipCard[0] == flipCard[1]) {
                    flipCard[0] = 0;
                    flipCard[1] = 1;
                    onMatched();
                } else {
                    flipCard[0] = 0;
                    flipCard[1] = 1;
                    onMissed();
                }
            }
        }
    }
    private void onMatched() {

        Log.i("MY_APP","Matched");
        score++;
        gameInfoView[0].setText("" + score);

        if (score == btnCards.length/2) {
            onGameWinner();
        }
        gameTimer[1] = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                cardFliped = 0;
                isCardFliping = false;
            }
        }.start();
    }
    private void onMissed() {

        Log.i("MY_APP","Missing");
        gameTimer[1] = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                btnCards[currentflipCards[0]].setClickable(true);
                btnCards[currentflipCards[1]].setClickable(true);
                btnCards[currentflipCards[0]].setImageResource(R.drawable.card_deck);
                btnCards[currentflipCards[1]].setImageResource(R.drawable.card_deck);
                cardFliped = 0;
                isCardFliping = false;
            }
        }.start();
    }
    private void onGameStarted() {
        Toast.makeText(MatchingGameActivity.this, "Game Starting...", Toast.LENGTH_SHORT).show();
    }
    private void onGameEnded() {
        gameTimer[0].cancel();
        gameInfoView[1].setText("GAME ENDED");
        INIT();
        Toast.makeText(MatchingGameActivity.this, "END GAME !!!\n!!!! --- YOU LOOSE --- !!!", Toast.LENGTH_SHORT).show();
    }
    private void onGameWinner() {
        gameTimer[0].cancel();
        gameInfoView[1].setText("YOU WIN");
        INIT();
        Toast.makeText(MatchingGameActivity.this, "!!!! --- YOU WIN --- !!!",
                Toast.LENGTH_SHORT).show();
    }
}