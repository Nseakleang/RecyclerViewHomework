package com.seakleang.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.seakleang.recyclerview.entity.Post;

public class PostActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPost,btnSave;
    private EditText textPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        btnPost = findViewById(R.id.btnPost);
        textPost = findViewById(R.id.textPost);
        btnSave = findViewById(R.id.btnSave);

        btnPost.setOnClickListener(this);
        btnSave.setOnClickListener(this);

        Post post = new Post();
        post = getIntent().getParcelableExtra("post");
        textPost.setText(post.getContent());
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnPost){
            Post post = new Post(R.drawable.profile,
                    "___Seakleang___",
                    "PP",
                    textPost.getText().toString(),
                    "0",
                    R.drawable.ros);
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putParcelable("data",post);
            intent.putExtras(bundle);
            setResult(RESULT_OK,intent);
            finish();
        }
        if (v.getId()==R.id.btnSave){
            Post post = new Post();
            post = getIntent().getParcelableExtra("post");
            post.setContent(textPost.getText().toString());
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putParcelable("post",post);
            bundle.putInt("position",getIntent().getExtras().getInt("position"));
            intent.putExtras(bundle);
            setResult(RESULT_OK,intent);
            finish();
        }
    }


}
