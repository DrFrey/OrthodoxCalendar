package com.example.orthodoxcalendar.common

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CoroutinesModule {

    //Dispatchers

    @DispatcherMain
    @Provides
    fun providesDispatcherMain(): CoroutineDispatcher = Dispatchers.Main

    @DispatcherMainImmediate
    @Provides
    fun providesDispatcherMainImmediate(): CoroutineDispatcher = Dispatchers.Main.immediate

    @DispatcherDefault
    @Provides
    fun providesDispatcherDefault(): CoroutineDispatcher = Dispatchers.Default

    @DispatcherIo
    @Provides
    fun providesDispatcherIo(): CoroutineDispatcher = Dispatchers.IO


    //Scopes

    /**
     * For operations that should be not dependent on caller lifecycle
     */
    @Singleton
    @ApplicationScope
    @Provides
    fun providesApplicationScope(): CoroutineScope = CoroutineScope(SupervisorJob())

    /**
     * For IO operations that should be not dependent on caller lifecycle
     */
    @Singleton
    @ApplicationIoScope
    @Provides
    fun providesApplicationIoScope(@DispatcherIo dispatcherIo: CoroutineDispatcher): CoroutineScope =
            CoroutineScope(SupervisorJob() + dispatcherIo)
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DispatcherMain

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DispatcherMainImmediate

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DispatcherDefault

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DispatcherIo

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationIoScope