package com.bangkit.enterity.model

import com.google.gson.annotations.SerializedName

data class ResponsePelanggan(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: List<DataItemPelanggan?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class DataItemPelanggan(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("nama_pelanggan")
	val nama_pelanggan: String? = null,

	@field:SerializedName("url_pelanggan")
	val url_pelanggan: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("jenis_kelamin")
	val jenis_kelamin: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("no_telepon")
	val noTelepon: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)
