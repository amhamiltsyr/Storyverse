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



public class MainActivity extends AppCompatActivity {
    private int yearGoalBooks;
    private int yearProgressBooks;
    private int yearProgressMovies;
    private int yearProgressTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView yearGoalTracker=findViewById(R.id.yearGoalTracker);
        String toSet="Yearly Goal:\nBooks:\nMovies:\nTV:\n";
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
