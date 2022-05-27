package com.moringaschool.phoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.submitButton)
    Button mButton;
    @BindView(R.id.textInputEditText)
    EditText mtextInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mtextInputEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, Products.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });



    }
}