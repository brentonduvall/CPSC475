package com.example.permissioninclassdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private static final String[] PERMISSIONS={Manifest.permission.WRITE_EXTERNAL_STORAGE,
    Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.CAMERA};
    private static final int PERMS_REQ_CODE = 206;
    //Don't let your anonymous listener go out of scope
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doStartCamera(View view) {
        if(!verifyPermissions())
            return;
        startCamera();
    }

    private void startCamera(){
        Intent mi = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(mi);
    }

    /**
     * Verify that the specific list of permisions requested have been granted,
     otherwise ask for
     * these permissions. Note this is coarse in that I assumme I need them all
     */
    private boolean verifyPermissions() {
        boolean allGranted = true;
        for (String permission:PERMISSIONS) {
            allGranted = allGranted && (ActivityCompat.checkSelfPermission(this, permission) ==
                    PackageManager.PERMISSION_GRANTED);

        }
        if (!allGranted) {

            for (String permission : PERMISSIONS) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                    Snackbar.make(findViewById(android.R.id.content),
                            permission+"WE GOTTA HAVE IT!", Snackbar.LENGTH_LONG).show();
                }
            }
            requestPermissions(PERMISSIONS,
                    PERMS_REQ_CODE);
        }

        return allGranted;
    }

    /***
     * callback from requestPermissions
     * @param permsRequestCode user defined code passed to requestpermissions used to identify what
    callback is coming in
     * @param permissions list of permissions requested
     * @param grantResults //results of those requests
     */
    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(permsRequestCode, permissions, grantResults);
        boolean allGranted = true;
        switch (permsRequestCode) {
            case PERMS_REQ_CODE:
                for (int result : grantResults) {
                    allGranted = allGranted && (result == PackageManager.PERMISSION_GRANTED);
                }

                if (allGranted) {
                    //TODO do your work here
                    startCamera();
                    break;
            }
        }
    }


}