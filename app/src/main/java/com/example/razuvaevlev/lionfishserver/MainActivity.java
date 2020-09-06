package com.example.razuvaevlev.lionfishserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button mButton;
    private TextView mText;
    private EditText mHtml;
    public Server p = new Server();
    public Thread t = new Thread(p);
    public static boolean serverState = false;
    public static String hkl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button)findViewById(R.id.start_button);
        mText = (TextView)findViewById(R.id.ser_info);
        mHtml = (EditText) findViewById(R.id.html);
        //hkl = mHtml.getText().toString();


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serverState = !serverState;

                if(serverState){
                    hkl = mHtml.getText().toString();
                    t.start();
                    mText.setText("Server working");
                }

                else{
                    t.interrupt();
                    mText.setText("Server stopped");
                }

            }
        });
    }
}


