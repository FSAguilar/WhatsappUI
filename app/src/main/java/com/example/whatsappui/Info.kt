package com.example.whatsappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappui.ui.theme.WhatsappUITheme

private val WaGreen = Color(0xFF008069)
private val WaBackground = Color(0xFFF0F2F5)
private val WaTextPrimary = Color(0xFF111B21)
private val WaTextSecondary = Color(0xFF667781)
private val WaDivider = Color(0xFFE9EDEF)
private val WaRed = Color(0xFFD70040)

class InfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsappUITheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = WaBackground
                ) { innerPadding ->
                    PantallaInfoContacto(
                        onBack = ::finish,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PantallaInfoContacto(
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(WaBackground)
            .verticalScroll(rememberScrollState())
    ) {
        CabeceraContacto(onBack)
        AccionesContacto()
        SeparacionSeccion()
        FilaMultimedia()
        SeparacionSeccion()
        SeccionAjustesPrincipales()
        SeparacionSeccion()
        SeccionPrivacidad()
        SeparacionSeccion()
        SeccionFavoritos()
        SeparacionSeccion()
        SeccionGrupos()
        SeparacionSeccion()
        SeccionPeligro()
        Spacer(Modifier.height(32.dp))
    }
}

@Composable
private fun CabeceraContacto(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(bottom = 22.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    painter = painterResource(R.drawable.arrow_back),
                    contentDescription = "Volver",
                    tint = WaTextPrimary,
                    modifier = Modifier.size(28.dp)
                )
            }
            Spacer(Modifier.weight(1f))
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.more_vert),
                    contentDescription = "Más opciones",
                    tint = WaTextPrimary,
                    modifier = Modifier.size(28.dp)
                )
            }
        }

        Image(
            painter = painterResource(R.drawable.pfp),
            contentDescription = "Foto de perfil de María González",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(132.dp)
                .clip(CircleShape)
        )
        Spacer(Modifier.height(14.dp))
        Text(
            text = "María González",
            color = WaTextPrimary,
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(Modifier.height(3.dp))
        Text(
            text = "+591 7123 4567",
            color = WaTextSecondary,
            fontSize = 16.sp
        )
    }
}

@Composable
private fun AccionesContacto() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(bottom = 18.dp),
        horizontalArrangement = Arrangement.spacedBy(28.dp, Alignment.CenterHorizontally)
    ) {
        BotonAccion(R.drawable.call, "Voz")
        BotonAccion(R.drawable.videocam, "Video")
        BotonAccion(R.drawable.search, "Buscar")
    }
}

@Composable
private fun BotonAccion(icono: Int, titulo: String) {
    Column(
        modifier = Modifier.width(62.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedButton(
            onClick = {},
            modifier = Modifier.size(58.dp),
            shape = CircleShape,
            border = BorderStroke(1.dp, WaDivider),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White)
        ) {
            Icon(
                painter = painterResource(icono),
                contentDescription = titulo,
                tint = WaGreen,
                modifier = Modifier.size(25.dp)
            )
        }
        Spacer(Modifier.height(6.dp))
        Text(
            text = titulo,
            color = WaGreen,
            fontSize = 13.sp,
            maxLines = 1
        )
    }
}

