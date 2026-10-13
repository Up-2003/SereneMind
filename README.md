#SereneMind - AI-Powered Mental Wellness App 🧠✨

SereneMind is a comprehensive mental wellness application designed to help users track their mood, practice meditation, journal their thoughts, and receive AI-driven insights. Built with a robust Spring Boot backend, a native Kotlin Android frontend, and integrated with Firebase for real-time notifications.

📱 Screenshots & UI Overview
(Include the images you provided in a screenshots/ folder in your repository)

Onboarding	Dashboard	Mood Tracker	Journaling	AI Insight
<img src="screenshots/1_splash.png" width="150">	<img src="screenshots/2_dashboard.png" width="150">	<img src="screenshots/3_mood.png" width="150">	<img src="screenshots/4_journal.png" width="150">	<img src="screenshots/5_ai_insight.png" width="150">
Meditation	Goals	AI Chat	Community	Profile
<img src="screenshots/6_meditation.png" width="150">	<img src="screenshots/7_goals.png" width="150">	<img src="screenshots/8_chat.png" width="150">	<img src="screenshots/9_community.png" width="150">	<img src="screenshots/10_profile.png" width="150">
🚀 Features
Based on the comprehensive UI design, the app includes the following core modules:

1. 👤 User Onboarding & Profile
Splash Screen: Welcoming interface with "Get Started" and Login options.

Profile Management: Personal information, privacy & security settings, premium subscription management, and app preferences.

2. 📊 Dashboard & Mood Tracking
Daily Overview: Displays current mood, weekly mood charts, and quick action buttons (Journal, Meditate, Goals, Breathing).

Mood Tracker: Allows users to log their current emotion (Happy, Calm, Neutral, Sad, Anxious, Angry) with an intensity slider and optional notes.

Mood History: Calendar view and graphical summaries (pie charts) of mood trends over time.

3. 📝 Journaling & AI Analysis
Rich Text Editor: Create, edit, and format journal entries with options to attach photos, tags, and privacy locks.

Journal List: Searchable and filterable list of past entries (Favorites, Tagged).

AI Insight & Analysis: The backend AI analyzes journal entries to detect emotions, stress levels, and key themes (e.g., "Positive day", "Walking"). It provides an "AI Perspective" and "Suggested Actions" based on the entry.

4. 🧘 Meditation & Mindfulness
Meditation Player: Audio player with progress tracking, play/pause, skip, download, favorite, and sleep timer functionality.

Categorized Sessions: Popular categories including Sleep, Anxiety, Focus, and Morning routines.

Recommendations: Personalized meditation suggestions (Deep Breathing, Body Scan, Sleep Meditation).

5. 🎯 Goals & Habits
Goal Creation: Set daily/weekly goals (e.g., "Meditate 10 minutes daily", "Write journal daily", "Drink 8 glasses of water").

Goal Detail & Tracking: Visual progress bars, current streaks, and historical completion data.

6. 🤖 AI Companion (SereneAI)
Chat Interface: A safe space to talk. The AI acts as a compassionate listener.

Interactive Support: Provides grounding exercises (e.g., 5-4-3-2-1 technique) and asks follow-up questions to help users process their emotions.

7. 👥 Community
Social Feed: A supportive space where users can share thoughts, struggles, and victories (anonymously or publicly).

Interactions: Like, comment, and follow other users for mutual support.

🛠️ Tech Stack
Frontend (Mobile)
Language: Kotlin

UI Framework: Jetpack Compose (Recommended for modern, reactive UI matching the mockups)

Architecture: MVVM (Model-View-ViewModel) with Clean Architecture principles

Networking: Retrofit + OkHttp (for REST API communication)

Image Loading: Coil

Local Storage: Room Database (for offline caching of journals and moods)

Backend
Language: Java / Kotlin

Framework: Spring Boot

Security: Spring Security + JWT (JSON Web Tokens)

Database:  MySQL

ORM: Spring Data JPA / Hibernate

AI Integration: OpenAI API / Groq API / Custom NLP models (for Journal Analysis and SereneAI Chat)

Cloud & Notifications
Push Notifications: Firebase Cloud Messaging (FCM)

Authentication: Firebase Auth (or custom JWT)

