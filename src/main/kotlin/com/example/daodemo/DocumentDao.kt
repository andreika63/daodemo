package com.example.daodemo

import org.reactivestreams.Publisher
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class DocumentDao(val delegate: DocumentRepository) : ReactiveCrudRepository<Document, Long> by delegate {

    override fun findById(id: Publisher<Long>): Mono<Document> {
        return delegate.findById(id)
                .switchIfEmpty(Mono.error(RuntimeException("document with id=$id not found")))
    }

    override fun findById(id: Long): Mono<Document> {
        return delegate.findById(id)
                .switchIfEmpty(Mono.error(RuntimeException("document with id=$id not found")))
    }
}