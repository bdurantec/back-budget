package br.com.dutech.backbudget.dynamodb.service

import br.com.dutech.backbudget.dynamodb.model.IncomeDynamo

interface IncomeDynamoService {

    fun getIncome(id: Long): IncomeDynamo

}