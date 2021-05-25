package com.saburovroman.note;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class Presenter implements MVPContract.Presenter {
    private final static String TAG = "Presenter";

    private MVPContract.View view;
    private MVPContract.Model model;
    private String noteText;
    private String noteTitleText;
    private Bundle state;

    public Presenter(MVPContract.View view, Bundle state) {
        this.view = view;
        if (state == null) state = new Bundle();
        this.state = state;
        model = new Model();
        Log.d(TAG, "Constructor");
    }

    @Override
    public void onButtonWasClicked(Context context) {
        Model mModel = (Model)model;
        Toast toast;
        MainActivity mView = (MainActivity)view;
        EditText note = (EditText)mView.findViewById(R.id.noteText);
        noteText = note.getText().toString();
        EditText title = (EditText)mView.findViewById(R.id.noteTitleText);
        noteTitleText = title.getText().toString();
        boolean isNoteWasChange = mModel.setText(noteTitleText, noteText, state);
        if (isNoteWasChange)
            toast = Toast.makeText(context, "Note was saved",  Toast.LENGTH_SHORT);
        else toast = Toast.makeText(context, "Note doesn't was change",  Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void setSavedText(EditText editText, String tag) {
        editText.setText(model.getSavedTextOrNull(state, tag));
    }
}
