package com.example.whatsappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappui.ui.theme.WhatsappUITheme

// ------------------------------------------------------------
// VARIABLES GLOBALES (se conservan dentro de este archivo
// para que puedas reemplazar directamente tu InfoActivity.kt)
// ------------------------------------------------------------
val WaGreen = Color(0xFF008069)
val WaGreenLight = Color(0xFF25D366)
val WaBubbleOut = Color(0xFFD9FDD3)
val WaBubbleIn = Color(0xFFFFFFFF)
val WaChatBackground = Color(0xFFEFEAE2)
val WaTextPrimary = Color(0xFF111B21)
val WaTextSecondary = Color(0xFF667781)
val WaTickBlue = Color(0xFF53BDEB)
val WaRed = Color(0xFFEA0038)

private val WaDivider = Color(0xFFE7E9E9)

object WaDimens {
    val SpaceXs = 4.dp
    val SpaceSm = 8.dp
    val SpaceMd = 16.dp
    val SpaceLg = 24.dp
    val SpaceXl = 32.dp
    val AvatarSmall = 40.dp
    val AvatarMedium = 52.dp
    val AvatarLarge = 120.dp
    val IconSize = 24.dp
    val ButtonHeight = 48.dp
    val ScreenPadding = 16.dp
    val RadiusSmall = 8.dp
    val RadiusMedium = 16.dp
    val RadiusLarge = 24.dp
}

object WaTextSizes {
    val Small = 12.sp
    val Body = 14.sp
    val Subtitle = 16.sp
    val Title = 20.sp
    val Heading = 24.sp
}

val AppTypography = Typography(
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = WaTextSizes.Small,
        lineHeight = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = WaTextSizes.Body,
        lineHeight = 20.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = WaTextSizes.Subtitle,
        lineHeight = 24.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = WaTextSizes.Subtitle,
        lineHeight = 24.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = WaTextSizes.Title,
        lineHeight = 28.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = WaTextSizes.Heading,
        lineHeight = 32.sp
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = WaTextSizes.Body,
        lineHeight = 20.sp
    )
)

val AppShapes = Shapes(
    small = RoundedCornerShape(WaDimens.RadiusSmall),
    medium = RoundedCornerShape(WaDimens.RadiusMedium),
    large = RoundedCornerShape(WaDimens.RadiusLarge)
)

// ------------------------------------------------------------
// ACTIVIDAD: se ve igual al ejecutar y en @Preview
// ------------------------------------------------------------
class InfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsappUITheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = WaChatBackground
                ) { innerPadding ->
                    PantallaInfoContacto(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PantallaInfoContacto(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(WaChatBackground)
            .verticalScroll(rememberScrollState())
    ) {
        BarraSuperior()
        CabeceraContacto()
        AccionesContacto()
        Spacer(Modifier.height(WaDimens.SpaceMd))
        TarjetaEstado()
        Spacer(Modifier.height(WaDimens.SpaceSm))
        TarjetaMultimedia()
        Spacer(Modifier.height(WaDimens.SpaceSm))
        TarjetaAjustes()
        Spacer(Modifier.height(WaDimens.SpaceSm))
        TarjetaGrupos()
        Spacer(Modifier.height(WaDimens.SpaceSm))
        TarjetaPeligro()
        Spacer(Modifier.height(WaDimens.SpaceXl))
    }
}

// ------------------------------------------------------------
// CABECERA
// ------------------------------------------------------------
@Composable
fun BarraSuperior(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .height(56.dp)
            .padding(horizontal = WaDimens.SpaceXs),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* Solo interfaz */ }) {
            IconoFlecha()
        }
        Text(
            text = "Información del contacto",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = WaTextPrimary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = { /* Solo interfaz */ }) {
            IconoTresPuntos()
        }
    }
}

@Composable
fun CabeceraContacto() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(top = 22.dp, bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Avatar temporal. Luego puedes sustituirlo por una Image.
        Box(
            modifier = Modifier
                .size(WaDimens.AvatarLarge)
                .clip(CircleShape)
                .background(WaGreen.copy(alpha = 0.15f)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "MG",
                fontSize = 40.sp,
                fontWeight = FontWeight.Medium,
                color = WaGreen
            )
        }
        Spacer(Modifier.height(WaDimens.SpaceMd))
        Text(
            text = "María González",
            fontSize = WaTextSizes.Heading,
            fontWeight = FontWeight.Bold,
            color = WaTextPrimary
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = "+591 7123 4567",
            fontSize = WaTextSizes.Subtitle,
            color = WaTextSecondary
        )
    }
}

