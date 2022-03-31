package com.kay.progayim.extensions

import com.kay.progayim.data.models.CharacterDto
import com.kay.progayim.data.models.CharacterEntity


fun CharacterDto.toCharacterEntity(): CharacterEntity {

    return CharacterEntity(
        char_id = this.char_id,
        name = this.name,
        birthday = this.birthday,
        img = this.img,
        status = this.status,
        nickname = this.nickname,
        portrayed = this.portrayed,
        category = this.category,

    )
}