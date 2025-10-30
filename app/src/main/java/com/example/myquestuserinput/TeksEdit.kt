package com.example.myquestuserinput

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

}