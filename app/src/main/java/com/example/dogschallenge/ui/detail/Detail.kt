package com.example.dogschallenge.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.example.dogschallenge.R
import com.example.dogschallenge.models.Dog
import com.example.dogschallenge.ui.home.perrasos


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Detail( navController: NavController, id: Int){
    val dog = perrasos.find { d -> d.id == id } as Dog

    Column {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.Rounded.ArrowBack, contentDescription = "Go back"
            )
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(vertical = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            )  {

                Box(modifier = Modifier
                    .height(200.dp)){
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(dog.imageUrl)
                            .crossfade(true)
                            .transformations(CircleCropTransformation())
                            .build(),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.height(25.dp))
                Text(text = dog.name, color = Color.White, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(25.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(0.5f),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = stringResource(R.string.otros_datos), color = Color.White)
                    Text(text = "|", color = Color.White)
                    Text(text = stringResource(R.string.mas_datos), color = Color.White)
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun DetailPreview(){
    Detail(navController = rememberNavController(), id = 4 )
}

