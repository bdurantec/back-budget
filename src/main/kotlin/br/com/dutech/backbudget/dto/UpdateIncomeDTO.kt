package br.com.dutech.backbudget.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class UpdateIncomeDTO(
    @field:NotNull
    var id: Long? = null,
    @field:NotEmpty
    val description: String,
    @field:NotNull
    val value: Double
)
