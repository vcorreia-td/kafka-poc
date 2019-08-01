package org.talkdesk.kafkapoc

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties
class KafkaConsumerProperties {
    val url = "localhost:29092"
    val groupId = "xpto"
}