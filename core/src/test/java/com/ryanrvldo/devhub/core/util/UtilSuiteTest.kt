package com.ryanrvldo.devhub.core.util

import com.ryanrvldo.devhub.core.util.mapper.MapperSuiteTest
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtilTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MapperSuiteTest::class,
    NullableValidationUtilTest::class
)
class UtilSuiteTest
