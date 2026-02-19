import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
  public class Homecontroller{
    @Getmapping("/health")
    public String health(){
      return "mhu"
        }
  }
