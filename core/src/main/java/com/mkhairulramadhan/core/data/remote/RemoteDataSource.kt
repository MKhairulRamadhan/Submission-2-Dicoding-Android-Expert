package com.mkhairulramadhan.core.data.remote

import android.util.Log
import com.mkhairulramadhan.core.retrofit.ServiceApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiRequest: ServiceApi) {

    fun getAllMovie(): Flow<ApiResponse<List<MovieDataItem>>> {
        return flow {
            try {
                val response = apiRequest.getAllMovie("6d3b5d87fff90c4cd594da0e61974684")
                val movieArray = response.results
                if (movieArray.isNotEmpty()){
                    emit(ApiResponse.Success(movieArray))
                }else{
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getDetailMovie(id: Int): Flow<ApiResponse<MovieDataItem>>{
        return flow {
            try {
                val movieData = apiRequest.getDetailMovie(id, "6d3b5d87fff90c4cd594da0e61974684")
                emit(ApiResponse.Success(movieData))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getAllTv(): Flow<ApiResponse<List<TvDataItem>>>{
        return flow {
            try {
                val response = apiRequest.getAllTv("6d3b5d87fff90c4cd594da0e61974684")
                val tvArray = response.results
                if (tvArray.isNotEmpty()){
                    emit(ApiResponse.Success(tvArray))
                }else{
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getDetailTv(id:Int): Flow<ApiResponse<TvDataItem>>{
        return flow {
            try {
                val tvData = apiRequest.getDetailTv(id, "6d3b5d87fff90c4cd594da0e61974684")
                emit(ApiResponse.Success(tvData))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

}