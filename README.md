# 📱 Smart Yatra – Android Application

## 🎥 Project Demo

👉 [Watch Problem Video]()

---

## 🈸 App APK

👉 [Download]()

### 🔑 Sample Login Credentials

```

Email: [suraj@example.com](mailto:suraj@example.com)
Password: suraj123

```

> Use the above credentials to explore the app features without creating a new account.
```


## Overview

Smart Yatra is an Android application developed using **Java** as a solution for a **Smart India Hackathon (SIH) problem statement(PS No. SIH25002)**, focused on **prioritising tourist safety** while also providing tourists with meaningful exposure to the **culture, events, and destinations of North‑Eastern India**.

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

## 🛂 Admin Panel (Web Dashboard)

### Overview

The **Admin Panel** is a minimalist web-based dashboard designed for **local authorities** to monitor tourist activity and ensure safety in real time. It connects to the same backend used by the Android app and visualizes live location data on an interactive map.

### Key Features

* **Tourist Count per Location** – Displays the number of tourists visiting a particular area
* **Live Location Tracking** – Shows real-time location updates of active users
* **Geo-fencing Alerts** – Raises alerts if a user enters a danger zone or is detected as suspicious
* **Active Users List** – Right-hand panel displaying currently active users
* **User Selection & Tracking** – Selecting a user plots their movement on the map
* **Polyline Visualization** – Tracks user movement history using polylines

### Map & Visualization

* Built using the **Leaflet.js** library
* Used for rendering maps, markers, and drawing polylines for movement tracking
* Optimized for clarity and low visual clutter to support quick decision-making

### Important Configuration

Before running the Admin Panel, update the **API Base URL** in the frontend code.

**File to Update:**

* `app.js`

**Example:**

```js
const BASE_URL = "http://YOUR_BACKEND_IP:PORT/";
```

Replace `YOUR_BACKEND_IP` and `PORT` with the appropriate backend server address.

### Notes for Authorities / Evaluators

* The Admin Panel requires the backend server to be running
* Alerts are generated based on geo-fencing rules defined in the backend
* Designed for monitoring purposes only; no user credentials are exposed
* Intended for controlled access by authorized personnel

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
Smart-Yatra/# 📱 Smart Yatra – Android Application

---

## 🛂 Admin Panel (Web Dashboard)

### Overview

The **Admin Panel** is a minimalist web-based dashboard designed for **local authorities** to monitor tourist activity and ensure safety in real time. It connects to the same backend used by the Android app and visualizes live location data on an interactive map.

### Key Features

* **Tourist Count per Location** – Displays the number of tourists visiting a particular area
* **Live Location Tracking** – Shows real-time location updates of active users
* **Geo-fencing Alerts** – Raises alerts if a user enters a danger zone or is detected as suspicious
* **Active Users List** – Right-hand panel displaying currently active users
* **User Selection & Tracking** – Selecting a user plots their movement on the map
* **Polyline Visualization** – Tracks user movement history using polylines

### Map & Visualization

* Built using the **Leaflet.js** library
* Used for rendering maps, markers, and drawing polylines for movement tracking
* Optimized for clarity and low visual clutter to support quick decision-making

### Important Configuration

Before running the Admin Panel, update the **API Base URL** in the frontend code.

**File to Update:**

* `app.js`

**Example:**

```js
const BASE_URL = "http://YOUR_BACKEND_IP:PORT/";
```

Replace `YOUR_BACKEND_IP` and `PORT` with the appropriate backend server address.

### Notes for Authorities / Evaluators

* The Admin Panel requires the backend server to be running
* Alerts are generated based on geo-fencing rules defined in the backend
* Designed for monitoring purposes only; no user credentials are exposed
* Intended for controlled access by authorized personnel

---

## Notes for Evaluators

* The application requires the backend server to be running
* Location data can be viewed in real-time on the Admin Panel
* No sensitive credentials are committed to the repository

---

## Folder Location

```
Smart-Yatra/Admin-Panel (Website)/
```

```

