package com.airo.photoemptystateapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CatesAdapter extends RecyclerView.Adapter<CatesAdapter.CatesViewHolder> {

    Context context;
    List<Cates> catesList;

    public CatesAdapter(Context context, List<Cates> catesList) {
        this.context = context;
        this.catesList = catesList;
    }

    @NonNull
    @Override
    public CatesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_menu, null);
        return new CatesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatesViewHolder holder, int position) {
        Cates cates = catesList.get(position);
        holder.iconTitle.setText(cates.getIconTitle());
        holder.iconImg.setImageDrawable(context.getResources().getDrawable(cates.getIconImg()));
    }

    @Override
    public int getItemCount() {
        return catesList.size();
    }

    class CatesViewHolder extends RecyclerView.ViewHolder {

        TextView iconTitle;
        ImageView iconImg;

        public CatesViewHolder(@NonNull View itemView) {
            super(itemView);

            iconTitle = itemView.findViewById(R.id.icontitle);
            iconImg = itemView.findViewById(R.id.iconimg);

        }
    }
}
