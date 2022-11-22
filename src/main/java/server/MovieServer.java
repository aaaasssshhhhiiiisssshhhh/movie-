package server;

import endpoint.MovieEndpoint;
import io.grpc.ServerBuilder;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.event.BeanCreatedEvent;
import io.micronaut.context.event.BeanCreatedEventListener;
import jakarta.inject.Inject;

@Factory

public class MovieServer <T extends ServerBuilder<T>> implements BeanCreatedEventListener<T> {
    private final MovieEndpoint movieEndpoint;
        @Inject
        MovieServer(MovieEndpoint movieEndpoint) {
        this.movieEndpoint = movieEndpoint;
    }

    @Override
    public T onCreated(BeanCreatedEvent<T> event) {
        return event.getBean().addService(movieEndpoint);
    }
}
