

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class LoginUiState(
    var isLoading: Boolean = false,
    var success: Boolean = false,
    var message: String = "",
)

class LoginViewModel : BaseViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())

    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun resetMessage() {
        _uiState.update {
            it.copy(message = "")
        }
    }

    fun login(username: String, password: String) {
        if (username.isBlank()) {
            _uiState.update {
                it.copy(message = "aaaa")
            }
            return
        }
        if (password.isBlank()) {
            _uiState.update {
                it.copy(message = "bbbb")
            }
            return
        }
        _uiState.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            val response = post<Login> {
                setUrl("user/login")
                putParam("username", username)
                putParam("password", password)
            }
            WanHelper.setUser(response.data)
            _uiState.update {
                it.copy(
                    isLoading = false,
                    success = response.errorCode == "0",
                    message = response.errorMsg
                )
            }
        }
    }

}