package com.example.logbook02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    ArrayList<String> imageUrlList;
    Button addImgUrl;
    Button back_btn;
    Button forward_btn;
    EditText inputImageURl;
    int currentImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageUrlList = new ArrayList<String>();
        imageUrlList.add("https://d32qe1r3a676y7.cloudfront.net/eyJidWNrZXQiOiJibG9nLWVjb3RyZWUiLCJrZXkiOiAiYmxvZy8wMDAxLzAxL2FkNDZkYmI0NDdjZDBlOWE2YWVlY2Q2NGNjMmJkMzMyYjBjYmNiNzkuanBlZyIsImVkaXRzIjp7InJlc2l6ZSI6eyJ3aWR0aCI6IDkwMCwiaGVpZ2h0IjowLCJmaXQiOiJjb3ZlciJ9fX0=");
        imageUrlList.add("https://upload.wikimedia.org/wikipedia/commons/e/eb/Ash_Tree_-_geograph.org.uk_-_590710.jpg");


        inputImageURl = findViewById(R.id.eUrl);
        imageView = findViewById(R.id.image_View);
        back_btn = findViewById(R.id.previous);
        forward_btn = findViewById(R.id.next);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                renderImageWhenOnclick(view);
            }
        });

        forward_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                renderImageWhenOnclick(view);
            }
        });



        addImgUrl = findViewById(R.id.aURL);
        addImgUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imageURl = inputImageURl.getText().toString();
                if (imageURl.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter Image URL !!!", Toast.LENGTH_SHORT).show();
                } else {
                    imageUrlList.add(imageURl);
                    inputImageURl.setText("");
                    Toast.makeText(getApplicationContext(), "Added successfully !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void renderImageWhenOnclick(View view) {
        if (view == forward_btn) {
            currentImage++;
            if (currentImage == imageUrlList.size()) {
                currentImage = 0;
            }
        } else {
            if (currentImage == 0) {
                currentImage = imageUrlList.size();
            }
            currentImage--;
        }
        loadImage(currentImage);
    }

    private void loadImage(int item) {
        Glide.with(MainActivity.this)
                .load(imageUrlList.get(item))
                .into(imageView);
    }
}