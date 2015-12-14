package r2b.apps.gnome.data;

import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import r2b.apps.gnome.DependencyManager;
import r2b.apps.gnome.data.mock.PeopleMock;
import r2b.apps.gnome.data.mock.WebServerMock;
import r2b.apps.gnome.domain.Repository;
import r2b.apps.gnome.domain.model.People;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class RepositoryImplUnitTest {

    protected Repository repository;
    protected People people;

    @Before
    public void setUp() throws IOException {
        repository = new RepositoryImpl(DependencyManager.getRestSource());
        people = PeopleMock.getPeople();
    }

    @After
    public void tearDown() throws IOException {
    }

    @Test
    public void testGetPeople() throws Exception {
        assertNotNull(repository.getPeople());
    }

    @Test
    public void testGetPeopleSize() {
        assertEquals(people.size(), repository.getPeople().size());
    }

}
