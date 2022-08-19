package br.com.dutech.backbudget.service

import br.com.dutech.backbudget.dto.NewIncomeForm
import br.com.dutech.backbudget.mapper.NewIncomeFormMapper
import br.com.dutech.backbudget.model.Income
import org.springframework.stereotype.Service

@Service
class IncomeService(
    private var incomes: List<Income>,
    private var newIncomeFormMapper: NewIncomeFormMapper
) {

    fun getIncomeList(): List<Income> {
        return incomes
    }

    fun getIncomeDetail(id: Long): Income {
        return incomes.stream().filter { i ->
            i.id == id
        }.findFirst().get()
    }

    fun registerIncome(form: NewIncomeForm) {
        val income = newIncomeFormMapper.map(form)
        income.id = incomes.size.toLong() + 1
        incomes = incomes.plus(income)
    }

}