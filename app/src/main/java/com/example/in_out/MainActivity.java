package com.example.in_out;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button btn_in,btn_out;
    private long backPressed;
    private Toast backToast;

    @Override
    public void onBackPressed() {

        if(backPressed + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            finishAffinity();
            return;
        }

        else {
            backToast=Toast.makeText(getBaseContext(),"Press back again to exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressed = System.currentTimeMillis();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_in = (Button)findViewById(R.id.btn_in);
        btn_out = (Button) findViewById(R.id.btn_out);

        btn_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInScreen();
            }
        });

        btn_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOutScreen();
            }
        });


    }

    public void openInScreen()
    {
        Intent intent = new Intent(this,in_screen.class);
        startActivity(intent);
    }

    public void openOutScreen()
    {
        Intent intent = new Intent(this,out_screen.class);
        startActivity(intent);
    }
}