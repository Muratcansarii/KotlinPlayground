
data class CharacterState(
    val characters :List<CharacterData> = emptyList(),
    val isLoading:Boolean = false,
    val error:String? = null
)
