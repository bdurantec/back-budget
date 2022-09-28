package br.com.dutech.backbudget.controller

import br.com.dutech.backbudget.dto.IncomeView
import br.com.dutech.backbudget.dto.NewIncomeForm
import br.com.dutech.backbudget.model.Income
import br.com.dutech.backbudget.service.IncomeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/incomes")
class IncomeController(val service: IncomeService) {

    @GetMapping
    fun getIncomeList(): List<Income> {
        return service.getIncomeList()
    }

    @GetMapping("/{id}")
    fun getIncomeDetail(@PathVariable id: Long): Income {
        return service.getIncomeDetail(id)
    }

    @PostMapping
    fun registerIncome(@RequestBody form: NewIncomeForm, uriBuilder: UriComponentsBuilder): ResponseEntity<IncomeView>{
        val income = service.registerIncome(form)
        val uri = uriBuilder.path("incomes/${income.id}").build().toUri()
        return ResponseEntity.created(uri).body(income)
    }

}