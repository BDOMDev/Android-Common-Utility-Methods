package com.bdom.tools.utilitymethods

import android.content.Context
import android.content.res.Resources
import android.support.annotation.RawRes
import java.io.*

object FileUtils {

    /**
     * Read a file as a ByteArray
     *
     * @param filePath path of the file to be read
     *
     * @return ByteArray
     */
    fun readFile(filePath: String): ByteArray {
        val fileContent: ByteArray
        val file = File(filePath)

        fileContent = file.readBytes()
        try {
            val bufferedInputStream = BufferedInputStream(
                FileInputStream(file)
            )
            try {
                bufferedInputStream.read(fileContent)
                bufferedInputStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }

        return fileContent
    }

    /**
     * Save a ByteArray to a file
     *
     * @param fileData ByteArray
     * @param path path of the File to be saved
     *
     * @return Boolean - Success or fail of the operation
     */
     fun saveFile(fileData: ByteArray, path: String): Boolean {
        try {
            val file = File(path)
            val bos = BufferedOutputStream(FileOutputStream(file, false))
            bos.write(fileData)
            bos.flush()
            bos.close()
            return true
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            return false
        } catch (e: IOException) {
            e.printStackTrace()
            return false
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }

    }

}