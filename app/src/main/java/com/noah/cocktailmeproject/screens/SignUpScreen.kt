package com.noah.cocktailmeproject.screens

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.OAuthProvider
import com.noah.cocktailmeproject.MainActivity
import com.noah.cocktailmeproject.R
import com.noah.cocktailmeproject.destinations.Destination

/**
 * A composable function for the sign up screen.
 *
 * @param context the app context.
 * @param modifier modifier for the composables.
 * @param navController the navController for the app
 */
@Composable
fun SignUpScreen(context: Context, modifier: Modifier, navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var visibility by remember { mutableStateOf(false) }
    var visibilityIcon = if (visibility) painterResource(id = R.drawable.visible)
        else painterResource(id = R.drawable.not_visible)
    var passwordVisibility = if (visibility) VisualTransformation.None
        else PasswordVisualTransformation()
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome to Cocktail Me",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Please enter an email and password to create a new account",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            label = { Text("Password") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            visualTransformation = passwordVisibility,
            trailingIcon = {
                Icon(painter = visibilityIcon,
                    contentDescription = "visibility icon",
                    modifier = modifier.clickable { visibility = !visibility  }
                )
            }
        )
        Button(
            onClick = {
                isLoading = true
                signUp(email, password, context, keyboardController)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Sign Up")
        }
        Button(
            onClick = { navController.navigate(Destination.SignIn.route){
                popUpTo(Destination.SignIn.route)
                launchSingleTop = true
            }},
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Sign In")
        }
    }
}

/**
 * A function for the sign up process
 *
 * @param email the email of the user.
 * @param password the password of the user.
 * @param context the app context.
 * @param keyboardController the keyboard controller.
 */
private fun signUp(
    email: String,
    password: String,
    context: Context,
    keyboardController: SoftwareKeyboardController?
) {
    val auth = FirebaseAuth.getInstance()
    try {
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {

                    val intent = Intent(context, MainActivity::class.java)
                    Toast.makeText(context, "Sign up Successful!", Toast.LENGTH_SHORT).show()
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    intent.putExtra("userID", FirebaseAuth.getInstance().currentUser?.uid)
                    context.startActivity(intent)

            } else {
                Toast.makeText(context, "Sign Up Failed", Toast.LENGTH_SHORT).show()
            }
            keyboardController?.hide()
        }
    }catch(e: Exception){Toast.makeText(context, "Sign Up Failed", Toast.LENGTH_SHORT).show()}
}


