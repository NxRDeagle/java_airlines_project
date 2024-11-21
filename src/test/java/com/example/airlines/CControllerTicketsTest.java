package com.example.airlines;

import com.example.airlines.model.CTickets;
import com.example.airlines.repositories.IRepositoryTickets;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CControllerTicketsTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IRepositoryTickets repositoryTickets;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        repositoryTickets.deleteAll();
    }

    @Test
    public void testGetAllTickets() throws Exception {
        CTickets ticket1 = new CTickets("Doe", "John", "Middle", LocalDate.of(1990, 1, 1), "+71234567890", "Company", "Airplane", "Airport1", "Airport2", LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        CTickets ticket2 = new CTickets("Smith", "Jane", "Middle", LocalDate.of(1995, 5, 5), "+79876543210", "Company", "Airplane", "Airport2", "Airport1", LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        repositoryTickets.save(ticket1);
        repositoryTickets.save(ticket2);

        mockMvc.perform(get("/tickets"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].lastName", is("Doe")))
                .andExpect(jsonPath("$[1].lastName", is("Smith")));
    }

    @Test
    public void testGetTicketById() throws Exception {
        CTickets ticket = new CTickets("Doe", "John", "Middle", LocalDate.of(1990, 1, 1), "+71234567890", "Company", "Airplane", "Airport1", "Airport2", LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        repositoryTickets.save(ticket);

        mockMvc.perform(get("/tickets/{id}", ticket.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.lastName", is("Doe")))
                .andExpect(jsonPath("$.firstName", is("John")));
    }

    @Test
    public void testCreateTicket() throws Exception {
        CTickets ticket = new CTickets("Doe", "John", "Middle", LocalDate.of(1990, 1, 1), "+71234567890", "Company", "Airplane", "Airport1", "Airport2", LocalDateTime.now(), LocalDateTime.now().plusHours(2));

        mockMvc.perform(post("/tickets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ticket)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.lastName", is("Doe")))
                .andExpect(jsonPath("$.firstName", is("John")));
    }

    @Test
    public void testUpdateTicket() throws Exception {
        CTickets ticket = new CTickets("Doe", "John", "Middle", LocalDate.of(1990, 1, 1), "+71234567890", "Company", "Airplane", "Airport1", "Airport2", LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        repositoryTickets.save(ticket);

        CTickets updatedTicket = new CTickets("Smith", "Jane", "Middle", LocalDate.of(1995, 5, 5), "+79876543210", "Company", "Airplane", "Airport2", "Airport1", LocalDateTime.now(), LocalDateTime.now().plusHours(2));

        mockMvc.perform(put("/tickets/{id}", ticket.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedTicket)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.lastName", is("Smith")))
                .andExpect(jsonPath("$.firstName", is("Jane")));
    }

    @Test
    public void testDeleteTicket() throws Exception {
        CTickets ticket = new CTickets("Doe", "John", "Middle", LocalDate.of(1990, 1, 1), "+71234567890", "Company", "Airplane", "Airport1", "Airport2", LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        repositoryTickets.save(ticket);

        mockMvc.perform(delete("/tickets/{id}", ticket.getId()))
                .andExpect(status().isOk());

        mockMvc.perform(get("/tickets"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));
    }
}