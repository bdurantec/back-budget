package br.com.dutech.backbudget.dynamodb.service.impl

import br.com.dutech.backbudget.dynamodb.model.IncomeDynamo
import br.com.dutech.backbudget.dynamodb.service.IncomeDynamoService
import com.amazonaws.auth.InstanceProfileCredentialsProvider
import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import org.springframework.stereotype.Service

@Service
class IncomeDynamoServiceImpl : IncomeDynamoService {

    override fun getIncome(id: Long): IncomeDynamo {
        val credentials: InstanceProfileCredentialsProvider =
            InstanceProfileCredentialsProvider.createAsyncRefreshingProvider(true);
        val client = AmazonDynamoDBClientBuilder
            .standard().withCredentials(credentials).withRegion(Regions.US_EAST_1)
            .build()
        val mapper = DynamoDBMapper(client)
        return mapper.load(IncomeDynamo::class.java, id)
    }

}