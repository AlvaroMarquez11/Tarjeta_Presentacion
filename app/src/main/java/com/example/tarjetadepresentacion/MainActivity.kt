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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
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
                    TarjetaPersonal(
                        "671234859",
                        "Alvaro.Marquezes",
                        "Alvaro@gmail.com",
                        "Álvaro Márquez",
                        "Estudiante de Informática",
                        "IES virgen de la Paloma",
                        "2ºCurso de DAM ",
                        "Madrid"
                    )
                }
            }
        }
    }
}

@Composable
fun TarjetaPersonal(
    telefono: String, pagina: String, email: String,
    nombre: String, estudio: String, instituto: String,
    curso: String, ciudad: String, modifier: Modifier = Modifier
) {
    val image1 = painterResource(R.drawable.descarga)
    val image2 = painterResource(R.drawable.fondotp)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(153, 217, 234, 255))
            .padding(20.dp)
    )

    {

        Image(
            painter = image2,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
        )

        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(20.dp)
                .align(Alignment.BottomCenter)
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.BottomCenter)

            ) {
                Row {
                    TextInformacion(
                        texto1 = "\uD83D\uDCDE",
                        texto2 = telefono,
                        modifier = modifier
                    )
                }
                Row {
                    TextInformacion(
                        texto1 = "\uD83C\uDF10",
                        texto2 = pagina,
                        modifier = modifier
                    )
                }
                Row {
                    Text(
                        text = "📧  $email",
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        fontSize = 21.sp
                    )
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
                    painter = image1,
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
                        text = nombre,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        fontSize = 20.sp,
                        modifier = modifier
                            .padding(15.dp)
                            .fillMaxWidth()
                    )
                }
                Row {
                    Text(
                        text = ciudad,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        fontSize = 20.sp,
                        modifier = modifier
                            .padding(15.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.CenterStart)
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.CenterStart),

                ) {
                Row {
                    TextInformacion(texto1 = "Información Personal", modifier = modifier)
                }
                Row {
                    TextInformacion(texto1 = estudio, modifier = modifier)
                }
                Row {
                    TextInformacion(texto1 = instituto, modifier = modifier)
                }
                Row {
                    TextInformacion(texto1 = curso, modifier = modifier)
                }
            }
        }
    }
}

@Composable
fun TextInformacion(texto1: String, texto2: String, modifier: Modifier) {
    Text(
        text = "$texto1  $texto2",
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Serif,
        fontSize = 22.sp
    )
}

@Composable
fun TextInformacion(texto1: String, modifier: Modifier) {
    Text(
        text = texto1,
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Serif,
        fontSize = 20.sp
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TarjetaDePresentacionTheme {
        TarjetaPersonal(
            "671 234 859",
            "AlvaroMarquez.es",
            "Alvaro@gmail.com",
            "Álvaro Márquez Santamaría",
            "Estudiante de informática",
            "IES virgen de la Paloma",
            "2º Curso de DAM ",
            "Madrid"
        )
    }
}