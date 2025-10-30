package com.example.myquestuserinput

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {

    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jk by remember { mutableStateOf("") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")

    Column(

        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Nama Lengkap") },
            onValueChange = {
                textNama = it
            }
        )

        Spacer(modifier = Modifier.height(16.dp)) // Memberi jarak


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly // Menyebar opsi gender
        ) {
            gender.forEach { item ->
                Row(
                    modifier = Modifier.selectable(
                        selected = (textJK == item),
                        onClick = { textJK = item }
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (textJK == item),
                        onClick = { textJK = item }
                    )
                    Text(text = item)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp)) // Memberi jarak

        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(), // Menggunakan fillMaxWidth
            label = { Text(text = "Alamat Lengkap") },
            onValueChange = {
                textAlamat = it
            }
        )

        Spacer(modifier = Modifier.height(32.dp)) // Jarak sebelum tombol

        Button(
            modifier = Modifier.fillMaxWidth(),
            enabled = textNama.isNotEmpty() && textAlamat.isNotEmpty() && textJK.isNotEmpty(),
            onClick = {
                nama = textNama
                alamat = textAlamat
                jk = textJK
            }
        ) {
            Text(text = stringResource(R.string.submit))
        }
        Divider(
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium), top = dimensionResource(
                R.dimen.padding_medium
            )),
            thickness = dimensionResource(R.dimen.divider_tipis),
            color = Color.DarkGray
        )

        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            modifier = Modifier
                .height(100.dp)
                .width(300.dp)
        ) {
            Column (modifier = Modifier.padding(horizontal = 5.dp, vertical = 15.dp),){
                Text(text = "Nama: $nama", color = Color.White)
                Text(text = "Jenis Kelamin: $jk", color = Color.White)
                Text(text = "Alamat: $alamat", color = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        if (nama.isNotEmpty()){
            Spacer(modifier = Modifier.height(24.dp))
            Divider(thickness = 1.dp, color = Color.Gray)
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Nama: $nama")
            Text(text = "Jenis Kelamin: $jk")
            Text(text = "Alamat: $alamat")
        }
    }
}
