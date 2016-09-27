package com.shilu.recyclerviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] movieNames = new String[]{"Dead Poet Society", "Pets Life", "Me Before You", "Batman Rises","Deadpool",
            "Dead Poet Society", "Pets Life", "Me Before You", "Batman Rises","Deadpool",
            "Dead Poet Society", "Pets Life", "Me Before You", "Batman Rises","Deadpool",
            "Dead Poet Society", "Pets Life", "Me Before You", "Batman Rises","Deadpool",
            "Dead Poet Society", "Pets Life", "Me Before You", "Batman Rises","Deadpool"};

    /**
     * very low images are used to avoid OutOfMemoryError
     */
    int[] movieIcons = new int[]{R.drawable.dead_poet_society, R.drawable.pets_life, R.drawable.me_before_you, R.drawable.batman_rises,R.drawable.deadpool,
            R.drawable.dead_poet_society, R.drawable.pets_life, R.drawable.me_before_you, R.drawable.batman_rises,R.drawable.deadpool,
            R.drawable.dead_poet_society, R.drawable.pets_life, R.drawable.me_before_you, R.drawable.batman_rises,R.drawable.deadpool,
            R.drawable.dead_poet_society, R.drawable.pets_life, R.drawable.me_before_you, R.drawable.batman_rises,R.drawable.deadpool,
            R.drawable.dead_poet_society, R.drawable.pets_life, R.drawable.me_before_you, R.drawable.batman_rises,R.drawable.deadpool};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv_movies);

        /**
         * A LayoutManager is responsible for measuring and positioning item views within a RecyclerView
         * as well as determining the policy for when to recycle item views that are no longer visible to the user.
         */
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new MoviesRvAdapter(this, movieNames, movieIcons));
    }
}
