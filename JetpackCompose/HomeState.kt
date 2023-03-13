

data class HomeState(
    val data: List<AnimeData> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
