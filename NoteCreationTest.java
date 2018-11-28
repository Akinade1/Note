package com.owoade.akinade.notekeeper;

import android.support.test.espresso.ViewInteraction;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.*;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static org.hamcrest.Matchers.*;
import static android.support.test.espresso.Espresso.pressBack;

@RunWith(AndroidJUnit4.class)
public class NoteCreationTest {
   static DataManager sDataManager;

    @BeforeClass
    public static void classSetUp() throws Exception {
     sDataManager = DataManager.getInstance();
    }

     @Rule
        public ActivityTestRule<NoteListActivity> mNoteListActivityRule = new ActivityTestRule<>(NoteListActivity.class);

     @Test
    public void createNewNote(){
         final CourseInfo course = sDataManager.getCourse("java_lang");
         final String title = "This is the Title";
         final String body = "Ahere omo ayeko, Ogede omo ayedo";


         onView(withId(R.id.fab)).perform(click());

         onView(withId(R.id.course_spinner)).perform(click());
         onData(allOf(instanceOf(CourseInfo.class), equalTo(course))).perform(click());
         onView(withId(R.id.text_note_title)).perform(typeText(title));
         onView(withId(R.id.text_note_body)).perform(typeText(body), closeSoftKeyboard());

     pressBack();
     }
}