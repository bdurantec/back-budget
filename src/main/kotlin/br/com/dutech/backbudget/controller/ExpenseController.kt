package br.com.dutech.backbudget.controller

import br.com.dutech.backbudget.model.Expense
import br.com.dutech.backbudget.service.ExpenseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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


}