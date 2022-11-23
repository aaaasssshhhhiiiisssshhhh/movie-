package endpoint;

import com.example.GenreRequest;
import com.example.MovieReply;
import com.example.MovieServiceGrpc;
import io.grpc.stub.StreamObserver;
import logic.MovieLogic;
import jakarta.inject.Singleton;


@Singleton
public class MovieEndpoint extends MovieServiceGrpc.MovieServiceImplBase {
    @Override
    public void send(GenreRequest request, StreamObserver<MovieReply> responseObserver) {
        String Genre = request.getGenre();
        MovieLogic ml = new MovieLogic(Genre);


//        server stream
//        for (int i =0 ; i <5 ; i++){
//            responseObserver.onNext(ml.response);
//        }


        //unary req and res
        responseObserver.onNext(ml.response);


        responseObserver.onCompleted();
    }
}
