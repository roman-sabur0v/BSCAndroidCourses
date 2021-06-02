package com.saburovroman.note;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements MVPContract.View {
    private final static String TAG = "note";
    private MVPContract.Presenter presenter;
    private EditText note;
    private EditText title;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        note = (EditText)this.findViewById(R.id.noteText);
        title = (EditText)this.findViewById(R.id.noteTitleText);
        button = this.findViewById(R.id.button);
        presenter = new Presenter(this, savedInstanceState);
        button.setOnClickListener(v -> {
            presenter.onButtonWasClicked(getApplicationContext());
        });
        showText(savedInstanceState);
        Log.d(TAG, "OnCreate()");
    }

    @Override
    public void showText(Bundle state) {
        presenter.setSavedText(title, Model.TITLE_TAG);
        presenter.setSavedText(note, Model.NOTE_TAG);
    }
}