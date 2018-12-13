package com.example.hamzajbr.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, InputActivity.class);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_simple:
                if (checked)
                    intent.putExtra("story", ((RadioButton) view).getText().toString());
                break;
            case R.id.radio_tarzan:
                if (checked)
                    intent.putExtra("story", ((RadioButton) view).getText().toString());
                break;
            case R.id.radio_university:
                if (checked)
                    intent.putExtra("story", ((RadioButton) view).getText().toString());
                break;
            case R.id.radio_clothes:
                if (checked)
                    intent.putExtra("story", ((RadioButton) view).getText().toString());
                break;
            case R.id.radio_dance:
                if (checked)
                    intent.putExtra("story", ((RadioButton) view).getText().toString());
                break;
        }
    }

    public void load(View v) {
        startActivity(intent);
    }
}

