package com.example.daodemo

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface DocumentRepository : ReactiveCrudRepository<Document, Long>