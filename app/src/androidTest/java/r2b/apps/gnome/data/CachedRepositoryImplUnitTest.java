package r2b.apps.gnome.data;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.runner.RunWith;

import java.io.IOException;

import r2b.apps.gnome.DependencyManager;

@RunWith(AndroidJUnit4.class)
public class CachedRepositoryImplUnitTest extends RepositoryImplUnitTest {

    @Before
    @Override
    public void setUp() throws IOException {
        repository = new CachedRepositoryImpl(
                DependencyManager.getRestSource(),
                DependencyManager.getDbSource(),
                DependencyManager.getCachingStrategy());
    }

}