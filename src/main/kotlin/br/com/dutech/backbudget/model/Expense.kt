package br.com.dutech.backbudget.model

import java.time.LocalDateTime

data class Expense(
    val id: Long? = null,
    val description: String,
    val value: Double,
    val date: LocalDateTime
)