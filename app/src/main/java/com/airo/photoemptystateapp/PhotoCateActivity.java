package com.airo.photoemptystateapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PhotoCateActivity extends AppCompatActivity {

    RecyclerView myCateList;
    CatesAdapter catesAdapter;
    List<Cates> catesList;
    Button btnSaveCate;
    Animation btt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_cate);

        btnSaveCate = findViewById(R.id.btnSaveCate);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);

        catesList = new ArrayList<>();
        catesList.add(
                new Cates("Juicy",
                        R.drawable.businesswoman)
        );
        catesList.add(
                new Cates("Snorkling",
                        R.drawable.boy)
        );
        catesList.add(
                new Cates("Shopping",
                        R.drawable.cowboy)
        );
        catesList.add(
                new Cates("Study",
                        R.drawable.designer)
        );
        catesList.add(
                new Cates("Travel",
                        R.drawable.diver)
        );
        catesList.add(
                new Cates("DoorPrize",
                        R.drawable.detective)
        );

        myCateList = findViewById(R.id.myCateList);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        myCateList.setLayoutManager(linearLayoutManager);
        myCateList.setHasFixedSize(true);
        catesAdapter = new CatesAdapter(this, catesList);
        myCateList.setAdapter(catesAdapter);

        // snapping from Google
        final SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(myCateList);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1ms = 100ms
                RecyclerView.ViewHolder viewHolder = myCateList.findViewHolderForAdapterPosition(0);
                ImageView imageView = viewHolder.itemView.findViewById(R.id.iconimg);
                imageView.animate().alpha(1).scaleX(1).scaleY(1).setDuration(100).start();

                TextView iconTitle = viewHolder.itemView.findViewById(R.id.icontitle);
                iconTitle.animate().alpha(1).setDuration(100).start();

                btnSaveCate.startAnimation(btt);
                btnSaveCate.animate().alpha(1).setDuration(100).start();
                //btnSaveCate.setAlpha(0);
            }
        }, 100);

        myCateList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    View view = snapHelper.findSnapView(linearLayoutManager);
                    int pos = linearLayoutManager.getPosition(view);

                    RecyclerView.ViewHolder viewHolder = myCateList.findViewHolderForAdapterPosition(pos);
                    ImageView imageView = viewHolder.itemView.findViewById(R.id.iconimg);
                    imageView.animate().alpha(1).scaleX(1).scaleY(1).setDuration(100).start();

                    TextView iconTitle = viewHolder.itemView.findViewById(R.id.icontitle);
                    iconTitle.animate().alpha(1).setDuration(100).start();

                    //btnSaveCate.setAlpha(1);
                    btnSaveCate.startAnimation(btt);
                    btnSaveCate.animate().alpha(1).setDuration(100).start();

                } else {
                    View view = snapHelper.findSnapView(linearLayoutManager);
                    int pos = linearLayoutManager.getPosition(view);

                    RecyclerView.ViewHolder viewHolder = myCateList.findViewHolderForAdapterPosition(pos);
                    ImageView imageView = viewHolder.itemView.findViewById(R.id.iconimg);
                    imageView.animate().alpha(0.5f).scaleX(0.5f).scaleY(0.5f).setDuration(100).start();

                    TextView iconTitle = viewHolder.itemView.findViewById(R.id.icontitle);
                    iconTitle.animate().alpha(0).setDuration(100).start();

                }

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                btnSaveCate.setAlpha(0);
            }
        });

    }
}
