package com.ryanrvldo.devhub.core

import com.ryanrvldo.devhub.core.data.repository.RepositorySuiteTest
import com.ryanrvldo.devhub.core.util.UtilSuiteTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.runner.RunWith
import org.junit.runners.Suite

@ExperimentalCoroutinesApi
@RunWith(Suite::class)
@Suite.SuiteClasses(
    RepositorySuiteTest::class,
    UtilSuiteTest::class
)
class CoreSuiteTest
