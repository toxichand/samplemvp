package com.example.vietnam01.samplemvp.di.module

import com.example.vietnam01.samplemvp.app.Constant
import com.example.vietnam01.samplemvp.model.http.api.NewApis
import com.example.vietnam01.samplemvp.model.http.api.PhotoApis
import com.example.vietnam01.samplemvp.model.http.api.UserApis
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
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
  @Named(Constant.Host.RENOSY)
  fun provideRenosyRetrofit(builder: Retrofit.Builder, client: OkHttpClient): Retrofit = createRetrofit(builder, client, Constant.BaseURL.RENOSY.URL)

  @Singleton
  @Provides
  @Named(Constant.Host.AWS)
  fun provideAwsRetrofit(builder: Retrofit.Builder, client: OkHttpClient): Retrofit = createRetrofit(builder, client, Constant.BaseURL.AWS.URL)

  @Singleton
  @Provides
  @Named(NewApis.NAME)
  fun provideRenosyService(@Named(Constant.Host.RENOSY) retrofit: Retrofit): NewApis {
    return retrofit.create(NewApis::class.java)
  }

  @Singleton
  @Provides
  @Named(UserApis.NAME)
  fun provideUserService(@Named(Constant.Host.RENOSY) retrofit: Retrofit): UserApis {
    return retrofit.create(UserApis::class.java)
  }

  @Singleton
  @Provides
  @Named(PhotoApis.NAME)
  fun provideAwsService(@Named(Constant.Host.AWS) retrofit: Retrofit): PhotoApis {
    return retrofit.create(PhotoApis::class.java)
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
        .addConverterFactory(MoshiConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
  }
}