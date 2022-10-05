package br.com.dutech.backbudget.dynamodb.model

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable

@DynamoDBTable(tableName = "tb_expense_back_budget")
data class ExpenseDynamoDb (
    @DynamoDBAttribute(attributeName = "id")
    var id: String? = null,
    @DynamoDBAttribute(attributeName = "description")
    val description: String,
    @DynamoDBAttribute(attributeName = "value")
    val value: Double,
    @DynamoDBAttribute(attributeName = "date")
    val date: String
)