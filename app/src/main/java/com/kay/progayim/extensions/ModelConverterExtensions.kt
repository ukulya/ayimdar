package com.kay.progayim.extensions

import com.kay.progayim.data.models.CharacterDto
import com.kay.progayim.data.models.CharacterEntity


fun CharacterDto.toCharacterEntity(): CharacterEntity {

    return CharacterEntity(
        id = this.id,
        name = this.name,
        status = this.status,
        species = this.species,
        type = this.type,
        gender = this.gender,
        image = this.image,
        url = this.url,
        created = this.created,
        episode = this.episode,
    )
}