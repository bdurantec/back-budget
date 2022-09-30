package br.com.dutech.backbudget.service

import br.com.dutech.backbudget.dto.ExpenseView
import br.com.dutech.backbudget.dto.NewExpenseForm
import br.com.dutech.backbudget.dto.UpdateExpenseDTO
import br.com.dutech.backbudget.exception.NotFoundException
import br.com.dutech.backbudget.mapper.ExpenseFormMapper
import br.com.dutech.backbudget.mapper.ExpenseViewMapper
import br.com.dutech.backbudget.model.Expense
import org.springframework.stereotype.Service

@Service
class ExpenseService(
    private var expenses: List<Expense>,
    private val expenseFormMapper: ExpenseFormMapper,
    private val expenseViewMapper: ExpenseViewMapper,
    private var notFoundMessage: String = "Expense not found."
) {

    fun getExpenseList(): List<Expense> {
        return expenses
    }

    fun getExpenseDetail(id: Long): Expense {
        return expenses.stream().filter { e ->
            e.id == id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }
    }

    fun registerExpense(form: NewExpenseForm): ExpenseView {
        val expense = expenseFormMapper.map(form)
        expense.id = expenses.size.toLong() + 1
        expenses = expenses.plus(expense)
        return expenseViewMapper.map(expense)
    }

    fun update(dto: UpdateExpenseDTO): ExpenseView {
        val expense = expenses.stream().filter { e ->
            e.id == dto.id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }

        val newExpense = Expense(
            id = expense.id,
            description = dto.description,
            value = dto.value,
            date = expense.date
        )

        expenses = expenses.minus(expense).plus(newExpense)
        return expenseViewMapper.map(newExpense)
    }

    fun deleteExpense(id: Long) {
        val expense = expenses.stream().filter {
            e -> e.id == id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }

        expenses = expenses.minus(expense)
    }

}