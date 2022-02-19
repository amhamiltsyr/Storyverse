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
        ImageButton year=findViewById(R.id.favorites);
        ImageButton account=findViewById(R.id.account);





    }
}
