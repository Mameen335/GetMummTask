package com.mameen.getmumm.ui.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mameen.getmumm.R;
import com.mameen.getmumm.app.Constants;
import com.mameen.getmumm.data.apis.responses.WeatherResponse;
import com.mameen.getmumm.data.apis.services.WeatherService;
import com.mameen.getmumm.data.apis.services.impl.WeatherServiceImple;
import com.mameen.getmumm.util.ParentActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.github.sporklibrary.Spork;
import io.github.sporklibrary.android.annotations.BindClick;
import io.github.sporklibrary.android.annotations.BindView;
import io.github.sporklibrary.annotations.BindComponent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TakePhotoActivity extends ParentActivity {

    static final String TAG = TakePhotoActivity.class.getSimpleName();

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private boolean havePhoto = false;

    @BindView(R.id.tvPlaceName)
    private TextView tvPlaceName;

    @BindView(R.id.tvTemperature)
    private TextView tvTemperature;

    @BindView(R.id.tvWeatherCondition)
    private TextView tvWeatherCondition;

    @BindView(R.id.img)
    private ImageView img;

    @BindView(R.id.lyPhoto)
    private RelativeLayout lyPhoto;

    @BindComponent(WeatherServiceImple.class)
    WeatherService weatherService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);

        Spork.bind(this);

        dispatchTakePictureIntent();
    }

    @BindClick(R.id.btnChangePhoto)
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            img.setImageBitmap(imageBitmap);

            havePhoto = true;

            loadWeatherData();
        }
    }

    private void loadWeatherData() {
        weatherService.getWeather(Constants.MY_PLACE, Constants.APPID, new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful()) {

                    tvPlaceName.setText(response.body().getPlaceName());
                    tvTemperature.setText(response.body().getTemp());
                    tvWeatherCondition.setText(response.body().getDescription());

                } else {
                    // no internet
                    showShortSnackbar(R.id.parent, getResources().getString(R.string.check_internet));
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.e(TAG, "onFailure Cause: " + t.getCause());
            }
        });
    }

    @BindClick(R.id.btnSavePhoto)
    private void saveImage() {
        if (havePhoto) {
            lyPhoto.setDrawingCacheEnabled(true);
            Bitmap b = lyPhoto.getDrawingCache();
            try {
                makeOutputFile();

                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String imageName = "IMG_" + timeStamp + ".jpg";

                b.compress(Bitmap.CompressFormat.JPEG, 95, new FileOutputStream(Constants.DEFAULT_STORAGE_LOCATION
                        + "/" + imageName));

                showLongSnackbar(R.id.parent, "Photo Saved Successfully");

                tvPlaceName.setText("");
                tvTemperature.setText("");
                tvWeatherCondition.setText("");

                img.setImageResource(0);
                havePhoto = false;
            } catch (FileNotFoundException e) {
                Log.e(TAG, "Error: " + e.getMessage());
            }
        } else {
            showLongSnackbar(R.id.parent, "You should Take a photo!");
        }
    }


    private void makeOutputFile() {
        File dir = new File(Constants.DEFAULT_STORAGE_LOCATION);

        if (!dir.exists()) {
            try {
                dir.mkdirs();
            } catch (Exception e) {
                Log.e(TAG, "Error: " + e.getMessage());
            }
        }
    }
}
