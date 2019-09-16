package com.example.explodedemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    Button btn_start;
    CircleImageView circleImageView;
    TextView name,tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start=findViewById(R.id.btn_start);
        circleImageView=findViewById(R.id.image);
        name=findViewById(R.id.name);
        tag=findViewById(R.id.tag);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Home.class);

              /*  Pair[] pairs=new Pair[3];
                pairs[0]=new Pair<View, String>(circleImageView,"imgTransition");
                pairs[1]=new Pair<View, String>(name,"nameTransition");
                pairs[2]=new Pair<View, String>(tag,"tagTransition");*/

                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);


                startActivity(i,options.toBundle());
            }
        });

        Fade transition=new Fade();
        transition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
        getWindow().setEnterTransition(transition);

        getWindow().setReenterTransition(transition);

        getWindow().setExitTransition(transition);

        getWindow().setAllowReturnTransitionOverlap(false);

    }
}
