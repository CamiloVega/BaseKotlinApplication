package com.cvdevelopers.baseapplication.utils

import android.content.res.AssetManager
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.reflect.Type
import javax.inject.Inject

class FileReader @Inject constructor(val assetManager: AssetManager, private val gson: Gson) {

    fun <T> loadJson(path: String, type: Type): T {
        try {
            val json = getFileString(path)

            return gson.fromJson(json, type)
        } catch (e: IOException) {
            throw IllegalArgumentException("Could not deserialize: $path into type: $type")
        }

    }

    fun <T> loadJson(path: String, clazz: Class<T>): T {
        try {
            val json = getFileString(path)
            return gson.fromJson(json, clazz)
        } catch (e: IOException) {
            throw IllegalArgumentException("Could not deserialize: $path into class: $clazz")
        }

    }

    fun getFileString(path: String): String {
        try {
            val sb = StringBuilder()
            val reader = BufferedReader(
                InputStreamReader(
                    assetManager.open(path))
            )
            do {
                val line = reader.readLine()
                line?.let { sb.append(it) }
            } while (line != null)
            return sb.toString()
        } catch (e: IOException) {
            throw IllegalArgumentException("Could not read from resource at: $path")
        }

    }
}