Storage: Cloudinary Storage (for profile pictures and journal attachments)

🏗️ System Architecture
text
[ Android App (Kotlin) ]
       │
       ├── UI Layer (Jetpack Compose)
       ├── ViewModels & State
       ├── Repository Layer
       │       ├── Local DB (Room)
       │       └── Remote API (Retrofit)
       │
       ▼
[ REST API (Spring Boot) ]
       │
       ├── Controllers (Auth, Journal, Mood, Goal, Chat)
       ├── Services (Business Logic, AI Integration)
       ├── Security (JWT Filter, OAuth2)
       │
       ├──► [MySqlSQL Database ]
       ├──► [ Firebase Admin SDK ] (Push Notifications)
       └──► [ AI Engine / API ] (Journal Analysis, Chatbot)
🔌 API Endpoints (Overview)
Method	Endpoint	Description
POST	/api/auth/login	User login & JWT generation
POST	/api/auth/register	User registration
GET	/api/users/profile	Get current user profile
GET	/api/moods	Get mood history (with date filters)
POST	/api/moods	Log a new mood
GET	/api/journals	Get list of journal entries
POST	/api/journals	Create a new journal entry
POST	/api/ai/analyze-journal	Trigger AI analysis on a journal entry
POST	/api/ai/chat	Send a message to SereneAI
GET	/api/goals	Get user goals & progress
POST	/api/goals	Create a new goal
GET	/api/meditations	Get meditation audio tracks
🚀 Getting Started
Prerequisites
Android Studio (Latest Version)

JDK 17 or higher

 MySQL

Firebase Project (for FCM and Auth)

Backend Setup (Spring Boot)
Clone the repository.

Navigate to the backend directory.

Configure application.properties with your database credentials and Firebase server key.

properties
spring.datasource.url=jdbc:postgresql://localhost:5432/serenemind
spring.datasource.username=your_user
spring.datasource.password=your_password
firebase.config.path=path/to/firebase-service-account.json
ai.api.key=your_openai_or_gemini_key
Run the application: ./mvnw spring-boot:run

Frontend Setup (Android Kotlin)
Open the android directory in Android Studio.

Add your google-services.json file (from Firebase Console) to the app/ directory.

In your NetworkModule.kt or equivalent, set the BASE_URL to your local IP or deployed backend URL.

kotlin
const val BASE_URL = "http://10.0.2.2:8080/api/" // For Android Emulator
Build and run the app on an emulator or physical device.

Firebase Notification Setup
Ensure FCM is enabled in your Firebase project.

The backend uses the Firebase Admin SDK to send notifications (e.g., daily journal reminders, goal completion congratulations).

The Android app must implement FirebaseMessagingService to handle incoming data payloads and display notifications.

🧠 AI Integration Details
Journal Analysis
When a user submits a journal entry, the text is sent to the backend. The backend securely calls an LLM (Large Language Model) with a specific prompt to extract:

Detected Emotion: (e.g., Joy, Sadness, Anxiety)

Stress Level: (Low, Medium, High)

Key Themes: (e.g., Work, Family, Health, Positivity)

AI Perspective: A empathetic summary of the entry.

Suggested Action: A small, actionable tip based on the entry.

SereneAI Chatbot
The chat feature maintains context using a conversation history array. The system prompt defines the AI's persona: "You are SereneAI, a compassionate and empathetic mental health companion. You listen actively, validate feelings, and suggest grounding exercises when appropriate, but you do not diagnose or prescribe."

🤝 Contributing
Contributions are welcome! Please follow these steps:

Fork the repository.

Create a feature branch (git checkout -b feature/AmazingFeature).

Commit your changes (git commit -m 'Add some AmazingFeature').

Push to the branch (git push origin feature/AmazingFeature).

Open a Pull Request.

📄 License
This project is licensed under the MIT License - see the LICENSE file for details.

📞 Contact
Project Maintainer: [Su Wai Tun/ Sint Sint Hlaing]
Email: [suwaitun.swt2003@gmail.com]
GitHub: [https://github.com/Up-2003/]

Disclaimer: SereneMind is an AI-powered wellness tool and is not a substitute for professional medical advice, diagnosis, or treatment. Always seek the advice of your physician or other qualified health provider with any questions you may have regarding a medical condition.
