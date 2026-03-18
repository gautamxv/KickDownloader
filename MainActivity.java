package com.example.kickdownloader;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText urlInput;
    Button downloadBtn;
    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlInput = findViewById(R.id.urlInput);
        downloadBtn = findViewById(R.id.downloadBtn);
        status = findViewById(R.id.status);

        downloadBtn.setOnClickListener(v -> {
            String url = urlInput.getText().toString();

            Intent intent = new Intent(this, DownloadService.class);
            intent.putExtra("url", url);
            startService(intent);

            status.setText("Downloading...");
        });
    }
}
