package r2b.apps.gnome;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import r2b.apps.gnome.data.CachedRepositoryImplUnitTest;
import r2b.apps.gnome.data.RepositoryImplUnitTest;
import r2b.apps.gnome.data.SyncRepositoryImplUnitTest;

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
