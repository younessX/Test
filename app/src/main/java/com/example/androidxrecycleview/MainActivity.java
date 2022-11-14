package com.example.androidxrecycleview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidxrecycleview.adapters.PostsAdapter;
import com.example.androidxrecycleview.models.Film;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PostsAdapter.OnclickFilm,
        View.OnClickListener{
    RecyclerView recyclerView;
    PostsAdapter postsAdapter;
    ArrayList<Film> posts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();
        setSupportActionBar((Toolbar) findViewById(R.id.Cards_ToolBar));
        setTitle("Films");

        /**pour floating action bar*/
        findViewById(R.id.fab).setOnClickListener(this);

        recyclerView = findViewById(R.id.MyRecycle);
        posts = new ArrayList<>();

          posts.add(new Film("Avatar", "2019 film", R.drawable.avatar));
          posts.add(new Film("Avenger", "2018 film", R.drawable.avenger));
          posts.add(new Film("Batman", "2014 film", R.drawable.batman));
          posts.add(new Film("Hulk", "2012 film ", R.drawable.hulk));
          posts.add(new Film("Good Deeds", "2003 film", R.drawable.good_deeds));
          posts.add(new Film("Jumanji", "2016 film", R.drawable.jumanji));
          posts.add(new Film("Venom", "2020 film", R.drawable.venom));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        postsAdapter = new PostsAdapter(posts, this);
        recyclerView.setAdapter(postsAdapter);
    }

    @Override
    public void onclickFilm(int position) {
        Film post = posts.get(position);
        Intent intent = new Intent(this, NewActivity.class);

        /**second methode it's to implement Serializable*/

        /**first methode*/
        //intent.putExtra("Desc", post.getDecUser());
        //intent.putExtra("Image", post.getImgUser());
        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        /**third methode is to implement parcelable to the object you want to pas, from the
         * activity to another ,and
         * parcelable it's  a way to package objects */
        intent.putExtra("Object", post);
        startActivity(intent);

        /**final String TAG = "MyActivity";
        Log.d(TAG , "vous avez clicker sur " + position);*/
    }


    @Override
    public void onClick(View view) {
        /**Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);*/
    }
}