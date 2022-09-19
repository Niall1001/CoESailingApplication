package com.unosquare.sailingapp.controller;

import com.flextrade.jfixture.FixtureAnnotations;
import com.flextrade.jfixture.JFixture;
import com.flextrade.jfixture.annotations.Fixture;
import com.unosquare.sailingapp.configuration.Mapper;
import com.unosquare.sailingapp.dto.AppUserDTO;
import com.unosquare.sailingapp.model.AppUserViewModel;
import com.unosquare.sailingapp.service.AppUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AppUserControllerTest {
    @Fixture
    private List<AppUserViewModel> appUserViewModelListFixture;
    @Fixture
    private List<AppUserDTO> appUserDTOListFixture;
    @Fixture
    private AppUserDTO appUserDTOFixture;
    @Fixture
    private AppUserViewModel appUserViewModelFixture;
    @Mock
    private JFixture jFixture;
    @Mock
    private MockMvc mockMvc;
    @Mock
    private AppUserService appUserServiceMock;
    @Mock
    private Mapper mapperMock;
    @BeforeEach
    public void setup() {


        jFixture = new JFixture();
        jFixture.customise()
                .circularDependencyBehaviour().omitSpecimen();



        FixtureAnnotations.initFixtures(this, jFixture);



        mockMvc = MockMvcBuilders.standaloneSetup(
                        new AppUserController(appUserServiceMock, mapperMock))
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((viewName, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    public void getAppUsers_ReturnsOk() throws Exception{
        when(mapperMock.map(appUserDTOListFixture, AppUserViewModel.class)).thenReturn(appUserViewModelListFixture);
        when(appUserServiceMock.getAllAppUsers()).thenReturn(appUserDTOListFixture);


        mockMvc.perform(get("/app-users/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getBoatByID_ReturnsOk() throws Exception{
        when(mapperMock.map(appUserDTOFixture, AppUserViewModel.class)).thenReturn(appUserViewModelFixture);
        when(appUserServiceMock.getAppUserByID(anyInt())).thenReturn(appUserDTOFixture);

        mockMvc.perform(get("/app-users/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
