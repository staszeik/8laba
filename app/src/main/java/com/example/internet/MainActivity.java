package com.example.internet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private FrameLayout constraintLayout;
    private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onClick(View view) {
        constraintLayout = (FrameLayout) findViewById(R.id.constraintLayout);
        myButton = (Button) findViewById(R.id.myButton);
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            myButton.setVisibility(View.INVISIBLE);

            constraintLayout.setBackground(getDrawable(R.drawable.online));
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    "Подключение есть \n Добро пожаловать в приложение!", Toast.LENGTH_LONG);
            toast1.show();
        } else {
            myButton.setVisibility(View.INVISIBLE);
            constraintLayout.setBackground(getDrawable(R.drawable.offline));
            Toast toast2 = Toast.makeText(getApplicationContext(),
                    "НЕт подключения. Разрешите доступ и повторите попытку.", Toast.LENGTH_LONG);
            toast2.show();
        }
    }
}
