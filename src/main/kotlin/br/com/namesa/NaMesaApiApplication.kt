package br.com.namesa

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NaMesaApiApplication

fun main(args: Array<String>) {
	runApplication<NaMesaApiApplication>(*args)
}
