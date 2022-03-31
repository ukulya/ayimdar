package com.kay.progayim.data.models

data class RepoResult(
    val items: List<Item>
)

data class Item(
    val char_id: Long?,
    val name: String?,
    val birthday: String?,
//    val owner: Owner,
    val img: Boolean,
    val status: String?,
    val nickname: String?,
    val portrayed: String?,
    val category: String?
)

//data class Owner(val login: String?, val id: Long?, val avatarUrl: String?)