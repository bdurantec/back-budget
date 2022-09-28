package br.com.dutech.backbudget.mapper

import br.com.dutech.backbudget.dto.NewIncomeForm
import br.com.dutech.backbudget.model.Income
import org.springframework.stereotype.Component

@Component
class IncomeFormMapper: Mapper<NewIncomeForm, Income> {
    override fun map(t: NewIncomeForm): Income {
        return Income(
            description = t.description,
            value = t.value,
            date = t.date
        )
    }

}
