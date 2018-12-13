package com.example.hamzajbr.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Scanner;

public class StoryActivity extends AppCompatActivity {
    String  x,story_name="1",story=" ",
            job="3",adjective="4",place="5",plural_noun="6",noun="7",funny_noise="8",
            number="9",city="10",color="11",unusual_adjective="12",exciting_adjective="13",
            male_name="14",interesting_adjective="15",adverb="16",verb="17",body_part="18",persons_name="19";
    Scanner scanner;
    TextView storyTextView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);


        storyTextView = (TextView) findViewById(R.id.story_txt);
        story_name = getIntent().getStringExtra("story");



        switch(story_name) {
            case "Simple":
                scanner = new Scanner(getResources().openRawResource(R.raw.madlib0_simple));

                adjective = getIntent().getStringExtra("adjective");
                job = getIntent().getStringExtra("job");
                break;
            case "Tarzan":
                scanner = new Scanner(getResources().openRawResource(R.raw.madlib1_tarzan));

                adjective = getIntent().getStringExtra("adjective");
                place = getIntent().getStringExtra("place");
                noun = getIntent().getStringExtra("noun");
                plural_noun = getIntent().getStringExtra("plural noun");
                persons_name = getIntent().getStringExtra("person's name");
                funny_noise = getIntent().getStringExtra("funny noise");
                break;
            case "University":
                scanner = new Scanner(getResources().openRawResource(R.raw.madlib2_university));

                adjective = getIntent().getStringExtra("adjective");
                job = getIntent().getStringExtra("job");
                noun = getIntent().getStringExtra("noun");
                number = getIntent().getStringExtra("number");
                plural_noun = getIntent().getStringExtra("plural noun");

                break;
            case "Clothes":
                scanner = new Scanner(getResources().openRawResource(R.raw.madlib3_clothes));

                adjective = getIntent().getStringExtra("adjective");
                city = getIntent().getStringExtra("city");
                color = getIntent().getStringExtra("color");
                unusual_adjective = getIntent().getStringExtra("unusual adjective");
                exciting_adjective = getIntent().getStringExtra("exciting adjective");
                male_name = getIntent().getStringExtra("male name");
                plural_noun = getIntent().getStringExtra("plural noun");
                interesting_adjective = getIntent().getStringExtra("interesting adjective");
                break;
            case "Dance":
                scanner = new Scanner(getResources().openRawResource(R.raw.madlib4_dance));

                body_part = getIntent().getStringExtra("body part");
                adverb = getIntent().getStringExtra("adverb");
                verb = getIntent().getStringExtra("verb");
                funny_noise = getIntent().getStringExtra("funny noise");
                plural_noun = getIntent().getStringExtra("plural noun");
                break;
        }
        while(scanner.hasNext()){
            x=scanner.nextLine();
            story+=x+"\n";
        }

            switch (story_name) {
                case "Simple":
                    story=story.replaceAll("<job>", job);
                    story=story.replaceAll("<adjective>", adjective);
                    break;
                case "Tarzan":
                    story=story.replaceAll("<adjective>", adjective);
                    story=story.replaceAll("<plural-noun>", plural_noun);
                    story=story.replaceAll("<noun>", noun);
                    story=story.replaceAll("<person's-name>", persons_name);
                    story=story.replaceAll("<funny-noise>", funny_noise);
                    story=story.replaceAll("<place>", place);

                    break;
                case "University":
                    story=story.replaceAll("<job>", job);
                    story=story.replaceAll("<plural-noun>", plural_noun);
                    story=story.replaceAll("<number>", number);
                    story=story.replaceAll("<adjective>", adjective);
                    story=story.replaceAll("<noun>", noun);

                    break;
                case "Clothes":
                    story=story.replaceAll("<male-name>", male_name);
                    story=story.replaceAll("<adjective>", adjective);
                    story=story.replaceAll("<city>", city);
                    story=story.replaceAll("<unusual-adjective>", unusual_adjective);
                    story=story.replaceAll("<plural-noun>", plural_noun);
                    story=story.replaceAll("<color>", color);
                    story=story.replaceAll("<exciting-adjective>", exciting_adjective);
                    story=story.replaceAll("<interesting-adjective>", interesting_adjective);

                    break;
                case "Dance":
                    story=story.replaceAll("<adverb>", adverb);
                    story=story.replaceAll("<number>", number);
                    story=story.replaceAll("<plural-noun>", plural_noun);
                    story=story.replaceAll("<verb>", verb);
                    story=story.replaceAll("<body-part>", body_part);
                    story=story.replaceAll("<funny-noise>", funny_noise);

                    break;
            }

        storyTextView.setText(story);



    }

    public void newStory(View view) {
        intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
