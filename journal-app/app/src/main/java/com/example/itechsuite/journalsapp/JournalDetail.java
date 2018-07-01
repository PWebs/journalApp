package com.example.itechsuite.journalsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class JournalDetail extends AppCompatActivity {

    DbAdapter db;
    String id, medName,  medDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_detail);


        Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        medName = intent.getStringExtra("MEDICATION_NAME");
        medDescription = intent.getStringExtra("DESCRIPTION");
        ((TextView) findViewById(R.id.medName)).setText(medName);
        ((TextView) findViewById(R.id.medDescription)).setText(medDescription);
        //calling DbAdapter
        db = new DbAdapter(this);
        db.open();
    }

    public void Edit(View v) {
        //go to EditContact page
        Intent edit = new Intent(JournalDetail.this, EditJournal.class);
        edit.putExtra("ID", id);
        edit.putExtra("MEDICATION_NAME", medName);
        edit.putExtra("DESCRIPTION", medDescription);
        startActivity(edit);
    }

    public void Delete(View v) {
        db.delete(Integer.parseInt(id));
        Toast.makeText(getApplicationContext(), "Journal successfully deleted", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(JournalDetail.this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
