package dev.srivatsan.spring_async.contoller;

import dev.srivatsan.spring_async.program.AsyncPrograms;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncCotntroller {

    private AsyncPrograms asyncPrograms;

    public AsyncCotntroller(AsyncPrograms asyncPrograms) {
        this.asyncPrograms = asyncPrograms;
    }

    private int i = 0;

    @GetMapping("/")
    public ResponseEntity<String> async() throws InterruptedException {
        ++i;
        asyncPrograms.printThreadName(i);
        return ResponseEntity.ok("task-" + String.valueOf(i));
    }
}