@Composable
fun AccionesContacto() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = WaDimens.SpaceMd, end = WaDimens.SpaceMd, bottom = 18.dp),
        horizontalArrangement = Arrangement.spacedBy(WaDimens.SpaceSm)
    ) {
        BotonAccion(
            icono = R.drawable.call,
            titulo = "Llamar",
            modifier = Modifier.weight(1f)
        )
        BotonAccion(
            icono = R.drawable.videocam,
            titulo = "Video",
            modifier = Modifier.weight(1f)
        )
        BotonAccion(
            icono = R.drawable.search,
            titulo = "Buscar",
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun BotonAccion(icono: Int, titulo: String, modifier: Modifier = Modifier) {
    OutlinedButton(
        onClick = { /* Sin funcionalidad por ahora */ },
        modifier = modifier.height(76.dp),
        shape = RoundedCornerShape(WaDimens.RadiusMedium),
        border = BorderStroke(1.dp, WaDivider),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(icono),
                contentDescription = titulo,
                tint = WaGreen,
                modifier = Modifier.size(25.dp)
            )
            Spacer(Modifier.height(5.dp))
            Text(
                text = titulo,
                color = WaGreen,
                fontSize = 13.sp,
                maxLines = 1
            )
        }
    }
}

// ------------------------------------------------------------
// TARJETAS DE INFORMACIÓN
// ------------------------------------------------------------
@Composable
fun TarjetaBase(content: @Composable ColumnScope.() -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = WaDimens.SpaceSm),
        shape = RoundedCornerShape(WaDimens.RadiusMedium),
        color = Color.White
    ) {
        Column(content = content)
    }
}

@Composable
fun TarjetaEstado() {
    TarjetaBase {
        Column(Modifier.padding(WaDimens.SpaceMd)) {
            Text(
                text = "Info.",
                fontSize = WaTextSizes.Body,
                color = WaGreen,
                fontWeight = FontWeight.Medium
            )
            Spacer(Modifier.height(WaDimens.SpaceSm))
            Text(
                text = "¡Hola! Estoy usando esta aplicación.",
                fontSize = WaTextSizes.Subtitle,
                color = WaTextPrimary
            )
            Spacer(Modifier.height(6.dp))
            Text(
                text = "12 de noviembre de 2026",
                fontSize = WaTextSizes.Small,
                color = WaTextSecondary
            )
        }
    }
}

@Composable
fun TarjetaMultimedia() {
    TarjetaBase {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WaDimens.SpaceMd),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Archivos, enlaces y documentos",
                color = WaTextPrimary,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.weight(1f)
            )
            Text("12", color = WaTextSecondary, fontSize = WaTextSizes.Body)
            Spacer(Modifier.width(4.dp))
            Icon(
                painter = painterResource(R.drawable.chevron_right),
                contentDescription = null,
                tint = WaTextSecondary,
                modifier = Modifier.size(20.dp)
            )
        }
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(start = WaDimens.SpaceMd, end = WaDimens.SpaceMd, bottom = WaDimens.SpaceMd),
            horizontalArrangement = Arrangement.spacedBy(WaDimens.SpaceSm)
        ) {
            Miniatura(R.drawable.pfp, Color(0xFFE3F2EF))
            Miniatura(R.drawable.pfp, Color(0xFFDEEBF6))
            Miniatura(R.drawable.description, Color(0xFFF9E8DB))
            Miniatura(R.drawable.link_2, Color(0xFFEAE6F4))
        }
    }
}

@Composable
fun Miniatura(icono: Int, colorFondo: Color) {
    Box(
        modifier = Modifier
            .size(78.dp)
            .clip(RoundedCornerShape(WaDimens.RadiusSmall))
            .background(colorFondo),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(icono),
            contentDescription = null,
            tint = WaGreen,
            modifier = Modifier.size(30.dp)
        )
    }
}

