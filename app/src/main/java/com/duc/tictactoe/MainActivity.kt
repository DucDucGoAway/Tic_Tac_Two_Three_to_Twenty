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

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("SuspiciousIndentation")
@Composable
fun Field() {
    val gridSize = 5
    val buttonSize = 240.sp / gridSize
    var player by remember { mutableStateOf("X") }
    var turns by remember { mutableStateOf(0) }
    var done by remember { mutableStateOf(false) }
    if (turns == gridSize * gridSize) {
        done = true
    }
    if (done == true) {
        player = "done"
    }

    val list = remember {
        mutableStateListOf(
            ""
        )
    }
    if(list.size < gridSize * gridSize) {
        for (repeat in 0 until gridSize * gridSize - 1) {
            list.add("")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(gridSize)
        ) {
            itemsIndexed(list) { index, s ->
                Button(
                    onClick = {
                        if (done == false) {
                            if (list[index] == "") {
                                list[index] = player
                                when (player) {
                                    "X" -> player = "O"
                                    "O" -> player = "F"
                                    else -> player = "X"
                                }
                                turns++
                            }
                        }
                    }, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor)
                ) {
                    Text(
                        text = list[index],
                        fontSize = buttonSize,
                        color = when (list[index]) {
                            "X" -> Color.Red
                            "O" -> Color.Blue
                            else -> Color.Green
                        }
                    )
                }
            }
        }

        fun findWinner(): String {
            fun checkEquals(a: Int, b: Int): Boolean {
                if (a >= list.size) return false
                if (b >= list.size) return false
                return list[a] == list[b]
            }
            // vertical
            for (repeatVertical in 0 until list.size - gridSize *2) {
                if (list[repeatVertical] != "" && checkEquals(repeatVertical, repeatVertical + gridSize) && list[repeatVertical] == list[repeatVertical + gridSize + gridSize]) return list[repeatVertical]
            }
            // diagonal right to left, top to bottom
            val diagonalRTL = (0 until list.size).filter { index ->
                (index + 1) % gridSize != 1 && (index + 1) % gridSize != 2
                        && index < gridSize * gridSize - gridSize * 2
            }
            for (repeatDiagonalRTL in diagonalRTL) {
                if (list[repeatDiagonalRTL] != "" && checkEquals(repeatDiagonalRTL, repeatDiagonalRTL + gridSize-1) && checkEquals(repeatDiagonalRTL + gridSize -1, repeatDiagonalRTL + 2 * gridSize - 2)) return list[repeatDiagonalRTL]
            }
            // diagonal left to right, top to bottom
            val diagonalLTR = (0 until list.size).filter { index ->
                (index + 1) % gridSize != gridSize && (index+1) % gridSize != gridSize-1
                        && index < gridSize * gridSize - gridSize * 2
            }
            for (repeatDiagonalLTR in diagonalLTR) {
                if (list[repeatDiagonalLTR] != "" && checkEquals(repeatDiagonalLTR, repeatDiagonalLTR + gridSize + 1) && checkEquals(repeatDiagonalLTR + gridSize + 1, repeatDiagonalLTR + gridSize * 2 + 2)) return list[repeatDiagonalLTR]
            }
            // horizontal
            val horizontal = (0 until list.size).filter { index ->
                (index + 1) % gridSize != gridSize && (index + 1) % gridSize != gridSize-1
            }
            for (repeatHorizontal in horizontal) {
                if (list[repeatHorizontal] != "" && checkEquals(repeatHorizontal, repeatHorizontal+1) && checkEquals(repeatHorizontal+1, repeatHorizontal+2)) return list[repeatHorizontal]
            }

            return ""
        }

        val winner = findWinner()
        if (winner != "") {
            done = true
        }
        Text(
            text = if (winner.isNotEmpty()) {
                "$winner wins"
            } else if (turns != gridSize * gridSize) {
                "player $player turn"
            } else {
                "tie"
            },
            fontSize = 50.sp,
            color = when (player) {
                "X" -> Color.Red
                "O" -> Color.Blue
                "F" -> Color.Green
                else -> Color.Yellow
            }
        )


        Spacer(modifier = Modifier.size(20.dp))
        Button(
            onClick = {
                for (index in 0 until list.size) {
                    list[index] = ""
                }
                turns = 0
                player = "X"
                done = false
            },
            modifier = Modifier
                .width(150.dp)
                .height(70.dp),
            colors = when (player) {
                "X" -> ButtonDefaults.buttonColors(Color.Red)
                "O" -> ButtonDefaults.buttonColors(Color.Blue)
                "F" -> ButtonDefaults.buttonColors(Color.Green)
                else -> ButtonDefaults.buttonColors(Color.Yellow)
            }
        )
        {
            Text(
                text = "restart",
                fontSize = 24.sp
            )
        }
    }
}