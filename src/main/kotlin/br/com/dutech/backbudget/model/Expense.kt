package br.com.dutech.backbudget.model

data class Expense(
    var id: Long? = null,
    val description: String,
    val value: Double,
    val date: String
)