package com.mameen.getmumm.ui.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.mameen.getmumm.R;
import com.mameen.getmumm.app.Constants;
import com.mameen.getmumm.interfaces.OnItemClickListener;
import com.mameen.getmumm.ui.adapters.GalleryAdapter;
import com.mameen.getmumm.util.ParentActivity;
import com.mameen.getmumm.util.PermissionUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.github.sporklibrary.Spork;
import io.github.sporklibrary.android.annotations.BindClick;
import io.github.sporklibrary.android.annotations.BindView;

public class DashboardActivity extends ParentActivity {

    static final String TAG = DashboardActivity.class.getSimpleName();


    private GalleryAdapter adapter;
    private List<File> imagesList = new ArrayList<>();

    @BindView(R.id.rv)
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Spork.bind(this);

        initList();
    }

    @Override
    protected void onResume() {
        super.onResume();

        imagesList.clear();
        loadImages();
    }

    private void initList() {

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(DashboardActivity.this, 4);
        adapter = new GalleryAdapter(DashboardActivity.this, imagesList, R.layout.row_image);
        rv.setLayoutManager(mLayoutManager);
        rv.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent intent = new Intent(DashboardActivity.this, ViewImageActivity.class);
                intent.putExtra("image", imagesList.get(position).getAbsolutePath());

                startActivity(intent);
            }
        });
    }

    private void loadImages() {
        if (!PermissionUtils.hasPermissions(DashboardActivity.this, PermissionUtils.IMAGE_PERMISSIONS)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(PermissionUtils.IMAGE_PERMISSIONS, PermissionUtils.IMAGE_PERMISSION_RESPONSE);
            }
        } else {

            File dir = makeOutputFile();

            if (dir != null) {
                adapter.InsertAll(Arrays.asList(dir.listFiles()));

            }

        }
    }

    private File makeOutputFile() {
        File dir = new File(Constants.DEFAULT_STORAGE_LOCATION);

        if (!dir.exists()) {
            try {
                dir.mkdirs();
            } catch (Exception e) {
                Log.e(TAG, "Error: " + e.getMessage());
                return null;
            }
        }

        return dir;
    }

    @BindClick(R.id.btnTakePhoto)
    private void takePhoto() {
        if (!PermissionUtils.hasPermissions(DashboardActivity.this, PermissionUtils.IMAGE_PERMISSIONS)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(PermissionUtils.IMAGE_PERMISSIONS, PermissionUtils.IMAGE_PERMISSION_RESPONSE);
            }
        } else {
            gotoActivity(TakePhotoActivity.class);
        }
    }
}
