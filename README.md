# KickDownloader 🎮

Download Kick.com clips and VODs directly on Android.

---

## 📁 Project Structure

```
KickDownloader/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/kickdownloader/
│   │   │   ├── MainActivity.java      ← UI + permission handling
│   │   │   └── DownloadService.java   ← Background download logic
│   │   ├── res/layout/
│   │   │   └── activity_main.xml      ← Dark-themed UI layout
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
├── settings.gradle
└── gradle.properties
```

---

## 🔨 How to Build APK

### Requirements
- Android Studio (Hedgehog or newer) — https://developer.android.com/studio
- JDK 11 or higher (bundled with Android Studio)

### Steps

1. **Open the project**
   - Launch Android Studio
   - Click **File → Open**
   - Select the `KickDownloader/` folder

2. **Sync Gradle**
   - Android Studio will prompt: *"Gradle sync needed"* → click **Sync Now**
   - Wait for dependencies to download (needs internet)

3. **Build Debug APK**
   - Go to **Build → Build Bundle(s) / APK(s) → Build APK(s)**
   - Wait for build to finish (~1–2 min)
   - Click **"locate"** in the popup, or find it at:
     `app/build/outputs/apk/debug/app-debug.apk`

4. **Install on device**
   - Enable **Settings → Developer Options → USB Debugging** on your phone
   - Connect via USB and run:
     ```
     adb install app/build/outputs/apk/debug/app-debug.apk
     ```
   - Or copy the APK to your phone and open it (enable *Install from unknown sources*)

---

## 📱 Features

- Paste any **kick.com** clip or VOD URL
- Select quality (Best / 1080p / 720p / 480p / 360p / Audio Only)
- Background download with foreground service
- Real-time progress bar + log output
- Files saved to `Movies/KickDownloader/` on device

---

## ⚠️ Notes

- Downloads are for **personal use only**
- Kick.com API endpoints may change — update `DownloadService.java` if needed
- For HLS/m3u8 streams, additional parsing logic may be needed
