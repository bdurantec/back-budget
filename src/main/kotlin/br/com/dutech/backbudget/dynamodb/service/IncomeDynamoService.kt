package br.com.dutech.backbudget.dynamodb.service

import br.com.dutech.backbudget.dynamodb.model.IncomeDynamoDb

interface IncomeDynamoService {

    fun getIncome(id: String): IncomeDynamoDb

}