@Composable
private fun FilaMultimedia() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 18.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Archivos, enlaces y documentos",
                color = WaTextPrimary,
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )
            Text(text = "7", color = WaTextSecondary, fontSize = 14.sp)
            Spacer(Modifier.width(8.dp))
            Icon(
                painter = painterResource(R.drawable.chevron_right),
                contentDescription = "Abrir archivos compartidos",
                tint = WaTextSecondary,
                modifier = Modifier.size(20.dp)
            )
        }
        Spacer(Modifier.height(14.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(5) { index ->
                Image(
                    painter = painterResource(R.drawable.pfp),
                    contentDescription = "Archivo compartido ${index + 1}",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(width = 96.dp, height = 88.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            }
        }
    }
}

@Composable
private fun SeccionAjustesPrincipales() {
    Column(Modifier.background(Color.White)) {
        OpcionInfo(R.drawable.image, "Administrar almacenamiento", "1,6 MB")
        OpcionInfo(R.drawable.image, "Visibilidad de archivos", "Predeterminada")
        OpcionInfo(R.drawable.notifications, "Notificaciones", "Predeterminadas")
    }
}

@Composable
private fun SeccionPrivacidad() {
    Column(Modifier.background(Color.White)) {
        OpcionInfo(R.drawable.avg_pace, "Mensajes temporales", "Desactivados")
        OpcionInfo(
            icono = R.drawable.lock,
            titulo = "Bloqueo de chat",
            subtitulo = "Bloquea y oculta este chat en este dispositivo.",
            control = { SwitchWhatsApp() }
        )
        OpcionInfo(R.drawable.block, "Chat restringido", "Desactivado")
        OpcionInfo(
            R.drawable.link_2,
            "Cifrado",
            "Los mensajes y las llamadas están cifrados"
        )
        OpcionInfo(
            icono = R.drawable.chat_info,
            titulo = "Traducir mensajes",
            subtitulo = "Desactivado",
            control = { SwitchWhatsApp() }
        )
    }
}

@Composable
private fun SeccionFavoritos() {
    Column(Modifier.background(Color.White)) {
        OpcionInfo(R.drawable.thumb_down, "Eliminar de Favoritos")
    }
}

@Composable
private fun SeccionGrupos() {
    val grupos = listOf(
        Triple("FA", "Familia", "8 participantes"),
        Triple("AU", "Amigos de la universidad", "12 participantes"),
        Triple("TR", "Trabajo", "6 participantes"),
        Triple("FU", "Fútbol del domingo", "10 participantes"),
        Triple("VE", "Vecinos", "18 participantes")
    )
    var expandido by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = "${grupos.size} grupos en común",
            color = WaGreen,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 10.dp)
        )
        (if (expandido) grupos else grupos.take(3)).forEach { (iniciales, nombre, detalle) ->
            GrupoComun(iniciales, nombre, detalle)
        }
        TextButton(
            onClick = { expandido = !expandido },
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 68.dp)
        ) {
            Text(
                text = if (expandido) "Ver menos" else "Ver ${grupos.size - 3} grupos más",
                color = WaGreen
            )
        }
    }
}

@Composable
private fun GrupoComun(iniciales: String, nombre: String, detalle: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color(0xFFD9FDD3)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = iniciales,
                color = WaGreen,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(Modifier.width(16.dp))
        Column {
            Text(text = nombre, color = WaTextPrimary, fontSize = 16.sp)
            Text(text = detalle, color = WaTextSecondary, fontSize = 14.sp)
        }
    }
}

@Composable
private fun SeccionPeligro() {
    Column(Modifier.background(Color.White)) {
        OpcionInfo(R.drawable.block, "Bloquear a María", peligro = true)
        OpcionInfo(R.drawable.thumb_down, "Reportar a María", peligro = true)
        OpcionInfo(R.drawable.block, "Vaciar chat", peligro = true)
    }
}

@Composable
private fun OpcionInfo(
    icono: Int,
    titulo: String,
    subtitulo: String? = null,
    peligro: Boolean = false,
    control: (@Composable () -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 20.dp, top = 17.dp, bottom = 17.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(icono),
            contentDescription = null,
            tint = if (peligro) WaRed else WaTextSecondary,
            modifier = Modifier.size(25.dp)
        )
        Spacer(Modifier.width(28.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = titulo,
                color = if (peligro) WaRed else WaTextPrimary,
                fontSize = 16.sp,
                lineHeight = 20.sp
            )
            if (subtitulo != null) {
                Spacer(Modifier.height(2.dp))
                Text(
                    text = subtitulo,
                    color = WaTextSecondary,
                    fontSize = 14.sp,
                    lineHeight = 18.sp
                )
            }
        }
        if (control != null) {
            Spacer(Modifier.width(12.dp))
            control()
        }
    }
}

@Composable
private fun SwitchWhatsApp() {
    Switch(
        checked = false,
        onCheckedChange = {},
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.White,
            checkedTrackColor = WaGreen,
            uncheckedThumbColor = Color.White,
            uncheckedTrackColor = Color(0xFF9DA5A8),
            uncheckedBorderColor = Color(0xFF9DA5A8)
        )
    )
}

@Composable
private fun SeparacionSeccion() {
    HorizontalDivider(color = WaDivider, thickness = 8.dp)
}

@Preview(showBackground = true, widthDp = 393, heightDp = 852)
@Composable
private fun InfoContactoPreview() {
    WhatsappUITheme {
        PantallaInfoContacto()
    }
}
