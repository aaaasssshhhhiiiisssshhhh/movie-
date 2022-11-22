package logic;

//import com.example.GenreRequest;
import com.example.MovieDetail;
import com.example.MovieReply;
import com.example.MovieServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;


public class MovieLogic extends MovieServiceGrpc.MovieServiceImplBase {

    public MovieReply response ;

    public MovieLogic(String Genre){
        Map<String, MovieReply> genre =  new HashMap<>();

        genre.put("Action" , MovieReply.newBuilder()
                .addMovieDetails(MovieDetail.newBuilder().setName("ram").setDescription("sita"))
                        .addMovieDetails(MovieDetail.newBuilder().setName("ramdasd").setDescription("sitasdasd"))
                .build());

        genre.put("Comedy" , MovieReply.newBuilder()
                .addMovieDetails(MovieDetail.newBuilder().setName("hello").setDescription("rita")).build());

        genre.forEach((k,v) ->{
            if(k.equals(Genre)){
                response =v;
            }});

    }
}
