package br.com.dutech.backbudget.service

import br.com.dutech.backbudget.model.Income
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class IncomeService(private var incomes: List<Income>) {

    init {
        val income1 = Income(
            id = 1,
            description = "My salary!",
            value = 500.00,
            date = LocalDateTime.now()
        )
        val income2 = Income(
            id = 2,
            description = "My sales!",
            value = 300.00,
            date = LocalDateTime.now()
        )

        incomes = Arrays.asList(income1, income2)
    }

    fun getIncomeList(): List<Income>{
        return incomes
    }

    fun getIncomeDetail(id: Long): Income {
        return incomes.stream().filter {
            i -> i.id == id
        }.findFirst().get()
    }

}