package com.example.task13july2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText nameET, messageET;
    RadioButton maleRB, femaleRT;
    //Hi Syed!!!

    //I am awesome!!!
    RadioGroup radioGroup;
    CheckBox agree;
    Button toastB, showB, nextB;
    TextView dataViewTextView, tv;
    Spinner spinner;
    String contact;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameET = findViewById(R.id.editTextName);
        messageET = findViewById(R.id.editTextMessege);
        maleRB = findViewById(R.id.radioButtonMale);
        femaleRT = findViewById(R.id.radioButtonFemale);
        radioGroup = findViewById(R.id.radioGroup);
        agree = findViewById(R.id.checkBox);
        toastB = findViewById(R.id.buttonToast);
        showB = findViewById(R.id.buttonShow);
        nextB = findViewById(R.id.buttonNext);
        dataViewTextView = findViewById(R.id.textView);
        spinner = findViewById(R.id.spinner);
        tv = findViewById(R.id.tv);
        contact = "";
        arrayList = new ArrayList();
        arrayList.add("Select a Number to contact");
        arrayList.add("RANJIT");
        arrayList.add("SUMIT");
        arrayList.add("BACHIR");
        arrayList.add("SERGIO");
        arrayList.add("SIRAT");
        arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                contact = spinner.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, contact + " -> " + position, Toast.LENGTH_SHORT);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void toastMethod(View view) {
      ///  Toast.makeText(MainActivity.this, "Agree that the data is correct", Toast.LENGTH_SHORT);
        if (agree.isChecked()) {
            String name = nameET.getText().toString();
            String messege = messageET.getText().toString();
            String gender = "";
            int rgId = radioGroup.getCheckedRadioButtonId();
            if (rgId == R.id.radioButtonMale) {
                gender = "male";
            } else if (rgId == R.id.radioButtonFemale) {
                gender = "female";
            }
            String text = "Name: " + name + "\nGender: " + gender + "\nMessege: " + messege + "\nSend to: " + contact;

            Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Agree that the data is correct", Toast.LENGTH_SHORT);
        }
    }

    public void showMethod(View view) {
        if (agree.isChecked()) {
            String name = nameET.getText().toString();
            String messege = messageET.getText().toString();
            String gender = "";
            int rgId = radioGroup.getCheckedRadioButtonId();
            if (rgId == R.id.radioButtonMale) {
                gender = "male";
            } else if (rgId == R.id.radioButtonFemale) {
                gender = "female";
            }
            String text = "Name: " + name + "\nGender: " + gender + "\nMessege: " + messege + "\nSend to: " + contact;

            dataViewTextView.setText(text);
        } else {
            Toast.makeText(MainActivity.this, "Agree that the data is correct", Toast.LENGTH_SHORT);
        }
    }

    public void nextMethod(View view) {
        String name = "";
        String messege = "";
        String gender = "";
        if (agree.isChecked()) {
            name = nameET.getText().toString();
            messege = messageET.getText().toString();
            int rgId = radioGroup.getCheckedRadioButtonId();
            if (rgId == R.id.radioButtonMale) {
                gender = "male";
            } else if (rgId == R.id.radioButtonFemale) {
                gender = "female";
            }
            String text = "Name: " + name + "\nGender: " + gender + "\nMessege: " + messege + "\nSend to: " + contact;

            dataViewTextView.setText(text);
        } else {
            Toast.makeText(MainActivity.this, "Agree that the data is correct", Toast.LENGTH_SHORT);
        }

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("name", name);
        intent.putExtra("messege", messege);
    }
}
