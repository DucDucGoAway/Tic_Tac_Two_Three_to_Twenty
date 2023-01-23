package com.duc.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.duc.tictactoe.ui.theme.TicTacToeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Field()
                    }
                }
            }
        }
    }

var buttonColor = Color(0xFF6e6e6e)
var imageX = R.drawable.x
var imageO = R.drawable.o
var imageNone = R.drawable.none
var buttonSize = 90.dp

@Composable
fun Field() {
    var player by remember {mutableStateOf("x")}
    var turns by remember { mutableStateOf(0)}
    var list: MutableList<String> by remember { mutableStateOf(mutableListOf(""))}

    var oneA by remember { mutableStateOf("")}
    var oneB by remember { mutableStateOf("")}
    var oneC by remember { mutableStateOf("")}
    var twoA by remember { mutableStateOf("")}
    var twoB by remember { mutableStateOf("")}
    var twoC by remember { mutableStateOf("")}
    var threeA by remember { mutableStateOf("")}
    var threeB by remember { mutableStateOf("")}
    var threeC by remember { mutableStateOf("")}
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Row() {
            Button(onClick = {
                if (oneA == "") {
                    oneA = player
                    if (player == "x") {
                        player = "o"
                    } else {
                        player = "x"
                    }
                    turns++
                }
            }, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor)
            ) {
                Image(painter = when(oneA) {
                    "x"     -> painterResource(imageX)
                    "o"     -> painterResource(imageO)
                    else    -> painterResource(imageNone)
                },
                    contentDescription = oneA,
                    modifier = Modifier
                        .size(buttonSize)
                )
            }
            Button(onClick = {
                if (oneB == "") {
                    oneB = player
                    if (player == "x") {
                        player = "o"
                    } else {
                        player = "x"
                    }
                    turns++
                }
            }, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor)
            ) {
                Image(painter = when(oneB) {
                    "x"      -> painterResource(imageX)
                    "o"     -> painterResource(imageO)
                    else    -> painterResource(imageNone)
                },
                    contentDescription = oneB,
                    modifier = Modifier
                        .size(buttonSize)
                )
            }
            Button(onClick = {
                if (oneC == "") {
                    oneC = player
                    if (player == "x") {
                        player = "o"
                    } else {
                        player = "x"
                    }
                    turns++
                }
            }, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor)
            ) {
                Image(painter = when(oneC) {
                    "x"      -> painterResource(imageX)
                    "o"     -> painterResource(imageO)
                    else    -> painterResource(imageNone)
                },
                    contentDescription = oneC,
                    modifier = Modifier
                        .size(buttonSize)
                )
            }
        }
        Row() {
            Button(onClick = {
                if (twoA == "") {
                    twoA = player
                    if (player == "x") {
                        player = "o"
                    } else {
                        player = "x"
                    }
                    turns++
                }
            }, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor)
            ) {
                Image(painter = when(twoA) {
                    "x"      -> painterResource(imageX)
                    "o"     -> painterResource(imageO)
                    else    -> painterResource(imageNone)
                },
                    contentDescription = twoA,
                    modifier = Modifier
                        .size(buttonSize)
                )
            }
            Button(onClick = {
                if (twoB == "") {
                    twoB = player
                    if (player == "x") {
                        player = "o"
                    } else {
                        player = "x"
                    }
                    turns++
                }
            }, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor)
            ) {
                Image(painter = when(twoB) {
                    "x"      -> painterResource(imageX)
                    "o"     -> painterResource(imageO)
                    else    -> painterResource(imageNone)
                },
                    contentDescription = twoB,
                    modifier = Modifier
                        .size(buttonSize)
                )
            }
            Button(onClick = {
                if (twoC == "") {
                    twoC = player
                    if (player == "x") {
                        player = "o"
                    } else {
                        player = "x"
                    }
                    turns++
                }
            }, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor)
            ) {
                Image(painter = when(twoC) {
                    "x"      -> painterResource(imageX)
                    "o"     -> painterResource(imageO)
                    else    -> painterResource(imageNone)
                },
                    contentDescription = twoC,
                    modifier = Modifier
                        .size(buttonSize)
                )
            }
        }
        Row() {
            Button(onClick = {
                if (threeA == "") {
                    threeA = player
                    if (player == "x") {
                        player = "o"
                    } else {
                        player = "x"
                    }
                    turns++
                }
            }, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor)
            ) {
                Image(painter = when(threeA) {
                    "x"      -> painterResource(imageX)
                    "o"     -> painterResource(imageO)
                    else    -> painterResource(imageNone)
                },
                    contentDescription = threeA,
                    modifier = Modifier
                        .size(buttonSize)
                )
            }
            Button(onClick = {
                if (threeB == "") {
                    threeB = player
                    if (player == "x") {
                        player = "o"
                    } else {
                        player = "x"
                    }
                    turns++
                }
            }, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor)
            ) {
                Image(painter = when(threeB) {
                    "x"      -> painterResource(imageX)
                    "o"     -> painterResource(imageO)
                    else    -> painterResource(imageNone)
                },
                    contentDescription = threeB,
                    modifier = Modifier
                        .size(buttonSize)
                )
            }
            Button(onClick = {
                if (threeC == "") {
                    threeC = player
                    if (player == "x") {
                        player = "o"
                    } else {
                        player = "x"
                    }
                    turns++
                }
            }, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor)
            ) {
                Image(painter = when(threeC) {
                    "x"      -> painterResource(imageX)
                    "o"     -> painterResource(imageO)
                    else    -> painterResource(imageNone)
                },
                    contentDescription = threeC,
                    modifier = Modifier
                        .size(buttonSize)
                )
            }
        }
        var winner = "placeholder"                      //placeholder here
        Text(
            text = if(turns != 9) {
            "player $player turn"} else {
                "$winner wins"                    //placeholder here
            },
            fontSize = 50.sp
        )
        Spacer(modifier = Modifier.size(20.dp))
        Button(onClick = {
            oneA = ""; oneB = ""; oneC = ""
            twoA = ""; twoB = ""; twoC = ""
            threeA = ""; threeB = ""; threeC = ""
            turns = 0
            player = "x"
        },
            modifier = Modifier
                .width(150.dp)
                .height(70.dp)
        )
        {
            Text(
                text = "restart",
                fontSize = 24.sp
            )
        }
    }
}