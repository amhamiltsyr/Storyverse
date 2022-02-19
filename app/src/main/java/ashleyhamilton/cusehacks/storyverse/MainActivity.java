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
    private int yearGoalBooks;
    private int yearProgressBooks;
    private int yearProgressMovies;
    private int yearProgressTV;
    private int yearGoalMovies;
    private int yearGoalTV;
    private String[][] total;
    private int currentIndexTotal;
    private String[][] favorite;
    private int currentIndexFavorite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null){
            yearGoalBooks=0;
            yearProgressBooks=0;
            yearProgressMovies=0;
            yearProgressTV=0;
            yearGoalMovies=0;
            yearGoalTV=0;
            favorite= new String[100][3];
            total=new String[100][3];
        }
        Intent intent = getIntent();
        if(intent.getExtras()!=null){
            System.out.println("happening");
            if(intent.getStringExtra("favor_key").equals("1")) {
                // is a favorite
                favorite[currentIndexFavorite][0] = intent.getStringExtra("saveName_key");
                favorite[currentIndexFavorite][1] = intent.getStringExtra("content_key");
                currentIndexFavorite++;
                total[currentIndexTotal][0] = intent.getStringExtra("saveName_key");
                total[currentIndexTotal][1] = intent.getStringExtra("content_key");
                currentIndexTotal++;
            }
            else if(intent.getStringExtra("favor_key").equals("")){
                //not a favorite
                total[currentIndexTotal][0]=intent.getStringExtra("saveName_key");
                total[currentIndexTotal][1]=intent.getStringExtra("content_key");
                currentIndexTotal++;
            }
            if(intent.getStringExtra("content_key").equals("Book")){
                yearProgressBooks++;
            }
            else if(intent.getStringExtra("content_key").equals("Movie")){
                yearProgressMovies++;
            }
            if(intent.getStringExtra("content_key").equals("TV")){
                yearProgressTV++;
            }
        }
        setContentView(R.layout.activity_main);
        TextView yearGoalTracker=findViewById(R.id.yearGoalTracker);
        String toSet="Yearly Goal:\nBooks: "+yearProgressBooks+"/"+yearGoalBooks+"\nMovies: "+yearProgressMovies+"/"+yearGoalMovies+"\nTV: "+yearProgressTV+"/"+yearGoalTV+"\n";
        yearGoalTracker.setText(toSet);
        Button add=findViewById(R.id.add);
        ImageButton favorites=findViewById(R.id.favorites);
        ImageButton year=findViewById(R.id.year);
        ImageButton account=findViewById(R.id.account);
        Button setYearGoal=findViewById(R.id.setYearGoal);
        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.add) {
                    Intent intent = new Intent(MainActivity.this, AddActivity.class);
                    startActivity(intent);
                } else if (v.getId() == R.id.setYearGoal) {
                    Intent intent = new Intent(MainActivity.this, setYearGoalActivity.class);
                    startActivity(intent);
                } else if (v.getId() == R.id.favorites) {
                    Intent intent = new Intent(MainActivity.this, favoritesActivity.class);
                    startActivity(intent);
                } else if (v.getId() == R.id.year) {
                    Intent intent = new Intent(MainActivity.this, yearActivity.class);
                    startActivity(intent);
                }
                else if(v.getId()==R.id.account){
                    Intent intent = new Intent(MainActivity.this, accountActivity.class);
                    startActivity(intent);
                }
            }
        };
        add.setOnClickListener(myListener);
        setYearGoal.setOnClickListener(myListener);
        favorites.setOnClickListener(myListener);
        year.setOnClickListener(myListener);
        account.setOnClickListener(myListener);


    }
}
