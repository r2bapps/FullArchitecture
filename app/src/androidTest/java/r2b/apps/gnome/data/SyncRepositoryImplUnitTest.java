package r2b.apps.gnome.data;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.runner.RunWith;

import java.io.IOException;

import r2b.apps.gnome.DependencyManager;
import r2b.apps.gnome.data.mock.PeopleMock;
import r2b.apps.gnome.data.mock.WebServerMock;

@RunWith(AndroidJUnit4.class)
public class SyncRepositoryImplUnitTest extends RepositoryImplUnitTest {

    @Before
    @Override
    public void setUp() throws IOException {
        repository = new SyncRepositoryImpl(
                DependencyManager.getRestSource(),
                DependencyManager.getDbSource(),
                DependencyManager.getSyncStrategy());
        people = PeopleMock.getPeople();
    }

}
