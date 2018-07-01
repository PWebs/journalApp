package com.example.itechsuite.journalsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewJournal extends AppCompatActivity {

        //calling variables
        DbAdapter db;
        EditText editTextMedName,  editTextDescription;
        String medName,  medDescription;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_contact);

        //get data from text feld
        editTextMedName = (EditText) findViewById(R.id.medName);
        editTextDescription = (EditText) findViewById(R.id.medDescription);

        //timeSpinner();
        //calling DbAdapter
        db = new DbAdapter(this);
        db.open();
    }

    public void Save(View v) {
        medName = editTextMedName.getText().toString();
        medDescription = editTextDescription.getText().toString();
        db.insert(medName, medDescription);
        Toast.makeText(getApplicationContext(), "Journal successfully added", Toast.LENGTH_SHORT).show();


        Intent intent = new Intent(AddNewJournal.this, MainActivity.class);
        startActivity(intent);

    }



    @Override
    public void onBackPressed() {
        finish();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}