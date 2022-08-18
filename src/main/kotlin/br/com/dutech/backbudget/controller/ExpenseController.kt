package br.com.dutech.backbudget.controller

import br.com.dutech.backbudget.dto.NewExpenseForm
import br.com.dutech.backbudget.model.Expense
import br.com.dutech.backbudget.service.ExpenseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/expenses")
class ExpenseController(val service: ExpenseService) {

    @GetMapping
    fun getExpenseList(): List<Expense> {
        return service.getExpenseList()
    }

    @GetMapping("/{id}")
    fun getExpenseDetail(@PathVariable id: Long): Expense {
        return service.getExpenseDetail(id)
    }

    @PostMapping
    fun registerExpense(@RequestBody @Valid form: NewExpenseForm){
        service.registerExpense(form)
    }


}