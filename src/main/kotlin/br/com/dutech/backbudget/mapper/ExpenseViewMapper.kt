package br.com.dutech.backbudget.mapper

import br.com.dutech.backbudget.dto.ExpenseView
import br.com.dutech.backbudget.model.Expense
import org.springframework.stereotype.Component

@Component
class ExpenseViewMapper: Mapper<Expense, ExpenseView> {
    override fun map(t: Expense): ExpenseView {
        return ExpenseView(
            id = t.id,
            description = t.description,
            value = t.value
        )
    }

}
