package com.example.vietnam01.samplemvp.di.module

import com.example.vietnam01.samplemvp.model.http.api.RenosyApis
import com.example.vietnam01.samplemvp.model.http.api.AwsApis
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
class HttpModule {

  @Singleton
  @Provides
  fun provideRetrofitBuilder(): Retrofit.Builder {
    return Retrofit.Builder()
  }

  @Singleton
  @Provides
  fun provideGson(): Gson {
    return Gson()
  }

  @Singleton
  @Provides
  fun provideOkHttpBuilder(): OkHttpClient.Builder {
    return OkHttpClient.Builder()
  }

  @Singleton
  @Provides
  @Named(RenosyApis.TAG)
  fun provideRenosyRetrofit(builder: Retrofit.Builder, client: OkHttpClient): Retrofit = createRetrofit(builder, client, RenosyApis.BASE_URL)

  @Singleton
  @Provides
  @Named(AwsApis.TAG)
  fun provideAwsRetrofit(builder: Retrofit.Builder, client: OkHttpClient): Retrofit = createRetrofit(builder, client, AwsApis.BASE_URL)

  @Singleton
  @Provides
  @Named(RenosyApis.TAG)
  fun provideRenosyService(@Named(RenosyApis.TAG) retrofit: Retrofit): RenosyApis {
    return retrofit.create(RenosyApis::class.java)
  }

  @Singleton
  @Provides
  @Named(AwsApis.TAG)
  fun provideAwsService(@Named(AwsApis.TAG) retrofit: Retrofit): AwsApis {
    return retrofit.create(AwsApis::class.java)
  }

  @Singleton
  @Provides
  fun provideClient(builder: OkHttpClient.Builder): OkHttpClient {
    return builder.apply {
      connectTimeout(60, TimeUnit.SECONDS)
      readTimeout(60, TimeUnit.SECONDS)
      writeTimeout(60, TimeUnit.SECONDS)
      retryOnConnectionFailure(true)
    }.build()
  }

  private fun createRetrofit(builder: Retrofit.Builder, client: OkHttpClient, url: String): Retrofit {
    return builder
        .baseUrl(url)
        .client(client)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
  }
}