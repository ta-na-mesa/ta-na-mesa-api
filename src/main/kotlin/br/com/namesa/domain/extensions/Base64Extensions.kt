package br.com.namesa.domain.extensions

import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.util.Base64


fun InputStream.toBase64String(): String = this.use {
    val outputStream = ByteArrayOutputStream()
    Base64.getEncoder().wrap(outputStream).use { base64Stream ->
        it.copyTo(base64Stream)
    }
    outputStream.toString(Charsets.UTF_8)
}