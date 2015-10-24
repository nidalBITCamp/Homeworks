package com.example.nn.androidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private static PersonList persons = new PersonList();
    private EditText personName;
    private EditText personSurname;
    private Button addPerson;
    private Button delete;
    private Button edit;
    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        personName = (EditText) findViewById(R.id.name);
        personSurname = (EditText) findViewById(R.id.surname);
        addPerson = (Button) findViewById(R.id.add_person);
        recyclerView = (RecyclerView) findViewById(R.id.personList);


        addPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable firstName = personName.getText();
                Editable surName = personSurname.getText();

                persons.addPerson(firstName, surName);

                personAdapter.notifyDataSetChanged();

                personName.setText("");
                personSurname.setText("");
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        personAdapter = new PersonAdapter(persons);
        recyclerView.setAdapter(personAdapter);


    }

    private class PersonView extends RecyclerView.ViewHolder {

        private TextView personName;
        private TextView personSurname;
        private TextView dateText;
        private Button delete;
        private Button edit;

        public PersonView(View itemView) {
            super(itemView);

            personName = (TextView) itemView.findViewById(R.id.textView2);
            personSurname = (TextView) itemView.findViewById(R.id.textView3);
            dateText = (TextView) itemView.findViewById(R.id.textView4);
            delete = (Button) itemView.findViewById(R.id.delete);
            edit = (Button) itemView.findViewById(R.id.edit);
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }
    }

    private class PersonAdapter extends RecyclerView.Adapter<PersonView> {

        private PersonList personList;

        public PersonAdapter(PersonList personList) {
            this.personList = personList;
        }

        @Override
        public PersonView onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);

            View view = layoutInflater.inflate(R.layout.person_layout, parent, false);

            return new PersonView(view);
        }

        @Override
        public void onBindViewHolder(PersonView holder, int position) {
            final Person person = personList.getPerson(position);

            holder.personName.setText(person.getmName());
            holder.personSurname.setText(person.getmSurname());
            holder.dateText.setText(person.getmDate().toString());
            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    personList.removePerson(person.getmId());
                    personAdapter.notifyDataSetChanged();

                }
            });

            holder.edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, EditUser.class);
                    intent.putExtra("name", person.getmName());
                    intent.putExtra("surname", person.getmSurname());
                    intent.putExtra("id", person.getmId());
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return personList.getSize();
        }
    }
}







