package com.axa.gnome.data;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.runner.RunWith;

import java.io.IOException;

import com.axa.gnome.DependencyManager;
import com.axa.gnome.data.mock.PeopleMock;
import com.axa.gnome.data.mock.WebServerMock;

@RunWith(AndroidJUnit4.class)
public class SyncRepositoryImplUnitTest extends RepositoryImplUnitTest {

    @Before
    @Override
    public void setUp() throws IOException {
        webServer = new WebServerMock();
        repository = new SyncRepositoryImpl(
                DependencyManager.getRestSource(),
                DependencyManager.getDbSource(),
                DependencyManager.getSyncStrategy());
        people = PeopleMock.getPeople();
    }

}
