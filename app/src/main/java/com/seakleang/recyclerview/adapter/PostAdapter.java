package com.seakleang.recyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.seakleang.recyclerview.MainActivity;
import com.seakleang.recyclerview.R;
import com.seakleang.recyclerview.entity.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    List<Post> posts;
    Context context;

    public PostAdapter(Context context, List<Post> posts){
        this.context = context;
        this.posts = posts;
    }

    public void setPosts(List<Post> posts){
        this.posts.addAll(posts);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(
                R.layout.activity_card, viewGroup, false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Post post = posts.get(i);
        viewHolder.post.setImageResource(post.getImage());
        viewHolder.profile.setImageResource(post.getUserProfile());
        viewHolder.textProfile.setText(post.getUserName());
        viewHolder.textCheckIn.setText(post.getCheckI());
        viewHolder.textLike.setText(post.getLikeCount());
        viewHolder.textStatus.setText(post.getContent());
    }


    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView profile, post, favorite, comment, share, bookmark;
        TextView textProfile, textCheckIn, textLike, textStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.profile);
            post = itemView.findViewById(R.id.imagePost);
            favorite = itemView.findViewById(R.id.favorite);
            comment = itemView.findViewById(R.id.comment);
            share = itemView.findViewById(R.id.share);
            bookmark = itemView.findViewById(R.id.bookMark);
            textProfile = itemView.findViewById(R.id.textProfile);
            textCheckIn = itemView.findViewById(R.id.textCheckIn);
            textLike =itemView.findViewById(R.id.textLike);
            textStatus = itemView.findViewById(R.id.textStatus);
        }

        private void onPostClicked(){
            post.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, MainActivity.class));
                }
            });
        }
    }
}
