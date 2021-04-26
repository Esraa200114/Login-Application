package com.example.myfirsttask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    ImageView facebook;
    Button login;
    TextView alert;

    String saved_username = "Admin";
    String saved_password = "1234";
    int counter = 0;

       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);

           findViews();
           setAction();
       }

        public void findViews(){

            facebook = findViewById(R.id.image_1);

            username = findViewById(R.id.text_1);
            password = findViewById(R.id.text_2);

            login = findViewById(R.id.button_1);

            alert = findViewById(R.id.alert);
        }

        public void setAction(){

            login.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                    if (password.getText().toString().equals(saved_password) && username.getText().toString().equals(saved_username)) {

                        Intent intent = new Intent(MainActivity.this, Activity2.class);
                        startActivity(intent);

                    }else{

                        if (!password.getText().toString().equals(saved_password) && username.getText().toString().equals(saved_username)) {

                            counter++;
                            if(counter > 5){

                                alert.setText("Can't log in ! You have clicked on the button more than 5 times. Please wait for 5 seconds.");
                                login.setEnabled(false);

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        login.setEnabled(true);
                                        alert.setText("Please Try again.");
                                        alert.setTextColor(Color.GREEN);
                                    }
                                },5000);
                            }
                        }
                    }
                }
            });
        }

}