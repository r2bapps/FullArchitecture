package com.axa.gnome;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.axa.gnome.data.CachedRepositoryImplUnitTest;
import com.axa.gnome.data.RepositoryImplUnitTest;
import com.axa.gnome.data.SyncRepositoryImplUnitTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                RepositoryImplUnitTest.class,
                CachedRepositoryImplUnitTest.class,
                SyncRepositoryImplUnitTest.class,
        }
)
/**
 * Runs all unit tests.
 */
public class UnitTestSuite {

}
