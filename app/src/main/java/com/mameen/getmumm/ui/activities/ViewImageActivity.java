package com.mameen.getmumm.ui.activities;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.mameen.getmumm.R;
import com.mameen.getmumm.ui.adapters.GalleryAdapter;
import com.mameen.getmumm.util.ParentActivity;
import com.squareup.picasso.Picasso;

import java.io.File;

import io.github.sporklibrary.Spork;
import io.github.sporklibrary.android.annotations.BindClick;
import io.github.sporklibrary.android.annotations.BindView;

public class ViewImageActivity extends ParentActivity {

    static final String TAG = ViewImageActivity.class.getSimpleName();

    @BindView(R.id.img)
    private ImageView img;

    private String image_path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        Spork.bind(this);

        image_path = getIntent().getExtras().getString("image");

        try {
            Picasso.get()
                    .load(new File(image_path))
                    .placeholder(R.color.overlay)
                    .error(R.color.overlay)
                    .into(img);
        } catch (Exception e) {
            Log.e(TAG, "Error: " + e.getMessage());
        }
    }

    @BindClick(R.id.btnShare)
    private void sharePhoto() {
        if (isFacebookPackageInstalled()) {
            File file = new File(image_path);
            Uri uri = Uri.fromFile(file);
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/*");
            intent.setPackage("com.facebook.katana");
            intent.putExtra(Intent.EXTRA_STREAM, uri);

            try {
                startActivity(intent);
            } catch (Exception e) {
                Log.e(TAG, "Error: " + e.getMessage());
            }
        } else {
            showLongSnackbar(R.id.parent, "Facebook didn't install!");
        }
    }

    private boolean isFacebookPackageInstalled() {
        PackageManager pm = getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo("com.facebook.katana", PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
        return true;
    }
}
