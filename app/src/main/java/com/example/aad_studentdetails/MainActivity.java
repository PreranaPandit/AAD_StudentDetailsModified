package com.example.aad_studentdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    //EditText Referencing
    EditText etName;

    //RadioGroup and radiobutton referencing
    RadioGroup rdoGroup;
    RadioButton rdobtnMale, rdobtnFemale, rdobtnOthers, gender;

    //Spinner referencing
    private Spinner spinCountry;

    //AutoCompleteTextView referencing
    private AutoCompleteTextView autoCompleteTextView;

    //passing an array to the batch in AutoCompleteTextView
    private String[] batch = {"19A","19B","20A","20B","21A","21B","22A","22B","22C","23A","23B"};

    //Button referencing
    Button btnSave;

    //TextView referencing
    TextView tvOutput, tvName, tvGender, tvCountry, tvBatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Data Binding
        etName = (EditText) findViewById(R.id.etName);
        rdoGroup = (RadioGroup) findViewById(R.id.rdoGroup);
        rdobtnMale = (RadioButton) findViewById(R.id.rdobtnMale);
        rdobtnFemale = (RadioButton) findViewById(R.id.rdobtnFemale);
        rdobtnOthers = (RadioButton) findViewById(R.id.rdobtnOthers);
        spinCountry = findViewById(R.id.spinCountry);
        autoCompleteTextView = findViewById(R.id.actvBatch);
        btnSave = (Button) findViewById(R.id.btnSave);
        tvOutput = (TextView) findViewById(R.id.tvOutput);
        tvName = (TextView) findViewById(R.id.tvName);
        tvGender = (TextView) findViewById(R.id.tvGender);
        tvCountry = (TextView) findViewById(R.id.tvCountry);
        tvBatch = (TextView) findViewById(R.id.tvBatch);



        //passing an array to the countries in spinner
        String countries[] = {"Nepal","India","China","Pakistan","US","UK","Bangladesh","Russia","Spain","Germany"};
        ArrayAdapter adapter = new ArrayAdapter<>
                (
            this,
            android.R.layout.simple_list_item_1, countries
            );
        spinCountry.setAdapter(adapter);

        //Listener passing on spinner; not compulsory
        spinCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               // Toast.makeText(MainActivity.this, spinCountry.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

       //listener passing to autoCompleteTextView
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.select_dialog_item,batch
        );
        autoCompleteTextView.setAdapter(stringArrayAdapter);
        //threshold (1) begins after typing single number/alphabet:: for 2- write threshold(2)
        autoCompleteTextView.setThreshold(1);

        //implementing onclick listener on the main activity


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                tvName.setText("Name : "+ etName.getText().toString());
                tvCountry.setText("Country : " + spinCountry.getSelectedItem().toString());
                tvBatch.setText("Batch : " + autoCompleteTextView.getText().toString());


                int selectedID = rdoGroup.getCheckedRadioButtonId();
                gender = findViewById(selectedID);
                switch (gender.getId()) {
                    case R.id.rdobtnMale:
                        tvGender.setText("Gender : " + rdobtnMale.getText().toString());
                        break;
                    case R.id.rdobtnFemale:
                        tvGender.setText("Gender : " + rdobtnFemale.getText().toString());
                        break;
                    case R.id.rdobtnOthers:
                        tvGender.setText("Gender : " + rdobtnOthers.getText().toString());
                        break;

                }
            }


        });
}}

