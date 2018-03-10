package com.example.nathapong.app62_boxerdataapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // First Step for Writing Data to Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        final DatabaseReference myRef = database.getReferenceFromUrl("https://app62boxerdataapp.firebaseio.com/");

        final EditText edtBoxerID = (EditText)findViewById(R.id.edtBoxerID);
        final EditText edtBoxerName = (EditText)findViewById(R.id.edtBoxerName);
        final EditText edtBoxerPunchPower = (EditText)findViewById(R.id.edtBoxerPunchPower);
        final EditText edtBoxerPuncgSpeed = (EditText)findViewById(R.id.edtBoxerPuncgSpeed);
        final EditText edtBoxerStamina = (EditText)findViewById(R.id.edtBoxerStamina);
        Button btnSendDataToServer = (Button)findViewById(R.id.btnSendDataToServer);


        btnSendDataToServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myRef.child(edtBoxerID.getText().toString())
                        .child("Name").setValue(edtBoxerName.getText().toString());

                myRef.child(edtBoxerID.getText().toString())
                        .child("Boxer Punch Power").setValue(edtBoxerPunchPower.getText().toString());

                myRef.child(edtBoxerID.getText().toString())
                        .child("Boxer Punch Speed").setValue(edtBoxerPuncgSpeed.getText().toString());

                myRef.child(edtBoxerID.getText().toString())
                        .child("Boxer Stamina").setValue(edtBoxerStamina.getText().toString());

            }
        });

    }
}
