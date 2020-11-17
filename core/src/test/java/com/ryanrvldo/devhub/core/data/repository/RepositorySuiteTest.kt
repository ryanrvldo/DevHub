package com.ryanrvldo.devhub.core.data.repository

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.runner.RunWith
import org.junit.runners.Suite

@ExperimentalCoroutinesApi
@RunWith(Suite::class)
@Suite.SuiteClasses(
    LoginRepositoryTest::class,
    SharedPrefRepositoryTest::class
)
class RepositorySuiteTest
