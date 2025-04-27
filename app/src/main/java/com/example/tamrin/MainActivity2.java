package com.example.tamrin;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity2 extends AppCompatActivity {
    private UserManager userManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);



        Button showDialogButton = findViewById(R.id.showDialogButton); // فرض بر اینه که توی activity_main این دکمه هست

        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }

    private void showCustomDialog() {
        Dialog dialog = new Dialog(MainActivity2.this);
        dialog.setContentView(R.layout.activity_main44);

        userManager=new UserManager(this);
        TextView title = dialog.findViewById(R.id.dialogTitle);
        Button okButton = dialog.findViewById(R.id.btnOk);
        title.setText(userManager.geton());

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}



