package br.com.namesa.domain.extensions

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface WithLog {
    val log: Logger
        get() = LoggerFactory.getLogger(this::class.java)
}