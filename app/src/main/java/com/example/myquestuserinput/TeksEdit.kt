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
fun FormDataDiri(modifier: Modifier = Modifier) { // Memberi nilai default pada modifier
    // Variabel-variabel untuk mengingat nilai masukan dari keyboard
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }

    // Variabel-variabel untuk menyimpan data yang diperoleh setelah tombol ditekan
    // (Sebenarnya variabel ini tidak wajib jika data akan langsung dikirim ke tempat lain)
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jk by remember { mutableStateOf("") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")

    Column(
        // PERBAIKAN: Modifier ditempatkan di dalam kurung Column
        modifier = modifier
            .fillMaxSize() // Memenuhi layar
            .padding(horizontal = 16.dp), // Padding kiri dan kanan
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(), // Menggunakan fillMaxWidth agar lebih responsif
            label = { Text(text = "Nama Lengkap") },
            onValueChange = {
                textNama = it
            }
        )

        Spacer(modifier = Modifier.height(16.dp)) // Memberi jarak

        // PERBAIKAN: Tata letak RadioButton yang benar
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
            // Tombol aktif jika semua input tidak kosong
            enabled = textNama.isNotEmpty() && textAlamat.isNotEmpty() && textJK.isNotEmpty(),
            onClick = {
                nama = textNama
                alamat = textAlamat
                jk = textJK
                // Di sini Anda bisa menambahkan logika lain, seperti navigasi atau menampilkan data
            }
        ) {
            Text(text = stringResource(R.string.submit))
        }

        // Contoh untuk menampilkan data yang sudah disubmit (opsional)
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
