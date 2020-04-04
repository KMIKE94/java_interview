package fiixsoftware;

import java.math.BigInteger;
import java.util.Optional;

public class Starter {

    public static void main(String argsp[]){
        Starter starter = new Starter();
        int[] arr = {3,4,5,3,7};

        System.out.println(starter.perfectTree(arr));

        Optional<String> s = Optional.ofNullable("");

    }

    /*
        Task 1:
            Mountain problem
                cannot have equal height
                must go up or down (opposite to previous
                how many ways can we cut out 1 element to make viable mountain given an array input?
                    [3,4,5,3,7] => 3 ways
                    [3,5,3,7]
                    [4,5,3,7]
                    [3,4,3,7]
                -1 means it can't be done
                0 means its already perfect
         */
    public int perfectTree(int[] arr) {

        // need a reference to the left and right elements
        // starting out we don't need to take into account the first
        boolean isPerfect = true;
        boolean isUp = false;
        for(int i=0;i<arr.length-1;i++) {
            int left = arr[i];
            int right = arr[i+1];

            // need to set the up or down boolean
            // on first entry
            if (i == 0) {
                if (left < right) {
                    isUp = true;
                } else {
                    isUp = false;
                }
            }

            // if equal then no
            if(left == right) {
                isPerfect = false;

                // go through the rest of the values and see
                // if it's up and down correctly
            } else if (left < right && !isUp) {
                isUp = true;
            } else if (left > right) {

            }
        }

        return -1;
    }
}

/*
package com.codility.tasks.hibernate.solution;

        import org.springframework.data.jpa.repository.*;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.http.MediaType;
        import org.springframework.transaction.annotation.*;
        import org.springframework.stereotype.Repository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;
        import java.util.Optional;

        import javax.persistence.*;

@Entity
class Task {
    private long id;
    private String description;
    private long priority;

    public long getId() {
        return id;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }
}

//@RequestMapping("/tasks")
//class TaskController {
//
//    TaskRepository repo;
//
//    @GetMapping("/{id}")
//    public Task updateTask(@PathVariable("id") long id, @RequestBody Task task) {
//        if(task == null || task.getDescription() == null) {
//            throw new RequiredFieldMissingException();
//        }
//
//        Optional<Task> optionalTask = repo.findById(id);
//        if(!optionalTask.isPresent()) {
//            throw new NotFoundException();
//        }
//
//        Task updateTask = optionalTask.get();
//        updateTask.setDescription(task.getDescription());
//        updateTask.setPriority(task.getPriority());
//
//        repo.save(updateTask);
//
//        return updateTask;
//    }
//
//    @ExceptionHandler({NotFoundException.class})
//    public ResponseEntity<ErrorResponse> handle404NotFound() {
//        return new ResponseEntity<>(new ErrorResponse("Cannot find task with given id", 404), HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler({RequiredFieldMissingException.class})
//    public ResponseEntity<ErrorResponse> handle400Required() {
//        return new ResponseEntity<>(new ErrorResponse("Task description is required", 400), HttpStatus.BAD_REQUEST);
//    }
//
//}
//
//class NotFoundException extends RuntimeException {
//}
//
//class RequiredFieldMissingException extends RuntimeException {
//}
//
//class ErrorResponse {
//    private String message;
//    private int httpStatus;
//
//    public ErrorResponse(String message, int httpStatus) {
//        this.message = message;
//        this.httpStatus = httpStatus;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public int getHttpStatus() {
//        return httpStatus;
//    }
//}
//
//@Repository
//interface TaskRepository extends JpaRepository<Task, Long> {
//    Optional<Task> findById(Long id);
//}

*/