// ------------------------------------------------------------
// OPCIONES DEL CONTACTO
// ------------------------------------------------------------
@Composable
fun TarjetaAjustes() {
    TarjetaBase {
        OpcionInfo(
            icono = R.drawable.notifications,
            titulo = "Notificaciones",
            subtitulo = "Predeterminadas"
        )
        Separador()
        OpcionInfo(
            icono = R.drawable.image,
            titulo = "Visibilidad de archivos",
            subtitulo = "Predeterminada"
        )
        Separador()
        OpcionInfo(
            icono = R.drawable.lock,
            titulo = "Cifrado",
            subtitulo = "Los mensajes y las llamadas están cifrados"
        )
        Separador()
        OpcionInfo(
            icono = R.drawable.avg_pace,
            titulo = "Mensajes temporales",
            subtitulo = "Desactivados"
        )
    }
}

@Composable
fun OpcionInfo(
    icono: Int,
    titulo: String,
    subtitulo: String? = null,
    peligro: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = WaDimens.SpaceMd, vertical = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(icono),
            contentDescription = null,
            tint = if (peligro) WaRed else WaTextSecondary,
            modifier = Modifier.size(WaDimens.IconSize)
        )
        Spacer(Modifier.width(24.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = titulo,
                color = if (peligro) WaRed else WaTextPrimary,
                fontSize = WaTextSizes.Subtitle,
                fontWeight = FontWeight.Normal
            )
            if (subtitulo != null) {
                Spacer(Modifier.height(3.dp))
                Text(
                    text = subtitulo,
                    color = WaTextSecondary,
                    fontSize = WaTextSizes.Body
                )
            }
        }
    }
}

@Composable
fun Separador() {
    HorizontalDivider(
        modifier = Modifier.padding(start = 64.dp),
        color = WaDivider,
        thickness = 1.dp
    )
}

// ------------------------------------------------------------
// GRUPOS EN COMÚN
// ------------------------------------------------------------
@Composable
fun TarjetaGrupos() {
    TarjetaBase {
        Text(
            text = "Grupos en común · 3",
            color = WaGreen,
            fontSize = WaTextSizes.Body,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(WaDimens.SpaceMd)
        )
        GrupoComun("FA", "Familia", "8 participantes", Color(0xFFD8EEE6))
        Separador()
        GrupoComun("AU", "Amigos de la universidad", "12 participantes", Color(0xFFFFECD4))
        Separador()
        GrupoComun("TR", "Trabajo", "6 participantes", Color(0xFFE3E8FF))
    }
}

@Composable
fun GrupoComun(iniciales: String, nombre: String, detalle: String, fondo: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = WaDimens.SpaceMd, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(WaDimens.AvatarMedium)
                .clip(CircleShape)
                .background(fondo),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = iniciales,
                color = WaGreen,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
        Spacer(Modifier.width(14.dp))
        Column {
            Text(
                text = nombre,
                color = WaTextPrimary,
                fontSize = WaTextSizes.Subtitle,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = detalle,
                color = WaTextSecondary,
                fontSize = WaTextSizes.Body
            )
        }
    }
}

// ------------------------------------------------------------
// OPCIONES EN ROJO
// ------------------------------------------------------------
@Composable
fun TarjetaPeligro() {
    TarjetaBase {
        OpcionInfo(
            icono = R.drawable.block,
            titulo = "Bloquear",
            peligro = true
        )
        Separador()
        OpcionInfo(
            icono = R.drawable.thumb_down,
            titulo = "Reportar",
            peligro = true
        )
    }
}

// ------------------------------------------------------------
// ÍCONOS YA REFERENCIADOS EN TU CÓDIGO
// ------------------------------------------------------------
@Composable
fun IconoFlecha() {
    Icon(
        painter = painterResource(R.drawable.arrow_back),
        contentDescription = "Volver",
        tint = WaTextPrimary,
        modifier = Modifier.size(28.dp)
    )
}

@Composable
fun IconoTresPuntos() {
    Icon(
        painter = painterResource(R.drawable.more_vert),
        contentDescription = "Más opciones",
        tint = WaTextPrimary,
        modifier = Modifier.size(28.dp)
    )
}

@Preview(showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun InfoContactoPreview() {
    WhatsappUITheme {
        PantallaInfoContacto()
    }
}
