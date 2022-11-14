package com.example.androidxrecycleview;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.androidxrecycleview.models.Film;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        TextView textHello = findViewById(R.id.hello);
        ImageView NewImage = findViewById(R.id.NewImage);

        if(getIntent().hasExtra("Object")){
            Film post = getIntent().getParcelableExtra("Object");
            textHello.setText(post.getNameUser());
            NewImage.setImageResource(post.getImgUser());

            /**add back Arrow (<--) in a toolbar*/
            Toolbar toolbar = findViewById(R.id.NewToolBar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(post.getNameUser());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }



        /**first methode*/
        /*********************************************************/
        //NewImage.setImageResource(getIntent().getIntExtra("Image", 0));
        //textHello.setText(getIntent().getStringExtra("Name"));

        /**second methode*/
        /****************************************/


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}