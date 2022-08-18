package br.com.dutech.backbudget.service

import br.com.dutech.backbudget.model.Expense
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class ExpenseService(private var expenses: List<Expense>) {

    init {
        val expense1 = Expense(
            id = 1,
            description = "Supermarket",
            value = 300.00,
            date = LocalDateTime.now()
        )
        val expense2 = Expense(
            id = 2,
            description = "Restaurant",
            value = 100.00,
            date = LocalDateTime.now()
        )

        expenses = Arrays.asList(expense1, expense2)
    }

    fun getExpenseList(): List<Expense> {
        return expenses
    }

    fun getExpenseDetail(id: Long): Expense {
        return expenses.stream().filter { e ->
            e.id == id
        }.findFirst().get()
    }

}