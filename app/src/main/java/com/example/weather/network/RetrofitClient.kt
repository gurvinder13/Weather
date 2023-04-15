
import androidx.databinding.library.BuildConfig
import com.example.weather.network.QueryParameterAddInterceptor
import com.google.gson.GsonBuilder

import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import java.util.logging.Level

object RetrofitClient {

    private var retrofit: Retrofit? = null
    private val gson = GsonBuilder().setLenient().create()

    val client: Retrofit
        get() {
            if (retrofit == null) {
                synchronized(Retrofit::class.java) {
                    if (retrofit == null) {

                        val httpClient = OkHttpClient.Builder()
                                .addInterceptor(QueryParameterAddInterceptor())

                        /*// for pretty log of HTTP request-response
                        httpClient.addInterceptor(
                                LoggingInterceptor.Builder()
                                        .loggable(BuildConfig.DEBUG)
                                        .setLevel(HttpLoggingInterceptor.Level.BASIC)
                                        .log(Platform.INFO)
                                        .request("LOG")
                                        .response("LOG")
                                        .executor(Executors.newSingleThreadExecutor())
                                        .build())*/

                        val client = httpClient.build()

                        retrofit = Retrofit.Builder()
                                .baseUrl("https://api.openweathermap.org/data/2.5/")
                                .addConverterFactory(GsonConverterFactory.create(gson))
                                .client(client)
                                .build()
                    }
                }

            }
            return retrofit!!
        }
}