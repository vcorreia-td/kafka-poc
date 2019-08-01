package org.talkdesk.kafkapoc

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties
class KafkaProducerProperties {
    val url = "localhost:29092"
}