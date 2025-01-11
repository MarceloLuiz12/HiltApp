package com.example.hiltapp.feature_address

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: AddressViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val address = viewModel.address
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var cep by remember { mutableStateOf("") }

                TextField(
                    value = cep,
                    onValueChange = { cep = it },
                    label = { Text("Digite o CEP") }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { viewModel.fetchAddress(cep) }) {
                    Text(text = "Buscar")
                }
                Spacer(modifier = Modifier.height(16.dp))
                address?.let {
                    Text("Endereço: ${it.street}, ${it.neighborhood}, ${it.city} - ${it.state}")
                }
            }
        }
    }
}

