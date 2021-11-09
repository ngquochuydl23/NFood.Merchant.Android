package com.nsolution.nfoodmerchant.Image

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import java.io.File


class FileImage {
  companion object {
    @SuppressLint("Recycle")
    fun queryName(contentResolver: ContentResolver, uri: Uri?): String? {
      if(uri != null) {
        val returnCursor =
          contentResolver.query(uri, null, null, null, null)!!
        val nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        returnCursor.moveToFirst()
        val name = returnCursor.getString(nameIndex)
        returnCursor.close()
        return name
      }
      return null
    }

    fun getFile(cacheDir: File, contentResolver: ContentResolver, uri: Uri?): File {
      return File(cacheDir, queryName(contentResolver, uri))
    }

    fun clearCache(context: Context) {
      val path: File = File(context.externalCacheDir, "camera")
      if (path.exists() && path.isDirectory) {
        for (child in path.listFiles()) {
          child.delete()
        }
      }
    }
  }
}