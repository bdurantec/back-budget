package br.com.dutech.backbudget.dynamodb.model

import com.amazonaws.services.dynamodbv2.datamodeling.*
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType

@DynamoDBTable(tableName = "tb_income_back_budget")
data class IncomeDynamo(
    @DynamoDBHashKey(attributeName = "id")
    var id: Long? = null,

    @DynamoDBTyped(DynamoDBAttributeType.S)
    @DynamoDBAttribute(attributeName = "description")
    var description: String = "",

    @DynamoDBTyped(DynamoDBAttributeType.N)
    @DynamoDBAttribute(attributeName = "value")
    var value: Double = 0.00,

    @DynamoDBTyped(DynamoDBAttributeType.S)
    @DynamoDBAttribute(attributeName = "date")
    var date: String = ""
)