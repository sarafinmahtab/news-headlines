package com.practice.newsheadlines.helpers

import android.util.Log


/*
 * Created by Arafin Mahtab on 7/10/2021.
 */

object ResolveApiResponse {

    suspend fun <T> resolve(classTag: String, updateCall: suspend () -> T) =
        try {
            Results.Success(updateCall.invoke())
        } catch (throwable: Throwable) {
            Log.w(classTag, throwable)
            throwable.printStackTrace()
            Results.Failure(throwable)
        }
}
