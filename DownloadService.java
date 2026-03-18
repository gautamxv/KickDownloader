package com.example.kickdownloader;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;

import com.arthenica.ffmpegkit.FFmpegKit;

import java.io.*;
import java.net.*;
import java.util.regex.*;

public class DownloadService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(() -> {
            try {
                String pageUrl = intent.getStringExtra("url");

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new URL(pageUrl).openStream())
                );

                StringBuilder html = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    html.append(line);
                }

                Pattern pattern = Pattern.compile("https://[^\\\"]+\\.m3u8");
                Matcher matcher = pattern.matcher(html.toString());

                String m3u8 = null;
                if (matcher.find()) {
                    m3u8 = matcher.group();
                }

                if (m3u8 == null) return;

                String output = Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DOWNLOADS
                ) + "/kick_video.mp4";

                String cmd = "-headers \"User-Agent: Mozilla/5.0\" -i \"" + m3u8 + "\" -c copy -bsf:a aac_adtstoasc \"" + output + "\"";

                FFmpegKit.execute(cmd);

            } catch (Exception e) {
                e.printStackTrace();
            }

            stopSelf();

        }).start();

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
