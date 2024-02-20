package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.constants.Movie
import com.example.myapplication.constants.MovieList
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           AppLayout {
                MainContent()
           }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppLayout(content: @Composable () -> Unit) {
    MyApplicationTheme {
       Scaffold(
           modifier = Modifier.fillMaxSize(),
           containerColor = Color.LightGray,
           topBar = {
               CenterAlignedTopAppBar(
                   colors = topAppBarColors(
                       containerColor = MaterialTheme.colorScheme.primaryContainer,
                       titleContentColor = MaterialTheme.colorScheme.primary
                   ),
                   title = { Text(text = "Welcome") },
                   actions = {
                       IconButton(
                           onClick = { /*TODO*/ }
                       ) {
                           Icon(
                               imageVector = Icons.Default.AccountCircle,
                               contentDescription = "Account",
                               modifier = Modifier
                                   .size(128.dp)
                           )
                       }
                   },
                   navigationIcon = {
                       Icon(
                           imageVector = Icons.Filled.Menu,
                           contentDescription = "Menu",
                           modifier = Modifier
                               .padding(start = 10.dp)
                           )
                   }
               )
           },
           floatingActionButton = {
               FloatingActionButton(onClick = { /*TODO*/ }) {
                   Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
               }
           }
       ) { innerPadding ->
           Column(
               modifier = Modifier
                   .padding(innerPadding)
           ) {
                content()
           }
       }
    }
}

@Composable
fun MainContent(movieList: List<Movie> = MovieList) {
    Column(modifier = Modifier
        .padding(12.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    Log.d("TAG", "Content: $movie")
                }
            }
        }
    }
}

@Composable
fun MovieRow(movie: Movie, onItemClick: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(bottom = 4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                onItemClick(movie.title)
            },
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                color = Color.Transparent) {
                Icon(imageVector = Icons.Filled.AccountBox,
                    contentDescription = "Image",
                )
            }
            Text(text = movie.title)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    AppLayout {
        MainContent()
    }
}