package com.example.tarjetadepresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjetadepresentacion.ui.theme.TarjetaDePresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarjetaDePresentacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TarjetaPersonal("671234859",
                        "Alvaro.es",
                        "Alvaro.marquez@gmail.com",
                        "Álvaro Márquez",
                        "Estudiante \n IES virgen de la Paloma \n 2ºCurso de DAM ")
                }
            }
        }
    }
}

@Composable
fun TarjetaPersonal(telefono: String, pagina:String, email: String,
                    nombre: String, info:String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.descarga)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(90, 200, 255, 255))
            .padding(20.dp)
    )

    {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(20.dp)
                .align(Alignment.BottomCenter)
        ) {
            Column (
                modifier = modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
                    .align(Alignment.BottomCenter)

                ) {
                Row {
                    TextInformacion(texto1 = "\uD83D\uDCDE", texto2 = telefono, modifier = modifier)
                }
                Row {
                    TextInformacion(texto1 = "\uD83C\uDF10", texto2 = pagina, modifier = modifier)
                }
                Row {
                    TextInformacion(texto1 = "📧", texto2 = email, modifier = modifier)
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.TopCenter)
        ) {
            Column {
                Image(
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                )
            }
            Column {
                Row {
                    Text(
                        text = "Álvaro Márquez Santamaria",
                        fontSize = 20.sp,
                        modifier = modifier
                            .background(Color.White)
                            .padding(15.dp)
                            .fillMaxWidth()
                    )
                }
                Row {
                    Text(
                        text = "Madrid",
                        fontSize = 20.sp,
                        modifier = modifier
                            .background(Color.White)
                            .padding(15.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(20.dp)
                .align(Alignment.CenterStart)) {
            Column (
                modifier = modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
                    .align(Alignment.CenterStart),

                ) {
                Row {
                    TextInformacion(texto1 = "Información Personal", texto2 = info, modifier = modifier)
                }
            }
        }
    }
}

@Composable
fun TextInformacion(texto1: String, texto2: String, modifier: Modifier) {
    Text(
        text = "$texto1 \t $texto2",
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TarjetaDePresentacionTheme {
        TarjetaPersonal("671234859",
            "Alvaro.Marquezes",
            "Alvaro@gmail.com",
            "Álvaro Márquez",
            "Estudiante de Informática \nIES virgen de la Paloma \n2ºCurso de DAM ")
    }
}