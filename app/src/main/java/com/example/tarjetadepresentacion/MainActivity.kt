package com.example.tarjetadepresentacion

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
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
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
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
                        "  671 234 859",
                        "marquez_valdee",
                        " a.marquez.santamaria@gmail.com",
                        "Álvaro Márquez Santamaría",
                        "Estudiante de informática",
                        "IES virgen de la Paloma",
                        "2º Curso de DAM ",
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
    curso: String, ciudad: String
) {
    BoxWithConstraints(Modifier.fillMaxSize()) {
        if (maxWidth < 500.dp) {
            TarjetaPersonalVertical(
                telefono,
                pagina,
                email,
                nombre,
                estudio,
                instituto,
                curso,
                ciudad
            )
        } else {
            TarjetaPersonalHorizontal(
                telefono,
                pagina,
                email,
                nombre,
                estudio,
                instituto,
                curso,
                ciudad
            )
        }
    }
}

@Composable
fun TarjetaPersonalHorizontal(
    telefono: String, pagina: String, email: String,
    nombre: String, estudio: String, instituto: String,
    curso: String, ciudad: String, modifier: Modifier = Modifier
) {
    val fotoPerfil = painterResource(R.drawable.descarga)
    val imgTelefono = painterResource(R.drawable.telefono)
    val insta = painterResource(R.drawable.insta)
    val imgEmail = painterResource(R.drawable.email)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(153, 217, 234, 255))
            .padding(20.dp)
    )
    {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(20.dp)
        ) {
            Column(modifier = modifier.align(alignment = Alignment.CenterStart)) {
                Row {
                    Image(
                        painter = fotoPerfil,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape)
                    )
                }

                Row {
                    Text(
                        text = "$ciudad|Spain",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        modifier = modifier.padding(
                            top = 20.dp,
                            start = 5.dp
                        )
                    )
                }


            }
            Column(
                modifier = Modifier
                    .align(alignment = Alignment.TopCenter)
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .align(alignment = Alignment.End)
                ) {
                    Text(
                        text = nombre,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        fontSize = 40.sp,
                        modifier = modifier.padding(start = 120.dp)
                    )
                }
                Row(modifier = modifier.align(alignment = Alignment.CenterHorizontally))
                {
                    Column(
                        modifier = modifier
                            .padding(
                                start = 85.dp,
                                top = 20.dp
                            )
                    )
                    {
                        Row {
                            Text(
                                text = estudio,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Serif,
                                fontSize = 20.sp,
                                modifier = modifier
                                    .padding(
                                        top = 28.dp,
                                        start = 30.dp
                                    )
                            )
                        }
                        Row {
                            Text(
                                text = instituto,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Serif,
                                fontSize = 20.sp,
                                modifier = modifier
                                    .padding(
                                        top = 28.dp,
                                        start = 30.dp
                                    )
                            )
                        }
                        Row {
                            Text(
                                text = curso,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Serif,
                                fontSize = 20.sp,
                                modifier = modifier
                                    .padding(
                                        top = 30.dp,
                                        start = 30.dp
                                    )
                            )
                        }
                    }

                    Column(modifier = modifier.padding(top = 20.dp))
                    {
                        Row(
                            modifier = modifier
                                .align(alignment = Alignment.End)
                                .padding(top = 15.dp)
                        ) {
                            
                            BotonNumeroHorizontal(telefono = telefono)
                            
                            Image(
                                painter = imgTelefono,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(40.dp)
                                    .align(alignment = Alignment.CenterVertically)
                                    .padding(start = 15.dp, top = 5.dp)
                            )

                        }

                        Row(
                            modifier = modifier
                                .align(alignment = Alignment.End)
                                .padding(top = 15.dp)
                        ) {

                            Text(
                                text = pagina,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Serif,
                                fontSize = 20.sp,
                                modifier = modifier
                                    .padding(
                                        start = 30.dp,
                                        top = 10.dp
                                    )
                            )
                            Image(
                                painter = insta,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(40.dp)
                                    .align(alignment = Alignment.CenterVertically)
                                    .padding(start = 15.dp, top = 5.dp)
                            )

                        }

                        Row(
                            modifier = modifier
                                .align(alignment = Alignment.End)
                                .padding(top = 15.dp)
                        ) {
/*
                            Text(
                                text = email,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Serif,
                                fontSize = 20.sp,
                                modifier = modifier
                                    .padding(
                                        start = 30.dp,
                                        top = 10.dp
                                    )
                            )*/

                            BotonEmailHorizontal()

                            Image(
                                painter = imgEmail,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(40.dp)
                                    .align(alignment = Alignment.CenterVertically)
                                    .padding(start = 15.dp, top = 5.dp)
                            )
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun BotonNumeroHorizontal(telefono: String) {
    val numeroTelefono = telefono
    val localContext = LocalContext.current
    TextButton(onClick = {
        val textPhone = "tel: $numeroTelefono"
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse(textPhone)
        startActivity(localContext, intent, null)
    }) {
        Text(
            text = numeroTelefono,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(
                    start = 30.dp,
                    top = 10.dp
                )
        )

    }
}

@Composable
fun BotonNumeroVertical(telefono: String) {
    val numeroTelefono = telefono
    val localContext = LocalContext.current
    TextButton(onClick = {
        val textPhone = "tel: $numeroTelefono"
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse(textPhone)
        startActivity(localContext, intent, null)
    }) {
        Text(
            text = numeroTelefono,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp
        )

    }
}

@Composable
fun BotonInstagram(instagram: String) {
    val linkInstagram = instagram
    val localContext = LocalContext.current
    TextButton(onClick = {
        val textInsta = "https://www.instagram.com/$instagram/"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(textInsta)
        startActivity(localContext, intent, null)
    }) {
        Text(
            text = linkInstagram,
            modifier = Modifier
                .fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp
            
        )

    }
}

@Composable
fun BotonInstagramHorizontal(instagram: String) {
    val linkInstagram = instagram
    val localContext = LocalContext.current
    TextButton(onClick = {
        val textInsta = "https://www.instagram.com/$instagram/"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(textInsta)
        startActivity(localContext, intent, null)
    }) {
        Text(
            text = linkInstagram,
            modifier = Modifier
                .fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp

        )

    }
}

@Composable
fun BotonEmail(email: String) {
    val email: String = email
    val localContext = LocalContext.current
    TextButton(onClick = {
        val intentMail = Intent(Intent.ACTION_SEND, Uri.parse(email))
        intentMail.type = "plain/text"
        intentMail.putExtra(Intent.EXTRA_SUBJECT, "titulo del mail")
        intentMail.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        startActivity(localContext, intentMail, null)
    }) {
        Text(
            text = email,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp

        )
    }
}

@Composable
fun BotonEmailHorizontal() {
    val linkEmail = "a.marquez@gmail.com"
    val localContext = LocalContext.current
    TextButton(onClick = {
        val intentMail = Intent(Intent.ACTION_SEND, Uri.parse(linkEmail))
        intentMail.type = "plain/text"
        intentMail.putExtra(Intent.EXTRA_SUBJECT, "titulo del mail")
        intentMail.putExtra(Intent.EXTRA_EMAIL, arrayOf("a.marquez.santamaria@gmail.com"))
        startActivity(localContext, intentMail, null)
    }) {
        Text(
            text = linkEmail,
            modifier = Modifier
                .fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp

        )
    }
}

@Composable
fun TarjetaPersonalVertical(
    telefono: String, pagina: String, email: String,
    nombre: String, estudio: String, instituto: String,
    curso: String, ciudad: String, modifier: Modifier = Modifier
) {
    val fotoPerfil = painterResource(R.drawable.descarga)
    val fondo = painterResource(R.drawable.fondotp)
    val imgTelefono = painterResource(R.drawable.telefono)
    val insta = painterResource(R.drawable.insta)
    val imgEmail = painterResource(R.drawable.email)


    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(153, 217, 234, 255))
            .padding(20.dp)
    )

    {

        Image(
            painter = fondo,
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

                    Image(
                        painter = imgTelefono,
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .align(alignment = Alignment.CenterVertically)
                            .padding(5.dp)
                    )

                    BotonNumeroVertical(telefono = telefono)
                }
                Row(
                    Modifier.align(alignment = Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = insta,
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                            .align(alignment = Alignment.CenterVertically)
                            .padding(end = 18.dp)
                    )

                    BotonInstagram(instagram = pagina)
                }
                Row {

                    Image(
                        painter = imgEmail,
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .align(alignment = Alignment.CenterVertically)
                            .padding(5.dp)
                    )

                    BotonEmail(email = email)
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
                    painter = fotoPerfil,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .padding(start = 12.dp)
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
fun TextInformacion(texto1: String, modifier: Modifier = Modifier) {
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
        TarjetaPersonalVertical(
            "  671 234 859",
            "Alvaro_Marquez",
            " Alvaro@gmail.com",
            "Álvaro Márquez Santamaría",
            "Estudiante de informática",
            "IES virgen de la Paloma",
            "2º Curso de DAM ",
            "Madrid"
        )
    }
}