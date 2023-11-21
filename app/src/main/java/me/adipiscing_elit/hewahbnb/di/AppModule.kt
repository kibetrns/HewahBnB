package me.adipiscing_elit.hewahbnb.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import me.adipiscing_elit.hewahbnb.data.repository.HBRepository
import me.adipiscing_elit.hewahbnb.data.service.HBService
import me.adipiscing_elit.hewahbnb.data.service.HBServiceImpl
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    @Named("default")
    fun provideDefaultHttpClient(): HttpClient = HttpClient(CIO) {

        engine {
            requestTimeout = 5_000
        }
        install(Logging) {
            level = LogLevel.ALL
            logger = Logger.ANDROID
        }

        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

    }

    @Provides
    fun provideCSAService(
        @Named("default") defaultCSAService: HttpClient
    ): HBService = HBServiceImpl(defaultCSAService = defaultCSAService)

    @Provides
    fun provideCSARepository(
        hbService: HBService
    ) = HBRepository(
        hBService = hbService
    )

}