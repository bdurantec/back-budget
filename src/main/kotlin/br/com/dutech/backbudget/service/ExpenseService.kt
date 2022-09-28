package br.com.dutech.backbudget.service

import br.com.dutech.backbudget.dto.ExpenseView
import br.com.dutech.backbudget.dto.NewExpenseForm
import br.com.dutech.backbudget.mapper.ExpenseFormMapper
import br.com.dutech.backbudget.mapper.ExpenseViewMapper
import br.com.dutech.backbudget.model.Expense
import org.springframework.stereotype.Service

@Service
class ExpenseService(
    private var expenses: List<Expense>,
    private val expenseFormMapper: ExpenseFormMapper,
    private val expenseViewMapper: ExpenseViewMapper
) {

    fun getExpenseList(): List<Expense> {
        return expenses
    }

    fun getExpenseDetail(id: Long): Expense {
        return expenses.stream().filter { e ->
            e.id == id
        }.findFirst().get()
    }

    fun registerExpense(form: NewExpenseForm): ExpenseView {
        val expense = expenseFormMapper.map(form)
        expense.id = expenses.size.toLong() + 1
        expenses = expenses.plus(expense)
        return expenseViewMapper.map(expense)
    }

}