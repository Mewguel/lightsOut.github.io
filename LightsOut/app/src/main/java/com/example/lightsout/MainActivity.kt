package com.example.lightsout

import android.content.Context
import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import org.w3c.dom.Text
import java.lang.reflect.Array
import kotlin.Array as Array1

class MainActivity : AppCompatActivity() {
    var tapCount:Int = 0
    lateinit var boxOne:TextView
    lateinit var boxTwo:TextView
    lateinit var boxThree:TextView
    lateinit var boxFour:TextView
    lateinit var boxFive:TextView
    lateinit var boxSix:TextView
    lateinit var boxSeven:TextView
    lateinit var boxEight:TextView
    lateinit var boxNine:TextView
    lateinit var boxTen:TextView
    lateinit var boxEleven:TextView
    lateinit var boxTwelve:TextView
    lateinit var boxThirteen:TextView
    lateinit var boxFourteen:TextView
    lateinit var boxFifteen:TextView
    lateinit var boxSixteen:TextView
    lateinit var boxSeventeen:TextView
    lateinit var boxEighteen:TextView
    lateinit var boxNineteen:TextView
    lateinit var boxTwenty:TextView
    lateinit var boxTwentyOne:TextView
    lateinit var boxTwentyTwo:TextView
    lateinit var boxTwentyThree:TextView
    lateinit var boxTwentyFour:TextView
    lateinit var boxTwentyFive:TextView
    private lateinit var editText:TextView
    private lateinit var rootConstraintLayout: View
    lateinit var congrats:TextView
    var gameOn:Int = 1

    lateinit var clickableViews: List<View>
    lateinit var boxFlags:IntArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boxOne = findViewById(R.id.box_one)
        boxTwo = findViewById(R.id.box_two)
        boxThree = findViewById(R.id.box_three)
        boxFour = findViewById(R.id.box_four)
        boxFive = findViewById(R.id.box_five)

        boxSix = findViewById(R.id.box_six)
        boxSeven = findViewById(R.id.box_seven)
        boxEight = findViewById(R.id.box_eight)
        boxNine = findViewById(R.id.box_nine)
        boxTen = findViewById(R.id.box_ten)

        boxEleven = findViewById(R.id.box_eleven)
        boxTwelve = findViewById(R.id.box_twelve)
        boxThirteen = findViewById(R.id.box_thirteen)
        boxFourteen = findViewById(R.id.box_fourteen)
        boxFifteen = findViewById(R.id.box_fifteen)

        boxSixteen = findViewById(R.id.box_sixteen)
        boxSeventeen = findViewById(R.id.box_seventeen)
        boxEighteen = findViewById(R.id.box_eighteen)
        boxNineteen = findViewById(R.id.box_nineteen)
        boxTwenty = findViewById(R.id.box_twenty)

        boxTwentyOne = findViewById(R.id.box_twenty_one)
        boxTwentyTwo = findViewById(R.id.box_twenty_two)
        boxTwentyThree = findViewById(R.id.box_twenty_three)
        boxTwentyFour = findViewById(R.id.box_twenty_four)
        boxTwentyFive = findViewById(R.id.box_twenty_five)
        congrats = findViewById(R.id.congrats_text)
        editText = findViewById<EditText>(R.id.name_edit)                                           // edit text for text view of the name
        boxFlags = IntArray(25) {0}

        clickableViews = listOf(boxOne, boxTwo, boxThree, boxFour,boxFive,
            boxSix, boxSeven,boxEight, boxNine, boxTen,
            boxEleven, boxTwelve, boxThirteen, boxFourteen, boxFifteen,
            boxSixteen, boxSeventeen, boxEighteen, boxNineteen, boxTwenty,
            boxTwentyOne, boxTwentyTwo, boxTwentyThree,boxTwentyFour, boxTwentyFive)                // add boxes here

        rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        findViewById<Button>(R.id.play_button).setOnClickListener{
            if(editText.text.toString() != ""){
                addName(it)
                showBoard()
            }else{
                Toast.makeText(applicationContext,"Name cannot be empty",Toast.LENGTH_SHORT).show()
            }
        }
        setListeners()
    }

    private fun addName(view: View){
        val lightsOut = findViewById<TextView>(R.id.lights_out_text)                     // lights out val
        val tempName = editText.text                                                  // since we dont have to show the name lets store it in a temp Val

        editText.visibility = View.GONE                                                           // hide fields
        lightsOut.text = tempName

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager   // hides the keyboard input after entering name
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

        findViewById<Button>(R.id.play_button).visibility = View.GONE                             // hide playbutton
                                                                                                 // game is running
    }

    private fun changeImage(view: View) {

        when (view.id) {
            // change box background to black tile when clicked
            R.id.box_one ->  {
                if(boxFlags[0] == 0){
                    boxFlags[0] = 1
                    view.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[0] = 0
                    view.setBackgroundResource(R.drawable.tile)
                }
                if(boxFlags[1] == 0){
                    boxFlags[1] = 1
                    boxTwo.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[1] = 0
                    boxTwo.setBackgroundResource(R.drawable.tile)
                }
                if(boxFlags[5] == 0){
                    boxFlags[5] = 1
                    boxSix.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[5] = 0
                    boxSix.setBackgroundResource(R.drawable.tile)
                }
            } // end of boxOne
            R.id.box_two -> {
                if(boxFlags[1] == 0){
                    boxFlags[1] = 1
                    view.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[1] = 0
                    view.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box two image
                if(boxFlags[0] == 0){
                    boxFlags[0] = 1
                    boxOne.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[0] = 0
                    boxOne.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box one image
                if(boxFlags[2] == 0){
                    boxFlags[2] = 1
                    boxThree.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[2] = 0
                    boxThree.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box three image
                if(boxFlags[6] == 0){
                    boxFlags[6] = 1
                    boxSeven.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[6] = 0
                    boxSeven.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box seven image
            }
            R.id.box_three ->{
                if(boxFlags[2] == 0){
                    boxFlags[2] = 1
                    view.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[2] = 0
                    view.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box three image
                if(boxFlags[1] == 0){
                    boxFlags[1] = 1
                    boxTwo.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[1] = 0
                    boxTwo.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box two image
                if(boxFlags[3] == 0){
                    boxFlags[3] = 1
                    boxFour.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[3] = 0
                    boxFour.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box four image
                if(boxFlags[7] == 0){
                    boxFlags[7] = 1
                    boxEight.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[7] = 0
                    boxEight.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box eight image
            }
            R.id.box_four ->{
                if(boxFlags[3] == 0){
                    boxFlags[3] = 1
                    view.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[3] = 0
                    view.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box four image
                if(boxFlags[2] == 0){
                    boxFlags[2] = 1
                    boxThree.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[2] = 0
                    boxThree.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box three image
                if(boxFlags[4] == 0){
                    boxFlags[4] = 1
                    boxFive.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[4] = 0
                    boxFive.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box five image
                if(boxFlags[8] == 0){
                    boxFlags[8] = 1
                    boxNine.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[8] = 0
                    boxNine.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box nine image
            }
            R.id.box_five -> {
                if(boxFlags[4] == 0){
                    boxFlags[4] = 1
                    view.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[4] = 0
                    view.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box five image
                if(boxFlags[3] == 0){
                    boxFlags[3] = 1
                    boxFour.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[3] = 0
                    boxFour.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box FOur image
                if(boxFlags[9] == 0){
                    boxFlags[9] = 1
                    boxTen.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[9] = 0
                    boxTen.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box ten image

            }
            R.id.box_six -> {
                if(boxFlags[5] == 0){
                    boxFlags[5] = 1
                    view.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[5] = 0
                    view.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box six image
                if(boxFlags[0] == 0){
                    boxFlags[0] = 1
                    boxOne.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[0] = 0
                    boxOne.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box one image
                if(boxFlags[6] == 0){
                    boxFlags[6] = 1
                    boxSeven.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[6] = 0
                    boxSeven.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box seven image
                if(boxFlags[10] == 0){
                    boxFlags[10] = 1
                    boxEleven.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[10] = 0
                    boxEleven.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box eleven image
            }
            R.id.box_seven -> {
                if(boxFlags[6] == 0){
                    boxFlags[6] = 1
                    view.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[6] = 0
                    view.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box seven image
                if(boxFlags[1] == 0){
                    boxFlags[1] = 1
                    boxTwo.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[1] = 0
                    boxTwo.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box two image
                if(boxFlags[5] == 0){
                    boxFlags[5] = 1
                    boxSix.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[5] = 0
                    boxSix.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box six image
                if(boxFlags[11] == 0){
                    boxFlags[11] = 1
                    boxTwelve.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[11] = 0
                    boxTwelve.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box twelve image
                if(boxFlags[7] == 0){
                    boxFlags[7] = 1
                    boxEight.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[7] = 0
                    boxEight.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box eight image
            }
            R.id.box_eight -> {
                if(boxFlags[7] == 0){
                    boxFlags[7] = 1
                    view.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[7] = 0
                    view.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box eight image
                if(boxFlags[2] == 0){
                    boxFlags[2] = 1
                    boxThree.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[2] = 0
                    boxThree.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box three image
                if(boxFlags[8] == 0){
                    boxFlags[8] = 1
                    boxNine.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[8] = 0
                    boxNine.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box Nine image
                if(boxFlags[6] == 0){
                    boxFlags[6] = 1
                    boxSeven.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[6] = 0
                    boxSeven.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box seven image
                if(boxFlags[12] == 0){
                    boxFlags[12] = 1
                    boxThirteen.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[12] = 0
                    boxThirteen.setBackgroundResource(R.drawable.black_tile)
                }                                                                                   // change box thirteen image
            }
            R.id.box_nine ->{
                if(boxFlags[8] == 0){
                    boxFlags[8] = 1
                    view.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[8] = 0
                    view.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box nine image center
                if(boxFlags[3] == 0){
                    boxFlags[3] = 1
                    boxFour.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[3] = 0
                    boxFour.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box four image top
                if(boxFlags[7] == 0){
                    boxFlags[7] = 1
                    boxEight.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[7] = 0
                    boxEight.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box eight image left
                if(boxFlags[9] == 0){
                    boxFlags[9] = 1
                    boxTen.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[9] = 0
                    boxTen.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box ten image right
                if(boxFlags[13] == 0){
                    boxFlags[13] = 1
                    boxFourteen.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[13] = 0
                    boxFourteen.setBackgroundResource(R.drawable.black_tile)
                }                                                                                   // change box fourteen image bottom
            }
            R.id.box_ten ->{
                if(boxFlags[9] == 0){
                    boxFlags[9] = 1
                    view.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[9] = 0
                    view.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box ten image center
                if(boxFlags[4] == 0){
                    boxFlags[4] = 1
                    boxFive.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[4] = 0
                    boxFive.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box five image top
                if(boxFlags[8] == 0){
                    boxFlags[8] = 1
                    boxNine.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[8] = 0
                    boxNine.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box nine image left
                if(boxFlags[14] == 0){
                    boxFlags[14] = 1
                    boxFifteen.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[14] = 0
                    boxFifteen.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box 15 image bottom
            }
            R.id.box_eleven ->{
                if(boxFlags[10] == 0){
                    boxFlags[10] = 1
                    view.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[10] = 0
                    view.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box eleven image center
                if(boxFlags[5] == 0){
                    boxFlags[5] = 1
                    boxSix.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[5] = 0
                    boxSix.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box six image top
                if(boxFlags[11] == 0){
                    boxFlags[11] = 1
                    boxTwelve.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[11] = 0
                    boxTwelve.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box twelve image right
                if(boxFlags[15] == 0){
                    boxFlags[15] = 1
                    boxSixteen.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[15] = 0
                    boxSixteen.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box sixteen image bottom
            }
            R.id.box_twelve ->{
                change12()                                                                          //change center
                if(boxFlags[6] == 0){
                    boxFlags[6] = 1
                    boxSeven.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[6] = 0
                    boxSeven.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box seven image top
                change11()                                                                          // change box eleven image left
                change13()                                                                          // change box 13 image right
                change17()                                                                          // change box 17 image bottom
            }
            R.id.box_thirteen -> {
                change13()                                                                          //center
                change12()                                                                          //left
                change14()                                                                          //right
                change18()                                                                          //bottom
                if(boxFlags[7] == 0){
                    boxFlags[7] = 1
                    boxEight.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[7] = 0
                    boxEight.setBackgroundResource(R.drawable.tile)
                }                                                                                   // change box eight image top
            }
            R.id.box_fourteen -> {
                change14()
                change13()
                change15()
                change19()
                if(boxFlags[8] == 0){
                    boxFlags[8] = 1
                    boxNine.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[8] = 0
                    boxNine.setBackgroundResource(R.drawable.tile)                                  // change top 9
                }
            }
            R.id.box_fifteen ->{
                change15()
                change14()
                change20()
                if(boxFlags[9] == 0){
                    boxFlags[9] = 1
                    boxTen.setBackgroundResource(R.drawable.black_tile)
                }else{
                    boxFlags[9] = 0
                    boxTen.setBackgroundResource(R.drawable.tile)
                }
            }

            R.id.box_sixteen -> {
                change16()
                change11()
                change17()
                change21()
            }
            R.id.box_seventeen -> {
                change17()
                change18()
                change16()
                change22()
                change12()
            }
            R.id.box_eighteen -> {
                change18()
                change19()
                change17()
                change23()
                change13()
            }
            R.id.box_nineteen -> {
                change19()
                change20()
                change18()
                change14()
                change24()
            }
            R.id.box_twenty -> {
                change20()
                change19()
                change15()
                change25()
            }

            R.id.box_twenty_one -> {
                change21()
                change16()
                change22()
            }
            R.id.box_twenty_two -> {
                change22()
                change17()
                change21()
                change23()
            }
            R.id.box_twenty_three -> {
                change23()
                change22()
                change24()
                change18()
            }
            R.id.box_twenty_four -> {
                change24()
                change25()
                change23()
                change19()
            }
            R.id.box_twenty_five -> {
                change25()
                change20()
                change24()
            }
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun setListeners() {
        for (item in clickableViews) {
            item.setOnClickListener {
                changeImage(it)
                updateCount()
                isGameOver()
            }
        }   // end for loop

        findViewById<Button>(R.id.retry_button).setOnClickListener{
            retry()
        }
    }

    private fun showBoard(){
        for (item in clickableViews) {
            item.visibility = View.VISIBLE
        }   // end for loop
        findViewById<TextView>(R.id.tap_counter).visibility = View.VISIBLE
        findViewById<Button>(R.id.retry_button).visibility = View.VISIBLE
    }

    private fun updateCount(){
        val countTextView = findViewById<TextView>(R.id.tap_counter)
        tapCount++
        countTextView.text = tapCount.toString()
    }


    private fun change11(){
        if(boxFlags[10] == 0){
            boxFlags[10] = 1
            boxEleven.setBackgroundResource(R.drawable.black_tile)
        }else{
            boxFlags[10] = 0
            boxEleven.setBackgroundResource(R.drawable.tile)
        }                                                                                   // change box 11 image center
    }

    private fun change12(){
        if(boxFlags[11] == 0){
            boxFlags[11] = 1
            boxTwelve.setBackgroundResource(R.drawable.black_tile)
        }else{
            boxFlags[11] = 0
            boxTwelve.setBackgroundResource(R.drawable.tile)
        }                                                                                   // change box 12 image center
    }

    private fun change13(){
        if(boxFlags[12] == 0){
            boxFlags[12] = 1
            boxThirteen.setBackgroundResource(R.drawable.black_tile)
        }else{
            boxFlags[12] = 0
            boxThirteen.setBackgroundResource(R.drawable.tile)
        }                                                                                   // change box 13 image center
    }

    private fun change14(){
        if(boxFlags[13] == 0){
            boxFlags[13] = 1
            boxFourteen.setBackgroundResource(R.drawable.black_tile)
        }else{
            boxFlags[13] = 0
            boxFourteen.setBackgroundResource(R.drawable.tile)
        }                                                                                   // change box 14 image center
    }

    private fun change15(){
        if(boxFlags[14] == 0){
            boxFlags[14] = 1
            boxFifteen.setBackgroundResource(R.drawable.black_tile)
        }else{
            boxFlags[14] = 0
            boxFifteen.setBackgroundResource(R.drawable.tile)
        }                                                                                   // change box 15 image center
    }

    private fun change16(){
        if(boxFlags[15] == 0){
            boxFlags[15] = 1
            boxSixteen.setBackgroundResource(R.drawable.black_tile)
        }else{
            boxFlags[15] = 0
            boxSixteen.setBackgroundResource(R.drawable.tile)
        }                                                                                   // change box 16 image center
    }

    private fun change17(){
        if(boxFlags[16] == 0){
            boxFlags[16] = 1
            boxSeventeen.setBackgroundResource(R.drawable.black_tile)
        }else{
            boxFlags[16] = 0
            boxSeventeen.setBackgroundResource(R.drawable.tile)
        }                                                                                   // change box 17 image center
    }

    private fun change18(){
        if(boxFlags[17] == 0){
            boxFlags[17] = 1
            boxEighteen.setBackgroundResource(R.drawable.black_tile)
        }else{
            boxFlags[17] = 0
            boxEighteen.setBackgroundResource(R.drawable.tile)
        }                                                                                   // change box 18 image center
    }

    private fun change19(){
        if(boxFlags[18] == 0){
            boxFlags[18] = 1
            boxNineteen.setBackgroundResource(R.drawable.black_tile)
        }else{
            boxFlags[18] = 0
            boxNineteen.setBackgroundResource(R.drawable.tile)
        }                                                                                   // change box 19 image center
    }

    private fun change20(){
        if(boxFlags[19] == 0){
            boxFlags[19] = 1
            boxTwenty.setBackgroundResource(R.drawable.black_tile)
        }else{
            boxFlags[19] = 0
            boxTwenty.setBackgroundResource(R.drawable.tile)
        }                                                                                   // change box 20 image center
    }

    private fun change21(){
        if(boxFlags[20] == 0){
            boxFlags[20] = 1
            boxTwentyOne.setBackgroundResource(R.drawable.black_tile)
        }else{
            boxFlags[20] = 0
            boxTwentyOne.setBackgroundResource(R.drawable.tile)
        }                                                                                   // change box 21 image center
    }

    private fun change22(){
        if(boxFlags[21] == 0){
            boxFlags[21] = 1
            boxTwentyTwo.setBackgroundResource(R.drawable.black_tile)
        }else{
            boxFlags[21] = 0
            boxTwentyTwo.setBackgroundResource(R.drawable.tile)
        }                                                                                   // change box 22 image center
    }

    private fun change23(){
        if(boxFlags[22] == 0){
            boxFlags[22] = 1
            boxTwentyThree.setBackgroundResource(R.drawable.black_tile)
        }else{
            boxFlags[22] = 0
            boxTwentyThree.setBackgroundResource(R.drawable.tile)
        }                                                                                   // change box 23 image center
    }

    private fun change24(){
        if(boxFlags[23] == 0){
            boxFlags[23] = 1
            boxTwentyFour.setBackgroundResource(R.drawable.black_tile)
        }else{
            boxFlags[23] = 0
            boxTwentyFour.setBackgroundResource(R.drawable.tile)
        }                                                                                   // change box 24 image center
    }

    private fun change25(){
        if(boxFlags[24] == 0){
            boxFlags[24] = 1
            boxTwentyFive.setBackgroundResource(R.drawable.black_tile)
        }else{
            boxFlags[24] = 0
            boxTwentyFive.setBackgroundResource(R.drawable.tile)
        }                                                                                   // change box 24 image center
    }

    private fun isGameOver(){
        var numTapped = 0
        val finalCount = findViewById<TextView>(R.id.tap_count_final)

        for (i in boxFlags){
            if(i == 1) numTapped++
        }
        if (numTapped == 25) gameOn = 0
        if (gameOn == 0){
            for (item in clickableViews) {
                item.visibility = View.GONE
            }   // end for loop
            findViewById<TextView>(R.id.tap_counter).visibility = View.GONE
            finalCount.text = tapCount.toString()
            finalCount.visibility = View.VISIBLE
            congrats.visibility = View.VISIBLE
        }
    }

    private fun retry(){
        for(i in 0..24){
            boxFlags[i] = 0
        }
        for (item in clickableViews) {
            item.setBackgroundResource(R.drawable.tile)
            item.visibility = View.VISIBLE
        }   // end for loop
        tapCount = 0
        gameOn = 1
        findViewById<TextView>(R.id.tap_counter).text = tapCount.toString()
        findViewById<TextView>(R.id.tap_counter).visibility = View.VISIBLE
        findViewById<TextView>(R.id.tap_count_final).visibility = View.GONE
        congrats.visibility = View.GONE

    }
}
