# Hybrid Android-Kotlin & Flutter App

This project demonstrates a **hybrid mobile application** where a native Android Kotlin app integrates a **cached Flutter engine** to launch Flutter screens (`HomePage` and `DetailPage`) without recreating the engine. The app allows seamless navigation from native buttons to Flutter routes and back.

---

## Project Overview

- **Native MainActivity**: The landing screen in Kotlin with two buttons:
  - **Home Page** → Opens Flutter `HomePage` (`/`)
  - **Detail Page** → Opens Flutter `DetailPage` (`/detail`)
- **Flutter Module**: Contains two screens:
  - `HomePage` → Default route (`/`)
  - `DetailPage` → Named route (`/detail`)
- **Engine Caching**: Only one instance of `FlutterEngine` (`my_cached_engine`) is created and reused for all navigations.
- **Back Navigation**: Pressing the back arrow in Flutter screens returns to the native MainActivity.

---

## Prerequisites

- Android Studio (Dolphin or later)  
- Flutter SDK v3.19 or later  
- Kotlin 1.9+  
- JDK 11+  

---

## Project Structure

```

hybrid_android_flutter/
│
├── android_app/                     # Native Android app (Kotlin)
│   └── src/
│       └── main/...
│
├── flutter_module/                  # Flutter module
│   ├── lib/
│   │   └── pages/
│   │       ├── home_page.dart
│   │       └── detail_page.dart
│   │
│   ├── pubspec.yaml
│   │
│   └── build/
│       └── host/
│           └── outputs/
│               └── repo/
│                   └── com/example/flutter_module/
│                       ├── flutter_debug/...      # Debug AAR
│                       ├── flutter_profile/...    # Profile AAR
│                       └── flutter_release/...    # Release AAR
│
└── README.md

````

## Setup & Build Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/amanxmhd/Interview-Assessment.git
cd Interview-Assessment 
```

> This ensures the Android project recognizes the Flutter module.

### 2. Build the Flutter Module

```bash
cd flutter_module
flutter pub get
flutter build aar
```

### 3. Run the Android App

* Open project in Android Studio
* Build and run on an emulator or device
* The app shows **MainActivity** with two buttons:

    * **Home Page** → Opens Flutter `HomePage`
    * **Detail Page** → Opens Flutter `DetailPage`

---

## Navigation Behavior

* Clicking a **native button** launches Flutter via the cached engine.
* **Back button** on Flutter screens returns to the native MainActivity.
* Switching between Flutter routes does not recreate the engine.

---

## Key Features

1. **Single Cached Flutter Engine** (`my_cached_engine`) for all navigations
2. **Native-to-Flutter Routing** using `MethodChannel`
3. **Correct Back Navigation** to return to native activity
4. **Clean separation** between native and Flutter code

---

## Video Recording 
[Watch Demo Video](https://drive.google.com/file/d/1JhM7BL5v6Jz4YwzqtuvPvqe0B2vsgffU/view?usp=sharing)


