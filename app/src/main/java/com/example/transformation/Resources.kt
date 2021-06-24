package com.example.transformation

import org.json.JSONObject

class Resources {

    fun getInputJsonObject(): JSONObject {
        val inputJsonString = "{\n" +
                "\t\"telemetry\": [{\n" +
                "\t\t\"value\": 94.5,\n" +
                "\t\t\"unit\": \"fahrenheit\",\n" +
                "\t\t\"name\": \"Temperature\", \"binding\": \"obs1\"\n" +
                "\t}, {\n" +
                "\t\t\"value\": \"2021-05-08T10:57:34+01:00\",\n" +
                "\t\t\"name\": \"Timestamp\",\n" +
                "\t\t\"binding\": \"timestamp\"\n" +
                "\t}]\n" +
                "}"
        return JSONObject(inputJsonString)
    }

    fun getInputTemplate(): String {
        return "{\"Telemetry\": { \"Temperature\": \"*obs1* Fahrenheit\",\"Timestamp\": \"*timestamp*\" } }"
    }

    fun getThermometerOutput(): JSONObject {
        val inputJSONString = "{\"telemetry\":[{\"value\":94.5,\"unit\":\"fahrenheit\",\"name\":\"Temperature\",\"binding\":\"obs1\"},{\"value\":\"2021-05-08T10:57:34+01:00\",\"name\":\"Timestamp\",\"binding\":\"timestamp\"}]}"
        return JSONObject(inputJSONString)
    }

    fun getThermometerTemplate(): String {
        return "{\"resourceType\": \"Bundle\", \"type\": \"transaction\", \"timestamp\": \"*payloadTime*\", \"entry\": [{\"fullUrl\": \"*npiid*\", \"resource\": {\"resourceType\": \"Patient\", \"id\": \"*npiid*\", \"identifier\": [{\"use\": \"usual\", \"value\": \"*npiid*\", \"assigner\": {\"display\": \"CHES RPM Client Name\"}}]}, \"request\": {\"method\": \"PUT\", \"url\": \"Patient/*npiid*\"}}, {\"fullUrl\": \"*deviceId*\", \"resource\": {\"id\": \"*deviceId*\", \"resourceType\": \"Device\", \"manufacturer\": \"ForaCare\", \"serialNumber\": \"5201100050\", \"deviceName\": [{\"name\": \"ForaCare Ear Thermometer IR20b\", \"type\": \"model-name\"}], \"modelNumber\": \"ForaCare IR20b\", \"type\": {\"coding\": [{\"system\": \"http://snomed.info/sct%22\", \"code\": \"700643004\", \"display\": \"Infrared patient thermometer, ear \"}]}}, \"request\": {\"method\": \"PUT\", \"url\": \"Device/*deviceId*\"}}, {\"fullUrl\": \"*uuid1*\", \"resource\": {\"id\": \"*uuid1*\", \"resourceType\": \"Observation\", \"status\": \"final\", \"category\": [{\"coding\": [{\"system\": \"http://terminology.hl7.org/CodeSystem/observation-category\", \"code\": \"vital-signs\", \"display\": \"Vital Signs\"}], \"text\": \"CHES Vital Signs\"}], \"code\": {\"coding\": [{\"system\": \"http://loinc.org\", \"code\": \"8310-5\", \"display\": \"Body Temperature\"}]}, \"effectiveDateTime\": \"*timestamp*\", \"performer\": [{\"reference\": \"Patient/*npiid*\"}], \"valueQuantity\": {\"code\": \"[degF]\", \"unit\": \"degree Fahrenheit\", \"value\": \"*obs1*\", \"system\": \"http://unitsofmeasure.org\"}, \"device\": {\"display\": \"ForaCare Ear Thermometer IR20b\", \"reference\": \"Device/*deviceId*\"}}, \"request\": {\"method\": \"POST\", \"url\": \"Observation/*uuid1*\"}}]}"
    }

    fun getPulseOximeterOutput(): JSONObject {
        val inputJSONString = "{\"telemetry\": [{\"value\": 98, \"unit\": \"%\", \"name\": \"SpO2\", \"binding\": \"obs1\"}, {\"value\": 80, \"unit\": \"BPM\", \"name\": \"PulseRate\", \"binding\": \"obs2\"}, {\"value\": 80, \"unit\": \"%\", \"name\": \"PulseAmplitudeIndex\", \"binding\": \"obs3\"}, {\"value\": \"2021-05-08T10:57:34+01:00\", \"name\": \"Timestamp\", \"binding\": \"timestamp\"}]}"
        return JSONObject(inputJSONString)
    }

