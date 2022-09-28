package br.com.dutech.backbudget.controller

import br.com.dutech.backbudget.dto.ExpenseView
import br.com.dutech.backbudget.dto.NewExpenseForm
import br.com.dutech.backbudget.dto.UpdateExpenseDTO
import br.com.dutech.backbudget.model.Expense
import br.com.dutech.backbudget.service.ExpenseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
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
    fun registerExpense(
        @RequestBody @Valid form: NewExpenseForm, uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ExpenseView> {
        val expense = service.registerExpense(form)
        val uri = uriBuilder.path("/expenses/${expense.id}").build().toUri()
        return ResponseEntity.created(uri).body(expense)
    }

    @PutMapping
    fun updateExpense(@RequestBody @Valid dto: UpdateExpenseDTO): ResponseEntity<ExpenseView> {
        val expenseView = service.update(dto)
        return ResponseEntity.ok(expenseView)
    }


}