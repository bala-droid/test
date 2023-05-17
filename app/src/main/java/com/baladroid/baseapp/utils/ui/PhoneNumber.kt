package com.baladroid.baseapp.utils.ui

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.Fragment


fun Fragment.dialNumber(phoneNumber: String) {
    val dialIntent = Intent(Intent.ACTION_DIAL)
    dialIntent.data = Uri.parse("tel:$phoneNumber")
    startActivity(dialIntent)
}

fun Fragment.sendWhatsAppMessage(phoneNumber: String, text: String = "Praise the Lord") {
    val messageIntent = Intent(Intent.ACTION_VIEW)
    val url = "https://api.whatsapp.com/send?phone=$phoneNumber&text=$text"
    messageIntent.data = Uri.parse(url)
    startActivity(messageIntent)
}

fun Fragment.sendTextMessage(phoneNumber: String, text: String = "Praise the Lord") {
  val smsNumber: String = phoneNumber
    val smsText: String = text

    val uri = Uri.parse("smsto:$smsNumber")
    val intent = Intent(Intent.ACTION_SENDTO, uri)
    intent.putExtra("sms_body", smsText)
    startActivity(intent)
}


fun Fragment.phoneNumberAction(phoneNumber: String, text: String = "Praise the Lord") {
    val dialIntent = Intent(Intent.ACTION_DIAL)
    dialIntent.data = Uri.parse("tel:$phoneNumber")

    val whatsAppIntent = Intent(Intent.ACTION_SENDTO)
  //  val url = "https://api.whatsapp.com/send?phone=$phoneNumber&text=$text"
 //   whatsAppIntent.data = Uri.parse(url)

    val uri = Uri.parse("smsto:$phoneNumber")
    val smsIntent = Intent(Intent.ACTION_SENDTO, uri)
    smsIntent.putExtra("sms_body", text)

    val openInChooser = Intent.createChooser(whatsAppIntent, "Open in...")
    startActivity(openInChooser)

}





