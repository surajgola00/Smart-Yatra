# 📱 Smart Yatra – Android Application

## Overview

Smart Yatra is an Android application developed using **Java** as a solution for a **Smart India Hackathon (SIH) problem statement**, focused on **prioritising tourist safety** while also providing tourists with meaningful exposure to the **culture, events, and destinations of North‑Eastern India**.

The application is designed to ensure safe travel experiences through real‑time monitoring, intelligent alerts, and guided assistance. It integrates with a **Python-based REST API** and a **MySQL database**, and works alongside a web‑based Admin Panel to enable authorities and response teams to monitor tourist activity and respond quickly during emergencies.

---

## Tech Stack

* **Language:** Java
* **Platform:** Android
* **Backend:** Python REST API
* **Database:** MySQL
* **Communication:** HTTP / JSON

---

## Application Flow

1. **User Registration** – New users register through the app (API‑integrated)
2. **User Login** – Login using the same registered credentials
3. **Home Dashboard Access** – Explore events, places, and register for visits
4. **Security Activation** – Safety features activate automatically for registered tours
5. **Background Location Tracking** – Location updates are sent to the backend for safety monitoring
   ** – Location is shared with the backend API

---

## Application Pages

### 🏠 Home Page

The Home Page serves as the main dashboard of the application and introduces users to the travel ecosystem.

Key features include:

* Highlights of **upcoming cultural events and festivals** in North‑Eastern India
* Information about **tourist places and destinations**
* Options for tourists to **register for guided visits and tours**
* Explore section showcasing places, experiences, and cultural insights
* Quick navigation to all other app features

### 🔐 Security Page

The Security Page represents the **core purpose of Smart Yatra** — ensuring tourist safety.

Key features:

* Integration with **Google Maps** to display the user’s current location
* Automatic **real‑time location sharing** with the backend API
* **Geofencing-based safety monitoring** for registered tourist visits
* Location tracking activates automatically based on the **date and time of the registered visit**
* If a user enters a **restricted or unsafe zone**, the system:

  * Sends alerts to the **tourist**
  * Notifies the **response team** for quick action

Emergency support features:

* Dedicated **Women Helpline**
* **SOS** emergency trigger
* **Helpdesk** support for immediate assistance

This system enables proactive monitoring and quick response to ensure tourist safety at all times.

### 🧭 Disha AI – Itinerary Planner

Disha AI is a virtual travel assistant integrated into the app to enhance the user’s travel planning experience.

Features:

* AI‑powered **itinerary planning** based on user preferences
* Helps users plan trips by asking a **few key details**
* Answers travel‑related queries and provides guidance
* Integrated with **Meta AI** through the backend API

Disha AI makes trip planning simple, interactive, and personalised for tourists.
feature

* Helps users plan their journey efficiently
* Designed to assist travelers with route and travel planning

### ⚙️ Settings Page

* Manage user preferences
* Update application-related settings
* Provides logout functionality

---

## Important Configuration

Before running the application, update the **API Base URL** in the Android code.

### Files to Update

* `SecurityFragment.java`
* `RegistrationActivity.java`

### Example

```java
private static final String BASE_URL = "http://YOUR_BACKEND_IP:PORT/";
```

Replace `YOUR_BACKEND_IP` and `PORT` with:

* Localhost (Android Emulator)
* Local network IP
* Deployed backend server URL

---

## How to Run the Application

1. Open **Android Studio**
2. Select **Open an Existing Project**
3. Navigate to the `Android App/` directory
4. Update the API Base URL (mandatory)
5. Sync Gradle dependencies
6. Run the app on an emulator or physical device

---

## APK

The APK file is not included in this repository.

A download link is provided in the **main project README**.

---

## Notes for Evaluators

* The application requires the backend server to be running
* Location data can be viewed in real-time on the Admin Panel
* No sensitive credentials are committed to the repository

---

## Folder Location

```
Smart-Yatra/Android App/
```
