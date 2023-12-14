package me.adipiscing_elit.hewahbnb.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.adipiscing_elit.hewahbnb.data.model.House
import me.adipiscing_elit.hewahbnb.ui.components.PopularHouseCard
import me.adipiscing_elit.hewahbnb.ui.components.RecommendedHouseCard

@Composable
fun HomeScreenContent(
    houses: List<House>,
    innerPadding: PaddingValues
) {
    LazyColumn(contentPadding = innerPadding) {
        item {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Most Popular", style = MaterialTheme.typography.titleLarge)

                TextButton(
                    onClick = {}
                ) {
                    Text(
                        text = "View more",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFFF82500)
                    )
                }
            }
        }
        item {
            LazyRow(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)) {
                itemsIndexed(houses) { index, house ->
                    PopularHouseCard(
                        house = house,
                        isFavorite = true,
                        onAddToFavouritesClicked = {}
                    )
                }
            }
        }

        item {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Recommended", style = MaterialTheme.typography.titleLarge)

                TextButton(
                    onClick = {}
                ) {
                    Text(
                        text = "View all",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFFF82500)
                    )
                }
            }
        }

        item {
            LazyRow(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)) {
                itemsIndexed(houses) { index, house ->
                    RecommendedHouseCard(
                        house = house,
                        isFavorite = false,
                        onAddToFavouritesClicked = {}
                    )
                }
            }
        }
    }

}