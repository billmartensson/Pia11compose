package se.magictechnology.pia11compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import se.magictechnology.pia11compose.ui.theme.Fingul
import se.magictechnology.pia11compose.ui.theme.Pia11composeTheme
import se.magictechnology.pia11compose.ui.theme.Teal200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pia11composeTheme {
// A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        Greeting("Bartil", "Bartilsson")
                        Text(text = "Mera text")
                        Fancylist()
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, lastname : String) {

    var fancymessage by remember { mutableStateOf("Hej") }

    var fintext = Modifier.padding(20.dp)

    Column(modifier = Modifier.background(Fingul).padding(25.dp)) {
        Text(text = "Hello $name!")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Tjena $lastname!")

        Text(text = "Hepp",
            modifier = fintext,
            color = Color.Red)

        Row(modifier = Modifier.background(Color.LightGray).fillMaxWidth()) {
            Text("AAAAA", modifier = Modifier.weight(1f).background(Color.Red))
            Text("BBBBB", modifier = Modifier.weight(3f).background(Color.Green))
        }

        Text(fancymessage)

        Button(onClick = {
            fancymessage = "Banan"
        }) {
            Text("Klicka här")
        }
    }

}

@Composable
fun Fancylist() {

    //var fruits = mutableStateListOf("")

    var fruits = mutableListOf<String>("Apelsin", "Banan")
    
    Column {
        Button(onClick = {
            fruits.add("Kiwi")
        }) {
            Text("Lägg till")
        }

        LazyColumn {
            items(fruits.toList()) {
                Text(it)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Pia11composeTheme {
        Column {
            Greeting("Bartil", "Bartilsson")
            Text(text = "Mera text")
            Fancylist()
        }
    }
}