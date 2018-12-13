package com.example.hamzajbr.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputActivity extends AppCompatActivity {
    String story_name;
    int words;
    String y="not initialized";
    int i =0;
    String [] inputHint;
    TextView wordsNo, test;
    EditText input;
    TextView hint;
    Intent intent;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        wordsNo = (TextView) findViewById(R.id.wordNo);
        input = (EditText) findViewById(R.id.input_ET);
        hint = (TextView) findViewById(R.id.hint);
        ok = (Button) findViewById(R.id.ok_btn);
        test =(TextView) findViewById(R.id.temp);

        story_name = getIntent().getStringExtra("story");



        switch(story_name) {
            case "Simple":
                words = 2;
                inputHint= new String[]{"job", "adjective"};
                break;
            case "Tarzan":
                words = 6;
                inputHint= new String[]{"adjective", "plural noun", "place", "noun", "funny noise", "person's name"};
                break;
            case "University":
                words = 5;
                inputHint= new String[]{"adjective", "plural noun", "number", "noun", "job"};
                break;
            case "Clothes":
                words = 8;
                inputHint= new String[]{"male name", "adjective", "city", "unusual adjective", "plural noun", "color", "exciting adjective", "interesting adjective"};
                break;
            case "Dance":
                words = 6;
                inputHint= new String[]{"adverb", "number", "plural noun", "verb", "body part", "funny noise"};
                break;
        }

        intent = new Intent(InputActivity.this,StoryActivity.class);
        //initial value
        intent.putExtra("story",story_name);

        hint.setText("please type a/an "+inputHint[0]);

        wordsNo.setText(""+words+" word(s) left");

    }


    public void onOkClick(View view) {
        words--;
        if(words==0){
            putExtra(y);
            startActivity(intent);
        }else {
            y = input.getText().toString();
            Log.i("value", y);
            putExtra(y);
            hint.setText("please type a/an " + inputHint[i]);
            if (i == 0)
                hint.setText("please type a/an " + inputHint[1]);
        }
        test.setText(y);
        wordsNo.setText(""+words+" word(s) left");
        input.setText(" ");

    }
    protected void putExtra(String x){

        switch(story_name) {
            case "Simple":
                switch (i) {
                    case 0:
                        intent.putExtra("job",x);
                        i++;
                        break;
                    case 1:
                        intent.putExtra("adjective",x);
                        i++;
                        break;
                }
                break;
            case "Tarzan":
                switch (i) {
                    case 0:
                        intent.putExtra("adjective",x);
                        i++;
                        break;
                    case 1:
                        intent.putExtra("plural noun",x);
                        i++;
                        break;

                    case 2:
                        intent.putExtra("place",x);
                        i++;
                        break;
                    case 3:
                        intent.putExtra("noun",x);
                        i++;
                        break;
                    case 4:
                        intent.putExtra("funny noise",x);
                        i++;
                        break;
                    case 5:
                        intent.putExtra("person's name",x);
                        i++;
                        break;

                }
                break;
            case "University":
                switch (i) {
                    case 0:
                        intent.putExtra("adjective",x);
                        i++;
                        break;
                    case 1:
                        intent.putExtra("plural noun",x);
                        i++;
                        break;

                    case 2:
                        intent.putExtra("number",x);
                        i++;
                        break;
                    case 3:
                        intent.putExtra("noun",x);
                        i++;
                        break;
                    case 4:
                        intent.putExtra("job",x);
                        i++;
                        break;
                }
                break;
            case "Clothes":
                switch (i) {
                    case 0:
                        intent.putExtra("male name",x);
                        i++;
                        break;
                    case 1:
                        intent.putExtra("adjective",x);
                        i++;
                        break;

                    case 2:
                        intent.putExtra("city",x);
                        i++;
                        break;
                    case 3:
                        intent.putExtra("unusual adjective",x);
                        i++;
                        break;
                    case 4:
                        intent.putExtra("plural noun",x);
                        i++;
                        break;
                    case 5:
                        intent.putExtra("color",x);
                        i++;
                        break;
                    case 6:
                        intent.putExtra("exciting adjective",x);
                        i++;
                        break;
                    case 7:
                        intent.putExtra("interesting adjective",x);
                        i++;
                        break;
                }
                break;
            case "Dance":
                switch (i) {
                    case 0:
                        intent.putExtra("adverb",x);
                        i++;
                        break;
                    case 1:
                        intent.putExtra("number",x);
                        i++;
                        break;

                    case 2:
                        intent.putExtra("plural noun",x);
                        i++;
                        break;
                    case 3:
                        intent.putExtra("verb",x);
                        i++;
                        break;
                    case 4:
                        intent.putExtra("body part",x);
                        i++;
                        break;
                    case 5:
                        intent.putExtra("funny noise",x);
                        i++;
                        break;

                }
                break;
        }


    }



}
