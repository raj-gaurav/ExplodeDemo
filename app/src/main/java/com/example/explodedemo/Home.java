package com.example.explodedemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    ImageView about,contact,project,suggestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        about=findViewById(R.id.imageView3);
        project=findViewById(R.id.imageView4);
        contact=findViewById(R.id.imageView5);
        suggestion=findViewById(R.id.imageView6);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"About",Toast.LENGTH_SHORT).show();
            }
        });

       contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Contact",Toast.LENGTH_SHORT).show();
            }
        });

        project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Projects.class);

                Pair[] pairs=new Pair[4];
                pairs[0]=new Pair<View, String>(about,"about");
                pairs[1]=new Pair<View, String>(contact,"contact");
                pairs[2]=new Pair<View, String>(project,"projects");
                pairs[3]=new Pair<View, String>(suggestion,"suggestion");

                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(Home.this,pairs);
                startActivity(i,options.toBundle());
            }
        });

        suggestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Suggestion",Toast.LENGTH_SHORT).show();
            }
        });


        Explode enterTransition=new Explode();
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        getWindow().setEnterTransition(enterTransition);

        getWindow().setAllowEnterTransitionOverlap(false);

    }
}
