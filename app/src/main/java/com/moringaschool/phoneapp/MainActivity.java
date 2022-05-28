package com.moringaschool.phoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

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

    boolean isAllFieldsChecked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                DialogFragment dialogFragment = new DialogFragment();
                dialogFragment.show(fm, "Sample Fragment");

                String name = mtextInputEditText.getText().toString();

                //validating the user input
                isAllFieldsChecked = CheckAllFields();
                if (isAllFieldsChecked) {
                    Intent intent = new Intent(MainActivity.this, Products.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }

//                Intent intent = new Intent(MainActivity.this, Products.class);
//                intent.putExtra("name", name);
//                startActivity(intent);
            }
        });
    }

    private boolean CheckAllFields() {
        if (mtextInputEditText.length() == 0) {
            mtextInputEditText.setError("This field is required");
            return false;
        }
        return true;
    }


}
