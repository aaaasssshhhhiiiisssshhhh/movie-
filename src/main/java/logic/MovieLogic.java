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
                .addMovieDetails(MovieDetail.newBuilder().setName("The rock").setDescription("Movie about the rock"))
                        .addMovieDetails(MovieDetail.newBuilder().setName("The Jhon").setDescription("Movie about the jhon's life "))
                .build());

        genre.put("Comedy" , MovieReply.newBuilder()
                .addMovieDetails(MovieDetail.newBuilder().setName("Mr bean").setDescription("movie about mister bean")).build());

        genre.put("Thriller" , MovieReply.newBuilder()
                .addMovieDetails(MovieDetail.newBuilder().setName("1012").setDescription("world will end")).build());

        genre.put("Horror" , MovieReply.newBuilder()
                .addMovieDetails(MovieDetail.newBuilder().setName("1947").setDescription("movie about ghost")).build());

        genre.forEach((k,v) ->{
            if(k.equals(Genre)){
                response =v;
            }});

    }
}
