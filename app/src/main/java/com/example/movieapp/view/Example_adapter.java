package com.example.movieapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movieapp.R;
import com.example.movieapp.appclass.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Example_adapter extends RecyclerView.Adapter<Example_adapter.example_viewholder> {


    private List<Result> resultList;
    private Context mContext;
    private recyclerview_lisiner mRecyclerview_lisiner;

    public Example_adapter(List<Result> resultList, Context mContext) {
        this.resultList = resultList;
        this.mContext = mContext;
    }

    public void setonitemclicklisinear(recyclerview_lisiner mRecyclerview_lisiner) {
        this.mRecyclerview_lisiner = mRecyclerview_lisiner;
    }

    public static class example_viewholder extends RecyclerView.ViewHolder {
        TextView title;
        TextView date;
        ImageView image;

        public example_viewholder(@NonNull View itemView, final recyclerview_lisiner recyclerview_lisinerx) {
            super(itemView);
            title = itemView.findViewById(R.id.examplecardview_titletxt);
            date = itemView.findViewById(R.id.examplecardview_release_datetxt);
            image = itemView.findViewById(R.id.examplecardview_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerview_lisinerx != null) {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION) {
                            recyclerview_lisinerx.onclick_recyclerview(getAdapterPosition());
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public example_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.examplecardview, parent, false);
        return new example_viewholder(v, mRecyclerview_lisiner);
    }

    @Override
    public void onBindViewHolder(@NonNull example_viewholder holder, int position) {
        Result current_result = resultList.get(position);
        holder.title.setText(current_result.getTitle());
        holder.date.setText(current_result.getReleaseDate());
        String url = "http://image.tmdb.org/t/p/w185/";
        String Url = url + current_result.getPosterPath();
        Picasso.with(mContext).load(Url).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public interface recyclerview_lisiner {
        void onclick_recyclerview(int position);
    }
}
