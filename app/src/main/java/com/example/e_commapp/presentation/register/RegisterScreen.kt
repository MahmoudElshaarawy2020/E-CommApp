package com.example.e_commapp.presentation.register

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.e_commapp.R
import com.example.e_commapp.presentation.utils.CustomTextField

@Composable
fun RegisterScreen(
    navController: NavHostController,
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    //Adding font family
    val poppinsFamily = FontFamily(
        Font(R.font.poppins_regular),
        Font(R.font.poppins_medium),
        Font(R.font.poppins_semibold),
        Font(R.font.poppins_bold)
    )

    val fullName by viewModel.fullName.collectAsState()
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val passwordAgain by viewModel.passwordAgain.collectAsState()
    var isFullNameFocused by remember { mutableStateOf(false) }
    var isEmailFocused by remember { mutableStateOf(false) }
    var isPasswordAgainFocused by remember { mutableStateOf(false) }
    var isPasswordFocused by remember { mutableStateOf(false) }
    val passwordErrorMessage by viewModel.passwordErrorMessage.collectAsState()
    var emailErrorMessage =  R.string.invalid_email
    val isFullNameError by viewModel.isFullNameError.collectAsState()
    val isEmailError by viewModel.isEmailError.collectAsState()
    val isPasswordError by viewModel.isPasswordError.collectAsState()
    val isPasswordAgainError by viewModel.isPasswordAgainError.collectAsState()

//    LaunchedEffect(email, password, passwordAgain, fullName) {
//        isEmailError = email.isEmpty()
//        isPasswordError = password.isEmpty()
//        isPasswordAgainError = passwordAgain.isEmpty() || passwordAgain != password
//    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = modifier
                .padding(top = 112.dp, bottom = 16.dp)
                .size(72.dp),
            painter = painterResource(id = R.drawable.login_img),
            contentDescription = "Login image"
        )

        Text(
            text = stringResource(id = R.string.lets_get_started),
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
            color = colorResource(id = R.color.Dark_blue),
            lineHeight = 24.sp,
            fontFamily = poppinsFamily
        )
        Spacer(modifier = modifier.size(8.dp))
        Text(
            text = stringResource(id = R.string.create_new_account),
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            color = colorResource(id = R.color.light_grey),
            lineHeight = 22.sp,
            fontFamily = poppinsFamily
        )
        Spacer(modifier = modifier.size(28.dp))
        CustomTextField(
            isError = isFullNameError,
            value = fullName,
            label = stringResource(id = R.string.full_name),
            onValueChange = { viewModel.onFullNameChange(it) },
            isFocused = isFullNameFocused,
            focusedBorderColor = colorResource(id = R.color.light_blue),
            unfocusedBorderColor = colorResource(id = R.color.lighter_grey),
            cursorColor = colorResource(id = R.color.light_grey),
            leadingIcon = R.drawable.user_ic
        )

        Spacer(modifier = modifier.size(8.dp))
        CustomTextField(
            isError = isEmailError,
            errorMessage = stringResource(id = emailErrorMessage),
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
            isError = isPasswordError,
            errorMessage = stringResource(id = passwordErrorMessage),
            value = password,
            label = stringResource(id = R.string.password),
            isPassword = true,
            isEncrypted = true,
            onValueChange = { viewModel.onPasswordChange(it) },
            isFocused = isPasswordFocused,
            focusedBorderColor = colorResource(id = R.color.light_blue),
            unfocusedBorderColor = colorResource(id = R.color.lighter_grey),
            cursorColor = colorResource(id = R.color.light_grey),
            leadingIcon = R.drawable.password_ic
        )

        Spacer(modifier = modifier.size(8.dp))
        CustomTextField(
            isError = isPasswordAgainError,
            errorMessage = stringResource(id = passwordErrorMessage),
            value = passwordAgain,
            label = stringResource(id = R.string.password_again),
            isEncrypted = true,
            onValueChange = { viewModel.onPasswordAgainChange(it) },
            isFocused = isPasswordAgainFocused,
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
//                if (email.isEmpty() || password.isEmpty() || passwordAgain.isEmpty() || fullName.isEmpty()) {
//                    isError = true
//                }else if (password != passwordAgain){
//                    isError = true
//                    passwordErrorMessage =  R.string.password_does_not_match
//                }else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//                    isError = true
//                    emailErrorMessage =  R.string.invalid_email
//                }
                    viewModel.register()
            }
        ) {
            Text(
                text = stringResource(id = R.string.Sign_up),
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(id = R.color.white),
                fontSize = 14.sp,
                lineHeight = 25.sp
            )
        }
        Spacer(modifier = modifier.size(25.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.have_an_account),
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Light,
                color = colorResource(id = R.color.light_grey),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                lineHeight = 18.sp
            )

            Text(
                modifier = modifier.clickable {
                    onLoginClick()
                },
                text = stringResource(id = R.string.Sign_in),
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(id = R.color.light_blue),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                lineHeight = 18.sp
            )
        }
        
        Spacer(modifier = modifier.size(150.dp))
    }

}