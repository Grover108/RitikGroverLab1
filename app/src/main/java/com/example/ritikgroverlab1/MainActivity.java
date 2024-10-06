package com.example.ritikgroverlab1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button; // Import Button
import android.widget.CheckBox; // Import CheckBox
import android.widget.ImageView; // Import ImageView
import android.widget.RadioButton; // Import RadioButton
import android.widget.Switch; // Import Switch
import android.widget.TextView;
import android.widget.CompoundButton; // Import CompoundButton

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textView;  // Declaring the TextView
    private CheckBox myCheckBox; // Declaring the CheckBox
    private Switch mySwitch; // Declaring the Switch
    private RadioButton myRadioButton; // Declaring the RadioButton
    private Button myButton; // Declaring the Button
    private ImageView imageView; // Declaring the ImageView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Handling window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Finding views by their IDs from the layout file
        textView = findViewById(R.id.textView);  // Assuming you have added a TextView in activity_main.xml
        myCheckBox = findViewById(R.id.myCheckBox); // Find the CheckBox by its ID
        mySwitch = findViewById(R.id.mySwitch); // Find the Switch by its ID
        myRadioButton = findViewById(R.id.myRadioButton); // Find the RadioButton by its ID
        myButton = findViewById(R.id.myButton); // Ensure this matches your XML layout ID
        imageView = findViewById(R.id.imageView2); // Find the ImageView by its ID

        // Set a listener on the CheckBox to respond to changes
        myCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView.setText("Checkbox is checked");
                } else {
                    textView.setText("Checkbox is unchecked");
                }
            }
        });

        // Set a listener on the Switch to respond to changes
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView.setText("Switch is ON");
                } else {
                    textView.setText("Switch is OFF");
                }
            }
        });

        // Set a listener on the RadioButton to respond to changes
        myRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView.setText("RadioButton is selected");
                }
            }
        });

        // Set an OnClickListener for the Button to change the TextView text
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Give new text here");
            }
        });
    }
}