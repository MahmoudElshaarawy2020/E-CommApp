package com.example.e_commapp.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.e_commapp.R
import com.example.e_commapp.presentation.utils.CustomTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavHostController,
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    //Adding font family
    val poppinsFamily = FontFamily(
        Font(R.font.poppins_regular),
        Font(R.font.poppins_medium),
        Font(R.font.poppins_semibold),
        Font(R.font.poppins_bold)
    )

    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    var isEmailFocused by remember { mutableStateOf(false) }
    var isPasswordFocused by remember { mutableStateOf(false) }
    val errorMessage = stringResource(id = R.string.login_error_message)
    val isError by viewModel.isError.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = modifier
                .padding(top = 112.dp, bottom = 16.dp)
                .size(72.dp),
            painter = painterResource(id = R.drawable.login_img),
            contentDescription = "Login image"
        )

        Text(
            text = stringResource(id = R.string.Welcome),
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
            color = colorResource(id = R.color.Dark_blue),
            lineHeight = 24.sp,
            fontFamily = poppinsFamily
        )
        Spacer(modifier = modifier.size(8.dp))
        Text(
            text = stringResource(id = R.string.Sign_in_to_continue),
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            color = colorResource(id = R.color.light_grey),
            lineHeight = 22.sp,
            fontFamily = poppinsFamily
        )
        Spacer(modifier = modifier.size(28.dp))
        CustomTextField(
            isError = isError,
            value = email,
            label = stringResource(id = R.string.your_email),
            onValueChange = { viewModel.onEmailChange(it) },
            isFocused = isEmailFocused,
            focusedBorderColor = colorResource(id = R.color.light_blue),
            unfocusedBorderColor = colorResource(id = R.color.lighter_grey),
            cursorColor = colorResource(id = R.color.light_grey),
            leadingIcon = R.drawable.email_ic
        )

        Spacer(modifier = modifier.size(8.dp))
        CustomTextField(
            isError = isError,
            errorMessage = errorMessage,
            value = password,
            label = stringResource(id = R.string.password),
            isPassword = true,
            onValueChange = { viewModel.onPasswordChange(it) },
            isFocused = isPasswordFocused,
            focusedBorderColor = colorResource(id = R.color.light_blue),
            unfocusedBorderColor = colorResource(id = R.color.lighter_grey),
            cursorColor = colorResource(id = R.color.light_grey),
            leadingIcon = R.drawable.password_ic
        )

        Spacer(modifier = modifier.size(16.dp))

        Button(
            modifier = modifier.size(width = 343.dp, height = 57.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.light_blue)),
            shape = RoundedCornerShape(8.dp),
            onClick = {
                viewModel.onLoginClick()
            }
        ) {
            Text(
                text = stringResource(id = R.string.Sign_in),
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(id = R.color.white),
                fontSize = 14.sp,
                lineHeight = 25.sp
            )
        }
        Spacer(modifier = modifier.size(21.dp))
        Box(
            modifier = modifier
                .size(width = 340.dp, height = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Divider(
                color = Color.LightGray,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                modifier = Modifier
                    .background(Color.White)
                    .width(50.dp),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.or),
                color = colorResource(id = R.color.light_grey),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFamily,
            )
        }

        Spacer(modifier = modifier.size(21.dp))
        Button(
            modifier = modifier
                .size(width = 343.dp, height = 57.dp)
                .border(1.dp, colorResource(id = R.color.lighter_grey), RoundedCornerShape(8.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            shape = RoundedCornerShape(8.dp),
            onClick = {},
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.google_ic),
                    contentDescription = "Google Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )

                Text(
                    modifier = Modifier.width(277.dp),
                    text = stringResource(id = R.string.Login_with_Google),
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.light_grey),
                    fontSize = 14.sp,
                    lineHeight = 25.sp
                )
            }
        }


        Spacer(modifier = modifier.size(16.dp))

        Button(
            modifier = modifier
                .size(width = 343.dp, height = 57.dp)
                .border(1.dp, colorResource(id = R.color.lighter_grey), RoundedCornerShape(8.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            shape = RoundedCornerShape(8.dp),
            onClick = {}
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.facebook_ic),
                    contentDescription = "Google Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )

                Text(
                    modifier = Modifier.width(277.dp),
                    text = stringResource(id = R.string.Login_with_facebook),
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.ExtraBold,
                    color = colorResource(id = R.color.light_grey),
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    lineHeight = 25.sp
                )
            }
        }
        Spacer(modifier = modifier.size(16.dp))
        Text(
            modifier = modifier.clickable { },
            text = stringResource(id = R.string.forgot_password),
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.ExtraBold,
            color = colorResource(id = R.color.light_blue),
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            lineHeight = 18.sp
        )

        Spacer(modifier = modifier.size(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.do_not_have_account),
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Light,
                color = colorResource(id = R.color.light_grey),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                lineHeight = 18.sp
            )

            Text(
                modifier = modifier.clickable {
                    onRegisterClick()
                },
                text = stringResource(id = R.string.register),
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(id = R.color.light_blue),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                lineHeight = 18.sp
            )
        }
    }
}

