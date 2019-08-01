package org.talkdesk.kafkapoc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.util.concurrent.ListenableFutureCallback
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpStatusCodeException
import org.springframework.kafka.annotation.KafkaListener



@RestController
class AppController(
    @Autowired val kafkaTemplate: KafkaTemplate<String, String>
) {

    @PostMapping("/stuff")
    fun stuff() : String {
        val future = kafkaTemplate.send("my_topic", "THIS IS ANOTHER MESSAGE")

        future.addCallback(
            object: ListenableFutureCallback<SendResult<String, String>> {
                override fun onSuccess(result: SendResult<String, String>) {
                    println("Result: ${result}")
                }

                override fun onFailure(ex: Throwable) {
                    ex.printStackTrace()
                    if (ex is HttpStatusCodeException) {
                        println(ex.responseBodyAsString)
                    }
                }
            }
        )

        return "Hello World"
    }

    @KafkaListener(topics = ["my_topic"], groupId = "xpto")
    fun listen(message: String) {
        println("Received Messasge in group xpto: $message")
    }
}