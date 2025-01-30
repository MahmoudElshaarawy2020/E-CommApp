package com.example.e_commapp.presentation.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.e_commapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle.Default,
    textColor: Color = colorResource(id = R.color.light_grey),
    focusedBorderColor: Color,
    unfocusedBorderColor: Color,
    cursorColor: Color,
    leadingIcon: Int,
    isFocused: Boolean,
    maxLines: Int = 1,
    isPassword: Boolean = false,
    isError: Boolean = false,
    errorMessage: String = ""
) {

    var isFieldFocused by remember { mutableStateOf(isFocused) }

    Column {
        OutlinedTextField(
            modifier = modifier
                .size(width = 343.dp, height = 48.dp)
                .onFocusChanged { focusState -> isFieldFocused = focusState.isFocused },
            value = value,
            onValueChange = onValueChange,
            maxLines = maxLines,
            textStyle = textStyle.copy(
                color = textColor
            ),
            visualTransformation = if (!isPassword) VisualTransformation.None else PasswordVisualTransformation(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = if (isError) Color.Red else focusedBorderColor,
                unfocusedBorderColor = if (isError) Color.Red else unfocusedBorderColor,
                cursorColor = cursorColor
            ),
            leadingIcon = {
                Icon(
                    modifier = modifier
                        .size(24.dp),
                    painter = painterResource(id = leadingIcon),
                    contentDescription = "Person Icon",
                    tint = if (isFieldFocused){
                        colorResource(id = R.color.light_blue)
                    } else if(isError){
                        Color.Red
                    }else{
                        colorResource(id = R.color.light_grey)
                    }
                )
            },
            isError = isError
        )

        if (isError) {
            Text(
                text = errorMessage,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }
    }
}