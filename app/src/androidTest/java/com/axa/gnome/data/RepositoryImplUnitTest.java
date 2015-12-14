package com.axa.gnome.data;

import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import com.axa.gnome.DependencyManager;
import com.axa.gnome.data.mock.PeopleMock;
import com.axa.gnome.data.mock.WebServerMock;
import com.axa.gnome.domain.Repository;
import com.axa.gnome.domain.model.People;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class RepositoryImplUnitTest {

    protected WebServerMock webServer;
    protected Repository repository;
    protected People people;

    @Before
    public void setUp() throws IOException {
        webServer = new WebServerMock();
        repository = new RepositoryImpl(DependencyManager.getRestSource());
        people = PeopleMock.getPeople();
    }

    @After
    public void tearDown() throws IOException {
        webServer.shutdown();
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
