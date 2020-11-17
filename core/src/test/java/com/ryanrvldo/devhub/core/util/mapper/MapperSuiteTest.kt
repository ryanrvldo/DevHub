package com.ryanrvldo.devhub.core.util.mapper

import com.ryanrvldo.devhub.core.util.mapper.impl.AccessTokenResponseToDomainMapperTest
import com.ryanrvldo.devhub.core.util.mapper.impl.UserDetailsResponseToDomainMapperTest
import com.ryanrvldo.devhub.core.util.mapper.impl.UserPlanResponseToDomainMapperTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    AccessTokenResponseToDomainMapperTest::class,
    UserDetailsResponseToDomainMapperTest::class,
    UserPlanResponseToDomainMapperTest::class
)
class MapperSuiteTest
