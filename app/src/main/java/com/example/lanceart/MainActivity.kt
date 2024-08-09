package com.example.lanceart

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lanceart.ui.telas.TelaCadastro
import com.example.lanceart.ui.telas.TelaLogin
import com.example.lanceart.ui.telas.TelaInicial
import com.example.lanceart.ui.theme.LanceArtTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LanceArtTheme {
                Scaffold() {
                    AppNavigator()
                }
            }
        }
    }

    @Composable
    fun AppNavigator() {
        val navController: NavHostController = rememberNavController()

        NavHost(navController = navController, startDestination = "login") {
            composable("login") {
                TelaLogin(
                    onSignInClick = { navController.navigate("inicial") },
                    onNavigateToCadastro = { navController.navigate("cadastro") }
                )
            }
            composable("cadastro") {
                TelaCadastro(
                    onSignUpClick = { navController.navigate("login") }
                )
            }
            composable("inicial") {
                TelaInicial(onOffClick = { navController.navigate("login") })
            }
        }
    }
}