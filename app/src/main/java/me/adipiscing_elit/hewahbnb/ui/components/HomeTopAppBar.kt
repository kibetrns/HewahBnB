package me.adipiscing_elit.hewahbnb.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import me.adipiscing_elit.hewahbnb.R
import me.adipiscing_elit.hewahbnb.util.SearchAppBarState
import me.adipiscing_elit.hewahbnb.util.TONAL_ELEVATION
import me.adipiscing_elit.hewahbnb.util.TOP_APP_BAR_HEIGHT
import me.adipiscing_elit.hewahbnb.util.TrailingIconState
import me.adipiscing_elit.hewahbnb.viewmodel.HBViewModel

@Composable
fun HomeTopAppBar(
    searchAppBarState: SearchAppBarState,
    searchTextState: String,
    hbViewModel: HBViewModel
) {
    when(searchAppBarState) {
        SearchAppBarState.CLOSED  -> {
            DefaultHomeTopAppBar(
                onSearchIconClicked = {
                    hbViewModel.searchAppBarState.value = SearchAppBarState.OPENED
                },
                onFilterIconClicked = {
                    hbViewModel.searchAppBarState.value = SearchAppBarState.CLOSED
                    hbViewModel.searchTextState.value = ""
                }
            )
        }
        else -> {
            SearchAppBar(
                text = searchTextState,
                onTextChange = { newText ->
                    hbViewModel.searchTextState.value = newText
                },
                onCloseClicked = {
                    hbViewModel.searchAppBarState.value = SearchAppBarState.CLOSED
                    hbViewModel.searchTextState.value = ""
                },
                onSearchIconClicked = {
                    hbViewModel.searchAppBarState.value = SearchAppBarState.TRIGGERED
                    hbViewModel.fetchSearchedHouses(it)
                }
            )
        }
    }

    
}


@Composable
fun DefaultHomeTopAppBar(
    onSearchIconClicked: () -> Unit,
    onFilterIconClicked: () -> Unit
    
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Column {
            Text(text = stringResource(id = R.string.location))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = stringResource(id = R.string.location_icon),
                    tint = Color(0xFFD20000),
                    modifier = Modifier
                        .size(16.dp)
                )

                //TODO("Make this dynamic")
                Text(
                    text = "Mweiga, Kenya",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
        ) {
            IconButton(
                modifier = Modifier
                    .padding(horizontal = 4.dp),
                onClick = onSearchIconClicked

            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(id = R.string.search_icon),

                )
            }

            //TODO("Do the screen that would be shown when the filter icon is clicked")
            IconButton(
                onClick = onFilterIconClicked

            ) {
                Icon(
                    imageVector = Icons.Default.FilterAlt,
                    contentDescription = stringResource(id = R.string.filter_icon),

                )
            }
        }
    }
    
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchIconClicked: (String) -> Unit
) {
    var trailingIconState by remember { mutableStateOf(TrailingIconState.READY_TO_DELETE)}


    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_APP_BAR_HEIGHT),
        tonalElevation = TONAL_ELEVATION,


        ) {
        TextField(
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.seach_by_location),
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .alpha(0.8f)
                )
            },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.onBackground,
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(id = R.string.search_icon)
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        when(trailingIconState){
                            TrailingIconState.READY_TO_DELETE -> {
                                onTextChange("")
                                trailingIconState = TrailingIconState.READY_TO_CLOSE
                            }
                            TrailingIconState.READY_TO_CLOSE -> {
                                if (text.isNotEmpty()){
                                    onTextChange("")
                                } else {
                                    onCloseClicked()
                                    trailingIconState = TrailingIconState.READY_TO_DELETE
                                }
                            }
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(id = R.string.close_icon)
                    )

                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchIconClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )
    }


}