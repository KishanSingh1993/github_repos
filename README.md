📦 GitHub Repos App
A modern Android application to display repositories of a specific GitHub user. This project demonstrates the usage of Hilt for Dependency Injection, MVVM architecture, Retrofit for API calls, LiveData & ViewModel, and Pagination with RecyclerView.

✨ Features
Fetches repositories of a specified GitHub user.
Displays repository details such as:
Repository name
Description
Programming language
Star count
Fork count
Supports pagination for loading more repositories when scrolling.
Swipe-to-refresh support.
Clean architecture using MVVM + Repository Pattern.
Handles loading, success, and error states using a sealed Resource class.
🛠️ Tech Stack
Kotlin
Hilt - Dependency Injection
MVVM - Architecture Pattern
Retrofit - Networking Library
Coroutines & Flow - For asynchronous data flow
LiveData - For observing data in UI
RecyclerView - For displaying lists
SwipeRefreshLayout - For pull-to-refresh
Navigation Component - For fragment navigation
📱 Screenshots
List View
📂 Project Structure

com.kishan.githubreposapp
├── di                  // Hilt module for providing dependencies
├── model               // Data classes for API responses
├── network             // Retrofit service & API configurations
├── repository          // Repository layer for fetching data
├── ui                  // UI Layer - Activities, Fragments, Adapters
├── util                 // Utility classes (Pagination, Resource handling)
├── viewmodel            // ViewModel for data handling
🚀 How to Run
Clone the repository.
git clone https://github.com/yourusername/GithubReposApp.git
Open the project in Android Studio.
Add your desired GitHub username in RepoListFragment.kt.

Build and run the project.
🔧 API Reference
This project uses the following GitHub REST API endpoint:

https://api.github.com/users/{username}/repos
Replace {username} with the desired GitHub username.
Supports pagination via ?page query parameter.
🏗️ Dependencies
Key dependencies used in the project:

// Hilt
implementation "com.google.dagger:hilt-android:2.50"
kapt "com.google.dagger:hilt-compiler:2.50"

// Retrofit
implementation "com.squareup.retrofit2:retrofit:2.9.0"
implementation "com.squareup.retrofit2:converter-gson:2.9.0"

// Coroutines
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3"
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3"

// Lifecycle
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2"
implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.6.2"

// Navigation Component
implementation "androidx.navigation:navigation-fragment-ktx:2.7.6"
implementation "androidx.navigation:navigation-ui-ktx:2.7.6"

// RecyclerView & SwipeRefresh
implementation "androidx.recyclerview:recyclerview:1.3.2"
implementation "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

🙌 Credits
Developed by Kishan
You can find me on GitHub or LinkedIn

