package br.com.dutech.backbudget.service

import br.com.dutech.backbudget.dto.IncomeView
import br.com.dutech.backbudget.dto.NewIncomeForm
import br.com.dutech.backbudget.dto.UpdateIncomeDTO
import br.com.dutech.backbudget.mapper.IncomeFormMapper
import br.com.dutech.backbudget.mapper.IncomeViewMapper
import br.com.dutech.backbudget.model.Income
import org.springframework.stereotype.Service

@Service
class IncomeService(
    private var incomes: List<Income>,
    private var incomeFormMapper: IncomeFormMapper,
    private var incomeViewMapper: IncomeViewMapper
) {

    fun getIncomeList(): List<Income> {
        return incomes
    }

    fun getIncomeDetail(id: Long): Income {
        return incomes.stream().filter { i ->
            i.id == id
        }.findFirst().get()
    }

    fun registerIncome(form: NewIncomeForm): IncomeView {
        val income = incomeFormMapper.map(form)
        income.id = incomes.size.toLong() + 1
        incomes = incomes.plus(income)
        return incomeViewMapper.map(income)
    }

    fun updateIncome(dto: UpdateIncomeDTO): IncomeView? {
        val income = incomes.stream().filter{ i ->
            i.id == dto.id
        }.findFirst().get()

        val newIncome = Income(
            id = income.id,
            description = dto.description,
            value = dto.value,
            date = income.date
        )

        incomes = incomes.minus(income).plus(newIncome)
        return incomeViewMapper.map(newIncome)
    }

    fun deleteIncome(id: Long) {
        val income = incomes.stream().filter {
            i -> i.id == id
        }.findFirst().get()

        incomes = incomes.minus(income)
    }

}