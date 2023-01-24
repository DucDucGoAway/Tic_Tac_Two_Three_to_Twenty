@file:OptIn(ExperimentalFoundationApi::class)

package com.duc.tictactoe

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
/*
var imageX = R.drawable.x
var imageO = R.drawable.o
var imageNone = R.drawable.none
 */
var buttonSize = 80.sp

@SuppressLint("SuspiciousIndentation")
@Composable
fun Field() {
    var player by remember { mutableStateOf("x") }
    var turns by remember { mutableStateOf(0) }
    var done = false

    val list = remember { mutableStateListOf("", "", "", "", "", "", "", "", "") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(3)
        ) {
            itemsIndexed(list) { index, s ->
                Button(
                    onClick = {
                        if (done == false) {
                            if (list[index] == "") {
                                list[index] = player
                                if (player == "x") {
                                    player = "o"
                                } else {
                                    player = "x"
                                }
                                turns++
                            }
                        }
                    }, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor)
                ) {
                    Text(
                        text = list[index],
                        fontSize = buttonSize,
                        color = Color.Red
                    )
                    /*
                    Image(
                        painter = when (list[index]) {
                            "x" -> painterResource(imageX)
                            "o" -> painterResource(imageO)
                            else -> painterResource(imageNone)
                        },
                        contentDescription = list[index],
                         modifier = Modifier
                            .size(buttonSize)
                    )
                     */
                }
            }
        }

        /*
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
            Row {
                Button(onClick = {
                    if (done == false) {
                        if (oneA == "") {
                            oneA = player
                            if (player == "x") {
                                player = "o"
                            } else {
                                player = "x"
                            }
                            turns++
                        }
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
                    if (done == false) {
                        if (oneB == "") {
                            oneB = player
                            if (player == "x") {
                                player = "o"
                            } else {
                                player = "x"
                            }
                            turns++
                        }
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
                    if (done == false) {
                        if (oneC == "") {
                            oneC = player
                            if (player == "x") {
                                player = "o"
                            } else {
                                player = "x"
                            }
                            turns++
                        }
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
                    if (done == false) {
                        if (twoA == "") {
                            twoA = player
                            if (player == "x") {
                                player = "o"
                            } else {
                                player = "x"
                            }
                            turns++
                        }
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
                    if (done == false) {
                        if (twoB == "") {
                            twoB = player
                            if (player == "x") {
                                player = "o"
                            } else {
                                player = "x"
                            }
                            turns++
                        }
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
                    if (done == false) {
                        if (twoC == "") {
                            twoC = player
                            if (player == "x") {
                                player = "o"
                            } else {
                                player = "x"
                            }
                            turns++
                        }
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
                    if (done == false) {
                        if (threeA == "") {
                            threeA = player
                            if (player == "x") {
                                player = "o"
                            } else {
                                player = "x"
                            }
                            turns++
                        }
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
                    if (done == false) {
                        if (threeB == "") {
                            threeB = player
                            if (player == "x") {
                                player = "o"
                            } else {
                                player = "x"
                            }
                            turns++
                        }
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
                    if (done == false) {
                        if (threeC == "") {
                            threeC = player
                            if (player == "x") {
                                player = "o"
                            } else {
                                player = "x"
                            }
                            turns++
                        }
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
            */

        val winCombinations = listOf(
            listOf(list[0], list[1], list[2]),
            listOf(list[0], list[4], list[8]),
            listOf(list[0], list[3], list[6]),
            listOf(list[1], list[4], list[7]),
            listOf(list[2], list[5], list[8]),
            listOf(list[2], list[4], list[6]),
            listOf(list[3], list[4], list[5]),
            listOf(list[6], list[7], list[8]),
        )


        fun findWinner(): String {
            winCombinations.forEach { combi ->
                if (combi.all { it.isNotEmpty() && it == combi.first() }) return combi.first()
            }
            return ""
        }

        val winner = findWinner()
        Text(
            text = if (winner.isNotEmpty()) {
                "$winner wins"
            } else if (turns != 9) {
                "player $player turn"                   //placeholder here
            } else {
                "tie"
            },
            fontSize = 50.sp
        )
        if (winner != "") {
            done = true
        }


        Spacer(modifier = Modifier.size(20.dp))
        Button(
            onClick = {
                for (index in 0 until list.size) {
                    list[index] = ""
                }
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