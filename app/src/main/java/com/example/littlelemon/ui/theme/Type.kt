package com.example.littlelemon.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R

val makarzi = FontFamily(
    Font(R.font.makarzi_regular),
    Font(R.font.makarzi_semibold, weight = FontWeight.SemiBold),
    Font(R.font.makazi_bold, weight = FontWeight.Bold),
    Font(R.font.makazi_medium, weight = FontWeight.Medium),

)

val karla = FontFamily(
    Font(R.font.karla_extra_light, weight = FontWeight.ExtraLight),
    Font(R.font.karla_extra_light_italic, weight = FontWeight.ExtraLight, style = FontStyle.Italic),
    Font(R.font.karla_light, weight = FontWeight.Light),
    Font(R.font.karla_light_italic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(R.font.karla_regular),
    Font(R.font.karla_italic,  style = FontStyle.Italic),
    Font(R.font.karla_bold, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(R.font.karla_semibold, weight = FontWeight.SemiBold),
    Font(R.font.karla_semibold_italic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
    Font(R.font.karla_medium, weight = FontWeight.Medium),
    Font(R.font.karla_medium_italic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(R.font.karla_semibold, weight = FontWeight.SemiBold),
    Font(R.font.karla_semibold_italic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
    Font(R.font.karla_extra_bold, weight = FontWeight.ExtraBold),
    Font(R.font.karla_extra_bold, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = makarzi,
        fontSize = 57.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 64.sp
    ),
    displayMedium = TextStyle(
        fontFamily = makarzi,
        fontSize = 45.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 52.sp
    ),
    displaySmall = TextStyle(
        fontFamily = makarzi,
        fontSize = 36.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 44.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = makarzi,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 28.sp,
        lineHeight = 36.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp,
        lineHeight = 32.sp
    ),
    titleLarge = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),
    titleMedium = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    titleSmall = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,

    ),

    bodyMedium = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,

    ),
    bodySmall = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        ),



    labelLarge = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),

    labelMedium = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),

    labelSmall = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 16.sp
    )
)