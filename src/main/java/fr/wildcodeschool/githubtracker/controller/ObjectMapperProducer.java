package fr.wildcodeschool.githubtracker.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

/**
 * Centralizes the creation of a custom ObjectMapper
 * get an instance via @Inject ObjectMapper objectMapper !
 */
@Singleton
class ObjectMapperProducer {

    // Only one in the application
    @Produces @Singleton
    public ObjectMapper produceObjectMapper() {
        ObjectMapper om = new ObjectMapper()

                //.registerModule(new ParameterNamesModule());

                //configure object mapper to ignore unknown properties in the constructor
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return om;
    }
}