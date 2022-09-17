package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity<length> extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondact);




//loading the words table and choosing a random word in data array


        Data tab = new Data();
        String[] word = tab.data;
        int a = (int) (Math.random()* 650 );
        String wordle = word[a].toUpperCase();
//initializing the letter blocks
        EditText txt = (EditText)findViewById(R.id.editText1) ;
        EditText txt2 = (EditText)findViewById(R.id.editText2);
        EditText txt3 = (EditText)findViewById(R.id.editText3) ;
        EditText txt4 = (EditText)findViewById(R.id.editText4);
        EditText txt5 = (EditText)findViewById(R.id.editText5) ;
        EditText txt6 = (EditText)findViewById(R.id.editText6);
        EditText txt7 = (EditText)findViewById(R.id.editText7) ;
        EditText txt8 = (EditText)findViewById(R.id.editText8);
        EditText txt9 = (EditText)findViewById(R.id.editText9) ;
        EditText txt10 = (EditText)findViewById(R.id.editText10);
        EditText txt11 = (EditText)findViewById(R.id.editText11) ;
        EditText txt12 = (EditText)findViewById(R.id.editText12);
        EditText txt13 = (EditText)findViewById(R.id.editText13) ;
        EditText txt14 = (EditText)findViewById(R.id.editText14);
        EditText txt15 = (EditText)findViewById(R.id.editText15) ;
        EditText txt16 = (EditText)findViewById(R.id.editText16);
        EditText txt17 = (EditText)findViewById(R.id.editText17) ;
        EditText txt18 = (EditText)findViewById(R.id.editText18);
        EditText txt19 = (EditText)findViewById(R.id.editText19) ;
        EditText txt20 = (EditText)findViewById(R.id.editText20);
        EditText txt21 = (EditText)findViewById(R.id.editText21) ;
        EditText txt22 = (EditText)findViewById(R.id.editText22);
        EditText txt23 = (EditText)findViewById(R.id.editText23) ;
        EditText txt24 = (EditText)findViewById(R.id.editText24);
        EditText txt25 = (EditText)findViewById(R.id.editText25) ;
        EditText txt26 = (EditText)findViewById(R.id.editText26);
        EditText txt27 = (EditText)findViewById(R.id.editText27) ;
        EditText txt28 = (EditText)findViewById(R.id.editText28);
        EditText txt29 = (EditText)findViewById(R.id.editText29) ;
        EditText txt30 = (EditText)findViewById(R.id.editText30);

        EditText[] row1 = {txt,txt2,txt3,txt4,txt5};
        EditText[] row2 = {txt6,txt7,txt8,txt9,txt10};
        EditText[] row3 = {txt11,txt12,txt13,txt14,txt15};
        EditText[] row4 = {txt16,txt17,txt18,txt19,txt20};
        EditText[] row5 = {txt21,txt22,txt23,txt24,txt25};
        EditText[] row6 = {txt26,txt27,txt28,txt29,txt30};

        //defining buttons


        Button x =findViewById(R.id.check);
        Button but5 = findViewById(R.id.help);





        //initialising an alert dialog for success

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);


        builder1.setMessage("You guessed right.");
        builder1.setCancelable(true);
        builder1.setPositiveButton(
                "Replay",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        finish();
                        startActivity(getIntent());
                    }
                });


        AlertDialog alert11 = builder1.create();






        //an explicit intent to a help page



        but5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent= new Intent(getApplicationContext(),Help.class);
                startActivity(intent);
            }
        });


        //sound playing on input
        final MediaPlayer mp =MediaPlayer.create(this, R.raw.click);



