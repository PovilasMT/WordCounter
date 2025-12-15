package com.example.wordcounter;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtInputText;
    private Spinner spnCountType;
    private Button btnCalculate;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Susiejame UI elementus
        edtInputText = findViewById(R.id.edtInputText);
        spnCountType = findViewById(R.id.spnCountType);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);

        // Spinner adapteris (Words / Characters)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.count_types,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCountType.setAdapter(adapter);

        // Mygtuko paspaudimas
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCalculate();
            }
        });
    }

    private void handleCalculate() {
        String inputText = edtInputText.getText().toString();

        // Jei tuščias tekstas – Toast
        if (inputText.trim().isEmpty()) {
            Toast.makeText(this, "Please enter some text", Toast.LENGTH_SHORT).show();
            return;
        }

        int selectedPosition = spnCountType.getSelectedItemPosition();

        if (selectedPosition == 0) {
            // Words – SKAIČIUOJAM PER ATSKIRĄ KLASĘ
            int words = TextCounter.countWords(inputText);
            txtResult.setText("Words count: " + words);
        } else {
            // Characters
            int chars = inputText.length();
            txtResult.setText("Characters count: " + chars);
        }
    }
}

