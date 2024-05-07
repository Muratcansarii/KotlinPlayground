

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository
) : ViewModel() {

    private val _characterState = mutableStateOf(CharacterState())
    val characterStata: State<CharacterState> = _characterState


    fun getCharacter(malId: Int) {
        viewModelScope.launch {
            _characterState.value = characterStata.value.copy(
                isLoading = true
            )
            charactersRepository.getCharacter(malId).collectLatest { character ->
                when (character) {
                    is Resource.Success -> {
                        Timber.d(character.toString())
                        _characterState.value = characterStata.value.copy(
                            characters = character.data?.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Resource.Failure -> {
                        _characterState.value = characterStata.value.copy(
                            error = character.message,
                            isLoading = false
                        )
                    }
                }
            }
        }
    }
}