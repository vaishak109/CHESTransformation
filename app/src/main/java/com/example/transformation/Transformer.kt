package com.example.transformation

import android.util.Log
import org.json.JSONObject
import kotlin.jvm.Throws
import kotlin.text.Regex
import java.util.UUID


class Transformer {

    @Throws(TransformationException :: class)
    /**
     *transform the input JSONObject to a preferred String template
     * @param npiid Kore patient ID
     * @param payloadTime time stamp in UTC W3C format
     * @param inputJSON a json object representing a telemetry reading
     * @param template the template to which the telemetry reading is to be transformed
     * @return transformed output string
     */
    fun transform(npiid: String, payloadTime: String, inputJSON: JSONObject, template: String): String {
        var transformedOutput = template

        //finding the *uuid* strings tobe replaced
        val regex = Regex("[*]uuid[0-9]+[*]")
        val uuids = regex.findAll(transformedOutput).map { it.value }.toSet()

        // replacing npiid
        transformedOutput = transformedOutput.replace("*npiid*", npiid)

        //replacing payloadTime
        transformedOutput = transformedOutput.replace("*payloadTime*", payloadTime)

        if (!inputJSON.has("telemetry"))
            throw TransformationException("Invalid input format, the input JSONObject doesn't have the key 'telemetry'")

//        var noOfReadings: Int = 0

        //replacing bindings with actual values
        try {
            val readings = inputJSON.getJSONArray("telemetry")
            val noOfReadings = readings.length()
            for (index in 0 until noOfReadings) {
                val reading = readings.getJSONObject(index)
                val valueToBeReplaced = "*" + reading.get("binding") + "*"
                transformedOutput = transformedOutput.replace(valueToBeReplaced, reading.getString("value"))
            }
        } catch (exception: Exception) {
            Log.e("Transformation Error", " ".plus(exception.message))
        }

//        if (noOfReadings == 0)
//            throw TransformationException("Invalid input format, found zero readings")
        
        //replacing uuids
        for (uuid in uuids) {
            val newUUID = UUID.randomUUID().toString()
            transformedOutput = transformedOutput.replace(uuid, newUUID)
        }
        return transformedOutput
    }
}