package com.seakleang.recyclerview;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.seakleang.recyclerview.adapter.PostAdapter;
import com.seakleang.recyclerview.entity.Post;

import java.util.ArrayList;
import java.util.List;

public class CardActivity extends AppCompatActivity implements PostAdapter.PostCallback {

    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private List<Post> postList = new ArrayList<>();
    private static int REQUEST_CODE_POST;
    private static int REQUEST_CODE_EDIT_POST;

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
        if (requestCode==REQUEST_CODE_EDIT_POST && requestCode==RESULT_OK){
            //Post post = data.getParcelableExtra("post");
            //postList.set(getIntent().getExtras().getInt("position"),post);
            //adapter.notifyDataSetChanged();
            Toast.makeText(this, "Edit", Toast.LENGTH_SHORT).show();
        }
    }

    private void setRecyclerViewScroll(int positiion){
        recyclerView.smoothScrollToPosition(positiion);
    }

    @Override
    public void removePost(Post post, int position) {
        postList.remove(post);
        adapter.notifyItemRemoved(position);
    }

    @Override
    public void editPost(Post post, int position) {
        Intent intent = new Intent(CardActivity.this, PostActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("post",post);
        bundle.putInt("position",position);
        intent.putExtras(bundle);
        startActivityForResult(intent,REQUEST_CODE_EDIT_POST);

    }
}