    fun getPulseOximeterTemplate(): String {
        return "{\"resourceType\": \"Bundle\", \"type\": \"transaction\", \"timestamp\": \"*payloadTime*\", \"entry\": [{\"fullUrl\": \"*npiid*\", \"resource\": {\"resourceType\": \"Patient\", \"id\": \"*npiid*\", \"identifier\": [{\"use\": \"usual\", \"value\": \"*npiid*\", \"assigner\": {\"display\": \"CHES RPM Client Name\"}}]}, \"request\": {\"method\": \"PUT\", \"url\": \"Patient/*npiid*\"}}, {\"fullUrl\": \"*deviceId*\", \"resource\": {\"id\": \"*deviceId*\", \"resourceType\": \"Device\", \"manufacturer\": \"Nonin 3230\", \"serialNumber\": \"5201100050\", \"deviceName\": [{\"name\": \"(Sp02)/Heart rate\", \"type\": \"model-name\"}], \"modelNumber\": \"320\", \"type\": {\"coding\": [{\"system\": \"http://snomed.info/sct%22\", \"code\": \"448703006\", \"display\": \"Pulse oximeter\"}]}}, \"request\": {\"method\": \"PUT\", \"url\": \"Device/*deviceId*\"}}, {\"fullUrl\": \"*uuid1*\", \"resource\": {\"id\": \"*uuid1*\", \"resourceType\": \"Observation\", \"status\": \"final\", \"category\": [{\"coding\": [{\"system\": \"http://terminology.hl7.org/CodeSystem/observation-category\", \"code\": \"vital-signs\", \"display\": \"Vital Signs\"}], \"text\": \"CHES Vital Signs\"}], \"code\": {\"coding\": [{\"system\": \"http://loinc.org\", \"code\": \"59408-5\", \"display\": \"Oxygen saturation in Arterial blood by Pulse oximetry\"}]}, \"effectiveDateTime\": \"*timestamp*\", \"performer\": [{\"reference\": \"Patient/*npiid*\"}], \"valueQuantity\": {\"value\": \"*obs1*\", \"unit\": \"%\", \"system\": \"http://unitsofmeasure.org\", \"code\": \"%\"}, \"device\": {\"display\": \"Nonin 3230\", \"reference\": \"Device/*deviceId*\"}}, \"request\": {\"method\": \"POST\", \"url\": \"Observation/*uuid1*\"}}, {\"fullUrl\": \"*uuid2*\", \"resource\": {\"id\": \"*uuid2*\", \"resourceType\": \"Observation\", \"status\": \"final\", \"category\": [{\"coding\": [{\"system\": \"http://terminology.hl7.org/CodeSystem/observation-category\", \"code\": \"vital-signs\", \"display\": \"Vital Signs\"}], \"text\": \"CHES Vital Signs\"}], \"code\": {\"coding\": [{\"system\": \"http://loinc.org\", \"code\": \"8867-4\", \"display\": \"Heart rate\"}]}, \"effectiveDateTime\": \"*timestamp*\", \"performer\": [{\"reference\": \"Patient/*npiid*\"}], \"valueQuantity\": {\"value\": \"*obs2*\", \"unit\": \"beats/minute\", \"system\": \"http://unitsofmeasure.org\", \"code\": \"/min\"}, \"device\": {\"display\": \"Nonin 3230\", \"reference\": \"Device/*deviceId*\"}}, \"request\": {\"method\": \"POST\", \"url\": \"Observation/*uuid2*\"}}, {\"fullUrl\": \"*uuid3*\", \"resource\": {\"id\": \"*uuid3*\", \"resourceType\": \"Observation\", \"status\": \"final\", \"category\": [{\"coding\": [{\"system\": \"http://terminology.hl7.org/CodeSystem/observation-category\", \"code\": \"vital-signs\", \"display\": \"Vital Signs\"}], \"text\": \"CHES Vital Signs\"}], \"code\": {\"coding\": [{\"system\": \"http://loinc.org\", \"code\": \"61006-3\", \"display\": \"Perfusion index Tissue by Pulse oximetry\"}]}, \"effectiveDateTime\": \"*timestamp*\", \"performer\": [{\"reference\": \"Patient/*npiid*\"}], \"valueQuantity\": {\"value\": \"*obs3*\", \"unit\": \"percent\", \"system\": \"http://unitsofmeasure.org\", \"code\": \"%\"}, \"device\": {\"display\": \"Nonin 3230\", \"reference\": \"Device/*deviceId*\"}}, \"request\": {\"method\": \"POST\", \"url\": \"Observation/*uuid3*\"}}]}"
    }
}