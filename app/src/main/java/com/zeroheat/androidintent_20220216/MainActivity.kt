package com.zeroheat.androidintent_20220216

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDial.setOnClickListener {

            val inputPhoneNum = edtPhoneNum.text.toString()

//            Intent에, 어디로 전화를 걸지 알려줘야함 .  uri를 이용해 알려주자
            val myUri = Uri.parse("tel:${inputPhoneNum}") // 띄워쓰기 하면 안됨


            val myIntent = Intent(Intent.ACTION_DIAL, myUri)

            startActivity(myIntent)

        }

        btnCall.setOnClickListener {

            val inputPhoneNum = edtPhoneNum.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        } //하면 앱 뒤짐.(권한 때매)

        btnSendTo.setOnClickListener {

//            문자 보낼 내용 추출
            val inputContent = edtContent.text.toString()

            val inputPhoneNum = edtPhoneNum.text.toString()
            val myUri = Uri.parse("smsto:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)

            myIntent.putExtra("sms_body", inputContent)

            startActivity(myIntent)
        }
    }
}