package me.adipiscing_elit.hewahbnb.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.adipiscing_elit.hewahbnb.R
import me.adipiscing_elit.hewahbnb.data.model.RatingScore

@Composable
fun RatingScoreDropDown(
    ratingScore: RatingScore,
    onRatingScoreSelected:(RatingScore) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val angle: Float by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f, label = ""
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 16.dp)
            .background(MaterialTheme.colorScheme.background)
            .height(32.dp)
            .clickable { expanded = true }
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSurface,
                shape = MaterialTheme.shapes.small
            )
    ) {
        Text(
            text = ratingScore.name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(start = 8.dp)
//                .weight(8f)
        )
        IconButton(
            onClick = { expanded = true },
            modifier = Modifier
                .alpha(ContentAlpha.medium)
                .rotate( degrees = angle)
//                .weight(1.5f)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = stringResource(id = R.string.dropDownIcon),
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth(fraction = 0.94f)
            ) {
                DropdownMenuItem(
                    text = { RatingScoreItem(ratingScore = RatingScore.ONE)},
                    onClick = {
                    expanded = false
                    onRatingScoreSelected(RatingScore.ONE)
                }
                )

                DropdownMenuItem(
                    text = { RatingScoreItem(ratingScore = RatingScore.TWO)},
                    onClick = {
                        expanded = false
                        onRatingScoreSelected(RatingScore.TWO)
                    }
                )

                DropdownMenuItem(
                    text = { RatingScoreItem(ratingScore = RatingScore.THREE)},
                    onClick = {
                        expanded = false
                        onRatingScoreSelected(RatingScore.THREE)
                    }
                )

                DropdownMenuItem(
                    text = { RatingScoreItem(ratingScore = RatingScore.FOUR)},
                    onClick = {
                        expanded = false
                        onRatingScoreSelected(RatingScore.FOUR)
                    }
                )

                DropdownMenuItem(
                    text = { RatingScoreItem(ratingScore = RatingScore.FIVE)},
                    onClick = {
                        expanded = false
                        onRatingScoreSelected(RatingScore.FIVE)
                    }
                )

            }
        }

    }
}


@Composable
fun RatingScoreItem(ratingScore: RatingScore) {
    Text(
        modifier = Modifier
            .padding(start = 8.dp),
        text = ratingScore.name,
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.onSurface
    )
}
