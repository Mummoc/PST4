package com.example.pst4;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MakePhotoActivity extends Activity {
    final static String DEBUG_TAG = "MakePhotoActivity";
    private Camera camera;
    private int cameraid = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            Toast.makeText(this, "No camera oon this device", Toast.LENGTH_LONG).show();
        } else {
            cameraid = findFrontFacingCamera();
            if (cameraid < 0) {
                Toast.makeText(this, "No front facing camera found.", Toast.LENGTH_LONG).show();
            } else {
                camera = Camera.open();
            }
        }
    }

    public void onClick(View view) {
        camera.startPreview();
        camera.takePicture(null, null, new PhotoHandle(getApplicationContext()));
    }

    private int findFrontFacingCamera() {
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
    }
}
