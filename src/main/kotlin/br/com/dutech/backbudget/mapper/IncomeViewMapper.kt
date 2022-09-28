package br.com.dutech.backbudget.mapper

import br.com.dutech.backbudget.dto.IncomeView
import br.com.dutech.backbudget.model.Income
import org.springframework.stereotype.Component

@Component
class IncomeViewMapper : Mapper<Income, IncomeView> {
    override fun map(t: Income): IncomeView {
        return IncomeView(
            id = t.id,
            description = t.description,
            value = t.value
        )
    }
}