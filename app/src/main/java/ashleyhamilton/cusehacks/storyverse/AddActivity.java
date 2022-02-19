package ashleyhamilton.cusehacks.storyverse;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AddActivity extends AppCompatActivity{
    boolean favoriteStatus = false;
    String content = "Book";
    String favor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_layout);
        ImageButton favorite = findViewById(R.id.favoriteSelect);
        favorite.setImageResource(R.drawable.ic_baseline_star_outline_24);
        EditText name=findViewById(R.id.name);
        RadioGroup type=findViewById(R.id.type);
        RadioButton radioBook = findViewById(R.id.radioBook);
        RadioButton radioMovie = findViewById(R.id.radioMovie);
        RadioButton radioTV = findViewById(R.id.radioTV);
        Button add = findViewById(R.id.add);
        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.favoriteSelect){
                    if(favoriteStatus){
                        favoriteStatus=false;
                        favorite.setImageResource(R.drawable.ic_baseline_star_outline_24);
                    }
                    else{
                        favoriteStatus=true;
                        favorite.setImageResource(R.drawable.ic_baseline_star_24);
                    }
                }
                else if(view.getId() == R.id.add){
                    String saveName = name.getText().toString();
                    if(radioBook.isChecked()){
                        content="Book";
                    }
                    else if(radioMovie.isChecked()){
                        content="Movie";
                    }
                    else if(radioTV.isChecked()){
                        content="TV";
                    }
                    System.out.println(saveName);
                    System.out.println(content);
                    System.out.println(favoriteStatus);
                    Intent intent = new Intent(AddActivity.this, MainActivity.class);
                    intent.putExtra("saveName_key", saveName);
                    intent.putExtra("content_key", content);
                    if(favoriteStatus){
                        favor="1";  //is a favorite
                    }
                    else{
                        favor="";
                    }
                    intent.putExtra("favor_key", favor);
                    startActivity(intent);
                }
            }
        };
        favorite.setOnClickListener(myListener);
        add.setOnClickListener(myListener);
        type.setOnClickListener(myListener);
    }

}
