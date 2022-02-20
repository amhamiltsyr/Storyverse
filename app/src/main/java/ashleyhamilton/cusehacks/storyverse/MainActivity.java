package ashleyhamilton.cusehacks.storyverse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;


public class MainActivity extends AppCompatActivity {
    private String yearGoalBooks;
    private int yearProgressBooks;
    private int yearProgressMovies;
    private int yearProgressTV;
    private String yearGoalMovies;
    private String yearGoalTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null){
            yearGoalBooks="0";
            yearProgressBooks=0;
            yearProgressMovies=0;
            yearProgressTV=0;
            yearGoalMovies="0";
            yearGoalTV="0";
        }
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras!=null){
            if(extras.containsKey("yearGoalBooks_key")){
                yearGoalBooks=intent.getStringExtra("yearGoalBooks_key");
            }
            if(extras.containsKey("yearGoalTV_key")){
                yearGoalTV=intent.getStringExtra("yearGoalTV_key");
            }
            if(extras.containsKey("yearGoalMovies_key")){
                yearGoalMovies=intent.getStringExtra("yearGoalMovies_key");
            }
            if(extras.containsKey("yearProgressBooks_key")){
                yearProgressBooks=Integer.parseInt(intent.getStringExtra("yearProgressBooks_key"));
            }
            if(extras.containsKey("yearProgressTV_key")){
                yearProgressTV=Integer.parseInt(intent.getStringExtra("yearProgressTV_key"));
            }
            if(extras.containsKey("yearProgressMovies_key")){
                yearProgressMovies=Integer.parseInt(intent.getStringExtra("yearProgressMovies_key"));
            }
            System.out.println("happening");
            if(extras.containsKey("content_key")) {
                if (intent.getStringExtra("content_key").equals("Book")) {
                    yearProgressBooks++;
                } else if (intent.getStringExtra("content_key").equals("Movie")) {
                    yearProgressMovies++;
                } else if (intent.getStringExtra("content_key").equals("TV")) {
                    yearProgressTV++;
                }
            }
            if(extras.containsKey("bookGoal_key")){
                yearGoalBooks=intent.getStringExtra("bookGoal_key");
            }
            if(extras.containsKey("movieGoal_key")){
                yearGoalMovies=intent.getStringExtra("movieGoal_key");
            }
            if(extras.containsKey("tvGoal_key")){
                yearGoalTV=intent.getStringExtra("tvGoal_key");
            }
        }
        setContentView(R.layout.activity_main);
        TextView yearGoalTracker=findViewById(R.id.yearGoalTracker);
        String toSet="Yearly Goal:\nBooks: "+yearProgressBooks+"/"+yearGoalBooks+"\nMovies: "+yearProgressMovies+"/"+yearGoalMovies+"\nTV: "+yearProgressTV+"/"+yearGoalTV+"\n";
        yearGoalTracker.setText(toSet);
        Button add=findViewById(R.id.add);
        Button setYearGoal=findViewById(R.id.setYearGoal);
        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.add) {
                    Intent intent = new Intent(MainActivity.this, AddActivity.class);
                    intent.putExtra("yearGoalBooks_key", yearGoalBooks);
                    intent.putExtra("yearGoalMovies_key", yearGoalMovies);
                    intent.putExtra("yearGoalTV_key", yearGoalTV);
                    intent.putExtra("yearProgressBooks_key", yearProgressBooks);
                    intent.putExtra("yearProgressBooks_key", yearProgressMovies);
                    intent.putExtra("yearProgressBooks_key", yearProgressTV);
                    startActivity(intent);
                } else if (v.getId() == R.id.setYearGoal) {
                    Intent intent = new Intent(MainActivity.this, setYearGoalActivity.class);
                    intent.putExtra("yearGoalBooks_key", yearGoalBooks);
                    intent.putExtra("yearGoalMovies_key", yearGoalMovies);
                    intent.putExtra("yearGoalTV_key", yearGoalTV);
                    intent.putExtra("yearProgressBooks_key", yearProgressBooks);
                    intent.putExtra("yearProgressBooks_key", yearProgressMovies);
                    intent.putExtra("yearProgressBooks_key", yearProgressTV);
                    startActivity(intent);
                }
            }
        };
        add.setOnClickListener(myListener);
        setYearGoal.setOnClickListener(myListener);
    }
}
