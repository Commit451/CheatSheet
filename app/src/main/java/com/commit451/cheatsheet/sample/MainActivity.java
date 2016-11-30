package com.commit451.cheatsheet.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.commit451.cheatsheet.CheatSheet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View fab = findViewById(R.id.fab);
        CheatSheet.setFactory(new CheatSheet.Factory() {
            @NonNull
            @Override
            public Toast createToast(@NonNull View view, @NonNull CharSequence text) {
                //do other custom things
                return Toast.makeText(view.getContext(), text, Toast.LENGTH_LONG);
            }
        });
        CheatSheet.setup(fab, "This is how you favorite");
    }
}
