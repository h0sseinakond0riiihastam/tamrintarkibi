package com.example.tamrin;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    private UserManager userManager;
    boolean isReceiverRegistered = false;
    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        userManager=new UserManager(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button onoff = findViewById(R.id.button);
        Button dastorat=findViewById(R.id.button2);
        textview = findViewById(R.id.textView);

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
                    if (getInternetStatus()) {
                        textview.setText("there is available network (for shared pereference)");
                    } else {
                        textview.setText("there is no available network");
                    }
                }
            }
        };


        onoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isReceiverRegistered) {
                    registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
                    Toast.makeText(MainActivity.this, "گیرنده فعال شد", Toast.LENGTH_SHORT).show();
//                    textview.setText("گیرنده فعال است");
                    isReceiverRegistered = true;
                } else {
                    unregisterReceiver(broadcastReceiver);
                    Toast.makeText(MainActivity.this, "گیرنده غیرفعال شد", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(MainActivity.this,"گیرنده غیرفعال است",Toast.LENGTH_SHORT).show();
                    textview.setText("");
                    isReceiverRegistered = false;
                }
            }
        });

        dastorat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isReceiverRegistered == true & getInternetStatus()){
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                    userManager.saveUserInformation(textview.getText().toString(),
                            textview.getText().toString()
                    );
                   }
                else {
                    Intent intent=new Intent(MainActivity.this,MainActivity3.class);
                    startActivity(intent);}
            }
        });

    }

    public boolean getInternetStatus() {
        ConnectivityManager contConnectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = contConnectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (isReceiverRegistered) {
            unregisterReceiver(broadcastReceiver);
        }
    }
}