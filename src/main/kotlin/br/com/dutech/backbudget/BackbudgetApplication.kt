package br.com.dutech.backbudget

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BackbudgetApplication

fun main(args: Array<String>) {
	runApplication<BackbudgetApplication>(*args)
}
