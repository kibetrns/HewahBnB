package me.adipiscing_elit.hewahbnb.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import me.adipiscing_elit.hewahbnb.R
import me.adipiscing_elit.hewahbnb.data.model.House

@Composable
fun RecommendedHouseCard(
    house: House,
    isFavorite: Boolean,
    onAddToFavouritesClicked: () -> Unit
) {

    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 0.dp)
            .size(width = 300.dp, height = 600.dp)
    ) {

        HouseImageContainer(
            house = house,
            isFavorite = isFavorite,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.Unspecified,
                    shape = MaterialTheme.shapes.medium.copy(
                        bottomEnd = CornerSize(32.dp),
                        bottomStart = CornerSize(32.dp),
                        topEnd = CornerSize(32.dp),
                        topStart = CornerSize(32.dp)
                    ),
                ),
            onAddToFavouritesClicked = onAddToFavouritesClicked
        )

        Column(modifier = Modifier.padding(vertical = 8.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = house.name,
                    style = MaterialTheme.typography.titleMedium,
                )

                Text(
                    text = "KES ${house.amount}",
                    color = Color(0xFFF82500),
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Spacer(
                Modifier
                    .height(8.dp)
                    .padding(8.dp)
            )

            Text(text = house.locationName, style = MaterialTheme.typography.labelLarge)

        }
    }
}