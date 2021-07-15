package com.neosoft.mymvvm.model

data class Data(
    val id: Int,
    val product_category_id: Int,
    val name: String,
    val producer: String,
    val description: String,
    val cost: Int,
    val rating: Int,
    val view_count: Int,
    val created: String,
    val modified: String,
    val product_images: String
)
