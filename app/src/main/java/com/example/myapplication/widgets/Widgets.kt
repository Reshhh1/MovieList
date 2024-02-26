package com.example.myapplication.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.constants.Movie
import com.example.myapplication.constants.getMovies


@Composable
@Preview
fun MovieRow(movie: Movie = getMovies()[1],
             onItemClick: (String) -> Unit = {}
) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(bottom = 4.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(movie.title)
            },
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                color = Color.Transparent
            ) {
                Icon(imageVector = Icons.Filled.AccountBox,
                    contentDescription = "Image",
                )
            }
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .width(200.dp)
                    .fillMaxWidth()
            ) {
                Text(text = movie.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Released: ${movie.year}",
                    style = MaterialTheme.typography.bodySmall)

                AnimatedVisibility(
                    visible = isExpanded
                ) {
                    Column(
                        modifier = Modifier
                            .width(150.dp)
                    ) {
                        Divider(modifier = Modifier.padding(4.dp))
                        Text(buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colorScheme.onBackground,
                                    fontSize = 13.sp
                                )
                            ) {
                                append("Description:")
                            }
                        })
                        Text(buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colorScheme.onBackground,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Light
                                )
                            ) {
                                append(movie.description)
                            }
                        })
                    }
                }
                Icon(imageVector = if(isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Down",
                    modifier = Modifier
                        .size(25.dp)
                        .align(Alignment.End)
                        .clickable { isExpanded = !isExpanded }
                )
            }
        }
    }
}