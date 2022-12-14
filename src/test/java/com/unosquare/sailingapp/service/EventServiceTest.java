package com.unosquare.sailingapp.service;

import com.flextrade.jfixture.FixtureAnnotations;
import com.flextrade.jfixture.JFixture;
import com.flextrade.jfixture.annotations.Fixture;
import com.unosquare.sailingapp.configuration.Mapper;
import com.unosquare.sailingapp.dto.CreateEventDTO;
import com.unosquare.sailingapp.dto.EventDTO;
import com.unosquare.sailingapp.entity.Event;
import com.unosquare.sailingapp.entity.EventBoat;
import com.unosquare.sailingapp.model.EventViewModel;
import com.unosquare.sailingapp.model.UpdateEventViewModel;
import com.unosquare.sailingapp.repository.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventServiceTest {
    @Fixture
    private Event eventFixture;
    @Fixture
    private EventDTO eventDTOFixture;
    @Fixture
    private List<Event> eventListFixture;
    @Fixture
    private List<EventDTO> eventDTOListFixture;
    @Fixture
    private List<EventViewModel> eventViewModelListFixture;
    @Fixture
    private EventViewModel eventViewModelFixture;
    @Fixture
    private CreateEventDTO createEventDTOFixture;
    @Fixture
    private UpdateEventViewModel updateEventViewModelFixture;
    @Mock
    private EventRepository eventRepositoryMock;
    @Mock
    private Mapper mapperMock;
    @Mock
    private JFixture jFixture;
    @InjectMocks
    private EventService classUnderTest;
    private Integer id = 1;
    @BeforeEach
    public void setup() {


        jFixture = new JFixture();
        jFixture.customise()
                .circularDependencyBehaviour().omitSpecimen();



        FixtureAnnotations.initFixtures(this, jFixture);

    }

    @Test
    public void getAllEvents_ReturnsOk(){
        when(eventRepositoryMock.findAll()).thenReturn(eventListFixture);
        when(mapperMock.map(eventListFixture, EventDTO.class)).thenReturn(eventDTOListFixture);
        classUnderTest.getAllEvents();

        assertThat(eventDTOListFixture).isNotNull();
        assertThat(classUnderTest.getAllEvents()).isNotNull();
        assertThat(eventDTOListFixture).hasSize(3);
    }

    @Test
    public void getEventByID_ReturnsOk(){
        when(eventRepositoryMock.findById(id)).thenReturn(Optional.ofNullable(eventFixture));
        when(mapperMock.map(eventFixture, EventDTO.class)).thenReturn(eventDTOFixture);

        assertThat(eventDTOFixture).isNotNull();
        assertThat(classUnderTest.getEventByID(id)).isNotNull();
    }

    @Test
    public void createEvent_ReturnsOk(){
        when(mapperMock.map(createEventDTOFixture, Event.class)).thenReturn(eventFixture);
        eventFixture.setName("Test Name");
        when(eventRepositoryMock.save(eventFixture)).thenReturn(eventFixture);
        createEventDTOFixture.setName("Test Name");

        classUnderTest.createEvent(createEventDTOFixture);

        assertThat(createEventDTOFixture).isNotNull();
        assertThat(eventFixture.getName()).isEqualTo(createEventDTOFixture.getName());
    }

    @Test
    public void updateEvent_ReturnsOk(){
        when(eventRepositoryMock.findById(id)).thenReturn(Optional.ofNullable(eventFixture));
        eventFixture.setName("EDYC Event 4");
        when(eventRepositoryMock.save(eventFixture)).thenReturn(eventFixture);
        updateEventViewModelFixture.setName("EDYC Event 4");
        classUnderTest.updateEvent(id, updateEventViewModelFixture);

        assertThat(updateEventViewModelFixture).isNotNull();
        assertThat(eventFixture.getName()).isEqualTo(updateEventViewModelFixture.getName());
    }

}
