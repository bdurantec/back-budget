package br.com.dutech.backbudget.mapper

import br.com.dutech.backbudget.dto.NewExpenseForm
import br.com.dutech.backbudget.model.Expense
import org.springframework.stereotype.Component

@Component
class ExpenseFormMapper : Mapper<NewExpenseForm, Expense> {

    override fun map(t: NewExpenseForm): Expense {
        return Expense(
            description = t.description,
            value = t.value,
            date = t.date
        )
    }

}