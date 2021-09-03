package com.example.architectureexamplewithroom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {
    public static final String EXTRA_TITLE =
            "com.example.architectureexamplewithroom.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION =
            "com.example.architectureexamplewithroom.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY =
            "com.example.architectureexamplewithroom.EXTRA_PRIORITY";

    private EditText et_title, et_description;
    private NumberPicker np_priority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        et_title = findViewById(R.id.et_title);
        et_description = findViewById(R.id.et_description);
        np_priority = findViewById(R.id.np_priority);

        np_priority.setMinValue(1);
        np_priority.setMaxValue(5);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");
    }

    private void saveNote() {
        String title = et_title.getText().toString();
        String description = et_description.getText().toString();
        int priority = np_priority.getValue();

        if (title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_PRIORITY, priority);

        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}