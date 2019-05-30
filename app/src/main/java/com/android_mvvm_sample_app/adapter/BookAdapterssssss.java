package com.android_mvvm_sample_app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android_mvvm_sample_app.R;
import com.android_mvvm_sample_app.model.BookResponseModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaushik on 25-Aug-18.
 */


public class BookAdapterssssss extends RecyclerView.Adapter<BookAdapterssssss.RecyclerViewHolder> {

    private List<BookResponseModel.ItemsBean> bookLists;
    private Context mContext;
    private View.OnClickListener clickListener;
    private int drawable;

    public BookAdapterssssss(Context context, View.OnClickListener mListener, int drawable) {
        this.mContext = context;
        this.clickListener = mListener;
        this.drawable = drawable;

        bookLists = new ArrayList<>();
    }

    @Override
    public BookAdapterssssss.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(drawable, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapterssssss.RecyclerViewHolder holder, int position) {

        BookResponseModel.ItemsBean books = bookLists.get(position);

        holder.releaseDate.setText(books.getVolumeInfo().getPublishedDate());
        holder.bookTitle.setText(books.getVolumeInfo().getTitle());
        holder.publisherName.setText(books.getVolumeInfo().getPublisher());
        Glide.with(mContext)
                .load(books.getVolumeInfo().getImageLinks().getThumbnail())
                .into(holder.bookImage);

        holder.itemView.setTag(books);
        holder.itemView.setOnClickListener(clickListener);

    }

    @Override
    public int getItemCount() {
        return (bookLists != null ? bookLists.size() : 0);
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView releaseDate;
        private TextView bookTitle;
        private TextView publisherName;
        private ImageView bookImage;


        public RecyclerViewHolder(View itemView) {
            super(itemView);

            releaseDate = itemView.findViewById(R.id.publish_date);
            bookTitle = itemView.findViewById(R.id.book_title);
            publisherName = itemView.findViewById(R.id.publisher_name);
            bookImage = itemView.findViewById(R.id.book_picture);

        }

    }

    public void addAll(List<BookResponseModel.ItemsBean> list) {

        for (int i = 0; i < list.size(); i++) {

            bookLists.add(list.get(i));
            notifyDataSetChanged();
        }

    }
}
