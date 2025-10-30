package com.example.myquestuserinput

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Divider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import java.lang.reflect.Modifier

@Composable
fun FormDataDiri(modifier: Modifier
){
    //variabel-variabel untuk mengingat nilai masukan dari keybord
    var textNama by remember { mutableStateOf(value = "")}
    var textAlamat by remember { mutableStateOf(value = "")}
    var textJK by remember { mutableStateOf(value = "")}

    //variabel-variabel untuk menyimpan data yang diperoleh dari komponen UI
    var nama by remember { mutableStateOf(value = "")}
    var alamat by remember { mutableStateOf(value = "")}
    var jk by remember { mutableStateOf(value = "")}

    val gender: List<String> = listOf("Laki-laki", "Perempuan")

    Column { modifier = Modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(
                value = textNama,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.width(widht = 250.dp),
                label = { Text(text = "Nama Lengkap") },
                onValueChange = {
                    textNama = it
                }
        }
        Row {
            gender.forEach { item ->
                Row {modifier = Modifier.selectable(
                    selected = textJK == item,
                    onClick = {
                        textJK = item
                    }

                ), verticalAlignment = Alignment.CenterVertically
                    {
                        RadioButton(
                            selected = textJK == item,
                            onClick = {
                                textJK = item
                            }
                        )
                        Text(text = item)
                    }
                }
            }

        }
        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier.width(widht = 250.dp),
            label = { Text(text = "Alamat Lengkap") },
            onValueChange = {
                textAlamat = it
            }
        )
        Divider(
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium), top = dimensionResource(
                = 30.dp
            )),
            thickness = dimensionResource(R.dimen.divider_tipis),
            color = Color.DarkGray
        )
        Button(
            modifier = Modifier.fillMaxWidth(fraction = 1f),
            // the button is enabled when the user makes a selection
            enabled = textAlamat.isNotEmpty(),
            onClick = {
                nama = textNama
                alamat = textAlamat
                jk = textJK
            }
        )


    }
}