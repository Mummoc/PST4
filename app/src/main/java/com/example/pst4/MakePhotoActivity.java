package com.example.pst4;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MakePhotoActivity extends Activity {
    final static String DEBUG_TAG = "MakePhotoActivity";
    private static final int REQUEST_ID_IMAGE_CAPTURE = 100;
    private static final int REQUEST_ID_READ_WRITE_PERMISSION = 99;
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;
    Button makephoto;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

       imageView = findViewById(R.id.result);
        makephoto = findViewById(R.id.button_takephoto);
        makephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MakePhotoActivity.this.onClick(v);
            }
        });

       /* if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            Toast.makeText(this, "No camera oon this device", Toast.LENGTH_LONG).show();
        } else {
            cameraid = findFrontFacingCamera();
            if (cameraid < 0) {
                Toast.makeText(this, "No front facing camera found.", Toast.LENGTH_LONG).show();
            } else {
                camera = Camera.open();
            }
        }*/
    }

    public void onClick(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        this.startActivityForResult(intent,REQUEST_ID_IMAGE_CAPTURE);
    }

    public static List<String> checkAndRequestPermissions(Context context){
        int camera = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA);
        int readStorage = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);
        int writeStorage = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int fineLoc = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION);
        int coarseLoc = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION);

        List<String> listPermissionsNeeded = new ArrayList<>();

        if (camera != PackageManager.PERMISSION_GRANTED){
            listPermissionsNeeded.add(Manifest.permission.CAMERA);
        }

        if (readStorage != PackageManager.PERMISSION_GRANTED){
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }

        if (writeStorage != PackageManager.PERMISSION_GRANTED){
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (fineLoc != PackageManager.PERMISSION_GRANTED){
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }

        if (coarseLoc != PackageManager.PERMISSION_GRANTED){
            listPermissionsNeeded.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }

        return listPermissionsNeeded;
    }

    private boolean permissions(List<String> listPermissionsNeeded){

        if (!listPermissionsNeeded.isEmpty()){
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_ID_IMAGE_CAPTURE){
            if (resultCode == RESULT_OK){
                Bitmap bp = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(bp);
            } else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Action canceled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Action failed", Toast.LENGTH_LONG).show();
            }
        }
    }

   /* @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case REQUEST_ID_READ_WRITE_PERMISSION: {
                if (grantResults.length > 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_LONG).show();
                }
            }
        }
    }*/

    /*private int findFrontFacingCamera() {
        int cameraId = -1;
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i<numberOfCameras; i++){
            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(i, info);
            if (info.facing == android.hardware.Camera.CameraInfo.CAMERA_FACING_FRONT){
                Log.d(DEBUG_TAG, "Camera found");
                cameraId = i;
                break;
            }
        }
        return cameraId;
    }

    @Override
    protected void onPause() {
        if (camera != null){
            camera.release();
            camera = null;
        }
        super.onPause();
    }*/
}
