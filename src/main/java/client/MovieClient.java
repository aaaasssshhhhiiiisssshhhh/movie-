package client;

import com.example.GenreRequest;
import com.example.MovieReply;
import com.example.MovieServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;


public class MovieClient {
    public static void main(String[] args) {
        MovieClient movieClient = new MovieClient();
        movieClient.run();
    }

    private void run() {
        ManagedChannel channel = ManagedChannelBuilder.
                forAddress("localhost", 50052)
                .usePlaintext()
                .build();
        unaryCall(channel);
    }

    private void unaryCall(ManagedChannel channel) {

        MovieServiceGrpc.MovieServiceBlockingStub client =
                MovieServiceGrpc.newBlockingStub(channel);

        GenreRequest request = GenreRequest.newBuilder().setGenre("Horror").build();


        //unary
        MovieReply response = client.send(request);
        System.out.println(response);


        // server stream
//        Iterator <MovieReply> response = client.send(request);
//        while (response.hasNext()){
//            System.out.println(response.next());
//        }
    }

}