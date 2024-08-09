package com.example.lanceart.ui.telas

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lanceart.R
import com.example.lanceart.ui.objetos.ObraDeArte



@Composable
fun CardObra(obraDeArte: Int, titulo: String, artista: String, ano: String){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(obraDeArte),
                contentDescription = titulo,
                modifier = Modifier.size(200.dp))
            Text(text = "Titulo: ${titulo}", fontSize = 18.sp, color = MaterialTheme.colorScheme.onSurface);
            Text(text = "Artista: ${artista}", fontSize = 18.sp, color = MaterialTheme.colorScheme.onSurface);
            Text(text = "Ano: ${ano}", fontSize = 18.sp, color = MaterialTheme.colorScheme.onSurface);

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = { }, modifier = Modifier.fillMaxWidth()) {
                Text("Dar um lance")
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaInicial(modifier: Modifier = Modifier,
                onOffClick: () -> Unit
) {
    val obras = listOf(
        ObraDeArte(R.drawable.pexels_steve_1109352, "Alegria", "Alencar Amorim", "2020"),
        ObraDeArte(R.drawable.pexels_steve_1183992, "Cores do mundo", "Poliana Prado", "2010"),
        ObraDeArte(R.drawable.pexels_zaksheuskaya_709412_1568607, "ColorHouse", "Mariana Oliveira","2022" ))

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("LanceArt")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Home, contentDescription = "Localized description")
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Filled.AccountCircle,
                            contentDescription = "Localized description",
                        )
                    }
                    Button(onClick = { onOffClick }, modifier = Modifier.fillMaxWidth()) {
                        Text("Sair")
                    }
                },
            )
        },
    )
    {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text(
            text = "Bem-vindo ao Leilão de Artes",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(24.dp))

        CardObra(obras[0].imagem, obras[0].titulo,obras[0].artista, obras[0].ano);
//        CardObra(obras[1].imagem, obras[1].titulo,obras[1].artista, obras[1].ano);
//        CardObra(obras[2].imagem, obras[2].titulo,obras[2].artista, obras[2].ano);
        }
    }

}