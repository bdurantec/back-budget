package br.com.dutech.backbudget.dto

import javax.validation.constraints.DecimalMin
import javax.validation.constraints.NotEmpty

data class NewExpenseForm(
    @field:NotEmpty
    val description: String,
    @field:DecimalMin("1.00")
    val value: Double,
    @field:NotEmpty
    val date: String
)
