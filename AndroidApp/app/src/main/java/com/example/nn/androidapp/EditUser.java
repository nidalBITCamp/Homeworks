package com.example.nn.androidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by NN on 24.10.2015.
 */
public class EditUser extends AppCompatActivity {

    private EditText name;
    private EditText surname;
    private Button ok;

    private PersonList persons = new PersonList();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.person_edit);

        name = (EditText) findViewById(R.id.edit_first_name);
        surname = (EditText) findViewById(R.id.edit_last_name);
        ok = (Button) findViewById(R.id.ok_button);

        String firstName = getIntent().getExtras().get("name").toString();
        String lastName = getIntent().getExtras().get("surname").toString();
        final String id = getIntent().getExtras().get("id").toString();



        name.setText(firstName);
        surname.setText(lastName);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstName = name.getText().toString();
                String lastName = surname.getText().toString();

                persons.editPerson(id, firstName, lastName);

            }
        });

    }
}