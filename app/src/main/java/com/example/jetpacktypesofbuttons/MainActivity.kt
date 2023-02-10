package com.example.jetpacktypesofbuttons

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.jetpacktypesofbuttons.ui.theme.JetPackTypesOfButtonsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackTypesOfButtonsTheme {
                Surface(color = Color.White) {
                    Column {
                        val context = LocalContext.current
                        allButtons(context)
                    }
                }
            }
        }
    }

}

@Composable
fun allButtons(context: Context) {
    Text(text = "Buttons", style = typography.titleSmall, modifier = Modifier.padding(8.dp))
    Row {
        // Create a Main Button or Normal Button
        Button(
            onClick = { Toast.makeText(context, "Click Main Button", Toast.LENGTH_LONG).show() },
            modifier = Modifier.padding(8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Main Button")
        }
        TextButton(onClick = {Toast.makeText(context, "Click Text Button", Toast.LENGTH_LONG).show() }, modifier = Modifier.padding(8.dp)) {
            Text(text = "Text Button")
        }
    }
    Row {
        // Elevated Button
        Button(
            onClick = { Toast.makeText(context, "Click Elevated Button", Toast.LENGTH_LONG).show() },
            modifier = Modifier.padding(8.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = ButtonDefaults.buttonElevation()
        ) {
            Text(text = "Elevated Button")
        }

        // Rounded Button
        Button(
            onClick = { Toast.makeText(context, "Click Rounded Button", Toast.LENGTH_LONG).show() },
            modifier = Modifier.padding(8.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(text = "Rounded")
        }

    }
    Row {
        // Outlined Button
        // add border field and set BorderStroke and its color
        OutlinedButton(
            onClick = { Toast.makeText(context, "Click Outlined Button", Toast.LENGTH_LONG).show() },
            border = BorderStroke(1.dp, Color.Red),
            modifier = Modifier.padding(8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Outlined")
        }

        // Outlined Button with icon
        // add border field and set BorderStroke and its color
        // add Icon field
        OutlinedButton(
            onClick = { Toast.makeText(context, "Click Outlined Icon Button", Toast.LENGTH_LONG).show() },
            border = BorderStroke(1.dp, Color.Red),
            modifier = Modifier.padding(8.dp), shape = RoundedCornerShape(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(text = "Outlined Icon")
        }

    }

    Row {
        // Icon Button
        // Icon on the left of text
        Button(onClick = { Toast.makeText(context, "Click Icon Button", Toast.LENGTH_LONG).show() }, modifier = Modifier.padding(8.dp), shape = RoundedCornerShape(8.dp)) {
            Row {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(text = "Icon Button")
            }
        }

        // Icon Button
        // Icon on the Right of text
        Button(onClick = {Toast.makeText(context, "Click Icon Button", Toast.LENGTH_LONG).show()}, modifier = Modifier.padding(8.dp), shape = RoundedCornerShape(8.dp)) {
            Text(text = "Icon Button")
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }

    //custom background buttons
    // create a variable mainButtonColor and define background Color and content Color
    val mainButtonColor = ButtonDefaults.buttonColors(
        Color.Magenta,
//        backgroundColor = Color.Magenta,
        contentColor = Color.Green
    )

    Row {
        Button(
            colors = mainButtonColor,
            onClick = { Toast.makeText(context, "Click Custom Colors Button", Toast.LENGTH_LONG).show() },
            modifier = Modifier.padding(8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Custom colors")
        }
    }

    Row {
        // Create variable horizontalGradient and inside color property define start and end color
        val horizontalGradient = Brush.horizontalGradient(
            colors = listOf(Color.Green, Color.Gray),
            0f,
            250f
        )
        // Horizontal gradient Button
        // Create a text and set its background to horizontalGradient that we created above
        Text(
            text = "Horizontal gradient",
            style = typography.bodyMedium.copy(color = Color.White),
            modifier = Modifier
                .padding(12.dp)
                .clickable(onClick = {Toast.makeText(context, "Click Horizontal gradient Button", Toast.LENGTH_LONG).show()})
                .clip(RoundedCornerShape(4.dp))
                .background(brush = horizontalGradient)
                .padding(12.dp)
        )

        // Create variable verticalGradient and inside color property define top and bottom color
        val verticalGradient = Brush.verticalGradient(
            colors = listOf(Color.Green, Color.Gray),
            startY = 0f,
            endY = 100f
        )
        // Vertical gradient Button
        // Create a text and set its background to verticalGradient that we created above
        Text(
            text = "Vertical gradient",
            style = typography.bodyLarge.copy(color = Color.White),
            modifier = Modifier
                .padding(12.dp)
                .clickable(onClick = {Toast.makeText(context, "Click Vertical gradient Button", Toast.LENGTH_LONG).show()})
                .clip(RoundedCornerShape(4.dp))
                .background(brush = verticalGradient)
                .padding(12.dp)
        )
    }

}

