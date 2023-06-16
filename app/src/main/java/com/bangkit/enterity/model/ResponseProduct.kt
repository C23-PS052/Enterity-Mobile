package com.bangkit.enterity.model

data class ResponseProduct(
	val code: Int? = null,
	val data: List<DataItemProduct?>? = null,
	val message: String? = null,
	val totalProduk: Int? = null,
	val status: String? = null
)

data class DataItemProduct(
	val createdAt: String? = null,
	val nama_produk: String? = null,
	val harga_produk: Int? = null,
	val id: String? = null,
	val stok: Int? = null,
	val url_produk: String? = null,
	val updated_at: String? = null
)

