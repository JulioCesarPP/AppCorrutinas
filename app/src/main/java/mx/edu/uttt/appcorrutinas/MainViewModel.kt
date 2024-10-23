package mx.edu.uttt.appcorrutinas

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class MainViewModel : ViewModel() {
    var resultState by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun fetchData() {
        viewModelScope.launch {
            try {
                isLoading = true
                LoadApi()
            }catch (e:Exception){
                println("Error : ${e.message}")
            }finally {
                isLoading = false
            }
//            var result = withContext(Dispatchers.IO) {
//                delay(5000)
//                "Respuesta desde la API"
//            }
//            resultState = result
        }
    }

    private suspend fun LoadApi(){
        val resultado = withContext(Dispatchers.IO){
            delay(5000)
            "Respuesta de la API"
        }
        resultState = resultado;
    }

    fun bloquoAppSimulado() {
        Thread.sleep(5000)
        resultState = "respuesta desde la api"
    }
}