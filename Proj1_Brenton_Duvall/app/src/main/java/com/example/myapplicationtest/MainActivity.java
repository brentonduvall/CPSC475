package com.example.myapplicationtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    Button butStart;
    Button butReset;
    Button red;
    Button blue;
    Button green;
    Button pink;
    TextView tv;
    TextView tv2;
    TextView tv3;
    String outStr;
    String outStr1;
    String outStr2;
    private static final int NUMBER_ROUNDS = 2;
    int correctCount = 0;
    int wrongCount = 0;
    int roundCount = 1;
    String currentColor;
    enum Colors {
        RED,BLUE,GREEN,PINK;

        public static Colors genRandColor() {
            Colors[] colors = Colors.values();
            int size = colors.length;
            int randIndex = new Random().nextInt(size);
            return colors[randIndex];
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butStart = (Button)findViewById(R.id.startButton);
        butReset = (Button)findViewById(R.id.ResetButton);
        red = (Button)findViewById(R.id.button13);
        blue = (Button)findViewById(R.id.button17);
        green = (Button)findViewById(R.id.button18);
        pink = (Button)findViewById(R.id.button19);

        tv = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv3 = (TextView)findViewById(R.id.textView3);

        red.setEnabled(false);
        blue.setEnabled(false);
        green.setEnabled(false);
        pink.setEnabled(false);

/*        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("                 Clicked by button2");
            }
        });*/
        if (savedInstanceState != null) {
            correctCount = savedInstanceState.getInt("correctCount");
            wrongCount = savedInstanceState.getInt("wrongCount");
            roundCount = savedInstanceState.getInt("roundCount");
            outStr = savedInstanceState.getString("textView1");
            tv.setText(outStr);
            outStr = getString(R.string.NumbRight);
            tv2.setText(outStr + " " + correctCount);
            outStr = getString(R.string.NumbWrong);
            tv3.setText(outStr + " " + wrongCount);
        }
    }
    private void evaluateUser() {
        if (correctCount == NUMBER_ROUNDS) {
            outStr = getString(R.string.Perfect_Score);
        }
        else {
            outStr = getString(R.string.Pay_Attention);

        }
        red.setEnabled(false);
        blue.setEnabled(false);
        green.setEnabled(false);
        pink.setEnabled(false);
        tv.setText(outStr);
    }

    public void resetApp(View view) {
        outStr = getString(R.string.press_start_to_begin);
        tv.setText(outStr);
        correctCount = 0;
        wrongCount = 0;
        roundCount = 1;
        tv2.setText("");
        tv3.setText("");
        butStart.setBackgroundColor(getResources().getColor(R.color.purple_500));
        butReset.setBackgroundColor(getResources().getColor(R.color.gray));
        butReset.setEnabled(false);
        butStart.setEnabled(true);
        red.setEnabled(false);
        blue.setEnabled(false);
        green.setEnabled(false);
        pink.setEnabled(false);





       /* Colors randColor = Colors.genRandColor();
        switch(randColor) {
            case RED:
                currentColor = "Red";
                outStr = getString(R.string.Press_Red);
                tv.setText(outStr);
                break;

            case BLUE:
                currentColor = "Blue";
                outStr = getString(R.string.Press_Blue);
                tv.setText(outStr);
                break;

            case PINK:
                currentColor = "Pink";
                outStr = getString(R.string.Press_Pink);
                tv.setText(outStr);
                break;

            case GREEN:
                currentColor = "Green";
                outStr = getString(R.string.Press_Green);
                tv.setText(outStr);
        }*/
    }


    public void startApp(View view) {
        Colors randColor = Colors.genRandColor();
        outStr1 = getString(R.string.NumbRight);
        outStr2 = getString(R.string.NumbWrong);
        outStr = getString(R.string.press_start_to_begin);
        tv.setText(outStr);
        tv2.setText(outStr1 +  " " + correctCount);
        tv3.setText(outStr2 + " " + wrongCount);
        butStart.setBackgroundColor(getResources().getColor(R.color.gray));
        butReset.setBackgroundColor(getResources().getColor(R.color.purple_500));
        butReset.setEnabled(true);
        butStart.setEnabled(false);
        red.setEnabled(true);
        blue.setEnabled(true);
        green.setEnabled(true);
        pink.setEnabled(true);

        /*tv.setText(*/

        switch(randColor) {
            case RED:
                currentColor = "Red";
                outStr = getString(R.string.Press_Red);
                tv.setText(outStr);
                break;

            case BLUE:
                currentColor = "Blue";
                outStr = getString(R.string.Press_Blue);
                tv.setText(outStr);
                break;

            case PINK:
                currentColor = "Pink";
                outStr = getString(R.string.Press_Pink);
                tv.setText(outStr);
                break;

            case GREEN:
                currentColor = "Green";
                outStr = getString(R.string.Press_Green);
                tv.setText(outStr);
        }
    }


    public void redButt(View view) {
        if (roundCount <= 2) {
            if (currentColor == "Red") {
                correctCount += 1;
                outStr = getString(R.string.NumbRight);
                tv2.setText(outStr + " " + String.valueOf(correctCount));
                roundCount += 1;

                if (roundCount > 2) {
                    evaluateUser();
                }

                else {
                    Colors randColor = Colors.genRandColor();
                    /*tv.setText(*/

                    switch (randColor) {
                        case RED:
                            currentColor = "Red";
                            outStr = getString(R.string.Press_Red);
                            tv.setText(outStr);
                            break;

                        case BLUE:
                            currentColor = "Blue";
                            outStr = getString(R.string.Press_Blue);
                            tv.setText(outStr);
                            break;

                        case PINK:
                            currentColor = "Pink";
                            outStr = getString(R.string.Press_Pink);
                            tv.setText(outStr);
                            break;

                        case GREEN:
                            currentColor = "Green";
                            outStr = getString(R.string.Press_Green);
                            tv.setText(outStr);
                    }
                }
            }
            else {
                wrongCount += 1;
                outStr = getString(R.string.NumbWrong);
                tv3.setText(outStr + " " + String.valueOf(wrongCount));
                roundCount += 1;

                if (roundCount > 2) {
                    evaluateUser();
                }

                else {
                    Colors randColor = Colors.genRandColor();
                    /*tv.setText(*/

                    switch (randColor) {
                        case RED:
                            currentColor = "Red";
                            outStr = getString(R.string.Press_Red);
                            tv.setText(outStr);
                            break;

                        case BLUE:
                            currentColor = "Blue";
                            outStr = getString(R.string.Press_Blue);
                            tv.setText(outStr);
                            break;

                        case PINK:
                            currentColor = "Pink";
                            outStr = getString(R.string.Press_Pink);
                            tv.setText(outStr);
                            break;

                        case GREEN:
                            currentColor = "Green";
                            outStr = getString(R.string.Press_Green);
                            tv.setText(outStr);
                    }
                }
            }


        }
    }
    public void blueButt(View view) {
        if (roundCount <= 2) {
            if (currentColor == "Blue") {
                correctCount += 1;
                outStr = getString(R.string.NumbRight);
                tv2.setText(outStr + " " + String.valueOf(correctCount));
                roundCount += 1;

                if (roundCount > 2) {
                    evaluateUser();
                }

                else {
                    Colors randColor = Colors.genRandColor();
                    /*tv.setText(*/

                    switch (randColor) {
                        case RED:
                            currentColor = "Red";
                            outStr = getString(R.string.Press_Red);
                            tv.setText(outStr);
                            break;

                        case BLUE:
                            currentColor = "Blue";
                            outStr = getString(R.string.Press_Blue);
                            tv.setText(outStr);
                            break;

                        case PINK:
                            currentColor = "Pink";
                            outStr = getString(R.string.Press_Pink);
                            tv.setText(outStr);
                            break;

                        case GREEN:
                            currentColor = "Green";
                            outStr = getString(R.string.Press_Green);
                            tv.setText(outStr);
                    }
                }
            }
            else {
                wrongCount += 1;
                outStr = getString(R.string.NumbWrong);
                tv3.setText(outStr + " " + String.valueOf(wrongCount));
                roundCount += 1;

                if (roundCount > 2) {
                    evaluateUser();
                }

                else {
                    Colors randColor = Colors.genRandColor();
                    /*tv.setText(*/

                    switch (randColor) {
                        case RED:
                            currentColor = "Red";
                            outStr = getString(R.string.Press_Red);
                            tv.setText(outStr);
                            break;

                        case BLUE:
                            currentColor = "Blue";
                            outStr = getString(R.string.Press_Blue);
                            tv.setText(outStr);
                            break;

                        case PINK:
                            currentColor = "Pink";
                            outStr = getString(R.string.Press_Pink);
                            tv.setText(outStr);
                            break;

                        case GREEN:
                            currentColor = "Green";
                            outStr = getString(R.string.Press_Green);
                            tv.setText(outStr);
                    }
                }
            }


        }
    }
    public void pinkButt(View view) {
        if (roundCount <= 2) {
            if (currentColor == "Pink") {
                correctCount += 1;
                outStr = getString(R.string.NumbRight);
                tv2.setText(outStr + " " + String.valueOf(correctCount));
                roundCount += 1;

                if (roundCount > 2) {
                    evaluateUser();
                }

                else {
                    Colors randColor = Colors.genRandColor();
                    /*tv.setText(*/

                    switch (randColor) {
                        case RED:
                            currentColor = "Red";
                            outStr = getString(R.string.Press_Red);
                            tv.setText(outStr);
                            break;

                        case BLUE:
                            currentColor = "Blue";
                            outStr = getString(R.string.Press_Blue);
                            tv.setText(outStr);
                            break;

                        case PINK:
                            currentColor = "Pink";
                            outStr = getString(R.string.Press_Pink);
                            tv.setText(outStr);
                            break;

                        case GREEN:
                            currentColor = "Green";
                            outStr = getString(R.string.Press_Green);
                            tv.setText(outStr);
                    }
                }
            }
            else {
                wrongCount += 1;
                outStr = getString(R.string.NumbWrong);
                tv3.setText(outStr + " " + String.valueOf(wrongCount));
                roundCount += 1;

                if (roundCount > 2) {
                    evaluateUser();
                }

                else {
                    Colors randColor = Colors.genRandColor();
                    /*tv.setText(*/

                    switch (randColor) {
                        case RED:
                            currentColor = "Red";
                            outStr = getString(R.string.Press_Red);
                            tv.setText(outStr);
                            break;

                        case BLUE:
                            currentColor = "Blue";
                            outStr = getString(R.string.Press_Blue);
                            tv.setText(outStr);
                            break;

                        case PINK:
                            currentColor = "Pink";
                            outStr = getString(R.string.Press_Pink);
                            tv.setText(outStr);
                            break;

                        case GREEN:
                            currentColor = "Green";
                            outStr = getString(R.string.Press_Green);
                            tv.setText(outStr);
                    }
                }
            }


        }
    }

    public void greenButt(View view) {
        if (roundCount <= 2) {
            if (currentColor == "Green") {
                correctCount += 1;
                outStr = getString(R.string.NumbRight);
                tv2.setText(outStr + " " + String.valueOf(correctCount));
                roundCount += 1;

                if (roundCount > 2) {
                    evaluateUser();
                }

                else {
                    Colors randColor = Colors.genRandColor();
                    /*tv.setText(*/

                    switch (randColor) {
                        case RED:
                            currentColor = "Red";
                            outStr = getString(R.string.Press_Red);
                            tv.setText(outStr);
                            break;

                        case BLUE:
                            currentColor = "Blue";
                            outStr = getString(R.string.Press_Blue);
                            tv.setText(outStr);
                            break;

                        case PINK:
                            currentColor = "Pink";
                            outStr = getString(R.string.Press_Pink);
                            tv.setText(outStr);
                            break;

                        case GREEN:
                            currentColor = "Green";
                            outStr = getString(R.string.Press_Green);
                            tv.setText(outStr);
                    }
                }
            }
            else {
                wrongCount += 1;
                outStr = getString(R.string.NumbWrong);
                tv3.setText(outStr + " " + String.valueOf(wrongCount));
                roundCount += 1;

                if (roundCount > 2) {
                    evaluateUser();
                }

                else {
                    Colors randColor = Colors.genRandColor();
                    /*tv.setText(*/

                    switch (randColor) {
                        case RED:
                            currentColor = "Red";
                            outStr = getString(R.string.Press_Red);
                            tv.setText(outStr);
                            break;

                        case BLUE:
                            currentColor = "Blue";
                            outStr = getString(R.string.Press_Blue);
                            tv.setText(outStr);
                            break;

                        case PINK:
                            currentColor = "Pink";
                            outStr = getString(R.string.Press_Pink);
                            tv.setText(outStr);
                            break;

                        case GREEN:
                            currentColor = "Green";
                            outStr = getString(R.string.Press_Green);
                            tv.setText(outStr);
                    }
                }
            }


        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("correctCount", correctCount);
        outState.putInt("wrongCount",wrongCount);
        outState.putInt("roundCount", roundCount);
        outState.putString("textView1", tv.getText().toString());

    }
}