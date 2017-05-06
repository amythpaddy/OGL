package com.caragiz_studio.example.ogl;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private GLSurfaceView glView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        if (hasGLES20()) {
            glView = new GLSurfaceView(this);
            glView.setEGLContextClientVersion(2);
            glView.setPreserveEGLContextOnPause(true);
            glView.setRenderer(new GLRendere());
        } else {
            Toast.makeText(this, "gl NOT SUPPORTED", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (glView != null)
            glView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (glView != null)
            glView.onResume();
    }
}

