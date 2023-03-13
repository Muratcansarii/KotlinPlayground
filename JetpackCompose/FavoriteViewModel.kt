

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val favoriteRepository: FavoriteRepository):ViewModel(){

    val allFavorites = favoriteRepository.getAllFavorites()

    fun insertFavorite(favorite: Favorite){
        viewModelScope.launch {
            favoriteRepository.insertFavorite(favorite)
        }
    }
    fun isFavorite(id:Int):LiveData<Boolean>{
        return favoriteRepository.isFavorite(id)
    }

    fun getOneAnime(id: Int): AnimeData{
       return favoriteRepository.getOneFavorite(id).toAnimeData()
    }

    fun deleteOneFavorite(favorite: Favorite) {
        viewModelScope.launch {
            favoriteRepository.deleteOneFavorite(favorite)
        }
    }
     fun deleteAllFavorites() {
        viewModelScope.launch {
            favoriteRepository.deleteAllFavorite()
        }
    }
}