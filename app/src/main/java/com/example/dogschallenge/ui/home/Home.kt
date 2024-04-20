package com.example.dogschallenge.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dogschallenge.models.Dog
import com.example.dogschallenge.navigation.MainDestinations
import com.example.dogschallenge.ui.components.ItemList


public val perrasos = listOf(
    Dog(1, "Sabueso Afgano", "https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg"),
    Dog(2, "Sabueso Basset", "https://images.dog.ceo/breeds/hound-basset/n02088238_10005.jpg"),
    Dog(3, "Sabueso Sangre", "https://images.dog.ceo/breeds/hound-blood/n02088466_10083.jpg"),
    Dog(4, "Sabueso Ingles", "https://images.dog.ceo/breeds/hound-english/n02089973_1030.jpg"),
    Dog(5, "Sabueso Ibizan", "https://images.dog.ceo/breeds/hound-ibizan/n02091244_1496.jpg"),
    Dog(6, "Sabueso Afgano", "https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg"),
    Dog(7, "Sabueso Afgano", "https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg"),
    Dog(8, "Sabueso Basset", "https://images.dog.ceo/breeds/hound-basset/n02088238_10005.jpg"),
    Dog(9, "Sabueso Sangre", "https://images.dog.ceo/breeds/hound-blood/n02088466_10083.jpg"),
    Dog(10, "Sabueso Ingles", "https://images.dog.ceo/breeds/hound-english/n02089973_1030.jpg"),
    Dog(11, "Sabueso Ibizan", "https://images.dog.ceo/breeds/hound-ibizan/n02091244_1496.jpg"),
    Dog(12, "Sabueso Afgano", "https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg"),
    Dog(13, "Sabueso Afgano", "https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg"),
    Dog(14, "Sabueso Basset", "https://images.dog.ceo/breeds/hound-basset/n02088238_10005.jpg"),
    Dog(15, "Sabueso Sangre", "https://images.dog.ceo/breeds/hound-blood/n02088466_10083.jpg"),
    Dog(16, "Sabueso Ingles", "https://images.dog.ceo/breeds/hound-english/n02089973_1030.jpg"),
    Dog(17, "Sabueso Ibizan", "https://images.dog.ceo/breeds/hound-ibizan/n02091244_1496.jpg"),
    Dog(18, "Sabueso Afgano", "https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg")
)


@Composable
fun Home(navController: NavController){
    DogsList(perrasos, navController )
}



@Composable
fun DogsList(dogs: List<Dog>,navController: NavController){
    LazyColumn(  modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)) {
        items(dogs) { dog ->
            Box(modifier = Modifier.clickable {
                navController.navigate(MainDestinations.DETAIL_ROUTE + "/${dog.id}")
            }) {
                ItemList(dog.name)
            }
        }
    }
}


@Preview( showSystemUi = true)
@Composable
fun DogsListPreview() {

}