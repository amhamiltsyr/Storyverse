package ashleyhamilton.cusehacks.storyverse;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class setYearGoalActivity extends AppCompatActivity{
    int bookGoal;
    int movieGoal;
    int tvGoal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setyeargoal_layout);
        NumberPicker numberPickerBook = findViewById(R.id.bookGoal);
        if(numberPickerBook != null){
            numberPickerBook.setMinValue(0);
            numberPickerBook.setMaxValue(500);
            numberPickerBook.setWrapSelectorWheel(true);
            numberPickerBook.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                    bookGoal=i1;
                }
            });
        }
        NumberPicker numberPickerMovie = findViewById(R.id.movieGoal);
        if(numberPickerMovie != null){
            numberPickerMovie.setMinValue(0);
            numberPickerMovie.setMaxValue(500);
            numberPickerMovie.setWrapSelectorWheel(true);
            numberPickerMovie.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                    movieGoal=i1;
                }
            });
        }
        NumberPicker numberPickerTV = findViewById(R.id.tvGoal);
        if(numberPickerTV != null){
            numberPickerTV.setMinValue(0);
            numberPickerTV.setMaxValue(500);
            numberPickerTV.setWrapSelectorWheel(true);
            numberPickerTV.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                    tvGoal=i1;
                }
            });
        }
        Button enter =findViewById(R.id.enter);
        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()== R.id.enter){
                    System.out.println(bookGoal);
                    System.out.println(movieGoal);
                    System.out.println(tvGoal);
                    Intent intent = new Intent(setYearGoalActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        enter.setOnClickListener(myListener);
    }
}
