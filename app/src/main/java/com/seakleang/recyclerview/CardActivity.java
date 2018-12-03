package com.seakleang.recyclerview;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.seakleang.recyclerview.adapter.PostAdapter;
import com.seakleang.recyclerview.entity.Post;

import java.util.ArrayList;
import java.util.List;

public class CardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private List<Post> postList = new ArrayList<>();
    private static int REQUEST_CODE_POST;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.post:
                Intent intent = new Intent(this,PostActivity.class);
                startActivityForResult(intent,REQUEST_CODE_POST);
                return true;
             default:   return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==REQUEST_CODE_POST && resultCode==RESULT_OK){
            //get data
            Post post = data.getParcelableExtra("data");
            //add new Item to recyclerView
            postList.add(0,post);
            adapter.notifyItemInserted(0);
            setRecyclerViewScroll(0);
        }
    }

    private void setRecyclerViewScroll(int positiion){
        recyclerView.smoothScrollToPosition(positiion);
    }
}
