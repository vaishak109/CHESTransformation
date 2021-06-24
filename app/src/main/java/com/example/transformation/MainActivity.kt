package com.example.transformation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val resource = Resources()
//        val inputJson = resource.getInputJsonObject()
//        Log.d(TRANSFORMER, "input json: ".plus(inputJson))
//        val template = resource.getInputTemplate()
//        Log.d(TRANSFORMER, "template: ".plus(template))
//        val transformer = Transformer()
//        val result = transformer.transform("P001", "abc", inputJson, template)
//        Log.d(TRANSFORMER, result)


        //******************************* THERMOMETER TESTING **************************************
        val inputJSON = resource.getThermometerOutput()
        Log.d(THERMOMETER, "input json: ".plus(inputJSON))
        val thermometerTemplate = resource.getThermometerTemplate()
        Log.d(THERMOMETER, "template: ".plus(thermometerTemplate))
        val transformer = Transformer()
        val payloadTime = "2021-06-24T04:48:37.005"
        val thermometerOutput = transformer.transform("P0001", payloadTime, inputJSON, thermometerTemplate)
        Log.d(THERMOMETER, "Output: ".plus(thermometerOutput))


        //************************************ PULSE OXIMETER TESTING ******************************
        val inputJSON2 = resource.getPulseOximeterOutput()
        Log.d(PULSEOXIMETER, "input json: ".plus(inputJSON2))
        val pulseOximeterTemplate = resource.getPulseOximeterTemplate()
        Log.d(PULSEOXIMETER, "template: ".plus(pulseOximeterTemplate))
        val pulseOximeterOutput = transformer.transform("P0002", payloadTime, inputJSON2, pulseOximeterTemplate)
        Log.d(PULSEOXIMETER, "Output: ".plus(pulseOximeterOutput))
    }
    companion object {
        const val THERMOMETER = "Thermometer Sample"
        const val PULSEOXIMETER = "Pulse Oximeter Sample"
    }
}