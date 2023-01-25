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
                    var start by remember { mutableStateOf(false) }
                    if(start == false) {
                        Button(onClick = { start = true }) {
                            Text(text = "start")
                        }
                    } else {
                        Field()
                    }
                }
            }
        }
    }
}



@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("SuspiciousIndentation")
@Composable
fun Field() {
    val buttonColor = Color(0xFFcccccc)
    val playersAmount = 10
    val gridSize = playersAmount + 1
    val textSize = 240.sp / gridSize
    val playerList = remember {
        mutableStateListOf("X")
    }
    if(playerList.size < playersAmount) {
        playerList.add("O")
        playerList.add("F")
        playerList.add("C")
        playerList.add("K")
        playerList.add("T")
        playerList.add("B")
        playerList.add("N")
        playerList.add("U")
        playerList.add("Z")
        playerList.add("P")
        playerList.add("R")
        playerList.add("G")
        playerList.add("J")
        playerList.add("L")
        playerList.add("H")
        playerList.add("E")
        playerList.add("A")
        playerList.add("I")
        playerList.add("M")
    }
    var playerNumber by remember { mutableStateOf(0) }
    var turns by remember { mutableStateOf(0) }
    var done by remember { mutableStateOf(false) }
    if (turns == gridSize * gridSize) {
        done = true
    }


    val list = remember {
        mutableStateListOf(
            -1
        )
    }
    if (list.size < gridSize * gridSize) {
        for (repeat in 0 until gridSize * gridSize - 1) {
            list.add(-1)
        }
    }
    val colorList = remember {
        mutableStateListOf(0xFFff0026)
    }
    if(colorList.size < playersAmount) {
        colorList.add(0xFF0008ff)
        colorList.add(0xFF09ff00)
        colorList.add(0xFFffea00)
        colorList.add(0xFFb700ff)
        colorList.add(0xFF00fff7)
        colorList.add(0xFFff0073)
        colorList.add(0xFFff8800)
        colorList.add(0xFF000000)
        colorList.add(0xFFffffff)
        colorList.add(0xFF00ff84)
        colorList.add(0xFF8c1c00)
        colorList.add(0xFF00598c)
        colorList.add(0xFF0e008c)
        colorList.add(0xFF008c05)
        colorList.add(0xFF8c0000)
        colorList.add(0xFF006e8c)
        colorList.add(0xFF608c00)
        colorList.add(0xFFff7dee)
        colorList.add(0xFF8c0033)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(5.dp),
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
                            if (list[index] == -1) {
                                list[index] = playerNumber
                                if (playerNumber < playersAmount - 1) {
                                    playerNumber++
                                } else {
                                    playerNumber = 0
                                }
                                turns++
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor)
                ) {
                    Text(
                        text = if (list[index] != -1) {
                            playerList[list[index]]
                        } else {
                            ""
                        },
                        fontSize = textSize,
                        color = if (list[index] != -1) {
                            Color(colorList[list[index]])
                        } else {
                            Color.Black
                        }
                    )
                }
            }
        }

        fun findWinner(): Int {
            fun checkEquals(a: Int, b: Int): Boolean {
                if (a >= list.size) return false
                if (b >= list.size) return false
                return list[a] == list[b]
            }
            // vertical
            for (repeatVertical in 0 until list.size - gridSize * 2) {
                if (list[repeatVertical] != -1 && checkEquals(
                        repeatVertical,
                        repeatVertical + gridSize
                    ) && list[repeatVertical] == list[repeatVertical + gridSize + gridSize]
                ) return list[repeatVertical]
            }
            // diagonal right to left, top to bottom
            val diagonalRTL = (0 until list.size).filter { index ->
                (index + 1) % gridSize != 1 && (index + 1) % gridSize != 2
                        && index < gridSize * gridSize - gridSize * 2
            }
            for (repeatDiagonalRTL in diagonalRTL) {
                if (list[repeatDiagonalRTL] != -1 && checkEquals(
                        repeatDiagonalRTL,
                        repeatDiagonalRTL + gridSize - 1
                    ) && checkEquals(
                        repeatDiagonalRTL + gridSize - 1,
                        repeatDiagonalRTL + 2 * gridSize - 2
                    )
                ) return list[repeatDiagonalRTL]
            }
            // diagonal left to right, top to bottom
            val diagonalLTR = (0 until list.size).filter { index ->
                (index + 1) % gridSize != 0 && (index + 1) % gridSize != gridSize - 1
                        && index < gridSize * gridSize - gridSize * 2
            }
            for (repeatDiagonalLTR in diagonalLTR) {
                if (list[repeatDiagonalLTR] != -1 && checkEquals(
                        repeatDiagonalLTR,
                        repeatDiagonalLTR + gridSize + 1
                    ) && checkEquals(
                        repeatDiagonalLTR + gridSize + 1,
                        repeatDiagonalLTR + gridSize * 2 + 2
                    )
                ) return list[repeatDiagonalLTR]
            }
            // horizontal
            val horizontal = (0 until list.size).filter { index ->
                (index + 1) % gridSize != 0 && (index + 1) % gridSize != gridSize - 1
            }
            for (repeatHorizontal in horizontal) {
                if (list[repeatHorizontal] != -1 && checkEquals(
                        repeatHorizontal,
                        repeatHorizontal + 1
                    ) && checkEquals(repeatHorizontal + 1, repeatHorizontal + 2)
                ) return list[repeatHorizontal]
            }

            return -1
        }

        val winner = findWinner()
        if (winner != -1) {
            done = true
        }
        Text(
            text = if (winner != -1) {
                "${playerList[winner]} wins"
            } else if (turns != gridSize * gridSize) {
                "player ${playerList[playerNumber]} turn"
            } else {
                "tie"
            },
            fontSize = 50.sp,
            color = if(done == false) {Color(colorList[playerNumber])}
        else {Color(colorList[winner])}
        )

        Spacer(modifier = Modifier.size(20.dp))
        Button(
            onClick = {
                for (index in 0 until list.size) {
                    list[index] = -1
                }
                turns = 0
                playerNumber = 0
                done = false
            },
            modifier = Modifier
                .width(150.dp)
                .height(70.dp),
            colors = if (done == false) {
                ButtonDefaults.buttonColors(backgroundColor = Color(colorList[playerNumber])
                )
            } else {
                ButtonDefaults.buttonColors(backgroundColor = Color(colorList[winner]))
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