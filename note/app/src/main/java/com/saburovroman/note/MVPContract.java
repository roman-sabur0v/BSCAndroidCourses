package com.saburovroman.note;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;

public interface MVPContract {
    interface View {
        void showText(Bundle state);
    }

    interface Model {
        @Nullable
        String getSavedTextOrNull(Bundle state, String tag);
    }

    interface Presenter {
        void onButtonWasClicked(Context context);
        void setSavedText(EditText editText, String tag);
    }
}
