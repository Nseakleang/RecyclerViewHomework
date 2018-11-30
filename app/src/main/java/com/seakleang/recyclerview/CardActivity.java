package com.seakleang.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.seakleang.recyclerview.adapter.PostAdapter;
import com.seakleang.recyclerview.entity.Post;

import java.util.ArrayList;
import java.util.List;

public class CardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private List<Post> postList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PostAdapter(this, postList);

        recyclerView.setAdapter(adapter);

        getData();
    }

    private void getData(){
        for (int i=0;i<50;i++){
            this.postList.add(new Post(
                    R.drawable.profile,
                    "___Seakleang___",
                    "Cambodia",
                    "Hello all friends",
                    "1,000k",
                    R.drawable.ros
            ));
        }
        adapter.setPosts(postList);
    }
}
