package com.bangkit.enterity.model

data class ResponseProductChannel(
	val code: Int? = null,
	val data: List<DataItem?>? = null,
	val message: String? = null,
	val totalProduk: Int? = null,
	val status: String? = null
)

data class Produk(
	val nama_produk: String? = null,
	val id: String? = null,
	val stok: Int? = null,
	val url_produk: String? = null
)

data class DataItem(
	val produk: Produk? = null,
	val platform_id: Int? = null,
	val platform: Platforme? = null
)

data class Platforme(
	val nama_channel: String? = null
)

