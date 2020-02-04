package com.example.tsechacks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview=findViewById(R.id.textView);

        if (!Python.isStarted())
        {
            Python.start(new AndroidPlatform(this));
        }

        Python py=Python.getInstance();
        PyObject pyf=py.getModule("pytest");
        PyObject object=pyf.callAttr("test");
        textview.setText(object.toString());

    }
}
