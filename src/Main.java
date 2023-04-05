import model.product.Product;
import model.userAccount.Buyer;
import javax.xml.stream.events.Comment;
import java.util.ArrayList;

public class Main {

    public ArrayList<Buyer> customers = new ArrayList<>();

    //---------------------------------------------------------

    public ArrayList<Product> products = new ArrayList<>();

    //-------------------------------------------------------

    public ArrayList<Comment> commentsAwaiting = new ArrayList<>();
    //public ArrayList<Comment> rejectedComments = new ArrayList<>();

    //-------------------------------------------------------

    public static void main(String[] args) {

        System.out.println("TEST");
    }
}
