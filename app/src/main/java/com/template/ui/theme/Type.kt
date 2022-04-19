package com.template.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.template.R

val robotoMedium = FontFamily(Font(R.font.roboto_medium))

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
        fontSize = 18.sp,
        color = textIcon
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
    )
)