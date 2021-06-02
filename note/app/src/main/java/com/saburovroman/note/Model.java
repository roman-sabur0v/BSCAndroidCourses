package com.saburovroman.note;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

public class Model implements MVPContract.Model {
    protected final static String NOTE_TAG = "Note";
    protected final static String TITLE_TAG = "Title";

    public boolean setText(@Nullable String noteTitleValue, @Nullable String noteValue, Bundle state) {
        Log.d(NOTE_TAG, "setText()");
        String note = getSavedTextOrNull(state, NOTE_TAG);
        String title = getSavedTextOrNull(state, TITLE_TAG);
        //обрабатываем null значения как пустые строки
        if (noteValue == null) noteValue = "";
        if (noteTitleValue == null) noteTitleValue = "";
        if (note == null) note = "";
        if (title == null) title = "";
        
        if (!note.equals(noteValue)) {
            state.putString(NOTE_TAG, noteValue);
            return true;
        }
        if (!title.equals(noteTitleValue)) {
            state.putString(TITLE_TAG, noteTitleValue);
            return true;
        }
        return false;
    }

    @Nullable
    @Override
    public String getSavedTextOrNull(Bundle state, String tag) {
        Log.d(tag, "getSavedTextOrNull()");
        if (state.containsKey(tag))
            return state.getString(tag);
        else return null;
    }
}
