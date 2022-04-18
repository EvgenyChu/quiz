package com.template.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.template.R

val robotoMedium = FontFamily(Font(R.font.roboto_medium))
val robotoRegular = FontFamily(Font(R.font.roboto_regular))
val robotoLight = FontFamily(Font(R.font.roboto_light))

fun MyTypography() = Typography(
    h1 = TextStyle(
        fontFamily = robotoMedium,
        fontSize = 56.sp,
        color = primaryText
    ),
    h2 = TextStyle(
        fontFamily = robotoMedium,
        fontSize = 18.sp,
        color = primaryText
    ),
    h3 = TextStyle(
        fontFamily = robotoMedium,
        fontSize = 16.sp,
        color = primaryText
    ),
    h4 = TextStyle(
        fontFamily = robotoMedium,
        fontSize = 16.sp,
        color = primaryText
    ),
    h5 = TextStyle(
        fontFamily = robotoMedium,
        fontSize = 14.sp,
        color = primaryText
    ),
    h6 = TextStyle(
        fontFamily = robotoMedium,
        fontSize = 14.sp,
        color = accentColor
    ),
    subtitle1 = TextStyle(
        fontFamily = robotoRegular,
        fontSize = 12.sp,
        color = primaryText
    ),

    body2 = TextStyle(
        fontFamily = robotoLight,
        fontSize = 14.sp,
        color = primaryText
    ),
    caption = TextStyle(
        fontFamily = robotoLight,
        fontSize = 13.sp,
        color = primaryText
    ),
    button = TextStyle(
        fontFamily = robotoMedium,
        fontSize = 24.sp,
        color = primaryText
    )
)