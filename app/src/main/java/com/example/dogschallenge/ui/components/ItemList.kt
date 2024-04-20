package com.example.dogschallenge.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ItemList(name: String){
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment=Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)) {
            Text(text = name, modifier = Modifier.padding(10.dp))
            Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = "Telephone",
                modifier = Modifier.height(30.dp))

        }
    }
}

@Preview
@Composable
fun ItemListPreview(){
    ItemList("Dog Name")
}