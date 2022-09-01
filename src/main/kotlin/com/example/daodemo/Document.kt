package com.example.daodemo

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("document")
data class Document (
        @Id
        val id: Long?,
        val name: String,
)