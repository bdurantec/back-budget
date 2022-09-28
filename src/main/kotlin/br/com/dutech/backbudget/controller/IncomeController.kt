package br.com.dutech.backbudget.controller

import br.com.dutech.backbudget.dto.IncomeView
import br.com.dutech.backbudget.dto.NewIncomeForm
import br.com.dutech.backbudget.dto.UpdateIncomeDTO
import br.com.dutech.backbudget.model.Income
import br.com.dutech.backbudget.service.IncomeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

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
    fun registerIncome(@RequestBody @Valid form: NewIncomeForm, uriBuilder: UriComponentsBuilder): ResponseEntity<IncomeView>{
        val income = service.registerIncome(form)
        val uri = uriBuilder.path("incomes/${income.id}").build().toUri()
        return ResponseEntity.created(uri).body(income)
    }

    @PutMapping
    fun updateIncome(@RequestBody @Valid dto: UpdateIncomeDTO): ResponseEntity<IncomeView>{
        val income = service.updateIncome(dto)
        return ResponseEntity.ok(income)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteIncome(@PathVariable id: Long){
        service.deleteIncome(id)
    }

}