package br.com.dutech.backbudget.dynamodb.service.impl

import br.com.dutech.backbudget.dynamodb.model.IncomeDynamoDb
import br.com.dutech.backbudget.dynamodb.service.IncomeDynamoService
import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper

class IncomeDynamoServiceImpl: IncomeDynamoService {

    override fun getIncome(id: String): IncomeDynamoDb {
        val client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build()
        val mapper = DynamoDBMapper(client)
        return mapper.load(IncomeDynamoDb::class.java, id)
    }

}