```md
## 🗄️ MySQL Database – Smart Yatra

This section describes the **MySQL database design** used in the Smart Yatra system.  
The database is responsible for storing user data, tourist visit schedules, real-time location updates, and safety alerts generated through geofencing.

The database is accessed by the **Python REST API**, which acts as a bridge between:
- Android Application
- Web-based Admin Panel

---

## 🎯 Purpose of the Database

- Store registered tourist details securely
- Maintain login and authentication data
- Track scheduled tourist visits (date, time, location)
- Store live GPS location updates from the app
- Log alerts triggered due to restricted/danger zones
- Enable authorities to monitor tourists in real time

---

## 📦 Database Name

```

smart_yatra

```

---

## 📊 Core Tables Overview

```

Users ──┬── Tourist_Visits ──┬── Location_Logs
│                    └── Alerts
└── Emergency_Contacts

````

---

## 🧑‍💼 1. users

Stores basic user account and profile information.

```sql
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    gender VARCHAR(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
````

**Used by**

* Login / Registration
* User identification across the system

---

## 🗺️ 2. tourist_visits

Stores details of registered tourist visits.

```sql
CREATE TABLE tourist_visits (
    visit_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    location_name VARCHAR(150),
    visit_date DATE,
    start_time TIME,
    end_time TIME,
    status ENUM('upcoming', 'active', 'completed') DEFAULT 'upcoming',
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
```

**Used by**

* Auto-activation of tracking
* Time-based geofencing logic

---

## 📍 3. location_logs

Stores real-time and historical GPS data sent from the Android app.

```sql
CREATE TABLE location_logs (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    latitude DECIMAL(10, 7),
    longitude DECIMAL(10, 7),
    recorded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
```

**Used by**

* Admin Panel live tracking
* Drawing polylines on maps (Leaflet)
* Movement history analysis

---

## 🚨 4. alerts

Stores alerts generated when a user enters a restricted or danger zone.

```sql
CREATE TABLE alerts (
    alert_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    alert_type ENUM('restricted_zone', 'sos', 'women_helpline'),
    message TEXT,
    is_resolved BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
```

**Used by**

* Admin Panel alert dashboard
* Emergency response coordination
* User notifications

---

## ☎️ 5. emergency_contacts

Stores emergency contact details for each user.

```sql
CREATE TABLE emergency_contacts (
    contact_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    contact_name VARCHAR(100),
    contact_phone VARCHAR(15),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
```

**Used by**

* SOS feature
* Emergency notifications

---

## 🔄 Data Flow (Simplified)

```
Android App
   ↓
Python REST API
   ↓
MySQL Database
   ↓
Admin Panel (Live Monitoring)
```

---

## 🛡️ Security Considerations

* Passwords are stored as **hashed values**
* No plaintext credentials are stored
* Database access is restricted to the backend API only
* CORS and authentication enforced at API level

---

## 🧪 Notes for Developers & Evaluators

* Location logging starts **only during active visits**
* Alerts are auto-generated via geofencing logic in the backend
* Admin Panel fetches live data at fixed intervals
* Database can be easily extended for analytics or reports

---

## 📌 Configuration

Update database credentials in the backend API configuration file:

```python
host = "localhost"
user = "your_db_user"
password = "your_db_password"
database = "smart_yatra"
```

---

This database design ensures **scalability, real-time monitoring, and tourist safety**, forming the backbone of the Smart Yatra ecosystem.

```
## Folder Location

```
Smart-Yatra/Backend (API)/
```
```
```md
## ⚙️ Backend API – Flask (Smart Yatra)

The Smart Yatra backend is built using **Flask (Python)** and serves as the central communication layer between the **Android App**, **MySQL Database**, **Admin Panel**, and **Disha AI**.  
It handles user registration, location tracking, AI-based itinerary assistance, and data access for authorities.

---

## 🎯 Responsibilities of the Backend API

- Handle user registration and data storage
- Receive and store real-time GPS location updates
- Provide location history for tracking and visualization
- Serve tourist data to the Admin Panel
- Power the **Disha AI** virtual assistant using Meta AI
- Enforce CORS for cross-platform communication

---

## 🧱 Tech Stack

- **Framework:** Flask
- **Language:** Python
- **Database:** MySQL
- **AI Integration:** Meta AI (via `meta_ai_api`)
- **CORS:** Flask-CORS
- **Data Format:** JSON (REST)

---

## 📁 Folder Structure (Backend)

```

backend/
│── app.py
│── requirements.txt

```

---

## 🔗 API Endpoints Overview

```

POST   /register
POST   /location/update
GET    /location/history/<user_id>
GET    /details/<user_id>
GET    /users
POST   /ai
GET    /

```

---

## 🧑‍💼 1. User Registration

**Endpoint**
```

POST /register

````

**Purpose**
- Registers a new tourist into the system
- Stores personal, emergency, and visit-related details

**Required Fields**
```json
{
  "full_name": "User Name",
  "age": 21,
  "gender": "Male/Female",
  "email": "user@email.com",
  "phone": "XXXXXXXXXX"
}
````

**Response**

```json
{
  "status": "ok",
  "timestamp": 1710000000000
}
```

---

## 📍 2. Location Update (Live Tracking)

**Endpoint**

```
POST /location/update
```

**Purpose**

* Receives live GPS coordinates from the Android app
* Stores data for real-time tracking and geofencing

**Payload**

```json
{
  "user_id": "USR123",
  "latitude": 27.4728,
  "longitude": 94.9120
}
```

---

## 🧭 3. Location History

**Endpoint**

```
GET /location/history/<user_id>
```

**Purpose**

* Fetches historical movement data of a tourist
* Used by Admin Panel to draw polylines on maps

**Response**

```json
[
  {
    "latitude": 27.4728,
    "longitude": 94.9120,
    "timestamp": 1710000000000
  }
]
```

---

## 🪪 4. Fetch User Details

**Endpoint**

```
GET /details/<user_id>
```

**Purpose**

* Retrieves complete profile information of a tourist
* Used by authorities for identification during alerts

---

## 👥 5. Fetch All Users (Admin Panel)

**Endpoint**

```
GET /users
```

**Purpose**

* Returns a list of all registered users
* Used to populate the **Active / Selectable Users List** on the Admin Panel

---

## 🤖 6. Disha AI – Virtual Assistant

**Endpoint**

```
POST /ai
```

**Purpose**

* Powers the **Disha AI** chatbot
* Helps tourists plan itineraries and resolve travel queries

**Payload**

```json
{
  "query": "Plan a 3-day trip to Assam"
}
```

**Response**

```json
{
  "response": "Here is a suggested 3-day itinerary..."
}
```

> Integrated using **Meta AI** via `meta_ai_api`

---

## ❤️ Health Check

**Endpoint**

```
GET /
```

**Response**

```json
{
  "status": "running"
}
```

---

## 🔐 Database Connection

Update database credentials in `get_db_cursor()`:

```python
host="host"
user="user"
password="password"
database="database"
```

---

## 🔄 Data Flow

```
Android App ──▶ Flask API ──▶ MySQL
                    │
                    ├──▶ Admin Panel (Live Tracking)
                    └──▶ Disha AI (Meta AI)
```

---

## 🛡️ Security & Reliability

* CORS enabled for Android & Web access
* Centralized error handling (404, 405)
* JSON validation on all POST requests
* Database connections safely closed after each request

---

## 📦 Requirements

Install dependencies using:

```bash
pip install -r requirements.txt
```

**requirements.txt includes**

* flask
* flask-cors
* mysql-connector-python
* meta-ai-api

---

## 📝 Notes for Evaluators

* API must be running for the app and admin panel to function
* Location tracking is continuous during active tourist visits
* Alerts and geofencing logic are handled at backend level
* Designed for scalability and real-time monitoring

---

This backend API acts as the **core engine of Smart Yatra**, ensuring tourist safety, intelligent assistance, and seamless coordination with authorities.

## 👨‍💻 Authors  

Developed by **Suraj Gola & Vanshika Tyagi** 🚀  
- Team Leader: Suraj Gola  
- Aspiring SDE, Researcher, Art & Craft Manager  

---

## 🛡️ License  

This project is licensed under the **MIT License** – feel free to use, modify, and share. 

