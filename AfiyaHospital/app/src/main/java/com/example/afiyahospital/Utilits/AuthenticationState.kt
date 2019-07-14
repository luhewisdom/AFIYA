package com.example.afiyahospital.Utilits

enum class AuthenticationState {
    AUTHENTICATED,          // Initial state, the user needs to authenticate
    UNAUTHENTICATED,        // The user has authenticated successfully
    INVALID_AUTHENTICATION,  // Authentication failed
    EXPIRED_TOKEN           //Token has expired but user is still logged in
}