package foo.bar.feature_test.di

import foo.bar.feature_test.presentation.TestScreenMapper
import foo.bar.feature_test.presentation.TestScreenMapperImpl
import foo.bar.feature_test.presentation.TestViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val TestModule = module {

    singleOf(::TestScreenMapperImpl) bind TestScreenMapper::class

    viewModelOf(::TestViewModel)
}