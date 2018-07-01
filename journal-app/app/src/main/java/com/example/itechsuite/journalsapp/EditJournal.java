package com.example.itechsuite.journalsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditJournal extends AppCompatActivity {
    DbAdapter db;
    String id,medName,medDescription;
    EditText editTextMedName,editTextMedDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_contact);

        Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        medName = intent.getStringExtra("MEDICATION_NAME");
        medDescription = intent.getStringExtra("DESCRIPTION");
        ((EditText) findViewById(R.id.medName)).setText(medName);
        ((EditText) findViewById(R.id.medDescription)).setText(medDescription);

        //calling DbAdapter
        db = new DbAdapter(this);
        db.open();
        //get data from text feld
        editTextMedName =(EditText)findViewById(R.id.medName);
        editTextMedDescription =(EditText)findViewById(R.id.medDescription);

    }
    public void Save(View v){
        medName=editTextMedName.getText().toString();
        medDescription=editTextMedDescription.getText().toString();
        db.update(Integer.parseInt(id),medName, medDescription);
        Toast.makeText(getApplicationContext(),"Journal successfully Updated", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(EditJournal.this, HomeActivity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        finish();
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }
}
