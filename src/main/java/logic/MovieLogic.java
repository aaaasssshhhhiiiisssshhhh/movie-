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
                .addMovieDetails(MovieDetail.newBuilder().setName("Mr bean").setDescription("movie about mister bean"))
                .addMovieDetails(MovieDetail.newBuilder().setName("The Jhosdasdsan").setDescription("Movie about tasdasdhe jhon's life "))
                .addMovieDetails(MovieDetail.newBuilder().setName("The Jsadasdasdhon").setDescription("Movie absadasdout the jhon's life "))
                .addMovieDetails(MovieDetail.newBuilder().setName("The asdas").setDescription("Movie aboutsdasdasd the jhon's life "))
                .addMovieDetails(MovieDetail.newBuilder().setName("The Jhsdasdasdon").setDescription("Movie abousadasdast the jhon's life "))
                .build());

        genre.put("Thriller" , MovieReply.newBuilder()
                .addMovieDetails(MovieDetail.newBuilder().setName("1012").setDescription("world will end"))
                .addMovieDetails(MovieDetail.newBuilder().setName("Tsdasdashe Jhasdasdon").setDescription("Movie abosadsdasdut the jhon's life "))
                .addMovieDetails(MovieDetail.newBuilder().setName("Tsadasdhe Jhon").setDescription("Movie about the jhosdasdn's life "))
                .addMovieDetails(MovieDetail.newBuilder().setName("sadasdhe Jhsdasdon").setDescription("Movie asadasdbout the jhon's life "))
                .addMovieDetails(MovieDetail.newBuilder().setName("Thsadasde Jhsadasdon").setDescription("Movie abosadasdut the jhon's life "))
                .addMovieDetails(MovieDetail.newBuilder().setName("Tsadashe Jhsdadon").setDescription("Movie absadasdout the jhon's life "))

                .build());

        genre.put("Horror" , MovieReply.newBuilder()
                .addMovieDetails(MovieDetail.newBuilder().setName("1947").setDescription("movie about ghost"))
                .addMovieDetails(MovieDetail.newBuilder().setName("The Jhosdasdasn").setDescription("Movie about the sadasdjhon's life "))
                .addMovieDetails(MovieDetail.newBuilder().setName("The Jhon").setDescription("Movie about the jhon's asdslife "))
                .addMovieDetails(MovieDetail.newBuilder().setName("The Jsdasdhon").setDescription("Moviesadasd about the jhon's life "))
                .addMovieDetails(MovieDetail.newBuilder().setName("The Jhonasda").setDescription("Movie about the jhon's life "))
                .build());

        genre.forEach((k,v) ->{
            if(k.equals(Genre)){
                response =v;
            }});

    }
}