//looping over blocks and taking input


        for (int i = 0; i < 4; i++) {
            int finalI = i;
            int finalI1 = i;


            row1[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {

                    //looping over blocks in row1 and requesting focus to the next block on input
                    if (row1[finalI].getText().toString().length() > 0) {
                        row1[finalI + 1].requestFocus();
                        mp.start();
                    }


                }
            });


        }


        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //when "check" is clicked, a loop is initialized to check whether a letter is in its right place and sets background
                //color to green, if it exists in the word, the background color is set to yellow and it stays unchanged otherwise

                for (int i = 0; i < 5; i++) {
                    if (wordle.indexOf(row1[i].getText().toString().charAt(0)) != -1) {
                        row1[i].setBackgroundColor(Color.YELLOW);
                        if (Character.compare(row1[i].getText().toString().charAt(0), wordle.charAt(i)) == 0) {
                            row1[i].setBackgroundColor(Color.GREEN);

                        }
                    }

                }


                row2[0].requestFocus();
                for (int i = 0; i < 4; i++) {
                    int finalI = i;
                    int finalI1 = i;


                    row2[i].addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {
                            if (row2[finalI].getText().toString().length() > 0) {
                                row2[finalI + 1].requestFocus();
                                mp.start();
                            }


                        }
                    });


                }


                x.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        for (int i = 0; i < 5; i++) {
                            if (wordle.indexOf(row2[i].getText().toString().charAt(0)) != -1) {
                                row2[i].setBackgroundColor(Color.YELLOW);
                                if (Character.compare(row2[i].getText().toString().charAt(0), wordle.charAt(i)) == 0) {
                                    row2[i].setBackgroundColor(Color.GREEN);

                                }
                            }

                        }


                        row3[0].requestFocus();
                        for (int i = 0; i < 4; i++) {
                            int finalI = i;
                            int finalI1 = i;


                            row3[i].addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                }

                                @Override
                                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                }

                                @Override
                                public void afterTextChanged(Editable editable) {
                                    if (row3[finalI].getText().toString().length() > 0) {
                                        row3[finalI + 1].requestFocus();
                                        mp.start();
                                    }


                                }
                            });


                        }


                        x.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                for (int i = 0; i < 5; i++) {
                                    if (wordle.indexOf(row3[i].getText().toString().charAt(0)) != -1) {
                                        row3[i].setBackgroundColor(Color.YELLOW);
                                        if (Character.compare(row3[i].getText().toString().charAt(0), wordle.charAt(i)) == 0) {
                                            row3[i].setBackgroundColor(Color.GREEN);

                                        }
                                    }

                                }


                                row4[0].requestFocus();
                                for (int i = 0; i < 4; i++) {
                                    int finalI = i;
                                    int finalI1 = i;


                                    row4[i].addTextChangedListener(new TextWatcher() {
                                        @Override
                                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                        }

                                        @Override
                                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                        }

                                        @Override
                                        public void afterTextChanged(Editable editable) {
                                            if (row4[finalI].getText().toString().length() > 0) {
                                                row4[finalI + 1].requestFocus();
                                                mp.start();
                                            }


                                        }
                                    });


                                }


                                x.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        for (int i = 0; i < 5; i++) {
                                            if (wordle.indexOf(row4[i].getText().toString().charAt(0)) != -1) {
                                                row4[i].setBackgroundColor(Color.YELLOW);
                                                if (Character.compare(row4[i].getText().toString().charAt(0), wordle.charAt(i)) == 0) {
                                                    row4[i].setBackgroundColor(Color.GREEN);

                                                }
                                            }

                                        }



                                        row5[0].requestFocus();
                                        for (int i = 0; i < 4; i++) {
                                            int finalI = i;
                                            int finalI1 = i;


                                            row5[i].addTextChangedListener(new TextWatcher() {
                                                @Override
                                                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                }

                                                @Override
                                                public void afterTextChanged(Editable editable) {
                                                    if (row5[finalI].getText().toString().length() > 0) {
                                                        row5[finalI + 1].requestFocus();
                                                        mp.start();
                                                    }


                                                }
                                            });


                                        }


                                        x.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {

                                                for (int i = 0; i < 5; i++) {
                                                    if (wordle.indexOf(row5[i].getText().toString().charAt(0)) != -1) {
                                                        row5[i].setBackgroundColor(Color.YELLOW);
                                                        if (Character.compare(row5[i].getText().toString().charAt(0), wordle.charAt(i)) == 0) {
                                                            row5[i].setBackgroundColor(Color.GREEN);

                                                        }
                                                    }

                                                }


                                                row6[0].requestFocus();
                                                for (int i = 0; i < 4; i++) {
                                                    int finalI = i;
                                                    int finalI1 = i;


                                                    row6[i].addTextChangedListener(new TextWatcher() {
                                                        @Override
                                                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                        }

                                                        @Override
                                                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                        }

                                                        @Override
                                                        public void afterTextChanged(Editable editable) {
                                                            if (row6[finalI].getText().toString().length() > 0) {
                                                                row6[finalI + 1].requestFocus();
                                                                mp.start();
                                                            }


                                                        }
                                                    });


                                                }


                                                x.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {

                                                        for (int i = 0; i < 5; i++) {
                                                            if (wordle.indexOf(row6[i].getText().toString().charAt(0)) != -1) {
                                                                row5[i].setBackgroundColor(Color.YELLOW);
                                                                if (Character.compare(row6[i].getText().toString().charAt(0), wordle.charAt(i)) == 0) {
                                                                    row6[i].setBackgroundColor(Color.GREEN);

                                                                }
                                                            }

                                                        }



                                                    }
                                                });

                                            }
                                        });

                                    }
                                });

                            }
                        });

                    }
                });


            }
        });














    }

}
