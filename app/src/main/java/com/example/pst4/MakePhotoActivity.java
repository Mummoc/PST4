package com.example.pst4;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MakePhotoActivity extends Activity {
    final static String DEBUG_TAG = "MakePhotoActivity";
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;
    private static final int REQUEST_TAKE_PHOTO = 1;
    private static final int TAKE_PICTURE = 1;
    Button makephoto;
    ImageView imageView;
    GridView gridView;
    Bitmap bitmap;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_layout_sumup);

        requestPermissions();

    }

    protected void requestPermissions(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_TAKE_PHOTO);
        } else {
            launchFeature();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PICTURE && resultCode == RESULT_OK){
            bitmap = (Bitmap) data.getExtras().get("data");
            //On envoie l'image à la grille d'image view dans la classe CarPictureAdapter
            //imageView = new ImageView(this);
            //imageView.setImageBitmap(bitmap);
            CarPictureAdapter carPictureAdapter = new CarPictureAdapter(this);

            //Boucler en fonction du nombre de photos prises
            carPictureAdapter.bitmapList.add(bitmap);

            //gridView = findViewById(R.id.grid_view);
            //gridView.setAdapter(carPictureAdapter);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_TAKE_PHOTO: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    launchFeature();
                } else {
                    disableFeature();
                }
                return;
            }
        }
    }

    private void launchFeature() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, TAKE_PICTURE);
    }

    private void disableFeature(){
        makephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MakePhotoActivity.this, "Vous devez donnez la permission CAMERA", Toast.LENGTH_SHORT).show();
            }
        });
    }

}